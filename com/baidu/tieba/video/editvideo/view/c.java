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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
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
    private a mdr;
    private CoverSeekBar mgc;
    private LinearLayout mgd;
    private HListView mge;
    private com.baidu.tieba.video.editvideo.a.a mgf;
    private CoverPendantDragView mgg;

    public c(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.mdr = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.mgc = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.mge = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.mgf = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.mgf.a(new a.InterfaceC0762a() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0762a
            public void a(View view, int i, PendantData pendantData) {
                c.this.mgg.a(view, pendantData);
                ap apVar = new ap("c12305");
                apVar.ah("obj_locate", i + 1);
                TiebaStatic.log(apVar);
            }
        });
        this.mge.setAdapter((ListAdapter) this.mgf);
        this.mgf.setData(dqP());
        this.mgc.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (c.this.mdr.dqE().getDuration() * i) / 1000;
                c.this.mgc.setProgressImage(i, (int) duration);
                c.this.mdr.dqE().seekTo((int) duration);
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

    private List<PendantData> dqP() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void fg(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, dqP());
        this.mgf.setData(list);
    }

    public void dqQ() {
        this.mgg.setVideoSize(this.mdr.dqE().getWidth(), this.mdr.dqE().getHeight());
        this.mgg.setVideoLocation(this.mdr.dqE().getLeft(), this.mdr.dqE().getTop(), this.mdr.dqE().getRight(), this.mdr.dqE().getBottom());
    }

    public void hideSoftKeyPad() {
        this.mgg.hideSoftKeyPad();
    }

    public String getText() {
        return this.mgg.getText();
    }

    public Bitmap G(Bitmap bitmap) {
        this.mgg.hideSoftKeyPad();
        String text = this.mgg.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.mdr.dqE().getWidth();
        int height = this.mdr.dqE().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.mgg.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.mdr.dqE().getLeft(), this.mdr.dqE().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.mgc.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mgc.setData(str);
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void dm(View view) {
        this.mgg = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.mgg.setParentViewController(this);
        this.mgd = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("video_cover_first_in", true)) {
            this.mgd.setVisibility(0);
            this.mgd.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.mgd.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void vN(boolean z) {
        this.mgg.vN(z);
        if (z) {
            this.mgc.seekTo(this.mgc.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.mgc.seekTo(c.this.mgc.getCurrentPosition());
                c.this.mdr.dqG();
            }
        }, 500L);
    }

    public void release() {
        if (this.mgc != null) {
            this.mgc.release();
        }
        if (this.mgg != null) {
            this.mgg.onDestroy();
        }
    }
}
