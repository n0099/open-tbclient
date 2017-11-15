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
    private i Jb;
    private ViewGroup brZ;
    private HListView ctt;
    private List<String> eVq;
    private b eVr;
    private QueryMatchEmotionModel eVs;
    private String eVt;
    private ViewGroup.LayoutParams eVu;
    private GetEmotionPidModel eVv;
    private Runnable eVw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.eVt = "";
            c.this.ctt.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.brZ = viewGroup;
        this.eVu = layoutParams;
    }

    public void setData(List<String> list) {
        this.eVq = list;
    }

    public void pM(String str) {
        if (!TextUtils.isEmpty(str) && !v.v(this.eVq) && this.eVq.contains(str)) {
            pN(str);
        }
    }

    private void pN(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.eVt)) {
            this.eVt = str;
            if (this.eVs == null) {
                this.eVs = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.eVs.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.eVt)) {
            if (v.v(list)) {
                this.eVt = "";
            } else if (this.brZ != null && this.eVu != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.ctt == null || this.ctt.getParent() == null) {
                    this.ctt = new HListView(this.mPageContext.getContext());
                    aj.k(this.ctt, d.C0080d.cp_bg_line_d);
                    this.ctt.setDividerWidth(l.f(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.ctt.setClipToPadding(false);
                    int f = l.f(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.ctt.setPadding(f, f, f, f);
                    this.ctt.setSelector(d.f.list_selector_transparent);
                    this.eVu.height = l.f(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.brZ.addView(this.ctt, this.eVu);
                    if (this.eVr == null) {
                        this.eVr = new b();
                        this.eVr.a((b.a) this);
                        this.eVr.a((EmotionView.a) this);
                        this.ctt.setAdapter((ListAdapter) this.eVr);
                        this.ctt.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.eVw);
                                        c.this.mHandler.postDelayed(c.this.eVw, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.eVw);
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
                this.ctt.setVisibility(0);
                this.eVr.setData(list);
                this.eVr.notifyDataSetChanged();
                this.ctt.setSelection(0);
                this.mHandler.removeCallbacks(this.eVw);
                this.mHandler.postDelayed(this.eVw, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void afH() {
        if (this.ctt != null) {
            this.ctt.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.eVw);
        this.eVt = "";
    }

    public void akY() {
        if (this.eVs != null) {
            this.eVs.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.eVw);
        this.mHandler.postDelayed(this.eVw, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Jb != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.eVv == null) {
                    this.eVv = new GetEmotionPidModel();
                }
                this.eVv.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.Jb.b(new com.baidu.tbadk.editortools.a(24, -1, mVar));
    }

    public void b(i iVar) {
        this.Jb = iVar;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean afW() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void afZ() {
        this.mHandler.removeCallbacks(this.eVw);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aga() {
        this.mHandler.removeCallbacks(this.eVw);
        this.mHandler.postDelayed(this.eVw, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
