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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.base.c {
    private Resources mResources;
    private View mRootView;
    private a noA;
    private CoverSeekBar nrh;
    private LinearLayout nri;
    private HListView nrj;
    private com.baidu.tieba.video.editvideo.a.a nrk;
    private CoverPendantDragView nrl;

    public c(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.noA = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nrh = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.nrj = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.nrk = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.nrk.a(new a.InterfaceC0862a() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0862a
            public void a(View view, int i, PendantData pendantData) {
                c.this.nrl.a(view, pendantData);
                ar arVar = new ar("c12305");
                arVar.ak("obj_locate", i + 1);
                TiebaStatic.log(arVar);
            }
        });
        this.nrj.setAdapter((ListAdapter) this.nrk);
        this.nrk.setData(dPJ());
        this.nrh.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (c.this.noA.dPy().getDuration() * i) / 1000;
                c.this.nrh.setProgressImage(i, (int) duration);
                c.this.noA.dPy().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onStartTrackingTouch() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onStopTrackingTouch() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> dPJ() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void fR(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, dPJ());
        this.nrk.setData(list);
    }

    public void dPK() {
        this.nrl.setVideoSize(this.noA.dPy().getWidth(), this.noA.dPy().getHeight());
        this.nrl.setVideoLocation(this.noA.dPy().getLeft(), this.noA.dPy().getTop(), this.noA.dPy().getRight(), this.noA.dPy().getBottom());
    }

    public void hideSoftKeyPad() {
        this.nrl.hideSoftKeyPad();
    }

    public String getText() {
        return this.nrl.getText();
    }

    public Bitmap F(Bitmap bitmap) {
        this.nrl.hideSoftKeyPad();
        String text = this.nrl.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.noA.dPy().getWidth();
        int height = this.noA.dPy().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.nrl.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.noA.dPy().getLeft(), this.noA.dPy().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.nrh.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nrh.setData(str);
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    public void dT(View view) {
        this.nrl = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.nrl.setParentViewController(this);
        this.nri = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("video_cover_first_in", true)) {
            this.nri.setVisibility(0);
            this.nri.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.nri.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yb(boolean z) {
        this.nrl.yb(z);
        if (z) {
            this.nrh.seekTo(this.nrh.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.nrh.seekTo(c.this.nrh.getCurrentPosition());
                c.this.noA.dPA();
            }
        }, 500L);
    }

    public void release() {
        if (this.nrh != null) {
            this.nrh.release();
        }
        if (this.nrl != null) {
            this.nrl.onDestroy();
        }
    }
}
