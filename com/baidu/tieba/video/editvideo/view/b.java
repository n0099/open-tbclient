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
    private a hnN;
    private CoverSeekBar hqB;
    private LinearLayout hqC;
    private HListView hqD;
    private com.baidu.tieba.video.editvideo.a.a hqE;
    private CoverPendantDragView hqF;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.hnN = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hqB = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.hqD = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.hqE = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.hqE.a(new a.InterfaceC0158a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0158a
            public void a(View view, int i, PendantData pendantData) {
                b.this.hqF.a(view, pendantData);
                ak akVar = new ak("c12305");
                akVar.s("obj_locate", i + 1);
                TiebaStatic.log(akVar);
            }
        });
        this.hqD.setAdapter((ListAdapter) this.hqE);
        this.hqE.setData(bBw());
        this.hqB.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.hnN.bBl().getDuration() * i) / 1000;
                b.this.hqB.cS(i, (int) duration);
                b.this.hnN.bBl().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBg() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bBh() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bBw() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dC(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bBw());
        this.hqE.setData(list);
    }

    public void bBx() {
        this.hqF.setVideoSize(this.hnN.bBl().getWidth(), this.hnN.bBl().getHeight());
        this.hqF.j(this.hnN.bBl().getLeft(), this.hnN.bBl().getTop(), this.hnN.bBl().getRight(), this.hnN.bBl().getBottom());
    }

    public void blv() {
        this.hqF.blv();
    }

    public String getText() {
        return this.hqF.getText();
    }

    public Bitmap m(Bitmap bitmap) {
        this.hqF.blv();
        String text = this.hqF.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.hnN.bBl().getWidth();
        int height = this.hnN.bBl().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.hqF.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.hnN.bBl().getLeft(), this.hnN.bBl().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.hqB.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hqB.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.t(this.mRootView, d.C0107d.cp_bg_line_d);
    }

    public void cT(View view) {
        this.hqF = (CoverPendantDragView) view.findViewById(d.g.cover_pendant_view);
        this.hqF.setParentViewController(this);
        this.hqC = (LinearLayout) view.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.hqC.setVisibility(0);
            this.hqC.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.hqC.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nb(boolean z) {
        this.hqF.nb(z);
        if (z) {
            this.hqB.seekTo(this.hqB.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.hqB.seekTo(b.this.hqB.getCurrentPosition());
                b.this.hnN.bBn();
            }
        }, 500L);
    }

    public void release() {
        if (this.hqB != null) {
            this.hqB.release();
        }
        if (this.hqF != null) {
            this.hqF.onDestroy();
        }
    }
}
