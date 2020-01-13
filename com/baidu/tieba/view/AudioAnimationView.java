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
    private int FJ;
    private int FK;
    private boolean FL;
    private boolean FM;
    private RectF[] FN;
    private int[] FO;
    private int FP;
    private int FQ;
    private final Runnable FR;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.FJ = 0;
        this.FK = 8;
        this.FL = false;
        this.FM = true;
        this.FO = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.FP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.FQ = R.color.cp_cont_a;
        this.FR = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        this.FJ = 0;
        this.FK = 8;
        this.FL = false;
        this.FM = true;
        this.FO = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.FP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.FQ = R.color.cp_cont_a;
        this.FR = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        if (this.FL) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.FR);
        if (!this.FM) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.FR, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.FJ > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.FP * ((this.FJ * 2) - 1);
            this.FK = this.FJ;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.FJ <= 0) {
            this.FK = (this.mCanvasWidth / this.FP) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.FL) {
            for (int i = 0; i < this.FK; i++) {
                lC();
                if (i < this.FN.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.FN[i].top / 2.0f));
                    canvas.drawRoundRect(this.FN[i], 10.0f, 10.0f, this.mPaint);
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
        this.mPaint.setColor(am.getColor(this.FQ));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(am.getColor(this.FQ));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void lC() {
        int nextInt;
        if (this.FN == null || this.FN.length != this.FK) {
            this.FN = new RectF[this.FK];
        }
        for (int i = 0; i < this.FK; i++) {
            int i2 = this.FP * i * 2;
            if (this.FM) {
                nextInt = (int) ((1.0d - (this.FO[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.FP + i2;
            int i4 = this.mCanvasHeight;
            if (this.FN[i] == null) {
                this.FN[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.FN[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.FP = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(am.getColor(i));
        }
        this.FQ = i;
    }

    public void start() {
        this.FL = true;
        this.FM = false;
        lA();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.FJ = i;
        }
    }

    public void lD() {
        this.FL = true;
        this.FM = true;
        lA();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.FR);
    }
}
