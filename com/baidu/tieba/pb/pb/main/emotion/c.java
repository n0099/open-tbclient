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
    private EditorTools TU;
    private HListView fkd;
    private List<String> hXF;
    private b hXG;
    private QueryMatchEmotionModel hXH;
    private String hXI;
    private ViewGroup.LayoutParams hXJ;
    private GetEmotionPidModel hXK;
    private Runnable hXL = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.hXI = "";
            c.this.fkd.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.hXJ = layoutParams;
    }

    public void setData(List<String> list) {
        this.hXF = list;
    }

    public void Ci(String str) {
        if (!TextUtils.isEmpty(str) && !v.aa(this.hXF) && this.hXF.contains(str)) {
            Cj(str);
        }
    }

    private void Cj(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.hXI)) {
            this.hXI = str;
            if (this.hXH == null) {
                this.hXH = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.hXH.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.hXI)) {
            if (v.aa(list)) {
                this.hXI = "";
            } else if (this.mParent != null && this.hXJ != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.fkd == null || this.fkd.getParent() == null) {
                    this.fkd = new HListView(this.mPageContext.getContext());
                    am.l(this.fkd, R.color.cp_bg_line_d);
                    this.fkd.setDividerWidth(l.g(this.mPageContext.getPageActivity(), R.dimen.ds7));
                    this.fkd.setClipToPadding(false);
                    int g = l.g(this.mPageContext.getPageActivity(), R.dimen.ds10);
                    this.fkd.setPadding(g, g, g, g);
                    this.fkd.setSelector(R.drawable.list_selector_transparent);
                    this.hXJ.height = l.g(this.mPageContext.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.fkd, this.hXJ);
                    if (this.hXG == null) {
                        this.hXG = new b();
                        this.hXG.a((b.a) this);
                        this.hXG.a((EmotionView.a) this);
                        this.fkd.setAdapter((ListAdapter) this.hXG);
                        this.fkd.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.hXL);
                                        c.this.mHandler.postDelayed(c.this.hXL, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.hXL);
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
                this.fkd.setVisibility(0);
                this.hXG.setData(list);
                this.hXG.notifyDataSetChanged();
                this.fkd.setSelection(0);
                this.mHandler.removeCallbacks(this.hXL);
                this.mHandler.postDelayed(this.hXL, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void aIm() {
        if (this.fkd != null) {
            this.fkd.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.hXL);
        this.hXI = "";
    }

    public void boF() {
        if (this.hXH != null) {
            this.hXH.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.hXL);
        this.mHandler.postDelayed(this.hXL, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.TU != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.hXK == null) {
                    this.hXK = new GetEmotionPidModel();
                }
                this.hXK.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.TU.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
    }

    public void b(EditorTools editorTools) {
        this.TU = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bhq() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bht() {
        this.mHandler.removeCallbacks(this.hXL);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bhu() {
        this.mHandler.removeCallbacks(this.hXL);
        this.mHandler.postDelayed(this.hXL, 5000L);
    }
}
