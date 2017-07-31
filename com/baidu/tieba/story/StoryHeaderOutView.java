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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class StoryHeaderOutView extends com.baidu.tbadk.widget.b implements b {
    protected int akG;
    private int akb;
    private int akc;
    private Paint fXA;
    private m fXB;
    private Drawable fXC;
    private Paint fXu;
    private float fXv;
    private float fXw;
    private float fXx;
    private RectF fXy;
    private int fXz;
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
        this.akG = 0;
        this.akb = d.g.transparent_bg;
        this.akc = d.e.cp_bg_line_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.akc);
        setDefaultResource(this.akb);
        setDefaultErrorResource(d.g.icon_default_avatar100);
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(k.g(TbadkCoreApplication.getInst(), d.f.ds3));
        this.fXA = new Paint();
        this.fXA.setStyle(Paint.Style.STROKE);
        this.fXA.setStrokeWidth(k.g(TbadkCoreApplication.getInst(), d.f.ds1));
        this.fXu = new Paint();
        this.fXu.setStyle(Paint.Style.STROKE);
        this.fXu.setStrokeWidth(k.g(TbadkCoreApplication.getInst(), d.f.ds3));
        setMaskColor(0);
        this.fXz = k.g(TbadkCoreApplication.getInst(), d.f.ds2);
        this.fXB = new m(this);
        this.fXC = ai.getDrawable(d.g.transparent_bg);
        this.mBmp = BitmapHelper.getCashBitmap(d.g.btn_story_loading);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void wA() {
        if (!this.aOn) {
            this.aOn = true;
        } else if (this.aOs != null && this.aOs.aJZ) {
            this.aOs.Gs();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            if (this.akG == 0) {
                this.mPaint.setColor(ai.getColor(d.e.cp_link_tip_g));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(ai.getColor(d.e.cp_link_tip_g_1));
                }
                canvas.drawCircle(this.fXv, this.fXw, this.fXv - this.fXz, this.mPaint);
                this.fXC.draw(canvas);
            } else if (this.akG == 2) {
                this.fXu.setColor(ai.getColor(d.e.cp_link_tip_g));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(ai.getColor(d.e.cp_link_tip_g_1));
                }
                canvas.drawArc(this.fXy, 0.0f, this.fXx, false, this.fXu);
                this.fXC.draw(canvas);
            } else if (this.akG == 1) {
                canvas.drawBitmap(this.mBmp, 0.0f, 0.0f, this.fXu);
                if (this.fXB != null && !this.fXB.isRunning()) {
                    this.fXB.bv(this);
                }
            } else if (this.akG == 3) {
                this.fXA.setColor(ai.getColor(d.e.cp_cont_e));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(ai.getColor(d.e.cp_cont_e_1));
                }
                canvas.drawCircle(this.fXv, this.fXw, this.fXv - this.fXz, this.fXA);
                this.fXC.draw(canvas);
            } else if (this.akG == 4) {
                this.mPaint.setColor(ai.getColor(d.e.cp_cont_h));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(ai.getColor(d.e.cp_cont_h_1));
                }
                canvas.drawCircle(this.fXv, this.fXw, this.fXv - this.fXz, this.mPaint);
                this.fXC.draw(canvas);
            }
        }
    }

    public void setMaskColor(int i) {
        this.akG = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.fXv = this.mWidth / 2.0f;
        this.fXw = this.mHeight / 2.0f;
        this.fXy = new RectF(this.fXz + 0, this.fXz + 0, this.mWidth - this.fXz, this.mHeight - this.fXz);
    }

    @Override // com.baidu.tieba.story.b
    public void bod() {
        if (this.fXB != null) {
            setMaskColor(2);
            this.fXB.bol();
        }
    }

    @Override // com.baidu.tieba.story.b
    public void aj(float f) {
        setValueFloat(f);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void boe() {
        setMaskColor(0);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void boc() {
    }

    public void setValueFloat(float f) {
        this.fXx = f;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void bog() {
        if (this.fXB != null) {
            this.fXB.bog();
        }
    }

    public void onChangeSkinType(int i) {
        this.mBmp = ai.cS(d.g.btn_story_loading);
        if (this.akG == 1) {
            invalidate();
        }
    }
}
