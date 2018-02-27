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
import com.baidu.tbadk.coreExtra.data.n;
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
/* loaded from: classes2.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private i axG;
    private ViewGroup cqU;
    private HListView dyy;
    private List<String> fWF;
    private b fWG;
    private QueryMatchEmotionModel fWH;
    private String fWI;
    private ViewGroup.LayoutParams fWJ;
    private GetEmotionPidModel fWK;
    private Runnable fWL = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.fWI = "";
            c.this.dyy.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.cqU = viewGroup;
        this.fWJ = layoutParams;
    }

    public void setData(List<String> list) {
        this.fWF = list;
    }

    public void qD(String str) {
        if (!TextUtils.isEmpty(str) && !v.E(this.fWF) && this.fWF.contains(str)) {
            qE(str);
        }
    }

    private void qE(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.fWI)) {
            this.fWI = str;
            if (this.fWH == null) {
                this.fWH = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.fWH.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void m(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.fWI)) {
            if (v.E(list)) {
                this.fWI = "";
            } else if (this.cqU != null && this.fWJ != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.dyy == null || this.dyy.getParent() == null) {
                    this.dyy = new HListView(this.mPageContext.getContext());
                    aj.t(this.dyy, d.C0141d.cp_bg_line_d);
                    this.dyy.setDividerWidth(l.t(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.dyy.setClipToPadding(false);
                    int t = l.t(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.dyy.setPadding(t, t, t, t);
                    this.dyy.setSelector(d.f.list_selector_transparent);
                    this.fWJ.height = l.t(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.cqU.addView(this.dyy, this.fWJ);
                    if (this.fWG == null) {
                        this.fWG = new b();
                        this.fWG.a((b.a) this);
                        this.fWG.a((EmotionView.a) this);
                        this.dyy.setAdapter((ListAdapter) this.fWG);
                        this.dyy.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.fWL);
                                        c.this.mHandler.postDelayed(c.this.fWL, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.fWL);
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
                this.dyy.setVisibility(0);
                this.fWG.setData(list);
                this.fWG.notifyDataSetChanged();
                this.dyy.setSelection(0);
                this.mHandler.removeCallbacks(this.fWL);
                this.mHandler.postDelayed(this.fWL, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void Wj() {
        if (this.dyy != null) {
            this.dyy.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.fWL);
        this.fWI = "";
    }

    public void awO() {
        if (this.fWH != null) {
            this.fWH.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.fWL);
        this.mHandler.postDelayed(this.fWL, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.axG != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.fWK == null) {
                    this.fWK = new GetEmotionPidModel();
                }
                this.fWK.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        n nVar = new n();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        nVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.ba("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        nVar.a(EmotionGroupType.NET_SUG);
        nVar.setWidth(emotionImageData.getWidth());
        nVar.setHeight(emotionImageData.getHeight());
        nVar.setUrl(emotionImageData.getPicUrl());
        this.axG.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
    }

    public void b(i iVar) {
        this.axG = iVar;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean arl() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aro() {
        this.mHandler.removeCallbacks(this.fWL);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void arp() {
        this.mHandler.removeCallbacks(this.fWL);
        this.mHandler.postDelayed(this.fWL, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
