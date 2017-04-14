package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int bth;
    private boolean eXP;
    private int fIR;
    private int fIS;
    private boolean fIT;
    private int fIU;
    private int fIV;
    private Rect[] fIW;
    private int[] fIX;
    private int fIY;
    private final Runnable fIZ;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.fIR = 0;
        this.fIS = 8;
        this.eXP = false;
        this.fIT = true;
        this.fIX = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fIY = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds4);
        this.bth = w.e.cp_link_tip_a;
        this.fIZ = new a(this);
        initPaint();
        aZc();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.fIR = 0;
        this.fIS = 8;
        this.eXP = false;
        this.fIT = true;
        this.fIX = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fIY = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds4);
        this.bth = w.e.cp_link_tip_a;
        this.fIZ = new a(this);
        initPaint();
        aZc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZc() {
        if (this.eXP) {
            invalidate();
        }
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.fIZ);
        if (!this.fIT) {
            com.baidu.adp.lib.g.h.fR().postDelayed(this.fIZ, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.fIR > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.fIU = this.fIY * ((this.fIR * 2) - 1);
            this.fIS = this.fIR;
            i = View.MeasureSpec.makeMeasureSpec(this.fIU, mode);
        }
        super.onMeasure(i, i2);
        this.fIV = getMeasuredHeight();
        this.fIU = getMeasuredWidth();
        if (this.fIR <= 0) {
            this.fIS = (this.fIU / this.fIY) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eXP) {
            for (int i = 0; i < this.fIS; i++) {
                bmj();
                if (i < this.fIW.length) {
                    canvas.drawRect(this.fIW[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aq.getColor(this.bth));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aq.getColor(this.bth));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bmj() {
        int nextInt;
        if (this.fIW == null || this.fIW.length != this.fIS) {
            this.fIW = new Rect[this.fIS];
        }
        for (int i = 0; i < this.fIS; i++) {
            int i2 = this.fIY * i * 2;
            if (this.fIT) {
                nextInt = (int) ((1.0d - (this.fIX[i % 22] / 10.0d)) * this.fIV);
            } else {
                nextInt = this.fIV > 0 ? this.random.nextInt(this.fIV) : 0;
            }
            int i3 = this.fIY + i2;
            int i4 = this.fIV;
            if (this.fIW[i] == null) {
                this.fIW[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.fIW[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.fIY = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aq.getColor(i));
        }
        this.bth = i;
    }

    public void start() {
        this.eXP = true;
        this.fIT = false;
        aZc();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.fIR = i;
        }
    }

    public void bmk() {
        this.eXP = true;
        this.fIT = true;
        aZc();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.fIZ);
    }
}
