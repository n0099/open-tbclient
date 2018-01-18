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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.pb.pb.main.emotion.b;
import com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private i axN;
    private ViewGroup cmX;
    private HListView dvx;
    private List<String> fTj;
    private b fTk;
    private QueryMatchEmotionModel fTl;
    private String fTm;
    private ViewGroup.LayoutParams fTn;
    private GetEmotionPidModel fTo;
    private Runnable fTp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.fTm = "";
            c.this.dvx.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.cmX = viewGroup;
        this.fTn = layoutParams;
    }

    public void setData(List<String> list) {
        this.fTj = list;
    }

    public void qn(String str) {
        if (!TextUtils.isEmpty(str) && !v.E(this.fTj) && this.fTj.contains(str)) {
            qo(str);
        }
    }

    private void qo(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.fTm)) {
            this.fTm = str;
            if (this.fTl == null) {
                this.fTl = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.fTl.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void l(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.fTm)) {
            if (v.E(list)) {
                this.fTm = "";
            } else if (this.cmX != null && this.fTn != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.dvx == null || this.dvx.getParent() == null) {
                    this.dvx = new HListView(this.mPageContext.getContext());
                    aj.t(this.dvx, d.C0107d.cp_bg_line_d);
                    this.dvx.setDividerWidth(l.s(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.dvx.setClipToPadding(false);
                    int s = l.s(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.dvx.setPadding(s, s, s, s);
                    this.dvx.setSelector(d.f.list_selector_transparent);
                    this.fTn.height = l.s(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.cmX.addView(this.dvx, this.fTn);
                    if (this.fTk == null) {
                        this.fTk = new b();
                        this.fTk.a((b.a) this);
                        this.fTk.a((EmotionView.a) this);
                        this.dvx.setAdapter((ListAdapter) this.fTk);
                        this.dvx.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.fTp);
                                        c.this.mHandler.postDelayed(c.this.fTp, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.fTp);
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
                this.dvx.setVisibility(0);
                this.fTk.setData(list);
                this.fTk.notifyDataSetChanged();
                this.dvx.setSelection(0);
                this.mHandler.removeCallbacks(this.fTp);
                this.mHandler.postDelayed(this.fTp, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void Vq() {
        if (this.dvx != null) {
            this.dvx.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.fTp);
        this.fTm = "";
    }

    public void avN() {
        if (this.fTl != null) {
            this.fTl.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.fTp);
        this.mHandler.postDelayed(this.fTp, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.axN != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.fTo == null) {
                    this.fTo = new GetEmotionPidModel();
                }
                this.fTo.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        nVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.ba("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        nVar.a(EmotionGroupType.NET_SUG);
        nVar.setWidth(emotionImageData.getWidth());
        nVar.setHeight(emotionImageData.getHeight());
        nVar.setUrl(emotionImageData.getPicUrl());
        this.axN.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
    }

    public void b(i iVar) {
        this.axN = iVar;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean aqr() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aqu() {
        this.mHandler.removeCallbacks(this.fTp);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aqv() {
        this.mHandler.removeCallbacks(this.fTp);
        this.mHandler.postDelayed(this.fTp, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
