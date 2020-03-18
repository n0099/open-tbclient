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
    private CoverSeekBar kAG;
    private LinearLayout kAH;
    private HListView kAI;
    private com.baidu.tieba.video.editvideo.a.a kAJ;
    private CoverPendantDragView kAK;
    private a kyf;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.kyf = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.kAG = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.kAI = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.kAJ = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.kAJ.a(new a.InterfaceC0620a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0620a
            public void a(View view, int i, PendantData pendantData) {
                b.this.kAK.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.X("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.kAI.setAdapter((ListAdapter) this.kAJ);
        this.kAJ.setData(cQT());
        this.kAG.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.kyf.cQJ().getDuration() * i) / 1000;
                b.this.kAG.setProgressImage(i, (int) duration);
                b.this.kyf.cQJ().seekTo((int) duration);
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

    private List<PendantData> cQT() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void ep(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, cQT());
        this.kAJ.setData(list);
    }

    public void cQU() {
        this.kAK.setVideoSize(this.kyf.cQJ().getWidth(), this.kyf.cQJ().getHeight());
        this.kAK.setVideoLocation(this.kyf.cQJ().getLeft(), this.kyf.cQJ().getTop(), this.kyf.cQJ().getRight(), this.kyf.cQJ().getBottom());
    }

    public void hideSoftKeyPad() {
        this.kAK.hideSoftKeyPad();
    }

    public String getText() {
        return this.kAK.getText();
    }

    public Bitmap z(Bitmap bitmap) {
        this.kAK.hideSoftKeyPad();
        String text = this.kAK.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.kyf.cQJ().getWidth();
        int height = this.kyf.cQJ().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.kAK.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.kyf.cQJ().getLeft(), this.kyf.cQJ().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.kAG.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.kAG.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void cW(View view) {
        this.kAK = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.kAK.setParentViewController(this);
        this.kAH = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("video_cover_first_in", true)) {
            this.kAH.setVisibility(0);
            this.kAH.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.kAH.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void tu(boolean z) {
        this.kAK.tu(z);
        if (z) {
            this.kAG.seekTo(this.kAG.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.kAG.seekTo(b.this.kAG.getCurrentPosition());
                b.this.kyf.cQL();
            }
        }, 500L);
    }

    public void release() {
        if (this.kAG != null) {
            this.kAG.release();
        }
        if (this.kAK != null) {
            this.kAK.onDestroy();
        }
    }
}
