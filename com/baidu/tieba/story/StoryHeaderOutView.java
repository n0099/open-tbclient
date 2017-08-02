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
    private int aiI;
    private int aiJ;
    protected int ajn;
    private Paint fWj;
    private float fWk;
    private float fWl;
    private float fWm;
    private RectF fWn;
    private int fWo;
    private Paint fWp;
    private m fWq;
    private Drawable fWr;
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
        this.ajn = 0;
        this.aiI = d.g.transparent_bg;
        this.aiJ = d.e.cp_bg_line_d;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.aiJ);
        setDefaultResource(this.aiI);
        setDefaultErrorResource(d.g.icon_default_avatar100);
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(k.g(TbadkCoreApplication.getInst(), d.f.ds3));
        this.fWp = new Paint();
        this.fWp.setStyle(Paint.Style.STROKE);
        this.fWp.setStrokeWidth(k.g(TbadkCoreApplication.getInst(), d.f.ds1));
        this.fWj = new Paint();
        this.fWj.setStyle(Paint.Style.STROKE);
        this.fWj.setStrokeWidth(k.g(TbadkCoreApplication.getInst(), d.f.ds3));
        setMaskColor(0);
        this.fWo = k.g(TbadkCoreApplication.getInst(), d.f.ds2);
        this.fWq = new m(this);
        this.fWr = ai.getDrawable(d.g.transparent_bg);
        this.mBmp = BitmapHelper.getCashBitmap(d.g.btn_story_loading);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void wq() {
        if (!this.aMZ) {
            this.aMZ = true;
        } else if (this.aNe != null && this.aNe.aIK) {
            this.aNe.Gk();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            if (this.ajn == 0) {
                this.mPaint.setColor(ai.getColor(d.e.cp_link_tip_g));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(ai.getColor(d.e.cp_link_tip_g_1));
                }
                canvas.drawCircle(this.fWk, this.fWl, this.fWk - this.fWo, this.mPaint);
                this.fWr.draw(canvas);
            } else if (this.ajn == 2) {
                this.fWj.setColor(ai.getColor(d.e.cp_link_tip_g));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(ai.getColor(d.e.cp_link_tip_g_1));
                }
                canvas.drawArc(this.fWn, 0.0f, this.fWm, false, this.fWj);
                this.fWr.draw(canvas);
            } else if (this.ajn == 1) {
                canvas.drawBitmap(this.mBmp, 0.0f, 0.0f, this.fWj);
                if (this.fWq != null && !this.fWq.isRunning()) {
                    this.fWq.bv(this);
                }
            } else if (this.ajn == 3) {
                this.fWp.setColor(ai.getColor(d.e.cp_cont_e));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(ai.getColor(d.e.cp_cont_e_1));
                }
                canvas.drawCircle(this.fWk, this.fWl, this.fWk - this.fWo, this.fWp);
                this.fWr.draw(canvas);
            } else if (this.ajn == 4) {
                this.mPaint.setColor(ai.getColor(d.e.cp_cont_h));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.mPaint.setColor(ai.getColor(d.e.cp_cont_h_1));
                }
                canvas.drawCircle(this.fWk, this.fWl, this.fWk - this.fWo, this.mPaint);
                this.fWr.draw(canvas);
            }
        }
    }

    public void setMaskColor(int i) {
        this.ajn = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.fWk = this.mWidth / 2.0f;
        this.fWl = this.mHeight / 2.0f;
        this.fWn = new RectF(this.fWo + 0, this.fWo + 0, this.mWidth - this.fWo, this.mHeight - this.fWo);
    }

    @Override // com.baidu.tieba.story.b
    public void bnU() {
        if (this.fWq != null) {
            setMaskColor(2);
            this.fWq.boc();
        }
    }

    @Override // com.baidu.tieba.story.b
    public void aj(float f) {
        setValueFloat(f);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bnV() {
        setMaskColor(0);
        postInvalidate();
    }

    @Override // com.baidu.tieba.story.b
    public void bnT() {
    }

    public void setValueFloat(float f) {
        this.fWm = f;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void bnX() {
        if (this.fWq != null) {
            this.fWq.bnX();
        }
    }

    public void onChangeSkinType(int i) {
        this.mBmp = ai.cQ(d.g.btn_story_loading);
        if (this.ajn == 1) {
            invalidate();
        }
    }
}
