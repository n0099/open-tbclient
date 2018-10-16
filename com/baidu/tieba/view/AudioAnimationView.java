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
    private int Tm;
    private int Tn;
    private boolean To;
    private boolean Tp;
    private int Tq;
    private int Tr;
    private int[] Tt;
    private int Tu;
    private int Tv;
    private final Runnable Tw;
    private Rect[] hDA;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Tm = 0;
        this.Tn = 8;
        this.To = false;
        this.Tp = true;
        this.Tt = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Tu = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds4);
        this.Tv = e.d.cp_link_tip_a;
        this.Tw = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.pU();
            }
        };
        initPaint();
        pU();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Tm = 0;
        this.Tn = 8;
        this.To = false;
        this.Tp = true;
        this.Tt = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Tu = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds4);
        this.Tv = e.d.cp_link_tip_a;
        this.Tw = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.pU();
            }
        };
        initPaint();
        pU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pU() {
        if (this.To) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.Tw);
        if (!this.Tp) {
            com.baidu.adp.lib.g.e.jI().postDelayed(this.Tw, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Tm > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Tq = this.Tu * ((this.Tm * 2) - 1);
            this.Tn = this.Tm;
            i = View.MeasureSpec.makeMeasureSpec(this.Tq, mode);
        }
        super.onMeasure(i, i2);
        this.Tr = getMeasuredHeight();
        this.Tq = getMeasuredWidth();
        if (this.Tm <= 0) {
            this.Tn = (this.Tq / this.Tu) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.To) {
            for (int i = 0; i < this.Tn; i++) {
                pV();
                if (i < this.hDA.length) {
                    canvas.drawRect(this.hDA[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(al.getColor(this.Tv));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(al.getColor(this.Tv));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void pV() {
        int nextInt;
        if (this.hDA == null || this.hDA.length != this.Tn) {
            this.hDA = new Rect[this.Tn];
        }
        for (int i = 0; i < this.Tn; i++) {
            int i2 = this.Tu * i * 2;
            if (this.Tp) {
                nextInt = (int) ((1.0d - (this.Tt[i % 22] / 10.0d)) * this.Tr);
            } else {
                nextInt = this.Tr > 0 ? this.random.nextInt(this.Tr) : 0;
            }
            int i3 = this.Tu + i2;
            int i4 = this.Tr;
            if (this.hDA[i] == null) {
                this.hDA[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.hDA[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Tu = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(al.getColor(i));
        }
        this.Tv = i;
    }

    public void start() {
        this.To = true;
        this.Tp = false;
        pU();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Tm = i;
        }
    }

    public void pW() {
        this.To = true;
        this.Tp = true;
        pU();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.Tw);
    }
}
