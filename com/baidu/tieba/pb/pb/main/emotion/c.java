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
    private EditorTools Zt;
    private e dJb;
    private ViewGroup.LayoutParams foJ;
    private HListView hgw;
    private List<String> jVY;
    private b jVZ;
    private QueryMatchEmotionModel jWa;
    private String jWb;
    private GetEmotionPidModel jWc;
    private Runnable jWd = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.jWb = "";
            c.this.hgw.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.dJb = eVar;
        this.mParent = viewGroup;
        this.foJ = layoutParams;
    }

    public void setData(List<String> list) {
        this.jVY = list;
    }

    public void JH(String str) {
        if (!TextUtils.isEmpty(str) && !v.isEmpty(this.jVY) && this.jVY.contains(str)) {
            JI(str);
        }
    }

    private void JI(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.jWb)) {
            this.jWb = str;
            if (this.jWa == null) {
                this.jWa = new QueryMatchEmotionModel(this.dJb);
            }
            this.jWa.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.jWb)) {
            if (v.isEmpty(list)) {
                this.jWb = "";
            } else if (this.mParent != null && this.foJ != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.hgw == null || this.hgw.getParent() == null) {
                    this.hgw = new HListView(this.dJb.getContext());
                    am.setBackgroundColor(this.hgw, R.color.cp_bg_line_d);
                    this.hgw.setDividerWidth(l.getDimens(this.dJb.getPageActivity(), R.dimen.ds7));
                    this.hgw.setClipToPadding(false);
                    int dimens = l.getDimens(this.dJb.getPageActivity(), R.dimen.ds10);
                    this.hgw.setPadding(dimens, dimens, dimens, dimens);
                    this.hgw.setSelector(R.drawable.list_selector_transparent);
                    this.foJ.height = l.getDimens(this.dJb.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.hgw, this.foJ);
                    if (this.jVZ == null) {
                        this.jVZ = new b();
                        this.jVZ.a((b.a) this);
                        this.jVZ.a((EmotionView.a) this);
                        this.hgw.setAdapter((ListAdapter) this.jVZ);
                        this.hgw.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.jWd);
                                        c.this.mHandler.postDelayed(c.this.jWd, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.jWd);
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
                this.hgw.setVisibility(0);
                this.jVZ.setData(list);
                this.jVZ.notifyDataSetChanged();
                this.hgw.setSelection(0);
                this.mHandler.removeCallbacks(this.jWd);
                this.mHandler.postDelayed(this.jWd, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void cJa() {
        if (this.hgw != null) {
            this.hgw.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.jWd);
        this.jWb = "";
    }

    public void bXG() {
        if (this.jWa != null) {
            this.jWa.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.jWd);
        this.mHandler.postDelayed(this.jWd, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Zt != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.jWc == null) {
                    this.jWc = new GetEmotionPidModel();
                }
                this.jWc.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.Zt.b(new com.baidu.tbadk.editortools.a(24, -1, qVar));
    }

    public void b(EditorTools editorTools) {
        this.Zt = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bQW() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bQZ() {
        this.mHandler.removeCallbacks(this.jWd);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bRa() {
        this.mHandler.removeCallbacks(this.jWd);
        this.mHandler.postDelayed(this.jWd, 5000L);
    }
}
