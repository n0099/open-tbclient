package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int bvz;
    private boolean eVT;
    private int fHP;
    private int fHQ;
    private boolean fHR;
    private int fHS;
    private int fHT;
    private Rect[] fHU;
    private int[] fHV;
    private int fHW;
    private final Runnable fHX;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.fHP = 0;
        this.fHQ = 8;
        this.eVT = false;
        this.fHR = true;
        this.fHV = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fHW = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds4);
        this.bvz = w.e.cp_link_tip_a;
        this.fHX = new a(this);
        initPaint();
        aXC();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.fHP = 0;
        this.fHQ = 8;
        this.eVT = false;
        this.fHR = true;
        this.fHV = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fHW = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds4);
        this.bvz = w.e.cp_link_tip_a;
        this.fHX = new a(this);
        initPaint();
        aXC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXC() {
        if (this.eVT) {
            invalidate();
        }
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fHX);
        if (!this.fHR) {
            com.baidu.adp.lib.g.h.fS().postDelayed(this.fHX, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.fHP > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.fHS = this.fHW * ((this.fHP * 2) - 1);
            this.fHQ = this.fHP;
            i = View.MeasureSpec.makeMeasureSpec(this.fHS, mode);
        }
        super.onMeasure(i, i2);
        this.fHT = getMeasuredHeight();
        this.fHS = getMeasuredWidth();
        if (this.fHP <= 0) {
            this.fHQ = (this.fHS / this.fHW) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eVT) {
            for (int i = 0; i < this.fHQ; i++) {
                bkQ();
                if (i < this.fHU.length) {
                    canvas.drawRect(this.fHU[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aq.getColor(this.bvz));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aq.getColor(this.bvz));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bkQ() {
        int nextInt;
        if (this.fHU == null || this.fHU.length != this.fHQ) {
            this.fHU = new Rect[this.fHQ];
        }
        for (int i = 0; i < this.fHQ; i++) {
            int i2 = this.fHW * i * 2;
            if (this.fHR) {
                nextInt = (int) ((1.0d - (this.fHV[i % 22] / 10.0d)) * this.fHT);
            } else {
                nextInt = this.fHT > 0 ? this.random.nextInt(this.fHT) : 0;
            }
            int i3 = this.fHW + i2;
            int i4 = this.fHT;
            if (this.fHU[i] == null) {
                this.fHU[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.fHU[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.fHW = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aq.getColor(i));
        }
        this.bvz = i;
    }

    public void start() {
        this.eVT = true;
        this.fHR = false;
        aXC();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.fHP = i;
        }
    }

    public void bkR() {
        this.eVT = true;
        this.fHR = true;
        aXC();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fHX);
    }
}
