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
    protected int ako;
    private Paint gfR;
    private float gfS;
    private float gfT;
    private float gfU;
    private RectF gfV;
    private int gfW;
    private Paint gfX;
    private m gfY;
    private PaintFlagsDrawFilter gfZ;
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
        this.gfX = new Paint();
        this.gfX.setStyle(Paint.Style.STROKE);
        this.gfX.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds1));
        this.gfR = new Paint();
        this.gfR.setStyle(Paint.Style.STROKE);
        this.gfR.setStrokeWidth(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds3));
        setMaskColor(0);
        this.gfW = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds2);
        this.gfY = new m(this);
        this.aOh = aj.getDrawable(d.f.transparent_bg);
        this.mBmp = BitmapHelper.getCashBitmap(d.f.btn_story_loading);
        this.gfZ = new PaintFlagsDrawFilter(0, 3);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void startLogPerf() {
        if (!this.canLogPerf) {
            this.canLogPerf = true;
        } else if (this.mPerfLog != null && this.mPerfLog.aJI) {
            this.mPerfLog.Gm();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            canvas.setDrawFilter(this.gfZ);
            if (this.ako == 0) {
                this.mPaint.setColor(aj.getColor(d.C0080d.cp_link_tip_g));
                canvas.drawCircle(this.gfS, this.gfT, this.gfS - this.gfW, this.mPaint);
                this.aOh.draw(canvas);
            } else if (this.ako == 2) {
                this.gfR.setColor(aj.getColor(d.C0080d.cp_link_tip_g));
                canvas.drawArc(this.gfV, 0.0f, this.gfU, false, this.gfR);
                this.aOh.draw(canvas);
            } else if (this.ako == 1) {
                canvas.drawBitmap(this.mBmp, 0.0f, 0.0f, this.gfR);
                if (this.gfY != null && !this.gfY.isRunning()) {
                    this.gfY.bI(this);
                }
            } else if (this.ako == 3) {
                this.gfX.setColor(aj.getColor(d.C0080d.cp_cont_e));
                canvas.drawCircle(this.gfS, this.gfT, this.gfS - this.gfW, this.gfX);
                this.aOh.draw(canvas);
            } else if (this.ako == 4) {
                this.mPaint.setColor(aj.getColor(d.C0080d.cp_cont_h));
                canvas.drawCircle(this.gfS, this.gfT, this.gfS - this.gfW, this.mPaint);
                this.aOh.draw(canvas);
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
        this.gfS = this.mWidth / 2.0f;
        this.gfT = this.mHeight / 2.0f;
        this.gfV = new RectF(this.gfW + 0, this.gfW + 0, this.mWidth - this.gfW, this.mHeight - this.gfW);
    }

    @Override // com.baidu.tieba.story.b
    public void bqd() {
        if (this.gfY != null) {
            setMaskColor(2);
            this.gfY.bqm();
        }
    }

    @Override // com.baidu.tieba.story.b
    public void aa(float f) {
        setValueFloat(f);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bqe() {
        setMaskColor(0);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bqc() {
    }

    public void setValueFloat(float f) {
        this.gfU = f;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void bqg() {
        if (this.gfY != null) {
            this.gfY.bqg();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ako == 1) {
            this.mBmp = aj.cQ(d.f.btn_story_loading);
        }
        if (this.mSkinType != i) {
            invalidate();
            this.mSkinType = i;
        }
    }
}
