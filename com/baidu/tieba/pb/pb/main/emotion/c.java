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
    private EditorTools CJ;
    private e ceS;
    private HListView fnH;
    private List<String> hXt;
    private b hXu;
    private QueryMatchEmotionModel hXv;
    private String hXw;
    private ViewGroup.LayoutParams hXx;
    private GetEmotionPidModel hXy;
    private Runnable hXz = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.hXw = "";
            c.this.fnH.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.ceS = eVar;
        this.mParent = viewGroup;
        this.hXx = layoutParams;
    }

    public void setData(List<String> list) {
        this.hXt = list;
    }

    public void Ba(String str) {
        if (!TextUtils.isEmpty(str) && !v.isEmpty(this.hXt) && this.hXt.contains(str)) {
            Bb(str);
        }
    }

    private void Bb(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.hXw)) {
            this.hXw = str;
            if (this.hXv == null) {
                this.hXv = new QueryMatchEmotionModel(this.ceS);
            }
            this.hXv.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.hXw)) {
            if (v.isEmpty(list)) {
                this.hXw = "";
            } else if (this.mParent != null && this.hXx != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.fnH == null || this.fnH.getParent() == null) {
                    this.fnH = new HListView(this.ceS.getContext());
                    am.setBackgroundColor(this.fnH, R.color.cp_bg_line_d);
                    this.fnH.setDividerWidth(l.getDimens(this.ceS.getPageActivity(), R.dimen.ds7));
                    this.fnH.setClipToPadding(false);
                    int dimens = l.getDimens(this.ceS.getPageActivity(), R.dimen.ds10);
                    this.fnH.setPadding(dimens, dimens, dimens, dimens);
                    this.fnH.setSelector(R.drawable.list_selector_transparent);
                    this.hXx.height = l.getDimens(this.ceS.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.fnH, this.hXx);
                    if (this.hXu == null) {
                        this.hXu = new b();
                        this.hXu.a((b.a) this);
                        this.hXu.a((EmotionView.a) this);
                        this.fnH.setAdapter((ListAdapter) this.hXu);
                        this.fnH.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.hXz);
                                        c.this.mHandler.postDelayed(c.this.hXz, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.hXz);
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
                this.fnH.setVisibility(0);
                this.hXu.setData(list);
                this.hXu.notifyDataSetChanged();
                this.fnH.setSelection(0);
                this.mHandler.removeCallbacks(this.hXz);
                this.mHandler.postDelayed(this.hXz, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void beT() {
        if (this.fnH != null) {
            this.fnH.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.hXz);
        this.hXw = "";
    }

    public void bmt() {
        if (this.hXv != null) {
            this.hXv.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.hXz);
        this.mHandler.postDelayed(this.hXz, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.CJ != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.hXy == null) {
                    this.hXy = new GetEmotionPidModel();
                }
                this.hXy.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        pVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.toMd5("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        pVar.a(EmotionGroupType.NET_SUG);
        pVar.setWidth(emotionImageData.getWidth());
        pVar.setHeight(emotionImageData.getHeight());
        pVar.setUrl(emotionImageData.getPicUrl());
        this.CJ.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
    }

    public void b(EditorTools editorTools) {
        this.CJ = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bfR() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bfU() {
        this.mHandler.removeCallbacks(this.hXz);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bfV() {
        this.mHandler.removeCallbacks(this.hXz);
        this.mHandler.postDelayed(this.hXz, 5000L);
    }
}
