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
    private EditorTools Tj;
    private HListView dBp;
    private List<String> giZ;
    private b gja;
    private QueryMatchEmotionModel gjb;
    private String gjc;
    private ViewGroup.LayoutParams gjd;
    private GetEmotionPidModel gje;
    private Runnable gjf = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.gjc = "";
            c.this.dBp.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.gjd = layoutParams;
    }

    public void setData(List<String> list) {
        this.giZ = list;
    }

    public void tA(String str) {
        if (!TextUtils.isEmpty(str) && !v.I(this.giZ) && this.giZ.contains(str)) {
            tB(str);
        }
    }

    private void tB(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.gjc)) {
            this.gjc = str;
            if (this.gjb == null) {
                this.gjb = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.gjb.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.gjc)) {
            if (v.I(list)) {
                this.gjc = "";
            } else if (this.mParent != null && this.gjd != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.dBp == null || this.dBp.getParent() == null) {
                    this.dBp = new HListView(this.mPageContext.getContext());
                    al.j(this.dBp, e.d.cp_bg_line_d);
                    this.dBp.setDividerWidth(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds7));
                    this.dBp.setClipToPadding(false);
                    int h = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds10);
                    this.dBp.setPadding(h, h, h, h);
                    this.dBp.setSelector(e.f.list_selector_transparent);
                    this.gjd.height = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds136);
                    this.mParent.addView(this.dBp, this.gjd);
                    if (this.gja == null) {
                        this.gja = new b();
                        this.gja.a((b.a) this);
                        this.gja.a((EmotionView.a) this);
                        this.dBp.setAdapter((ListAdapter) this.gja);
                        this.dBp.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.gjf);
                                        c.this.mHandler.postDelayed(c.this.gjf, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.gjf);
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
                this.dBp.setVisibility(0);
                this.gja.setData(list);
                this.gja.notifyDataSetChanged();
                this.dBp.setSelection(0);
                this.mHandler.removeCallbacks(this.gjf);
                this.mHandler.postDelayed(this.gjf, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void ZZ() {
        if (this.dBp != null) {
            this.dBp.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.gjf);
        this.gjc = "";
    }

    public void aEp() {
        if (this.gjb != null) {
            this.gjb.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.gjf);
        this.mHandler.postDelayed(this.gjf, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Tj != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.gje == null) {
                    this.gje = new GetEmotionPidModel();
                }
                this.gje.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.Tj.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
    }

    public void b(EditorTools editorTools) {
        this.Tj = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean axj() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void axm() {
        this.mHandler.removeCallbacks(this.gjf);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void axn() {
        this.mHandler.removeCallbacks(this.gjf);
        this.mHandler.postDelayed(this.gjf, 5000L);
    }
}
