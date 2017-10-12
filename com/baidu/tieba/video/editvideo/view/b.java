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
    private Resources fEU;
    private a gva;
    private CoverSeekBar gwm;
    private CoverTextLayout gwn;
    private LinearLayout gwo;
    private CoverDragLayout gwp;
    private EditText gwq;
    private FrameLayout gwr;
    private TextView gws;
    private View gwt;
    private View mRootView;

    public b(e eVar, a aVar) {
        super(eVar);
        this.gva = aVar;
        this.mRootView = LayoutInflater.from(eVar.getPageActivity()).inflate(d.j.edit_cover_layout, (ViewGroup) null);
        this.fEU = this.mRootView.getResources();
        initView();
    }

    private void initView() {
        this.gwm = (CoverSeekBar) this.mRootView.findViewById(d.h.cover_seek_bar);
        this.gwn = (CoverTextLayout) this.mRootView.findViewById(d.h.cover_text_layout);
        this.gwm.setOnProgressChanged(new CoverSeekBar.a() { // from class: com.baidu.tieba.video.editvideo.view.b.1
            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void onProgress(int i) {
                long duration = (b.this.gva.bwc().getDuration() * i) / 1000;
                b.this.gwm.bY(i, (int) duration);
                b.this.gva.bwc().seekTo((int) duration);
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bvX() {
            }

            @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.a
            public void bvY() {
                TiebaStatic.log("c12304");
            }
        });
        bwk();
    }

    public void beV() {
        if (this.gwr.getVisibility() == 0) {
            this.gws.setText(this.gwq.getText());
            this.gws.setVisibility(0);
            this.gwq.setVisibility(8);
            setEditTextEnable(false);
            HidenSoftKeyPad(this.gwq);
        }
    }

    public void bwj() {
        if (this.gwr.getVisibility() == 0) {
            this.gws.setText(this.gwq.getText());
            this.gws.setVisibility(8);
            this.gwq.setVisibility(0);
            setEditTextEnable(true);
            ShowSoftKeyPad(this.gwq);
        }
    }

    public void uy(int i) {
        switch (i) {
            case 0:
                this.gwr.setVisibility(8);
                this.gwq.setText("");
                int height = (this.gva.bwc().getHeight() - this.gwr.getHeight()) / 2;
                if (this.gwr.getTop() != height) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gwr.getLayoutParams();
                    layoutParams.setMargins(0, height, 0, 0);
                    this.gwr.setLayoutParams(layoutParams);
                }
                beV();
                return;
            case 1:
                this.gwr.setVisibility(0);
                this.gwr.setBackgroundResource(d.g.bg_cover_edit_blue);
                bwj();
                return;
            case 2:
                this.gwr.setVisibility(0);
                this.gwr.setBackgroundResource(d.g.bg_cover_edit_black);
                bwj();
                return;
            case 3:
                this.gwr.setVisibility(0);
                this.gwr.setBackgroundDrawable(null);
                bwj();
                return;
            default:
                return;
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.gwq.setFocusable(true);
            this.gwq.setFocusableInTouchMode(true);
            this.gwq.requestFocus();
            return;
        }
        this.gwq.setFocusable(false);
        this.gwq.setFocusableInTouchMode(false);
    }

    private void bwk() {
        this.gwn.setOnTextClickCallback(new CoverTextLayout.a() { // from class: com.baidu.tieba.video.editvideo.view.b.2
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
        if (this.gws == null || this.gws.getText() == null) {
            return null;
        }
        return this.gws.getText().toString();
    }

    public void bwl() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gwp.getLayoutParams();
        layoutParams.width = this.gva.bwc().getWidth();
        layoutParams.height = this.gva.bwc().getHeight();
        this.gwp.setLayoutParams(layoutParams);
        bZ(this.gva.bwc().getWidth(), l.ad(TbadkCoreApplication.getInst()));
    }

    private void bZ(int i, int i2) {
        if (i != i2) {
            int f = (int) ((l.f(TbadkCoreApplication.getInst(), d.f.ds100) * i) / i2);
            ((FrameLayout.LayoutParams) this.gws.getLayoutParams()).height = f;
            ((FrameLayout.LayoutParams) this.gwq.getLayoutParams()).height = f;
            float f2 = (l.f(this.mContext.getPageActivity(), d.f.fontsize40) * i) / i2;
            this.gws.setTextSize(0, f2);
            this.gwq.setTextSize(0, f2);
        }
    }

    public Bitmap j(Bitmap bitmap) {
        beV();
        String text = getText();
        if (bitmap == null || TextUtils.isEmpty(text)) {
            return null;
        }
        int width = this.gwp.getWidth();
        int height = this.gwp.getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        this.gwr.buildDrawingCache();
        Bitmap drawingCache = this.gwr.getDrawingCache();
        Matrix matrix = new Matrix();
        matrix.postScale(width2 / width, height2 / height);
        Bitmap createBitmap2 = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
        if (createBitmap2 != null) {
            canvas.drawBitmap(createBitmap2, (this.gwr.getLeft() * width2) / width, (this.gwr.getTop() * height2) / height, (Paint) null);
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public int getCurrentPosition() {
        return this.gwm.getCurrentPosition();
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gwm.setData(str);
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        aj.k(this.mRootView, d.e.cp_bg_line_d);
    }

    public void bJ(View view) {
        this.gwt = view.findViewById(d.h.center_container);
        this.gwp = (CoverDragLayout) view.findViewById(d.h.cover_layout);
        this.gwq = (EditText) view.findViewById(d.h.cover_edit);
        this.gwr = (FrameLayout) view.findViewById(d.h.cover_edit_container);
        this.gws = (TextView) view.findViewById(d.h.cover_text);
        this.gwr.setVisibility(8);
        this.gwp.a(this, this.gwr);
        this.gwq.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.video.editvideo.view.b.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    b.this.bwj();
                } else {
                    b.this.beV();
                }
            }
        });
        this.gwt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.beV();
            }
        });
        this.gwo = (LinearLayout) view.findViewById(d.h.cover_tips);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("video_cover_first_in", true)) {
            this.gwo.setVisibility(0);
            this.gwo.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.video.editvideo.view.b.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.gwo.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
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
            if (this.gwn.getCurrentTextIndex() != 0) {
                this.gwr.setVisibility(0);
                bwj();
            }
            this.gwm.seekTo(this.gwm.getCurrentPosition());
        } else if (this.gwn.getCurrentTextIndex() != 0) {
            this.gwr.setVisibility(8);
        }
    }

    public void bwe() {
        this.gwr.destroyDrawingCache();
    }

    public void onPause() {
    }

    public void onResume() {
        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.b.6
            @Override // java.lang.Runnable
            public void run() {
                b.this.gwm.seekTo(b.this.gwm.getCurrentPosition());
                b.this.gva.bwd();
            }
        }, 500L);
    }

    public void release() {
        if (this.gwm != null) {
            this.gwm.release();
        }
    }
}
