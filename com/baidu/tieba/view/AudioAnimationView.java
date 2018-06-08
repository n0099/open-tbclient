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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int QA;
    private int QB;
    private int[] QD;
    private int QE;
    private int QF;
    private final Runnable QG;
    private int Qw;
    private int Qx;
    private boolean Qy;
    private boolean Qz;
    private Rect[] hji;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Qw = 0;
        this.Qx = 8;
        this.Qy = false;
        this.Qz = true;
        this.QD = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.QE = l.e(TbadkCoreApplication.getInst(), d.e.ds4);
        this.QF = d.C0141d.cp_link_tip_a;
        this.QG = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.oH();
            }
        };
        initPaint();
        oH();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Qw = 0;
        this.Qx = 8;
        this.Qy = false;
        this.Qz = true;
        this.QD = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.QE = l.e(TbadkCoreApplication.getInst(), d.e.ds4);
        this.QF = d.C0141d.cp_link_tip_a;
        this.QG = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.oH();
            }
        };
        initPaint();
        oH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oH() {
        if (this.Qy) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.QG);
        if (!this.Qz) {
            com.baidu.adp.lib.g.e.im().postDelayed(this.QG, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Qw > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.QA = this.QE * ((this.Qw * 2) - 1);
            this.Qx = this.Qw;
            i = View.MeasureSpec.makeMeasureSpec(this.QA, mode);
        }
        super.onMeasure(i, i2);
        this.QB = getMeasuredHeight();
        this.QA = getMeasuredWidth();
        if (this.Qw <= 0) {
            this.Qx = (this.QA / this.QE) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Qy) {
            for (int i = 0; i < this.Qx; i++) {
                oI();
                if (i < this.hji.length) {
                    canvas.drawRect(this.hji[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(al.getColor(this.QF));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(al.getColor(this.QF));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void oI() {
        int nextInt;
        if (this.hji == null || this.hji.length != this.Qx) {
            this.hji = new Rect[this.Qx];
        }
        for (int i = 0; i < this.Qx; i++) {
            int i2 = this.QE * i * 2;
            if (this.Qz) {
                nextInt = (int) ((1.0d - (this.QD[i % 22] / 10.0d)) * this.QB);
            } else {
                nextInt = this.QB > 0 ? this.random.nextInt(this.QB) : 0;
            }
            int i3 = this.QE + i2;
            int i4 = this.QB;
            if (this.hji[i] == null) {
                this.hji[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.hji[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.QE = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(al.getColor(i));
        }
        this.QF = i;
    }

    public void start() {
        this.Qy = true;
        this.Qz = false;
        oH();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Qw = i;
        }
    }

    public void oJ() {
        this.Qy = true;
        this.Qz = true;
        oH();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.QG);
    }
}
