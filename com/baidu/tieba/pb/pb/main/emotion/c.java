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
import java.util.List;
/* loaded from: classes22.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools acn;
    private e eNZ;
    private ViewGroup.LayoutParams hip;
    private HListView iLR;
    private List<String> lTb;
    private b lTc;
    private QueryMatchEmotionModel lTd;
    private String lTe;
    private GetEmotionPidModel lTf;
    private Runnable lTg = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.lTe = "";
            c.this.iLR.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.eNZ = eVar;
        this.mParent = viewGroup;
        this.hip = layoutParams;
    }

    public void setData(List<String> list) {
        this.lTb = list;
    }

    public void Qz(String str) {
        if (!TextUtils.isEmpty(str) && !y.isEmpty(this.lTb) && this.lTb.contains(str)) {
            QA(str);
        }
    }

    private void QA(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.lTe)) {
            this.lTe = str;
            if (this.lTd == null) {
                this.lTd = new QueryMatchEmotionModel(this.eNZ);
            }
            this.lTd.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.lTe)) {
            if (y.isEmpty(list)) {
                this.lTe = "";
            } else if (this.mParent != null && this.hip != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.iLR == null || this.iLR.getParent() == null) {
                    this.iLR = new HListView(this.eNZ.getContext());
                    ap.setBackgroundColor(this.iLR, R.color.CAM_X0201);
                    this.iLR.setDividerWidth(l.getDimens(this.eNZ.getPageActivity(), R.dimen.ds7));
                    this.iLR.setClipToPadding(false);
                    int dimens = l.getDimens(this.eNZ.getPageActivity(), R.dimen.ds10);
                    this.iLR.setPadding(dimens, dimens, dimens, dimens);
                    this.iLR.setSelector(R.drawable.list_selector_transparent);
                    this.hip.height = l.getDimens(this.eNZ.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.iLR, this.hip);
                    if (this.lTc == null) {
                        this.lTc = new b();
                        this.lTc.a((b.a) this);
                        this.lTc.a((EmotionView.a) this);
                        this.iLR.setAdapter((ListAdapter) this.lTc);
                        this.iLR.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.lTg);
                                        c.this.mHandler.postDelayed(c.this.lTg, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.lTg);
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
                this.iLR.setVisibility(0);
                this.lTc.setData(list);
                this.lTc.notifyDataSetChanged();
                this.iLR.setSelection(0);
                this.mHandler.removeCallbacks(this.lTg);
                this.mHandler.postDelayed(this.lTg, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void dtK() {
        if (this.iLR != null) {
            this.iLR.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.lTg);
        this.lTe = "";
    }

    public void cFh() {
        if (this.lTd != null) {
            this.lTd.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.lTg);
        this.mHandler.postDelayed(this.lTg, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.acn != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.lTf == null) {
                    this.lTf = new GetEmotionPidModel();
                }
                this.lTf.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        sb.append(emotionImageData.getPicId()).append(",");
        sb.append(emotionImageData.getWidth()).append(",");
        sb.append(emotionImageData.getHeight()).append(",");
        uVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + s.toMd5("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        uVar.a(EmotionGroupType.NET_SUG);
        uVar.setWidth(emotionImageData.getWidth());
        uVar.setHeight(emotionImageData.getHeight());
        uVar.setUrl(emotionImageData.getPicUrl());
        this.acn.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
    }

    public void c(EditorTools editorTools) {
        this.acn = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cxV() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cxY() {
        this.mHandler.removeCallbacks(this.lTg);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cxZ() {
        this.mHandler.removeCallbacks(this.lTg);
        this.mHandler.postDelayed(this.lTg, 5000L);
    }
}
