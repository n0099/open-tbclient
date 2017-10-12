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
    private int gBY;
    private int gBZ;
    private boolean gCa;
    private boolean gCb;
    private int gCc;
    private int gCd;
    private Rect[] gCe;
    private int[] gCf;
    private int gCg;
    private final Runnable gCh;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.gBY = 0;
        this.gBZ = 8;
        this.gCa = false;
        this.gCb = true;
        this.gCf = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gCg = l.f(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bLo = d.e.cp_link_tip_a;
        this.gCh = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bxT();
            }
        };
        initPaint();
        bxT();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.gBY = 0;
        this.gBZ = 8;
        this.gCa = false;
        this.gCb = true;
        this.gCf = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gCg = l.f(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bLo = d.e.cp_link_tip_a;
        this.gCh = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bxT();
            }
        };
        initPaint();
        bxT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxT() {
        if (this.gCa) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gCh);
        if (!this.gCb) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.gCh, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.gBY > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.gCc = this.gCg * ((this.gBY * 2) - 1);
            this.gBZ = this.gBY;
            i = View.MeasureSpec.makeMeasureSpec(this.gCc, mode);
        }
        super.onMeasure(i, i2);
        this.gCd = getMeasuredHeight();
        this.gCc = getMeasuredWidth();
        if (this.gBY <= 0) {
            this.gBZ = (this.gCc / this.gCg) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.gCa) {
            for (int i = 0; i < this.gBZ; i++) {
                bxU();
                if (i < this.gCe.length) {
                    canvas.drawRect(this.gCe[i], this.mPaint);
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

    private void bxU() {
        int nextInt;
        if (this.gCe == null || this.gCe.length != this.gBZ) {
            this.gCe = new Rect[this.gBZ];
        }
        for (int i = 0; i < this.gBZ; i++) {
            int i2 = this.gCg * i * 2;
            if (this.gCb) {
                nextInt = (int) ((1.0d - (this.gCf[i % 22] / 10.0d)) * this.gCd);
            } else {
                nextInt = this.gCd > 0 ? this.random.nextInt(this.gCd) : 0;
            }
            int i3 = this.gCg + i2;
            int i4 = this.gCd;
            if (this.gCe[i] == null) {
                this.gCe[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.gCe[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.gCg = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.bLo = i;
    }

    public void start() {
        this.gCa = true;
        this.gCb = false;
        bxT();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.gBY = i;
        }
    }

    public void bxV() {
        this.gCa = true;
        this.gCb = true;
        bxT();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.gCh);
    }
}
