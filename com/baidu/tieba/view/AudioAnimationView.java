package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int bcG;
    private boolean eMH;
    private int ftL;
    private int ftM;
    private boolean ftN;
    private int ftO;
    private int ftP;
    private Rect[] ftQ;
    private int[] ftR;
    private int ftS;
    private final Runnable ftT;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.ftL = 0;
        this.ftM = 8;
        this.eMH = false;
        this.ftN = true;
        this.ftR = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ftS = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds4);
        this.bcG = r.d.cp_link_tip_a;
        this.ftT = new a(this);
        initPaint();
        aXA();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.ftL = 0;
        this.ftM = 8;
        this.eMH = false;
        this.ftN = true;
        this.ftR = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ftS = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds4);
        this.bcG = r.d.cp_link_tip_a;
        this.ftT = new a(this);
        initPaint();
        aXA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXA() {
        if (this.eMH) {
            invalidate();
        }
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ftT);
        if (!this.ftN) {
            com.baidu.adp.lib.h.h.eG().postDelayed(this.ftT, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.ftL > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.ftO = this.ftS * ((this.ftL * 2) - 1);
            this.ftM = this.ftL;
            i = View.MeasureSpec.makeMeasureSpec(this.ftO, mode);
        }
        super.onMeasure(i, i2);
        this.ftP = getMeasuredHeight();
        this.ftO = getMeasuredWidth();
        if (this.ftL <= 0) {
            this.ftM = (this.ftO / this.ftS) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eMH) {
            for (int i = 0; i < this.ftM; i++) {
                bkf();
                if (i < this.ftQ.length) {
                    canvas.drawRect(this.ftQ[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ar.getColor(this.bcG));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(ar.getColor(this.bcG));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bkf() {
        int nextInt;
        if (this.ftQ == null || this.ftQ.length != this.ftM) {
            this.ftQ = new Rect[this.ftM];
        }
        for (int i = 0; i < this.ftM; i++) {
            int i2 = this.ftS * i * 2;
            if (this.ftN) {
                nextInt = (int) ((1.0d - (this.ftR[i % 22] / 10.0d)) * this.ftP);
            } else {
                nextInt = this.ftP > 0 ? this.random.nextInt(this.ftP) : 0;
            }
            int i3 = this.ftS + i2;
            int i4 = this.ftP;
            if (this.ftQ[i] == null) {
                this.ftQ[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.ftQ[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.ftS = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ar.getColor(i));
        }
        this.bcG = i;
    }

    public void start() {
        this.eMH = true;
        this.ftN = false;
        aXA();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.ftL = i;
        }
    }

    public void bkg() {
        this.eMH = true;
        this.ftN = true;
        aXA();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ftT);
    }
}
