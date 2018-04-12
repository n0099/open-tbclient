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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c {
    private a gLr;
    private CoverSeekBar gOc;
    private LinearLayout gOd;
    private HListView gOe;
    private com.baidu.tieba.video.editvideo.a.a gOf;
    private CoverPendantDragView gOg;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.gLr = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.i.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gOc = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.gOe = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.gOf = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.gOf.a(new a.InterfaceC0222a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0222a
            public void a(View view2, int i, PendantData pendantData) {
                b.this.gOg.a(view2, pendantData);
                al alVar = new al("c12305");
                alVar.r("obj_locate", i + 1);
                TiebaStatic.log(alVar);
            }
        });
        this.gOe.setAdapter((ListAdapter) this.gOf);
        this.gOf.setData(bxq());
        this.gOc.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.gLr.bxf().getDuration() * i) / 1000;
                b.this.gOc.setProgressImage(i, (int) duration);
                b.this.gLr.bxf().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bxa() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bxb() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bxq() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dz(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bxq());
        this.gOf.setData(list);
    }

    public void bxr() {
        this.gOg.setVideoSize(this.gLr.bxf().getWidth(), this.gLr.bxf().getHeight());
        this.gOg.setVideoLocation(this.gLr.bxf().getLeft(), this.gLr.bxf().getTop(), this.gLr.bxf().getRight(), this.gLr.bxf().getBottom());
    }

    public void bhP() {
        this.gOg.bhP();
    }

    public String getText() {
        return this.gOg.getText();
    }

    public Bitmap t(Bitmap bitmap) {
        this.gOg.bhP();
        String text = this.gOg.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.gLr.bxf().getWidth();
        int height = this.gLr.bxf().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.gOg.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.gLr.bxf().getLeft(), this.gLr.bxf().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.gOc.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gOc.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
    }

    public void by(View view2) {
        this.gOg = (CoverPendantDragView) view2.findViewById(d.g.cover_pendant_view);
        this.gOg.setParentViewController(this);
        this.gOd = (LinearLayout) view2.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.gOd.setVisibility(0);
            this.gOd.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.gOd.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mS(boolean z) {
        this.gOg.mS(z);
        if (z) {
            this.gOc.seekTo(this.gOc.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.gOc.seekTo(b.this.gOc.getCurrentPosition());
                b.this.gLr.bxh();
            }
        }, 500L);
    }

    public void release() {
        if (this.gOc != null) {
            this.gOc.release();
        }
        if (this.gOg != null) {
            this.gOg.onDestroy();
        }
    }
}
