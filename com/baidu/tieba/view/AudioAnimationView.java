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
    private int SY;
    private int SZ;
    private boolean Ta;
    private boolean Tb;
    private int Tc;
    private int Td;
    private int[] Tf;
    private int Tg;
    private int Th;
    private final Runnable Ti;
    private Rect[] hwo;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.SY = 0;
        this.SZ = 8;
        this.Ta = false;
        this.Tb = true;
        this.Tf = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Tg = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds4);
        this.Th = e.d.cp_link_tip_a;
        this.Ti = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.pM();
            }
        };
        pN();
        pM();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.SY = 0;
        this.SZ = 8;
        this.Ta = false;
        this.Tb = true;
        this.Tf = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Tg = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds4);
        this.Th = e.d.cp_link_tip_a;
        this.Ti = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.pM();
            }
        };
        pN();
        pM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM() {
        if (this.Ta) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.Ti);
        if (!this.Tb) {
            com.baidu.adp.lib.g.e.jt().postDelayed(this.Ti, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.SY > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Tc = this.Tg * ((this.SY * 2) - 1);
            this.SZ = this.SY;
            i = View.MeasureSpec.makeMeasureSpec(this.Tc, mode);
        }
        super.onMeasure(i, i2);
        this.Td = getMeasuredHeight();
        this.Tc = getMeasuredWidth();
        if (this.SY <= 0) {
            this.SZ = (this.Tc / this.Tg) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Ta) {
            for (int i = 0; i < this.SZ; i++) {
                pO();
                if (i < this.hwo.length) {
                    canvas.drawRect(this.hwo[i], this.mPaint);
                }
            }
        }
    }

    private void pN() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(al.getColor(this.Th));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(al.getColor(this.Th));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void pO() {
        int nextInt;
        if (this.hwo == null || this.hwo.length != this.SZ) {
            this.hwo = new Rect[this.SZ];
        }
        for (int i = 0; i < this.SZ; i++) {
            int i2 = this.Tg * i * 2;
            if (this.Tb) {
                nextInt = (int) ((1.0d - (this.Tf[i % 22] / 10.0d)) * this.Td);
            } else {
                nextInt = this.Td > 0 ? this.random.nextInt(this.Td) : 0;
            }
            int i3 = this.Tg + i2;
            int i4 = this.Td;
            if (this.hwo[i] == null) {
                this.hwo[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.hwo[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Tg = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(al.getColor(i));
        }
        this.Th = i;
    }

    public void start() {
        this.Ta = true;
        this.Tb = false;
        pM();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.SY = i;
        }
    }

    public void pP() {
        this.Ta = true;
        this.Tb = true;
        pM();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.Ti);
    }
}
