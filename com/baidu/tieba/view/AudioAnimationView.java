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
    private int ayd;
    private int aye;
    private boolean ayf;
    private boolean ayg;
    private int ayh;
    private int ayi;
    private int[] ayk;
    private int ayl;
    private int aym;
    private final Runnable ayn;
    private Rect[] hIs;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.ayd = 0;
        this.aye = 8;
        this.ayf = false;
        this.ayg = true;
        this.ayk = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ayl = com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.ds4);
        this.aym = d.C0108d.cp_link_tip_a;
        this.ayn = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.tl();
            }
        };
        initPaint();
        tl();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.ayd = 0;
        this.aye = 8;
        this.ayf = false;
        this.ayg = true;
        this.ayk = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ayl = com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.ds4);
        this.aym = d.C0108d.cp_link_tip_a;
        this.ayn = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.tl();
            }
        };
        initPaint();
        tl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl() {
        if (this.ayf) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.ayn);
        if (!this.ayg) {
            com.baidu.adp.lib.g.e.nr().postDelayed(this.ayn, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.ayd > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.ayh = this.ayl * ((this.ayd * 2) - 1);
            this.aye = this.ayd;
            i = View.MeasureSpec.makeMeasureSpec(this.ayh, mode);
        }
        super.onMeasure(i, i2);
        this.ayi = getMeasuredHeight();
        this.ayh = getMeasuredWidth();
        if (this.ayd <= 0) {
            this.aye = (this.ayh / this.ayl) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ayf) {
            for (int i = 0; i < this.aye; i++) {
                tm();
                if (i < this.hIs.length) {
                    canvas.drawRect(this.hIs[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.aym));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(this.aym));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void tm() {
        int nextInt;
        if (this.hIs == null || this.hIs.length != this.aye) {
            this.hIs = new Rect[this.aye];
        }
        for (int i = 0; i < this.aye; i++) {
            int i2 = this.ayl * i * 2;
            if (this.ayg) {
                nextInt = (int) ((1.0d - (this.ayk[i % 22] / 10.0d)) * this.ayi);
            } else {
                nextInt = this.ayi > 0 ? this.random.nextInt(this.ayi) : 0;
            }
            int i3 = this.ayl + i2;
            int i4 = this.ayi;
            if (this.hIs[i] == null) {
                this.hIs[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.hIs[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.ayl = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.aym = i;
    }

    public void start() {
        this.ayf = true;
        this.ayg = false;
        tl();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.ayd = i;
        }
    }

    public void tn() {
        this.ayf = true;
        this.ayg = true;
        tl();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.ayn);
    }
}
