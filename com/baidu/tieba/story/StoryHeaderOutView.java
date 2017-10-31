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
    private Drawable aNZ;
    protected int ako;
    private Paint geP;
    private float geQ;
    private float geR;
    private float geS;
    private RectF geT;
    private int geU;
    private Paint geV;
    private m geW;
    private PaintFlagsDrawFilter geX;
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
        this.ako = 0;
        this.mDefaultId = d.f.transparent_bg;
        this.mDefaultBgId = d.C0080d.cp_bg_line_d;
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
        this.geV = new Paint();
        this.geV.setStyle(Paint.Style.STROKE);
        this.geV.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds1));
        this.geP = new Paint();
        this.geP.setStyle(Paint.Style.STROKE);
        this.geP.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds3));
        setMaskColor(0);
        this.geU = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds2);
        this.geW = new m(this);
        this.aNZ = aj.getDrawable(d.f.transparent_bg);
        this.mBmp = BitmapHelper.getCashBitmap(d.f.btn_story_loading);
        this.geX = new PaintFlagsDrawFilter(0, 3);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void startLogPerf() {
        if (!this.canLogPerf) {
            this.canLogPerf = true;
        } else if (this.mPerfLog != null && this.mPerfLog.aJA) {
            this.mPerfLog.Gb();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            canvas.setDrawFilter(this.geX);
            if (this.ako == 0) {
                this.mPaint.setColor(aj.getColor(d.C0080d.cp_link_tip_g));
                canvas.drawCircle(this.geQ, this.geR, this.geQ - this.geU, this.mPaint);
                this.aNZ.draw(canvas);
            } else if (this.ako == 2) {
                this.geP.setColor(aj.getColor(d.C0080d.cp_link_tip_g));
                canvas.drawArc(this.geT, 0.0f, this.geS, false, this.geP);
                this.aNZ.draw(canvas);
            } else if (this.ako == 1) {
                canvas.drawBitmap(this.mBmp, 0.0f, 0.0f, this.geP);
                if (this.geW != null && !this.geW.isRunning()) {
                    this.geW.bH(this);
                }
            } else if (this.ako == 3) {
                this.geV.setColor(aj.getColor(d.C0080d.cp_cont_e));
                canvas.drawCircle(this.geQ, this.geR, this.geQ - this.geU, this.geV);
                this.aNZ.draw(canvas);
            } else if (this.ako == 4) {
                this.mPaint.setColor(aj.getColor(d.C0080d.cp_cont_h));
                canvas.drawCircle(this.geQ, this.geR, this.geQ - this.geU, this.mPaint);
                this.aNZ.draw(canvas);
            }
        }
    }

    public void setMaskColor(int i) {
        this.ako = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.geQ = this.mWidth / 2.0f;
        this.geR = this.mHeight / 2.0f;
        this.geT = new RectF(this.geU + 0, this.geU + 0, this.mWidth - this.geU, this.mHeight - this.geU);
    }

    @Override // com.baidu.tieba.story.b
    public void bpS() {
        if (this.geW != null) {
            setMaskColor(2);
            this.geW.bqb();
        }
    }

    @Override // com.baidu.tieba.story.b
    public void aa(float f) {
        setValueFloat(f);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bpT() {
        setMaskColor(0);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bpR() {
    }

    public void setValueFloat(float f) {
        this.geS = f;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void bpV() {
        if (this.geW != null) {
            this.geW.bpV();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ako == 1) {
            this.mBmp = aj.cR(d.f.btn_story_loading);
        }
        if (this.mSkinType != i) {
            invalidate();
            this.mSkinType = i;
        }
    }
}
