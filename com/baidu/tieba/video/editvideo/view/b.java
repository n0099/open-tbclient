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
/* loaded from: classes5.dex */
public class b extends com.baidu.adp.base.c {
    private CoverSeekBar jAr;
    private LinearLayout jAs;
    private HListView jAt;
    private com.baidu.tieba.video.editvideo.a.a jAu;
    private CoverPendantDragView jAv;
    private a jxL;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.jxL = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.jAr = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.jAt = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.jAu = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.jAu.a(new a.InterfaceC0527a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0527a
            public void a(View view, int i, PendantData pendantData) {
                b.this.jAv.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.O("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.jAt.setAdapter((ListAdapter) this.jAu);
        this.jAu.setData(ctY());
        this.jAr.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.jxL.ctN().getDuration() * i) / 1000;
                b.this.jAr.setProgressImage(i, (int) duration);
                b.this.jxL.ctN().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void ctH() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void ctI() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> ctY() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void eB(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, ctY());
        this.jAu.setData(list);
    }

    public void ctZ() {
        this.jAv.setVideoSize(this.jxL.ctN().getWidth(), this.jxL.ctN().getHeight());
        this.jAv.setVideoLocation(this.jxL.ctN().getLeft(), this.jxL.ctN().getTop(), this.jxL.ctN().getRight(), this.jxL.ctN().getBottom());
    }

    public void hideSoftKeyPad() {
        this.jAv.hideSoftKeyPad();
    }

    public String getText() {
        return this.jAv.getText();
    }

    public Bitmap z(Bitmap bitmap) {
        this.jAv.hideSoftKeyPad();
        String text = this.jAv.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.jxL.ctN().getWidth();
        int height = this.jxL.ctN().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.jAv.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.jxL.ctN().getLeft(), this.jxL.ctN().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.jAr.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jAr.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void cT(View view) {
        this.jAv = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.jAv.setParentViewController(this);
        this.jAs = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("video_cover_first_in", true)) {
            this.jAs.setVisibility(0);
            this.jAs.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.jAs.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rr(boolean z) {
        this.jAv.rr(z);
        if (z) {
            this.jAr.seekTo(this.jAr.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.jAr.seekTo(b.this.jAr.getCurrentPosition());
                b.this.jxL.ctP();
            }
        }, 500L);
    }

    public void release() {
        if (this.jAr != null) {
            this.jAr.release();
        }
        if (this.jAv != null) {
            this.jAv.onDestroy();
        }
    }
}
