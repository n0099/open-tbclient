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
    private CoverSeekBar jBi;
    private LinearLayout jBj;
    private HListView jBk;
    private com.baidu.tieba.video.editvideo.a.a jBl;
    private CoverPendantDragView jBm;
    private a jyC;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.jyC = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.jBi = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.jBk = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.jBl = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.jBl.a(new a.InterfaceC0527a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0527a
            public void a(View view, int i, PendantData pendantData) {
                b.this.jBm.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.O("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.jBk.setAdapter((ListAdapter) this.jBl);
        this.jBl.setData(cua());
        this.jBi.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.jyC.ctP().getDuration() * i) / 1000;
                b.this.jBi.setProgressImage(i, (int) duration);
                b.this.jyC.ctP().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void ctJ() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void ctK() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> cua() {
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
        list.addAll(0, cua());
        this.jBl.setData(list);
    }

    public void cub() {
        this.jBm.setVideoSize(this.jyC.ctP().getWidth(), this.jyC.ctP().getHeight());
        this.jBm.setVideoLocation(this.jyC.ctP().getLeft(), this.jyC.ctP().getTop(), this.jyC.ctP().getRight(), this.jyC.ctP().getBottom());
    }

    public void hideSoftKeyPad() {
        this.jBm.hideSoftKeyPad();
    }

    public String getText() {
        return this.jBm.getText();
    }

    public Bitmap z(Bitmap bitmap) {
        this.jBm.hideSoftKeyPad();
        String text = this.jBm.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.jyC.ctP().getWidth();
        int height = this.jyC.ctP().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.jBm.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.jyC.ctP().getLeft(), this.jyC.ctP().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.jBi.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jBi.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void cT(View view) {
        this.jBm = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.jBm.setParentViewController(this);
        this.jBj = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("video_cover_first_in", true)) {
            this.jBj.setVisibility(0);
            this.jBj.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.jBj.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rr(boolean z) {
        this.jBm.rr(z);
        if (z) {
            this.jBi.seekTo(this.jBi.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.jBi.seekTo(b.this.jBi.getCurrentPosition());
                b.this.jyC.ctR();
            }
        }, 500L);
    }

    public void release() {
        if (this.jBi != null) {
            this.jBi.release();
        }
        if (this.jBm != null) {
            this.jBm.onDestroy();
        }
    }
}
