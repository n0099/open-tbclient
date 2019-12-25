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
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.base.c {
    private a krH;
    private CoverSeekBar kui;
    private LinearLayout kuj;
    private HListView kuk;
    private com.baidu.tieba.video.editvideo.a.a kul;
    private CoverPendantDragView kum;
    private Resources mResources;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.krH = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.mResources = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.kui = (CoverSeekBar) this.mRootView.findViewById(R.id.cover_seek_bar);
        this.kuk = (HListView) this.mRootView.findViewById(R.id.pendant_list_view);
        this.kul = new com.baidu.tieba.video.editvideo.a.a(getPageContext());
        this.kul.a(new a.InterfaceC0606a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.a.a.InterfaceC0606a
            public void a(View view, int i, PendantData pendantData) {
                b.this.kum.a(view, pendantData);
                an anVar = new an("c12305");
                anVar.Z("obj_locate", i + 1);
                TiebaStatic.log(anVar);
            }
        });
        this.kuk.setAdapter((ListAdapter) this.kul);
        this.kul.setData(cNY());
        this.kui.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.krH.cNO().getDuration() * i) / 1000;
                b.this.kui.setProgressImage(i, (int) duration);
                b.this.krH.cNO().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void cNI() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void cNJ() {
                TiebaStatic.log("c12304");
            }
        });
    }

    private List<PendantData> cNY() {
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
        list.addAll(0, cNY());
        this.kul.setData(list);
    }

    public void cNZ() {
        this.kum.setVideoSize(this.krH.cNO().getWidth(), this.krH.cNO().getHeight());
        this.kum.setVideoLocation(this.krH.cNO().getLeft(), this.krH.cNO().getTop(), this.krH.cNO().getRight(), this.krH.cNO().getBottom());
    }

    public void hideSoftKeyPad() {
        this.kum.hideSoftKeyPad();
    }

    public String getText() {
        return this.kum.getText();
    }

    public Bitmap z(Bitmap bitmap) {
        this.kum.hideSoftKeyPad();
        String text = this.kum.getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.krH.cNO().getWidth();
        int height = this.krH.cNO().getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap tempBitmap = this.kum.getTempBitmap();
        if (tempBitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(width2 / width, height2 / height);
            Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.krH.cNO().getLeft(), this.krH.cNO().getTop(), width, height, matrix, true);
            if (createBitmap2 != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.kui.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.kui.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void cO(View view) {
        this.kum = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
        this.kum.setParentViewController(this);
        this.kuj = (LinearLayout) view.findViewById(R.id.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("video_cover_first_in", true)) {
            this.kuj.setVisibility(0);
            this.kuj.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.kuj.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void sY(boolean z) {
        this.kum.sY(z);
        if (z) {
            this.kui.seekTo(this.kui.getCurrentPosition());
        }
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.kui.seekTo(b.this.kui.getCurrentPosition());
                b.this.krH.cNQ();
            }
        }, 500L);
    }

    public void release() {
        if (this.kui != null) {
            this.kui.release();
        }
        if (this.kum != null) {
            this.kum.onDestroy();
        }
    }
}
