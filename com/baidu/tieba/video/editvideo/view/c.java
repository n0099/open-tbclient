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
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends com.baidu.adp.base.d {
    private Resources mResources;
    private View mRootView;
    private a nCe;
    private CoverSeekBar nEJ;
    private LinearLayout nEK;
    private HListView nEL;
    private com.baidu.tieba.video.editvideo.a.a nEM;
    private CoverPendantDragView nEN;

    public c(f fVar, a aVar) {
        super(fVar);
        this.nCe = aVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nEJ = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.nEL = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.nEM = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.nEM.a(new a.InterfaceC0882a() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0882a
            public void a(View view, int i, PendantData pendantData) {
                c.this.nEN.a(view, pendantData);
                aq aqVar = new aq("c12305");
                aqVar.an("obj_locate", i + 1);
                TiebaStatic.log(aqVar);
            }
        });
        this.nEL.setAdapter((ListAdapter) this.nEM);
        this.nEM.setData(dRd());
        this.nEJ.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (c.this.nCe.dQT().getDuration() * i) / 1000;
                c.this.nEJ.setProgressImage(i, (int) duration);
                c.this.nCe.dQT().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void dQN() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void dQO() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> dRd() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void ga(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, dRd());
        this.nEM.setData(list);
    }

    public void dRe() {
        this.nEN.setVideoSize(this.nCe.dQT().getWidth(), this.nCe.dQT().getHeight());
        this.nEN.setVideoLocation(this.nCe.dQT().getLeft(), this.nCe.dQT().getTop(), this.nCe.dQT().getRight(), this.nCe.dQT().getBottom());
    }

    public void hideSoftKeyPad() {
        this.nEN.hideSoftKeyPad();
    }

    public String getText() {
        return this.nEN.getText();
    }

    public Bitmap G(Bitmap bitmap) {
        this.nEN.hideSoftKeyPad();
        String text = this.nEN.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.nCe.dQT().getWidth();
        int height = this.nCe.dQT().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.nEN.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.nCe.dQT().getLeft(), this.nCe.dQT().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.nEJ.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nEJ.setData(str);
        }
    }

    public void onChangeSkinType(f fVar, int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    public void eo(View view) {
        this.nEN = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.nEN.setParentViewController(this);
        this.nEK = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("video_cover_first_in", true)) {
            this.nEK.setVisibility(0);
            this.nEK.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.nEK.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yF(boolean z) {
        this.nEN.yF(z);
        if (z) {
            this.nEJ.seekTo(this.nEJ.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.nEJ.seekTo(c.this.nEJ.getCurrentPosition());
                c.this.nCe.dQV();
            }
        }, 500L);
    }

    public void release() {
        if (this.nEJ != null) {
            this.nEJ.release();
        }
        if (this.nEN != null) {
            this.nEN.onDestroy();
        }
    }
}
