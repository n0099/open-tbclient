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
    private a hEA;
    private CoverSeekBar hHl;
    private LinearLayout hHm;
    private HListView hHn;
    private com.baidu.tieba.video.editvideo.a.a hHo;
    private CoverPendantDragView hHp;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.hEA = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hHl = (CoverSeekBar) this.mRootView.findViewById(e.g.cover_seek_bar);
        this.hHn = (HListView) this.mRootView.findViewById(e.g.pendant_list_view);
        this.hHo = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.hHo.a(new a.InterfaceC0324a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0324a
            public void a(View view, int i, PendantData pendantData) {
                b.this.hHp.a(view, pendantData);
                am amVar = new am("c12305");
                amVar.x("obj_locate", i + 1);
                TiebaStatic.log(amVar);
            }
        });
        this.hHn.setAdapter((ListAdapter) this.hHo);
        this.hHo.setData(bKd());
        this.hHl.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.hEA.bJT().getDuration() * i) / 1000;
                b.this.hHl.setProgressImage(i, (int) duration);
                b.this.hEA.bJT().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bJO() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bJP() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bKd() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dY(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bKd());
        this.hHo.setData(list);
    }

    public void bKe() {
        this.hHp.setVideoSize(this.hEA.bJT().getWidth(), this.hEA.bJT().getHeight());
        this.hHp.setVideoLocation(this.hEA.bJT().getLeft(), this.hEA.bJT().getTop(), this.hEA.bJT().getRight(), this.hEA.bJT().getBottom());
    }

    public void btC() {
        this.hHp.btC();
    }

    public String getText() {
        return this.hHp.getText();
    }

    public Bitmap s(Bitmap bitmap) {
        this.hHp.btC();
        String text = this.hHp.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.hEA.bJT().getWidth();
        int height = this.hEA.bJT().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.hHp.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.hEA.bJT().getLeft(), this.hEA.bJT().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.hHl.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hHl.setData(str);
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public void bX(View view) {
        this.hHp = (CoverPendantDragView) view.findViewById(e.g.cover_pendant_view);
        this.hHp.setParentViewController(this);
        this.hHm = (LinearLayout) view.findViewById(e.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.hHm.setVisibility(0);
            this.hHm.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.hHm.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(SystemScreenshotManager.DELAY_TIME).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void oa(boolean z) {
        this.hHp.oa(z);
        if (z) {
            this.hHl.seekTo(this.hHl.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.hHl.seekTo(b.this.hHl.getCurrentPosition());
                b.this.hEA.bJV();
            }
        }, 500L);
    }

    public void release() {
        if (this.hHl != null) {
            this.hHl.release();
        }
        if (this.hHp != null) {
            this.hHp.onDestroy();
        }
    }
}
