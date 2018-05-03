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
    private a gLo;
    private CoverSeekBar gNZ;
    private LinearLayout gOa;
    private HListView gOb;
    private com.baidu.tieba.video.editvideo.a.a gOc;
    private CoverPendantDragView gOd;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.gLo = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.i.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gNZ = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.gOb = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.gOc = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.gOc.a(new a.InterfaceC0222a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0222a
            public void a(View view2, int i, PendantData pendantData) {
                b.this.gOd.a(view2, pendantData);
                al alVar = new al("c12305");
                alVar.r("obj_locate", i + 1);
                TiebaStatic.log(alVar);
            }
        });
        this.gOb.setAdapter((ListAdapter) this.gOc);
        this.gOc.setData(bxq());
        this.gNZ.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.gLo.bxf().getDuration() * i) / 1000;
                b.this.gNZ.setProgressImage(i, (int) duration);
                b.this.gLo.bxf().seekTo((int) duration);
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
        this.gOc.setData(list);
    }

    public void bxr() {
        this.gOd.setVideoSize(this.gLo.bxf().getWidth(), this.gLo.bxf().getHeight());
        this.gOd.setVideoLocation(this.gLo.bxf().getLeft(), this.gLo.bxf().getTop(), this.gLo.bxf().getRight(), this.gLo.bxf().getBottom());
    }

    public void bhP() {
        this.gOd.bhP();
    }

    public String getText() {
        return this.gOd.getText();
    }

    public Bitmap t(Bitmap bitmap) {
        this.gOd.bhP();
        String text = this.gOd.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.gLo.bxf().getWidth();
        int height = this.gLo.bxf().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.gOd.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.gLo.bxf().getLeft(), this.gLo.bxf().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.gNZ.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gNZ.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
    }

    public void by(View view2) {
        this.gOd = (CoverPendantDragView) view2.findViewById(d.g.cover_pendant_view);
        this.gOd.setParentViewController(this);
        this.gOa = (LinearLayout) view2.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.gOa.setVisibility(0);
            this.gOa.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.gOa.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mS(boolean z) {
        this.gOd.mS(z);
        if (z) {
            this.gNZ.seekTo(this.gNZ.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.gNZ.seekTo(b.this.gNZ.getCurrentPosition());
                b.this.gLo.bxh();
            }
        }, 500L);
    }

    public void release() {
        if (this.gNZ != null) {
            this.gNZ.release();
        }
        if (this.gOd != null) {
            this.gOd.onDestroy();
        }
    }
}
