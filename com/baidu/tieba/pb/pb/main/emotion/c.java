package com.baidu.tieba.pb.pb.main.emotion;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
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
/* loaded from: classes4.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools VO;
    private HListView eOs;
    private List<String> hyI;
    private b hyJ;
    private QueryMatchEmotionModel hyK;
    private String hyL;
    private ViewGroup.LayoutParams hyM;
    private GetEmotionPidModel hyN;
    private Runnable hyO = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.hyL = "";
            c.this.eOs.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.hyM = layoutParams;
    }

    public void setData(List<String> list) {
        this.hyI = list;
    }

    public void Ad(String str) {
        if (!TextUtils.isEmpty(str) && !v.T(this.hyI) && this.hyI.contains(str)) {
            Ae(str);
        }
    }

    private void Ae(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.hyL)) {
            this.hyL = str;
            if (this.hyK == null) {
                this.hyK = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.hyK.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void p(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.hyL)) {
            if (v.T(list)) {
                this.hyL = "";
            } else if (this.mParent != null && this.hyM != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.eOs == null || this.eOs.getParent() == null) {
                    this.eOs = new HListView(this.mPageContext.getContext());
                    al.l(this.eOs, d.C0277d.cp_bg_line_d);
                    this.eOs.setDividerWidth(l.h(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.eOs.setClipToPadding(false);
                    int h = l.h(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.eOs.setPadding(h, h, h, h);
                    this.eOs.setSelector(d.f.list_selector_transparent);
                    this.hyM.height = l.h(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.mParent.addView(this.eOs, this.hyM);
                    if (this.hyJ == null) {
                        this.hyJ = new b();
                        this.hyJ.a((b.a) this);
                        this.hyJ.a((EmotionView.a) this);
                        this.eOs.setAdapter((ListAdapter) this.hyJ);
                        this.eOs.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.hyO);
                                        c.this.mHandler.postDelayed(c.this.hyO, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.hyO);
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
                this.eOs.setVisibility(0);
                this.hyJ.setData(list);
                this.hyJ.notifyDataSetChanged();
                this.eOs.setSelection(0);
                this.mHandler.removeCallbacks(this.hyO);
                this.mHandler.postDelayed(this.hyO, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void aAy() {
        if (this.eOs != null) {
            this.eOs.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.hyO);
        this.hyL = "";
    }

    public void beW() {
        if (this.hyK != null) {
            this.hyK.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.hyO);
        this.mHandler.postDelayed(this.hyO, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.VO != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.hyN == null) {
                    this.hyN = new GetEmotionPidModel();
                }
                this.hyN.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        p pVar = new p();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        pVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.bC("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        pVar.a(EmotionGroupType.NET_SUG);
        pVar.setWidth(emotionImageData.getWidth());
        pVar.setHeight(emotionImageData.getHeight());
        pVar.setUrl(emotionImageData.getPicUrl());
        this.VO.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
    }

    public void b(EditorTools editorTools) {
        this.VO = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean aXJ() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aXM() {
        this.mHandler.removeCallbacks(this.hyO);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aXN() {
        this.mHandler.removeCallbacks(this.hyO);
        this.mHandler.postDelayed(this.hyO, 5000L);
    }
}
