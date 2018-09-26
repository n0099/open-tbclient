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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c {
    private a hle;
    private CoverSeekBar hnP;
    private LinearLayout hnQ;
    private HListView hnR;
    private com.baidu.tieba.video.editvideo.a.a hnS;
    private CoverPendantDragView hnT;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.hle = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(e.h.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.hnP = (CoverSeekBar) this.mRootView.findViewById(e.g.cover_seek_bar);
        this.hnR = (HListView) this.mRootView.findViewById(e.g.pendant_list_view);
        this.hnS = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.hnS.a(new a.InterfaceC0247a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0247a
            public void a(View view, int i, PendantData pendantData) {
                b.this.hnT.a(view, pendantData);
                am amVar = new am("c12305");
                amVar.w("obj_locate", i + 1);
                TiebaStatic.log(amVar);
            }
        });
        this.hnR.setAdapter((ListAdapter) this.hnS);
        this.hnS.setData(bEx());
        this.hnP.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.hle.bEm().getDuration() * i) / 1000;
                b.this.hnP.setProgressImage(i, (int) duration);
                b.this.hle.bEm().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bEh() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bEi() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bEx() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dH(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bEx());
        this.hnS.setData(list);
    }

    public void bEy() {
        this.hnT.setVideoSize(this.hle.bEm().getWidth(), this.hle.bEm().getHeight());
        this.hnT.setVideoLocation(this.hle.bEm().getLeft(), this.hle.bEm().getTop(), this.hle.bEm().getRight(), this.hle.bEm().getBottom());
    }

    public void bon() {
        this.hnT.bon();
    }

    public String getText() {
        return this.hnT.getText();
    }

    public Bitmap s(Bitmap bitmap) {
        this.hnT.bon();
        String text = this.hnT.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.hle.bEm().getWidth();
        int height = this.hle.bEm().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.hnT.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.hle.bEm().getLeft(), this.hle.bEm().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.hnP.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hnP.setData(str);
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public void bS(View view) {
        this.hnT = (CoverPendantDragView) view.findViewById(e.g.cover_pendant_view);
        this.hnT.setParentViewController(this);
        this.hnQ = (LinearLayout) view.findViewById(e.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.hnQ.setVisibility(0);
            this.hnQ.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.hnQ.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nq(boolean z) {
        this.hnT.nq(z);
        if (z) {
            this.hnP.seekTo(this.hnP.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.hnP.seekTo(b.this.hnP.getCurrentPosition());
                b.this.hle.bEo();
            }
        }, 500L);
    }

    public void release() {
        if (this.hnP != null) {
            this.hnP.release();
        }
        if (this.hnT != null) {
            this.hnT.onDestroy();
        }
    }
}
