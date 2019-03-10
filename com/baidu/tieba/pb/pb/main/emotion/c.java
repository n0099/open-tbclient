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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
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
/* loaded from: classes4.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools VM;
    private HListView eOJ;
    private List<String> hzb;
    private b hzc;
    private QueryMatchEmotionModel hzd;
    private String hze;
    private ViewGroup.LayoutParams hzf;
    private GetEmotionPidModel hzg;
    private Runnable hzh = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.hze = "";
            c.this.eOJ.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.hzf = layoutParams;
    }

    public void setData(List<String> list) {
        this.hzb = list;
    }

    public void Ag(String str) {
        if (!TextUtils.isEmpty(str) && !v.T(this.hzb) && this.hzb.contains(str)) {
            Ah(str);
        }
    }

    private void Ah(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.hze)) {
            this.hze = str;
            if (this.hzd == null) {
                this.hzd = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.hzd.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void p(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.hze)) {
            if (v.T(list)) {
                this.hze = "";
            } else if (this.mParent != null && this.hzf != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.eOJ == null || this.eOJ.getParent() == null) {
                    this.eOJ = new HListView(this.mPageContext.getContext());
                    al.l(this.eOJ, d.C0236d.cp_bg_line_d);
                    this.eOJ.setDividerWidth(l.h(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.eOJ.setClipToPadding(false);
                    int h = l.h(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.eOJ.setPadding(h, h, h, h);
                    this.eOJ.setSelector(d.f.list_selector_transparent);
                    this.hzf.height = l.h(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.mParent.addView(this.eOJ, this.hzf);
                    if (this.hzc == null) {
                        this.hzc = new b();
                        this.hzc.a((b.a) this);
                        this.hzc.a((EmotionView.a) this);
                        this.eOJ.setAdapter((ListAdapter) this.hzc);
                        this.eOJ.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.hzh);
                                        c.this.mHandler.postDelayed(c.this.hzh, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.hzh);
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
                this.eOJ.setVisibility(0);
                this.hzc.setData(list);
                this.hzc.notifyDataSetChanged();
                this.eOJ.setSelection(0);
                this.mHandler.removeCallbacks(this.hzh);
                this.mHandler.postDelayed(this.hzh, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void aAC() {
        if (this.eOJ != null) {
            this.eOJ.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.hzh);
        this.hze = "";
    }

    public void beZ() {
        if (this.hzd != null) {
            this.hzd.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.hzh);
        this.mHandler.postDelayed(this.hzh, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.VM != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.hzg == null) {
                    this.hzg = new GetEmotionPidModel();
                }
                this.hzg.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        p pVar = new p();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        pVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.bC("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        pVar.a(EmotionGroupType.NET_SUG);
        pVar.setWidth(emotionImageData.getWidth());
        pVar.setHeight(emotionImageData.getHeight());
        pVar.setUrl(emotionImageData.getPicUrl());
        this.VM.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
    }

    public void b(EditorTools editorTools) {
        this.VM = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean aXN() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aXQ() {
        this.mHandler.removeCallbacks(this.hzh);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aXR() {
        this.mHandler.removeCallbacks(this.hzh);
        this.mHandler.postDelayed(this.hzh, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
