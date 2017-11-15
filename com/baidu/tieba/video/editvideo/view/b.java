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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.a.a;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c {
    private Resources fOt;
    private a gEN;
    private CoverSeekBar gGM;
    private LinearLayout gGN;
    private HListView gGO;
    private com.baidu.tieba.video.editvideo.a.a gGP;
    private CoverPendantDragView gGQ;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.gEN = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.h.edit_cover_layout, (ViewGroup) null);
        this.fOt = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gGM = (CoverSeekBar) this.mRootView.findViewById(d.g.cover_seek_bar);
        this.gGO = (HListView) this.mRootView.findViewById(d.g.pendant_list_view);
        this.gGP = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.gGP.a(new a.InterfaceC0133a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0133a
            public void a(View view, int i, PendantData pendantData) {
                b.this.gGQ.a(view, pendantData);
                ak akVar = new ak("c12305");
                akVar.r("obj_locate", i + 1);
                TiebaStatic.log(akVar);
            }
        });
        this.gGO.setAdapter((ListAdapter) this.gGP);
        this.gGP.setData(bzA());
        this.gGM.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.gEN.bzu().getDuration() * i) / 1000;
                b.this.gGM.ca(i, (int) duration);
                b.this.gEN.bzu().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bzp() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bzq() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> bzA() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PendantData(0));
        arrayList.add(1, new PendantData(1));
        arrayList.add(2, new PendantData(2));
        arrayList.add(3, new PendantData(3));
        return arrayList;
    }

    public void dC(List<PendantData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(0, bzA());
        this.gGP.setData(list);
    }

    public void bzB() {
        this.gGQ.setVideoSize(this.gEN.bzu().getWidth(), this.gEN.bzu().getHeight());
        this.gGQ.i(this.gEN.bzu().getLeft(), this.gEN.bzu().getTop(), this.gEN.bzu().getRight(), this.gEN.bzu().getBottom());
    }

    public void bin() {
        this.gGQ.bin();
    }

    public String getText() {
        return this.gGQ.getText();
    }

    public Bitmap j(Bitmap bitmap) {
        this.gGQ.bin();
        String text = this.gGQ.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.gEN.bzu().getWidth();
        int height = this.gEN.bzu().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.gGQ.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.gEN.bzu().getLeft(), this.gEN.bzu().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.gGM.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gGM.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.C0080d.cp_bg_line_d);
    }

    public void bM(View view) {
        this.gGQ = (CoverPendantDragView) view.findViewById(d.g.cover_pendant_view);
        this.gGQ.setParentViewController(this);
        this.gGN = (LinearLayout) view.findViewById(d.g.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.gGN.setVisibility(0);
            this.gGN.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.gGN.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void ne(boolean z) {
        this.gGQ.ne(z);
        if (z) {
            this.gGM.seekTo(this.gGM.getCurrentPosition());
        }
    }

    public void bzw() {
        this.gGQ.bzo();
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.gGM.seekTo(b.this.gGM.getCurrentPosition());
                b.this.gEN.bzv();
            }
        }, 500L);
    }

    public void release() {
        if (this.gGM != null) {
            this.gGM.release();
        }
        if (this.gGQ != null) {
            this.gGQ.onDestroy();
        }
    }
}
