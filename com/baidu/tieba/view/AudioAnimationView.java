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
    private int bLb;
    private boolean gvA;
    private boolean gvB;
    private int gvC;
    private int gvD;
    private Rect[] gvE;
    private int[] gvF;
    private int gvG;
    private final Runnable gvH;
    private int gvy;
    private int gvz;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.gvy = 0;
        this.gvz = 8;
        this.gvA = false;
        this.gvB = true;
        this.gvF = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gvG = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bLb = d.e.cp_link_tip_a;
        this.gvH = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bwr();
            }
        };
        initPaint();
        bwr();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.gvy = 0;
        this.gvz = 8;
        this.gvA = false;
        this.gvB = true;
        this.gvF = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gvG = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bLb = d.e.cp_link_tip_a;
        this.gvH = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bwr();
            }
        };
        initPaint();
        bwr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwr() {
        if (this.gvA) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.gvH);
        if (!this.gvB) {
            com.baidu.adp.lib.g.e.fQ().postDelayed(this.gvH, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.gvy > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.gvC = this.gvG * ((this.gvy * 2) - 1);
            this.gvz = this.gvy;
            i = View.MeasureSpec.makeMeasureSpec(this.gvC, mode);
        }
        super.onMeasure(i, i2);
        this.gvD = getMeasuredHeight();
        this.gvC = getMeasuredWidth();
        if (this.gvy <= 0) {
            this.gvz = (this.gvC / this.gvG) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.gvA) {
            for (int i = 0; i < this.gvz; i++) {
                bws();
                if (i < this.gvE.length) {
                    canvas.drawRect(this.gvE[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.bLb));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(this.bLb));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bws() {
        int nextInt;
        if (this.gvE == null || this.gvE.length != this.gvz) {
            this.gvE = new Rect[this.gvz];
        }
        for (int i = 0; i < this.gvz; i++) {
            int i2 = this.gvG * i * 2;
            if (this.gvB) {
                nextInt = (int) ((1.0d - (this.gvF[i % 22] / 10.0d)) * this.gvD);
            } else {
                nextInt = this.gvD > 0 ? this.random.nextInt(this.gvD) : 0;
            }
            int i3 = this.gvG + i2;
            int i4 = this.gvD;
            if (this.gvE[i] == null) {
                this.gvE[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.gvE[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.gvG = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.bLb = i;
    }

    public void start() {
        this.gvA = true;
        this.gvB = false;
        bwr();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.gvy = i;
        }
    }

    public void bwt() {
        this.gvA = true;
        this.gvB = true;
        bwr();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.gvH);
    }
}
