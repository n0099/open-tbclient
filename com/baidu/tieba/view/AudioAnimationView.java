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
    private int Jh;
    private int Ji;
    private boolean Jj;
    private boolean Jk;
    private int Jl;
    private int Jm;
    private int[] Jo;
    private int Jp;
    private int Jq;
    private final Runnable Jr;
    private Rect[] haq;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Jh = 0;
        this.Ji = 8;
        this.Jj = false;
        this.Jk = true;
        this.Jo = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Jp = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds4);
        this.Jq = d.C0096d.cp_link_tip_a;
        this.Jr = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.lI();
            }
        };
        initPaint();
        lI();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Jh = 0;
        this.Ji = 8;
        this.Jj = false;
        this.Jk = true;
        this.Jo = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Jp = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds4);
        this.Jq = d.C0096d.cp_link_tip_a;
        this.Jr = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.lI();
            }
        };
        initPaint();
        lI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI() {
        if (this.Jj) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.Jr);
        if (!this.Jk) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.Jr, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Jh > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Jl = this.Jp * ((this.Jh * 2) - 1);
            this.Ji = this.Jh;
            i = View.MeasureSpec.makeMeasureSpec(this.Jl, mode);
        }
        super.onMeasure(i, i2);
        this.Jm = getMeasuredHeight();
        this.Jl = getMeasuredWidth();
        if (this.Jh <= 0) {
            this.Ji = (this.Jl / this.Jp) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Jj) {
            for (int i = 0; i < this.Ji; i++) {
                lJ();
                if (i < this.haq.length) {
                    canvas.drawRect(this.haq[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.Jq));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(this.Jq));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void lJ() {
        int nextInt;
        if (this.haq == null || this.haq.length != this.Ji) {
            this.haq = new Rect[this.Ji];
        }
        for (int i = 0; i < this.Ji; i++) {
            int i2 = this.Jp * i * 2;
            if (this.Jk) {
                nextInt = (int) ((1.0d - (this.Jo[i % 22] / 10.0d)) * this.Jm);
            } else {
                nextInt = this.Jm > 0 ? this.random.nextInt(this.Jm) : 0;
            }
            int i3 = this.Jp + i2;
            int i4 = this.Jm;
            if (this.haq[i] == null) {
                this.haq[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.haq[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Jp = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.Jq = i;
    }

    public void start() {
        this.Jj = true;
        this.Jk = false;
        lI();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Jh = i;
        }
    }

    public void lK() {
        this.Jj = true;
        this.Jk = true;
        lI();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.Jr);
    }
}
