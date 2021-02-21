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
/* loaded from: classes2.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools acR;
    private f eVB;
    private ViewGroup.LayoutParams hue;
    private HListView iZq;
    private ViewGroup mParent;
    private List<String> mdb;
    private b mdc;
    private QueryMatchEmotionModel mdd;
    private String mde;
    private GetEmotionPidModel mdf;
    private Runnable mdg = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.mde = "";
            c.this.iZq.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();

    public c(f fVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.eVB = fVar;
        this.mParent = viewGroup;
        this.hue = layoutParams;
    }

    public void setData(List<String> list) {
        this.mdb = list;
    }

    public void PP(String str) {
        if (!TextUtils.isEmpty(str) && !y.isEmpty(this.mdb) && this.mdb.contains(str)) {
            PQ(str);
        }
    }

    private void PQ(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.mde)) {
            this.mde = str;
            if (this.mdd == null) {
                this.mdd = new QueryMatchEmotionModel(this.eVB);
            }
            this.mdd.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.mde)) {
            if (y.isEmpty(list)) {
                this.mde = "";
            } else if (this.mParent != null && this.hue != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.iZq == null || this.iZq.getParent() == null) {
                    this.iZq = new HListView(this.eVB.getContext());
                    ap.setBackgroundColor(this.iZq, R.color.CAM_X0201);
                    this.iZq.setDividerWidth(l.getDimens(this.eVB.getPageActivity(), R.dimen.ds7));
                    this.iZq.setClipToPadding(false);
                    int dimens = l.getDimens(this.eVB.getPageActivity(), R.dimen.ds10);
                    this.iZq.setPadding(dimens, dimens, dimens, dimens);
                    this.iZq.setSelector(R.drawable.list_selector_transparent);
                    this.hue.height = l.getDimens(this.eVB.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.iZq, this.hue);
                    if (this.mdc == null) {
                        this.mdc = new b();
                        this.mdc.a((b.a) this);
                        this.mdc.a((EmotionView.a) this);
                        this.iZq.setAdapter((ListAdapter) this.mdc);
                        this.iZq.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.mdg);
                                        c.this.mHandler.postDelayed(c.this.mdg, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.mdg);
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
                this.iZq.setVisibility(0);
                this.mdc.setData(list);
                this.mdc.notifyDataSetChanged();
                this.iZq.setSelection(0);
                this.mHandler.removeCallbacks(this.mdg);
                this.mHandler.postDelayed(this.mdg, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void dsd() {
        if (this.iZq != null) {
            this.iZq.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.mdg);
        this.mde = "";
    }

    public void cFE() {
        if (this.mdd != null) {
            this.mdd.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.mdg);
        this.mHandler.postDelayed(this.mdg, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.acR != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.mdf == null) {
                    this.mdf = new GetEmotionPidModel();
                }
                this.mdf.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.acR.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
    }

    public void c(EditorTools editorTools) {
        this.acR = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cyp() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cys() {
        this.mHandler.removeCallbacks(this.mdg);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cyt() {
        this.mHandler.removeCallbacks(this.mdg);
        this.mHandler.postDelayed(this.mdg, 5000L);
    }
}
