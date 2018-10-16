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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends com.baidu.adp.base.c {
    private a hst;
    private CoverSeekBar hve;
    private LinearLayout hvf;
    private HListView hvg;
    private com.baidu.tieba.video.editvideo.a.a hvh;
    private CoverPendantDragView hvi;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.hst = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hve = (CoverSeekBar) this.mRootView.findViewById(e.g.cover_seek_bar);
        this.hvg = (HListView) this.mRootView.findViewById(e.g.pendant_list_view);
        this.hvh = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.hvh.a(new a.InterfaceC0282a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0282a
            public void a(View view, int i, PendantData pendantData) {
                b.this.hvi.a(view, pendantData);
                am amVar = new am("c12305");
                amVar.x("obj_locate", i + 1);
                TiebaStatic.log(amVar);
            }
        });
        this.hvg.setAdapter((ListAdapter) this.hvh);
        this.hvh.setData(bHK());
        this.hve.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.hst.bHA().getDuration() * i) / 1000;
                b.this.hve.setProgressImage(i, (int) duration);
                b.this.hst.bHA().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bHv() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bHw() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bHK() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dV(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bHK());
        this.hvh.setData(list);
    }

    public void bHL() {
        this.hvi.setVideoSize(this.hst.bHA().getWidth(), this.hst.bHA().getHeight());
        this.hvi.setVideoLocation(this.hst.bHA().getLeft(), this.hst.bHA().getTop(), this.hst.bHA().getRight(), this.hst.bHA().getBottom());
    }

    public void brC() {
        this.hvi.brC();
    }

    public String getText() {
        return this.hvi.getText();
    }

    public Bitmap s(Bitmap bitmap) {
        this.hvi.brC();
        String text = this.hvi.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.hst.bHA().getWidth();
        int height = this.hst.bHA().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.hvi.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.hst.bHA().getLeft(), this.hst.bHA().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.hve.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hve.setData(str);
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public void bS(View view) {
        this.hvi = (CoverPendantDragView) view.findViewById(e.g.cover_pendant_view);
        this.hvi.setParentViewController(this);
        this.hvf = (LinearLayout) view.findViewById(e.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.hvf.setVisibility(0);
            this.hvf.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.hvf.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(SystemScreenshotManager.DELAY_TIME).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nH(boolean z) {
        this.hvi.nH(z);
        if (z) {
            this.hve.seekTo(this.hve.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.hve.seekTo(b.this.hve.getCurrentPosition());
                b.this.hst.bHC();
            }
        }, 500L);
    }

    public void release() {
        if (this.hve != null) {
            this.hve.release();
        }
        if (this.hvi != null) {
            this.hvi.onDestroy();
        }
    }
}
