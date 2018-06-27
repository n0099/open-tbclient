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
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private boolean QA;
    private boolean QB;
    private int QC;
    private int QD;
    private int[] QF;
    private int QG;
    private int QH;
    private final Runnable QI;
    private int Qy;
    private int Qz;
    private Rect[] hnn;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Qy = 0;
        this.Qz = 8;
        this.QA = false;
        this.QB = true;
        this.QF = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.QG = l.e(TbadkCoreApplication.getInst(), d.e.ds4);
        this.QH = d.C0142d.cp_link_tip_a;
        this.QI = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        this.Qy = 0;
        this.Qz = 8;
        this.QA = false;
        this.QB = true;
        this.QF = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.QG = l.e(TbadkCoreApplication.getInst(), d.e.ds4);
        this.QH = d.C0142d.cp_link_tip_a;
        this.QI = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        if (this.QA) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.QI);
        if (!this.QB) {
            com.baidu.adp.lib.g.e.im().postDelayed(this.QI, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Qy > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.QC = this.QG * ((this.Qy * 2) - 1);
            this.Qz = this.Qy;
            i = View.MeasureSpec.makeMeasureSpec(this.QC, mode);
        }
        super.onMeasure(i, i2);
        this.QD = getMeasuredHeight();
        this.QC = getMeasuredWidth();
        if (this.Qy <= 0) {
            this.Qz = (this.QC / this.QG) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.QA) {
            for (int i = 0; i < this.Qz; i++) {
                oI();
                if (i < this.hnn.length) {
                    canvas.drawRect(this.hnn[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(am.getColor(this.QH));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(am.getColor(this.QH));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void oI() {
        int nextInt;
        if (this.hnn == null || this.hnn.length != this.Qz) {
            this.hnn = new Rect[this.Qz];
        }
        for (int i = 0; i < this.Qz; i++) {
            int i2 = this.QG * i * 2;
            if (this.QB) {
                nextInt = (int) ((1.0d - (this.QF[i % 22] / 10.0d)) * this.QD);
            } else {
                nextInt = this.QD > 0 ? this.random.nextInt(this.QD) : 0;
            }
            int i3 = this.QG + i2;
            int i4 = this.QD;
            if (this.hnn[i] == null) {
                this.hnn[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.hnn[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.QG = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(am.getColor(i));
        }
        this.QH = i;
    }

    public void start() {
        this.QA = true;
        this.QB = false;
        oH();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Qy = i;
        }
    }

    public void oJ() {
        this.QA = true;
        this.QB = true;
        oH();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.QI);
    }
}
