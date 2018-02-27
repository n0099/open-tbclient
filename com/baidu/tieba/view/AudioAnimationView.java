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
    private int axV;
    private int axW;
    private boolean axX;
    private boolean axY;
    private int axZ;
    private int aya;
    private int[] ayc;
    private int ayd;
    private int aye;
    private final Runnable ayf;
    private Rect[] hzM;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.axV = 0;
        this.axW = 8;
        this.axX = false;
        this.axY = true;
        this.ayc = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ayd = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst(), d.e.ds4);
        this.aye = d.C0141d.cp_link_tip_a;
        this.ayf = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        this.axV = 0;
        this.axW = 8;
        this.axX = false;
        this.axY = true;
        this.ayc = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ayd = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst(), d.e.ds4);
        this.aye = d.C0141d.cp_link_tip_a;
        this.ayf = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        if (this.axX) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.ayf);
        if (!this.axY) {
            com.baidu.adp.lib.g.e.ns().postDelayed(this.ayf, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.axV > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.axZ = this.ayd * ((this.axV * 2) - 1);
            this.axW = this.axV;
            i = View.MeasureSpec.makeMeasureSpec(this.axZ, mode);
        }
        super.onMeasure(i, i2);
        this.aya = getMeasuredHeight();
        this.axZ = getMeasuredWidth();
        if (this.axV <= 0) {
            this.axW = (this.axZ / this.ayd) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.axX) {
            for (int i = 0; i < this.axW; i++) {
                tm();
                if (i < this.hzM.length) {
                    canvas.drawRect(this.hzM[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.aye));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(this.aye));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void tm() {
        int nextInt;
        if (this.hzM == null || this.hzM.length != this.axW) {
            this.hzM = new Rect[this.axW];
        }
        for (int i = 0; i < this.axW; i++) {
            int i2 = this.ayd * i * 2;
            if (this.axY) {
                nextInt = (int) ((1.0d - (this.ayc[i % 22] / 10.0d)) * this.aya);
            } else {
                nextInt = this.aya > 0 ? this.random.nextInt(this.aya) : 0;
            }
            int i3 = this.ayd + i2;
            int i4 = this.aya;
            if (this.hzM[i] == null) {
                this.hzM[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.hzM[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.ayd = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.aye = i;
    }

    public void start() {
        this.axX = true;
        this.axY = false;
        tl();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.axV = i;
        }
    }

    public void tn() {
        this.axX = true;
        this.axY = true;
        tl();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.ayf);
    }
}
