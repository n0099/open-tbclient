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
    private EditorTools FO;
    private e cVR;
    private ViewGroup.LayoutParams ewO;
    private HListView gin;
    private List<String> iTg;
    private b iTh;
    private QueryMatchEmotionModel iTi;
    private String iTj;
    private GetEmotionPidModel iTk;
    private Runnable iTl = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.iTj = "";
            c.this.gin.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.cVR = eVar;
        this.mParent = viewGroup;
        this.ewO = layoutParams;
    }

    public void setData(List<String> list) {
        this.iTg = list;
    }

    public void Gl(String str) {
        if (!TextUtils.isEmpty(str) && !v.isEmpty(this.iTg) && this.iTg.contains(str)) {
            Gm(str);
        }
    }

    private void Gm(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.iTj)) {
            this.iTj = str;
            if (this.iTi == null) {
                this.iTi = new QueryMatchEmotionModel(this.cVR);
            }
            this.iTi.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.iTj)) {
            if (v.isEmpty(list)) {
                this.iTj = "";
            } else if (this.mParent != null && this.ewO != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.gin == null || this.gin.getParent() == null) {
                    this.gin = new HListView(this.cVR.getContext());
                    am.setBackgroundColor(this.gin, R.color.cp_bg_line_d);
                    this.gin.setDividerWidth(l.getDimens(this.cVR.getPageActivity(), R.dimen.ds7));
                    this.gin.setClipToPadding(false);
                    int dimens = l.getDimens(this.cVR.getPageActivity(), R.dimen.ds10);
                    this.gin.setPadding(dimens, dimens, dimens, dimens);
                    this.gin.setSelector(R.drawable.list_selector_transparent);
                    this.ewO.height = l.getDimens(this.cVR.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.gin, this.ewO);
                    if (this.iTh == null) {
                        this.iTh = new b();
                        this.iTh.a((b.a) this);
                        this.iTh.a((EmotionView.a) this);
                        this.gin.setAdapter((ListAdapter) this.iTh);
                        this.gin.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.iTl);
                                        c.this.mHandler.postDelayed(c.this.iTl, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.iTl);
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
                this.gin.setVisibility(0);
                this.iTh.setData(list);
                this.iTh.notifyDataSetChanged();
                this.gin.setSelection(0);
                this.mHandler.removeCallbacks(this.iTl);
                this.mHandler.postDelayed(this.iTl, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void crj() {
        if (this.gin != null) {
            this.gin.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.iTl);
        this.iTj = "";
    }

    public void bGI() {
        if (this.iTi != null) {
            this.iTi.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.iTl);
        this.mHandler.postDelayed(this.iTl, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.FO != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.iTk == null) {
                    this.iTk = new GetEmotionPidModel();
                }
                this.iTk.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.FO.b(new com.baidu.tbadk.editortools.a(24, -1, qVar));
    }

    public void b(EditorTools editorTools) {
        this.FO = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bzZ() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bAc() {
        this.mHandler.removeCallbacks(this.iTl);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bAd() {
        this.mHandler.removeCallbacks(this.iTl);
        this.mHandler.postDelayed(this.iTl, 5000L);
    }
}
