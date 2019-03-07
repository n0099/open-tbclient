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
    private int Wb;
    private int Wc;
    private boolean Wd;
    private boolean We;
    private int Wf;
    private int Wg;
    private RectF[] Wh;
    private int[] Wi;
    private int Wj;
    private int Wk;
    private final Runnable Wl;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Wb = 0;
        this.Wc = 8;
        this.Wd = false;
        this.We = true;
        this.Wi = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Wj = l.h(TbadkCoreApplication.getInst(), d.e.tbds5);
        this.Wk = d.C0236d.cp_btn_a;
        this.Wl = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        this.Wb = 0;
        this.Wc = 8;
        this.Wd = false;
        this.We = true;
        this.Wi = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Wj = l.h(TbadkCoreApplication.getInst(), d.e.tbds5);
        this.Wk = d.C0236d.cp_btn_a;
        this.Wl = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        if (this.Wd) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.Wl);
        if (!this.We) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.Wl, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Wb > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Wf = this.Wj * ((this.Wb * 2) - 1);
            this.Wc = this.Wb;
            i = View.MeasureSpec.makeMeasureSpec(this.Wf, mode);
        }
        super.onMeasure(i, i2);
        this.Wg = getMeasuredHeight();
        this.Wf = getMeasuredWidth();
        if (this.Wb <= 0) {
            this.Wc = (this.Wf / this.Wj) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Wd) {
            for (int i = 0; i < this.Wc; i++) {
                qZ();
                if (i < this.Wh.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.Wh[i].top / 2.0f));
                    canvas.drawRoundRect(this.Wh[i], 10.0f, 10.0f, this.mPaint);
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
        this.mPaint.setColor(al.getColor(this.Wk));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(al.getColor(this.Wk));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void qZ() {
        int nextInt;
        if (this.Wh == null || this.Wh.length != this.Wc) {
            this.Wh = new RectF[this.Wc];
        }
        for (int i = 0; i < this.Wc; i++) {
            int i2 = this.Wj * i * 2;
            if (this.We) {
                nextInt = (int) ((1.0d - (this.Wi[i % 22] / 10.0d)) * this.Wg);
            } else {
                nextInt = this.Wg > 0 ? this.random.nextInt(this.Wg) : 0;
            }
            int i3 = this.Wj + i2;
            int i4 = this.Wg;
            if (this.Wh[i] == null) {
                this.Wh[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.Wh[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Wj = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(al.getColor(i));
        }
        this.Wk = i;
    }

    public void start() {
        this.Wd = true;
        this.We = false;
        qX();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Wb = i;
        }
    }

    public void ra() {
        this.Wd = true;
        this.We = true;
        qX();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.Wl);
    }
}
