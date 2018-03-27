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
    private i axH;
    private ViewGroup cqX;
    private HListView dyB;
    private List<String> fWV;
    private b fWW;
    private QueryMatchEmotionModel fWX;
    private String fWY;
    private ViewGroup.LayoutParams fWZ;
    private GetEmotionPidModel fXa;
    private Runnable fXb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.fWY = "";
            c.this.dyB.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.cqX = viewGroup;
        this.fWZ = layoutParams;
    }

    public void setData(List<String> list) {
        this.fWV = list;
    }

    public void qD(String str) {
        if (!TextUtils.isEmpty(str) && !v.E(this.fWV) && this.fWV.contains(str)) {
            qE(str);
        }
    }

    private void qE(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.fWY)) {
            this.fWY = str;
            if (this.fWX == null) {
                this.fWX = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.fWX.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void m(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.fWY)) {
            if (v.E(list)) {
                this.fWY = "";
            } else if (this.cqX != null && this.fWZ != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.dyB == null || this.dyB.getParent() == null) {
                    this.dyB = new HListView(this.mPageContext.getContext());
                    aj.t(this.dyB, d.C0141d.cp_bg_line_d);
                    this.dyB.setDividerWidth(l.t(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.dyB.setClipToPadding(false);
                    int t = l.t(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.dyB.setPadding(t, t, t, t);
                    this.dyB.setSelector(d.f.list_selector_transparent);
                    this.fWZ.height = l.t(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.cqX.addView(this.dyB, this.fWZ);
                    if (this.fWW == null) {
                        this.fWW = new b();
                        this.fWW.a((b.a) this);
                        this.fWW.a((EmotionView.a) this);
                        this.dyB.setAdapter((ListAdapter) this.fWW);
                        this.dyB.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.fXb);
                                        c.this.mHandler.postDelayed(c.this.fXb, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.fXb);
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
                this.dyB.setVisibility(0);
                this.fWW.setData(list);
                this.fWW.notifyDataSetChanged();
                this.dyB.setSelection(0);
                this.mHandler.removeCallbacks(this.fXb);
                this.mHandler.postDelayed(this.fXb, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void Wk() {
        if (this.dyB != null) {
            this.dyB.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.fXb);
        this.fWY = "";
    }

    public void awQ() {
        if (this.fWX != null) {
            this.fWX.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.fXb);
        this.mHandler.postDelayed(this.fXb, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.axH != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.fXa == null) {
                    this.fXa = new GetEmotionPidModel();
                }
                this.fXa.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.axH.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
    }

    public void b(i iVar) {
        this.axH = iVar;
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
        this.mHandler.removeCallbacks(this.fXb);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void arq() {
        this.mHandler.removeCallbacks(this.fXb);
        this.mHandler.postDelayed(this.fXb, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
