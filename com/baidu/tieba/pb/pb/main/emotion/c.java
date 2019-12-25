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
/* loaded from: classes6.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools Fq;
    private e cRq;
    private ViewGroup.LayoutParams eqH;
    private HListView gce;
    private List<String> iMs;
    private b iMt;
    private QueryMatchEmotionModel iMu;
    private String iMv;
    private GetEmotionPidModel iMw;
    private Runnable iMx = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.iMv = "";
            c.this.gce.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.cRq = eVar;
        this.mParent = viewGroup;
        this.eqH = layoutParams;
    }

    public void setData(List<String> list) {
        this.iMs = list;
    }

    public void FL(String str) {
        if (!TextUtils.isEmpty(str) && !v.isEmpty(this.iMs) && this.iMs.contains(str)) {
            FM(str);
        }
    }

    private void FM(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.iMv)) {
            this.iMv = str;
            if (this.iMu == null) {
                this.iMu = new QueryMatchEmotionModel(this.cRq);
            }
            this.iMu.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.iMv)) {
            if (v.isEmpty(list)) {
                this.iMv = "";
            } else if (this.mParent != null && this.eqH != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.gce == null || this.gce.getParent() == null) {
                    this.gce = new HListView(this.cRq.getContext());
                    am.setBackgroundColor(this.gce, R.color.cp_bg_line_d);
                    this.gce.setDividerWidth(l.getDimens(this.cRq.getPageActivity(), R.dimen.ds7));
                    this.gce.setClipToPadding(false);
                    int dimens = l.getDimens(this.cRq.getPageActivity(), R.dimen.ds10);
                    this.gce.setPadding(dimens, dimens, dimens, dimens);
                    this.gce.setSelector(R.drawable.list_selector_transparent);
                    this.eqH.height = l.getDimens(this.cRq.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.gce, this.eqH);
                    if (this.iMt == null) {
                        this.iMt = new b();
                        this.iMt.a((b.a) this);
                        this.iMt.a((EmotionView.a) this);
                        this.gce.setAdapter((ListAdapter) this.iMt);
                        this.gce.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.iMx);
                                        c.this.mHandler.postDelayed(c.this.iMx, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.iMx);
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
                this.gce.setVisibility(0);
                this.iMt.setData(list);
                this.iMt.notifyDataSetChanged();
                this.gce.setSelection(0);
                this.mHandler.removeCallbacks(this.iMx);
                this.mHandler.postDelayed(this.iMx, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void bwn() {
        if (this.gce != null) {
            this.gce.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.iMx);
        this.iMv = "";
    }

    public void bDP() {
        if (this.iMu != null) {
            this.iMu.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.iMx);
        this.mHandler.postDelayed(this.iMx, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Fq != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.iMw == null) {
                    this.iMw = new GetEmotionPidModel();
                }
                this.iMw.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        pVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.toMd5("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        pVar.a(EmotionGroupType.NET_SUG);
        pVar.setWidth(emotionImageData.getWidth());
        pVar.setHeight(emotionImageData.getHeight());
        pVar.setUrl(emotionImageData.getPicUrl());
        this.Fq.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
    }

    public void b(EditorTools editorTools) {
        this.Fq = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bxm() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bxp() {
        this.mHandler.removeCallbacks(this.iMx);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bxq() {
        this.mHandler.removeCallbacks(this.iMx);
        this.mHandler.postDelayed(this.iMx, 5000L);
    }
}
