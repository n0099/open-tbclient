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
    private EditorTools TA;
    private HListView feB;
    private ViewGroup.LayoutParams hQA;
    private GetEmotionPidModel hQB;
    private List<String> hQw;
    private b hQx;
    private QueryMatchEmotionModel hQy;
    private String hQz;
    private e mPageContext;
    private ViewGroup mParent;
    private Runnable hQC = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.hQz = "";
            c.this.feB.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.hQA = layoutParams;
    }

    public void setData(List<String> list) {
        this.hQw = list;
    }

    public void Bv(String str) {
        if (!TextUtils.isEmpty(str) && !v.aa(this.hQw) && this.hQw.contains(str)) {
            Bw(str);
        }
    }

    private void Bw(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.hQz)) {
            this.hQz = str;
            if (this.hQy == null) {
                this.hQy = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.hQy.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.hQz)) {
            if (v.aa(list)) {
                this.hQz = "";
            } else if (this.mParent != null && this.hQA != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.feB == null || this.feB.getParent() == null) {
                    this.feB = new HListView(this.mPageContext.getContext());
                    al.l(this.feB, R.color.cp_bg_line_d);
                    this.feB.setDividerWidth(l.g(this.mPageContext.getPageActivity(), R.dimen.ds7));
                    this.feB.setClipToPadding(false);
                    int g = l.g(this.mPageContext.getPageActivity(), R.dimen.ds10);
                    this.feB.setPadding(g, g, g, g);
                    this.feB.setSelector(R.drawable.list_selector_transparent);
                    this.hQA.height = l.g(this.mPageContext.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.feB, this.hQA);
                    if (this.hQx == null) {
                        this.hQx = new b();
                        this.hQx.a((b.a) this);
                        this.hQx.a((EmotionView.a) this);
                        this.feB.setAdapter((ListAdapter) this.hQx);
                        this.feB.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.hQC);
                                        c.this.mHandler.postDelayed(c.this.hQC, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.hQC);
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
                this.feB.setVisibility(0);
                this.hQx.setData(list);
                this.hQx.notifyDataSetChanged();
                this.feB.setSelection(0);
                this.mHandler.removeCallbacks(this.hQC);
                this.mHandler.postDelayed(this.hQC, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void aGN() {
        if (this.feB != null) {
            this.feB.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.hQC);
        this.hQz = "";
    }

    public void bmr() {
        if (this.hQy != null) {
            this.hQy.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.hQC);
        this.mHandler.postDelayed(this.hQC, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.TA != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.hQB == null) {
                    this.hQB = new GetEmotionPidModel();
                }
                this.hQB.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        pVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.bm("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        pVar.a(EmotionGroupType.NET_SUG);
        pVar.setWidth(emotionImageData.getWidth());
        pVar.setHeight(emotionImageData.getHeight());
        pVar.setUrl(emotionImageData.getPicUrl());
        this.TA.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
    }

    public void b(EditorTools editorTools) {
        this.TA = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bfg() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bfj() {
        this.mHandler.removeCallbacks(this.hQC);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bfk() {
        this.mHandler.removeCallbacks(this.hQC);
        this.mHandler.postDelayed(this.hQC, 5000L);
    }
}
