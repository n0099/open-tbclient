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
    private a hpw;
    private CoverSeekBar hsk;
    private LinearLayout hsl;
    private HListView hsm;
    private com.baidu.tieba.video.editvideo.a.a hsn;
    private CoverPendantDragView hso;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.hpw = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hsk = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.hsm = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.hsn = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.hsn.a(new a.InterfaceC0240a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0240a
            public void a(View view, int i, PendantData pendantData) {
                b.this.hso.a(view, pendantData);
                ak akVar = new ak("c12305");
                akVar.s("obj_locate", i + 1);
                TiebaStatic.log(akVar);
            }
        });
        this.hsm.setAdapter((ListAdapter) this.hsn);
        this.hsn.setData(bCh());
        this.hsk.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.hpw.bBW().getDuration() * i) / 1000;
                b.this.hsk.cN(i, (int) duration);
                b.this.hpw.bBW().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBR() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBS() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bCh() {
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
        list.addAll(0, bCh());
        this.hsn.setData(list);
    }

    public void bCi() {
        this.hso.setVideoSize(this.hpw.bBW().getWidth(), this.hpw.bBW().getHeight());
        this.hso.k(this.hpw.bBW().getLeft(), this.hpw.bBW().getTop(), this.hpw.bBW().getRight(), this.hpw.bBW().getBottom());
    }

    public void bmJ() {
        this.hso.bmJ();
    }

    public String getText() {
        return this.hso.getText();
    }

    public Bitmap p(Bitmap bitmap) {
        this.hso.bmJ();
        String text = this.hso.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.hpw.bBW().getWidth();
        int height = this.hpw.bBW().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.hso.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.hpw.bBW().getLeft(), this.hpw.bBW().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.hsk.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hsk.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.t(this.mRootView, d.C0140d.cp_bg_line_d);
    }

    public void cS(View view) {
        this.hso = (CoverPendantDragView) view.findViewById(d.g.cover_pendant_view);
        this.hso.setParentViewController(this);
        this.hsl = (LinearLayout) view.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.hsl.setVisibility(0);
            this.hsl.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.hsl.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nl(boolean z) {
        this.hso.nl(z);
        if (z) {
            this.hsk.seekTo(this.hsk.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.hsk.seekTo(b.this.hsk.getCurrentPosition());
                b.this.hpw.bBY();
            }
        }, 500L);
    }

    public void release() {
        if (this.hsk != null) {
            this.hsk.release();
        }
        if (this.hso != null) {
            this.hso.onDestroy();
        }
    }
}
