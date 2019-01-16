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
    private HListView dBo;
    private List<String> giY;
    private b giZ;
    private QueryMatchEmotionModel gja;
    private String gjb;
    private ViewGroup.LayoutParams gjc;
    private GetEmotionPidModel gjd;
    private Runnable gje = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.gjb = "";
            c.this.dBo.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.gjc = layoutParams;
    }

    public void setData(List<String> list) {
        this.giY = list;
    }

    public void tA(String str) {
        if (!TextUtils.isEmpty(str) && !v.I(this.giY) && this.giY.contains(str)) {
            tB(str);
        }
    }

    private void tB(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.gjb)) {
            this.gjb = str;
            if (this.gja == null) {
                this.gja = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.gja.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.gjb)) {
            if (v.I(list)) {
                this.gjb = "";
            } else if (this.mParent != null && this.gjc != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.dBo == null || this.dBo.getParent() == null) {
                    this.dBo = new HListView(this.mPageContext.getContext());
                    al.j(this.dBo, e.d.cp_bg_line_d);
                    this.dBo.setDividerWidth(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds7));
                    this.dBo.setClipToPadding(false);
                    int h = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds10);
                    this.dBo.setPadding(h, h, h, h);
                    this.dBo.setSelector(e.f.list_selector_transparent);
                    this.gjc.height = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds136);
                    this.mParent.addView(this.dBo, this.gjc);
                    if (this.giZ == null) {
                        this.giZ = new b();
                        this.giZ.a((b.a) this);
                        this.giZ.a((EmotionView.a) this);
                        this.dBo.setAdapter((ListAdapter) this.giZ);
                        this.dBo.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.gje);
                                        c.this.mHandler.postDelayed(c.this.gje, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.gje);
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
                this.dBo.setVisibility(0);
                this.giZ.setData(list);
                this.giZ.notifyDataSetChanged();
                this.dBo.setSelection(0);
                this.mHandler.removeCallbacks(this.gje);
                this.mHandler.postDelayed(this.gje, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void ZZ() {
        if (this.dBo != null) {
            this.dBo.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.gje);
        this.gjb = "";
    }

    public void aEp() {
        if (this.gja != null) {
            this.gja.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.gje);
        this.mHandler.postDelayed(this.gje, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Tj != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.gjd == null) {
                    this.gjd = new GetEmotionPidModel();
                }
                this.gjd.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.mHandler.removeCallbacks(this.gje);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void axn() {
        this.mHandler.removeCallbacks(this.gje);
        this.mHandler.postDelayed(this.gje, 5000L);
    }
}
