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
    private a nCf;
    private CoverSeekBar nEK;
    private LinearLayout nEL;
    private HListView nEM;
    private com.baidu.tieba.video.editvideo.a.a nEN;
    private CoverPendantDragView nEO;

    public c(f fVar, a aVar) {
        super(fVar);
        this.nCf = aVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nEK = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.nEM = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.nEN = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.nEN.a(new a.InterfaceC0882a() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0882a
            public void a(View view, int i, PendantData pendantData) {
                c.this.nEO.a(view, pendantData);
                aq aqVar = new aq("c12305");
                aqVar.an("obj_locate", i + 1);
                TiebaStatic.log(aqVar);
            }
        });
        this.nEM.setAdapter((ListAdapter) this.nEN);
        this.nEN.setData(dRd());
        this.nEK.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (c.this.nCf.dQT().getDuration() * i) / 1000;
                c.this.nEK.setProgressImage(i, (int) duration);
                c.this.nCf.dQT().seekTo((int) duration);
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
        this.nEN.setData(list);
    }

    public void dRe() {
        this.nEO.setVideoSize(this.nCf.dQT().getWidth(), this.nCf.dQT().getHeight());
        this.nEO.setVideoLocation(this.nCf.dQT().getLeft(), this.nCf.dQT().getTop(), this.nCf.dQT().getRight(), this.nCf.dQT().getBottom());
    }

    public void hideSoftKeyPad() {
        this.nEO.hideSoftKeyPad();
    }

    public String getText() {
        return this.nEO.getText();
    }

    public Bitmap G(Bitmap bitmap) {
        this.nEO.hideSoftKeyPad();
        String text = this.nEO.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.nCf.dQT().getWidth();
        int height = this.nCf.dQT().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.nEO.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.nCf.dQT().getLeft(), this.nCf.dQT().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.nEK.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nEK.setData(str);
        }
    }

    public void onChangeSkinType(f fVar, int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    public void eo(View view) {
        this.nEO = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.nEO.setParentViewController(this);
        this.nEL = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("video_cover_first_in", true)) {
            this.nEL.setVisibility(0);
            this.nEL.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.nEL.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yF(boolean z) {
        this.nEO.yF(z);
        if (z) {
            this.nEK.seekTo(this.nEK.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.nEK.seekTo(c.this.nEK.getCurrentPosition());
                c.this.nCf.dQV();
            }
        }, 500L);
    }

    public void release() {
        if (this.nEK != null) {
            this.nEK.release();
        }
        if (this.nEO != null) {
            this.nEO.onDestroy();
        }
    }
}
