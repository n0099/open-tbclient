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
    private int ajw;
    private int ajx;
    protected int akb;
    private Paint fYM;
    private float fYN;
    private float fYO;
    private float fYP;
    private RectF fYQ;
    private int fYR;
    private Paint fYS;
    private m fYT;
    private Drawable fYU;
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
        this.akb = 0;
        this.ajw = d.g.transparent_bg;
        this.ajx = d.e.cp_bg_line_d;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.ajx);
        setDefaultResource(this.ajw);
        setDefaultErrorResource(d.g.icon_default_avatar100);
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(k.f(TbadkCoreApplication.getInst(), d.f.ds3));
        this.fYS = new Paint();
        this.fYS.setStyle(Paint.Style.STROKE);
        this.fYS.setStrokeWidth(k.f(TbadkCoreApplication.getInst(), d.f.ds1));
        this.fYM = new Paint();
        this.fYM.setStyle(Paint.Style.STROKE);
        this.fYM.setStrokeWidth(k.f(TbadkCoreApplication.getInst(), d.f.ds3));
        setMaskColor(0);
        this.fYR = k.f(TbadkCoreApplication.getInst(), d.f.ds2);
        this.fYT = new m(this);
        this.fYU = aj.getDrawable(d.g.transparent_bg);
        this.mBmp = BitmapHelper.getCashBitmap(d.g.btn_story_loading);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void wy() {
        if (!this.aNV) {
            this.aNV = true;
        } else if (this.aOa != null && this.aOa.aJC) {
            this.aOa.Gq();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            if (this.akb == 0) {
                this.mPaint.setColor(aj.getColor(d.e.cp_link_tip_g));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(aj.getColor(d.e.cp_link_tip_g_1));
                }
                canvas.drawCircle(this.fYN, this.fYO, this.fYN - this.fYR, this.mPaint);
                this.fYU.draw(canvas);
            } else if (this.akb == 2) {
                this.fYM.setColor(aj.getColor(d.e.cp_link_tip_g));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(aj.getColor(d.e.cp_link_tip_g_1));
                }
                canvas.drawArc(this.fYQ, 0.0f, this.fYP, false, this.fYM);
                this.fYU.draw(canvas);
            } else if (this.akb == 1) {
                canvas.drawBitmap(this.mBmp, 0.0f, 0.0f, this.fYM);
                if (this.fYT != null && !this.fYT.isRunning()) {
                    this.fYT.bD(this);
                }
            } else if (this.akb == 3) {
                this.fYS.setColor(aj.getColor(d.e.cp_cont_e));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(aj.getColor(d.e.cp_cont_e_1));
                }
                canvas.drawCircle(this.fYN, this.fYO, this.fYN - this.fYR, this.fYS);
                this.fYU.draw(canvas);
            } else if (this.akb == 4) {
                this.mPaint.setColor(aj.getColor(d.e.cp_cont_h));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(aj.getColor(d.e.cp_cont_h_1));
                }
                canvas.drawCircle(this.fYN, this.fYO, this.fYN - this.fYR, this.mPaint);
                this.fYU.draw(canvas);
            }
        }
    }

    public void setMaskColor(int i) {
        this.akb = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.fYN = this.mWidth / 2.0f;
        this.fYO = this.mHeight / 2.0f;
        this.fYQ = new RectF(this.fYR + 0, this.fYR + 0, this.mWidth - this.fYR, this.mHeight - this.fYR);
    }

    @Override // com.baidu.tieba.story.b
    public void bob() {
        if (this.fYT != null) {
            setMaskColor(2);
            this.fYT.bok();
        }
    }

    @Override // com.baidu.tieba.story.b
    public void Y(float f) {
        setValueFloat(f);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void boc() {
        setMaskColor(0);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void boa() {
    }

    public void setValueFloat(float f) {
        this.fYP = f;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void boe() {
        if (this.fYT != null) {
            this.fYT.boe();
        }
    }

    public void onChangeSkinType(int i) {
        this.mBmp = aj.cT(d.g.btn_story_loading);
        if (this.akb == 1) {
            invalidate();
        }
    }
}
