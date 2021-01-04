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
    private EditorTools acZ;
    private f eXW;
    private ViewGroup.LayoutParams hul;
    private HListView iYc;
    private List<String> lYn;
    private b lYo;
    private QueryMatchEmotionModel lYp;
    private String lYq;
    private GetEmotionPidModel lYr;
    private Runnable lYs = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.lYq = "";
            c.this.iYc.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(f fVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.eXW = fVar;
        this.mParent = viewGroup;
        this.hul = layoutParams;
    }

    public void setData(List<String> list) {
        this.lYn = list;
    }

    public void Qf(String str) {
        if (!TextUtils.isEmpty(str) && !x.isEmpty(this.lYn) && this.lYn.contains(str)) {
            Qg(str);
        }
    }

    private void Qg(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.lYq)) {
            this.lYq = str;
            if (this.lYp == null) {
                this.lYp = new QueryMatchEmotionModel(this.eXW);
            }
            this.lYp.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.lYq)) {
            if (x.isEmpty(list)) {
                this.lYq = "";
            } else if (this.mParent != null && this.hul != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.iYc == null || this.iYc.getParent() == null) {
                    this.iYc = new HListView(this.eXW.getContext());
                    ao.setBackgroundColor(this.iYc, R.color.CAM_X0201);
                    this.iYc.setDividerWidth(l.getDimens(this.eXW.getPageActivity(), R.dimen.ds7));
                    this.iYc.setClipToPadding(false);
                    int dimens = l.getDimens(this.eXW.getPageActivity(), R.dimen.ds10);
                    this.iYc.setPadding(dimens, dimens, dimens, dimens);
                    this.iYc.setSelector(R.drawable.list_selector_transparent);
                    this.hul.height = l.getDimens(this.eXW.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.iYc, this.hul);
                    if (this.lYo == null) {
                        this.lYo = new b();
                        this.lYo.a((b.a) this);
                        this.lYo.a((EmotionView.a) this);
                        this.iYc.setAdapter((ListAdapter) this.lYo);
                        this.iYc.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.lYs);
                                        c.this.mHandler.postDelayed(c.this.lYs, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.lYs);
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
                this.iYc.setVisibility(0);
                this.lYo.setData(list);
                this.lYo.notifyDataSetChanged();
                this.iYc.setSelection(0);
                this.mHandler.removeCallbacks(this.lYs);
                this.mHandler.postDelayed(this.lYs, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void dtz() {
        if (this.iYc != null) {
            this.iYc.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.lYs);
        this.lYq = "";
    }

    public void cIb() {
        if (this.lYp != null) {
            this.lYp.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.lYs);
        this.mHandler.postDelayed(this.lYs, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.acZ != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.lYr == null) {
                    this.lYr = new GetEmotionPidModel();
                }
                this.lYr.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.acZ.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
    }

    public void c(EditorTools editorTools) {
        this.acZ = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cAO() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cAR() {
        this.mHandler.removeCallbacks(this.lYs);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cAS() {
        this.mHandler.removeCallbacks(this.lYs);
        this.mHandler.postDelayed(this.lYs, 5000L);
    }
}
