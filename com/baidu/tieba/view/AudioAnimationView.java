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
    private int ayf;
    private int ayg;
    private boolean ayh;
    private boolean ayi;
    private int ayj;
    private int ayk;
    private int[] aym;
    private int ayn;
    private int ayo;
    private final Runnable ayp;
    private Rect[] hyt;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.ayf = 0;
        this.ayg = 8;
        this.ayh = false;
        this.ayi = true;
        this.aym = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ayn = com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.ds4);
        this.ayo = d.C0108d.cp_link_tip_a;
        this.ayp = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.tm();
            }
        };
        initPaint();
        tm();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.ayf = 0;
        this.ayg = 8;
        this.ayh = false;
        this.ayi = true;
        this.aym = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ayn = com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.ds4);
        this.ayo = d.C0108d.cp_link_tip_a;
        this.ayp = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.tm();
            }
        };
        initPaint();
        tm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tm() {
        if (this.ayh) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.ayp);
        if (!this.ayi) {
            com.baidu.adp.lib.g.e.ns().postDelayed(this.ayp, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.ayf > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.ayj = this.ayn * ((this.ayf * 2) - 1);
            this.ayg = this.ayf;
            i = View.MeasureSpec.makeMeasureSpec(this.ayj, mode);
        }
        super.onMeasure(i, i2);
        this.ayk = getMeasuredHeight();
        this.ayj = getMeasuredWidth();
        if (this.ayf <= 0) {
            this.ayg = (this.ayj / this.ayn) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ayh) {
            for (int i = 0; i < this.ayg; i++) {
                tn();
                if (i < this.hyt.length) {
                    canvas.drawRect(this.hyt[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.ayo));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(this.ayo));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void tn() {
        int nextInt;
        if (this.hyt == null || this.hyt.length != this.ayg) {
            this.hyt = new Rect[this.ayg];
        }
        for (int i = 0; i < this.ayg; i++) {
            int i2 = this.ayn * i * 2;
            if (this.ayi) {
                nextInt = (int) ((1.0d - (this.aym[i % 22] / 10.0d)) * this.ayk);
            } else {
                nextInt = this.ayk > 0 ? this.random.nextInt(this.ayk) : 0;
            }
            int i3 = this.ayn + i2;
            int i4 = this.ayk;
            if (this.hyt[i] == null) {
                this.hyt[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.hyt[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.ayn = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.ayo = i;
    }

    public void start() {
        this.ayh = true;
        this.ayi = false;
        tm();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.ayf = i;
        }
    }

    public void to() {
        this.ayh = true;
        this.ayi = true;
        tm();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.ayp);
    }
}
