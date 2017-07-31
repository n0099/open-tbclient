package com.baidu.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int bHx;
    private boolean fDe;
    private int gvf;
    private int gvg;
    private boolean gvh;
    private int gvi;
    private int gvj;
    private Rect[] gvk;
    private int[] gvl;
    private int gvm;
    private final Runnable gvn;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.gvf = 0;
        this.gvg = 8;
        this.fDe = false;
        this.gvh = true;
        this.gvl = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gvm = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bHx = d.e.cp_link_tip_a;
        this.gvn = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bgR();
            }
        };
        initPaint();
        bgR();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.gvf = 0;
        this.gvg = 8;
        this.fDe = false;
        this.gvh = true;
        this.gvl = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gvm = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bHx = d.e.cp_link_tip_a;
        this.gvn = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bgR();
            }
        };
        initPaint();
        bgR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgR() {
        if (this.fDe) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.gvn);
        if (!this.gvh) {
            com.baidu.adp.lib.g.e.ga().postDelayed(this.gvn, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.gvf > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.gvi = this.gvm * ((this.gvf * 2) - 1);
            this.gvg = this.gvf;
            i = View.MeasureSpec.makeMeasureSpec(this.gvi, mode);
        }
        super.onMeasure(i, i2);
        this.gvj = getMeasuredHeight();
        this.gvi = getMeasuredWidth();
        if (this.gvf <= 0) {
            this.gvg = (this.gvi / this.gvm) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fDe) {
            for (int i = 0; i < this.gvg; i++) {
                bwB();
                if (i < this.gvk.length) {
                    canvas.drawRect(this.gvk[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ai.getColor(this.bHx));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(ai.getColor(this.bHx));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bwB() {
        int nextInt;
        if (this.gvk == null || this.gvk.length != this.gvg) {
            this.gvk = new Rect[this.gvg];
        }
        for (int i = 0; i < this.gvg; i++) {
            int i2 = this.gvm * i * 2;
            if (this.gvh) {
                nextInt = (int) ((1.0d - (this.gvl[i % 22] / 10.0d)) * this.gvj);
            } else {
                nextInt = this.gvj > 0 ? this.random.nextInt(this.gvj) : 0;
            }
            int i3 = this.gvm + i2;
            int i4 = this.gvj;
            if (this.gvk[i] == null) {
                this.gvk[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.gvk[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.gvm = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ai.getColor(i));
        }
        this.bHx = i;
    }

    public void start() {
        this.fDe = true;
        this.gvh = false;
        bgR();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.gvf = i;
        }
    }

    public void bwC() {
        this.fDe = true;
        this.gvh = true;
        bgR();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.gvn);
    }
}
