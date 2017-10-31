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
    private int bSG;
    private int gLA;
    private boolean gLB;
    private boolean gLC;
    private int gLD;
    private int gLE;
    private Rect[] gLF;
    private int[] gLG;
    private int gLH;
    private final Runnable gLI;
    private int gLz;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.gLz = 0;
        this.gLA = 8;
        this.gLB = false;
        this.gLC = true;
        this.gLG = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gLH = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds4);
        this.bSG = d.C0080d.cp_link_tip_a;
        this.gLI = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bBe();
            }
        };
        initPaint();
        bBe();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.gLz = 0;
        this.gLA = 8;
        this.gLB = false;
        this.gLC = true;
        this.gLG = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gLH = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds4);
        this.bSG = d.C0080d.cp_link_tip_a;
        this.gLI = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bBe();
            }
        };
        initPaint();
        bBe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBe() {
        if (this.gLB) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gLI);
        if (!this.gLC) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.gLI, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.gLz > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.gLD = this.gLH * ((this.gLz * 2) - 1);
            this.gLA = this.gLz;
            i = View.MeasureSpec.makeMeasureSpec(this.gLD, mode);
        }
        super.onMeasure(i, i2);
        this.gLE = getMeasuredHeight();
        this.gLD = getMeasuredWidth();
        if (this.gLz <= 0) {
            this.gLA = (this.gLD / this.gLH) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.gLB) {
            for (int i = 0; i < this.gLA; i++) {
                bBf();
                if (i < this.gLF.length) {
                    canvas.drawRect(this.gLF[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.bSG));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(this.bSG));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bBf() {
        int nextInt;
        if (this.gLF == null || this.gLF.length != this.gLA) {
            this.gLF = new Rect[this.gLA];
        }
        for (int i = 0; i < this.gLA; i++) {
            int i2 = this.gLH * i * 2;
            if (this.gLC) {
                nextInt = (int) ((1.0d - (this.gLG[i % 22] / 10.0d)) * this.gLE);
            } else {
                nextInt = this.gLE > 0 ? this.random.nextInt(this.gLE) : 0;
            }
            int i3 = this.gLH + i2;
            int i4 = this.gLE;
            if (this.gLF[i] == null) {
                this.gLF[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.gLF[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.gLH = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.bSG = i;
    }

    public void start() {
        this.gLB = true;
        this.gLC = false;
        bBe();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.gLz = i;
        }
    }

    public void bBg() {
        this.gLB = true;
        this.gLC = true;
        bBe();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gLI);
    }
}
