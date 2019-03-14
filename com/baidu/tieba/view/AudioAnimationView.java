package com.baidu.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int Wc;
    private int Wd;
    private boolean We;
    private boolean Wf;
    private int Wg;
    private int Wh;
    private RectF[] Wi;
    private int[] Wj;
    private int Wk;
    private int Wl;
    private final Runnable Wm;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Wc = 0;
        this.Wd = 8;
        this.We = false;
        this.Wf = true;
        this.Wj = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Wk = l.h(TbadkCoreApplication.getInst(), d.e.tbds5);
        this.Wl = d.C0277d.cp_btn_a;
        this.Wm = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qX();
            }
        };
        qY();
        qX();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Wc = 0;
        this.Wd = 8;
        this.We = false;
        this.Wf = true;
        this.Wj = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Wk = l.h(TbadkCoreApplication.getInst(), d.e.tbds5);
        this.Wl = d.C0277d.cp_btn_a;
        this.Wm = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qX();
            }
        };
        qY();
        qX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX() {
        if (this.We) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.Wm);
        if (!this.Wf) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.Wm, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Wc > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Wg = this.Wk * ((this.Wc * 2) - 1);
            this.Wd = this.Wc;
            i = View.MeasureSpec.makeMeasureSpec(this.Wg, mode);
        }
        super.onMeasure(i, i2);
        this.Wh = getMeasuredHeight();
        this.Wg = getMeasuredWidth();
        if (this.Wc <= 0) {
            this.Wd = (this.Wg / this.Wk) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.We) {
            for (int i = 0; i < this.Wd; i++) {
                qZ();
                if (i < this.Wi.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.Wi[i].top / 2.0f));
                    canvas.drawRoundRect(this.Wi[i], 10.0f, 10.0f, this.mPaint);
                    canvas.restore();
                }
            }
        }
    }

    private void qY() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(al.getColor(this.Wl));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(al.getColor(this.Wl));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void qZ() {
        int nextInt;
        if (this.Wi == null || this.Wi.length != this.Wd) {
            this.Wi = new RectF[this.Wd];
        }
        for (int i = 0; i < this.Wd; i++) {
            int i2 = this.Wk * i * 2;
            if (this.Wf) {
                nextInt = (int) ((1.0d - (this.Wj[i % 22] / 10.0d)) * this.Wh);
            } else {
                nextInt = this.Wh > 0 ? this.random.nextInt(this.Wh) : 0;
            }
            int i3 = this.Wk + i2;
            int i4 = this.Wh;
            if (this.Wi[i] == null) {
                this.Wi[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.Wi[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Wk = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(al.getColor(i));
        }
        this.Wl = i;
    }

    public void start() {
        this.We = true;
        this.Wf = false;
        qX();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Wc = i;
        }
    }

    public void ra() {
        this.We = true;
        this.Wf = true;
        qX();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.Wm);
    }
}
