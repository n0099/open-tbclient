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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int FE;
    private int FF;
    private boolean FG;
    private boolean FH;
    private RectF[] FI;
    private int[] FJ;
    private int FK;
    private int FL;
    private final Runnable FM;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.FE = 0;
        this.FF = 8;
        this.FG = false;
        this.FH = true;
        this.FJ = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.FK = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.FL = R.color.cp_cont_a;
        this.FM = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.lA();
            }
        };
        lB();
        lA();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.FE = 0;
        this.FF = 8;
        this.FG = false;
        this.FH = true;
        this.FJ = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.FK = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.FL = R.color.cp_cont_a;
        this.FM = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.lA();
            }
        };
        lB();
        lA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lA() {
        if (this.FG) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.FM);
        if (!this.FH) {
            com.baidu.adp.lib.f.e.gy().postDelayed(this.FM, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.FE > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.FK * ((this.FE * 2) - 1);
            this.FF = this.FE;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.FE <= 0) {
            this.FF = (this.mCanvasWidth / this.FK) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.FG) {
            for (int i = 0; i < this.FF; i++) {
                lC();
                if (i < this.FI.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.FI[i].top / 2.0f));
                    canvas.drawRoundRect(this.FI[i], 10.0f, 10.0f, this.mPaint);
                    canvas.restore();
                }
            }
        }
    }

    private void lB() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(am.getColor(this.FL));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(am.getColor(this.FL));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void lC() {
        int nextInt;
        if (this.FI == null || this.FI.length != this.FF) {
            this.FI = new RectF[this.FF];
        }
        for (int i = 0; i < this.FF; i++) {
            int i2 = this.FK * i * 2;
            if (this.FH) {
                nextInt = (int) ((1.0d - (this.FJ[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.FK + i2;
            int i4 = this.mCanvasHeight;
            if (this.FI[i] == null) {
                this.FI[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.FI[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.FK = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(am.getColor(i));
        }
        this.FL = i;
    }

    public void start() {
        this.FG = true;
        this.FH = false;
        lA();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.FE = i;
        }
    }

    public void lD() {
        this.FG = true;
        this.FH = true;
        lA();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.FM);
    }
}
