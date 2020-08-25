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
/* loaded from: classes17.dex */
public class c extends com.baidu.adp.base.c {
    private Resources mResources;
    private View mRootView;
    private a mve;
    private CoverSeekBar mxO;
    private LinearLayout mxP;
    private HListView mxQ;
    private com.baidu.tieba.video.editvideo.a.a mxR;
    private CoverPendantDragView mxS;

    public c(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.mve = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.mxO = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.mxQ = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.mxR = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.mxR.a(new a.InterfaceC0814a() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0814a
            public void a(View view, int i, PendantData pendantData) {
                c.this.mxS.a(view, pendantData);
                aq aqVar = new aq("c12305");
                aqVar.ai("obj_locate", i + 1);
                TiebaStatic.log(aqVar);
            }
        });
        this.mxQ.setAdapter((ListAdapter) this.mxR);
        this.mxR.setData(dCl());
        this.mxO.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (c.this.mve.dCa().getDuration() * i) / 1000;
                c.this.mxO.setProgressImage(i, (int) duration);
                c.this.mve.dCa().seekTo((int) duration);
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

    private List<PendantData> dCl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void fo(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, dCl());
        this.mxR.setData(list);
    }

    public void dCm() {
        this.mxS.setVideoSize(this.mve.dCa().getWidth(), this.mve.dCa().getHeight());
        this.mxS.setVideoLocation(this.mve.dCa().getLeft(), this.mve.dCa().getTop(), this.mve.dCa().getRight(), this.mve.dCa().getBottom());
    }

    public void hideSoftKeyPad() {
        this.mxS.hideSoftKeyPad();
    }

    public String getText() {
        return this.mxS.getText();
    }

    public Bitmap G(Bitmap bitmap) {
        this.mxS.hideSoftKeyPad();
        String text = this.mxS.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.mve.dCa().getWidth();
        int height = this.mve.dCa().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.mxS.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.mve.dCa().getLeft(), this.mve.dCa().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.mxO.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mxO.setData(str);
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void dq(View view) {
        this.mxS = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.mxS.setParentViewController(this);
        this.mxP = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("video_cover_first_in", true)) {
            this.mxP.setVisibility(0);
            this.mxP.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.mxP.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void wC(boolean z) {
        this.mxS.wC(z);
        if (z) {
            this.mxO.seekTo(this.mxO.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.mxO.seekTo(c.this.mxO.getCurrentPosition());
                c.this.mve.dCc();
            }
        }, 500L);
    }

    public void release() {
        if (this.mxO != null) {
            this.mxO.release();
        }
        if (this.mxS != null) {
            this.mxS.onDestroy();
        }
    }
}
