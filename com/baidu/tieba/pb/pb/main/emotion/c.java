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
    private i axQ;
    private ViewGroup cnf;
    private HListView dvS;
    private List<String> fTE;
    private b fTF;
    private QueryMatchEmotionModel fTG;
    private String fTH;
    private ViewGroup.LayoutParams fTI;
    private GetEmotionPidModel fTJ;
    private Runnable fTK = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.fTH = "";
            c.this.dvS.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.cnf = viewGroup;
        this.fTI = layoutParams;
    }

    public void setData(List<String> list) {
        this.fTE = list;
    }

    public void qu(String str) {
        if (!TextUtils.isEmpty(str) && !v.E(this.fTE) && this.fTE.contains(str)) {
            qv(str);
        }
    }

    private void qv(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.fTH)) {
            this.fTH = str;
            if (this.fTG == null) {
                this.fTG = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.fTG.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void l(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.fTH)) {
            if (v.E(list)) {
                this.fTH = "";
            } else if (this.cnf != null && this.fTI != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.dvS == null || this.dvS.getParent() == null) {
                    this.dvS = new HListView(this.mPageContext.getContext());
                    aj.t(this.dvS, d.C0108d.cp_bg_line_d);
                    this.dvS.setDividerWidth(l.s(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.dvS.setClipToPadding(false);
                    int s = l.s(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.dvS.setPadding(s, s, s, s);
                    this.dvS.setSelector(d.f.list_selector_transparent);
                    this.fTI.height = l.s(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.cnf.addView(this.dvS, this.fTI);
                    if (this.fTF == null) {
                        this.fTF = new b();
                        this.fTF.a((b.a) this);
                        this.fTF.a((EmotionView.a) this);
                        this.dvS.setAdapter((ListAdapter) this.fTF);
                        this.dvS.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.fTK);
                                        c.this.mHandler.postDelayed(c.this.fTK, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.fTK);
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
                this.dvS.setVisibility(0);
                this.fTF.setData(list);
                this.fTF.notifyDataSetChanged();
                this.dvS.setSelection(0);
                this.mHandler.removeCallbacks(this.fTK);
                this.mHandler.postDelayed(this.fTK, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void Vs() {
        if (this.dvS != null) {
            this.dvS.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.fTK);
        this.fTH = "";
    }

    public void avS() {
        if (this.fTG != null) {
            this.fTG.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.fTK);
        this.mHandler.postDelayed(this.fTK, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.axQ != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.fTJ == null) {
                    this.fTJ = new GetEmotionPidModel();
                }
                this.fTJ.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.axQ.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
    }

    public void b(i iVar) {
        this.axQ = iVar;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean aqw() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aqz() {
        this.mHandler.removeCallbacks(this.fTK);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aqA() {
        this.mHandler.removeCallbacks(this.fTK);
        this.mHandler.postDelayed(this.fTK, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
