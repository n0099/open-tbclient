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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int QA;
    private int[] QC;
    private int QD;
    private int QE;
    private final Runnable QF;
    private int Qv;
    private int Qw;
    private boolean Qx;
    private boolean Qy;
    private int Qz;
    private Rect[] how;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Qv = 0;
        this.Qw = 8;
        this.Qx = false;
        this.Qy = true;
        this.QC = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.QD = l.f(TbadkCoreApplication.getInst(), f.e.ds4);
        this.QE = f.d.cp_link_tip_a;
        this.QF = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.oG();
            }
        };
        oH();
        oG();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Qv = 0;
        this.Qw = 8;
        this.Qx = false;
        this.Qy = true;
        this.QC = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.QD = l.f(TbadkCoreApplication.getInst(), f.e.ds4);
        this.QE = f.d.cp_link_tip_a;
        this.QF = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.oG();
            }
        };
        oH();
        oG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oG() {
        if (this.Qx) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.QF);
        if (!this.Qy) {
            com.baidu.adp.lib.g.e.in().postDelayed(this.QF, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Qv > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Qz = this.QD * ((this.Qv * 2) - 1);
            this.Qw = this.Qv;
            i = View.MeasureSpec.makeMeasureSpec(this.Qz, mode);
        }
        super.onMeasure(i, i2);
        this.QA = getMeasuredHeight();
        this.Qz = getMeasuredWidth();
        if (this.Qv <= 0) {
            this.Qw = (this.Qz / this.QD) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Qx) {
            for (int i = 0; i < this.Qw; i++) {
                oI();
                if (i < this.how.length) {
                    canvas.drawRect(this.how[i], this.mPaint);
                }
            }
        }
    }

    private void oH() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(am.getColor(this.QE));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(am.getColor(this.QE));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void oI() {
        int nextInt;
        if (this.how == null || this.how.length != this.Qw) {
            this.how = new Rect[this.Qw];
        }
        for (int i = 0; i < this.Qw; i++) {
            int i2 = this.QD * i * 2;
            if (this.Qy) {
                nextInt = (int) ((1.0d - (this.QC[i % 22] / 10.0d)) * this.QA);
            } else {
                nextInt = this.QA > 0 ? this.random.nextInt(this.QA) : 0;
            }
            int i3 = this.QD + i2;
            int i4 = this.QA;
            if (this.how[i] == null) {
                this.how[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.how[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.QD = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(am.getColor(i));
        }
        this.QE = i;
    }

    public void start() {
        this.Qx = true;
        this.Qy = false;
        oG();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Qv = i;
        }
    }

    public void oJ() {
        this.Qx = true;
        this.Qy = true;
        oG();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.QF);
    }
}
