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
    private e cVD;
    private ViewGroup.LayoutParams ewf;
    private HListView ghr;
    private List<String> iRt;
    private b iRu;
    private QueryMatchEmotionModel iRv;
    private String iRw;
    private GetEmotionPidModel iRx;
    private Runnable iRy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.iRw = "";
            c.this.ghr.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.cVD = eVar;
        this.mParent = viewGroup;
        this.ewf = layoutParams;
    }

    public void setData(List<String> list) {
        this.iRt = list;
    }

    public void Gk(String str) {
        if (!TextUtils.isEmpty(str) && !v.isEmpty(this.iRt) && this.iRt.contains(str)) {
            Gl(str);
        }
    }

    private void Gl(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.iRw)) {
            this.iRw = str;
            if (this.iRv == null) {
                this.iRv = new QueryMatchEmotionModel(this.cVD);
            }
            this.iRv.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.iRw)) {
            if (v.isEmpty(list)) {
                this.iRw = "";
            } else if (this.mParent != null && this.ewf != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.ghr == null || this.ghr.getParent() == null) {
                    this.ghr = new HListView(this.cVD.getContext());
                    am.setBackgroundColor(this.ghr, R.color.cp_bg_line_d);
                    this.ghr.setDividerWidth(l.getDimens(this.cVD.getPageActivity(), R.dimen.ds7));
                    this.ghr.setClipToPadding(false);
                    int dimens = l.getDimens(this.cVD.getPageActivity(), R.dimen.ds10);
                    this.ghr.setPadding(dimens, dimens, dimens, dimens);
                    this.ghr.setSelector(R.drawable.list_selector_transparent);
                    this.ewf.height = l.getDimens(this.cVD.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.ghr, this.ewf);
                    if (this.iRu == null) {
                        this.iRu = new b();
                        this.iRu.a((b.a) this);
                        this.iRu.a((EmotionView.a) this);
                        this.ghr.setAdapter((ListAdapter) this.iRu);
                        this.ghr.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.iRy);
                                        c.this.mHandler.postDelayed(c.this.iRy, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.iRy);
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
                this.ghr.setVisibility(0);
                this.iRu.setData(list);
                this.iRu.notifyDataSetChanged();
                this.ghr.setSelection(0);
                this.mHandler.removeCallbacks(this.iRy);
                this.mHandler.postDelayed(this.iRy, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void cqN() {
        if (this.ghr != null) {
            this.ghr.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.iRy);
        this.iRw = "";
    }

    public void bGv() {
        if (this.iRv != null) {
            this.iRv.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.iRy);
        this.mHandler.postDelayed(this.iRy, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.FO != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.iRx == null) {
                    this.iRx = new GetEmotionPidModel();
                }
                this.iRx.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
    public boolean bzS() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bzV() {
        this.mHandler.removeCallbacks(this.iRy);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bzW() {
        this.mHandler.removeCallbacks(this.iRy);
        this.mHandler.postDelayed(this.iRy, 5000L);
    }
}
