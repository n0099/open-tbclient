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
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.pb.pb.main.emotion.b;
import com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel;
import java.util.List;
/* loaded from: classes6.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools Ta;
    private HListView dAF;
    private List<String> ghU;
    private b ghV;
    private QueryMatchEmotionModel ghW;
    private String ghX;
    private ViewGroup.LayoutParams ghY;
    private GetEmotionPidModel ghZ;
    private Runnable gia = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.ghX = "";
            c.this.dAF.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.ghY = layoutParams;
    }

    public void setData(List<String> list) {
        this.ghU = list;
    }

    public void tk(String str) {
        if (!TextUtils.isEmpty(str) && !v.I(this.ghU) && this.ghU.contains(str)) {
            tl(str);
        }
    }

    private void tl(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.ghX)) {
            this.ghX = str;
            if (this.ghW == null) {
                this.ghW = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.ghW.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.ghX)) {
            if (v.I(list)) {
                this.ghX = "";
            } else if (this.mParent != null && this.ghY != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.dAF == null || this.dAF.getParent() == null) {
                    this.dAF = new HListView(this.mPageContext.getContext());
                    al.j(this.dAF, e.d.cp_bg_line_d);
                    this.dAF.setDividerWidth(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds7));
                    this.dAF.setClipToPadding(false);
                    int h = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds10);
                    this.dAF.setPadding(h, h, h, h);
                    this.dAF.setSelector(e.f.list_selector_transparent);
                    this.ghY.height = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds136);
                    this.mParent.addView(this.dAF, this.ghY);
                    if (this.ghV == null) {
                        this.ghV = new b();
                        this.ghV.a((b.a) this);
                        this.ghV.a((EmotionView.a) this);
                        this.dAF.setAdapter((ListAdapter) this.ghV);
                        this.dAF.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.gia);
                                        c.this.mHandler.postDelayed(c.this.gia, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.gia);
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
                this.dAF.setVisibility(0);
                this.ghV.setData(list);
                this.ghV.notifyDataSetChanged();
                this.dAF.setSelection(0);
                this.mHandler.removeCallbacks(this.gia);
                this.mHandler.postDelayed(this.gia, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void ZC() {
        if (this.dAF != null) {
            this.dAF.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.gia);
        this.ghX = "";
    }

    public void aDS() {
        if (this.ghW != null) {
            this.ghW.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.gia);
        this.mHandler.postDelayed(this.gia, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Ta != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.ghZ == null) {
                    this.ghZ = new GetEmotionPidModel();
                }
                this.ghZ.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        sb.append(emotionImageData.getPicId()).append(",");
        sb.append(emotionImageData.getWidth()).append(",");
        sb.append(emotionImageData.getHeight()).append(",");
        pVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + s.bC("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        pVar.a(EmotionGroupType.NET_SUG);
        pVar.setWidth(emotionImageData.getWidth());
        pVar.setHeight(emotionImageData.getHeight());
        pVar.setUrl(emotionImageData.getPicUrl());
        this.Ta.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
    }

    public void b(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean awM() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void awP() {
        this.mHandler.removeCallbacks(this.gia);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void awQ() {
        this.mHandler.removeCallbacks(this.gia);
        this.mHandler.postDelayed(this.gia, 5000L);
    }
}
