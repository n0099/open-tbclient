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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools ZS;
    private e dWk;
    private ViewGroup.LayoutParams gdi;
    private HListView hys;
    private List<String> kyO;
    private b kyP;
    private QueryMatchEmotionModel kyQ;
    private String kyR;
    private GetEmotionPidModel kyS;
    private Runnable kyT = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.kyR = "";
            c.this.hys.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.dWk = eVar;
        this.mParent = viewGroup;
        this.gdi = layoutParams;
    }

    public void setData(List<String> list) {
        this.kyO = list;
    }

    public void KW(String str) {
        if (!TextUtils.isEmpty(str) && !x.isEmpty(this.kyO) && this.kyO.contains(str)) {
            KX(str);
        }
    }

    private void KX(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.kyR)) {
            this.kyR = str;
            if (this.kyQ == null) {
                this.kyQ = new QueryMatchEmotionModel(this.dWk);
            }
            this.kyQ.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.kyR)) {
            if (x.isEmpty(list)) {
                this.kyR = "";
            } else if (this.mParent != null && this.gdi != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.hys == null || this.hys.getParent() == null) {
                    this.hys = new HListView(this.dWk.getContext());
                    ao.setBackgroundColor(this.hys, R.color.cp_bg_line_d);
                    this.hys.setDividerWidth(l.getDimens(this.dWk.getPageActivity(), R.dimen.ds7));
                    this.hys.setClipToPadding(false);
                    int dimens = l.getDimens(this.dWk.getPageActivity(), R.dimen.ds10);
                    this.hys.setPadding(dimens, dimens, dimens, dimens);
                    this.hys.setSelector(R.drawable.list_selector_transparent);
                    this.gdi.height = l.getDimens(this.dWk.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.hys, this.gdi);
                    if (this.kyP == null) {
                        this.kyP = new b();
                        this.kyP.a((b.a) this);
                        this.kyP.a((EmotionView.a) this);
                        this.hys.setAdapter((ListAdapter) this.kyP);
                        this.hys.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.kyT);
                                        c.this.mHandler.postDelayed(c.this.kyT, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.kyT);
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
                this.hys.setVisibility(0);
                this.kyP.setData(list);
                this.kyP.notifyDataSetChanged();
                this.hys.setSelection(0);
                this.mHandler.removeCallbacks(this.kyT);
                this.mHandler.postDelayed(this.kyT, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void cRf() {
        if (this.hys != null) {
            this.hys.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.kyT);
        this.kyR = "";
    }

    public void ceq() {
        if (this.kyQ != null) {
            this.kyQ.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.kyT);
        this.mHandler.postDelayed(this.kyT, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.ZS != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.kyS == null) {
                    this.kyS = new GetEmotionPidModel();
                }
                this.kyS.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.ZS.b(new com.baidu.tbadk.editortools.a(24, -1, qVar));
    }

    public void c(EditorTools editorTools) {
        this.ZS = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bXm() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bXp() {
        this.mHandler.removeCallbacks(this.kyT);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bXq() {
        this.mHandler.removeCallbacks(this.kyT);
        this.mHandler.postDelayed(this.kyT, 5000L);
    }
}
