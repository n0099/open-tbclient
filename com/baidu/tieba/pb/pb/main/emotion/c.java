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
    private EditorTools aaS;
    private e eid;
    private ViewGroup.LayoutParams gsI;
    private HListView hSO;
    private List<String> kXc;
    private b kXd;
    private QueryMatchEmotionModel kXe;
    private String kXf;
    private GetEmotionPidModel kXg;
    private Runnable kXh = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.kXf = "";
            c.this.hSO.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.eid = eVar;
        this.mParent = viewGroup;
        this.gsI = layoutParams;
    }

    public void setData(List<String> list) {
        this.kXc = list;
    }

    public void Or(String str) {
        if (!TextUtils.isEmpty(str) && !y.isEmpty(this.kXc) && this.kXc.contains(str)) {
            Os(str);
        }
    }

    private void Os(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.kXf)) {
            this.kXf = str;
            if (this.kXe == null) {
                this.kXe = new QueryMatchEmotionModel(this.eid);
            }
            this.kXe.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.kXf)) {
            if (y.isEmpty(list)) {
                this.kXf = "";
            } else if (this.mParent != null && this.gsI != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.hSO == null || this.hSO.getParent() == null) {
                    this.hSO = new HListView(this.eid.getContext());
                    ap.setBackgroundColor(this.hSO, R.color.cp_bg_line_d);
                    this.hSO.setDividerWidth(l.getDimens(this.eid.getPageActivity(), R.dimen.ds7));
                    this.hSO.setClipToPadding(false);
                    int dimens = l.getDimens(this.eid.getPageActivity(), R.dimen.ds10);
                    this.hSO.setPadding(dimens, dimens, dimens, dimens);
                    this.hSO.setSelector(R.drawable.list_selector_transparent);
                    this.gsI.height = l.getDimens(this.eid.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.hSO, this.gsI);
                    if (this.kXd == null) {
                        this.kXd = new b();
                        this.kXd.a((b.a) this);
                        this.kXd.a((EmotionView.a) this);
                        this.hSO.setAdapter((ListAdapter) this.kXd);
                        this.hSO.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.kXh);
                                        c.this.mHandler.postDelayed(c.this.kXh, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.kXh);
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
                this.hSO.setVisibility(0);
                this.kXd.setData(list);
                this.kXd.notifyDataSetChanged();
                this.hSO.setSelection(0);
                this.mHandler.removeCallbacks(this.kXh);
                this.mHandler.postDelayed(this.kXh, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void dfA() {
        if (this.hSO != null) {
            this.hSO.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.kXh);
        this.kXf = "";
    }

    public void csi() {
        if (this.kXe != null) {
            this.kXe.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.kXh);
        this.mHandler.postDelayed(this.kXh, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.aaS != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.kXg == null) {
                    this.kXg = new GetEmotionPidModel();
                }
                this.kXg.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.aaS.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
    }

    public void c(EditorTools editorTools) {
        this.aaS = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean ckW() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void ckZ() {
        this.mHandler.removeCallbacks(this.kXh);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cla() {
        this.mHandler.removeCallbacks(this.kXh);
        this.mHandler.postDelayed(this.kXh, 5000L);
    }
}
