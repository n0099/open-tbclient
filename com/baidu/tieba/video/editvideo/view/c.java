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
import com.baidu.tbadk.core.util.ar;
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
    private a nCB;
    private CoverSeekBar nFi;
    private LinearLayout nFj;
    private HListView nFk;
    private com.baidu.tieba.video.editvideo.a.a nFl;
    private CoverPendantDragView nFm;

    public c(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.nCB = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nFi = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.nFk = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.nFl = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.nFl.a(new a.InterfaceC0878a() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0878a
            public void a(View view, int i, PendantData pendantData) {
                c.this.nFm.a(view, pendantData);
                ar arVar = new ar("c12305");
                arVar.al("obj_locate", i + 1);
                TiebaStatic.log(arVar);
            }
        });
        this.nFk.setAdapter((ListAdapter) this.nFl);
        this.nFl.setData(dVd());
        this.nFi.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (c.this.nCB.dUS().getDuration() * i) / 1000;
                c.this.nFi.setProgressImage(i, (int) duration);
                c.this.nCB.dUS().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void dUM() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void dUN() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> dVd() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void gf(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, dVd());
        this.nFl.setData(list);
    }

    public void dVe() {
        this.nFm.setVideoSize(this.nCB.dUS().getWidth(), this.nCB.dUS().getHeight());
        this.nFm.setVideoLocation(this.nCB.dUS().getLeft(), this.nCB.dUS().getTop(), this.nCB.dUS().getRight(), this.nCB.dUS().getBottom());
    }

    public void hideSoftKeyPad() {
        this.nFm.hideSoftKeyPad();
    }

    public String getText() {
        return this.nFm.getText();
    }

    public Bitmap F(Bitmap bitmap) {
        this.nFm.hideSoftKeyPad();
        String text = this.nFm.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.nCB.dUS().getWidth();
        int height = this.nCB.dUS().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.nFm.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.nCB.dUS().getLeft(), this.nCB.dUS().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.nFi.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nFi.setData(str);
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    public void ee(View view) {
        this.nFm = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.nFm.setParentViewController(this);
        this.nFj = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("video_cover_first_in", true)) {
            this.nFj.setVisibility(0);
            this.nFj.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.nFj.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yG(boolean z) {
        this.nFm.yG(z);
        if (z) {
            this.nFi.seekTo(this.nFi.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.nFi.seekTo(c.this.nFi.getCurrentPosition());
                c.this.nCB.dUU();
            }
        }, 500L);
    }

    public void release() {
        if (this.nFi != null) {
            this.nFi.release();
        }
        if (this.nFm != null) {
            this.nFm.onDestroy();
        }
    }
}
