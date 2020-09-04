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
import com.baidu.tbadk.coreExtra.data.t;
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
/* loaded from: classes16.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools aaA;
    private e efO;
    private ViewGroup.LayoutParams gpu;
    private HListView hLN;
    private List<String> kOA;
    private b kOB;
    private QueryMatchEmotionModel kOC;
    private String kOD;
    private GetEmotionPidModel kOE;
    private Runnable kOF = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.kOD = "";
            c.this.hLN.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.efO = eVar;
        this.mParent = viewGroup;
        this.gpu = layoutParams;
    }

    public void setData(List<String> list) {
        this.kOA = list;
    }

    public void NQ(String str) {
        if (!TextUtils.isEmpty(str) && !y.isEmpty(this.kOA) && this.kOA.contains(str)) {
            NR(str);
        }
    }

    private void NR(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.kOD)) {
            this.kOD = str;
            if (this.kOC == null) {
                this.kOC = new QueryMatchEmotionModel(this.efO);
            }
            this.kOC.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.kOD)) {
            if (y.isEmpty(list)) {
                this.kOD = "";
            } else if (this.mParent != null && this.gpu != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.hLN == null || this.hLN.getParent() == null) {
                    this.hLN = new HListView(this.efO.getContext());
                    ap.setBackgroundColor(this.hLN, R.color.cp_bg_line_d);
                    this.hLN.setDividerWidth(l.getDimens(this.efO.getPageActivity(), R.dimen.ds7));
                    this.hLN.setClipToPadding(false);
                    int dimens = l.getDimens(this.efO.getPageActivity(), R.dimen.ds10);
                    this.hLN.setPadding(dimens, dimens, dimens, dimens);
                    this.hLN.setSelector(R.drawable.list_selector_transparent);
                    this.gpu.height = l.getDimens(this.efO.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.hLN, this.gpu);
                    if (this.kOB == null) {
                        this.kOB = new b();
                        this.kOB.a((b.a) this);
                        this.kOB.a((EmotionView.a) this);
                        this.hLN.setAdapter((ListAdapter) this.kOB);
                        this.hLN.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.kOF);
                                        c.this.mHandler.postDelayed(c.this.kOF, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.kOF);
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
                this.hLN.setVisibility(0);
                this.kOB.setData(list);
                this.kOB.notifyDataSetChanged();
                this.hLN.setSelection(0);
                this.mHandler.removeCallbacks(this.kOF);
                this.mHandler.postDelayed(this.kOF, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void dbW() {
        if (this.hLN != null) {
            this.hLN.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.kOF);
        this.kOD = "";
    }

    public void coV() {
        if (this.kOC != null) {
            this.kOC.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.kOF);
        this.mHandler.postDelayed(this.kOF, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.aaA != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.kOE == null) {
                    this.kOE = new GetEmotionPidModel();
                }
                this.kOE.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        t tVar = new t();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        tVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.toMd5("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        tVar.a(EmotionGroupType.NET_SUG);
        tVar.setWidth(emotionImageData.getWidth());
        tVar.setHeight(emotionImageData.getHeight());
        tVar.setUrl(emotionImageData.getPicUrl());
        this.aaA.b(new com.baidu.tbadk.editortools.a(24, -1, tVar));
    }

    public void c(EditorTools editorTools) {
        this.aaA = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean chJ() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void chM() {
        this.mHandler.removeCallbacks(this.kOF);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void chN() {
        this.mHandler.removeCallbacks(this.kOF);
        this.mHandler.postDelayed(this.kOF, 5000L);
    }
}
