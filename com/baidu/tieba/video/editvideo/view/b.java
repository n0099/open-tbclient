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
    private a hpH;
    private CoverPendantDragView hsA;
    private CoverSeekBar hsw;
    private LinearLayout hsx;
    private HListView hsy;
    private com.baidu.tieba.video.editvideo.a.a hsz;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.hpH = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hsw = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.hsy = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.hsz = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.hsz.a(new a.InterfaceC0241a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0241a
            public void a(View view, int i, PendantData pendantData) {
                b.this.hsA.a(view, pendantData);
                ak akVar = new ak("c12305");
                akVar.s("obj_locate", i + 1);
                TiebaStatic.log(akVar);
            }
        });
        this.hsy.setAdapter((ListAdapter) this.hsz);
        this.hsz.setData(bCl());
        this.hsw.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.hpH.bCa().getDuration() * i) / 1000;
                b.this.hsw.cN(i, (int) duration);
                b.this.hpH.bCa().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBV() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBW() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bCl() {
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
        list.addAll(0, bCl());
        this.hsz.setData(list);
    }

    public void bCm() {
        this.hsA.setVideoSize(this.hpH.bCa().getWidth(), this.hpH.bCa().getHeight());
        this.hsA.k(this.hpH.bCa().getLeft(), this.hpH.bCa().getTop(), this.hpH.bCa().getRight(), this.hpH.bCa().getBottom());
    }

    public void bmJ() {
        this.hsA.bmJ();
    }

    public String getText() {
        return this.hsA.getText();
    }

    public Bitmap p(Bitmap bitmap) {
        this.hsA.bmJ();
        String text = this.hsA.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.hpH.bCa().getWidth();
        int height = this.hpH.bCa().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.hsA.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.hpH.bCa().getLeft(), this.hpH.bCa().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.hsw.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hsw.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.t(this.mRootView, d.C0141d.cp_bg_line_d);
    }

    public void cS(View view) {
        this.hsA = (CoverPendantDragView) view.findViewById(d.g.cover_pendant_view);
        this.hsA.setParentViewController(this);
        this.hsx = (LinearLayout) view.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.hsx.setVisibility(0);
            this.hsx.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.hsx.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nq(boolean z) {
        this.hsA.nq(z);
        if (z) {
            this.hsw.seekTo(this.hsw.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.hsw.seekTo(b.this.hsw.getCurrentPosition());
                b.this.hpH.bCc();
            }
        }, 500L);
    }

    public void release() {
        if (this.hsw != null) {
            this.hsw.release();
        }
        if (this.hsA != null) {
            this.hsA.onDestroy();
        }
    }
}
