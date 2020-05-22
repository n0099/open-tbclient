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
    private int ZH;
    private int ZI;
    private boolean ZJ;
    private boolean ZK;
    private RectF[] ZL;
    private int[] ZM;
    private int ZN;
    private int ZO;
    private final Runnable ZP;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.ZH = 0;
        this.ZI = 8;
        this.ZJ = false;
        this.ZK = true;
        this.ZM = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ZN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.ZO = R.color.cp_cont_a;
        this.ZP = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qx();
            }
        };
        qy();
        qx();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.ZH = 0;
        this.ZI = 8;
        this.ZJ = false;
        this.ZK = true;
        this.ZM = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ZN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.ZO = R.color.cp_cont_a;
        this.ZP = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qx();
            }
        };
        qy();
        qx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qx() {
        if (this.ZJ) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.ZP);
        if (!this.ZK) {
            com.baidu.adp.lib.f.e.ld().postDelayed(this.ZP, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.ZH > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.ZN * ((this.ZH * 2) - 1);
            this.ZI = this.ZH;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.ZH <= 0) {
            this.ZI = (this.mCanvasWidth / this.ZN) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ZJ) {
            for (int i = 0; i < this.ZI; i++) {
                qz();
                if (i < this.ZL.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.ZL[i].top / 2.0f));
                    canvas.drawRoundRect(this.ZL[i], 10.0f, 10.0f, this.mPaint);
                    canvas.restore();
                }
            }
        }
    }

    private void qy() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(am.getColor(this.ZO));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(am.getColor(this.ZO));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void qz() {
        int nextInt;
        if (this.ZL == null || this.ZL.length != this.ZI) {
            this.ZL = new RectF[this.ZI];
        }
        for (int i = 0; i < this.ZI; i++) {
            int i2 = this.ZN * i * 2;
            if (this.ZK) {
                nextInt = (int) ((1.0d - (this.ZM[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.ZN + i2;
            int i4 = this.mCanvasHeight;
            if (this.ZL[i] == null) {
                this.ZL[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.ZL[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.ZN = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(am.getColor(i));
        }
        this.ZO = i;
    }

    public void start() {
        this.ZJ = true;
        this.ZK = false;
        qx();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.ZH = i;
        }
    }

    public void qA() {
        this.ZJ = true;
        this.ZK = true;
        qx();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.ZP);
    }
}
