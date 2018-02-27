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
    private a hpj;
    private CoverSeekBar hrX;
    private LinearLayout hrY;
    private HListView hrZ;
    private com.baidu.tieba.video.editvideo.a.a hsa;
    private CoverPendantDragView hsb;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.hpj = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hrX = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.hrZ = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.hsa = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.hsa.a(new a.InterfaceC0241a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0241a
            public void a(View view, int i, PendantData pendantData) {
                b.this.hsb.a(view, pendantData);
                ak akVar = new ak("c12305");
                akVar.s("obj_locate", i + 1);
                TiebaStatic.log(akVar);
            }
        });
        this.hrZ.setAdapter((ListAdapter) this.hsa);
        this.hsa.setData(bCg());
        this.hrX.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.hpj.bBV().getDuration() * i) / 1000;
                b.this.hrX.cN(i, (int) duration);
                b.this.hpj.bBV().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBQ() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBR() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bCg() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dI(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bCg());
        this.hsa.setData(list);
    }

    public void bCh() {
        this.hsb.setVideoSize(this.hpj.bBV().getWidth(), this.hpj.bBV().getHeight());
        this.hsb.k(this.hpj.bBV().getLeft(), this.hpj.bBV().getTop(), this.hpj.bBV().getRight(), this.hpj.bBV().getBottom());
    }

    public void bmI() {
        this.hsb.bmI();
    }

    public String getText() {
        return this.hsb.getText();
    }

    public Bitmap p(Bitmap bitmap) {
        this.hsb.bmI();
        String text = this.hsb.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.hpj.bBV().getWidth();
        int height = this.hpj.bBV().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.hsb.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.hpj.bBV().getLeft(), this.hpj.bBV().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.hrX.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hrX.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.t(this.mRootView, d.C0141d.cp_bg_line_d);
    }

    public void cS(View view) {
        this.hsb = (CoverPendantDragView) view.findViewById(d.g.cover_pendant_view);
        this.hsb.setParentViewController(this);
        this.hrY = (LinearLayout) view.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.hrY.setVisibility(0);
            this.hrY.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.hrY.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nl(boolean z) {
        this.hsb.nl(z);
        if (z) {
            this.hrX.seekTo(this.hrX.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.hrX.seekTo(b.this.hrX.getCurrentPosition());
                b.this.hpj.bBX();
            }
        }, 500L);
    }

    public void release() {
        if (this.hrX != null) {
            this.hrX.release();
        }
        if (this.hsb != null) {
            this.hsb.onDestroy();
        }
    }
}
