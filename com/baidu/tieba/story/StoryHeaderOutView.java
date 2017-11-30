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
    private Drawable aOI;
    protected int akK;
    private Paint goJ;
    private float goK;
    private float goL;
    private float goM;
    private RectF goN;
    private int goO;
    private Paint goP;
    private m goQ;
    private PaintFlagsDrawFilter goR;
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
        this.mDefaultBgId = d.C0082d.cp_bg_line_d;
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
        this.goP = new Paint();
        this.goP.setStyle(Paint.Style.STROKE);
        this.goP.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds1));
        this.goJ = new Paint();
        this.goJ.setStyle(Paint.Style.STROKE);
        this.goJ.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds3));
        setMaskColor(0);
        this.goO = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds2);
        this.goQ = new m(this);
        this.aOI = aj.getDrawable(d.f.transparent_bg);
        this.mBmp = BitmapHelper.getCashBitmap(d.f.btn_story_loading);
        this.goR = new PaintFlagsDrawFilter(0, 3);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void startLogPerf() {
        if (!this.canLogPerf) {
            this.canLogPerf = true;
        } else if (this.mPerfLog != null && this.mPerfLog.aKj) {
            this.mPerfLog.Gt();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            canvas.setDrawFilter(this.goR);
            if (this.akK == 0) {
                this.mPaint.setColor(aj.getColor(d.C0082d.cp_link_tip_g));
                canvas.drawCircle(this.goK, this.goL, this.goK - this.goO, this.mPaint);
                this.aOI.draw(canvas);
            } else if (this.akK == 2) {
                this.goJ.setColor(aj.getColor(d.C0082d.cp_link_tip_g));
                canvas.drawArc(this.goN, 0.0f, this.goM, false, this.goJ);
                this.aOI.draw(canvas);
            } else if (this.akK == 1) {
                canvas.drawBitmap(this.mBmp, 0.0f, 0.0f, this.goJ);
                if (this.goQ != null && !this.goQ.isRunning()) {
                    this.goQ.bD(this);
                }
            } else if (this.akK == 3) {
                this.goP.setColor(aj.getColor(d.C0082d.cp_cont_e));
                canvas.drawCircle(this.goK, this.goL, this.goK - this.goO, this.goP);
                this.aOI.draw(canvas);
            } else if (this.akK == 4) {
                this.mPaint.setColor(aj.getColor(d.C0082d.cp_cont_h));
                canvas.drawCircle(this.goK, this.goL, this.goK - this.goO, this.mPaint);
                this.aOI.draw(canvas);
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
        this.goK = this.mWidth / 2.0f;
        this.goL = this.mHeight / 2.0f;
        this.goN = new RectF(this.goO + 0, this.goO + 0, this.mWidth - this.goO, this.mHeight - this.goO);
    }

    @Override // com.baidu.tieba.story.b
    public void brL() {
        if (this.goQ != null) {
            setMaskColor(2);
            this.goQ.brU();
        }
    }

    @Override // com.baidu.tieba.story.b
    public void ak(float f) {
        setValueFloat(f);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void brM() {
        setMaskColor(0);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void brK() {
    }

    public void setValueFloat(float f) {
        this.goM = f;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void brO() {
        if (this.goQ != null) {
            this.goQ.brO();
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
