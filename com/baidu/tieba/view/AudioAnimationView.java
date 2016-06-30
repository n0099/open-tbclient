package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.h.h;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int aTI;
    private boolean eFD;
    private int fAA;
    private int fAB;
    private boolean fAC;
    private int fAD;
    private int fAE;
    private Rect[] fAF;
    private int[] fAG;
    private int fAH;
    private final Runnable fAI;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.fAA = 0;
        this.fAB = 8;
        this.eFD = false;
        this.fAC = true;
        this.fAG = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fAH = k.c(TbadkCoreApplication.m9getInst(), u.e.ds4);
        this.aTI = u.d.cp_link_tip_a;
        this.fAI = new a(this);
        initPaint();
        aUj();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.fAA = 0;
        this.fAB = 8;
        this.eFD = false;
        this.fAC = true;
        this.fAG = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fAH = k.c(TbadkCoreApplication.m9getInst(), u.e.ds4);
        this.aTI = u.d.cp_link_tip_a;
        this.fAI = new a(this);
        initPaint();
        aUj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUj() {
        if (this.eFD) {
            invalidate();
        }
        h.dM().removeCallbacks(this.fAI);
        if (!this.fAC) {
            h.dM().postDelayed(this.fAI, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.fAA > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.fAD = this.fAH * ((this.fAA * 2) - 1);
            this.fAB = this.fAA;
            i = View.MeasureSpec.makeMeasureSpec(this.fAD, mode);
        }
        super.onMeasure(i, i2);
        this.fAE = getMeasuredHeight();
        this.fAD = getMeasuredWidth();
        if (this.fAA <= 0) {
            this.fAB = (this.fAD / this.fAH) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eFD) {
            for (int i = 0; i < this.fAB; i++) {
                bjl();
                if (i < this.fAF.length) {
                    canvas.drawRect(this.fAF[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(av.getColor(this.aTI));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(av.getColor(this.aTI));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bjl() {
        int nextInt;
        if (this.fAF == null || this.fAF.length != this.fAB) {
            this.fAF = new Rect[this.fAB];
        }
        for (int i = 0; i < this.fAB; i++) {
            int i2 = this.fAH * i * 2;
            if (this.fAC) {
                nextInt = (int) ((1.0d - (this.fAG[i % 22] / 10.0d)) * this.fAE);
            } else {
                nextInt = this.fAE > 0 ? this.random.nextInt(this.fAE) : 0;
            }
            int i3 = this.fAH + i2;
            int i4 = this.fAE;
            if (this.fAF[i] == null) {
                this.fAF[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.fAF[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.fAH = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(av.getColor(i));
        }
        this.aTI = i;
    }

    public void start() {
        this.eFD = true;
        this.fAC = false;
        aUj();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.fAA = i;
        }
    }

    public void bjm() {
        this.eFD = true;
        this.fAC = true;
        aUj();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.dM().removeCallbacks(this.fAI);
    }
}
