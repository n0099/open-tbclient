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
import com.baidu.tbadk.core.util.w;
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
import java.util.List;
/* loaded from: classes2.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools Qh;
    private HListView dbz;
    private ViewGroup.LayoutParams fDA;
    private GetEmotionPidModel fDB;
    private List<String> fDw;
    private b fDx;
    private QueryMatchEmotionModel fDy;
    private String fDz;
    private e mPageContext;
    private ViewGroup mParent;
    private Runnable fDC = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.fDz = "";
            c.this.dbz.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.fDA = layoutParams;
    }

    public void setData(List<String> list) {
        this.fDw = list;
    }

    public void rA(String str) {
        if (!TextUtils.isEmpty(str) && !w.z(this.fDw) && this.fDw.contains(str)) {
            rB(str);
        }
    }

    private void rB(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.fDz)) {
            this.fDz = str;
            if (this.fDy == null) {
                this.fDy = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.fDy.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.fDz)) {
            if (w.z(list)) {
                this.fDz = "";
            } else if (this.mParent != null && this.fDA != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.dbz == null || this.dbz.getParent() == null) {
                    this.dbz = new HListView(this.mPageContext.getContext());
                    al.j(this.dbz, d.C0141d.cp_bg_line_d);
                    this.dbz.setDividerWidth(l.e(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.dbz.setClipToPadding(false);
                    int e = l.e(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.dbz.setPadding(e, e, e, e);
                    this.dbz.setSelector(d.f.list_selector_transparent);
                    this.fDA.height = l.e(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.mParent.addView(this.dbz, this.fDA);
                    if (this.fDx == null) {
                        this.fDx = new b();
                        this.fDx.a((b.a) this);
                        this.fDx.a((EmotionView.a) this);
                        this.dbz.setAdapter((ListAdapter) this.fDx);
                        this.dbz.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.fDC);
                                        c.this.mHandler.postDelayed(c.this.fDC, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.fDC);
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
                this.dbz.setVisibility(0);
                this.fDx.setData(list);
                this.fDx.notifyDataSetChanged();
                this.dbz.setSelection(0);
                this.mHandler.removeCallbacks(this.fDC);
                this.mHandler.postDelayed(this.fDC, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void Sg() {
        if (this.dbz != null) {
            this.dbz.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.fDC);
        this.fDz = "";
    }

    public void avk() {
        if (this.fDy != null) {
            this.fDy.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.fDC);
        this.mHandler.postDelayed(this.fDC, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Qh != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.fDB == null) {
                    this.fDB = new GetEmotionPidModel();
                }
                this.fDB.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        sb.append(emotionImageData.getPicId()).append(",");
        sb.append(emotionImageData.getWidth()).append(",");
        sb.append(emotionImageData.getHeight()).append(",");
        nVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + s.bj("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        nVar.a(EmotionGroupType.NET_SUG);
        nVar.setWidth(emotionImageData.getWidth());
        nVar.setHeight(emotionImageData.getHeight());
        nVar.setUrl(emotionImageData.getPicUrl());
        this.Qh.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
    }

    public void b(EditorTools editorTools) {
        this.Qh = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean apI() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apL() {
        this.mHandler.removeCallbacks(this.fDC);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void apM() {
        this.mHandler.removeCallbacks(this.fDC);
        this.mHandler.postDelayed(this.fDC, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
