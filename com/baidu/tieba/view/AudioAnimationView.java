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
    private int Wd;
    private int We;
    private boolean Wf;
    private boolean Wg;
    private int Wh;
    private int Wi;
    private RectF[] Wj;
    private int[] Wk;
    private int Wl;
    private int Wm;
    private final Runnable Wn;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Wd = 0;
        this.We = 8;
        this.Wf = false;
        this.Wg = true;
        this.Wk = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Wl = l.h(TbadkCoreApplication.getInst(), d.e.tbds5);
        this.Wm = d.C0277d.cp_btn_a;
        this.Wn = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        this.Wd = 0;
        this.We = 8;
        this.Wf = false;
        this.Wg = true;
        this.Wk = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Wl = l.h(TbadkCoreApplication.getInst(), d.e.tbds5);
        this.Wm = d.C0277d.cp_btn_a;
        this.Wn = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        if (this.Wf) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.Wn);
        if (!this.Wg) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.Wn, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Wd > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Wh = this.Wl * ((this.Wd * 2) - 1);
            this.We = this.Wd;
            i = View.MeasureSpec.makeMeasureSpec(this.Wh, mode);
        }
        super.onMeasure(i, i2);
        this.Wi = getMeasuredHeight();
        this.Wh = getMeasuredWidth();
        if (this.Wd <= 0) {
            this.We = (this.Wh / this.Wl) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Wf) {
            for (int i = 0; i < this.We; i++) {
                qZ();
                if (i < this.Wj.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.Wj[i].top / 2.0f));
                    canvas.drawRoundRect(this.Wj[i], 10.0f, 10.0f, this.mPaint);
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
        this.mPaint.setColor(al.getColor(this.Wm));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(al.getColor(this.Wm));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void qZ() {
        int nextInt;
        if (this.Wj == null || this.Wj.length != this.We) {
            this.Wj = new RectF[this.We];
        }
        for (int i = 0; i < this.We; i++) {
            int i2 = this.Wl * i * 2;
            if (this.Wg) {
                nextInt = (int) ((1.0d - (this.Wk[i % 22] / 10.0d)) * this.Wi);
            } else {
                nextInt = this.Wi > 0 ? this.random.nextInt(this.Wi) : 0;
            }
            int i3 = this.Wl + i2;
            int i4 = this.Wi;
            if (this.Wj[i] == null) {
                this.Wj[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.Wj[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Wl = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(al.getColor(i));
        }
        this.Wm = i;
    }

    public void start() {
        this.Wf = true;
        this.Wg = false;
        qX();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Wd = i;
        }
    }

    public void ra() {
        this.Wf = true;
        this.Wg = true;
        qX();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.Wn);
    }
}
