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
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.base.c {
    private a mFi;
    private CoverSeekBar mHS;
    private LinearLayout mHT;
    private HListView mHU;
    private com.baidu.tieba.video.editvideo.a.a mHV;
    private CoverPendantDragView mHW;
    private Resources mResources;
    private View mRootView;

    public c(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.mFi = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.mHS = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.mHU = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.mHV = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.mHV.a(new a.InterfaceC0811a() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0811a
            public void a(View view, int i, PendantData pendantData) {
                c.this.mHW.a(view, pendantData);
                aq aqVar = new aq("c12305");
                aqVar.ai("obj_locate", i + 1);
                TiebaStatic.log(aqVar);
            }
        });
        this.mHU.setAdapter((ListAdapter) this.mHV);
        this.mHV.setData(dGo());
        this.mHS.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (c.this.mFi.dGd().getDuration() * i) / 1000;
                c.this.mHS.setProgressImage(i, (int) duration);
                c.this.mFi.dGd().seekTo((int) duration);
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

    private List<PendantData> dGo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void fx(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, dGo());
        this.mHV.setData(list);
    }

    public void dGp() {
        this.mHW.setVideoSize(this.mFi.dGd().getWidth(), this.mFi.dGd().getHeight());
        this.mHW.setVideoLocation(this.mFi.dGd().getLeft(), this.mFi.dGd().getTop(), this.mFi.dGd().getRight(), this.mFi.dGd().getBottom());
    }

    public void hideSoftKeyPad() {
        this.mHW.hideSoftKeyPad();
    }

    public String getText() {
        return this.mHW.getText();
    }

    public Bitmap F(Bitmap bitmap) {
        this.mHW.hideSoftKeyPad();
        String text = this.mHW.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.mFi.dGd().getWidth();
        int height = this.mFi.dGd().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.mHW.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.mFi.dGd().getLeft(), this.mFi.dGd().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.mHS.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mHS.setData(str);
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void dz(View view) {
        this.mHW = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.mHW.setParentViewController(this);
        this.mHT = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("video_cover_first_in", true)) {
            this.mHT.setVisibility(0);
            this.mHT.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.mHT.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void wN(boolean z) {
        this.mHW.wN(z);
        if (z) {
            this.mHS.seekTo(this.mHS.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.mHS.seekTo(c.this.mHS.getCurrentPosition());
                c.this.mFi.dGf();
            }
        }, 500L);
    }

    public void release() {
        if (this.mHS != null) {
            this.mHS.release();
        }
        if (this.mHW != null) {
            this.mHW.onDestroy();
        }
    }
}
