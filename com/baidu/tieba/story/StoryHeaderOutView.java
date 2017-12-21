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
    private Drawable aOO;
    protected int akK;
    private int grA;
    private Paint grB;
    private m grC;
    private PaintFlagsDrawFilter grD;
    private Paint grv;
    private float grw;
    private float grx;
    private float gry;
    private RectF grz;
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
        this.akK = 0;
        this.mDefaultId = d.f.transparent_bg;
        this.mDefaultBgId = d.C0095d.cp_bg_line_d;
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
        this.grB = new Paint();
        this.grB.setStyle(Paint.Style.STROKE);
        this.grB.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds1));
        this.grv = new Paint();
        this.grv.setStyle(Paint.Style.STROKE);
        this.grv.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds3));
        setMaskColor(0);
        this.grA = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds2);
        this.grC = new m(this);
        this.aOO = aj.getDrawable(d.f.transparent_bg);
        this.mBmp = BitmapHelper.getCashBitmap(d.f.btn_story_loading);
        this.grD = new PaintFlagsDrawFilter(0, 3);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void startLogPerf() {
        if (!this.canLogPerf) {
            this.canLogPerf = true;
        } else if (this.mPerfLog != null && this.mPerfLog.aKq) {
            this.mPerfLog.Gu();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            canvas.setDrawFilter(this.grD);
            if (this.akK == 0) {
                this.mPaint.setColor(aj.getColor(d.C0095d.cp_link_tip_g));
                canvas.drawCircle(this.grw, this.grx, this.grw - this.grA, this.mPaint);
                this.aOO.draw(canvas);
            } else if (this.akK == 2) {
                this.grv.setColor(aj.getColor(d.C0095d.cp_link_tip_g));
                canvas.drawArc(this.grz, 0.0f, this.gry, false, this.grv);
                this.aOO.draw(canvas);
            } else if (this.akK == 1) {
                canvas.drawBitmap(this.mBmp, 0.0f, 0.0f, this.grv);
                if (this.grC != null && !this.grC.isRunning()) {
                    this.grC.bH(this);
                }
            } else if (this.akK == 3) {
                this.grB.setColor(aj.getColor(d.C0095d.cp_cont_e));
                canvas.drawCircle(this.grw, this.grx, this.grw - this.grA, this.grB);
                this.aOO.draw(canvas);
            } else if (this.akK == 4) {
                this.mPaint.setColor(aj.getColor(d.C0095d.cp_cont_h));
                canvas.drawCircle(this.grw, this.grx, this.grw - this.grA, this.mPaint);
                this.aOO.draw(canvas);
            }
        }
    }

    public void setMaskColor(int i) {
        this.akK = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.grw = this.mWidth / 2.0f;
        this.grx = this.mHeight / 2.0f;
        this.grz = new RectF(this.grA + 0, this.grA + 0, this.mWidth - this.grA, this.mHeight - this.grA);
    }

    @Override // com.baidu.tieba.story.b
    public void bsr() {
        if (this.grC != null) {
            setMaskColor(2);
            this.grC.bsA();
        }
    }

    @Override // com.baidu.tieba.story.b
    public void ak(float f) {
        setValueFloat(f);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bss() {
        setMaskColor(0);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bsq() {
    }

    public void setValueFloat(float f) {
        this.gry = f;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void bsu() {
        if (this.grC != null) {
            this.grC.bsu();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akK == 1) {
            this.mBmp = aj.cR(d.f.btn_story_loading);
        }
        if (this.mSkinType != i) {
            invalidate();
            this.mSkinType = i;
        }
    }
}
