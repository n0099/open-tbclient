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
/* loaded from: classes7.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools Fv;
    private e cRA;
    private ViewGroup.LayoutParams erU;
    private HListView gfp;
    private List<String> iPW;
    private b iPX;
    private QueryMatchEmotionModel iPY;
    private String iPZ;
    private GetEmotionPidModel iQa;
    private Runnable iQb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.iPZ = "";
            c.this.gfp.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.cRA = eVar;
        this.mParent = viewGroup;
        this.erU = layoutParams;
    }

    public void setData(List<String> list) {
        this.iPW = list;
    }

    public void FV(String str) {
        if (!TextUtils.isEmpty(str) && !v.isEmpty(this.iPW) && this.iPW.contains(str)) {
            FW(str);
        }
    }

    private void FW(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.iPZ)) {
            this.iPZ = str;
            if (this.iPY == null) {
                this.iPY = new QueryMatchEmotionModel(this.cRA);
            }
            this.iPY.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.iPZ)) {
            if (v.isEmpty(list)) {
                this.iPZ = "";
            } else if (this.mParent != null && this.erU != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.gfp == null || this.gfp.getParent() == null) {
                    this.gfp = new HListView(this.cRA.getContext());
                    am.setBackgroundColor(this.gfp, R.color.cp_bg_line_d);
                    this.gfp.setDividerWidth(l.getDimens(this.cRA.getPageActivity(), R.dimen.ds7));
                    this.gfp.setClipToPadding(false);
                    int dimens = l.getDimens(this.cRA.getPageActivity(), R.dimen.ds10);
                    this.gfp.setPadding(dimens, dimens, dimens, dimens);
                    this.gfp.setSelector(R.drawable.list_selector_transparent);
                    this.erU.height = l.getDimens(this.cRA.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.gfp, this.erU);
                    if (this.iPX == null) {
                        this.iPX = new b();
                        this.iPX.a((b.a) this);
                        this.iPX.a((EmotionView.a) this);
                        this.gfp.setAdapter((ListAdapter) this.iPX);
                        this.gfp.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.iQb);
                                        c.this.mHandler.postDelayed(c.this.iQb, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.iQb);
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
                this.gfp.setVisibility(0);
                this.iPX.setData(list);
                this.iPX.notifyDataSetChanged();
                this.gfp.setSelection(0);
                this.mHandler.removeCallbacks(this.iQb);
                this.mHandler.postDelayed(this.iQb, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void bxp() {
        if (this.gfp != null) {
            this.gfp.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.iQb);
        this.iPZ = "";
    }

    public void bER() {
        if (this.iPY != null) {
            this.iPY.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.iQb);
        this.mHandler.postDelayed(this.iQb, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Fv != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.iQa == null) {
                    this.iQa = new GetEmotionPidModel();
                }
                this.iQa.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.Fv.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
    }

    public void b(EditorTools editorTools) {
        this.Fv = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean byo() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void byr() {
        this.mHandler.removeCallbacks(this.iQb);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bys() {
        this.mHandler.removeCallbacks(this.iQb);
        this.mHandler.postDelayed(this.iQb, 5000L);
    }
}
