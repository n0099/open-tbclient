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
    private a gRi;
    private CoverSeekBar gTU;
    private LinearLayout gTV;
    private HListView gTW;
    private com.baidu.tieba.video.editvideo.a.a gTX;
    private CoverPendantDragView gTY;
    private Resources gan;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.gRi = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_cover_layout, (ViewGroup) null);
        this.gan = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gTU = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.gTW = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.gTX = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.gTX.a(new a.InterfaceC0146a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0146a
            public void a(View view, int i, PendantData pendantData) {
                b.this.gTY.a(view, pendantData);
                ak akVar = new ak("c12305");
                akVar.r("obj_locate", i + 1);
                TiebaStatic.log(akVar);
            }
        });
        this.gTW.setAdapter((ListAdapter) this.gTX);
        this.gTX.setData(bCC());
        this.gTU.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.gRi.bCr().getDuration() * i) / 1000;
                b.this.gTU.cc(i, (int) duration);
                b.this.gRi.bCr().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bCm() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bCn() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bCC() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dN(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bCC());
        this.gTX.setData(list);
    }

    public void bCD() {
        this.gTY.setVideoSize(this.gRi.bCr().getWidth(), this.gRi.bCr().getHeight());
        this.gTY.i(this.gRi.bCr().getLeft(), this.gRi.bCr().getTop(), this.gRi.bCr().getRight(), this.gRi.bCr().getBottom());
    }

    public void bkv() {
        this.gTY.bkv();
    }

    public String getText() {
        return this.gTY.getText();
    }

    public Bitmap j(Bitmap bitmap) {
        this.gTY.bkv();
        String text = this.gTY.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.gRi.bCr().getWidth();
        int height = this.gRi.bCr().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.gTY.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.gRi.bCr().getLeft(), this.gRi.bCr().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.gTU.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gTU.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.C0095d.cp_bg_line_d);
    }

    public void bM(View view) {
        this.gTY = (CoverPendantDragView) view.findViewById(d.g.cover_pendant_view);
        this.gTY.setParentViewController(this);
        this.gTV = (LinearLayout) view.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.gTV.setVisibility(0);
            this.gTV.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.gTV.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nF(boolean z) {
        this.gTY.nF(z);
        if (z) {
            this.gTU.seekTo(this.gTU.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.gTU.seekTo(b.this.gTU.getCurrentPosition());
                b.this.gRi.bCt();
            }
        }, 500L);
    }

    public void release() {
        if (this.gTU != null) {
            this.gTU.release();
        }
        if (this.gTY != null) {
            this.gTY.onDestroy();
        }
    }
}
