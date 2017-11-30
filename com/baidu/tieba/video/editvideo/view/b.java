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
    private Resources fXC;
    private a gOv;
    private CoverSeekBar gRg;
    private LinearLayout gRh;
    private HListView gRi;
    private com.baidu.tieba.video.editvideo.a.a gRj;
    private CoverPendantDragView gRk;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.gOv = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_cover_layout, (ViewGroup) null);
        this.fXC = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gRg = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.gRi = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.gRj = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.gRj.a(new a.InterfaceC0132a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0132a
            public void a(View view, int i, PendantData pendantData) {
                b.this.gRk.a(view, pendantData);
                ak akVar = new ak("c12305");
                akVar.r("obj_locate", i + 1);
                TiebaStatic.log(akVar);
            }
        });
        this.gRi.setAdapter((ListAdapter) this.gRj);
        this.gRj.setData(bBW());
        this.gRg.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.gOv.bBL().getDuration() * i) / 1000;
                b.this.gRg.cb(i, (int) duration);
                b.this.gOv.bBL().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBF() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBG() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bBW() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dO(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bBW());
        this.gRj.setData(list);
    }

    public void bBX() {
        this.gRk.setVideoSize(this.gOv.bBL().getWidth(), this.gOv.bBL().getHeight());
        this.gRk.i(this.gOv.bBL().getLeft(), this.gOv.bBL().getTop(), this.gOv.bBL().getRight(), this.gOv.bBL().getBottom());
    }

    public void bkn() {
        this.gRk.bkn();
    }

    public String getText() {
        return this.gRk.getText();
    }

    public Bitmap j(Bitmap bitmap) {
        this.gRk.bkn();
        String text = this.gRk.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.gOv.bBL().getWidth();
        int height = this.gOv.bBL().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.gRk.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.gOv.bBL().getLeft(), this.gOv.bBL().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.gRg.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gRg.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.C0082d.cp_bg_line_d);
    }

    public void bI(View view) {
        this.gRk = (CoverPendantDragView) view.findViewById(d.g.cover_pendant_view);
        this.gRk.setParentViewController(this);
        this.gRh = (LinearLayout) view.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.gRh.setVisibility(0);
            this.gRh.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.gRh.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nD(boolean z) {
        this.gRk.nD(z);
        if (z) {
            this.gRg.seekTo(this.gRg.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.gRg.seekTo(b.this.gRg.getCurrentPosition());
                b.this.gOv.bBN();
            }
        }, 500L);
    }

    public void release() {
        if (this.gRg != null) {
            this.gRg.release();
        }
        if (this.gRk != null) {
            this.gRk.onDestroy();
        }
    }
}
