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
    private Paint fWp;
    private float fWq;
    private float fWr;
    private float fWs;
    private RectF fWt;
    private int fWu;
    private Paint fWv;
    private m fWw;
    private PaintFlagsDrawFilter fWx;
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
        this.fWv = new Paint();
        this.fWv.setStyle(Paint.Style.STROKE);
        this.fWv.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds1));
        this.fWp = new Paint();
        this.fWp.setStyle(Paint.Style.STROKE);
        this.fWp.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds3));
        setMaskColor(0);
        this.fWu = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds2);
        this.fWw = new m(this);
        this.aOh = aj.getDrawable(d.g.transparent_bg);
        this.mBmp = BitmapHelper.getCashBitmap(d.g.btn_story_loading);
        this.fWx = new PaintFlagsDrawFilter(0, 3);
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
            canvas.setDrawFilter(this.fWx);
            if (this.akc == 0) {
                this.mPaint.setColor(aj.getColor(d.e.cp_link_tip_g));
                canvas.drawCircle(this.fWq, this.fWr, this.fWq - this.fWu, this.mPaint);
                this.aOh.draw(canvas);
            } else if (this.akc == 2) {
                this.fWp.setColor(aj.getColor(d.e.cp_link_tip_g));
                canvas.drawArc(this.fWt, 0.0f, this.fWs, false, this.fWp);
                this.aOh.draw(canvas);
            } else if (this.akc == 1) {
                canvas.drawBitmap(this.mBmp, 0.0f, 0.0f, this.fWp);
                if (this.fWw != null && !this.fWw.isRunning()) {
                    this.fWw.bD(this);
                }
            } else if (this.akc == 3) {
                this.fWv.setColor(aj.getColor(d.e.cp_cont_e));
                canvas.drawCircle(this.fWq, this.fWr, this.fWq - this.fWu, this.fWv);
                this.aOh.draw(canvas);
            } else if (this.akc == 4) {
                this.mPaint.setColor(aj.getColor(d.e.cp_cont_h));
                canvas.drawCircle(this.fWq, this.fWr, this.fWq - this.fWu, this.mPaint);
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
        this.fWq = this.mWidth / 2.0f;
        this.fWr = this.mHeight / 2.0f;
        this.fWt = new RectF(this.fWu + 0, this.fWu + 0, this.mWidth - this.fWu, this.mHeight - this.fWu);
    }

    @Override // com.baidu.tieba.story.b
    public void bmU() {
        if (this.fWw != null) {
            setMaskColor(2);
            this.fWw.bnd();
        }
    }

    @Override // com.baidu.tieba.story.b
    public void ab(float f) {
        setValueFloat(f);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bmV() {
        setMaskColor(0);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bmT() {
    }

    public void setValueFloat(float f) {
        this.fWs = f;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void bmX() {
        if (this.fWw != null) {
            this.fWw.bmX();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akc == 1) {
            this.mBmp = aj.cR(d.g.btn_story_loading);
            invalidate();
        }
    }
}
