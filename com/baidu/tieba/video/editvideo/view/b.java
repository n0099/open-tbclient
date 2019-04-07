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
    private a iVX;
    private CoverSeekBar iYF;
    private LinearLayout iYG;
    private HListView iYH;
    private com.baidu.tieba.video.editvideo.a.a iYI;
    private CoverPendantDragView iYJ;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.iVX = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.iYF = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.iYH = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.iYI = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.iYI.a(new a.InterfaceC0397a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0397a
            public void a(View view, int i, PendantData pendantData) {
                b.this.iYJ.a(view, pendantData);
                am amVar = new am("c12305");
                amVar.T("obj_locate", i + 1);
                TiebaStatic.log(amVar);
            }
        });
        this.iYH.setAdapter((ListAdapter) this.iYI);
        this.iYI.setData(ckl());
        this.iYF.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.iVX.cka().getDuration() * i) / 1000;
                b.this.iYF.setProgressImage(i, (int) duration);
                b.this.iVX.cka().seekTo((int) duration);
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
        this.iYI.setData(list);
    }

    public void ckm() {
        this.iYJ.setVideoSize(this.iVX.cka().getWidth(), this.iVX.cka().getHeight());
        this.iYJ.setVideoLocation(this.iVX.cka().getLeft(), this.iVX.cka().getTop(), this.iVX.cka().getRight(), this.iVX.cka().getBottom());
    }

    public void bUW() {
        this.iYJ.bUW();
    }

    public String getText() {
        return this.iYJ.getText();
    }

    public Bitmap A(Bitmap bitmap) {
        this.iYJ.bUW();
        String text = this.iYJ.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.iVX.cka().getWidth();
        int height = this.iVX.cka().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.iYJ.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.iVX.cka().getLeft(), this.iVX.cka().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.iYF.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.iYF.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
    }

    public void cK(View view) {
        this.iYJ = (CoverPendantDragView) view.findViewById(d.g.cover_pendant_view);
        this.iYJ.setParentViewController(this);
        this.iYG = (LinearLayout) view.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.iYG.setVisibility(0);
            this.iYG.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.iYG.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void qB(boolean z) {
        this.iYJ.qB(z);
        if (z) {
            this.iYF.seekTo(this.iYF.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.iYF.seekTo(b.this.iYF.getCurrentPosition());
                b.this.iVX.ckc();
            }
        }, 500L);
    }

    public void release() {
        if (this.iYF != null) {
            this.iYF.release();
        }
        if (this.iYJ != null) {
            this.iYJ.onDestroy();
        }
    }
}
