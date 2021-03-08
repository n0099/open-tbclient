package com.baidu.tieba.pb.pb.main.emotion;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.f;
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
import java.util.List;
/* loaded from: classes2.dex */
public class c implements EmotionView.a, b.a, QueryMatchEmotionModel.a {
    private EditorTools ael;
    private f eXa;
    private ViewGroup.LayoutParams hvN;
    private HListView jaZ;
    private ViewGroup mParent;
    private List<String> mfe;
    private b mff;
    private QueryMatchEmotionModel mfg;
    private String mfh;
    private GetEmotionPidModel mfi;
    private Runnable mfj = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.mfh = "";
            c.this.jaZ.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();

    public c(f fVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.eXa = fVar;
        this.mParent = viewGroup;
        this.hvN = layoutParams;
    }

    public void setData(List<String> list) {
        this.mfe = list;
    }

    public void PV(String str) {
        if (!TextUtils.isEmpty(str) && !y.isEmpty(this.mfe) && this.mfe.contains(str)) {
            PW(str);
        }
    }

    private void PW(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.mfh)) {
            this.mfh = str;
            if (this.mfg == null) {
                this.mfg = new QueryMatchEmotionModel(this.eXa);
            }
            this.mfg.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.mfh)) {
            if (y.isEmpty(list)) {
                this.mfh = "";
            } else if (this.mParent != null && this.hvN != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.jaZ == null || this.jaZ.getParent() == null) {
                    this.jaZ = new HListView(this.eXa.getContext());
                    ap.setBackgroundColor(this.jaZ, R.color.CAM_X0201);
                    this.jaZ.setDividerWidth(l.getDimens(this.eXa.getPageActivity(), R.dimen.ds7));
                    this.jaZ.setClipToPadding(false);
                    int dimens = l.getDimens(this.eXa.getPageActivity(), R.dimen.ds10);
                    this.jaZ.setPadding(dimens, dimens, dimens, dimens);
                    this.jaZ.setSelector(R.drawable.list_selector_transparent);
                    this.hvN.height = l.getDimens(this.eXa.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.jaZ, this.hvN);
                    if (this.mff == null) {
                        this.mff = new b();
                        this.mff.a((b.a) this);
                        this.mff.a((EmotionView.a) this);
                        this.jaZ.setAdapter((ListAdapter) this.mff);
                        this.jaZ.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.mfj);
                                        c.this.mHandler.postDelayed(c.this.mfj, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.mfj);
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
                this.jaZ.setVisibility(0);
                this.mff.setData(list);
                this.mff.notifyDataSetChanged();
                this.jaZ.setSelection(0);
                this.mHandler.removeCallbacks(this.mfj);
                this.mHandler.postDelayed(this.mfj, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void dsm() {
        if (this.jaZ != null) {
            this.jaZ.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.mfj);
        this.mfh = "";
    }

    public void cFK() {
        if (this.mfg != null) {
            this.mfg.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.mfj);
        this.mHandler.postDelayed(this.mfj, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.ael != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.mfi == null) {
                    this.mfi = new GetEmotionPidModel();
                }
                this.mfi.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        sb.append(emotionImageData.getPicId()).append(",");
        sb.append(emotionImageData.getWidth()).append(",");
        sb.append(emotionImageData.getHeight()).append(",");
        uVar.setName("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + s.toMd5("meme," + sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
        uVar.a(EmotionGroupType.NET_SUG);
        uVar.setWidth(emotionImageData.getWidth());
        uVar.setHeight(emotionImageData.getHeight());
        uVar.setUrl(emotionImageData.getPicUrl());
        this.ael.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
    }

    public void c(EditorTools editorTools) {
        this.ael = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cyv() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cyy() {
        this.mHandler.removeCallbacks(this.mfj);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cyz() {
        this.mHandler.removeCallbacks(this.mfj);
        this.mHandler.postDelayed(this.mfj, 5000L);
    }
}
