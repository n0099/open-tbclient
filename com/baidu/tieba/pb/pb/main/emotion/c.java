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
    private ViewGroup.LayoutParams hin;
    private HListView iLP;
    private List<String> lSZ;
    private b lTa;
    private QueryMatchEmotionModel lTb;
    private String lTc;
    private GetEmotionPidModel lTd;
    private Runnable lTe = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.lTc = "";
            c.this.iLP.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.eNZ = eVar;
        this.mParent = viewGroup;
        this.hin = layoutParams;
    }

    public void setData(List<String> list) {
        this.lSZ = list;
    }

    public void Qz(String str) {
        if (!TextUtils.isEmpty(str) && !y.isEmpty(this.lSZ) && this.lSZ.contains(str)) {
            QA(str);
        }
    }

    private void QA(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.lTc)) {
            this.lTc = str;
            if (this.lTb == null) {
                this.lTb = new QueryMatchEmotionModel(this.eNZ);
            }
            this.lTb.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.lTc)) {
            if (y.isEmpty(list)) {
                this.lTc = "";
            } else if (this.mParent != null && this.hin != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.iLP == null || this.iLP.getParent() == null) {
                    this.iLP = new HListView(this.eNZ.getContext());
                    ap.setBackgroundColor(this.iLP, R.color.CAM_X0201);
                    this.iLP.setDividerWidth(l.getDimens(this.eNZ.getPageActivity(), R.dimen.ds7));
                    this.iLP.setClipToPadding(false);
                    int dimens = l.getDimens(this.eNZ.getPageActivity(), R.dimen.ds10);
                    this.iLP.setPadding(dimens, dimens, dimens, dimens);
                    this.iLP.setSelector(R.drawable.list_selector_transparent);
                    this.hin.height = l.getDimens(this.eNZ.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.iLP, this.hin);
                    if (this.lTa == null) {
                        this.lTa = new b();
                        this.lTa.a((b.a) this);
                        this.lTa.a((EmotionView.a) this);
                        this.iLP.setAdapter((ListAdapter) this.lTa);
                        this.iLP.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.lTe);
                                        c.this.mHandler.postDelayed(c.this.lTe, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.lTe);
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
                this.iLP.setVisibility(0);
                this.lTa.setData(list);
                this.lTa.notifyDataSetChanged();
                this.iLP.setSelection(0);
                this.mHandler.removeCallbacks(this.lTe);
                this.mHandler.postDelayed(this.lTe, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void dtJ() {
        if (this.iLP != null) {
            this.iLP.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.lTe);
        this.lTc = "";
    }

    public void cFg() {
        if (this.lTb != null) {
            this.lTb.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.lTe);
        this.mHandler.postDelayed(this.lTe, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.acn != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.lTd == null) {
                    this.lTd = new GetEmotionPidModel();
                }
                this.lTd.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
    public boolean cxU() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cxX() {
        this.mHandler.removeCallbacks(this.lTe);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cxY() {
        this.mHandler.removeCallbacks(this.lTe);
        this.mHandler.postDelayed(this.lTe, 5000L);
    }
}
