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
    private EditorTools VN;
    private HListView eOF;
    private List<String> hyV;
    private b hyW;
    private QueryMatchEmotionModel hyX;
    private String hyY;
    private ViewGroup.LayoutParams hyZ;
    private GetEmotionPidModel hza;
    private Runnable hzb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.hyY = "";
            c.this.eOF.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.hyZ = layoutParams;
    }

    public void setData(List<String> list) {
        this.hyV = list;
    }

    public void Ae(String str) {
        if (!TextUtils.isEmpty(str) && !v.T(this.hyV) && this.hyV.contains(str)) {
            Af(str);
        }
    }

    private void Af(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.hyY)) {
            this.hyY = str;
            if (this.hyX == null) {
                this.hyX = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.hyX.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void p(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.hyY)) {
            if (v.T(list)) {
                this.hyY = "";
            } else if (this.mParent != null && this.hyZ != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.eOF == null || this.eOF.getParent() == null) {
                    this.eOF = new HListView(this.mPageContext.getContext());
                    al.l(this.eOF, d.C0277d.cp_bg_line_d);
                    this.eOF.setDividerWidth(l.h(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.eOF.setClipToPadding(false);
                    int h = l.h(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.eOF.setPadding(h, h, h, h);
                    this.eOF.setSelector(d.f.list_selector_transparent);
                    this.hyZ.height = l.h(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.mParent.addView(this.eOF, this.hyZ);
                    if (this.hyW == null) {
                        this.hyW = new b();
                        this.hyW.a((b.a) this);
                        this.hyW.a((EmotionView.a) this);
                        this.eOF.setAdapter((ListAdapter) this.hyW);
                        this.eOF.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.hzb);
                                        c.this.mHandler.postDelayed(c.this.hzb, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.hzb);
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
                this.eOF.setVisibility(0);
                this.hyW.setData(list);
                this.hyW.notifyDataSetChanged();
                this.eOF.setSelection(0);
                this.mHandler.removeCallbacks(this.hzb);
                this.mHandler.postDelayed(this.hzb, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void aAB() {
        if (this.eOF != null) {
            this.eOF.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.hzb);
        this.hyY = "";
    }

    public void beY() {
        if (this.hyX != null) {
            this.hyX.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.hzb);
        this.mHandler.postDelayed(this.hzb, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.VN != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.hza == null) {
                    this.hza = new GetEmotionPidModel();
                }
                this.hza.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.VN.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
    }

    public void b(EditorTools editorTools) {
        this.VN = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean aXM() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aXP() {
        this.mHandler.removeCallbacks(this.hzb);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aXQ() {
        this.mHandler.removeCallbacks(this.hzb);
        this.mHandler.postDelayed(this.hzb, 5000L);
    }
}
