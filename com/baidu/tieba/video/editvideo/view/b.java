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
    private a lCs;
    private CoverSeekBar lEW;
    private LinearLayout lEX;
    private HListView lEY;
    private com.baidu.tieba.video.editvideo.a.a lEZ;
    private CoverPendantDragView lFa;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.lCs = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.lEW = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.lEY = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.lEZ = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.lEZ.a(new a.InterfaceC0736a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0736a
            public void a(View view, int i, PendantData pendantData) {
                b.this.lFa.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.ag("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.lEY.setAdapter((ListAdapter) this.lEZ);
        this.lEZ.setData(djr());
        this.lEW.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.lCs.djh().getDuration() * i) / 1000;
                b.this.lEW.setProgressImage(i, (int) duration);
                b.this.lCs.djh().seekTo((int) duration);
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

    private List<PendantData> djr() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void eN(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, djr());
        this.lEZ.setData(list);
    }

    public void djs() {
        this.lFa.setVideoSize(this.lCs.djh().getWidth(), this.lCs.djh().getHeight());
        this.lFa.setVideoLocation(this.lCs.djh().getLeft(), this.lCs.djh().getTop(), this.lCs.djh().getRight(), this.lCs.djh().getBottom());
    }

    public void hideSoftKeyPad() {
        this.lFa.hideSoftKeyPad();
    }

    public String getText() {
        return this.lFa.getText();
    }

    public Bitmap D(Bitmap bitmap) {
        this.lFa.hideSoftKeyPad();
        String text = this.lFa.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.lCs.djh().getWidth();
        int height = this.lCs.djh().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.lFa.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.lCs.djh().getLeft(), this.lCs.djh().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.lEW.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lEW.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void df(View view) {
        this.lFa = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.lFa.setParentViewController(this);
        this.lEX = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("video_cover_first_in", true)) {
            this.lEX.setVisibility(0);
            this.lEX.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.lEX.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void uT(boolean z) {
        this.lFa.uT(z);
        if (z) {
            this.lEW.seekTo(this.lEW.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.lEW.seekTo(b.this.lEW.getCurrentPosition());
                b.this.lCs.djj();
            }
        }, 500L);
    }

    public void release() {
        if (this.lEW != null) {
            this.lEW.release();
        }
        if (this.lFa != null) {
            this.lFa.onDestroy();
        }
    }
}
