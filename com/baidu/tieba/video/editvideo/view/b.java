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
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends com.baidu.adp.base.c {
    private a iVY;
    private CoverSeekBar iYG;
    private LinearLayout iYH;
    private HListView iYI;
    private com.baidu.tieba.video.editvideo.a.a iYJ;
    private CoverPendantDragView iYK;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.iVY = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.iYG = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.iYI = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.iYJ = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.iYJ.a(new a.InterfaceC0397a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0397a
            public void a(View view, int i, PendantData pendantData) {
                b.this.iYK.a(view, pendantData);
                am amVar = new am("c12305");
                amVar.T("obj_locate", i + 1);
                TiebaStatic.log(amVar);
            }
        });
        this.iYI.setAdapter((ListAdapter) this.iYJ);
        this.iYJ.setData(ckl());
        this.iYG.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.iVY.cka().getDuration() * i) / 1000;
                b.this.iYG.setProgressImage(i, (int) duration);
                b.this.iVY.cka().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void cjV() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void cjW() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> ckl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void ec(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, ckl());
        this.iYJ.setData(list);
    }

    public void ckm() {
        this.iYK.setVideoSize(this.iVY.cka().getWidth(), this.iVY.cka().getHeight());
        this.iYK.setVideoLocation(this.iVY.cka().getLeft(), this.iVY.cka().getTop(), this.iVY.cka().getRight(), this.iVY.cka().getBottom());
    }

    public void bUW() {
        this.iYK.bUW();
    }

    public String getText() {
        return this.iYK.getText();
    }

    public Bitmap A(Bitmap bitmap) {
        this.iYK.bUW();
        String text = this.iYK.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.iVY.cka().getWidth();
        int height = this.iVY.cka().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.iYK.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.iVY.cka().getLeft(), this.iVY.cka().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.iYG.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.iYG.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
    }

    public void cK(View view) {
        this.iYK = (CoverPendantDragView) view.findViewById(d.g.cover_pendant_view);
        this.iYK.setParentViewController(this);
        this.iYH = (LinearLayout) view.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.iYH.setVisibility(0);
            this.iYH.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.iYH.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void qB(boolean z) {
        this.iYK.qB(z);
        if (z) {
            this.iYG.seekTo(this.iYG.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.iYG.seekTo(b.this.iYG.getCurrentPosition());
                b.this.iVY.ckc();
            }
        }, 500L);
    }

    public void release() {
        if (this.iYG != null) {
            this.iYG.release();
        }
        if (this.iYK != null) {
            this.iYK.onDestroy();
        }
    }
}
