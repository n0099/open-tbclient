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
    private a joV;
    private CoverSeekBar jrB;
    private LinearLayout jrC;
    private HListView jrD;
    private com.baidu.tieba.video.editvideo.a.a jrE;
    private CoverPendantDragView jrF;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.joV = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.jrB = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.jrD = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.jrE = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.jrE.a(new a.InterfaceC0416a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0416a
            public void a(View view, int i, PendantData pendantData) {
                b.this.jrF.a(view, pendantData);
                am amVar = new am("c12305");
                amVar.P("obj_locate", i + 1);
                TiebaStatic.log(amVar);
            }
        });
        this.jrD.setAdapter((ListAdapter) this.jrE);
        this.jrE.setData(cso());
        this.jrB.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.joV.csd().getDuration() * i) / 1000;
                b.this.jrB.setProgressImage(i, (int) duration);
                b.this.joV.csd().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void crY() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void crZ() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> cso() {
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
        list.addAll(0, cso());
        this.jrE.setData(list);
    }

    public void csp() {
        this.jrF.setVideoSize(this.joV.csd().getWidth(), this.joV.csd().getHeight());
        this.jrF.setVideoLocation(this.joV.csd().getLeft(), this.joV.csd().getTop(), this.joV.csd().getRight(), this.joV.csd().getBottom());
    }

    public void ccX() {
        this.jrF.ccX();
    }

    public String getText() {
        return this.jrF.getText();
    }

    public Bitmap B(Bitmap bitmap) {
        this.jrF.ccX();
        String text = this.jrF.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.joV.csd().getWidth();
        int height = this.joV.csd().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.jrF.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.joV.csd().getLeft(), this.joV.csd().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.jrB.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jrB.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        al.l(this.mRootView, R.color.cp_bg_line_d);
    }

    public void cS(View view) {
        this.jrF = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.jrF.setParentViewController(this);
        this.jrC = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("video_cover_first_in", true)) {
            this.jrC.setVisibility(0);
            this.jrC.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.jrC.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void rq(boolean z) {
        this.jrF.rq(z);
        if (z) {
            this.jrB.seekTo(this.jrB.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.jrB.seekTo(b.this.jrB.getCurrentPosition());
                b.this.joV.csf();
            }
        }, 500L);
    }

    public void release() {
        if (this.jrB != null) {
            this.jrB.release();
        }
        if (this.jrF != null) {
            this.jrF.onDestroy();
        }
    }
}
