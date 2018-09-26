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
import com.baidu.tbadk.coreExtra.data.o;
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
/* loaded from: classes2.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools SG;
    private HListView dik;
    private List<String> fPl;
    private b fPm;
    private QueryMatchEmotionModel fPn;
    private String fPo;
    private ViewGroup.LayoutParams fPp;
    private GetEmotionPidModel fPq;
    private Runnable fPr = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.fPo = "";
            c.this.dik.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.fPp = layoutParams;
    }

    public void setData(List<String> list) {
        this.fPl = list;
    }

    public void sd(String str) {
        if (!TextUtils.isEmpty(str) && !v.z(this.fPl) && this.fPl.contains(str)) {
            se(str);
        }
    }

    private void se(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.fPo)) {
            this.fPo = str;
            if (this.fPn == null) {
                this.fPn = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.fPn.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.fPo)) {
            if (v.z(list)) {
                this.fPo = "";
            } else if (this.mParent != null && this.fPp != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.dik == null || this.dik.getParent() == null) {
                    this.dik = new HListView(this.mPageContext.getContext());
                    al.j(this.dik, e.d.cp_bg_line_d);
                    this.dik.setDividerWidth(l.h(this.mPageContext.getPageActivity(), e.C0141e.ds7));
                    this.dik.setClipToPadding(false);
                    int h = l.h(this.mPageContext.getPageActivity(), e.C0141e.ds10);
                    this.dik.setPadding(h, h, h, h);
                    this.dik.setSelector(e.f.list_selector_transparent);
                    this.fPp.height = l.h(this.mPageContext.getPageActivity(), e.C0141e.ds136);
                    this.mParent.addView(this.dik, this.fPp);
                    if (this.fPm == null) {
                        this.fPm = new b();
                        this.fPm.a((b.a) this);
                        this.fPm.a((EmotionView.a) this);
                        this.dik.setAdapter((ListAdapter) this.fPm);
                        this.dik.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.fPr);
                                        c.this.mHandler.postDelayed(c.this.fPr, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.fPr);
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
                this.dik.setVisibility(0);
                this.fPm.setData(list);
                this.fPm.notifyDataSetChanged();
                this.dik.setSelection(0);
                this.mHandler.removeCallbacks(this.fPr);
                this.mHandler.postDelayed(this.fPr, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void UC() {
        if (this.dik != null) {
            this.dik.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.fPr);
        this.fPo = "";
    }

    public void ayC() {
        if (this.fPn != null) {
            this.fPn.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.fPr);
        this.mHandler.postDelayed(this.fPr, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.SG != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.fPq == null) {
                    this.fPq = new GetEmotionPidModel();
                }
                this.fPq.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        o oVar = new o();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(",");
        sb.append(emotionImageData.getWidth()).append(",");
        sb.append(emotionImageData.getHeight()).append(",");
        oVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + s.bD("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        oVar.a(EmotionGroupType.NET_SUG);
        oVar.setWidth(emotionImageData.getWidth());
        oVar.setHeight(emotionImageData.getHeight());
        oVar.setUrl(emotionImageData.getPicUrl());
        this.SG.b(new com.baidu.tbadk.editortools.a(24, -1, oVar));
    }

    public void b(EditorTools editorTools) {
        this.SG = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean arr() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aru() {
        this.mHandler.removeCallbacks(this.fPr);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void arv() {
        this.mHandler.removeCallbacks(this.fPr);
        this.mHandler.postDelayed(this.fPr, 5000L);
    }
}
