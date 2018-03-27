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
    private int axW;
    private int axX;
    private boolean axY;
    private boolean axZ;
    private int aya;
    private int ayb;
    private int[] ayd;
    private int aye;
    private int ayf;
    private final Runnable ayg;
    private Rect[] hAk;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.axW = 0;
        this.axX = 8;
        this.axY = false;
        this.axZ = true;
        this.ayd = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aye = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst(), d.e.ds4);
        this.ayf = d.C0141d.cp_link_tip_a;
        this.ayg = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.tl();
            }
        };
        initPaint();
        tl();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.axW = 0;
        this.axX = 8;
        this.axY = false;
        this.axZ = true;
        this.ayd = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aye = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst(), d.e.ds4);
        this.ayf = d.C0141d.cp_link_tip_a;
        this.ayg = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.tl();
            }
        };
        initPaint();
        tl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl() {
        if (this.axY) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.ayg);
        if (!this.axZ) {
            com.baidu.adp.lib.g.e.ns().postDelayed(this.ayg, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.axW > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.aya = this.aye * ((this.axW * 2) - 1);
            this.axX = this.axW;
            i = View.MeasureSpec.makeMeasureSpec(this.aya, mode);
        }
        super.onMeasure(i, i2);
        this.ayb = getMeasuredHeight();
        this.aya = getMeasuredWidth();
        if (this.axW <= 0) {
            this.axX = (this.aya / this.aye) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.axY) {
            for (int i = 0; i < this.axX; i++) {
                tm();
                if (i < this.hAk.length) {
                    canvas.drawRect(this.hAk[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.ayf));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(this.ayf));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void tm() {
        int nextInt;
        if (this.hAk == null || this.hAk.length != this.axX) {
            this.hAk = new Rect[this.axX];
        }
        for (int i = 0; i < this.axX; i++) {
            int i2 = this.aye * i * 2;
            if (this.axZ) {
                nextInt = (int) ((1.0d - (this.ayd[i % 22] / 10.0d)) * this.ayb);
            } else {
                nextInt = this.ayb > 0 ? this.random.nextInt(this.ayb) : 0;
            }
            int i3 = this.aye + i2;
            int i4 = this.ayb;
            if (this.hAk[i] == null) {
                this.hAk[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.hAk[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.aye = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.ayf = i;
    }

    public void start() {
        this.axY = true;
        this.axZ = false;
        tl();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.axW = i;
        }
    }

    public void tn() {
        this.axY = true;
        this.axZ = true;
        tl();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.ayg);
    }
}
