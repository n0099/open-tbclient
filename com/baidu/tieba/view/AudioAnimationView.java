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
    private int acC;
    private int acD;
    private boolean acE;
    private boolean acF;
    private RectF[] acG;
    private int[] acH;
    private int acI;
    private int acJ;
    private final Runnable acK;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.acC = 0;
        this.acD = 8;
        this.acE = false;
        this.acF = true;
        this.acH = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.acI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.acJ = R.color.CAM_X0302;
        this.acK = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.sy();
            }
        };
        sz();
        sy();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.acC = 0;
        this.acD = 8;
        this.acE = false;
        this.acF = true;
        this.acH = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.acI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.acJ = R.color.CAM_X0302;
        this.acK = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.sy();
            }
        };
        sz();
        sy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sy() {
        if (this.acE) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.acK);
        if (!this.acF) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.acK, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.acC > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.acI * ((this.acC * 2) - 1);
            this.acD = this.acC;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.acC <= 0) {
            this.acD = (this.mCanvasWidth / this.acI) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.acE) {
            for (int i = 0; i < this.acD; i++) {
                sA();
                if (i < this.acG.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.acG[i].top / 2.0f));
                    canvas.drawRoundRect(this.acG[i], 10.0f, 10.0f, this.mPaint);
                    canvas.restore();
                }
            }
        }
    }

    private void sz() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ap.getColor(this.acJ));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(ap.getColor(this.acJ));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void sA() {
        int nextInt;
        if (this.acG == null || this.acG.length != this.acD) {
            this.acG = new RectF[this.acD];
        }
        for (int i = 0; i < this.acD; i++) {
            int i2 = this.acI * i * 2;
            if (this.acF) {
                nextInt = (int) ((1.0d - (this.acH[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.acI + i2;
            int i4 = this.mCanvasHeight;
            if (this.acG[i] == null) {
                this.acG[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.acG[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.acI = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ap.getColor(i));
        }
        this.acJ = i;
    }

    public void start() {
        this.acE = true;
        this.acF = false;
        sy();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.acC = i;
        }
    }

    public void sB() {
        this.acE = true;
        this.acF = true;
        sy();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.acK);
    }
}
