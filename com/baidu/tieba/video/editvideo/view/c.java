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
    private a mUV;
    private CoverSeekBar mXD;
    private LinearLayout mXE;
    private HListView mXF;
    private com.baidu.tieba.video.editvideo.a.a mXG;
    private CoverPendantDragView mXH;

    public c(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.mUV = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.mXD = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.mXF = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.mXG = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.mXG.a(new a.InterfaceC0829a() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0829a
            public void a(View view, int i, PendantData pendantData) {
                c.this.mXH.a(view, pendantData);
                aq aqVar = new aq("c12305");
                aqVar.aj("obj_locate", i + 1);
                TiebaStatic.log(aqVar);
            }
        });
        this.mXF.setAdapter((ListAdapter) this.mXG);
        this.mXG.setData(dKa());
        this.mXD.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (c.this.mUV.dJP().getDuration() * i) / 1000;
                c.this.mXD.setProgressImage(i, (int) duration);
                c.this.mUV.dJP().seekTo((int) duration);
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

    private List<PendantData> dKa() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void fA(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, dKa());
        this.mXG.setData(list);
    }

    public void dKb() {
        this.mXH.setVideoSize(this.mUV.dJP().getWidth(), this.mUV.dJP().getHeight());
        this.mXH.setVideoLocation(this.mUV.dJP().getLeft(), this.mUV.dJP().getTop(), this.mUV.dJP().getRight(), this.mUV.dJP().getBottom());
    }

    public void hideSoftKeyPad() {
        this.mXH.hideSoftKeyPad();
    }

    public String getText() {
        return this.mXH.getText();
    }

    public Bitmap F(Bitmap bitmap) {
        this.mXH.hideSoftKeyPad();
        String text = this.mXH.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.mUV.dJP().getWidth();
        int height = this.mUV.dJP().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.mXH.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.mUV.dJP().getLeft(), this.mUV.dJP().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.mXD.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mXD.setData(str);
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void dD(View view) {
        this.mXH = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.mXH.setParentViewController(this);
        this.mXE = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("video_cover_first_in", true)) {
            this.mXE.setVisibility(0);
            this.mXE.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.mXE.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void xu(boolean z) {
        this.mXH.xu(z);
        if (z) {
            this.mXD.seekTo(this.mXD.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.mXD.seekTo(c.this.mXD.getCurrentPosition());
                c.this.mUV.dJR();
            }
        }, 500L);
    }

    public void release() {
        if (this.mXD != null) {
            this.mXD.release();
        }
        if (this.mXH != null) {
            this.mXH.onDestroy();
        }
    }
}
