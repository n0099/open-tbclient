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
    private e cVC;
    private ViewGroup.LayoutParams ewe;
    private HListView ghp;
    private List<String> iRr;
    private b iRs;
    private QueryMatchEmotionModel iRt;
    private String iRu;
    private GetEmotionPidModel iRv;
    private Runnable iRw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.iRu = "";
            c.this.ghp.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.cVC = eVar;
        this.mParent = viewGroup;
        this.ewe = layoutParams;
    }

    public void setData(List<String> list) {
        this.iRr = list;
    }

    public void Gk(String str) {
        if (!TextUtils.isEmpty(str) && !v.isEmpty(this.iRr) && this.iRr.contains(str)) {
            Gl(str);
        }
    }

    private void Gl(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.iRu)) {
            this.iRu = str;
            if (this.iRt == null) {
                this.iRt = new QueryMatchEmotionModel(this.cVC);
            }
            this.iRt.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.iRu)) {
            if (v.isEmpty(list)) {
                this.iRu = "";
            } else if (this.mParent != null && this.ewe != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.ghp == null || this.ghp.getParent() == null) {
                    this.ghp = new HListView(this.cVC.getContext());
                    am.setBackgroundColor(this.ghp, R.color.cp_bg_line_d);
                    this.ghp.setDividerWidth(l.getDimens(this.cVC.getPageActivity(), R.dimen.ds7));
                    this.ghp.setClipToPadding(false);
                    int dimens = l.getDimens(this.cVC.getPageActivity(), R.dimen.ds10);
                    this.ghp.setPadding(dimens, dimens, dimens, dimens);
                    this.ghp.setSelector(R.drawable.list_selector_transparent);
                    this.ewe.height = l.getDimens(this.cVC.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.ghp, this.ewe);
                    if (this.iRs == null) {
                        this.iRs = new b();
                        this.iRs.a((b.a) this);
                        this.iRs.a((EmotionView.a) this);
                        this.ghp.setAdapter((ListAdapter) this.iRs);
                        this.ghp.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.iRw);
                                        c.this.mHandler.postDelayed(c.this.iRw, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.iRw);
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
                this.ghp.setVisibility(0);
                this.iRs.setData(list);
                this.iRs.notifyDataSetChanged();
                this.ghp.setSelection(0);
                this.mHandler.removeCallbacks(this.iRw);
                this.mHandler.postDelayed(this.iRw, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void cqL() {
        if (this.ghp != null) {
            this.ghp.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.iRw);
        this.iRu = "";
    }

    public void bGt() {
        if (this.iRt != null) {
            this.iRt.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.iRw);
        this.mHandler.postDelayed(this.iRw, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.FO != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.iRv == null) {
                    this.iRv = new GetEmotionPidModel();
                }
                this.iRv.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
    public boolean bzQ() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bzT() {
        this.mHandler.removeCallbacks(this.iRw);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bzU() {
        this.mHandler.removeCallbacks(this.iRw);
        this.mHandler.postDelayed(this.iRw, 5000L);
    }
}
