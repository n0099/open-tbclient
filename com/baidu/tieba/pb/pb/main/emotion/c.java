package com.baidu.tieba.pb.pb.main.emotion;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes2.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools acX;
    private f eTl;
    private ViewGroup.LayoutParams hpF;
    private HListView iTv;
    private List<String> lTI;
    private b lTJ;
    private QueryMatchEmotionModel lTK;
    private String lTL;
    private GetEmotionPidModel lTM;
    private Runnable lTN = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.lTL = "";
            c.this.iTv.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(f fVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.eTl = fVar;
        this.mParent = viewGroup;
        this.hpF = layoutParams;
    }

    public void setData(List<String> list) {
        this.lTI = list;
    }

    public void OX(String str) {
        if (!TextUtils.isEmpty(str) && !x.isEmpty(this.lTI) && this.lTI.contains(str)) {
            OY(str);
        }
    }

    private void OY(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.lTL)) {
            this.lTL = str;
            if (this.lTK == null) {
                this.lTK = new QueryMatchEmotionModel(this.eTl);
            }
            this.lTK.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.lTL)) {
            if (x.isEmpty(list)) {
                this.lTL = "";
            } else if (this.mParent != null && this.hpF != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.iTv == null || this.iTv.getParent() == null) {
                    this.iTv = new HListView(this.eTl.getContext());
                    ao.setBackgroundColor(this.iTv, R.color.CAM_X0201);
                    this.iTv.setDividerWidth(l.getDimens(this.eTl.getPageActivity(), R.dimen.ds7));
                    this.iTv.setClipToPadding(false);
                    int dimens = l.getDimens(this.eTl.getPageActivity(), R.dimen.ds10);
                    this.iTv.setPadding(dimens, dimens, dimens, dimens);
                    this.iTv.setSelector(R.drawable.list_selector_transparent);
                    this.hpF.height = l.getDimens(this.eTl.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.iTv, this.hpF);
                    if (this.lTJ == null) {
                        this.lTJ = new b();
                        this.lTJ.a((b.a) this);
                        this.lTJ.a((EmotionView.a) this);
                        this.iTv.setAdapter((ListAdapter) this.lTJ);
                        this.iTv.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.lTN);
                                        c.this.mHandler.postDelayed(c.this.lTN, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.lTN);
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
                this.iTv.setVisibility(0);
                this.lTJ.setData(list);
                this.lTJ.notifyDataSetChanged();
                this.iTv.setSelection(0);
                this.mHandler.removeCallbacks(this.lTN);
                this.mHandler.postDelayed(this.lTN, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void dpI() {
        if (this.iTv != null) {
            this.iTv.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.lTN);
        this.lTL = "";
    }

    public void cEk() {
        if (this.lTK != null) {
            this.lTK.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.lTN);
        this.mHandler.postDelayed(this.lTN, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.acX != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.lTM == null) {
                    this.lTM = new GetEmotionPidModel();
                }
                this.lTM.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.acX.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
    }

    public void c(EditorTools editorTools) {
        this.acX = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cwX() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cxa() {
        this.mHandler.removeCallbacks(this.lTN);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cxb() {
        this.mHandler.removeCallbacks(this.lTN);
        this.mHandler.postDelayed(this.lTN, 5000L);
    }
}
