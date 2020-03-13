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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends com.baidu.adp.base.c {
    private a kwA;
    private CoverSeekBar kyZ;
    private LinearLayout kza;
    private HListView kzb;
    private com.baidu.tieba.video.editvideo.a.a kzc;
    private CoverPendantDragView kzd;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.kwA = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.kyZ = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.kzb = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.kzc = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.kzc.a(new a.InterfaceC0619a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0619a
            public void a(View view, int i, PendantData pendantData) {
                b.this.kzd.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.X("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.kzb.setAdapter((ListAdapter) this.kzc);
        this.kzc.setData(cQz());
        this.kyZ.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.kwA.cQp().getDuration() * i) / 1000;
                b.this.kyZ.setProgressImage(i, (int) duration);
                b.this.kwA.cQp().seekTo((int) duration);
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

    private List<PendantData> cQz() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void ep(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, cQz());
        this.kzc.setData(list);
    }

    public void cQA() {
        this.kzd.setVideoSize(this.kwA.cQp().getWidth(), this.kwA.cQp().getHeight());
        this.kzd.setVideoLocation(this.kwA.cQp().getLeft(), this.kwA.cQp().getTop(), this.kwA.cQp().getRight(), this.kwA.cQp().getBottom());
    }

    public void hideSoftKeyPad() {
        this.kzd.hideSoftKeyPad();
    }

    public String getText() {
        return this.kzd.getText();
    }

    public Bitmap z(Bitmap bitmap) {
        this.kzd.hideSoftKeyPad();
        String text = this.kzd.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.kwA.cQp().getWidth();
        int height = this.kwA.cQp().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.kzd.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.kwA.cQp().getLeft(), this.kwA.cQp().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.kyZ.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.kyZ.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void cW(View view) {
        this.kzd = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.kzd.setParentViewController(this);
        this.kza = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("video_cover_first_in", true)) {
            this.kza.setVisibility(0);
            this.kza.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.kza.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void to(boolean z) {
        this.kzd.to(z);
        if (z) {
            this.kyZ.seekTo(this.kyZ.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.kyZ.seekTo(b.this.kyZ.getCurrentPosition());
                b.this.kwA.cQr();
            }
        }, 500L);
    }

    public void release() {
        if (this.kyZ != null) {
            this.kyZ.release();
        }
        if (this.kzd != null) {
            this.kzd.onDestroy();
        }
    }
}
