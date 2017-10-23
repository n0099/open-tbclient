package com.baidu.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int bLc;
    private int gBJ;
    private int gBK;
    private boolean gBL;
    private boolean gBM;
    private int gBN;
    private int gBO;
    private Rect[] gBP;
    private int[] gBQ;
    private int gBR;
    private final Runnable gBS;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.gBJ = 0;
        this.gBK = 8;
        this.gBL = false;
        this.gBM = true;
        this.gBQ = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gBR = l.f(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bLc = d.e.cp_link_tip_a;
        this.gBS = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bxL();
            }
        };
        initPaint();
        bxL();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.gBJ = 0;
        this.gBK = 8;
        this.gBL = false;
        this.gBM = true;
        this.gBQ = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gBR = l.f(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bLc = d.e.cp_link_tip_a;
        this.gBS = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bxL();
            }
        };
        initPaint();
        bxL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxL() {
        if (this.gBL) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gBS);
        if (!this.gBM) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.gBS, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.gBJ > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.gBN = this.gBR * ((this.gBJ * 2) - 1);
            this.gBK = this.gBJ;
            i = View.MeasureSpec.makeMeasureSpec(this.gBN, mode);
        }
        super.onMeasure(i, i2);
        this.gBO = getMeasuredHeight();
        this.gBN = getMeasuredWidth();
        if (this.gBJ <= 0) {
            this.gBK = (this.gBN / this.gBR) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.gBL) {
            for (int i = 0; i < this.gBK; i++) {
                bxM();
                if (i < this.gBP.length) {
                    canvas.drawRect(this.gBP[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.bLc));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(this.bLc));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bxM() {
        int nextInt;
        if (this.gBP == null || this.gBP.length != this.gBK) {
            this.gBP = new Rect[this.gBK];
        }
        for (int i = 0; i < this.gBK; i++) {
            int i2 = this.gBR * i * 2;
            if (this.gBM) {
                nextInt = (int) ((1.0d - (this.gBQ[i % 22] / 10.0d)) * this.gBO);
            } else {
                nextInt = this.gBO > 0 ? this.random.nextInt(this.gBO) : 0;
            }
            int i3 = this.gBR + i2;
            int i4 = this.gBO;
            if (this.gBP[i] == null) {
                this.gBP[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.gBP[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.gBR = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.bLc = i;
    }

    public void start() {
        this.gBL = true;
        this.gBM = false;
        bxL();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.gBJ = i;
        }
    }

    public void bxN() {
        this.gBL = true;
        this.gBM = true;
        bxL();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gBS);
    }
}
