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
        this.gTS.setData(bCB());
        this.gTP.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.gRd.bCq().getDuration() * i) / 1000;
                b.this.gTP.cc(i, (int) duration);
                b.this.gRd.bCq().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bCl() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bCm() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bCB() {
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
        list.addAll(0, bCB());
        this.gTS.setData(list);
    }

    public void bCC() {
        this.gTT.setVideoSize(this.gRd.bCq().getWidth(), this.gRd.bCq().getHeight());
        this.gTT.i(this.gRd.bCq().getLeft(), this.gRd.bCq().getTop(), this.gRd.bCq().getRight(), this.gRd.bCq().getBottom());
    }

    public void bku() {
        this.gTT.bku();
    }

    public String getText() {
        return this.gTT.getText();
    }

    public Bitmap j(Bitmap bitmap) {
        this.gTT.bku();
        String text = this.gTT.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.gRd.bCq().getWidth();
        int height = this.gRd.bCq().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.gTT.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.gRd.bCq().getLeft(), this.gRd.bCq().getTop(), width, height, matrix, true);
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

    public void bM(View view) {
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
                b.this.gRd.bCs();
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
