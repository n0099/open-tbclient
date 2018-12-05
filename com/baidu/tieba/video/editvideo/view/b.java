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
    private a hBp;
    private CoverSeekBar hEa;
    private LinearLayout hEb;
    private HListView hEc;
    private com.baidu.tieba.video.editvideo.a.a hEd;
    private CoverPendantDragView hEe;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.hBp = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hEa = (CoverSeekBar) this.mRootView.findViewById(e.g.cover_seek_bar);
        this.hEc = (HListView) this.mRootView.findViewById(e.g.pendant_list_view);
        this.hEd = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.hEd.a(new a.InterfaceC0324a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0324a
            public void a(View view, int i, PendantData pendantData) {
                b.this.hEe.a(view, pendantData);
                am amVar = new am("c12305");
                amVar.x("obj_locate", i + 1);
                TiebaStatic.log(amVar);
            }
        });
        this.hEc.setAdapter((ListAdapter) this.hEd);
        this.hEd.setData(bJo());
        this.hEa.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.hBp.bJe().getDuration() * i) / 1000;
                b.this.hEa.setProgressImage(i, (int) duration);
                b.this.hBp.bJe().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bIZ() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bJa() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bJo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dX(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bJo());
        this.hEd.setData(list);
    }

    public void bJp() {
        this.hEe.setVideoSize(this.hBp.bJe().getWidth(), this.hBp.bJe().getHeight());
        this.hEe.setVideoLocation(this.hBp.bJe().getLeft(), this.hBp.bJe().getTop(), this.hBp.bJe().getRight(), this.hBp.bJe().getBottom());
    }

    public void bsR() {
        this.hEe.bsR();
    }

    public String getText() {
        return this.hEe.getText();
    }

    public Bitmap s(Bitmap bitmap) {
        this.hEe.bsR();
        String text = this.hEe.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.hBp.bJe().getWidth();
        int height = this.hBp.bJe().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.hEe.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.hBp.bJe().getLeft(), this.hBp.bJe().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.hEa.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hEa.setData(str);
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public void bU(View view) {
        this.hEe = (CoverPendantDragView) view.findViewById(e.g.cover_pendant_view);
        this.hEe.setParentViewController(this);
        this.hEb = (LinearLayout) view.findViewById(e.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.hEb.setVisibility(0);
            this.hEb.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.hEb.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(SystemScreenshotManager.DELAY_TIME).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nX(boolean z) {
        this.hEe.nX(z);
        if (z) {
            this.hEa.seekTo(this.hEa.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.hEa.seekTo(b.this.hEa.getCurrentPosition());
                b.this.hBp.bJg();
            }
        }, 500L);
    }

    public void release() {
        if (this.hEa != null) {
            this.hEa.release();
        }
        if (this.hEe != null) {
            this.hEe.onDestroy();
        }
    }
}
