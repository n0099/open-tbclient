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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
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
/* loaded from: classes21.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools abp;
    private e eGT;
    private ViewGroup.LayoutParams gYE;
    private HListView iAX;
    private List<String> lFg;
    private b lFh;
    private QueryMatchEmotionModel lFi;
    private String lFj;
    private GetEmotionPidModel lFk;
    private Runnable lFl = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.lFj = "";
            c.this.iAX.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.eGT = eVar;
        this.mParent = viewGroup;
        this.gYE = layoutParams;
    }

    public void setData(List<String> list) {
        this.lFg = list;
    }

    public void Pr(String str) {
        if (!TextUtils.isEmpty(str) && !y.isEmpty(this.lFg) && this.lFg.contains(str)) {
            Ps(str);
        }
    }

    private void Ps(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.lFj)) {
            this.lFj = str;
            if (this.lFi == null) {
                this.lFi = new QueryMatchEmotionModel(this.eGT);
            }
            this.lFi.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.lFj)) {
            if (y.isEmpty(list)) {
                this.lFj = "";
            } else if (this.mParent != null && this.gYE != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.iAX == null || this.iAX.getParent() == null) {
                    this.iAX = new HListView(this.eGT.getContext());
                    ap.setBackgroundColor(this.iAX, R.color.CAM_X0201);
                    this.iAX.setDividerWidth(l.getDimens(this.eGT.getPageActivity(), R.dimen.ds7));
                    this.iAX.setClipToPadding(false);
                    int dimens = l.getDimens(this.eGT.getPageActivity(), R.dimen.ds10);
                    this.iAX.setPadding(dimens, dimens, dimens, dimens);
                    this.iAX.setSelector(R.drawable.list_selector_transparent);
                    this.gYE.height = l.getDimens(this.eGT.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.iAX, this.gYE);
                    if (this.lFh == null) {
                        this.lFh = new b();
                        this.lFh.a((b.a) this);
                        this.lFh.a((EmotionView.a) this);
                        this.iAX.setAdapter((ListAdapter) this.lFh);
                        this.iAX.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.lFl);
                                        c.this.mHandler.postDelayed(c.this.lFl, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.lFl);
                                        return;
                                    default:
                                        return;
                                }
                            }

                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                            }
                        });
                    }
                }
                this.iAX.setVisibility(0);
                this.lFh.setData(list);
                this.lFh.notifyDataSetChanged();
                this.iAX.setSelection(0);
                this.mHandler.removeCallbacks(this.lFl);
                this.mHandler.postDelayed(this.lFl, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void dos() {
        if (this.iAX != null) {
            this.iAX.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.lFl);
        this.lFj = "";
    }

    public void cAQ() {
        if (this.lFi != null) {
            this.lFi.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.lFl);
        this.mHandler.postDelayed(this.lFl, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.abp != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.lFk == null) {
                    this.lFk = new GetEmotionPidModel();
                }
                this.lFk.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        u uVar = new u();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        uVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.toMd5("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        uVar.a(EmotionGroupType.NET_SUG);
        uVar.setWidth(emotionImageData.getWidth());
        uVar.setHeight(emotionImageData.getHeight());
        uVar.setUrl(emotionImageData.getPicUrl());
        this.abp.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
    }

    public void c(EditorTools editorTools) {
        this.abp = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean ctF() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void ctI() {
        this.mHandler.removeCallbacks(this.lFl);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void ctJ() {
        this.mHandler.removeCallbacks(this.lFl);
        this.mHandler.postDelayed(this.lFl, 5000L);
    }
}
