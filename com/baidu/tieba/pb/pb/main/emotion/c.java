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
/* loaded from: classes4.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools Dl;
    private e cfJ;
    private HListView foy;
    private List<String> hYk;
    private b hYl;
    private QueryMatchEmotionModel hYm;
    private String hYn;
    private ViewGroup.LayoutParams hYo;
    private GetEmotionPidModel hYp;
    private Runnable hYq = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.hYn = "";
            c.this.foy.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private ViewGroup mParent;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.cfJ = eVar;
        this.mParent = viewGroup;
        this.hYo = layoutParams;
    }

    public void setData(List<String> list) {
        this.hYk = list;
    }

    public void Ba(String str) {
        if (!TextUtils.isEmpty(str) && !v.isEmpty(this.hYk) && this.hYk.contains(str)) {
            Bb(str);
        }
    }

    private void Bb(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.hYn)) {
            this.hYn = str;
            if (this.hYm == null) {
                this.hYm = new QueryMatchEmotionModel(this.cfJ);
            }
            this.hYm.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.hYn)) {
            if (v.isEmpty(list)) {
                this.hYn = "";
            } else if (this.mParent != null && this.hYo != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.foy == null || this.foy.getParent() == null) {
                    this.foy = new HListView(this.cfJ.getContext());
                    am.setBackgroundColor(this.foy, R.color.cp_bg_line_d);
                    this.foy.setDividerWidth(l.getDimens(this.cfJ.getPageActivity(), R.dimen.ds7));
                    this.foy.setClipToPadding(false);
                    int dimens = l.getDimens(this.cfJ.getPageActivity(), R.dimen.ds10);
                    this.foy.setPadding(dimens, dimens, dimens, dimens);
                    this.foy.setSelector(R.drawable.list_selector_transparent);
                    this.hYo.height = l.getDimens(this.cfJ.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.foy, this.hYo);
                    if (this.hYl == null) {
                        this.hYl = new b();
                        this.hYl.a((b.a) this);
                        this.hYl.a((EmotionView.a) this);
                        this.foy.setAdapter((ListAdapter) this.hYl);
                        this.foy.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.hYq);
                                        c.this.mHandler.postDelayed(c.this.hYq, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.hYq);
                                        return;
                                    default:
                                        return;
                                }
                            }

                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                            }
                        });
                    }
                }
                this.foy.setVisibility(0);
                this.hYl.setData(list);
                this.hYl.notifyDataSetChanged();
                this.foy.setSelection(0);
                this.mHandler.removeCallbacks(this.hYq);
                this.mHandler.postDelayed(this.hYq, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void beV() {
        if (this.foy != null) {
            this.foy.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.hYq);
        this.hYn = "";
    }

    public void bmv() {
        if (this.hYm != null) {
            this.hYm.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.hYq);
        this.mHandler.postDelayed(this.hYq, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.Dl != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.hYp == null) {
                    this.hYp = new GetEmotionPidModel();
                }
                this.hYp.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.Dl.b(new com.baidu.tbadk.editortools.a(24, -1, pVar));
    }

    public void b(EditorTools editorTools) {
        this.Dl = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean bfT() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bfW() {
        this.mHandler.removeCallbacks(this.hYq);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void bfX() {
        this.mHandler.removeCallbacks(this.hYq);
        this.mHandler.postDelayed(this.hYq, 5000L);
    }
}
