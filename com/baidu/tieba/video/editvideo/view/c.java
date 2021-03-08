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
/* loaded from: classes7.dex */
public class c extends com.baidu.adp.base.d {
    private Resources mResources;
    private View mRootView;
    private a nOu;
    private CoverSeekBar nQZ;
    private LinearLayout nRa;
    private HListView nRb;
    private com.baidu.tieba.video.editvideo.a.a nRc;
    private CoverPendantDragView nRd;

    public c(f fVar, a aVar) {
        super(fVar);
        this.nOu = aVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nQZ = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.nRb = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.nRc = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.nRc.a(new a.InterfaceC0893a() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0893a
            public void a(View view, int i, PendantData pendantData) {
                c.this.nRd.a(view, pendantData);
                ar arVar = new ar("c12305");
                arVar.aq("obj_locate", i + 1);
                TiebaStatic.log(arVar);
            }
        });
        this.nRb.setAdapter((ListAdapter) this.nRc);
        this.nRc.setData(dTE());
        this.nQZ.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (c.this.nOu.dTu().getDuration() * i) / 1000;
                c.this.nQZ.setProgressImage(i, (int) duration);
                c.this.nOu.dTu().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void dTo() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void dTp() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> dTE() {
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
        list.addAll(0, dTE());
        this.nRc.setData(list);
    }

    public void dTF() {
        this.nRd.setVideoSize(this.nOu.dTu().getWidth(), this.nOu.dTu().getHeight());
        this.nRd.setVideoLocation(this.nOu.dTu().getLeft(), this.nOu.dTu().getTop(), this.nOu.dTu().getRight(), this.nOu.dTu().getBottom());
    }

    public void hideSoftKeyPad() {
        this.nRd.hideSoftKeyPad();
    }

    public String getText() {
        return this.nRd.getText();
    }

    public Bitmap F(Bitmap bitmap) {
        this.nRd.hideSoftKeyPad();
        String text = this.nRd.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.nOu.dTu().getWidth();
        int height = this.nOu.dTu().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.nRd.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.nOu.dTu().getLeft(), this.nOu.dTu().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.nQZ.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nQZ.setData(str);
        }
    }

    public void onChangeSkinType(f fVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    public void em(View view) {
        this.nRd = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.nRd.setParentViewController(this);
        this.nRa = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("video_cover_first_in", true)) {
            this.nRa.setVisibility(0);
            this.nRa.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.nRa.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yX(boolean z) {
        this.nRd.yX(z);
        if (z) {
            this.nQZ.seekTo(this.nQZ.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.nQZ.seekTo(c.this.nQZ.getCurrentPosition());
                c.this.nOu.dTw();
            }
        }, 500L);
    }

    public void release() {
        if (this.nQZ != null) {
            this.nQZ.release();
        }
        if (this.nRd != null) {
            this.nRd.onDestroy();
        }
    }
}
