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
import com.baidu.tbadk.coreExtra.data.t;
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
/* loaded from: classes16.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools aay;
    private e efK;
    private ViewGroup.LayoutParams gpq;
    private HListView hLH;
    private List<String> kOt;
    private b kOu;
    private QueryMatchEmotionModel kOv;
    private String kOw;
    private GetEmotionPidModel kOx;
    private Runnable kOy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.kOw = "";
            c.this.hLH.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.efK = eVar;
        this.mParent = viewGroup;
        this.gpq = layoutParams;
    }

    public void setData(List<String> list) {
        this.kOt = list;
    }

    public void NP(String str) {
        if (!TextUtils.isEmpty(str) && !y.isEmpty(this.kOt) && this.kOt.contains(str)) {
            NQ(str);
        }
    }

    private void NQ(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.kOw)) {
            this.kOw = str;
            if (this.kOv == null) {
                this.kOv = new QueryMatchEmotionModel(this.efK);
            }
            this.kOv.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.kOw)) {
            if (y.isEmpty(list)) {
                this.kOw = "";
            } else if (this.mParent != null && this.gpq != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.hLH == null || this.hLH.getParent() == null) {
                    this.hLH = new HListView(this.efK.getContext());
                    ap.setBackgroundColor(this.hLH, R.color.cp_bg_line_d);
                    this.hLH.setDividerWidth(l.getDimens(this.efK.getPageActivity(), R.dimen.ds7));
                    this.hLH.setClipToPadding(false);
                    int dimens = l.getDimens(this.efK.getPageActivity(), R.dimen.ds10);
                    this.hLH.setPadding(dimens, dimens, dimens, dimens);
                    this.hLH.setSelector(R.drawable.list_selector_transparent);
                    this.gpq.height = l.getDimens(this.efK.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.hLH, this.gpq);
                    if (this.kOu == null) {
                        this.kOu = new b();
                        this.kOu.a((b.a) this);
                        this.kOu.a((EmotionView.a) this);
                        this.hLH.setAdapter((ListAdapter) this.kOu);
                        this.hLH.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.kOy);
                                        c.this.mHandler.postDelayed(c.this.kOy, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.kOy);
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
                this.hLH.setVisibility(0);
                this.kOu.setData(list);
                this.kOu.notifyDataSetChanged();
                this.hLH.setSelection(0);
                this.mHandler.removeCallbacks(this.kOy);
                this.mHandler.postDelayed(this.kOy, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void dbV() {
        if (this.hLH != null) {
            this.hLH.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.kOy);
        this.kOw = "";
    }

    public void coU() {
        if (this.kOv != null) {
            this.kOv.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.kOy);
        this.mHandler.postDelayed(this.kOy, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.aay != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.kOx == null) {
                    this.kOx = new GetEmotionPidModel();
                }
                this.kOx.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        t tVar = new t();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        tVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.toMd5("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        tVar.a(EmotionGroupType.NET_SUG);
        tVar.setWidth(emotionImageData.getWidth());
        tVar.setHeight(emotionImageData.getHeight());
        tVar.setUrl(emotionImageData.getPicUrl());
        this.aay.b(new com.baidu.tbadk.editortools.a(24, -1, tVar));
    }

    public void c(EditorTools editorTools) {
        this.aay = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean chI() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void chL() {
        this.mHandler.removeCallbacks(this.kOy);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void chM() {
        this.mHandler.removeCallbacks(this.kOy);
        this.mHandler.postDelayed(this.kOy, 5000L);
    }
}
