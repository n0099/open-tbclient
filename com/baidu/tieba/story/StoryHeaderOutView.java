package com.baidu.tieba.story;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class StoryHeaderOutView extends com.baidu.tbadk.widget.b implements b {
    private int ajx;
    private int ajy;
    protected int akc;
    private Paint fXS;
    private float fXT;
    private float fXU;
    private float fXV;
    private RectF fXW;
    private int fXX;
    private Paint fXY;
    private m fXZ;
    private Drawable fYa;
    private Bitmap mBmp;
    private int mColor;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    public StoryHeaderOutView(Context context) {
        this(context, null, 0);
    }

    public StoryHeaderOutView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StoryHeaderOutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akc = 0;
        this.ajx = d.g.transparent_bg;
        this.ajy = d.e.cp_bg_line_d;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.ajy);
        setDefaultResource(this.ajx);
        setDefaultErrorResource(d.g.icon_default_avatar100);
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(k.g(TbadkCoreApplication.getInst(), d.f.ds3));
        this.fXY = new Paint();
        this.fXY.setStyle(Paint.Style.STROKE);
        this.fXY.setStrokeWidth(k.g(TbadkCoreApplication.getInst(), d.f.ds1));
        this.fXS = new Paint();
        this.fXS.setStyle(Paint.Style.STROKE);
        this.fXS.setStrokeWidth(k.g(TbadkCoreApplication.getInst(), d.f.ds3));
        setMaskColor(0);
        this.fXX = k.g(TbadkCoreApplication.getInst(), d.f.ds2);
        this.fXZ = new m(this);
        this.fYa = aj.getDrawable(d.g.transparent_bg);
        this.mBmp = BitmapHelper.getCashBitmap(d.g.btn_story_loading);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void wy() {
        if (!this.aNY) {
            this.aNY = true;
        } else if (this.aOd != null && this.aOd.aJF) {
            this.aOd.Gq();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            if (this.akc == 0) {
                this.mPaint.setColor(aj.getColor(d.e.cp_link_tip_g));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(aj.getColor(d.e.cp_link_tip_g_1));
                }
                canvas.drawCircle(this.fXT, this.fXU, this.fXT - this.fXX, this.mPaint);
                this.fYa.draw(canvas);
            } else if (this.akc == 2) {
                this.fXS.setColor(aj.getColor(d.e.cp_link_tip_g));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(aj.getColor(d.e.cp_link_tip_g_1));
                }
                canvas.drawArc(this.fXW, 0.0f, this.fXV, false, this.fXS);
                this.fYa.draw(canvas);
            } else if (this.akc == 1) {
                canvas.drawBitmap(this.mBmp, 0.0f, 0.0f, this.fXS);
                if (this.fXZ != null && !this.fXZ.isRunning()) {
                    this.fXZ.bD(this);
                }
            } else if (this.akc == 3) {
                this.fXY.setColor(aj.getColor(d.e.cp_cont_e));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(aj.getColor(d.e.cp_cont_e_1));
                }
                canvas.drawCircle(this.fXT, this.fXU, this.fXT - this.fXX, this.fXY);
                this.fYa.draw(canvas);
            } else if (this.akc == 4) {
                this.mPaint.setColor(aj.getColor(d.e.cp_cont_h));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(aj.getColor(d.e.cp_cont_h_1));
                }
                canvas.drawCircle(this.fXT, this.fXU, this.fXT - this.fXX, this.mPaint);
                this.fYa.draw(canvas);
            }
        }
    }

    public void setMaskColor(int i) {
        this.akc = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.fXT = this.mWidth / 2.0f;
        this.fXU = this.mHeight / 2.0f;
        this.fXW = new RectF(this.fXX + 0, this.fXX + 0, this.mWidth - this.fXX, this.mHeight - this.fXX);
    }

    @Override // com.baidu.tieba.story.b
    public void bnQ() {
        if (this.fXZ != null) {
            setMaskColor(2);
            this.fXZ.bnZ();
        }
    }

    @Override // com.baidu.tieba.story.b
    public void Y(float f) {
        setValueFloat(f);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bnR() {
        setMaskColor(0);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bnP() {
    }

    public void setValueFloat(float f) {
        this.fXV = f;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void bnT() {
        if (this.fXZ != null) {
            this.fXZ.bnT();
        }
    }

    public void onChangeSkinType(int i) {
        this.mBmp = aj.cT(d.g.btn_story_loading);
        if (this.akc == 1) {
            invalidate();
        }
    }
}
