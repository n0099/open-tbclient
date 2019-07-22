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
import com.baidu.tbadk.core.util.am;
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
    private EditorTools TU;
    private HListView fjD;
    private List<String> hWJ;
    private b hWK;
    private QueryMatchEmotionModel hWL;
    private String hWM;
    private ViewGroup.LayoutParams hWN;
    private GetEmotionPidModel hWO;
    private Runnable hWP = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.hWM = "";
            c.this.fjD.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.mParent = viewGroup;
        this.hWN = layoutParams;
    }

    public void setData(List<String> list) {
        this.hWJ = list;
    }

    public void Ch(String str) {
        if (!TextUtils.isEmpty(str) && !v.aa(this.hWJ) && this.hWJ.contains(str)) {
            Ci(str);
        }
    }

    private void Ci(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.hWM)) {
            this.hWM = str;
            if (this.hWL == null) {
                this.hWL = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.hWL.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.hWM)) {
            if (v.aa(list)) {
                this.hWM = "";
            } else if (this.mParent != null && this.hWN != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.fjD == null || this.fjD.getParent() == null) {
                    this.fjD = new HListView(this.mPageContext.getContext());
                    am.l(this.fjD, R.color.cp_bg_line_d);
                    this.fjD.setDividerWidth(l.g(this.mPageContext.getPageActivity(), R.dimen.ds7));
                    this.fjD.setClipToPadding(false);
                    int g = l.g(this.mPageContext.getPageActivity(), R.dimen.ds10);
                    this.fjD.setPadding(g, g, g, g);
                    this.fjD.setSelector(R.drawable.list_selector_transparent);
                    this.hWN.height = l.g(this.mPageContext.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.fjD, this.hWN);
                    if (this.hWK == null) {
                        this.hWK = new b();
                        this.hWK.a((b.a) this);
                        this.hWK.a((EmotionView.a) this);
                        this.fjD.setAdapter((ListAdapter) this.hWK);
                        this.fjD.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.hWP);
                                        c.this.mHandler.postDelayed(c.this.hWP, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.hWP);
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
                this.fjD.setVisibility(0);
                this.hWK.setData(list);
                this.hWK.notifyDataSetChanged();
                this.fjD.setSelection(0);
                this.mHandler.removeCallbacks(this.hWP);
                this.mHandler.postDelayed(this.hWP, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void aIk() {
        if (this.fjD != null) {
            this.fjD.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.hWP);
        this.hWM = "";
    }

    public void bos() {
        if (this.hWL != null) {
            this.hWL.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.hWP);
        this.mHandler.postDelayed(this.hWP, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.TU != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.hWO == null) {
                    this.hWO = new GetEmotionPidModel();
                }
                this.hWO.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        pVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.bn("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        pVar.a(EmotionGroupType.NET_SUG);
        pVar.setWidth(emotionImageData.getWidth());
        pVar.setHeight(emotionImageData.getHeight());
        pVar.setUrl(emotionImageData.getPicUrl());
        this.TU.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
    }

    public void b(EditorTools editorTools) {
        this.TU = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bhj() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bhm() {
        this.mHandler.removeCallbacks(this.hWP);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bhn() {
        this.mHandler.removeCallbacks(this.hWP);
        this.mHandler.postDelayed(this.hWP, 5000L);
    }
}
