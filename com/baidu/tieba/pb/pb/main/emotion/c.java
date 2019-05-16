package com.baidu.tieba.pb.pb.main.emotion;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.R;
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
    private EditorTools TB;
    private HListView feA;
    private List<String> hQs;
    private b hQt;
    private QueryMatchEmotionModel hQu;
    private String hQv;
    private ViewGroup.LayoutParams hQw;
    private GetEmotionPidModel hQx;
    private Runnable hQy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.hQv = "";
            c.this.feA.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.hQw = layoutParams;
    }

    public void setData(List<String> list) {
        this.hQs = list;
    }

    public void Bt(String str) {
        if (!TextUtils.isEmpty(str) && !v.aa(this.hQs) && this.hQs.contains(str)) {
            Bu(str);
        }
    }

    private void Bu(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.hQv)) {
            this.hQv = str;
            if (this.hQu == null) {
                this.hQu = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.hQu.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.hQv)) {
            if (v.aa(list)) {
                this.hQv = "";
            } else if (this.mParent != null && this.hQw != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.feA == null || this.feA.getParent() == null) {
                    this.feA = new HListView(this.mPageContext.getContext());
                    al.l(this.feA, R.color.cp_bg_line_d);
                    this.feA.setDividerWidth(l.g(this.mPageContext.getPageActivity(), R.dimen.ds7));
                    this.feA.setClipToPadding(false);
                    int g = l.g(this.mPageContext.getPageActivity(), R.dimen.ds10);
                    this.feA.setPadding(g, g, g, g);
                    this.feA.setSelector(R.drawable.list_selector_transparent);
                    this.hQw.height = l.g(this.mPageContext.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.feA, this.hQw);
                    if (this.hQt == null) {
                        this.hQt = new b();
                        this.hQt.a((b.a) this);
                        this.hQt.a((EmotionView.a) this);
                        this.feA.setAdapter((ListAdapter) this.hQt);
                        this.feA.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.hQy);
                                        c.this.mHandler.postDelayed(c.this.hQy, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.hQy);
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
                this.feA.setVisibility(0);
                this.hQt.setData(list);
                this.hQt.notifyDataSetChanged();
                this.feA.setSelection(0);
                this.mHandler.removeCallbacks(this.hQy);
                this.mHandler.postDelayed(this.hQy, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void aGK() {
        if (this.feA != null) {
            this.feA.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.hQy);
        this.hQv = "";
    }

    public void bmo() {
        if (this.hQu != null) {
            this.hQu.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.hQy);
        this.mHandler.postDelayed(this.hQy, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.TB != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.hQx == null) {
                    this.hQx = new GetEmotionPidModel();
                }
                this.hQx.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        pVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.bm("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        pVar.a(EmotionGroupType.NET_SUG);
        pVar.setWidth(emotionImageData.getWidth());
        pVar.setHeight(emotionImageData.getHeight());
        pVar.setUrl(emotionImageData.getPicUrl());
        this.TB.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
    }

    public void b(EditorTools editorTools) {
        this.TB = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bfd() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bfg() {
        this.mHandler.removeCallbacks(this.hQy);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bfh() {
        this.mHandler.removeCallbacks(this.hQy);
        this.mHandler.postDelayed(this.hQy, 5000L);
    }
}
