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
    private a lBj;
    private CoverSeekBar lDN;
    private LinearLayout lDO;
    private HListView lDP;
    private com.baidu.tieba.video.editvideo.a.a lDQ;
    private CoverPendantDragView lDR;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.lBj = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.lDN = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.lDP = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.lDQ = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.lDQ.a(new a.InterfaceC0735a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0735a
            public void a(View view, int i, PendantData pendantData) {
                b.this.lDR.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.ag("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.lDP.setAdapter((ListAdapter) this.lDQ);
        this.lDQ.setData(djc());
        this.lDN.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.lBj.diS().getDuration() * i) / 1000;
                b.this.lDN.setProgressImage(i, (int) duration);
                b.this.lBj.diS().seekTo((int) duration);
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

    private List<PendantData> djc() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void eL(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, djc());
        this.lDQ.setData(list);
    }

    public void djd() {
        this.lDR.setVideoSize(this.lBj.diS().getWidth(), this.lBj.diS().getHeight());
        this.lDR.setVideoLocation(this.lBj.diS().getLeft(), this.lBj.diS().getTop(), this.lBj.diS().getRight(), this.lBj.diS().getBottom());
    }

    public void hideSoftKeyPad() {
        this.lDR.hideSoftKeyPad();
    }

    public String getText() {
        return this.lDR.getText();
    }

    public Bitmap D(Bitmap bitmap) {
        this.lDR.hideSoftKeyPad();
        String text = this.lDR.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.lBj.diS().getWidth();
        int height = this.lBj.diS().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.lDR.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.lBj.diS().getLeft(), this.lBj.diS().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.lDN.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lDN.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void df(View view) {
        this.lDR = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.lDR.setParentViewController(this);
        this.lDO = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("video_cover_first_in", true)) {
            this.lDO.setVisibility(0);
            this.lDO.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.lDO.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void uT(boolean z) {
        this.lDR.uT(z);
        if (z) {
            this.lDN.seekTo(this.lDN.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.lDN.seekTo(b.this.lDN.getCurrentPosition());
                b.this.lBj.diU();
            }
        }, 500L);
    }

    public void release() {
        if (this.lDN != null) {
            this.lDN.release();
        }
        if (this.lDR != null) {
            this.lDR.onDestroy();
        }
    }
}
