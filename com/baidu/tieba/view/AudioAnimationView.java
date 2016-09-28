package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int bag;
    private int fXA;
    private int fXB;
    private Rect[] fXC;
    private int[] fXD;
    private int fXE;
    private final Runnable fXF;
    private int fXx;
    private int fXy;
    private boolean fXz;
    private boolean fcg;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.fXx = 0;
        this.fXy = 8;
        this.fcg = false;
        this.fXz = true;
        this.fXD = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fXE = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds4);
        this.bag = r.d.cp_link_tip_a;
        this.fXF = new a(this);
        initPaint();
        bbw();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.fXx = 0;
        this.fXy = 8;
        this.fcg = false;
        this.fXz = true;
        this.fXD = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fXE = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds4);
        this.bag = r.d.cp_link_tip_a;
        this.fXF = new a(this);
        initPaint();
        bbw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbw() {
        if (this.fcg) {
            invalidate();
        }
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.fXF);
        if (!this.fXz) {
            com.baidu.adp.lib.h.h.eG().postDelayed(this.fXF, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.fXx > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.fXA = this.fXE * ((this.fXx * 2) - 1);
            this.fXy = this.fXx;
            i = View.MeasureSpec.makeMeasureSpec(this.fXA, mode);
        }
        super.onMeasure(i, i2);
        this.fXB = getMeasuredHeight();
        this.fXA = getMeasuredWidth();
        if (this.fXx <= 0) {
            this.fXy = (this.fXA / this.fXE) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fcg) {
            for (int i = 0; i < this.fXy; i++) {
                bqL();
                if (i < this.fXC.length) {
                    canvas.drawRect(this.fXC[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(av.getColor(this.bag));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(av.getColor(this.bag));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bqL() {
        int nextInt;
        if (this.fXC == null || this.fXC.length != this.fXy) {
            this.fXC = new Rect[this.fXy];
        }
        for (int i = 0; i < this.fXy; i++) {
            int i2 = this.fXE * i * 2;
            if (this.fXz) {
                nextInt = (int) ((1.0d - (this.fXD[i % 22] / 10.0d)) * this.fXB);
            } else {
                nextInt = this.fXB > 0 ? this.random.nextInt(this.fXB) : 0;
            }
            int i3 = this.fXE + i2;
            int i4 = this.fXB;
            if (this.fXC[i] == null) {
                this.fXC[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.fXC[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.fXE = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(av.getColor(i));
        }
        this.bag = i;
    }

    public void start() {
        this.fcg = true;
        this.fXz = false;
        bbw();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.fXx = i;
        }
    }

    public void bqM() {
        this.fcg = true;
        this.fXz = true;
        bbw();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.fXF);
    }
}
