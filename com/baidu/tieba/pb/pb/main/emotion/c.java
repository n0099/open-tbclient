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
    private i axP;
    private ViewGroup crh;
    private HListView dyK;
    private List<String> fWQ;
    private b fWR;
    private QueryMatchEmotionModel fWS;
    private String fWT;
    private ViewGroup.LayoutParams fWU;
    private GetEmotionPidModel fWV;
    private Runnable fWW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.fWT = "";
            c.this.dyK.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.crh = viewGroup;
        this.fWU = layoutParams;
    }

    public void setData(List<String> list) {
        this.fWQ = list;
    }

    public void qD(String str) {
        if (!TextUtils.isEmpty(str) && !v.E(this.fWQ) && this.fWQ.contains(str)) {
            qE(str);
        }
    }

    private void qE(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.fWT)) {
            this.fWT = str;
            if (this.fWS == null) {
                this.fWS = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.fWS.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void m(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.fWT)) {
            if (v.E(list)) {
                this.fWT = "";
            } else if (this.crh != null && this.fWU != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.dyK == null || this.dyK.getParent() == null) {
                    this.dyK = new HListView(this.mPageContext.getContext());
                    aj.t(this.dyK, d.C0140d.cp_bg_line_d);
                    this.dyK.setDividerWidth(l.t(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.dyK.setClipToPadding(false);
                    int t = l.t(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.dyK.setPadding(t, t, t, t);
                    this.dyK.setSelector(d.f.list_selector_transparent);
                    this.fWU.height = l.t(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.crh.addView(this.dyK, this.fWU);
                    if (this.fWR == null) {
                        this.fWR = new b();
                        this.fWR.a((b.a) this);
                        this.fWR.a((EmotionView.a) this);
                        this.dyK.setAdapter((ListAdapter) this.fWR);
                        this.dyK.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.fWW);
                                        c.this.mHandler.postDelayed(c.this.fWW, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.fWW);
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
                this.dyK.setVisibility(0);
                this.fWR.setData(list);
                this.fWR.notifyDataSetChanged();
                this.dyK.setSelection(0);
                this.mHandler.removeCallbacks(this.fWW);
                this.mHandler.postDelayed(this.fWW, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void Wk() {
        if (this.dyK != null) {
            this.dyK.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.fWW);
        this.fWT = "";
    }

    public void awP() {
        if (this.fWS != null) {
            this.fWS.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.fWW);
        this.mHandler.postDelayed(this.fWW, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.axP != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.fWV == null) {
                    this.fWV = new GetEmotionPidModel();
                }
                this.fWV.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.axP.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
    }

    public void b(i iVar) {
        this.axP = iVar;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean arm() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void arp() {
        this.mHandler.removeCallbacks(this.fWW);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void arq() {
        this.mHandler.removeCallbacks(this.fWW);
        this.mHandler.postDelayed(this.fWW, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
