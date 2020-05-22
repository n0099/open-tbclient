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
    private ViewGroup.LayoutParams foy;
    private HListView hgl;
    private List<String> jUS;
    private b jUT;
    private QueryMatchEmotionModel jUU;
    private String jUV;
    private GetEmotionPidModel jUW;
    private Runnable jUX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.jUV = "";
            c.this.hgl.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.dJb = eVar;
        this.mParent = viewGroup;
        this.foy = layoutParams;
    }

    public void setData(List<String> list) {
        this.jUS = list;
    }

    public void JG(String str) {
        if (!TextUtils.isEmpty(str) && !v.isEmpty(this.jUS) && this.jUS.contains(str)) {
            JH(str);
        }
    }

    private void JH(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.jUV)) {
            this.jUV = str;
            if (this.jUU == null) {
                this.jUU = new QueryMatchEmotionModel(this.dJb);
            }
            this.jUU.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.jUV)) {
            if (v.isEmpty(list)) {
                this.jUV = "";
            } else if (this.mParent != null && this.foy != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.hgl == null || this.hgl.getParent() == null) {
                    this.hgl = new HListView(this.dJb.getContext());
                    am.setBackgroundColor(this.hgl, R.color.cp_bg_line_d);
                    this.hgl.setDividerWidth(l.getDimens(this.dJb.getPageActivity(), R.dimen.ds7));
                    this.hgl.setClipToPadding(false);
                    int dimens = l.getDimens(this.dJb.getPageActivity(), R.dimen.ds10);
                    this.hgl.setPadding(dimens, dimens, dimens, dimens);
                    this.hgl.setSelector(R.drawable.list_selector_transparent);
                    this.foy.height = l.getDimens(this.dJb.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.hgl, this.foy);
                    if (this.jUT == null) {
                        this.jUT = new b();
                        this.jUT.a((b.a) this);
                        this.jUT.a((EmotionView.a) this);
                        this.hgl.setAdapter((ListAdapter) this.jUT);
                        this.hgl.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.jUX);
                                        c.this.mHandler.postDelayed(c.this.jUX, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.jUX);
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
                this.hgl.setVisibility(0);
                this.jUT.setData(list);
                this.jUT.notifyDataSetChanged();
                this.hgl.setSelection(0);
                this.mHandler.removeCallbacks(this.jUX);
                this.mHandler.postDelayed(this.jUX, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void cIK() {
        if (this.hgl != null) {
            this.hgl.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.jUX);
        this.jUV = "";
    }

    public void bXE() {
        if (this.jUU != null) {
            this.jUU.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.jUX);
        this.mHandler.postDelayed(this.jUX, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Zt != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.jUW == null) {
                    this.jUW = new GetEmotionPidModel();
                }
                this.jUW.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
    public boolean bQU() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bQX() {
        this.mHandler.removeCallbacks(this.jUX);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bQY() {
        this.mHandler.removeCallbacks(this.jUX);
        this.mHandler.postDelayed(this.jUX, 5000L);
    }
}
