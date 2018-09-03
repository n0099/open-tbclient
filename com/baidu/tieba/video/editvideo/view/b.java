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
import com.baidu.tieba.f;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c {
    private a hdm;
    private CoverSeekBar hfZ;
    private LinearLayout hga;
    private HListView hgb;
    private com.baidu.tieba.video.editvideo.a.a hgc;
    private CoverPendantDragView hgd;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.hdm = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(f.h.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hfZ = (CoverSeekBar) this.mRootView.findViewById(f.g.cover_seek_bar);
        this.hgb = (HListView) this.mRootView.findViewById(f.g.pendant_list_view);
        this.hgc = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.hgc.a(new a.InterfaceC0241a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0241a
            public void a(View view, int i, PendantData pendantData) {
                b.this.hgd.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.r("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.hgb.setAdapter((ListAdapter) this.hgc);
        this.hgc.setData(bBI());
        this.hfZ.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.hdm.bBx().getDuration() * i) / 1000;
                b.this.hfZ.setProgressImage(i, (int) duration);
                b.this.hdm.bBx().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBs() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBt() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bBI() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dG(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bBI());
        this.hgc.setData(list);
    }

    public void bBJ() {
        this.hgd.setVideoSize(this.hdm.bBx().getWidth(), this.hdm.bBx().getHeight());
        this.hgd.setVideoLocation(this.hdm.bBx().getLeft(), this.hdm.bBx().getTop(), this.hdm.bBx().getRight(), this.hdm.bBx().getBottom());
    }

    public void blH() {
        this.hgd.blH();
    }

    public String getText() {
        return this.hgd.getText();
    }

    public Bitmap r(Bitmap bitmap) {
        this.hgd.blH();
        String text = this.hgd.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.hdm.bBx().getWidth();
        int height = this.hdm.bBx().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.hgd.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.hdm.bBx().getLeft(), this.hdm.bBx().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.hfZ.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hfZ.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.j(this.mRootView, f.d.cp_bg_line_d);
    }

    public void bF(View view) {
        this.hgd = (CoverPendantDragView) view.findViewById(f.g.cover_pendant_view);
        this.hgd.setParentViewController(this);
        this.hga = (LinearLayout) view.findViewById(f.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.hga.setVisibility(0);
            this.hga.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.hga.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mT(boolean z) {
        this.hgd.mT(z);
        if (z) {
            this.hfZ.seekTo(this.hfZ.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.hfZ.seekTo(b.this.hfZ.getCurrentPosition());
                b.this.hdm.bBz();
            }
        }, 500L);
    }

    public void release() {
        if (this.hfZ != null) {
            this.hfZ.release();
        }
        if (this.hgd != null) {
            this.hgd.onDestroy();
        }
    }
}
