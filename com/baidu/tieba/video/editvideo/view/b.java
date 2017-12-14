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
    private a gRd;
    private CoverSeekBar gTP;
    private LinearLayout gTQ;
    private HListView gTR;
    private com.baidu.tieba.video.editvideo.a.a gTS;
    private CoverPendantDragView gTT;
    private Resources gai;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.gRd = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_cover_layout, (ViewGroup) null);
        this.gai = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gTP = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.gTR = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.gTS = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.gTS.a(new a.InterfaceC0147a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0147a
            public void a(View view, int i, PendantData pendantData) {
                b.this.gTT.a(view, pendantData);
                ak akVar = new ak("c12305");
                akVar.r("obj_locate", i + 1);
                TiebaStatic.log(akVar);
            }
        });
        this.gTR.setAdapter((ListAdapter) this.gTS);
        this.gTS.setData(bCC());
        this.gTP.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.gRd.bCr().getDuration() * i) / 1000;
                b.this.gTP.cc(i, (int) duration);
                b.this.gRd.bCr().seekTo((int) duration);
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
        this.gTS.setData(list);
    }

    public void bCD() {
        this.gTT.setVideoSize(this.gRd.bCr().getWidth(), this.gRd.bCr().getHeight());
        this.gTT.i(this.gRd.bCr().getLeft(), this.gRd.bCr().getTop(), this.gRd.bCr().getRight(), this.gRd.bCr().getBottom());
    }

    public void bkv() {
        this.gTT.bkv();
    }

    public String getText() {
        return this.gTT.getText();
    }

    public Bitmap j(Bitmap bitmap) {
        this.gTT.bkv();
        String text = this.gTT.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.gRd.bCr().getWidth();
        int height = this.gRd.bCr().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.gTT.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.gRd.bCr().getLeft(), this.gRd.bCr().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.gTP.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gTP.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.C0096d.cp_bg_line_d);
    }

    public void bL(View view) {
        this.gTT = (CoverPendantDragView) view.findViewById(d.g.cover_pendant_view);
        this.gTT.setParentViewController(this);
        this.gTQ = (LinearLayout) view.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.gTQ.setVisibility(0);
            this.gTQ.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.gTQ.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nF(boolean z) {
        this.gTT.nF(z);
        if (z) {
            this.gTP.seekTo(this.gTP.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.gTP.seekTo(b.this.gTP.getCurrentPosition());
                b.this.gRd.bCt();
            }
        }, 500L);
    }

    public void release() {
        if (this.gTP != null) {
            this.gTP.release();
        }
        if (this.gTT != null) {
            this.gTT.onDestroy();
        }
    }
}
