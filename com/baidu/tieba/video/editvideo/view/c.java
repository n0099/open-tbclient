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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c extends com.baidu.adp.base.c {
    private a lWb;
    private CoverSeekBar lYL;
    private LinearLayout lYM;
    private HListView lYN;
    private com.baidu.tieba.video.editvideo.a.a lYO;
    private CoverPendantDragView lYP;
    private Resources mResources;
    private View mRootView;

    public c(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.lWb = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.lYL = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.lYN = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.lYO = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.lYO.a(new a.InterfaceC0752a() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0752a
            public void a(View view, int i, PendantData pendantData) {
                c.this.lYP.a(view, pendantData);
                ao aoVar = new ao("c12305");
                aoVar.ag("obj_locate", i + 1);
                TiebaStatic.log(aoVar);
            }
        });
        this.lYN.setAdapter((ListAdapter) this.lYO);
        this.lYO.setData(dnG());
        this.lYL.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (c.this.lWb.dnv().getDuration() * i) / 1000;
                c.this.lYL.setProgressImage(i, (int) duration);
                c.this.lWb.dnv().seekTo((int) duration);
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

    private List<PendantData> dnG() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void fa(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, dnG());
        this.lYO.setData(list);
    }

    public void dnH() {
        this.lYP.setVideoSize(this.lWb.dnv().getWidth(), this.lWb.dnv().getHeight());
        this.lYP.setVideoLocation(this.lWb.dnv().getLeft(), this.lWb.dnv().getTop(), this.lWb.dnv().getRight(), this.lWb.dnv().getBottom());
    }

    public void hideSoftKeyPad() {
        this.lYP.hideSoftKeyPad();
    }

    public String getText() {
        return this.lYP.getText();
    }

    public Bitmap D(Bitmap bitmap) {
        this.lYP.hideSoftKeyPad();
        String text = this.lYP.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.lWb.dnv().getWidth();
        int height = this.lWb.dnv().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.lYP.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.lWb.dnv().getLeft(), this.lWb.dnv().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.lYL.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lYL.setData(str);
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void dg(View view) {
        this.lYP = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.lYP.setParentViewController(this);
        this.lYM = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("video_cover_first_in", true)) {
            this.lYM.setVisibility(0);
            this.lYM.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.lYM.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void vj(boolean z) {
        this.lYP.vj(z);
        if (z) {
            this.lYL.seekTo(this.lYL.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.lYL.seekTo(c.this.lYL.getCurrentPosition());
                c.this.lWb.dnx();
            }
        }, 500L);
    }

    public void release() {
        if (this.lYL != null) {
            this.lYL.release();
        }
        if (this.lYP != null) {
            this.lYP.onDestroy();
        }
    }
}
