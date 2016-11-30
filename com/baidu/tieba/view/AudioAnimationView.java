package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int bdo;
    private boolean fjr;
    private int geR;
    private int geS;
    private boolean geT;
    private int geU;
    private int geV;
    private Rect[] geW;
    private int[] geX;
    private int geY;
    private final Runnable geZ;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.geR = 0;
        this.geS = 8;
        this.fjr = false;
        this.geT = true;
        this.geX = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.geY = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds4);
        this.bdo = r.d.cp_link_tip_a;
        this.geZ = new a(this);
        initPaint();
        bdT();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.geR = 0;
        this.geS = 8;
        this.fjr = false;
        this.geT = true;
        this.geX = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.geY = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds4);
        this.bdo = r.d.cp_link_tip_a;
        this.geZ = new a(this);
        initPaint();
        bdT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdT() {
        if (this.fjr) {
            invalidate();
        }
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.geZ);
        if (!this.geT) {
            com.baidu.adp.lib.h.h.eG().postDelayed(this.geZ, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.geR > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.geU = this.geY * ((this.geR * 2) - 1);
            this.geS = this.geR;
            i = View.MeasureSpec.makeMeasureSpec(this.geU, mode);
        }
        super.onMeasure(i, i2);
        this.geV = getMeasuredHeight();
        this.geU = getMeasuredWidth();
        if (this.geR <= 0) {
            this.geS = (this.geU / this.geY) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fjr) {
            for (int i = 0; i < this.geS; i++) {
                btf();
                if (i < this.geW.length) {
                    canvas.drawRect(this.geW[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(at.getColor(this.bdo));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(at.getColor(this.bdo));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void btf() {
        int nextInt;
        if (this.geW == null || this.geW.length != this.geS) {
            this.geW = new Rect[this.geS];
        }
        for (int i = 0; i < this.geS; i++) {
            int i2 = this.geY * i * 2;
            if (this.geT) {
                nextInt = (int) ((1.0d - (this.geX[i % 22] / 10.0d)) * this.geV);
            } else {
                nextInt = this.geV > 0 ? this.random.nextInt(this.geV) : 0;
            }
            int i3 = this.geY + i2;
            int i4 = this.geV;
            if (this.geW[i] == null) {
                this.geW[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.geW[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.geY = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(at.getColor(i));
        }
        this.bdo = i;
    }

    public void start() {
        this.fjr = true;
        this.geT = false;
        bdT();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.geR = i;
        }
    }

    public void btg() {
        this.fjr = true;
        this.geT = true;
        bdT();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.geZ);
    }
}
