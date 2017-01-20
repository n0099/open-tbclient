package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int bmv;
    private boolean eWe;
    private int fCH;
    private int fCI;
    private boolean fCJ;
    private int fCK;
    private int fCL;
    private Rect[] fCM;
    private int[] fCN;
    private int fCO;
    private final Runnable fCP;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.fCH = 0;
        this.fCI = 8;
        this.eWe = false;
        this.fCJ = true;
        this.fCN = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fCO = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.f.ds4);
        this.bmv = r.e.cp_link_tip_a;
        this.fCP = new a(this);
        initPaint();
        aZo();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.fCH = 0;
        this.fCI = 8;
        this.eWe = false;
        this.fCJ = true;
        this.fCN = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fCO = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.f.ds4);
        this.bmv = r.e.cp_link_tip_a;
        this.fCP = new a(this);
        initPaint();
        aZo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZo() {
        if (this.eWe) {
            invalidate();
        }
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.fCP);
        if (!this.fCJ) {
            com.baidu.adp.lib.g.h.eE().postDelayed(this.fCP, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.fCH > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.fCK = this.fCO * ((this.fCH * 2) - 1);
            this.fCI = this.fCH;
            i = View.MeasureSpec.makeMeasureSpec(this.fCK, mode);
        }
        super.onMeasure(i, i2);
        this.fCL = getMeasuredHeight();
        this.fCK = getMeasuredWidth();
        if (this.fCH <= 0) {
            this.fCI = (this.fCK / this.fCO) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eWe) {
            for (int i = 0; i < this.fCI; i++) {
                blK();
                if (i < this.fCM.length) {
                    canvas.drawRect(this.fCM[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ap.getColor(this.bmv));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(ap.getColor(this.bmv));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void blK() {
        int nextInt;
        if (this.fCM == null || this.fCM.length != this.fCI) {
            this.fCM = new Rect[this.fCI];
        }
        for (int i = 0; i < this.fCI; i++) {
            int i2 = this.fCO * i * 2;
            if (this.fCJ) {
                nextInt = (int) ((1.0d - (this.fCN[i % 22] / 10.0d)) * this.fCL);
            } else {
                nextInt = this.fCL > 0 ? this.random.nextInt(this.fCL) : 0;
            }
            int i3 = this.fCO + i2;
            int i4 = this.fCL;
            if (this.fCM[i] == null) {
                this.fCM[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.fCM[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.fCO = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ap.getColor(i));
        }
        this.bmv = i;
    }

    public void start() {
        this.eWe = true;
        this.fCJ = false;
        aZo();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.fCH = i;
        }
    }

    public void blL() {
        this.eWe = true;
        this.fCJ = true;
        aZo();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.fCP);
    }
}
