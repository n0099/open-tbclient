package com.baidu.tieba.pb.pb.main.emotion;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.pb.pb.main.emotion.b;
import com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private i JG;
    private ViewGroup bqn;
    private HListView clS;
    private List<String> eMp;
    private b eMq;
    private QueryMatchEmotionModel eMr;
    private String eMs;
    private ViewGroup.LayoutParams eMt;
    private GetEmotionPidModel eMu;
    private Runnable eMv = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.eMs = "";
            c.this.clS.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.bqn = viewGroup;
        this.eMt = layoutParams;
    }

    public void setData(List<String> list) {
        this.eMp = list;
    }

    public void pe(String str) {
        if (!TextUtils.isEmpty(str) && !v.u(this.eMp) && this.eMp.contains(str)) {
            pf(str);
        }
    }

    private void pf(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.eMs)) {
            this.eMs = str;
            if (this.eMr == null) {
                this.eMr = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.eMr.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void m(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.eMs)) {
            if (v.u(list)) {
                this.eMs = "";
            } else if (this.bqn != null && this.eMt != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.clS == null || this.clS.getParent() == null) {
                    this.clS = new HListView(this.mPageContext.getContext());
                    aj.k(this.clS, d.e.cp_bg_line_d);
                    this.clS.setDividerWidth(l.f(this.mPageContext.getPageActivity(), d.f.ds7));
                    this.clS.setClipToPadding(false);
                    int f = l.f(this.mPageContext.getPageActivity(), d.f.ds10);
                    this.clS.setPadding(f, f, f, f);
                    this.clS.setSelector(d.g.list_selector_transparent);
                    this.eMt.height = l.f(this.mPageContext.getPageActivity(), d.f.ds136);
                    this.bqn.addView(this.clS, this.eMt);
                    if (this.eMq == null) {
                        this.eMq = new b();
                        this.eMq.a((b.a) this);
                        this.eMq.a((EmotionView.a) this);
                        this.clS.setAdapter((ListAdapter) this.eMq);
                        this.clS.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.eMv);
                                        c.this.mHandler.postDelayed(c.this.eMv, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.eMv);
                                        return;
                                    default:
                                        return;
                                }
                            }

                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                            }
                        });
                    }
                }
                this.clS.setVisibility(0);
                this.eMq.setData(list);
                this.eMq.notifyDataSetChanged();
                this.clS.setSelection(0);
                this.mHandler.removeCallbacks(this.eMv);
                this.mHandler.postDelayed(this.eMv, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void adq() {
        if (this.clS != null) {
            this.clS.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.eMv);
        this.eMs = "";
    }

    public void aiD() {
        if (this.eMr != null) {
            this.eMr.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.eMv);
        this.mHandler.postDelayed(this.eMv, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.JG != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.eMu == null) {
                    this.eMu = new GetEmotionPidModel();
                }
                this.eMu.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
                    @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                    public void a(com.baidu.tbadk.img.c cVar) {
                        if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                            emotionImageData.setPicId(cVar.picId);
                            c.this.e(emotionImageData);
                        }
                    }

                    @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                    public void onFail(int i, String str) {
                    }
                });
                return;
            }
            e(emotionImageData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(EmotionImageData emotionImageData) {
        TiebaStatic.log("c12489");
        com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        lVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.aS("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        lVar.a(EmotionGroupType.NET_SUG);
        lVar.setWidth(emotionImageData.getWidth());
        lVar.setHeight(emotionImageData.getHeight());
        lVar.setUrl(emotionImageData.getPicUrl());
        this.JG.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
    }

    public void b(i iVar) {
        this.JG = iVar;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean adF() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean adG() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void adJ() {
        this.mHandler.removeCallbacks(this.eMv);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void adK() {
        this.mHandler.removeCallbacks(this.eMv);
        this.mHandler.postDelayed(this.eMv, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
