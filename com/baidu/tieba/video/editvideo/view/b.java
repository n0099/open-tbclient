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
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c {
    private a hdl;
    private CoverSeekBar hfY;
    private LinearLayout hfZ;
    private HListView hga;
    private com.baidu.tieba.video.editvideo.a.a hgb;
    private CoverPendantDragView hgc;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.hdl = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hfY = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.hga = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.hgb = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.hgb.a(new a.InterfaceC0241a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0241a
            public void a(View view, int i, PendantData pendantData) {
                b.this.hgc.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.r("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.hga.setAdapter((ListAdapter) this.hgb);
        this.hgb.setData(bBG());
        this.hfY.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.hdl.bBv().getDuration() * i) / 1000;
                b.this.hfY.setProgressImage(i, (int) duration);
                b.this.hdl.bBv().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBq() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBr() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bBG() {
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
        list.addAll(0, bBG());
        this.hgb.setData(list);
    }

    public void bBH() {
        this.hgc.setVideoSize(this.hdl.bBv().getWidth(), this.hdl.bBv().getHeight());
        this.hgc.setVideoLocation(this.hdl.bBv().getLeft(), this.hdl.bBv().getTop(), this.hdl.bBv().getRight(), this.hdl.bBv().getBottom());
    }

    public void blK() {
        this.hgc.blK();
    }

    public String getText() {
        return this.hgc.getText();
    }

    public Bitmap r(Bitmap bitmap) {
        this.hgc.blK();
        String text = this.hgc.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.hdl.bBv().getWidth();
        int height = this.hdl.bBv().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.hgc.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.hdl.bBv().getLeft(), this.hdl.bBv().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.hfY.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hfY.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.j(this.mRootView, d.C0140d.cp_bg_line_d);
    }

    public void bF(View view) {
        this.hgc = (CoverPendantDragView) view.findViewById(d.g.cover_pendant_view);
        this.hgc.setParentViewController(this);
        this.hfZ = (LinearLayout) view.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.hfZ.setVisibility(0);
            this.hfZ.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.hfZ.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mT(boolean z) {
        this.hgc.mT(z);
        if (z) {
            this.hfY.seekTo(this.hfY.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.hfY.seekTo(b.this.hfY.getCurrentPosition());
                b.this.hdl.bBx();
            }
        }, 500L);
    }

    public void release() {
        if (this.hfY != null) {
            this.hfY.release();
        }
        if (this.hgc != null) {
            this.hgc.onDestroy();
        }
    }
}
