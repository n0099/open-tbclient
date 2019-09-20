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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.R;
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
    private EditorTools TT;
    private HListView flQ;
    private List<String> hZC;
    private b hZD;
    private QueryMatchEmotionModel hZE;
    private String hZF;
    private ViewGroup.LayoutParams hZG;
    private GetEmotionPidModel hZH;
    private Runnable hZI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.hZF = "";
            c.this.flQ.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.hZG = layoutParams;
    }

    public void setData(List<String> list) {
        this.hZC = list;
    }

    public void CH(String str) {
        if (!TextUtils.isEmpty(str) && !v.aa(this.hZC) && this.hZC.contains(str)) {
            CI(str);
        }
    }

    private void CI(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.hZF)) {
            this.hZF = str;
            if (this.hZE == null) {
                this.hZE = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.hZE.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.hZF)) {
            if (v.aa(list)) {
                this.hZF = "";
            } else if (this.mParent != null && this.hZG != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.flQ == null || this.flQ.getParent() == null) {
                    this.flQ = new HListView(this.mPageContext.getContext());
                    am.l(this.flQ, R.color.cp_bg_line_d);
                    this.flQ.setDividerWidth(l.g(this.mPageContext.getPageActivity(), R.dimen.ds7));
                    this.flQ.setClipToPadding(false);
                    int g = l.g(this.mPageContext.getPageActivity(), R.dimen.ds10);
                    this.flQ.setPadding(g, g, g, g);
                    this.flQ.setSelector(R.drawable.list_selector_transparent);
                    this.hZG.height = l.g(this.mPageContext.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.flQ, this.hZG);
                    if (this.hZD == null) {
                        this.hZD = new b();
                        this.hZD.a((b.a) this);
                        this.hZD.a((EmotionView.a) this);
                        this.flQ.setAdapter((ListAdapter) this.hZD);
                        this.flQ.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.hZI);
                                        c.this.mHandler.postDelayed(c.this.hZI, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.hZI);
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
                this.flQ.setVisibility(0);
                this.hZD.setData(list);
                this.hZD.notifyDataSetChanged();
                this.flQ.setSelection(0);
                this.mHandler.removeCallbacks(this.hZI);
                this.mHandler.postDelayed(this.hZI, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void aIQ() {
        if (this.flQ != null) {
            this.flQ.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.hZI);
        this.hZF = "";
    }

    public void bpq() {
        if (this.hZE != null) {
            this.hZE.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.hZI);
        this.mHandler.postDelayed(this.hZI, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.TT != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.hZH == null) {
                    this.hZH = new GetEmotionPidModel();
                }
                this.hZH.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        pVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.bn("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        pVar.a(EmotionGroupType.NET_SUG);
        pVar.setWidth(emotionImageData.getWidth());
        pVar.setHeight(emotionImageData.getHeight());
        pVar.setUrl(emotionImageData.getPicUrl());
        this.TT.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
    }

    public void b(EditorTools editorTools) {
        this.TT = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bib() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bie() {
        this.mHandler.removeCallbacks(this.hZI);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bif() {
        this.mHandler.removeCallbacks(this.hZI);
        this.mHandler.postDelayed(this.hZI, 5000L);
    }
}
