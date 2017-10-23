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
    private Drawable aNU;
    private int aiM;
    private int aiN;
    protected int ajQ;
    private Paint fWb;
    private float fWc;
    private float fWd;
    private float fWe;
    private RectF fWf;
    private int fWg;
    private Paint fWh;
    private m fWi;
    private PaintFlagsDrawFilter fWj;
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
        this.ajQ = 0;
        this.aiM = d.g.transparent_bg;
        this.aiN = d.e.cp_bg_line_d;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.aiN);
        setDefaultResource(this.aiM);
        setDefaultErrorResource(d.g.icon_default_avatar100);
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds3));
        this.fWh = new Paint();
        this.fWh.setStyle(Paint.Style.STROKE);
        this.fWh.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds1));
        this.fWb = new Paint();
        this.fWb.setStyle(Paint.Style.STROKE);
        this.fWb.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds3));
        setMaskColor(0);
        this.fWg = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds2);
        this.fWi = new m(this);
        this.aNU = aj.getDrawable(d.g.transparent_bg);
        this.mBmp = BitmapHelper.getCashBitmap(d.g.btn_story_loading);
        this.fWj = new PaintFlagsDrawFilter(0, 3);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void vW() {
        if (!this.aNx) {
            this.aNx = true;
        } else if (this.aNC != null && this.aNC.aIQ) {
            this.aNC.FP();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            canvas.setDrawFilter(this.fWj);
            if (this.ajQ == 0) {
                this.mPaint.setColor(aj.getColor(d.e.cp_link_tip_g));
                canvas.drawCircle(this.fWc, this.fWd, this.fWc - this.fWg, this.mPaint);
                this.aNU.draw(canvas);
            } else if (this.ajQ == 2) {
                this.fWb.setColor(aj.getColor(d.e.cp_link_tip_g));
                canvas.drawArc(this.fWf, 0.0f, this.fWe, false, this.fWb);
                this.aNU.draw(canvas);
            } else if (this.ajQ == 1) {
                canvas.drawBitmap(this.mBmp, 0.0f, 0.0f, this.fWb);
                if (this.fWi != null && !this.fWi.isRunning()) {
                    this.fWi.bD(this);
                }
            } else if (this.ajQ == 3) {
                this.fWh.setColor(aj.getColor(d.e.cp_cont_e));
                canvas.drawCircle(this.fWc, this.fWd, this.fWc - this.fWg, this.fWh);
                this.aNU.draw(canvas);
            } else if (this.ajQ == 4) {
                this.mPaint.setColor(aj.getColor(d.e.cp_cont_h));
                canvas.drawCircle(this.fWc, this.fWd, this.fWc - this.fWg, this.mPaint);
                this.aNU.draw(canvas);
            }
        }
    }

    public void setMaskColor(int i) {
        this.ajQ = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.fWc = this.mWidth / 2.0f;
        this.fWd = this.mHeight / 2.0f;
        this.fWf = new RectF(this.fWg + 0, this.fWg + 0, this.mWidth - this.fWg, this.mHeight - this.fWg);
    }

    @Override // com.baidu.tieba.story.b
    public void bmN() {
        if (this.fWi != null) {
            setMaskColor(2);
            this.fWi.bmW();
        }
    }

    @Override // com.baidu.tieba.story.b
    public void ab(float f) {
        setValueFloat(f);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bmO() {
        setMaskColor(0);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bmM() {
    }

    public void setValueFloat(float f) {
        this.fWe = f;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void bmQ() {
        if (this.fWi != null) {
            this.fWi.bmQ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajQ == 1) {
            this.mBmp = aj.cQ(d.g.btn_story_loading);
            invalidate();
        }
    }
}
