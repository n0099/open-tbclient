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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int Kh;
    private int Ki;
    private boolean Kj;
    private boolean Kk;
    private int Kl;
    private int Km;
    private int[] Ko;
    private int Kp;
    private int Kq;
    private final Runnable Kr;
    private Rect[] gWF;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Kh = 0;
        this.Ki = 8;
        this.Kj = false;
        this.Kk = true;
        this.Ko = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Kp = l.e(TbadkCoreApplication.getInst(), d.e.ds4);
        this.Kq = d.C0126d.cp_link_tip_a;
        this.Kr = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.lR();
            }
        };
        initPaint();
        lR();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Kh = 0;
        this.Ki = 8;
        this.Kj = false;
        this.Kk = true;
        this.Ko = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Kp = l.e(TbadkCoreApplication.getInst(), d.e.ds4);
        this.Kq = d.C0126d.cp_link_tip_a;
        this.Kr = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.lR();
            }
        };
        initPaint();
        lR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR() {
        if (this.Kj) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.Kr);
        if (!this.Kk) {
            com.baidu.adp.lib.g.e.fw().postDelayed(this.Kr, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Kh > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Kl = this.Kp * ((this.Kh * 2) - 1);
            this.Ki = this.Kh;
            i = View.MeasureSpec.makeMeasureSpec(this.Kl, mode);
        }
        super.onMeasure(i, i2);
        this.Km = getMeasuredHeight();
        this.Kl = getMeasuredWidth();
        if (this.Kh <= 0) {
            this.Ki = (this.Kl / this.Kp) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Kj) {
            for (int i = 0; i < this.Ki; i++) {
                lS();
                if (i < this.gWF.length) {
                    canvas.drawRect(this.gWF[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ak.getColor(this.Kq));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(ak.getColor(this.Kq));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void lS() {
        int nextInt;
        if (this.gWF == null || this.gWF.length != this.Ki) {
            this.gWF = new Rect[this.Ki];
        }
        for (int i = 0; i < this.Ki; i++) {
            int i2 = this.Kp * i * 2;
            if (this.Kk) {
                nextInt = (int) ((1.0d - (this.Ko[i % 22] / 10.0d)) * this.Km);
            } else {
                nextInt = this.Km > 0 ? this.random.nextInt(this.Km) : 0;
            }
            int i3 = this.Kp + i2;
            int i4 = this.Km;
            if (this.gWF[i] == null) {
                this.gWF[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.gWF[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Kp = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ak.getColor(i));
        }
        this.Kq = i;
    }

    public void start() {
        this.Kj = true;
        this.Kk = false;
        lR();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Kh = i;
        }
    }

    public void lT() {
        this.Kj = true;
        this.Kk = true;
        lR();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.Kr);
    }
}
