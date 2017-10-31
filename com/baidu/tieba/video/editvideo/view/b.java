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
    private Resources fNu;
    private a gDF;
    private CoverSeekBar gFE;
    private LinearLayout gFF;
    private HListView gFG;
    private com.baidu.tieba.video.editvideo.a.a gFH;
    private CoverPendantDragView gFI;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.gDF = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_cover_layout, (ViewGroup) null);
        this.fNu = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gFE = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.gFG = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.gFH = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.gFH.a(new a.InterfaceC0130a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0130a
            public void a(View view, int i, PendantData pendantData) {
                b.this.gFI.a(view, pendantData);
                ak akVar = new ak("c12305");
                akVar.r("obj_locate", i + 1);
                TiebaStatic.log(akVar);
            }
        });
        this.gFG.setAdapter((ListAdapter) this.gFH);
        this.gFH.setData(bzo());
        this.gFE.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.gDF.bzi().getDuration() * i) / 1000;
                b.this.gFE.cb(i, (int) duration);
                b.this.gDF.bzi().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bzd() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bze() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bzo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dB(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bzo());
        this.gFH.setData(list);
    }

    public void bzp() {
        this.gFI.setVideoSize(this.gDF.bzi().getWidth(), this.gDF.bzi().getHeight());
        this.gFI.i(this.gDF.bzi().getLeft(), this.gDF.bzi().getTop(), this.gDF.bzi().getRight(), this.gDF.bzi().getBottom());
    }

    public void bic() {
        this.gFI.bic();
    }

    public String getText() {
        return this.gFI.getText();
    }

    public Bitmap j(Bitmap bitmap) {
        this.gFI.bic();
        String text = this.gFI.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.gDF.bzi().getWidth();
        int height = this.gDF.bzi().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.gFI.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.gDF.bzi().getLeft(), this.gDF.bzi().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.gFE.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gFE.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.C0080d.cp_bg_line_d);
    }

    public void bL(View view) {
        this.gFI = (CoverPendantDragView) view.findViewById(d.g.cover_pendant_view);
        this.gFI.setParentViewController(this);
        this.gFF = (LinearLayout) view.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.gFF.setVisibility(0);
            this.gFF.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.gFF.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void mW(boolean z) {
        this.gFI.mW(z);
        if (z) {
            this.gFE.seekTo(this.gFE.getCurrentPosition());
        }
    }

    public void bzk() {
        this.gFI.bzc();
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.gFE.seekTo(b.this.gFE.getCurrentPosition());
                b.this.gDF.bzj();
            }
        }, 500L);
    }

    public void release() {
        if (this.gFE != null) {
            this.gFE.release();
        }
        if (this.gFI != null) {
            this.gFI.onDestroy();
        }
    }
}
