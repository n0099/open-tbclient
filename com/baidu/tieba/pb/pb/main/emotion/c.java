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
/* loaded from: classes.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private i IR;
    private ViewGroup byH;
    private HListView cCq;
    private List<String> feL;
    private b feM;
    private QueryMatchEmotionModel feN;
    private String feO;
    private ViewGroup.LayoutParams feP;
    private GetEmotionPidModel feQ;
    private Runnable feR = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.feO = "";
            c.this.cCq.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.byH = viewGroup;
        this.feP = layoutParams;
    }

    public void setData(List<String> list) {
        this.feL = list;
    }

    public void qa(String str) {
        if (!TextUtils.isEmpty(str) && !v.w(this.feL) && this.feL.contains(str)) {
            qb(str);
        }
    }

    private void qb(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.feO)) {
            this.feO = str;
            if (this.feN == null) {
                this.feN = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.feN.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void l(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.feO)) {
            if (v.w(list)) {
                this.feO = "";
            } else if (this.byH != null && this.feP != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.cCq == null || this.cCq.getParent() == null) {
                    this.cCq = new HListView(this.mPageContext.getContext());
                    aj.k(this.cCq, d.C0096d.cp_bg_line_d);
                    this.cCq.setDividerWidth(l.f(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.cCq.setClipToPadding(false);
                    int f = l.f(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.cCq.setPadding(f, f, f, f);
                    this.cCq.setSelector(d.f.list_selector_transparent);
                    this.feP.height = l.f(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.byH.addView(this.cCq, this.feP);
                    if (this.feM == null) {
                        this.feM = new b();
                        this.feM.a((b.a) this);
                        this.feM.a((EmotionView.a) this);
                        this.cCq.setAdapter((ListAdapter) this.feM);
                        this.cCq.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.feR);
                                        c.this.mHandler.postDelayed(c.this.feR, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.feR);
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
                this.cCq.setVisibility(0);
                this.feM.setData(list);
                this.feM.notifyDataSetChanged();
                this.cCq.setSelection(0);
                this.mHandler.removeCallbacks(this.feR);
                this.mHandler.postDelayed(this.feR, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void Od() {
        if (this.cCq != null) {
            this.cCq.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.feR);
        this.feO = "";
    }

    public void anc() {
        if (this.feN != null) {
            this.feN.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.feR);
        this.mHandler.postDelayed(this.feR, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.IR != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.feQ == null) {
                    this.feQ = new GetEmotionPidModel();
                }
                this.feQ.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        nVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.aS("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        nVar.a(EmotionGroupType.NET_SUG);
        nVar.setWidth(emotionImageData.getWidth());
        nVar.setHeight(emotionImageData.getHeight());
        nVar.setUrl(emotionImageData.getPicUrl());
        this.IR.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
    }

    public void b(i iVar) {
        this.IR = iVar;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean ahO() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void ahR() {
        this.mHandler.removeCallbacks(this.feR);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void ahS() {
        this.mHandler.removeCallbacks(this.feR);
        this.mHandler.postDelayed(this.feR, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
