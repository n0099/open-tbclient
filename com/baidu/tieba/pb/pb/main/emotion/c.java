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
    private EditorTools Zd;
    private e dvg;
    private ViewGroup.LayoutParams faW;
    private HListView gRA;
    private List<String> jDt;
    private b jDu;
    private QueryMatchEmotionModel jDv;
    private String jDw;
    private GetEmotionPidModel jDx;
    private Runnable jDy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.jDw = "";
            c.this.gRA.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.dvg = eVar;
        this.mParent = viewGroup;
        this.faW = layoutParams;
    }

    public void setData(List<String> list) {
        this.jDt = list;
    }

    public void HV(String str) {
        if (!TextUtils.isEmpty(str) && !v.isEmpty(this.jDt) && this.jDt.contains(str)) {
            HW(str);
        }
    }

    private void HW(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.jDw)) {
            this.jDw = str;
            if (this.jDv == null) {
                this.jDv = new QueryMatchEmotionModel(this.dvg);
            }
            this.jDv.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.jDw)) {
            if (v.isEmpty(list)) {
                this.jDw = "";
            } else if (this.mParent != null && this.faW != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.gRA == null || this.gRA.getParent() == null) {
                    this.gRA = new HListView(this.dvg.getContext());
                    am.setBackgroundColor(this.gRA, R.color.cp_bg_line_d);
                    this.gRA.setDividerWidth(l.getDimens(this.dvg.getPageActivity(), R.dimen.ds7));
                    this.gRA.setClipToPadding(false);
                    int dimens = l.getDimens(this.dvg.getPageActivity(), R.dimen.ds10);
                    this.gRA.setPadding(dimens, dimens, dimens, dimens);
                    this.gRA.setSelector(R.drawable.list_selector_transparent);
                    this.faW.height = l.getDimens(this.dvg.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.gRA, this.faW);
                    if (this.jDu == null) {
                        this.jDu = new b();
                        this.jDu.a((b.a) this);
                        this.jDu.a((EmotionView.a) this);
                        this.gRA.setAdapter((ListAdapter) this.jDu);
                        this.gRA.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.jDy);
                                        c.this.mHandler.postDelayed(c.this.jDy, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.jDy);
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
                this.gRA.setVisibility(0);
                this.jDu.setData(list);
                this.jDu.notifyDataSetChanged();
                this.gRA.setSelection(0);
                this.mHandler.removeCallbacks(this.jDy);
                this.mHandler.postDelayed(this.jDy, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void cBN() {
        if (this.gRA != null) {
            this.gRA.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.jDy);
        this.jDw = "";
    }

    public void bRi() {
        if (this.jDv != null) {
            this.jDv.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.jDy);
        this.mHandler.postDelayed(this.jDy, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Zd != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.jDx == null) {
                    this.jDx = new GetEmotionPidModel();
                }
                this.jDx.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.Zd.b(new com.baidu.tbadk.editortools.a(24, -1, qVar));
    }

    public void b(EditorTools editorTools) {
        this.Zd = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bKz() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bKC() {
        this.mHandler.removeCallbacks(this.jDy);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bKD() {
        this.mHandler.removeCallbacks(this.jDy);
        this.mHandler.postDelayed(this.jDy, 5000L);
    }
}
