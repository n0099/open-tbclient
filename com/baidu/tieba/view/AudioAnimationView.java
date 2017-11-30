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
    private int Ji;
    private int Jj;
    private boolean Jk;
    private boolean Jl;
    private int Jm;
    private int Jn;
    private int[] Jp;
    private int Jq;
    private int Jr;
    private final Runnable Js;
    private Rect[] gXE;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Ji = 0;
        this.Jj = 8;
        this.Jk = false;
        this.Jl = true;
        this.Jp = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Jq = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds4);
        this.Jr = d.C0082d.cp_link_tip_a;
        this.Js = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        this.Ji = 0;
        this.Jj = 8;
        this.Jk = false;
        this.Jl = true;
        this.Jp = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Jq = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds4);
        this.Jr = d.C0082d.cp_link_tip_a;
        this.Js = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        if (this.Jk) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.Js);
        if (!this.Jl) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.Js, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Ji > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Jm = this.Jq * ((this.Ji * 2) - 1);
            this.Jj = this.Ji;
            i = View.MeasureSpec.makeMeasureSpec(this.Jm, mode);
        }
        super.onMeasure(i, i2);
        this.Jn = getMeasuredHeight();
        this.Jm = getMeasuredWidth();
        if (this.Ji <= 0) {
            this.Jj = (this.Jm / this.Jq) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Jk) {
            for (int i = 0; i < this.Jj; i++) {
                lJ();
                if (i < this.gXE.length) {
                    canvas.drawRect(this.gXE[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.Jr));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(this.Jr));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void lJ() {
        int nextInt;
        if (this.gXE == null || this.gXE.length != this.Jj) {
            this.gXE = new Rect[this.Jj];
        }
        for (int i = 0; i < this.Jj; i++) {
            int i2 = this.Jq * i * 2;
            if (this.Jl) {
                nextInt = (int) ((1.0d - (this.Jp[i % 22] / 10.0d)) * this.Jn);
            } else {
                nextInt = this.Jn > 0 ? this.random.nextInt(this.Jn) : 0;
            }
            int i3 = this.Jq + i2;
            int i4 = this.Jn;
            if (this.gXE[i] == null) {
                this.gXE[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.gXE[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Jq = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.Jr = i;
    }

    public void start() {
        this.Jk = true;
        this.Jl = false;
        lI();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Ji = i;
        }
    }

    public void lK() {
        this.Jk = true;
        this.Jl = true;
        lI();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.Js);
    }
}
