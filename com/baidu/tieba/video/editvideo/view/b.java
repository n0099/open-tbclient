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
    private Resources fEV;
    private a gvb;
    private CoverSeekBar gwn;
    private CoverTextLayout gwo;
    private LinearLayout gwp;
    private CoverDragLayout gwq;
    private EditText gwr;
    private FrameLayout gws;
    private TextView gwt;
    private View gwu;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.gvb = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.j.edit_cover_layout, (ViewGroup) null);
        this.fEV = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gwn = (CoverSeekBar) this.mRootView.findViewById(d.h.cover_seek_bar);
        this.gwo = (CoverTextLayout) this.mRootView.findViewById(d.h.cover_text_layout);
        this.gwn.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.gvb.bwd().getDuration() * i) / 1000;
                b.this.gwn.bY(i, (int) duration);
                b.this.gvb.bwd().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bvY() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bvZ() {
                TiebaStatic.log("c12304");
            }
        });
        bwl();
    }

    public void beW() {
        if (this.gws.getVisibility() == 0) {
            this.gwt.setText(this.gwr.getText());
            this.gwt.setVisibility(0);
            this.gwr.setVisibility(8);
            setEditTextEnable(false);
            HidenSoftKeyPad(this.gwr);
        }
    }

    public void bwk() {
        if (this.gws.getVisibility() == 0) {
            this.gwt.setText(this.gwr.getText());
            this.gwt.setVisibility(8);
            this.gwr.setVisibility(0);
            setEditTextEnable(true);
            ShowSoftKeyPad(this.gwr);
        }
    }

    public void uy(int i) {
        switch (i) {
            case 0:
                this.gws.setVisibility(8);
                this.gwr.setText("");
                int height = (this.gvb.bwd().getHeight() - this.gws.getHeight()) / 2;
                if (this.gws.getTop() != height) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gws.getLayoutParams();
                    layoutParams.setMargins(0, height, 0, 0);
                    this.gws.setLayoutParams(layoutParams);
                }
                beW();
                return;
            case 1:
                this.gws.setVisibility(0);
                this.gws.setBackgroundResource(d.g.bg_cover_edit_blue);
                bwk();
                return;
            case 2:
                this.gws.setVisibility(0);
                this.gws.setBackgroundResource(d.g.bg_cover_edit_black);
                bwk();
                return;
            case 3:
                this.gws.setVisibility(0);
                this.gws.setBackgroundDrawable(null);
                bwk();
                return;
            default:
                return;
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.gwr.setFocusable(true);
            this.gwr.setFocusableInTouchMode(true);
            this.gwr.requestFocus();
            return;
        }
        this.gwr.setFocusable(false);
        this.gwr.setFocusableInTouchMode(false);
    }

    private void bwl() {
        this.gwo.setOnTextClickCallback(new CoverTextLayout.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
            @Override // com.baidu.tieba.video.editvideo.view.CoverTextLayout.a
            public void bI(View view) {
                Integer num = (Integer) view.getTag();
                b.this.uy(num.intValue());
                ak akVar = new ak("c12305");
                akVar.r("obj_locate", num.intValue() + 1);
                TiebaStatic.log(akVar);
            }
        });
    }

    public String getText() {
        if (this.gwt == null || this.gwt.getText() == null) {
            return null;
        }
        return this.gwt.getText().toString();
    }

    public void bwm() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gwq.getLayoutParams();
        layoutParams.width = this.gvb.bwd().getWidth();
        layoutParams.height = this.gvb.bwd().getHeight();
        this.gwq.setLayoutParams(layoutParams);
        bZ(this.gvb.bwd().getWidth(), l.ad(TbadkCoreApplication.getInst()));
    }

    private void bZ(int i, int i2) {
        if (i != i2) {
            int f = (int) ((l.f(TbadkCoreApplication.getInst(), d.f.ds100) * i) / i2);
            ((FrameLayout.LayoutParams) this.gwt.getLayoutParams()).height = f;
            ((FrameLayout.LayoutParams) this.gwr.getLayoutParams()).height = f;
            float f2 = (l.f(this.mContext.getPageActivity(), d.f.fontsize40) * i) / i2;
            this.gwt.setTextSize(0, f2);
            this.gwr.setTextSize(0, f2);
        }
    }

    public Bitmap j(Bitmap bitmap) {
        beW();
        String text = getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.gwq.getWidth();
        int height = this.gwq.getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        this.gws.buildDrawingCache();
        Bitmap drawingCache = this.gws.getDrawingCache();
        Matrix matrix = new Matrix();
        matrix.postScale(width2 / width, height2 / height);
        Bitmap createBitmap2 = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        if (createBitmap2 != null) {
            canvas.drawBitmap(createBitmap2, (this.gws.getLeft() * width2) / width, (this.gws.getTop() * height2) / height, (Paint) null);
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.gwn.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gwn.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.e.cp_bg_line_d);
    }

    public void bJ(View view) {
        this.gwu = view.findViewById(d.h.center_container);
        this.gwq = (CoverDragLayout) view.findViewById(d.h.cover_layout);
        this.gwr = (EditText) view.findViewById(d.h.cover_edit);
        this.gws = (FrameLayout) view.findViewById(d.h.cover_edit_container);
        this.gwt = (TextView) view.findViewById(d.h.cover_text);
        this.gws.setVisibility(8);
        this.gwq.a(this, this.gws);
        this.gwr.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.video.editvideo.view.b.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    b.this.bwk();
                } else {
                    b.this.beW();
                }
            }
        });
        this.gwu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.beW();
            }
        });
        this.gwp = (LinearLayout) view.findViewById(d.h.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.gwp.setVisibility(0);
            this.gwp.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.gwp.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
                }
            }).start();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("video_cover_first_in", false);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void nc(boolean z) {
        if (z) {
            if (this.gwo.getCurrentTextIndex() != 0) {
                this.gws.setVisibility(0);
                bwk();
            }
            this.gwn.seekTo(this.gwn.getCurrentPosition());
        } else if (this.gwo.getCurrentTextIndex() != 0) {
            this.gws.setVisibility(8);
        }
    }

    public void bwf() {
        this.gws.destroyDrawingCache();
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.6
            @Override // java.lang.Runnable
            public void run() {
                b.this.gwn.seekTo(b.this.gwn.getCurrentPosition());
                b.this.gvb.bwe();
            }
        }, 500L);
    }

    public void release() {
        if (this.gwn != null) {
            this.gwn.release();
        }
    }
}
