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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class c extends com.baidu.adp.base.c {
    private Resources mResources;
    private View mRootView;
    private a nhv;
    private CoverSeekBar nkd;
    private LinearLayout nke;
    private HListView nkf;
    private com.baidu.tieba.video.editvideo.a.a nkg;
    private CoverPendantDragView nkh;

    public c(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.nhv = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nkd = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.nkf = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.nkg = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.nkg.a(new a.InterfaceC0844a() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0844a
            public void a(View view, int i, PendantData pendantData) {
                c.this.nkh.a(view, pendantData);
                aq aqVar = new aq("c12305");
                aqVar.aj("obj_locate", i + 1);
                TiebaStatic.log(aqVar);
            }
        });
        this.nkf.setAdapter((ListAdapter) this.nkg);
        this.nkg.setData(dNi());
        this.nkd.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (c.this.nhv.dMX().getDuration() * i) / 1000;
                c.this.nkd.setProgressImage(i, (int) duration);
                c.this.nhv.dMX().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onStartTrackingTouch() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onStopTrackingTouch() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> dNi() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void fJ(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, dNi());
        this.nkg.setData(list);
    }

    public void dNj() {
        this.nkh.setVideoSize(this.nhv.dMX().getWidth(), this.nhv.dMX().getHeight());
        this.nkh.setVideoLocation(this.nhv.dMX().getLeft(), this.nhv.dMX().getTop(), this.nhv.dMX().getRight(), this.nhv.dMX().getBottom());
    }

    public void hideSoftKeyPad() {
        this.nkh.hideSoftKeyPad();
    }

    public String getText() {
        return this.nkh.getText();
    }

    public Bitmap F(Bitmap bitmap) {
        this.nkh.hideSoftKeyPad();
        String text = this.nkh.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.nhv.dMX().getWidth();
        int height = this.nhv.dMX().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.nkh.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.nhv.dMX().getLeft(), this.nhv.dMX().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.nkd.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nkd.setData(str);
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void dH(View view) {
        this.nkh = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.nkh.setParentViewController(this);
        this.nke = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("video_cover_first_in", true)) {
            this.nke.setVisibility(0);
            this.nke.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.nke.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void xL(boolean z) {
        this.nkh.xL(z);
        if (z) {
            this.nkd.seekTo(this.nkd.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.nkd.seekTo(c.this.nkd.getCurrentPosition());
                c.this.nhv.dMZ();
            }
        }, 500L);
    }

    public void release() {
        if (this.nkd != null) {
            this.nkd.release();
        }
        if (this.nkh != null) {
            this.nkh.onDestroy();
        }
    }
}
