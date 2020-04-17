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
import com.baidu.tbadk.coreExtra.data.q;
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
/* loaded from: classes9.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools Za;
    private e dvc;
    private ViewGroup.LayoutParams faR;
    private HListView gRu;
    private List<String> jDp;
    private b jDq;
    private QueryMatchEmotionModel jDr;
    private String jDs;
    private GetEmotionPidModel jDt;
    private Runnable jDu = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.jDs = "";
            c.this.gRu.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.dvc = eVar;
        this.mParent = viewGroup;
        this.faR = layoutParams;
    }

    public void setData(List<String> list) {
        this.jDp = list;
    }

    public void HS(String str) {
        if (!TextUtils.isEmpty(str) && !v.isEmpty(this.jDp) && this.jDp.contains(str)) {
            HT(str);
        }
    }

    private void HT(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.jDs)) {
            this.jDs = str;
            if (this.jDr == null) {
                this.jDr = new QueryMatchEmotionModel(this.dvc);
            }
            this.jDr.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.jDs)) {
            if (v.isEmpty(list)) {
                this.jDs = "";
            } else if (this.mParent != null && this.faR != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.gRu == null || this.gRu.getParent() == null) {
                    this.gRu = new HListView(this.dvc.getContext());
                    am.setBackgroundColor(this.gRu, R.color.cp_bg_line_d);
                    this.gRu.setDividerWidth(l.getDimens(this.dvc.getPageActivity(), R.dimen.ds7));
                    this.gRu.setClipToPadding(false);
                    int dimens = l.getDimens(this.dvc.getPageActivity(), R.dimen.ds10);
                    this.gRu.setPadding(dimens, dimens, dimens, dimens);
                    this.gRu.setSelector(R.drawable.list_selector_transparent);
                    this.faR.height = l.getDimens(this.dvc.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.gRu, this.faR);
                    if (this.jDq == null) {
                        this.jDq = new b();
                        this.jDq.a((b.a) this);
                        this.jDq.a((EmotionView.a) this);
                        this.gRu.setAdapter((ListAdapter) this.jDq);
                        this.gRu.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.jDu);
                                        c.this.mHandler.postDelayed(c.this.jDu, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.jDu);
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
                this.gRu.setVisibility(0);
                this.jDq.setData(list);
                this.jDq.notifyDataSetChanged();
                this.gRu.setSelection(0);
                this.mHandler.removeCallbacks(this.jDu);
                this.mHandler.postDelayed(this.jDu, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void cBP() {
        if (this.gRu != null) {
            this.gRu.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.jDu);
        this.jDs = "";
    }

    public void bRj() {
        if (this.jDr != null) {
            this.jDr.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.jDu);
        this.mHandler.postDelayed(this.jDu, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Za != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.jDt == null) {
                    this.jDt = new GetEmotionPidModel();
                }
                this.jDt.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        q qVar = new q();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        qVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.toMd5("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        qVar.a(EmotionGroupType.NET_SUG);
        qVar.setWidth(emotionImageData.getWidth());
        qVar.setHeight(emotionImageData.getHeight());
        qVar.setUrl(emotionImageData.getPicUrl());
        this.Za.b(new com.baidu.tbadk.editortools.a(24, -1, qVar));
    }

    public void b(EditorTools editorTools) {
        this.Za = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bKA() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bKD() {
        this.mHandler.removeCallbacks(this.jDu);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bKE() {
        this.mHandler.removeCallbacks(this.jDu);
        this.mHandler.postDelayed(this.jDu, 5000L);
    }
}
