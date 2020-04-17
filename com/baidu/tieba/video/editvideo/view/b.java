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
    private a liu;
    private CoverSeekBar lkZ;
    private LinearLayout lla;
    private HListView llb;
    private com.baidu.tieba.video.editvideo.a.a llc;
    private CoverPendantDragView lld;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.liu = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.lkZ = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.llb = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.llc = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.llc.a(new a.InterfaceC0661a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0661a
            public void a(View view, int i, PendantData pendantData) {
                b.this.lld.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.af("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.llb.setAdapter((ListAdapter) this.llc);
        this.llc.setData(dbQ());
        this.lkZ.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.liu.dbG().getDuration() * i) / 1000;
                b.this.lkZ.setProgressImage(i, (int) duration);
                b.this.liu.dbG().seekTo((int) duration);
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

    private List<PendantData> dbQ() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void eE(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, dbQ());
        this.llc.setData(list);
    }

    public void dbR() {
        this.lld.setVideoSize(this.liu.dbG().getWidth(), this.liu.dbG().getHeight());
        this.lld.setVideoLocation(this.liu.dbG().getLeft(), this.liu.dbG().getTop(), this.liu.dbG().getRight(), this.liu.dbG().getBottom());
    }

    public void hideSoftKeyPad() {
        this.lld.hideSoftKeyPad();
    }

    public String getText() {
        return this.lld.getText();
    }

    public Bitmap B(Bitmap bitmap) {
        this.lld.hideSoftKeyPad();
        String text = this.lld.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.liu.dbG().getWidth();
        int height = this.liu.dbG().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.lld.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.liu.dbG().getLeft(), this.liu.dbG().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.lkZ.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lkZ.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void de(View view) {
        this.lld = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.lld.setParentViewController(this);
        this.lla = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("video_cover_first_in", true)) {
            this.lla.setVisibility(0);
            this.lla.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.lla.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void uv(boolean z) {
        this.lld.uv(z);
        if (z) {
            this.lkZ.seekTo(this.lkZ.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.lkZ.seekTo(b.this.lkZ.getCurrentPosition());
                b.this.liu.dbI();
            }
        }, 500L);
    }

    public void release() {
        if (this.lkZ != null) {
            this.lkZ.release();
        }
        if (this.lld != null) {
            this.lld.onDestroy();
        }
    }
}
