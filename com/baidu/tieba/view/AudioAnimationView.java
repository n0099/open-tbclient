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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int bLo;
    private int gBZ;
    private int gCa;
    private boolean gCb;
    private boolean gCc;
    private int gCd;
    private int gCe;
    private Rect[] gCf;
    private int[] gCg;
    private int gCh;
    private final Runnable gCi;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.gBZ = 0;
        this.gCa = 8;
        this.gCb = false;
        this.gCc = true;
        this.gCg = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gCh = l.f(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bLo = d.e.cp_link_tip_a;
        this.gCi = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bxU();
            }
        };
        initPaint();
        bxU();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.gBZ = 0;
        this.gCa = 8;
        this.gCb = false;
        this.gCc = true;
        this.gCg = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gCh = l.f(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bLo = d.e.cp_link_tip_a;
        this.gCi = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bxU();
            }
        };
        initPaint();
        bxU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxU() {
        if (this.gCb) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gCi);
        if (!this.gCc) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.gCi, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.gBZ > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.gCd = this.gCh * ((this.gBZ * 2) - 1);
            this.gCa = this.gBZ;
            i = View.MeasureSpec.makeMeasureSpec(this.gCd, mode);
        }
        super.onMeasure(i, i2);
        this.gCe = getMeasuredHeight();
        this.gCd = getMeasuredWidth();
        if (this.gBZ <= 0) {
            this.gCa = (this.gCd / this.gCh) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.gCb) {
            for (int i = 0; i < this.gCa; i++) {
                bxV();
                if (i < this.gCf.length) {
                    canvas.drawRect(this.gCf[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.bLo));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(this.bLo));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bxV() {
        int nextInt;
        if (this.gCf == null || this.gCf.length != this.gCa) {
            this.gCf = new Rect[this.gCa];
        }
        for (int i = 0; i < this.gCa; i++) {
            int i2 = this.gCh * i * 2;
            if (this.gCc) {
                nextInt = (int) ((1.0d - (this.gCg[i % 22] / 10.0d)) * this.gCe);
            } else {
                nextInt = this.gCe > 0 ? this.random.nextInt(this.gCe) : 0;
            }
            int i3 = this.gCh + i2;
            int i4 = this.gCe;
            if (this.gCf[i] == null) {
                this.gCf[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.gCf[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.gCh = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.bLo = i;
    }

    public void start() {
        this.gCb = true;
        this.gCc = false;
        bxU();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.gBZ = i;
        }
    }

    public void bxW() {
        this.gCb = true;
        this.gCc = true;
        bxU();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gCi);
    }
}
