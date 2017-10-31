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
    private ViewGroup brP;
    private HListView cta;
    private List<String> eUV;
    private b eUW;
    private QueryMatchEmotionModel eUX;
    private String eUY;
    private ViewGroup.LayoutParams eUZ;
    private GetEmotionPidModel eVa;
    private Runnable eVb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.eUY = "";
            c.this.cta.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.brP = viewGroup;
        this.eUZ = layoutParams;
    }

    public void setData(List<String> list) {
        this.eUV = list;
    }

    public void pI(String str) {
        if (!TextUtils.isEmpty(str) && !v.v(this.eUV) && this.eUV.contains(str)) {
            pJ(str);
        }
    }

    private void pJ(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.eUY)) {
            this.eUY = str;
            if (this.eUX == null) {
                this.eUX = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.eUX.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void m(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.eUY)) {
            if (v.v(list)) {
                this.eUY = "";
            } else if (this.brP != null && this.eUZ != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.cta == null || this.cta.getParent() == null) {
                    this.cta = new HListView(this.mPageContext.getContext());
                    aj.k(this.cta, d.C0080d.cp_bg_line_d);
                    this.cta.setDividerWidth(l.f(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.cta.setClipToPadding(false);
                    int f = l.f(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.cta.setPadding(f, f, f, f);
                    this.cta.setSelector(d.f.list_selector_transparent);
                    this.eUZ.height = l.f(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.brP.addView(this.cta, this.eUZ);
                    if (this.eUW == null) {
                        this.eUW = new b();
                        this.eUW.a((b.a) this);
                        this.eUW.a((EmotionView.a) this);
                        this.cta.setAdapter((ListAdapter) this.eUW);
                        this.cta.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.eVb);
                                        c.this.mHandler.postDelayed(c.this.eVb, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.eVb);
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
                this.cta.setVisibility(0);
                this.eUW.setData(list);
                this.eUW.notifyDataSetChanged();
                this.cta.setSelection(0);
                this.mHandler.removeCallbacks(this.eVb);
                this.mHandler.postDelayed(this.eVb, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void aft() {
        if (this.cta != null) {
            this.cta.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.eVb);
        this.eUY = "";
    }

    public void akK() {
        if (this.eUX != null) {
            this.eUX.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.eVb);
        this.mHandler.postDelayed(this.eVb, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Jb != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.eVa == null) {
                    this.eVa = new GetEmotionPidModel();
                }
                this.eVa.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        lVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.aS("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        lVar.a(EmotionGroupType.NET_SUG);
        lVar.setWidth(emotionImageData.getWidth());
        lVar.setHeight(emotionImageData.getHeight());
        lVar.setUrl(emotionImageData.getPicUrl());
        this.Jb.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
    }

    public void b(i iVar) {
        this.Jb = iVar;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean afI() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void afL() {
        this.mHandler.removeCallbacks(this.eVb);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void afM() {
        this.mHandler.removeCallbacks(this.eVb);
        this.mHandler.postDelayed(this.eVb, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
