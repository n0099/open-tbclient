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
import com.baidu.tieba.d;
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
    private HListView dcr;
    private List<String> fHM;
    private b fHN;
    private QueryMatchEmotionModel fHO;
    private String fHP;
    private ViewGroup.LayoutParams fHQ;
    private GetEmotionPidModel fHR;
    private Runnable fHS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.fHP = "";
            c.this.dcr.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.fHQ = layoutParams;
    }

    public void setData(List<String> list) {
        this.fHM = list;
    }

    public void rt(String str) {
        if (!TextUtils.isEmpty(str) && !w.z(this.fHM) && this.fHM.contains(str)) {
            ru(str);
        }
    }

    private void ru(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.fHP)) {
            this.fHP = str;
            if (this.fHO == null) {
                this.fHO = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.fHO.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void m(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.fHP)) {
            if (w.z(list)) {
                this.fHP = "";
            } else if (this.mParent != null && this.fHQ != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.dcr == null || this.dcr.getParent() == null) {
                    this.dcr = new HListView(this.mPageContext.getContext());
                    am.j(this.dcr, d.C0140d.cp_bg_line_d);
                    this.dcr.setDividerWidth(l.f(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.dcr.setClipToPadding(false);
                    int f = l.f(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.dcr.setPadding(f, f, f, f);
                    this.dcr.setSelector(d.f.list_selector_transparent);
                    this.fHQ.height = l.f(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.mParent.addView(this.dcr, this.fHQ);
                    if (this.fHN == null) {
                        this.fHN = new b();
                        this.fHN.a((b.a) this);
                        this.fHN.a((EmotionView.a) this);
                        this.dcr.setAdapter((ListAdapter) this.fHN);
                        this.dcr.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.fHS);
                                        c.this.mHandler.postDelayed(c.this.fHS, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.fHS);
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
                this.dcr.setVisibility(0);
                this.fHN.setData(list);
                this.fHN.notifyDataSetChanged();
                this.dcr.setSelection(0);
                this.mHandler.removeCallbacks(this.fHS);
                this.mHandler.postDelayed(this.fHS, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void SL() {
        if (this.dcr != null) {
            this.dcr.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.fHS);
        this.fHP = "";
    }

    public void aws() {
        if (this.fHO != null) {
            this.fHO.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.fHS);
        this.mHandler.postDelayed(this.fHS, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Qg != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.fHR == null) {
                    this.fHR = new GetEmotionPidModel();
                }
                this.fHR.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.mHandler.removeCallbacks(this.fHS);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apH() {
        this.mHandler.removeCallbacks(this.fHS);
        this.mHandler.postDelayed(this.fHS, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
