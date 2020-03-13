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
    private e cVE;
    private ViewGroup.LayoutParams ews;
    private HListView ghE;
    private List<String> iRF;
    private b iRG;
    private QueryMatchEmotionModel iRH;
    private String iRI;
    private GetEmotionPidModel iRJ;
    private Runnable iRK = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.iRI = "";
            c.this.ghE.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.cVE = eVar;
        this.mParent = viewGroup;
        this.ews = layoutParams;
    }

    public void setData(List<String> list) {
        this.iRF = list;
    }

    public void Gl(String str) {
        if (!TextUtils.isEmpty(str) && !v.isEmpty(this.iRF) && this.iRF.contains(str)) {
            Gm(str);
        }
    }

    private void Gm(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.iRI)) {
            this.iRI = str;
            if (this.iRH == null) {
                this.iRH = new QueryMatchEmotionModel(this.cVE);
            }
            this.iRH.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.iRI)) {
            if (v.isEmpty(list)) {
                this.iRI = "";
            } else if (this.mParent != null && this.ews != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.ghE == null || this.ghE.getParent() == null) {
                    this.ghE = new HListView(this.cVE.getContext());
                    am.setBackgroundColor(this.ghE, R.color.cp_bg_line_d);
                    this.ghE.setDividerWidth(l.getDimens(this.cVE.getPageActivity(), R.dimen.ds7));
                    this.ghE.setClipToPadding(false);
                    int dimens = l.getDimens(this.cVE.getPageActivity(), R.dimen.ds10);
                    this.ghE.setPadding(dimens, dimens, dimens, dimens);
                    this.ghE.setSelector(R.drawable.list_selector_transparent);
                    this.ews.height = l.getDimens(this.cVE.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.ghE, this.ews);
                    if (this.iRG == null) {
                        this.iRG = new b();
                        this.iRG.a((b.a) this);
                        this.iRG.a((EmotionView.a) this);
                        this.ghE.setAdapter((ListAdapter) this.iRG);
                        this.ghE.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.iRK);
                                        c.this.mHandler.postDelayed(c.this.iRK, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.iRK);
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
                this.ghE.setVisibility(0);
                this.iRG.setData(list);
                this.iRG.notifyDataSetChanged();
                this.ghE.setSelection(0);
                this.mHandler.removeCallbacks(this.iRK);
                this.mHandler.postDelayed(this.iRK, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void cqO() {
        if (this.ghE != null) {
            this.ghE.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.iRK);
        this.iRI = "";
    }

    public void bGw() {
        if (this.iRH != null) {
            this.iRH.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.iRK);
        this.mHandler.postDelayed(this.iRK, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.FO != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.iRJ == null) {
                    this.iRJ = new GetEmotionPidModel();
                }
                this.iRJ.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
    public boolean bzT() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bzW() {
        this.mHandler.removeCallbacks(this.iRK);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bzX() {
        this.mHandler.removeCallbacks(this.iRK);
        this.mHandler.postDelayed(this.iRK, 5000L);
    }
}
