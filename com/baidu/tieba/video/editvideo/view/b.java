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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import com.baidu.tieba.video.editvideo.view.CoverTextLayout;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.base.c {
    private Resources fEG;
    private a guM;
    private CoverSeekBar gvY;
    private CoverTextLayout gvZ;
    private LinearLayout gwa;
    private CoverDragLayout gwb;
    private EditText gwc;
    private FrameLayout gwd;
    private TextView gwe;
    private View gwf;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.guM = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.j.edit_cover_layout, (ViewGroup) null);
        this.fEG = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gvY = (CoverSeekBar) this.mRootView.findViewById(d.h.cover_seek_bar);
        this.gvZ = (CoverTextLayout) this.mRootView.findViewById(d.h.cover_text_layout);
        this.gvY.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.guM.bvU().getDuration() * i) / 1000;
                b.this.gvY.bY(i, (int) duration);
                b.this.guM.bvU().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bvP() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bvQ() {
                TiebaStatic.log("c12304");
            }
        });
        bwc();
    }

    public void beQ() {
        if (this.gwd.getVisibility() == 0) {
            this.gwe.setText(this.gwc.getText());
            this.gwe.setVisibility(0);
            this.gwc.setVisibility(8);
            setEditTextEnable(false);
            HidenSoftKeyPad(this.gwc);
        }
    }

    public void bwb() {
        if (this.gwd.getVisibility() == 0) {
            this.gwe.setText(this.gwc.getText());
            this.gwe.setVisibility(8);
            this.gwc.setVisibility(0);
            setEditTextEnable(true);
            ShowSoftKeyPad(this.gwc);
        }
    }

    public void ux(int i) {
        switch (i) {
            case 0:
                this.gwd.setVisibility(8);
                this.gwc.setText("");
                int height = (this.guM.bvU().getHeight() - this.gwd.getHeight()) / 2;
                if (this.gwd.getTop() != height) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gwd.getLayoutParams();
                    layoutParams.setMargins(0, height, 0, 0);
                    this.gwd.setLayoutParams(layoutParams);
                }
                beQ();
                return;
            case 1:
                this.gwd.setVisibility(0);
                this.gwd.setBackgroundResource(d.g.bg_cover_edit_blue);
                bwb();
                return;
            case 2:
                this.gwd.setVisibility(0);
                this.gwd.setBackgroundResource(d.g.bg_cover_edit_black);
                bwb();
                return;
            case 3:
                this.gwd.setVisibility(0);
                this.gwd.setBackgroundDrawable(null);
                bwb();
                return;
            default:
                return;
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.gwc.setFocusable(true);
            this.gwc.setFocusableInTouchMode(true);
            this.gwc.requestFocus();
            return;
        }
        this.gwc.setFocusable(false);
        this.gwc.setFocusableInTouchMode(false);
    }

    private void bwc() {
        this.gvZ.setOnTextClickCallback(new CoverTextLayout.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverTextLayout.a
            public void bI(View view) {
                Integer num = (Integer) view.getTag();
                b.this.ux(num.intValue());
                ak akVar = new ak("c12305");
                akVar.r("obj_locate", num.intValue() + 1);
                TiebaStatic.log(akVar);
            }
        });
    }

    public String getText() {
        if (this.gwe == null || this.gwe.getText() == null) {
            return null;
        }
        return this.gwe.getText().toString();
    }

    public void bwd() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gwb.getLayoutParams();
        layoutParams.width = this.guM.bvU().getWidth();
        layoutParams.height = this.guM.bvU().getHeight();
        this.gwb.setLayoutParams(layoutParams);
        bZ(this.guM.bvU().getWidth(), l.ad(TbadkCoreApplication.getInst()));
    }

    private void bZ(int i, int i2) {
        if (i != i2) {
            int f = (int) ((l.f(TbadkCoreApplication.getInst(), d.f.ds100) * i) / i2);
            ((FrameLayout.LayoutParams) this.gwe.getLayoutParams()).height = f;
            ((FrameLayout.LayoutParams) this.gwc.getLayoutParams()).height = f;
            float f2 = (l.f(this.mContext.getPageActivity(), d.f.fontsize40) * i) / i2;
            this.gwe.setTextSize(0, f2);
            this.gwc.setTextSize(0, f2);
        }
    }

    public Bitmap j(Bitmap bitmap) {
        beQ();
        String text = getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.gwb.getWidth();
        int height = this.gwb.getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        this.gwd.buildDrawingCache();
        Bitmap drawingCache = this.gwd.getDrawingCache();
        Matrix matrix = new Matrix();
        matrix.postScale(width2 / width, height2 / height);
        Bitmap createBitmap2 = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        if (createBitmap2 != null) {
            canvas.drawBitmap(createBitmap2, (this.gwd.getLeft() * width2) / width, (this.gwd.getTop() * height2) / height, (Paint) null);
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.gvY.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gvY.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.e.cp_bg_line_d);
    }

    public void bJ(View view) {
        this.gwf = view.findViewById(d.h.center_container);
        this.gwb = (CoverDragLayout) view.findViewById(d.h.cover_layout);
        this.gwc = (EditText) view.findViewById(d.h.cover_edit);
        this.gwd = (FrameLayout) view.findViewById(d.h.cover_edit_container);
        this.gwe = (TextView) view.findViewById(d.h.cover_text);
        this.gwd.setVisibility(8);
        this.gwb.a(this, this.gwd);
        this.gwc.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.video.editvideo.view.b.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    b.this.bwb();
                } else {
                    b.this.beQ();
                }
            }
        });
        this.gwf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.beQ();
            }
        });
        this.gwa = (LinearLayout) view.findViewById(d.h.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.gwa.setVisibility(0);
            this.gwa.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.gwa.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nb(boolean z) {
        if (z) {
            if (this.gvZ.getCurrentTextIndex() != 0) {
                this.gwd.setVisibility(0);
                bwb();
            }
            this.gvY.seekTo(this.gvY.getCurrentPosition());
        } else if (this.gvZ.getCurrentTextIndex() != 0) {
            this.gwd.setVisibility(8);
        }
    }

    public void bvW() {
        this.gwd.destroyDrawingCache();
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.6
            @Override // java.lang.Runnable
            public void run() {
                b.this.gvY.seekTo(b.this.gvY.getCurrentPosition());
                b.this.guM.bvV();
            }
        }, 500L);
    }

    public void release() {
        if (this.gvY != null) {
            this.gvY.release();
        }
    }
}
