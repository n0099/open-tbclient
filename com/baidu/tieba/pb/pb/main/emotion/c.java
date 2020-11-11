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
/* loaded from: classes22.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools abk;
    private e eIz;
    private ViewGroup.LayoutParams gYX;
    private HListView iAi;
    private List<String> lEP;
    private b lEQ;
    private QueryMatchEmotionModel lER;
    private String lES;
    private GetEmotionPidModel lET;
    private Runnable lEU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.lES = "";
            c.this.iAi.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.eIz = eVar;
        this.mParent = viewGroup;
        this.gYX = layoutParams;
    }

    public void setData(List<String> list) {
        this.lEP = list;
    }

    public void PV(String str) {
        if (!TextUtils.isEmpty(str) && !y.isEmpty(this.lEP) && this.lEP.contains(str)) {
            PW(str);
        }
    }

    private void PW(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.lES)) {
            this.lES = str;
            if (this.lER == null) {
                this.lER = new QueryMatchEmotionModel(this.eIz);
            }
            this.lER.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.lES)) {
            if (y.isEmpty(list)) {
                this.lES = "";
            } else if (this.mParent != null && this.gYX != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.iAi == null || this.iAi.getParent() == null) {
                    this.iAi = new HListView(this.eIz.getContext());
                    ap.setBackgroundColor(this.iAi, R.color.cp_bg_line_d);
                    this.iAi.setDividerWidth(l.getDimens(this.eIz.getPageActivity(), R.dimen.ds7));
                    this.iAi.setClipToPadding(false);
                    int dimens = l.getDimens(this.eIz.getPageActivity(), R.dimen.ds10);
                    this.iAi.setPadding(dimens, dimens, dimens, dimens);
                    this.iAi.setSelector(R.drawable.list_selector_transparent);
                    this.gYX.height = l.getDimens(this.eIz.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.iAi, this.gYX);
                    if (this.lEQ == null) {
                        this.lEQ = new b();
                        this.lEQ.a((b.a) this);
                        this.lEQ.a((EmotionView.a) this);
                        this.iAi.setAdapter((ListAdapter) this.lEQ);
                        this.iAi.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.lEU);
                                        c.this.mHandler.postDelayed(c.this.lEU, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.lEU);
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
                this.iAi.setVisibility(0);
                this.lEQ.setData(list);
                this.lEQ.notifyDataSetChanged();
                this.iAi.setSelection(0);
                this.mHandler.removeCallbacks(this.lEU);
                this.mHandler.postDelayed(this.lEU, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void doT() {
        if (this.iAi != null) {
            this.iAi.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.lEU);
        this.lES = "";
    }

    public void cBn() {
        if (this.lER != null) {
            this.lER.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.lEU);
        this.mHandler.postDelayed(this.lEU, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.abk != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.lET == null) {
                    this.lET = new GetEmotionPidModel();
                }
                this.lET.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.abk.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
    }

    public void c(EditorTools editorTools) {
        this.abk = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cuc() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cuf() {
        this.mHandler.removeCallbacks(this.lEU);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cug() {
        this.mHandler.removeCallbacks(this.lEU);
        this.mHandler.postDelayed(this.lEU, 5000L);
    }
}
