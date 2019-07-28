package com.baidu.tieba.video.editvideo.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends com.baidu.adp.base.c {
    private a jvh;
    private CoverSeekBar jxN;
    private LinearLayout jxO;
    private HListView jxP;
    private com.baidu.tieba.video.editvideo.a.a jxQ;
    private CoverPendantDragView jxR;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.jvh = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.jxN = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.jxP = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.jxQ = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.jxQ.a(new a.InterfaceC0421a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0421a
            public void a(View view, int i, PendantData pendantData) {
                b.this.jxR.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.P("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.jxP.setAdapter((ListAdapter) this.jxQ);
        this.jxQ.setData(cvc());
        this.jxN.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.jvh.cuR().getDuration() * i) / 1000;
                b.this.jxN.setProgressImage(i, (int) duration);
                b.this.jvh.cuR().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void cuM() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void cuN() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> cvc() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void ep(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, cvc());
        this.jxQ.setData(list);
    }

    public void cvd() {
        this.jxR.setVideoSize(this.jvh.cuR().getWidth(), this.jvh.cuR().getHeight());
        this.jxR.setVideoLocation(this.jvh.cuR().getLeft(), this.jvh.cuR().getTop(), this.jvh.cuR().getRight(), this.jvh.cuR().getBottom());
    }

    public void cfS() {
        this.jxR.cfS();
    }

    public String getText() {
        return this.jxR.getText();
    }

    public Bitmap B(Bitmap bitmap) {
        this.jxR.cfS();
        String text = this.jxR.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.jvh.cuR().getWidth();
        int height = this.jvh.cuR().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.jxR.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.jvh.cuR().getLeft(), this.jvh.cuR().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.jxN.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jxN.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.l(this.mRootView, R.color.cp_bg_line_d);
    }

    public void cV(View view) {
        this.jxR = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.jxR.setParentViewController(this);
        this.jxO = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("video_cover_first_in", true)) {
            this.jxO.setVisibility(0);
            this.jxO.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.jxO.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rE(boolean z) {
        this.jxR.rE(z);
        if (z) {
            this.jxN.seekTo(this.jxN.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.jxN.seekTo(b.this.jxN.getCurrentPosition());
                b.this.jvh.cuT();
            }
        }, 500L);
    }

    public void release() {
        if (this.jxN != null) {
            this.jxN.release();
        }
        if (this.jxR != null) {
            this.jxR.onDestroy();
        }
    }
}
