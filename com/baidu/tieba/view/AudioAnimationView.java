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
    private int ayc;
    private int ayd;
    private boolean aye;
    private boolean ayf;
    private int ayg;
    private int ayh;
    private int[] ayj;
    private int ayk;
    private int ayl;
    private final Runnable aym;
    private Rect[] hxZ;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.ayc = 0;
        this.ayd = 8;
        this.aye = false;
        this.ayf = true;
        this.ayj = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ayk = com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.ds4);
        this.ayl = d.C0107d.cp_link_tip_a;
        this.aym = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        this.ayc = 0;
        this.ayd = 8;
        this.aye = false;
        this.ayf = true;
        this.ayj = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ayk = com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.ds4);
        this.ayl = d.C0107d.cp_link_tip_a;
        this.aym = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        if (this.aye) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.aym);
        if (!this.ayf) {
            com.baidu.adp.lib.g.e.nr().postDelayed(this.aym, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.ayc > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.ayg = this.ayk * ((this.ayc * 2) - 1);
            this.ayd = this.ayc;
            i = View.MeasureSpec.makeMeasureSpec(this.ayg, mode);
        }
        super.onMeasure(i, i2);
        this.ayh = getMeasuredHeight();
        this.ayg = getMeasuredWidth();
        if (this.ayc <= 0) {
            this.ayd = (this.ayg / this.ayk) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aye) {
            for (int i = 0; i < this.ayd; i++) {
                tm();
                if (i < this.hxZ.length) {
                    canvas.drawRect(this.hxZ[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.ayl));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(this.ayl));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void tm() {
        int nextInt;
        if (this.hxZ == null || this.hxZ.length != this.ayd) {
            this.hxZ = new Rect[this.ayd];
        }
        for (int i = 0; i < this.ayd; i++) {
            int i2 = this.ayk * i * 2;
            if (this.ayf) {
                nextInt = (int) ((1.0d - (this.ayj[i % 22] / 10.0d)) * this.ayh);
            } else {
                nextInt = this.ayh > 0 ? this.random.nextInt(this.ayh) : 0;
            }
            int i3 = this.ayk + i2;
            int i4 = this.ayh;
            if (this.hxZ[i] == null) {
                this.hxZ[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.hxZ[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.ayk = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.ayl = i;
    }

    public void start() {
        this.aye = true;
        this.ayf = false;
        tl();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.ayc = i;
        }
    }

    public void tn() {
        this.aye = true;
        this.ayf = true;
        tl();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.aym);
    }
}
