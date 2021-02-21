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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.d {
    private Resources mResources;
    private View mRootView;
    private a nMp;
    private CoverSeekBar nOU;
    private LinearLayout nOV;
    private HListView nOW;
    private com.baidu.tieba.video.editvideo.a.a nOX;
    private CoverPendantDragView nOY;

    public c(f fVar, a aVar) {
        super(fVar);
        this.nMp = aVar;
        this.mRootView = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.nOU = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.nOW = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.nOX = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.nOX.a(new a.InterfaceC0887a() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0887a
            public void a(View view, int i, PendantData pendantData) {
                c.this.nOY.a(view, pendantData);
                ar arVar = new ar("c12305");
                arVar.ap("obj_locate", i + 1);
                TiebaStatic.log(arVar);
            }
        });
        this.nOW.setAdapter((ListAdapter) this.nOX);
        this.nOX.setData(dTw());
        this.nOU.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (c.this.nMp.dTm().getDuration() * i) / 1000;
                c.this.nOU.setProgressImage(i, (int) duration);
                c.this.nMp.dTm().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void dTg() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void dTh() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> dTw() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void fY(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, dTw());
        this.nOX.setData(list);
    }

    public void dTx() {
        this.nOY.setVideoSize(this.nMp.dTm().getWidth(), this.nMp.dTm().getHeight());
        this.nOY.setVideoLocation(this.nMp.dTm().getLeft(), this.nMp.dTm().getTop(), this.nMp.dTm().getRight(), this.nMp.dTm().getBottom());
    }

    public void hideSoftKeyPad() {
        this.nOY.hideSoftKeyPad();
    }

    public String getText() {
        return this.nOY.getText();
    }

    public Bitmap F(Bitmap bitmap) {
        this.nOY.hideSoftKeyPad();
        String text = this.nOY.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.nMp.dTm().getWidth();
        int height = this.nMp.dTm().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.nOY.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.nMp.dTm().getLeft(), this.nMp.dTm().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.nOU.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nOU.setData(str);
        }
    }

    public void onChangeSkinType(f fVar, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    public void em(View view) {
        this.nOY = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.nOY.setParentViewController(this);
        this.nOV = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("video_cover_first_in", true)) {
            this.nOV.setVisibility(0);
            this.nOV.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.nOV.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void yY(boolean z) {
        this.nOY.yY(z);
        if (z) {
            this.nOU.seekTo(this.nOU.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.nOU.seekTo(c.this.nOU.getCurrentPosition());
                c.this.nMp.dTo();
            }
        }, 500L);
    }

    public void release() {
        if (this.nOU != null) {
            this.nOU.release();
        }
        if (this.nOY != null) {
            this.nOY.onDestroy();
        }
    }
}
