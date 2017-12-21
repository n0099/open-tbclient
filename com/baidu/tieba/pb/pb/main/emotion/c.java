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
    private i IS;
    private ViewGroup byL;
    private HListView cCu;
    private List<String> feQ;
    private b feR;
    private QueryMatchEmotionModel feS;
    private String feT;
    private ViewGroup.LayoutParams feU;
    private GetEmotionPidModel feV;
    private Runnable feW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.feT = "";
            c.this.cCu.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.byL = viewGroup;
        this.feU = layoutParams;
    }

    public void setData(List<String> list) {
        this.feQ = list;
    }

    public void qa(String str) {
        if (!TextUtils.isEmpty(str) && !v.w(this.feQ) && this.feQ.contains(str)) {
            qb(str);
        }
    }

    private void qb(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.feT)) {
            this.feT = str;
            if (this.feS == null) {
                this.feS = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.feS.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void l(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.feT)) {
            if (v.w(list)) {
                this.feT = "";
            } else if (this.byL != null && this.feU != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.cCu == null || this.cCu.getParent() == null) {
                    this.cCu = new HListView(this.mPageContext.getContext());
                    aj.k(this.cCu, d.C0095d.cp_bg_line_d);
                    this.cCu.setDividerWidth(l.f(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.cCu.setClipToPadding(false);
                    int f = l.f(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.cCu.setPadding(f, f, f, f);
                    this.cCu.setSelector(d.f.list_selector_transparent);
                    this.feU.height = l.f(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.byL.addView(this.cCu, this.feU);
                    if (this.feR == null) {
                        this.feR = new b();
                        this.feR.a((b.a) this);
                        this.feR.a((EmotionView.a) this);
                        this.cCu.setAdapter((ListAdapter) this.feR);
                        this.cCu.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.feW);
                                        c.this.mHandler.postDelayed(c.this.feW, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.feW);
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
                this.cCu.setVisibility(0);
                this.feR.setData(list);
                this.feR.notifyDataSetChanged();
                this.cCu.setSelection(0);
                this.mHandler.removeCallbacks(this.feW);
                this.mHandler.postDelayed(this.feW, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void Od() {
        if (this.cCu != null) {
            this.cCu.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.feW);
        this.feT = "";
    }

    public void and() {
        if (this.feS != null) {
            this.feS.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.feW);
        this.mHandler.postDelayed(this.feW, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.IS != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.feV == null) {
                    this.feV = new GetEmotionPidModel();
                }
                this.feV.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.IS.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
    }

    public void b(i iVar) {
        this.IS = iVar;
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
        this.mHandler.removeCallbacks(this.feW);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void ahS() {
        this.mHandler.removeCallbacks(this.feW);
        this.mHandler.postDelayed(this.feW, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
