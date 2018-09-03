package com.baidu.tieba.pb.pb.main.emotion;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.f;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.pb.pb.main.emotion.b;
import com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools Qg;
    private HListView dcp;
    private List<String> fHF;
    private b fHG;
    private QueryMatchEmotionModel fHH;
    private String fHI;
    private ViewGroup.LayoutParams fHJ;
    private GetEmotionPidModel fHK;
    private Runnable fHL = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.fHI = "";
            c.this.dcp.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.fHJ = layoutParams;
    }

    public void setData(List<String> list) {
        this.fHF = list;
    }

    public void rw(String str) {
        if (!TextUtils.isEmpty(str) && !w.z(this.fHF) && this.fHF.contains(str)) {
            rx(str);
        }
    }

    private void rx(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.fHI)) {
            this.fHI = str;
            if (this.fHH == null) {
                this.fHH = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.fHH.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void m(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.fHI)) {
            if (w.z(list)) {
                this.fHI = "";
            } else if (this.mParent != null && this.fHJ != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.dcp == null || this.dcp.getParent() == null) {
                    this.dcp = new HListView(this.mPageContext.getContext());
                    am.j(this.dcp, f.d.cp_bg_line_d);
                    this.dcp.setDividerWidth(l.f(this.mPageContext.getPageActivity(), f.e.ds7));
                    this.dcp.setClipToPadding(false);
                    int f = l.f(this.mPageContext.getPageActivity(), f.e.ds10);
                    this.dcp.setPadding(f, f, f, f);
                    this.dcp.setSelector(f.C0146f.list_selector_transparent);
                    this.fHJ.height = l.f(this.mPageContext.getPageActivity(), f.e.ds136);
                    this.mParent.addView(this.dcp, this.fHJ);
                    if (this.fHG == null) {
                        this.fHG = new b();
                        this.fHG.a((b.a) this);
                        this.fHG.a((EmotionView.a) this);
                        this.dcp.setAdapter((ListAdapter) this.fHG);
                        this.dcp.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.fHL);
                                        c.this.mHandler.postDelayed(c.this.fHL, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.fHL);
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
                this.dcp.setVisibility(0);
                this.fHG.setData(list);
                this.fHG.notifyDataSetChanged();
                this.dcp.setSelection(0);
                this.mHandler.removeCallbacks(this.fHL);
                this.mHandler.postDelayed(this.fHL, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void SP() {
        if (this.dcp != null) {
            this.dcp.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.fHL);
        this.fHI = "";
    }

    public void awr() {
        if (this.fHH != null) {
            this.fHH.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.fHL);
        this.mHandler.postDelayed(this.fHL, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Qg != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.fHK == null) {
                    this.fHK = new GetEmotionPidModel();
                }
                this.fHK.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        n nVar = new n();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(",");
        sb.append(emotionImageData.getWidth()).append(",");
        sb.append(emotionImageData.getHeight()).append(",");
        nVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + s.bm("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        nVar.a(EmotionGroupType.NET_SUG);
        nVar.setWidth(emotionImageData.getWidth());
        nVar.setHeight(emotionImageData.getHeight());
        nVar.setUrl(emotionImageData.getPicUrl());
        this.Qg.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
    }

    public void b(EditorTools editorTools) {
        this.Qg = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean apD() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apG() {
        this.mHandler.removeCallbacks(this.fHL);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apH() {
        this.mHandler.removeCallbacks(this.fHL);
        this.mHandler.postDelayed(this.fHL, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
