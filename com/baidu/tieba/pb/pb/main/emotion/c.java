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
/* loaded from: classes22.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools abk;
    private e eCK;
    private ViewGroup.LayoutParams gSS;
    private HListView iul;
    private List<String> lyT;
    private b lyU;
    private QueryMatchEmotionModel lyV;
    private String lyW;
    private GetEmotionPidModel lyX;
    private Runnable lyY = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.lyW = "";
            c.this.iul.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.eCK = eVar;
        this.mParent = viewGroup;
        this.gSS = layoutParams;
    }

    public void setData(List<String> list) {
        this.lyT = list;
    }

    public void PE(String str) {
        if (!TextUtils.isEmpty(str) && !y.isEmpty(this.lyT) && this.lyT.contains(str)) {
            PF(str);
        }
    }

    private void PF(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.lyW)) {
            this.lyW = str;
            if (this.lyV == null) {
                this.lyV = new QueryMatchEmotionModel(this.eCK);
            }
            this.lyV.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.lyW)) {
            if (y.isEmpty(list)) {
                this.lyW = "";
            } else if (this.mParent != null && this.gSS != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.iul == null || this.iul.getParent() == null) {
                    this.iul = new HListView(this.eCK.getContext());
                    ap.setBackgroundColor(this.iul, R.color.cp_bg_line_d);
                    this.iul.setDividerWidth(l.getDimens(this.eCK.getPageActivity(), R.dimen.ds7));
                    this.iul.setClipToPadding(false);
                    int dimens = l.getDimens(this.eCK.getPageActivity(), R.dimen.ds10);
                    this.iul.setPadding(dimens, dimens, dimens, dimens);
                    this.iul.setSelector(R.drawable.list_selector_transparent);
                    this.gSS.height = l.getDimens(this.eCK.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.iul, this.gSS);
                    if (this.lyU == null) {
                        this.lyU = new b();
                        this.lyU.a((b.a) this);
                        this.lyU.a((EmotionView.a) this);
                        this.iul.setAdapter((ListAdapter) this.lyU);
                        this.iul.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.lyY);
                                        c.this.mHandler.postDelayed(c.this.lyY, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.lyY);
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
                this.iul.setVisibility(0);
                this.lyU.setData(list);
                this.lyU.notifyDataSetChanged();
                this.iul.setSelection(0);
                this.mHandler.removeCallbacks(this.lyY);
                this.mHandler.postDelayed(this.lyY, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void dmq() {
        if (this.iul != null) {
            this.iul.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.lyY);
        this.lyW = "";
    }

    public void cyM() {
        if (this.lyV != null) {
            this.lyV.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.lyY);
        this.mHandler.postDelayed(this.lyY, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.abk != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.lyX == null) {
                    this.lyX = new GetEmotionPidModel();
                }
                this.lyX.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.abk.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
    }

    public void c(EditorTools editorTools) {
        this.abk = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean crB() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void crE() {
        this.mHandler.removeCallbacks(this.lyY);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void crF() {
        this.mHandler.removeCallbacks(this.lyY);
        this.mHandler.postDelayed(this.lyY, 5000L);
    }
}
