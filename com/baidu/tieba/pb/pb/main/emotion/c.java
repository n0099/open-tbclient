package com.baidu.tieba.pb.pb.main.emotion;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.pb.pb.main.emotion.b;
import com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools JO;
    private ViewGroup bIv;
    private HListView cSs;
    private List<String> fsf;
    private b fsg;
    private QueryMatchEmotionModel fsh;
    private String fsi;
    private ViewGroup.LayoutParams fsj;
    private GetEmotionPidModel fsk;
    private Runnable fsl = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.fsi = "";
            c.this.cSs.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();
    private e mPageContext;

    public c(e eVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.mPageContext = eVar;
        this.bIv = viewGroup;
        this.fsj = layoutParams;
    }

    public void setData(List<String> list) {
        this.fsf = list;
    }

    public void qM(String str) {
        if (!TextUtils.isEmpty(str) && !v.w(this.fsf) && this.fsf.contains(str)) {
            qN(str);
        }
    }

    private void qN(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.fsi)) {
            this.fsi = str;
            if (this.fsh == null) {
                this.fsh = new QueryMatchEmotionModel(this.mPageContext);
            }
            this.fsh.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.fsi)) {
            if (v.w(list)) {
                this.fsi = "";
            } else if (this.bIv != null && this.fsj != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.cSs == null || this.cSs.getParent() == null) {
                    this.cSs = new HListView(this.mPageContext.getContext());
                    ak.j(this.cSs, d.C0126d.cp_bg_line_d);
                    this.cSs.setDividerWidth(l.e(this.mPageContext.getPageActivity(), d.e.ds7));
                    this.cSs.setClipToPadding(false);
                    int e = l.e(this.mPageContext.getPageActivity(), d.e.ds10);
                    this.cSs.setPadding(e, e, e, e);
                    this.cSs.setSelector(d.f.list_selector_transparent);
                    this.fsj.height = l.e(this.mPageContext.getPageActivity(), d.e.ds136);
                    this.bIv.addView(this.cSs, this.fsj);
                    if (this.fsg == null) {
                        this.fsg = new b();
                        this.fsg.a((b.a) this);
                        this.fsg.a((EmotionView.a) this);
                        this.cSs.setAdapter((ListAdapter) this.fsg);
                        this.cSs.setOnScrollListener(new AbsHListView.h() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.h
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.fsl);
                                        c.this.mHandler.postDelayed(c.this.fsl, TbConfig.NOTIFY_SOUND_INTERVAL);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.fsl);
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
                this.cSs.setVisibility(0);
                this.fsg.setData(list);
                this.fsg.notifyDataSetChanged();
                this.cSs.setSelection(0);
                this.mHandler.removeCallbacks(this.fsl);
                this.mHandler.postDelayed(this.fsl, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void OI() {
        if (this.cSs != null) {
            this.cSs.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.fsl);
        this.fsi = "";
    }

    public void arf() {
        if (this.fsh != null) {
            this.fsh.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.fsl);
        this.mHandler.postDelayed(this.fsl, TbConfig.NOTIFY_SOUND_INTERVAL);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.JO != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.fsk == null) {
                    this.fsk = new GetEmotionPidModel();
                }
                this.fsk.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        n nVar = new n();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        nVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + Constants.ACCEPT_TIME_SEPARATOR_SP + sb.toString() + s.aX("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        nVar.a(EmotionGroupType.NET_SUG);
        nVar.setWidth(emotionImageData.getWidth());
        nVar.setHeight(emotionImageData.getHeight());
        nVar.setUrl(emotionImageData.getPicUrl());
        this.JO.b(new com.baidu.tbadk.editortools.a(24, -1, nVar));
    }

    public void b(EditorTools editorTools) {
        this.JO = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean alC() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void alF() {
        this.mHandler.removeCallbacks(this.fsl);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void alG() {
        this.mHandler.removeCallbacks(this.fsl);
        this.mHandler.postDelayed(this.fsl, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
