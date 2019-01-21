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
import com.baidu.tieba.e;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private boolean TA;
    private int TB;
    private int TC;
    private int[] TF;
    private int TG;
    private int TH;
    private final Runnable TI;
    private int Tx;
    private int Ty;
    private boolean Tz;
    private Rect[] hQP;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Tx = 0;
        this.Ty = 8;
        this.Tz = false;
        this.TA = true;
        this.TF = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.TG = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds4);
        this.TH = e.d.cp_link_tip_a;
        this.TI = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.pV();
            }
        };
        initPaint();
        pV();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Tx = 0;
        this.Ty = 8;
        this.Tz = false;
        this.TA = true;
        this.TF = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.TG = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds4);
        this.TH = e.d.cp_link_tip_a;
        this.TI = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.pV();
            }
        };
        initPaint();
        pV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV() {
        if (this.Tz) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.TI);
        if (!this.TA) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.TI, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Tx > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.TB = this.TG * ((this.Tx * 2) - 1);
            this.Ty = this.Tx;
            i = View.MeasureSpec.makeMeasureSpec(this.TB, mode);
        }
        super.onMeasure(i, i2);
        this.TC = getMeasuredHeight();
        this.TB = getMeasuredWidth();
        if (this.Tx <= 0) {
            this.Ty = (this.TB / this.TG) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Tz) {
            for (int i = 0; i < this.Ty; i++) {
                pW();
                if (i < this.hQP.length) {
                    canvas.drawRect(this.hQP[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(al.getColor(this.TH));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(al.getColor(this.TH));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void pW() {
        int nextInt;
        if (this.hQP == null || this.hQP.length != this.Ty) {
            this.hQP = new Rect[this.Ty];
        }
        for (int i = 0; i < this.Ty; i++) {
            int i2 = this.TG * i * 2;
            if (this.TA) {
                nextInt = (int) ((1.0d - (this.TF[i % 22] / 10.0d)) * this.TC);
            } else {
                nextInt = this.TC > 0 ? this.random.nextInt(this.TC) : 0;
            }
            int i3 = this.TG + i2;
            int i4 = this.TC;
            if (this.hQP[i] == null) {
                this.hQP[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.hQP[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.TG = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(al.getColor(i));
        }
        this.TH = i;
    }

    public void start() {
        this.Tz = true;
        this.TA = false;
        pV();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Tx = i;
        }
    }

    public void pX() {
        this.Tz = true;
        this.TA = true;
        pV();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.TI);
    }
}
