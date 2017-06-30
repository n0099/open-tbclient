package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int bCg;
    private int fZA;
    private int fZB;
    private boolean fZC;
    private int fZD;
    private int fZE;
    private Rect[] fZF;
    private int[] fZG;
    private int fZH;
    private final Runnable fZI;
    private boolean fpe;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.fZA = 0;
        this.fZB = 8;
        this.fpe = false;
        this.fZC = true;
        this.fZG = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fZH = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds4);
        this.bCg = w.e.cp_link_tip_a;
        this.fZI = new a(this);
        initPaint();
        bdg();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.fZA = 0;
        this.fZB = 8;
        this.fpe = false;
        this.fZC = true;
        this.fZG = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fZH = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds4);
        this.bCg = w.e.cp_link_tip_a;
        this.fZI = new a(this);
        initPaint();
        bdg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdg() {
        if (this.fpe) {
            invalidate();
        }
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.fZI);
        if (!this.fZC) {
            com.baidu.adp.lib.g.h.fR().postDelayed(this.fZI, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.fZA > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.fZD = this.fZH * ((this.fZA * 2) - 1);
            this.fZB = this.fZA;
            i = View.MeasureSpec.makeMeasureSpec(this.fZD, mode);
        }
        super.onMeasure(i, i2);
        this.fZE = getMeasuredHeight();
        this.fZD = getMeasuredWidth();
        if (this.fZA <= 0) {
            this.fZB = (this.fZD / this.fZH) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fpe) {
            for (int i = 0; i < this.fZB; i++) {
                bqy();
                if (i < this.fZF.length) {
                    canvas.drawRect(this.fZF[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(as.getColor(this.bCg));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(as.getColor(this.bCg));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bqy() {
        int nextInt;
        if (this.fZF == null || this.fZF.length != this.fZB) {
            this.fZF = new Rect[this.fZB];
        }
        for (int i = 0; i < this.fZB; i++) {
            int i2 = this.fZH * i * 2;
            if (this.fZC) {
                nextInt = (int) ((1.0d - (this.fZG[i % 22] / 10.0d)) * this.fZE);
            } else {
                nextInt = this.fZE > 0 ? this.random.nextInt(this.fZE) : 0;
            }
            int i3 = this.fZH + i2;
            int i4 = this.fZE;
            if (this.fZF[i] == null) {
                this.fZF[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.fZF[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.fZH = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(as.getColor(i));
        }
        this.bCg = i;
    }

    public void start() {
        this.fpe = true;
        this.fZC = false;
        bdg();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.fZA = i;
        }
    }

    public void bqz() {
        this.fpe = true;
        this.fZC = true;
        bdg();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.fZI);
    }
}
