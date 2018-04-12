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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
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
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools JS;
    private ViewGroup bHh;
    private HListView cRo;
    private List<String> fra;
    private b frb;
    private QueryMatchEmotionModel frc;
    private String frd;
    private ViewGroup.LayoutParams fre;
    private GetEmotionPidModel frf;
    private Runnable frg = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.frd = "";
            c.this.cRo.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.bHh = viewGroup;
        this.fre = layoutParams;
    }

    public void setData(List<String> list) {
        this.fra = list;
    }

    public void qJ(String str) {
        if (!TextUtils.isEmpty(str) && !v.w(this.fra) && this.fra.contains(str)) {
            qK(str);
        }
    }

    private void qK(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.frd)) {
            this.frd = str;
            if (this.frc == null) {
                this.frc = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.frc.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.frd)) {
            if (v.w(list)) {
                this.frd = "";
            } else if (this.bHh != null && this.fre != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.cRo == null || this.cRo.getParent() == null) {
                    this.cRo = new HListView(this.mPageContext.getContext());
                    ak.j(this.cRo, d.C0126d.cp_bg_line_d);
                    this.cRo.setDividerWidth(l.e(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.cRo.setClipToPadding(false);
                    int e = l.e(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.cRo.setPadding(e, e, e, e);
                    this.cRo.setSelector(d.f.list_selector_transparent);
                    this.fre.height = l.e(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.bHh.addView(this.cRo, this.fre);
                    if (this.frb == null) {
                        this.frb = new b();
                        this.frb.a((b.a) this);
                        this.frb.a((EmotionView.a) this);
                        this.cRo.setAdapter((ListAdapter) this.frb);
                        this.cRo.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.frg);
                                        c.this.mHandler.postDelayed(c.this.frg, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.frg);
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
                this.cRo.setVisibility(0);
                this.frb.setData(list);
                this.frb.notifyDataSetChanged();
                this.cRo.setSelection(0);
                this.mHandler.removeCallbacks(this.frg);
                this.mHandler.postDelayed(this.frg, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void OL() {
        if (this.cRo != null) {
            this.cRo.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.frg);
        this.frd = "";
    }

    public void arg() {
        if (this.frc != null) {
            this.frc.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.frg);
        this.mHandler.postDelayed(this.frg, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.JS != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.frf == null) {
                    this.frf = new GetEmotionPidModel();
                }
                this.frf.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        nVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.aX("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        nVar.a(EmotionGroupType.NET_SUG);
        nVar.setWidth(emotionImageData.getWidth());
        nVar.setHeight(emotionImageData.getHeight());
        nVar.setUrl(emotionImageData.getPicUrl());
        this.JS.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
    }

    public void b(EditorTools editorTools) {
        this.JS = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean alC() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void alF() {
        this.mHandler.removeCallbacks(this.frg);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void alG() {
        this.mHandler.removeCallbacks(this.frg);
        this.mHandler.postDelayed(this.frg, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
