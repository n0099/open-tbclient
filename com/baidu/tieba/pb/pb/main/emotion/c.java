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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.q;
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
/* loaded from: classes9.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools ZX;
    private e dPR;
    private ViewGroup.LayoutParams fYb;
    private HListView hsG;
    private List<String> kpO;
    private b kpP;
    private QueryMatchEmotionModel kpQ;
    private String kpR;
    private GetEmotionPidModel kpS;
    private Runnable kpT = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.kpR = "";
            c.this.hsG.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.dPR = eVar;
        this.mParent = viewGroup;
        this.fYb = layoutParams;
    }

    public void setData(List<String> list) {
        this.kpO = list;
    }

    public void Kj(String str) {
        if (!TextUtils.isEmpty(str) && !w.isEmpty(this.kpO) && this.kpO.contains(str)) {
            Kk(str);
        }
    }

    private void Kk(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.kpR)) {
            this.kpR = str;
            if (this.kpQ == null) {
                this.kpQ = new QueryMatchEmotionModel(this.dPR);
            }
            this.kpQ.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.kpR)) {
            if (w.isEmpty(list)) {
                this.kpR = "";
            } else if (this.mParent != null && this.fYb != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.hsG == null || this.hsG.getParent() == null) {
                    this.hsG = new HListView(this.dPR.getContext());
                    an.setBackgroundColor(this.hsG, R.color.cp_bg_line_d);
                    this.hsG.setDividerWidth(l.getDimens(this.dPR.getPageActivity(), R.dimen.ds7));
                    this.hsG.setClipToPadding(false);
                    int dimens = l.getDimens(this.dPR.getPageActivity(), R.dimen.ds10);
                    this.hsG.setPadding(dimens, dimens, dimens, dimens);
                    this.hsG.setSelector(R.drawable.list_selector_transparent);
                    this.fYb.height = l.getDimens(this.dPR.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.hsG, this.fYb);
                    if (this.kpP == null) {
                        this.kpP = new b();
                        this.kpP.a((b.a) this);
                        this.kpP.a((EmotionView.a) this);
                        this.hsG.setAdapter((ListAdapter) this.kpP);
                        this.hsG.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.kpT);
                                        c.this.mHandler.postDelayed(c.this.kpT, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.kpT);
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
                this.hsG.setVisibility(0);
                this.kpP.setData(list);
                this.kpP.notifyDataSetChanged();
                this.hsG.setSelection(0);
                this.mHandler.removeCallbacks(this.kpT);
                this.mHandler.postDelayed(this.kpT, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void cNr() {
        if (this.hsG != null) {
            this.hsG.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.kpT);
        this.kpR = "";
    }

    public void caR() {
        if (this.kpQ != null) {
            this.kpQ.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.kpT);
        this.mHandler.postDelayed(this.kpT, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.ZX != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.kpS == null) {
                    this.kpS = new GetEmotionPidModel();
                }
                this.kpS.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        q qVar = new q();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        qVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.toMd5("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        qVar.a(EmotionGroupType.NET_SUG);
        qVar.setWidth(emotionImageData.getWidth());
        qVar.setHeight(emotionImageData.getHeight());
        qVar.setUrl(emotionImageData.getPicUrl());
        this.ZX.b(new com.baidu.tbadk.editortools.a(24, -1, qVar));
    }

    public void b(EditorTools editorTools) {
        this.ZX = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bTS() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bTV() {
        this.mHandler.removeCallbacks(this.kpT);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bTW() {
        this.mHandler.removeCallbacks(this.kpT);
        this.mHandler.postDelayed(this.kpT, 5000L);
    }
}
