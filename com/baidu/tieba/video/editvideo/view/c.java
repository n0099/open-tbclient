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
import com.baidu.adp.base.f;
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
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.d {
    private Resources mResources;
    private View mRootView;
    private a nLP;
    private CoverSeekBar nOu;
    private LinearLayout nOv;
    private HListView nOw;
    private com.baidu.tieba.video.editvideo.a.a nOx;
    private CoverPendantDragView nOy;

    public c(f fVar, a aVar) {
        super(fVar);
        this.nLP = aVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nOu = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.nOw = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.nOx = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.nOx.a(new a.InterfaceC0885a() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0885a
            public void a(View view, int i, PendantData pendantData) {
                c.this.nOy.a(view, pendantData);
                ar arVar = new ar("c12305");
                arVar.ap("obj_locate", i + 1);
                TiebaStatic.log(arVar);
            }
        });
        this.nOw.setAdapter((ListAdapter) this.nOx);
        this.nOx.setData(dTo());
        this.nOu.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (c.this.nLP.dTe().getDuration() * i) / 1000;
                c.this.nOu.setProgressImage(i, (int) duration);
                c.this.nLP.dTe().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void dSY() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void dSZ() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> dTo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void fY(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, dTo());
        this.nOx.setData(list);
    }

    public void dTp() {
        this.nOy.setVideoSize(this.nLP.dTe().getWidth(), this.nLP.dTe().getHeight());
        this.nOy.setVideoLocation(this.nLP.dTe().getLeft(), this.nLP.dTe().getTop(), this.nLP.dTe().getRight(), this.nLP.dTe().getBottom());
    }

    public void hideSoftKeyPad() {
        this.nOy.hideSoftKeyPad();
    }

    public String getText() {
        return this.nOy.getText();
    }

    public Bitmap F(Bitmap bitmap) {
        this.nOy.hideSoftKeyPad();
        String text = this.nOy.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.nLP.dTe().getWidth();
        int height = this.nLP.dTe().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.nOy.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.nLP.dTe().getLeft(), this.nLP.dTe().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.nOu.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nOu.setData(str);
        }
    }

    public void onChangeSkinType(f fVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    public void em(View view) {
        this.nOy = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.nOy.setParentViewController(this);
        this.nOv = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("video_cover_first_in", true)) {
            this.nOv.setVisibility(0);
            this.nOv.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.nOv.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yY(boolean z) {
        this.nOy.yY(z);
        if (z) {
            this.nOu.seekTo(this.nOu.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.nOu.seekTo(c.this.nOu.getCurrentPosition());
                c.this.nLP.dTg();
            }
        }, 500L);
    }

    public void release() {
        if (this.nOu != null) {
            this.nOu.release();
        }
        if (this.nOy != null) {
            this.nOy.onDestroy();
        }
    }
}
