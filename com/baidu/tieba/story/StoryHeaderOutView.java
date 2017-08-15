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
    protected int akI;
    private int akd;
    private int ake;
    private Paint fZo;
    private float fZp;
    private float fZq;
    private float fZr;
    private RectF fZs;
    private int fZt;
    private Paint fZu;
    private m fZv;
    private Drawable fZw;
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
        this.akI = 0;
        this.akd = d.g.transparent_bg;
        this.ake = d.e.cp_bg_line_d;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.ake);
        setDefaultResource(this.akd);
        setDefaultErrorResource(d.g.icon_default_avatar100);
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(k.g(TbadkCoreApplication.getInst(), d.f.ds3));
        this.fZu = new Paint();
        this.fZu.setStyle(Paint.Style.STROKE);
        this.fZu.setStrokeWidth(k.g(TbadkCoreApplication.getInst(), d.f.ds1));
        this.fZo = new Paint();
        this.fZo.setStyle(Paint.Style.STROKE);
        this.fZo.setStrokeWidth(k.g(TbadkCoreApplication.getInst(), d.f.ds3));
        setMaskColor(0);
        this.fZt = k.g(TbadkCoreApplication.getInst(), d.f.ds2);
        this.fZv = new m(this);
        this.fZw = ai.getDrawable(d.g.transparent_bg);
        this.mBmp = BitmapHelper.getCashBitmap(d.g.btn_story_loading);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void wA() {
        if (!this.aOo) {
            this.aOo = true;
        } else if (this.aOt != null && this.aOt.aKa) {
            this.aOt.Gs();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            if (this.akI == 0) {
                this.mPaint.setColor(ai.getColor(d.e.cp_link_tip_g));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(ai.getColor(d.e.cp_link_tip_g_1));
                }
                canvas.drawCircle(this.fZp, this.fZq, this.fZp - this.fZt, this.mPaint);
                this.fZw.draw(canvas);
            } else if (this.akI == 2) {
                this.fZo.setColor(ai.getColor(d.e.cp_link_tip_g));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(ai.getColor(d.e.cp_link_tip_g_1));
                }
                canvas.drawArc(this.fZs, 0.0f, this.fZr, false, this.fZo);
                this.fZw.draw(canvas);
            } else if (this.akI == 1) {
                canvas.drawBitmap(this.mBmp, 0.0f, 0.0f, this.fZo);
                if (this.fZv != null && !this.fZv.isRunning()) {
                    this.fZv.bx(this);
                }
            } else if (this.akI == 3) {
                this.fZu.setColor(ai.getColor(d.e.cp_cont_e));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(ai.getColor(d.e.cp_cont_e_1));
                }
                canvas.drawCircle(this.fZp, this.fZq, this.fZp - this.fZt, this.fZu);
                this.fZw.draw(canvas);
            } else if (this.akI == 4) {
                this.mPaint.setColor(ai.getColor(d.e.cp_cont_h));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(ai.getColor(d.e.cp_cont_h_1));
                }
                canvas.drawCircle(this.fZp, this.fZq, this.fZp - this.fZt, this.mPaint);
                this.fZw.draw(canvas);
            }
        }
    }

    public void setMaskColor(int i) {
        this.akI = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.fZp = this.mWidth / 2.0f;
        this.fZq = this.mHeight / 2.0f;
        this.fZs = new RectF(this.fZt + 0, this.fZt + 0, this.mWidth - this.fZt, this.mHeight - this.fZt);
    }

    @Override // com.baidu.tieba.story.b
    public void boJ() {
        if (this.fZv != null) {
            setMaskColor(2);
            this.fZv.boR();
        }
    }

    @Override // com.baidu.tieba.story.b
    public void aj(float f) {
        setValueFloat(f);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void boK() {
        setMaskColor(0);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void boI() {
    }

    public void setValueFloat(float f) {
        this.fZr = f;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void boM() {
        if (this.fZv != null) {
            this.fZv.boM();
        }
    }

    public void onChangeSkinType(int i) {
        this.mBmp = ai.cS(d.g.btn_story_loading);
        if (this.akI == 1) {
            invalidate();
        }
    }
}
