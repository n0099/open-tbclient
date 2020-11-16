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
    private int abE;
    private int abF;
    private boolean abG;
    private boolean abH;
    private RectF[] abI;
    private int[] abJ;
    private int abK;
    private int abL;
    private final Runnable abM;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.abE = 0;
        this.abF = 8;
        this.abG = false;
        this.abH = true;
        this.abJ = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abK = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.abL = R.color.CAM_X0302;
        this.abM = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        this.abE = 0;
        this.abF = 8;
        this.abG = false;
        this.abH = true;
        this.abJ = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abK = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.abL = R.color.CAM_X0302;
        this.abM = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
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
        if (this.abG) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.abM);
        if (!this.abH) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.abM, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.abE > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.abK * ((this.abE * 2) - 1);
            this.abF = this.abE;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.abE <= 0) {
            this.abF = (this.mCanvasWidth / this.abK) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.abG) {
            for (int i = 0; i < this.abF; i++) {
                sx();
                if (i < this.abI.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.abI[i].top / 2.0f));
                    canvas.drawRoundRect(this.abI[i], 10.0f, 10.0f, this.mPaint);
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
        this.mPaint.setColor(ap.getColor(this.abL));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(ap.getColor(this.abL));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void sx() {
        int nextInt;
        if (this.abI == null || this.abI.length != this.abF) {
            this.abI = new RectF[this.abF];
        }
        for (int i = 0; i < this.abF; i++) {
            int i2 = this.abK * i * 2;
            if (this.abH) {
                nextInt = (int) ((1.0d - (this.abJ[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.abK + i2;
            int i4 = this.mCanvasHeight;
            if (this.abI[i] == null) {
                this.abI[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.abI[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.abK = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ap.getColor(i));
        }
        this.abL = i;
    }

    public void start() {
        this.abG = true;
        this.abH = false;
        sv();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.abE = i;
        }
    }

    public void sy() {
        this.abG = true;
        this.abH = true;
        sv();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.abM);
    }
}
