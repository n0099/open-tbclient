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
    private EditorTools Qj;
    private HListView cZA;
    private String fHA;
    private ViewGroup.LayoutParams fHB;
    private GetEmotionPidModel fHC;
    private List<String> fHx;
    private b fHy;
    private QueryMatchEmotionModel fHz;
    private e mPageContext;
    private ViewGroup mParent;
    private Runnable fHD = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.fHA = "";
            c.this.cZA.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.fHB = layoutParams;
    }

    public void setData(List<String> list) {
        this.fHx = list;
    }

    public void rz(String str) {
        if (!TextUtils.isEmpty(str) && !w.A(this.fHx) && this.fHx.contains(str)) {
            rA(str);
        }
    }

    private void rA(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.fHA)) {
            this.fHA = str;
            if (this.fHz == null) {
                this.fHz = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.fHz.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.fHA)) {
            if (w.A(list)) {
                this.fHA = "";
            } else if (this.mParent != null && this.fHB != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.cZA == null || this.cZA.getParent() == null) {
                    this.cZA = new HListView(this.mPageContext.getContext());
                    am.j(this.cZA, d.C0142d.cp_bg_line_d);
                    this.cZA.setDividerWidth(l.e(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.cZA.setClipToPadding(false);
                    int e = l.e(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.cZA.setPadding(e, e, e, e);
                    this.cZA.setSelector(d.f.list_selector_transparent);
                    this.fHB.height = l.e(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.mParent.addView(this.cZA, this.fHB);
                    if (this.fHy == null) {
                        this.fHy = new b();
                        this.fHy.a((b.a) this);
                        this.fHy.a((EmotionView.a) this);
                        this.cZA.setAdapter((ListAdapter) this.fHy);
                        this.cZA.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.fHD);
                                        c.this.mHandler.postDelayed(c.this.fHD, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.fHD);
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
                this.cZA.setVisibility(0);
                this.fHy.setData(list);
                this.fHy.notifyDataSetChanged();
                this.cZA.setSelection(0);
                this.mHandler.removeCallbacks(this.fHD);
                this.mHandler.postDelayed(this.fHD, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void SC() {
        if (this.cZA != null) {
            this.cZA.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.fHD);
        this.fHA = "";
    }

    public void avN() {
        if (this.fHz != null) {
            this.fHz.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.fHD);
        this.mHandler.postDelayed(this.fHD, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Qj != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.fHC == null) {
                    this.fHC = new GetEmotionPidModel();
                }
                this.fHC.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        nVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + s.bl("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        nVar.a(EmotionGroupType.NET_SUG);
        nVar.setWidth(emotionImageData.getWidth());
        nVar.setHeight(emotionImageData.getHeight());
        nVar.setUrl(emotionImageData.getPicUrl());
        this.Qj.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
    }

    public void b(EditorTools editorTools) {
        this.Qj = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean apc() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apf() {
        this.mHandler.removeCallbacks(this.fHD);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apg() {
        this.mHandler.removeCallbacks(this.fHD);
        this.mHandler.postDelayed(this.fHD, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
