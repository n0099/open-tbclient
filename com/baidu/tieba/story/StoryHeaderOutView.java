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
    private Drawable aOh;
    private int aiY;
    private int aiZ;
    protected int akc;
    private Paint fWq;
    private float fWr;
    private float fWs;
    private float fWt;
    private RectF fWu;
    private int fWv;
    private Paint fWw;
    private m fWx;
    private PaintFlagsDrawFilter fWy;
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
        this.aiY = d.g.transparent_bg;
        this.aiZ = d.e.cp_bg_line_d;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.aiZ);
        setDefaultResource(this.aiY);
        setDefaultErrorResource(d.g.icon_default_avatar100);
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds3));
        this.fWw = new Paint();
        this.fWw.setStyle(Paint.Style.STROKE);
        this.fWw.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds1));
        this.fWq = new Paint();
        this.fWq.setStyle(Paint.Style.STROKE);
        this.fWq.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds3));
        setMaskColor(0);
        this.fWv = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds2);
        this.fWx = new m(this);
        this.aOh = aj.getDrawable(d.g.transparent_bg);
        this.mBmp = BitmapHelper.getCashBitmap(d.g.btn_story_loading);
        this.fWy = new PaintFlagsDrawFilter(0, 3);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void wd() {
        if (!this.aNK) {
            this.aNK = true;
        } else if (this.aNP != null && this.aNP.aJd) {
            this.aNP.FV();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            canvas.setDrawFilter(this.fWy);
            if (this.akc == 0) {
                this.mPaint.setColor(aj.getColor(d.e.cp_link_tip_g));
                canvas.drawCircle(this.fWr, this.fWs, this.fWr - this.fWv, this.mPaint);
                this.aOh.draw(canvas);
            } else if (this.akc == 2) {
                this.fWq.setColor(aj.getColor(d.e.cp_link_tip_g));
                canvas.drawArc(this.fWu, 0.0f, this.fWt, false, this.fWq);
                this.aOh.draw(canvas);
            } else if (this.akc == 1) {
                canvas.drawBitmap(this.mBmp, 0.0f, 0.0f, this.fWq);
                if (this.fWx != null && !this.fWx.isRunning()) {
                    this.fWx.bD(this);
                }
            } else if (this.akc == 3) {
                this.fWw.setColor(aj.getColor(d.e.cp_cont_e));
                canvas.drawCircle(this.fWr, this.fWs, this.fWr - this.fWv, this.fWw);
                this.aOh.draw(canvas);
            } else if (this.akc == 4) {
                this.mPaint.setColor(aj.getColor(d.e.cp_cont_h));
                canvas.drawCircle(this.fWr, this.fWs, this.fWr - this.fWv, this.mPaint);
                this.aOh.draw(canvas);
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
        this.fWr = this.mWidth / 2.0f;
        this.fWs = this.mHeight / 2.0f;
        this.fWu = new RectF(this.fWv + 0, this.fWv + 0, this.mWidth - this.fWv, this.mHeight - this.fWv);
    }

    @Override // com.baidu.tieba.story.b
    public void bmV() {
        if (this.fWx != null) {
            setMaskColor(2);
            this.fWx.bne();
        }
    }

    @Override // com.baidu.tieba.story.b
    public void ab(float f) {
        setValueFloat(f);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bmW() {
        setMaskColor(0);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bmU() {
    }

    public void setValueFloat(float f) {
        this.fWt = f;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void bmY() {
        if (this.fWx != null) {
            this.fWx.bmY();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akc == 1) {
            this.mBmp = aj.cR(d.g.btn_story_loading);
            invalidate();
        }
    }
}
