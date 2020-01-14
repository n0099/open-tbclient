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
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.base.c {
    private a kvp;
    private CoverSeekBar kxQ;
    private LinearLayout kxR;
    private HListView kxS;
    private com.baidu.tieba.video.editvideo.a.a kxT;
    private CoverPendantDragView kxU;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.kvp = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.kxQ = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.kxS = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.kxT = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.kxT.a(new a.InterfaceC0611a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0611a
            public void a(View view, int i, PendantData pendantData) {
                b.this.kxU.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.Z("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.kxS.setAdapter((ListAdapter) this.kxT);
        this.kxT.setData(cPd());
        this.kxQ.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.kvp.cOT().getDuration() * i) / 1000;
                b.this.kxQ.setProgressImage(i, (int) duration);
                b.this.kvp.cOT().seekTo((int) duration);
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

    private List<PendantData> cPd() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void et(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, cPd());
        this.kxT.setData(list);
    }

    public void cPe() {
        this.kxU.setVideoSize(this.kvp.cOT().getWidth(), this.kvp.cOT().getHeight());
        this.kxU.setVideoLocation(this.kvp.cOT().getLeft(), this.kvp.cOT().getTop(), this.kvp.cOT().getRight(), this.kvp.cOT().getBottom());
    }

    public void hideSoftKeyPad() {
        this.kxU.hideSoftKeyPad();
    }

    public String getText() {
        return this.kxU.getText();
    }

    public Bitmap z(Bitmap bitmap) {
        this.kxU.hideSoftKeyPad();
        String text = this.kxU.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.kvp.cOT().getWidth();
        int height = this.kvp.cOT().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.kxU.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.kvp.cOT().getLeft(), this.kvp.cOT().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.kxQ.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.kxQ.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void cU(View view) {
        this.kxU = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.kxU.setParentViewController(this);
        this.kxR = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("video_cover_first_in", true)) {
            this.kxR.setVisibility(0);
            this.kxR.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.kxR.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void tk(boolean z) {
        this.kxU.tk(z);
        if (z) {
            this.kxQ.seekTo(this.kxQ.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.kxQ.seekTo(b.this.kxQ.getCurrentPosition());
                b.this.kvp.cOV();
            }
        }, 500L);
    }

    public void release() {
        if (this.kxQ != null) {
            this.kxQ.release();
        }
        if (this.kxU != null) {
            this.kxU.onDestroy();
        }
    }
}
