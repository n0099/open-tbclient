package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.h.h;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private boolean dTq;
    private int eFg;
    private int eFh;
    private boolean eFi;
    private int eFj;
    private int eFk;
    private Rect[] eFl;
    private int[] eFm;
    private int eFn;
    private int eFo;
    private final Runnable eFp;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.eFg = 0;
        this.eFh = 8;
        this.dTq = false;
        this.eFi = true;
        this.eFm = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.eFn = k.c(TbadkCoreApplication.m411getInst(), t.e.ds4);
        this.eFo = t.d.cp_link_tip_a;
        this.eFp = new a(this);
        initPaint();
        aKX();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.eFg = 0;
        this.eFh = 8;
        this.dTq = false;
        this.eFi = true;
        this.eFm = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.eFn = k.c(TbadkCoreApplication.m411getInst(), t.e.ds4);
        this.eFo = t.d.cp_link_tip_a;
        this.eFp = new a(this);
        initPaint();
        aKX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKX() {
        if (this.dTq) {
            invalidate();
        }
        h.hx().removeCallbacks(this.eFp);
        if (!this.eFi) {
            h.hx().postDelayed(this.eFp, 100L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.eFg > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.eFj = this.eFn * ((this.eFg * 2) - 1);
            this.eFh = this.eFg;
            i = View.MeasureSpec.makeMeasureSpec(this.eFj, mode);
        }
        super.onMeasure(i, i2);
        this.eFk = getMeasuredHeight();
        this.eFj = getMeasuredWidth();
        if (this.eFg <= 0) {
            this.eFh = (this.eFj / this.eFn) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.dTq) {
            for (int i = 0; i < this.eFh; i++) {
                aYA();
                if (i < this.eFl.length) {
                    canvas.drawRect(this.eFl[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(at.getColor(this.eFo));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(at.getColor(this.eFo));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void aYA() {
        int nextInt;
        if (this.eFl == null || this.eFl.length != this.eFh) {
            this.eFl = new Rect[this.eFh];
        }
        for (int i = 0; i < this.eFh; i++) {
            int i2 = this.eFn * i * 2;
            if (this.eFi) {
                nextInt = (int) ((1.0d - (this.eFm[i % 22] / 10.0d)) * this.eFk);
            } else {
                nextInt = this.eFk > 0 ? this.random.nextInt(this.eFk) : 0;
            }
            int i3 = this.eFn + i2;
            int i4 = this.eFk;
            if (this.eFl[i] == null) {
                this.eFl[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.eFl[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(at.getColor(i));
        }
        this.eFo = i;
    }

    public void start() {
        this.dTq = true;
        this.eFi = false;
        aKX();
    }

    public void setCertainColumnCount(int i) {
        this.eFg = i;
    }

    public void aYB() {
        this.dTq = true;
        this.eFi = true;
        aKX();
    }
}
