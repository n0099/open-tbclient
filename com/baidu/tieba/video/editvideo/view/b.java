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
    private a hFH;
    private CoverSeekBar hIs;
    private LinearLayout hIt;
    private HListView hIu;
    private com.baidu.tieba.video.editvideo.a.a hIv;
    private CoverPendantDragView hIw;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.hFH = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hIs = (CoverSeekBar) this.mRootView.findViewById(e.g.cover_seek_bar);
        this.hIu = (HListView) this.mRootView.findViewById(e.g.pendant_list_view);
        this.hIv = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.hIv.a(new a.InterfaceC0323a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0323a
            public void a(View view, int i, PendantData pendantData) {
                b.this.hIw.a(view, pendantData);
                am amVar = new am("c12305");
                amVar.y("obj_locate", i + 1);
                TiebaStatic.log(amVar);
            }
        });
        this.hIu.setAdapter((ListAdapter) this.hIv);
        this.hIv.setData(bKM());
        this.hIs.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.hFH.bKC().getDuration() * i) / 1000;
                b.this.hIs.setProgressImage(i, (int) duration);
                b.this.hFH.bKC().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bKx() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bKy() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bKM() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dZ(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bKM());
        this.hIv.setData(list);
    }

    public void bKN() {
        this.hIw.setVideoSize(this.hFH.bKC().getWidth(), this.hFH.bKC().getHeight());
        this.hIw.setVideoLocation(this.hFH.bKC().getLeft(), this.hFH.bKC().getTop(), this.hFH.bKC().getRight(), this.hFH.bKC().getBottom());
    }

    public void bul() {
        this.hIw.bul();
    }

    public String getText() {
        return this.hIw.getText();
    }

    public Bitmap s(Bitmap bitmap) {
        this.hIw.bul();
        String text = this.hIw.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.hFH.bKC().getWidth();
        int height = this.hFH.bKC().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.hIw.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.hFH.bKC().getLeft(), this.hFH.bKC().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.hIs.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hIs.setData(str);
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public void bX(View view) {
        this.hIw = (CoverPendantDragView) view.findViewById(e.g.cover_pendant_view);
        this.hIw.setParentViewController(this);
        this.hIt = (LinearLayout) view.findViewById(e.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.hIt.setVisibility(0);
            this.hIt.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.hIt.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(SystemScreenshotManager.DELAY_TIME).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void ob(boolean z) {
        this.hIw.ob(z);
        if (z) {
            this.hIs.seekTo(this.hIs.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.hIs.seekTo(b.this.hIs.getCurrentPosition());
                b.this.hFH.bKE();
            }
        }, 500L);
    }

    public void release() {
        if (this.hIs != null) {
            this.hIs.release();
        }
        if (this.hIw != null) {
            this.hIw.onDestroy();
        }
    }
}
