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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends com.baidu.adp.base.c {
    private a joW;
    private CoverSeekBar jrC;
    private LinearLayout jrD;
    private HListView jrE;
    private com.baidu.tieba.video.editvideo.a.a jrF;
    private CoverPendantDragView jrG;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.joW = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.jrC = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.jrE = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.jrF = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.jrF.a(new a.InterfaceC0416a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0416a
            public void a(View view, int i, PendantData pendantData) {
                b.this.jrG.a(view, pendantData);
                am amVar = new am("c12305");
                amVar.P("obj_locate", i + 1);
                TiebaStatic.log(amVar);
            }
        });
        this.jrE.setAdapter((ListAdapter) this.jrF);
        this.jrF.setData(csq());
        this.jrC.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.joW.csf().getDuration() * i) / 1000;
                b.this.jrC.setProgressImage(i, (int) duration);
                b.this.joW.csf().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void csa() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void csb() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> csq() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void em(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, csq());
        this.jrF.setData(list);
    }

    public void csr() {
        this.jrG.setVideoSize(this.joW.csf().getWidth(), this.joW.csf().getHeight());
        this.jrG.setVideoLocation(this.joW.csf().getLeft(), this.joW.csf().getTop(), this.joW.csf().getRight(), this.joW.csf().getBottom());
    }

    public void cda() {
        this.jrG.cda();
    }

    public String getText() {
        return this.jrG.getText();
    }

    public Bitmap B(Bitmap bitmap) {
        this.jrG.cda();
        String text = this.jrG.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.joW.csf().getWidth();
        int height = this.joW.csf().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.jrG.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.joW.csf().getLeft(), this.joW.csf().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.jrC.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jrC.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        al.l(this.mRootView, R.color.cp_bg_line_d);
    }

    public void cS(View view) {
        this.jrG = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.jrG.setParentViewController(this);
        this.jrD = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("video_cover_first_in", true)) {
            this.jrD.setVisibility(0);
            this.jrD.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.jrD.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rq(boolean z) {
        this.jrG.rq(z);
        if (z) {
            this.jrC.seekTo(this.jrC.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.jrC.seekTo(b.this.jrC.getCurrentPosition());
                b.this.joW.csh();
            }
        }, 500L);
    }

    public void release() {
        if (this.jrC != null) {
            this.jrC.release();
        }
        if (this.jrG != null) {
            this.jrG.onDestroy();
        }
    }
}
