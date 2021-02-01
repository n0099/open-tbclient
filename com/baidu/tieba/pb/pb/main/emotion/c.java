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
    private EditorTools acR;
    private f eVB;
    private ViewGroup.LayoutParams htQ;
    private HListView iZc;
    private ViewGroup mParent;
    private List<String> mcM;
    private b mcN;
    private QueryMatchEmotionModel mcO;
    private String mcP;
    private GetEmotionPidModel mcQ;
    private Runnable mcR = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.mcP = "";
            c.this.iZc.setVisibility(8);
        }
    };
    private Handler mHandler = new Handler();

    public c(f fVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.eVB = fVar;
        this.mParent = viewGroup;
        this.htQ = layoutParams;
    }

    public void setData(List<String> list) {
        this.mcM = list;
    }

    public void PO(String str) {
        if (!TextUtils.isEmpty(str) && !y.isEmpty(this.mcM) && this.mcM.contains(str)) {
            PP(str);
        }
    }

    private void PP(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.mcP)) {
            this.mcP = str;
            if (this.mcO == null) {
                this.mcO = new QueryMatchEmotionModel(this.eVB);
            }
            this.mcO.a(str, this);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && str.equals(this.mcP)) {
            if (y.isEmpty(list)) {
                this.mcP = "";
            } else if (this.mParent != null && this.htQ != null) {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                if (this.iZc == null || this.iZc.getParent() == null) {
                    this.iZc = new HListView(this.eVB.getContext());
                    ap.setBackgroundColor(this.iZc, R.color.CAM_X0201);
                    this.iZc.setDividerWidth(l.getDimens(this.eVB.getPageActivity(), R.dimen.ds7));
                    this.iZc.setClipToPadding(false);
                    int dimens = l.getDimens(this.eVB.getPageActivity(), R.dimen.ds10);
                    this.iZc.setPadding(dimens, dimens, dimens, dimens);
                    this.iZc.setSelector(R.drawable.list_selector_transparent);
                    this.htQ.height = l.getDimens(this.eVB.getPageActivity(), R.dimen.ds136);
                    this.mParent.addView(this.iZc, this.htQ);
                    if (this.mcN == null) {
                        this.mcN = new b();
                        this.mcN.a((b.a) this);
                        this.mcN.a((EmotionView.a) this);
                        this.iZc.setAdapter((ListAdapter) this.mcN);
                        this.iZc.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.2
                            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
                            public void a(AbsHListView absHListView, int i) {
                                switch (i) {
                                    case 0:
                                        c.this.mHandler.removeCallbacks(c.this.mcR);
                                        c.this.mHandler.postDelayed(c.this.mcR, 5000L);
                                        return;
                                    case 1:
                                        c.this.mHandler.removeCallbacks(c.this.mcR);
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
                this.iZc.setVisibility(0);
                this.mcN.setData(list);
                this.mcN.notifyDataSetChanged();
                this.iZc.setSelection(0);
                this.mHandler.removeCallbacks(this.mcR);
                this.mHandler.postDelayed(this.mcR, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.a
    public void onFail(int i, String str) {
    }

    public void drW() {
        if (this.iZc != null) {
            this.iZc.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.mcR);
        this.mcP = "";
    }

    public void cFx() {
        if (this.mcO != null) {
            this.mcO.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.b.a
    public void d(final EmotionImageData emotionImageData) {
        this.mHandler.removeCallbacks(this.mcR);
        this.mHandler.postDelayed(this.mcR, 5000L);
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getPicUrl()) && this.acR != null) {
            if (TextUtils.isEmpty(emotionImageData.getPicId()) || emotionImageData.getPicId().equals("0")) {
                if (this.mcQ == null) {
                    this.mcQ = new GetEmotionPidModel();
                }
                this.mcQ.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.c.3
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
        this.acR.b(new com.baidu.tbadk.editortools.a(24, -1, uVar));
    }

    public void c(EditorTools editorTools) {
        this.acR = editorTools;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean cyi() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public boolean canClick() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cyl() {
        this.mHandler.removeCallbacks(this.mcR);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.a
    public void cym() {
        this.mHandler.removeCallbacks(this.mcR);
        this.mHandler.postDelayed(this.mcR, 5000L);
    }
}
