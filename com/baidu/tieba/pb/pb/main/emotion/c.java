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
    private i axO;
    private ViewGroup cmO;
    private HListView dqX;
    private List<String> fRJ;
    private b fRK;
    private QueryMatchEmotionModel fRL;
    private String fRM;
    private ViewGroup.LayoutParams fRN;
    private GetEmotionPidModel fRO;
    private Runnable fRP = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.fRM = "";
            c.this.dqX.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.cmO = viewGroup;
        this.fRN = layoutParams;
    }

    public void setData(List<String> list) {
        this.fRJ = list;
    }

    public void ql(String str) {
        if (!TextUtils.isEmpty(str) && !v.G(this.fRJ) && this.fRJ.contains(str)) {
            qm(str);
        }
    }

    private void qm(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.fRM)) {
            this.fRM = str;
            if (this.fRL == null) {
                this.fRL = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.fRL.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void l(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.fRM)) {
            if (v.G(list)) {
                this.fRM = "";
            } else if (this.cmO != null && this.fRN != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.dqX == null || this.dqX.getParent() == null) {
                    this.dqX = new HListView(this.mPageContext.getContext());
                    aj.t(this.dqX, d.C0108d.cp_bg_line_d);
                    this.dqX.setDividerWidth(l.s(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.dqX.setClipToPadding(false);
                    int s = l.s(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.dqX.setPadding(s, s, s, s);
                    this.dqX.setSelector(d.f.list_selector_transparent);
                    this.fRN.height = l.s(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.cmO.addView(this.dqX, this.fRN);
                    if (this.fRK == null) {
                        this.fRK = new b();
                        this.fRK.a((b.a) this);
                        this.fRK.a((EmotionView.a) this);
                        this.dqX.setAdapter((ListAdapter) this.fRK);
                        this.dqX.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.fRP);
                                        c.this.mHandler.postDelayed(c.this.fRP, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.fRP);
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
                this.dqX.setVisibility(0);
                this.fRK.setData(list);
                this.fRK.notifyDataSetChanged();
                this.dqX.setSelection(0);
                this.mHandler.removeCallbacks(this.fRP);
                this.mHandler.postDelayed(this.fRP, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void VC() {
        if (this.dqX != null) {
            this.dqX.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.fRP);
        this.fRM = "";
    }

    public void auK() {
        if (this.fRL != null) {
            this.fRL.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.fRP);
        this.mHandler.postDelayed(this.fRP, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.axO != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.fRO == null) {
                    this.fRO = new GetEmotionPidModel();
                }
                this.fRO.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.axO.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
    }

    public void b(i iVar) {
        this.axO = iVar;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean apo() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apr() {
        this.mHandler.removeCallbacks(this.fRP);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aps() {
        this.mHandler.removeCallbacks(this.fRP);
        this.mHandler.postDelayed(this.fRP, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
