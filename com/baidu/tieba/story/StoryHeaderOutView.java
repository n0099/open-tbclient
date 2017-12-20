package com.baidu.tieba.story;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class StoryHeaderOutView extends com.baidu.tbadk.widget.b implements b {
    private Drawable aOL;
    protected int akH;
    private Paint grq;
    private float grr;
    private float grs;
    private float grt;
    private RectF gru;
    private int grv;
    private Paint grw;
    private m grx;
    private PaintFlagsDrawFilter gry;
    private Bitmap mBmp;
    private int mColor;
    private int mDefaultBgId;
    private int mDefaultId;
    private int mHeight;
    private Paint mPaint;
    private int mSkinType;
    private int mWidth;

    public StoryHeaderOutView(Context context) {
        this(context, null, 0);
    }

    public StoryHeaderOutView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StoryHeaderOutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akH = 0;
        this.mDefaultId = d.f.transparent_bg;
        this.mDefaultBgId = d.C0096d.cp_bg_line_d;
        this.mSkinType = 3;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.mDefaultBgId);
        setDefaultResource(this.mDefaultId);
        setDefaultErrorResource(d.f.icon_default_avatar100);
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds3));
        this.grw = new Paint();
        this.grw.setStyle(Paint.Style.STROKE);
        this.grw.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds1));
        this.grq = new Paint();
        this.grq.setStyle(Paint.Style.STROKE);
        this.grq.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds3));
        setMaskColor(0);
        this.grv = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds2);
        this.grx = new m(this);
        this.aOL = aj.getDrawable(d.f.transparent_bg);
        this.mBmp = BitmapHelper.getCashBitmap(d.f.btn_story_loading);
        this.gry = new PaintFlagsDrawFilter(0, 3);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void startLogPerf() {
        if (!this.canLogPerf) {
            this.canLogPerf = true;
        } else if (this.mPerfLog != null && this.mPerfLog.aKn) {
            this.mPerfLog.Gu();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            canvas.setDrawFilter(this.gry);
            if (this.akH == 0) {
                this.mPaint.setColor(aj.getColor(d.C0096d.cp_link_tip_g));
                canvas.drawCircle(this.grr, this.grs, this.grr - this.grv, this.mPaint);
                this.aOL.draw(canvas);
            } else if (this.akH == 2) {
                this.grq.setColor(aj.getColor(d.C0096d.cp_link_tip_g));
                canvas.drawArc(this.gru, 0.0f, this.grt, false, this.grq);
                this.aOL.draw(canvas);
            } else if (this.akH == 1) {
                canvas.drawBitmap(this.mBmp, 0.0f, 0.0f, this.grq);
                if (this.grx != null && !this.grx.isRunning()) {
                    this.grx.bH(this);
                }
            } else if (this.akH == 3) {
                this.grw.setColor(aj.getColor(d.C0096d.cp_cont_e));
                canvas.drawCircle(this.grr, this.grs, this.grr - this.grv, this.grw);
                this.aOL.draw(canvas);
            } else if (this.akH == 4) {
                this.mPaint.setColor(aj.getColor(d.C0096d.cp_cont_h));
                canvas.drawCircle(this.grr, this.grs, this.grr - this.grv, this.mPaint);
                this.aOL.draw(canvas);
            }
        }
    }

    public void setMaskColor(int i) {
        this.akH = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.grr = this.mWidth / 2.0f;
        this.grs = this.mHeight / 2.0f;
        this.gru = new RectF(this.grv + 0, this.grv + 0, this.mWidth - this.grv, this.mHeight - this.grv);
    }

    @Override // com.baidu.tieba.story.b
    public void bsq() {
        if (this.grx != null) {
            setMaskColor(2);
            this.grx.bsz();
        }
    }

    @Override // com.baidu.tieba.story.b
    public void ak(float f) {
        setValueFloat(f);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bsr() {
        setMaskColor(0);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bsp() {
    }

    public void setValueFloat(float f) {
        this.grt = f;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void bst() {
        if (this.grx != null) {
            this.grx.bst();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akH == 1) {
            this.mBmp = aj.cR(d.f.btn_story_loading);
        }
        if (this.mSkinType != i) {
            invalidate();
            this.mSkinType = i;
        }
    }
}
