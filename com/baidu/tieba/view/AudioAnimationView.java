package com.baidu.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int bST;
    private int gMH;
    private int gMI;
    private boolean gMJ;
    private boolean gMK;
    private int gML;
    private int gMM;
    private Rect[] gMN;
    private int[] gMO;
    private int gMP;
    private final Runnable gMQ;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.gMH = 0;
        this.gMI = 8;
        this.gMJ = false;
        this.gMK = true;
        this.gMO = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gMP = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds4);
        this.bST = d.C0080d.cp_link_tip_a;
        this.gMQ = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bBq();
            }
        };
        initPaint();
        bBq();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.gMH = 0;
        this.gMI = 8;
        this.gMJ = false;
        this.gMK = true;
        this.gMO = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gMP = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds4);
        this.bST = d.C0080d.cp_link_tip_a;
        this.gMQ = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bBq();
            }
        };
        initPaint();
        bBq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBq() {
        if (this.gMJ) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gMQ);
        if (!this.gMK) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.gMQ, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.gMH > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.gML = this.gMP * ((this.gMH * 2) - 1);
            this.gMI = this.gMH;
            i = View.MeasureSpec.makeMeasureSpec(this.gML, mode);
        }
        super.onMeasure(i, i2);
        this.gMM = getMeasuredHeight();
        this.gML = getMeasuredWidth();
        if (this.gMH <= 0) {
            this.gMI = (this.gML / this.gMP) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.gMJ) {
            for (int i = 0; i < this.gMI; i++) {
                bBr();
                if (i < this.gMN.length) {
                    canvas.drawRect(this.gMN[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.bST));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(this.bST));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bBr() {
        int nextInt;
        if (this.gMN == null || this.gMN.length != this.gMI) {
            this.gMN = new Rect[this.gMI];
        }
        for (int i = 0; i < this.gMI; i++) {
            int i2 = this.gMP * i * 2;
            if (this.gMK) {
                nextInt = (int) ((1.0d - (this.gMO[i % 22] / 10.0d)) * this.gMM);
            } else {
                nextInt = this.gMM > 0 ? this.random.nextInt(this.gMM) : 0;
            }
            int i3 = this.gMP + i2;
            int i4 = this.gMM;
            if (this.gMN[i] == null) {
                this.gMN[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.gMN[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.gMP = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.bST = i;
    }

    public void start() {
        this.gMJ = true;
        this.gMK = false;
        bBq();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.gMH = i;
        }
    }

    public void bBs() {
        this.gMJ = true;
        this.gMK = true;
        bBq();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gMQ);
    }
}
