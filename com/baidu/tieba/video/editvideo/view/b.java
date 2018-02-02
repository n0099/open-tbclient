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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c {
    private a hoh;
    private CoverSeekBar hqV;
    private LinearLayout hqW;
    private HListView hqX;
    private com.baidu.tieba.video.editvideo.a.a hqY;
    private CoverPendantDragView hqZ;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.hoh = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hqV = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.hqX = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.hqY = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.hqY.a(new a.InterfaceC0159a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0159a
            public void a(View view, int i, PendantData pendantData) {
                b.this.hqZ.a(view, pendantData);
                ak akVar = new ak("c12305");
                akVar.s("obj_locate", i + 1);
                TiebaStatic.log(akVar);
            }
        });
        this.hqX.setAdapter((ListAdapter) this.hqY);
        this.hqY.setData(bBy());
        this.hqV.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.hoh.bBn().getDuration() * i) / 1000;
                b.this.hqV.cS(i, (int) duration);
                b.this.hoh.bBn().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBi() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBj() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bBy() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dC(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bBy());
        this.hqY.setData(list);
    }

    public void bBz() {
        this.hqZ.setVideoSize(this.hoh.bBn().getWidth(), this.hoh.bBn().getHeight());
        this.hqZ.j(this.hoh.bBn().getLeft(), this.hoh.bBn().getTop(), this.hoh.bBn().getRight(), this.hoh.bBn().getBottom());
    }

    public void blw() {
        this.hqZ.blw();
    }

    public String getText() {
        return this.hqZ.getText();
    }

    public Bitmap m(Bitmap bitmap) {
        this.hqZ.blw();
        String text = this.hqZ.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.hoh.bBn().getWidth();
        int height = this.hoh.bBn().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.hqZ.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.hoh.bBn().getLeft(), this.hoh.bBn().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.hqV.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hqV.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.t(this.mRootView, d.C0108d.cp_bg_line_d);
    }

    public void cT(View view) {
        this.hqZ = (CoverPendantDragView) view.findViewById(d.g.cover_pendant_view);
        this.hqZ.setParentViewController(this);
        this.hqW = (LinearLayout) view.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.hqW.setVisibility(0);
            this.hqW.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.hqW.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void ne(boolean z) {
        this.hqZ.ne(z);
        if (z) {
            this.hqV.seekTo(this.hqV.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.hqV.seekTo(b.this.hqV.getCurrentPosition());
                b.this.hoh.bBp();
            }
        }, 500L);
    }

    public void release() {
        if (this.hqV != null) {
            this.hqV.release();
        }
        if (this.hqZ != null) {
            this.hqZ.onDestroy();
        }
    }
}
