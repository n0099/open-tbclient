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
    private HListView eOr;
    private List<String> hyH;
    private b hyI;
    private QueryMatchEmotionModel hyJ;
    private String hyK;
    private ViewGroup.LayoutParams hyL;
    private GetEmotionPidModel hyM;
    private Runnable hyN = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.hyK = "";
            c.this.eOr.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.hyL = layoutParams;
    }

    public void setData(List<String> list) {
        this.hyH = list;
    }

    public void Ad(String str) {
        if (!TextUtils.isEmpty(str) && !v.T(this.hyH) && this.hyH.contains(str)) {
            Ae(str);
        }
    }

    private void Ae(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.hyK)) {
            this.hyK = str;
            if (this.hyJ == null) {
                this.hyJ = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.hyJ.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void p(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.hyK)) {
            if (v.T(list)) {
                this.hyK = "";
            } else if (this.mParent != null && this.hyL != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.eOr == null || this.eOr.getParent() == null) {
                    this.eOr = new HListView(this.mPageContext.getContext());
                    al.l(this.eOr, d.C0277d.cp_bg_line_d);
                    this.eOr.setDividerWidth(l.h(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.eOr.setClipToPadding(false);
                    int h = l.h(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.eOr.setPadding(h, h, h, h);
                    this.eOr.setSelector(d.f.list_selector_transparent);
                    this.hyL.height = l.h(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.mParent.addView(this.eOr, this.hyL);
                    if (this.hyI == null) {
                        this.hyI = new b();
                        this.hyI.a((b.a) this);
                        this.hyI.a((EmotionView.a) this);
                        this.eOr.setAdapter((ListAdapter) this.hyI);
                        this.eOr.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.hyN);
                                        c.this.mHandler.postDelayed(c.this.hyN, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.hyN);
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
                this.eOr.setVisibility(0);
                this.hyI.setData(list);
                this.hyI.notifyDataSetChanged();
                this.eOr.setSelection(0);
                this.mHandler.removeCallbacks(this.hyN);
                this.mHandler.postDelayed(this.hyN, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void aAy() {
        if (this.eOr != null) {
            this.eOr.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.hyN);
        this.hyK = "";
    }

    public void beW() {
        if (this.hyJ != null) {
            this.hyJ.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.hyN);
        this.mHandler.postDelayed(this.hyN, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.VN != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.hyM == null) {
                    this.hyM = new GetEmotionPidModel();
                }
                this.hyM.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
    public boolean aXJ() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aXM() {
        this.mHandler.removeCallbacks(this.hyN);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aXN() {
        this.mHandler.removeCallbacks(this.hyN);
        this.mHandler.postDelayed(this.hyN, 5000L);
    }
}
