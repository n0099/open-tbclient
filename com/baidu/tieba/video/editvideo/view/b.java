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
    private a liy;
    private CoverSeekBar lld;
    private LinearLayout lle;
    private HListView llf;
    private com.baidu.tieba.video.editvideo.a.a llg;
    private CoverPendantDragView llh;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.liy = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.lld = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.llf = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.llg = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.llg.a(new a.InterfaceC0682a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0682a
            public void a(View view, int i, PendantData pendantData) {
                b.this.llh.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.af("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.llf.setAdapter((ListAdapter) this.llg);
        this.llg.setData(dbO());
        this.lld.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.liy.dbE().getDuration() * i) / 1000;
                b.this.lld.setProgressImage(i, (int) duration);
                b.this.liy.dbE().seekTo((int) duration);
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

    private List<PendantData> dbO() {
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
        list.addAll(0, dbO());
        this.llg.setData(list);
    }

    public void dbP() {
        this.llh.setVideoSize(this.liy.dbE().getWidth(), this.liy.dbE().getHeight());
        this.llh.setVideoLocation(this.liy.dbE().getLeft(), this.liy.dbE().getTop(), this.liy.dbE().getRight(), this.liy.dbE().getBottom());
    }

    public void hideSoftKeyPad() {
        this.llh.hideSoftKeyPad();
    }

    public String getText() {
        return this.llh.getText();
    }

    public Bitmap B(Bitmap bitmap) {
        this.llh.hideSoftKeyPad();
        String text = this.llh.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.liy.dbE().getWidth();
        int height = this.liy.dbE().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.llh.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.liy.dbE().getLeft(), this.liy.dbE().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.lld.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lld.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void de(View view) {
        this.llh = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.llh.setParentViewController(this);
        this.lle = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("video_cover_first_in", true)) {
            this.lle.setVisibility(0);
            this.lle.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.lle.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void uv(boolean z) {
        this.llh.uv(z);
        if (z) {
            this.lld.seekTo(this.lld.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.lld.seekTo(b.this.lld.getCurrentPosition());
                b.this.liy.dbG();
            }
        }, 500L);
    }

    public void release() {
        if (this.lld != null) {
            this.lld.release();
        }
        if (this.llh != null) {
            this.llh.onDestroy();
        }
    }
}
