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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
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
/* loaded from: classes22.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools abj;
    private e eul;
    private ViewGroup.LayoutParams gHd;
    private HListView ihN;
    private List<String> lmp;
    private b lmq;
    private QueryMatchEmotionModel lmr;
    private String lms;
    private GetEmotionPidModel lmt;
    private Runnable lmu = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.lms = "";
            c.this.ihN.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.eul = eVar;
        this.mParent = viewGroup;
        this.gHd = layoutParams;
    }

    public void setData(List<String> list) {
        this.lmp = list;
    }

    public void Pg(String str) {
        if (!TextUtils.isEmpty(str) && !y.isEmpty(this.lmp) && this.lmp.contains(str)) {
            Ph(str);
        }
    }

    private void Ph(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.lms)) {
            this.lms = str;
            if (this.lmr == null) {
                this.lmr = new QueryMatchEmotionModel(this.eul);
            }
            this.lmr.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.lms)) {
            if (y.isEmpty(list)) {
                this.lms = "";
            } else if (this.mParent != null && this.gHd != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.ihN == null || this.ihN.getParent() == null) {
                    this.ihN = new HListView(this.eul.getContext());
                    ap.setBackgroundColor(this.ihN, R.color.cp_bg_line_d);
                    this.ihN.setDividerWidth(l.getDimens(this.eul.getPageActivity(), R.dimen.ds7));
                    this.ihN.setClipToPadding(false);
                    int dimens = l.getDimens(this.eul.getPageActivity(), R.dimen.ds10);
                    this.ihN.setPadding(dimens, dimens, dimens, dimens);
                    this.ihN.setSelector(R.drawable.list_selector_transparent);
                    this.gHd.height = l.getDimens(this.eul.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.ihN, this.gHd);
                    if (this.lmq == null) {
                        this.lmq = new b();
                        this.lmq.a((b.a) this);
                        this.lmq.a((EmotionView.a) this);
                        this.ihN.setAdapter((ListAdapter) this.lmq);
                        this.ihN.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.lmu);
                                        c.this.mHandler.postDelayed(c.this.lmu, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.lmu);
                                        return;
                                    default:
                                        return;
                                }
                            }

                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                            }
                        });
                    }
                }
                this.ihN.setVisibility(0);
                this.lmq.setData(list);
                this.lmq.notifyDataSetChanged();
                this.ihN.setSelection(0);
                this.mHandler.removeCallbacks(this.lmu);
                this.mHandler.postDelayed(this.lmu, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void djj() {
        if (this.ihN != null) {
            this.ihN.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.lmu);
        this.lms = "";
    }

    public void cvF() {
        if (this.lmr != null) {
            this.lmr.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.lmu);
        this.mHandler.postDelayed(this.lmu, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.abj != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.lmt == null) {
                    this.lmt = new GetEmotionPidModel();
                }
                this.lmt.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        u uVar = new u();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        uVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.toMd5("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        uVar.a(EmotionGroupType.NET_SUG);
        uVar.setWidth(emotionImageData.getWidth());
        uVar.setHeight(emotionImageData.getHeight());
        uVar.setUrl(emotionImageData.getPicUrl());
        this.abj.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
    }

    public void c(EditorTools editorTools) {
        this.abj = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cou() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cox() {
        this.mHandler.removeCallbacks(this.lmu);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void coy() {
        this.mHandler.removeCallbacks(this.lmu);
        this.mHandler.postDelayed(this.lmu, 5000L);
    }
}
