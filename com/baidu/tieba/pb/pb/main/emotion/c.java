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
    private i JH;
    private ViewGroup bqb;
    private HListView clF;
    private List<String> eMb;
    private b eMc;
    private QueryMatchEmotionModel eMd;
    private String eMe;
    private ViewGroup.LayoutParams eMf;
    private GetEmotionPidModel eMg;
    private Runnable eMh = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.eMe = "";
            c.this.clF.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.bqb = viewGroup;
        this.eMf = layoutParams;
    }

    public void setData(List<String> list) {
        this.eMb = list;
    }

    public void pd(String str) {
        if (!TextUtils.isEmpty(str) && !v.u(this.eMb) && this.eMb.contains(str)) {
            pe(str);
        }
    }

    private void pe(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.eMe)) {
            this.eMe = str;
            if (this.eMd == null) {
                this.eMd = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.eMd.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void m(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.eMe)) {
            if (v.u(list)) {
                this.eMe = "";
            } else if (this.bqb != null && this.eMf != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.clF == null || this.clF.getParent() == null) {
                    this.clF = new HListView(this.mPageContext.getContext());
                    aj.k(this.clF, d.e.cp_bg_line_d);
                    this.clF.setDividerWidth(l.f(this.mPageContext.getPageActivity(), d.f.ds7));
                    this.clF.setClipToPadding(false);
                    int f = l.f(this.mPageContext.getPageActivity(), d.f.ds10);
                    this.clF.setPadding(f, f, f, f);
                    this.clF.setSelector(d.g.list_selector_transparent);
                    this.eMf.height = l.f(this.mPageContext.getPageActivity(), d.f.ds136);
                    this.bqb.addView(this.clF, this.eMf);
                    if (this.eMc == null) {
                        this.eMc = new b();
                        this.eMc.a((b.a) this);
                        this.eMc.a((EmotionView.a) this);
                        this.clF.setAdapter((ListAdapter) this.eMc);
                        this.clF.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.eMh);
                                        c.this.mHandler.postDelayed(c.this.eMh, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.eMh);
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
                this.clF.setVisibility(0);
                this.eMc.setData(list);
                this.eMc.notifyDataSetChanged();
                this.clF.setSelection(0);
                this.mHandler.removeCallbacks(this.eMh);
                this.mHandler.postDelayed(this.eMh, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void adm() {
        if (this.clF != null) {
            this.clF.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.eMh);
        this.eMe = "";
    }

    public void aiy() {
        if (this.eMd != null) {
            this.eMd.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.eMh);
        this.mHandler.postDelayed(this.eMh, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.JH != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.eMg == null) {
                    this.eMg = new GetEmotionPidModel();
                }
                this.eMg.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.JH.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
    }

    public void b(i iVar) {
        this.JH = iVar;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean adB() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void adE() {
        this.mHandler.removeCallbacks(this.eMh);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void adF() {
        this.mHandler.removeCallbacks(this.eMh);
        this.mHandler.postDelayed(this.eMh, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
