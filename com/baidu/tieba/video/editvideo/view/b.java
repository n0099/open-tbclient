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
    private a jwo;
    private CoverSeekBar jyU;
    private LinearLayout jyV;
    private HListView jyW;
    private com.baidu.tieba.video.editvideo.a.a jyX;
    private CoverPendantDragView jyY;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.jwo = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.jyU = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.jyW = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.jyX = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.jyX.a(new a.InterfaceC0421a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0421a
            public void a(View view, int i, PendantData pendantData) {
                b.this.jyY.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.P("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.jyW.setAdapter((ListAdapter) this.jyX);
        this.jyX.setData(cvy());
        this.jyU.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.jwo.cvn().getDuration() * i) / 1000;
                b.this.jyU.setProgressImage(i, (int) duration);
                b.this.jwo.cvn().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void cvi() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void cvj() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> cvy() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void eo(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, cvy());
        this.jyX.setData(list);
    }

    public void cvz() {
        this.jyY.setVideoSize(this.jwo.cvn().getWidth(), this.jwo.cvn().getHeight());
        this.jyY.setVideoLocation(this.jwo.cvn().getLeft(), this.jwo.cvn().getTop(), this.jwo.cvn().getRight(), this.jwo.cvn().getBottom());
    }

    public void cgk() {
        this.jyY.cgk();
    }

    public String getText() {
        return this.jyY.getText();
    }

    public Bitmap B(Bitmap bitmap) {
        this.jyY.cgk();
        String text = this.jyY.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.jwo.cvn().getWidth();
        int height = this.jwo.cvn().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.jyY.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.jwo.cvn().getLeft(), this.jwo.cvn().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.jyU.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jyU.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.l(this.mRootView, R.color.cp_bg_line_d);
    }

    public void cX(View view) {
        this.jyY = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.jyY.setParentViewController(this);
        this.jyV = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("video_cover_first_in", true)) {
            this.jyV.setVisibility(0);
            this.jyV.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.jyV.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rF(boolean z) {
        this.jyY.rF(z);
        if (z) {
            this.jyU.seekTo(this.jyU.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.jyU.seekTo(b.this.jyU.getCurrentPosition());
                b.this.jwo.cvp();
            }
        }, 500L);
    }

    public void release() {
        if (this.jyU != null) {
            this.jyU.release();
        }
        if (this.jyY != null) {
            this.jyY.onDestroy();
        }
    }
}
