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
import com.baidu.tbadk.coreExtra.data.m;
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
    private i IT;
    private ViewGroup byF;
    private HListView cCi;
    private List<String> fdK;
    private b fdL;
    private QueryMatchEmotionModel fdM;
    private String fdN;
    private ViewGroup.LayoutParams fdO;
    private GetEmotionPidModel fdP;
    private Runnable fdQ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.fdN = "";
            c.this.cCi.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.byF = viewGroup;
        this.fdO = layoutParams;
    }

    public void setData(List<String> list) {
        this.fdK = list;
    }

    public void qa(String str) {
        if (!TextUtils.isEmpty(str) && !v.w(this.fdK) && this.fdK.contains(str)) {
            qb(str);
        }
    }

    private void qb(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.fdN)) {
            this.fdN = str;
            if (this.fdM == null) {
                this.fdM = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.fdM.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void l(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.fdN)) {
            if (v.w(list)) {
                this.fdN = "";
            } else if (this.byF != null && this.fdO != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.cCi == null || this.cCi.getParent() == null) {
                    this.cCi = new HListView(this.mPageContext.getContext());
                    aj.k(this.cCi, d.C0082d.cp_bg_line_d);
                    this.cCi.setDividerWidth(l.f(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.cCi.setClipToPadding(false);
                    int f = l.f(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.cCi.setPadding(f, f, f, f);
                    this.cCi.setSelector(d.f.list_selector_transparent);
                    this.fdO.height = l.f(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.byF.addView(this.cCi, this.fdO);
                    if (this.fdL == null) {
                        this.fdL = new b();
                        this.fdL.a((b.a) this);
                        this.fdL.a((EmotionView.a) this);
                        this.cCi.setAdapter((ListAdapter) this.fdL);
                        this.cCi.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.fdQ);
                                        c.this.mHandler.postDelayed(c.this.fdQ, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.fdQ);
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
                this.cCi.setVisibility(0);
                this.fdL.setData(list);
                this.fdL.notifyDataSetChanged();
                this.cCi.setSelection(0);
                this.mHandler.removeCallbacks(this.fdQ);
                this.mHandler.postDelayed(this.fdQ, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void Od() {
        if (this.cCi != null) {
            this.cCi.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.fdQ);
        this.fdN = "";
    }

    public void amU() {
        if (this.fdM != null) {
            this.fdM.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.fdQ);
        this.mHandler.postDelayed(this.fdQ, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.IT != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.fdP == null) {
                    this.fdP = new GetEmotionPidModel();
                }
                this.fdP.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        m mVar = new m();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        mVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.aS("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        mVar.a(EmotionGroupType.NET_SUG);
        mVar.setWidth(emotionImageData.getWidth());
        mVar.setHeight(emotionImageData.getHeight());
        mVar.setUrl(emotionImageData.getPicUrl());
        this.IT.b(new com.baidu.tbadk.editortools.a(24, -1, mVar));
    }

    public void b(i iVar) {
        this.IT = iVar;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean ahH() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void ahK() {
        this.mHandler.removeCallbacks(this.fdQ);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void ahL() {
        this.mHandler.removeCallbacks(this.fdQ);
        this.mHandler.postDelayed(this.fdQ, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
