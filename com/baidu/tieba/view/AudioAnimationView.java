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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int abA;
    private boolean abB;
    private boolean abC;
    private RectF[] abD;
    private int[] abE;
    private int abF;
    private int abG;
    private final Runnable abH;
    private int abz;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.abz = 0;
        this.abA = 8;
        this.abB = false;
        this.abC = true;
        this.abE = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.abG = R.color.cp_cont_a;
        this.abH = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.sv();
            }
        };
        sw();
        sv();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.abz = 0;
        this.abA = 8;
        this.abB = false;
        this.abC = true;
        this.abE = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.abG = R.color.cp_cont_a;
        this.abH = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.sv();
            }
        };
        sw();
        sv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sv() {
        if (this.abB) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.abH);
        if (!this.abC) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.abH, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.abz > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.abF * ((this.abz * 2) - 1);
            this.abA = this.abz;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.abz <= 0) {
            this.abA = (this.mCanvasWidth / this.abF) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.abB) {
            for (int i = 0; i < this.abA; i++) {
                sx();
                if (i < this.abD.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.abD[i].top / 2.0f));
                    canvas.drawRoundRect(this.abD[i], 10.0f, 10.0f, this.mPaint);
                    canvas.restore();
                }
            }
        }
    }

    private void sw() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ap.getColor(this.abG));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(ap.getColor(this.abG));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void sx() {
        int nextInt;
        if (this.abD == null || this.abD.length != this.abA) {
            this.abD = new RectF[this.abA];
        }
        for (int i = 0; i < this.abA; i++) {
            int i2 = this.abF * i * 2;
            if (this.abC) {
                nextInt = (int) ((1.0d - (this.abE[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.abF + i2;
            int i4 = this.mCanvasHeight;
            if (this.abD[i] == null) {
                this.abD[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.abD[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.abF = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ap.getColor(i));
        }
        this.abG = i;
    }

    public void start() {
        this.abB = true;
        this.abC = false;
        sv();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.abz = i;
        }
    }

    public void sy() {
        this.abB = true;
        this.abC = true;
        sv();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.abH);
    }
}
