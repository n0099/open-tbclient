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
    private a mdt;
    private CoverSeekBar mge;
    private LinearLayout mgf;
    private HListView mgg;
    private com.baidu.tieba.video.editvideo.a.a mgh;
    private CoverPendantDragView mgi;

    public c(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.mdt = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.mge = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.mgg = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.mgh = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.mgh.a(new a.InterfaceC0762a() { // from class: com.baidu.tieba.video.editvideo.view.c.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0762a
            public void a(View view, int i, PendantData pendantData) {
                c.this.mgi.a(view, pendantData);
                ap apVar = new ap("c12305");
                apVar.ah("obj_locate", i + 1);
                TiebaStatic.log(apVar);
            }
        });
        this.mgg.setAdapter((ListAdapter) this.mgh);
        this.mgh.setData(dqQ());
        this.mge.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.c.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (c.this.mdt.dqF().getDuration() * i) / 1000;
                c.this.mge.setProgressImage(i, (int) duration);
                c.this.mdt.dqF().seekTo((int) duration);
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

    private List<PendantData> dqQ() {
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
        list.addAll(0, dqQ());
        this.mgh.setData(list);
    }

    public void dqR() {
        this.mgi.setVideoSize(this.mdt.dqF().getWidth(), this.mdt.dqF().getHeight());
        this.mgi.setVideoLocation(this.mdt.dqF().getLeft(), this.mdt.dqF().getTop(), this.mdt.dqF().getRight(), this.mdt.dqF().getBottom());
    }

    public void hideSoftKeyPad() {
        this.mgi.hideSoftKeyPad();
    }

    public String getText() {
        return this.mgi.getText();
    }

    public Bitmap G(Bitmap bitmap) {
        this.mgi.hideSoftKeyPad();
        String text = this.mgi.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.mdt.dqF().getWidth();
        int height = this.mdt.dqF().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.mgi.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.mdt.dqF().getLeft(), this.mdt.dqF().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.mge.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mge.setData(str);
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void dm(View view) {
        this.mgi = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.mgi.setParentViewController(this);
        this.mgf = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("video_cover_first_in", true)) {
            this.mgf.setVisibility(0);
            this.mgf.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.c.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.mgf.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void vN(boolean z) {
        this.mgi.vN(z);
        if (z) {
            this.mge.seekTo(this.mge.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.mge.seekTo(c.this.mge.getCurrentPosition());
                c.this.mdt.dqH();
            }
        }, 500L);
    }

    public void release() {
        if (this.mge != null) {
            this.mge.release();
        }
        if (this.mgi != null) {
            this.mgi.onDestroy();
        }
    }
}
