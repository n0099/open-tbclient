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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c {
    private a hbY;
    private CoverSeekBar heJ;
    private LinearLayout heK;
    private HListView heL;
    private com.baidu.tieba.video.editvideo.a.a heM;
    private CoverPendantDragView heN;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.hbY = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.i.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.heJ = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.heL = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.heM = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.heM.a(new a.InterfaceC0241a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0241a
            public void a(View view, int i, PendantData pendantData) {
                b.this.heN.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.r("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.heL.setAdapter((ListAdapter) this.heM);
        this.heM.setData(bCV());
        this.heJ.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.hbY.bCK().getDuration() * i) / 1000;
                b.this.heJ.setProgressImage(i, (int) duration);
                b.this.hbY.bCK().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bCF() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bCG() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bCV() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dK(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bCV());
        this.heM.setData(list);
    }

    public void bCW() {
        this.heN.setVideoSize(this.hbY.bCK().getWidth(), this.hbY.bCK().getHeight());
        this.heN.setVideoLocation(this.hbY.bCK().getLeft(), this.hbY.bCK().getTop(), this.hbY.bCK().getRight(), this.hbY.bCK().getBottom());
    }

    public void bnr() {
        this.heN.bnr();
    }

    public String getText() {
        return this.heN.getText();
    }

    public Bitmap s(Bitmap bitmap) {
        this.heN.bnr();
        String text = this.heN.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.hbY.bCK().getWidth();
        int height = this.hbY.bCK().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.heN.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.hbY.bCK().getLeft(), this.hbY.bCK().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.heJ.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.heJ.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.j(this.mRootView, d.C0142d.cp_bg_line_d);
    }

    public void bC(View view) {
        this.heN = (CoverPendantDragView) view.findViewById(d.g.cover_pendant_view);
        this.heN.setParentViewController(this);
        this.heK = (LinearLayout) view.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.heK.setVisibility(0);
            this.heK.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.heK.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nh(boolean z) {
        this.heN.nh(z);
        if (z) {
            this.heJ.seekTo(this.heJ.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.heJ.seekTo(b.this.heJ.getCurrentPosition());
                b.this.hbY.bCM();
            }
        }, 500L);
    }

    public void release() {
        if (this.heJ != null) {
            this.heJ.release();
        }
        if (this.heN != null) {
            this.heN.onDestroy();
        }
    }
}
