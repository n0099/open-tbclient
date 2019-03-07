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
    private List<String> hza;
    private b hzb;
    private QueryMatchEmotionModel hzc;
    private String hzd;
    private ViewGroup.LayoutParams hze;
    private GetEmotionPidModel hzf;
    private Runnable hzg = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.hzd = "";
            c.this.eOJ.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.hze = layoutParams;
    }

    public void setData(List<String> list) {
        this.hza = list;
    }

    public void Af(String str) {
        if (!TextUtils.isEmpty(str) && !v.T(this.hza) && this.hza.contains(str)) {
            Ag(str);
        }
    }

    private void Ag(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.hzd)) {
            this.hzd = str;
            if (this.hzc == null) {
                this.hzc = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.hzc.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void p(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.hzd)) {
            if (v.T(list)) {
                this.hzd = "";
            } else if (this.mParent != null && this.hze != null) {
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
                    this.hze.height = l.h(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.mParent.addView(this.eOJ, this.hze);
                    if (this.hzb == null) {
                        this.hzb = new b();
                        this.hzb.a((b.a) this);
                        this.hzb.a((EmotionView.a) this);
                        this.eOJ.setAdapter((ListAdapter) this.hzb);
                        this.eOJ.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.hzg);
                                        c.this.mHandler.postDelayed(c.this.hzg, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.hzg);
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
                this.hzb.setData(list);
                this.hzb.notifyDataSetChanged();
                this.eOJ.setSelection(0);
                this.mHandler.removeCallbacks(this.hzg);
                this.mHandler.postDelayed(this.hzg, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void aAB() {
        if (this.eOJ != null) {
            this.eOJ.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.hzg);
        this.hzd = "";
    }

    public void beY() {
        if (this.hzc != null) {
            this.hzc.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.hzg);
        this.mHandler.postDelayed(this.hzg, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.VM != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.hzf == null) {
                    this.hzf = new GetEmotionPidModel();
                }
                this.hzf.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
    public boolean aXM() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aXP() {
        this.mHandler.removeCallbacks(this.hzg);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void aXQ() {
        this.mHandler.removeCallbacks(this.hzg);
        this.mHandler.postDelayed(this.hzg, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
