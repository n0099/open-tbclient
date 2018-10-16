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
/* loaded from: classes6.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools SY;
    private HListView dqo;
    private List<String> fWL;
    private b fWM;
    private QueryMatchEmotionModel fWN;
    private String fWO;
    private ViewGroup.LayoutParams fWP;
    private GetEmotionPidModel fWQ;
    private Runnable fWR = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.fWO = "";
            c.this.dqo.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.fWP = layoutParams;
    }

    public void setData(List<String> list) {
        this.fWL = list;
    }

    public void sE(String str) {
        if (!TextUtils.isEmpty(str) && !v.J(this.fWL) && this.fWL.contains(str)) {
            sF(str);
        }
    }

    private void sF(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.fWO)) {
            this.fWO = str;
            if (this.fWN == null) {
                this.fWN = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.fWN.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.fWO)) {
            if (v.J(list)) {
                this.fWO = "";
            } else if (this.mParent != null && this.fWP != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.dqo == null || this.dqo.getParent() == null) {
                    this.dqo = new HListView(this.mPageContext.getContext());
                    al.j(this.dqo, e.d.cp_bg_line_d);
                    this.dqo.setDividerWidth(l.h(this.mPageContext.getPageActivity(), e.C0175e.ds7));
                    this.dqo.setClipToPadding(false);
                    int h = l.h(this.mPageContext.getPageActivity(), e.C0175e.ds10);
                    this.dqo.setPadding(h, h, h, h);
                    this.dqo.setSelector(e.f.list_selector_transparent);
                    this.fWP.height = l.h(this.mPageContext.getPageActivity(), e.C0175e.ds136);
                    this.mParent.addView(this.dqo, this.fWP);
                    if (this.fWM == null) {
                        this.fWM = new b();
                        this.fWM.a((b.a) this);
                        this.fWM.a((EmotionView.a) this);
                        this.dqo.setAdapter((ListAdapter) this.fWM);
                        this.dqo.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.fWR);
                                        c.this.mHandler.postDelayed(c.this.fWR, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.fWR);
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
                this.dqo.setVisibility(0);
                this.fWM.setData(list);
                this.fWM.notifyDataSetChanged();
                this.dqo.setSelection(0);
                this.mHandler.removeCallbacks(this.fWR);
                this.mHandler.postDelayed(this.fWR, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void Yj() {
        if (this.dqo != null) {
            this.dqo.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.fWR);
        this.fWO = "";
    }

    public void aBV() {
        if (this.fWN != null) {
            this.fWN.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.fWR);
        this.mHandler.postDelayed(this.fWR, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.SY != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.fWQ == null) {
                    this.fWQ = new GetEmotionPidModel();
                }
                this.fWQ.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        oVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + s.bC("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        oVar.a(EmotionGroupType.NET_SUG);
        oVar.setWidth(emotionImageData.getWidth());
        oVar.setHeight(emotionImageData.getHeight());
        oVar.setUrl(emotionImageData.getPicUrl());
        this.SY.b(new com.baidu.tbadk.editortools.a(24, -1, oVar));
    }

    public void b(EditorTools editorTools) {
        this.SY = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean auN() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void auQ() {
        this.mHandler.removeCallbacks(this.fWR);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void auR() {
        this.mHandler.removeCallbacks(this.fWR);
        this.mHandler.postDelayed(this.fWR, 5000L);
    }
}
