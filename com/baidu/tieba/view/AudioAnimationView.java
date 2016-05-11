package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.h.h;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private boolean dWi;
    private int eVN;
    private int eVO;
    private boolean eVP;
    private int eVQ;
    private int eVR;
    private Rect[] eVS;
    private int[] eVT;
    private int eVU;
    private int eVV;
    private final Runnable eVW;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.eVN = 0;
        this.eVO = 8;
        this.dWi = false;
        this.eVP = true;
        this.eVT = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.eVU = k.c(TbadkCoreApplication.m11getInst(), t.e.ds4);
        this.eVV = t.d.cp_link_tip_a;
        this.eVW = new a(this);
        initPaint();
        aLb();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.eVN = 0;
        this.eVO = 8;
        this.dWi = false;
        this.eVP = true;
        this.eVT = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.eVU = k.c(TbadkCoreApplication.m11getInst(), t.e.ds4);
        this.eVV = t.d.cp_link_tip_a;
        this.eVW = new a(this);
        initPaint();
        aLb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLb() {
        if (this.dWi) {
            invalidate();
        }
        h.dL().removeCallbacks(this.eVW);
        if (!this.eVP) {
            h.dL().postDelayed(this.eVW, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.eVN > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.eVQ = this.eVU * ((this.eVN * 2) - 1);
            this.eVO = this.eVN;
            i = View.MeasureSpec.makeMeasureSpec(this.eVQ, mode);
        }
        super.onMeasure(i, i2);
        this.eVR = getMeasuredHeight();
        this.eVQ = getMeasuredWidth();
        if (this.eVN <= 0) {
            this.eVO = (this.eVQ / this.eVU) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.dWi) {
            for (int i = 0; i < this.eVO; i++) {
                baR();
                if (i < this.eVS.length) {
                    canvas.drawRect(this.eVS[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(at.getColor(this.eVV));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(at.getColor(this.eVV));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void baR() {
        int nextInt;
        if (this.eVS == null || this.eVS.length != this.eVO) {
            this.eVS = new Rect[this.eVO];
        }
        for (int i = 0; i < this.eVO; i++) {
            int i2 = this.eVU * i * 2;
            if (this.eVP) {
                nextInt = (int) ((1.0d - (this.eVT[i % 22] / 10.0d)) * this.eVR);
            } else {
                nextInt = this.eVR > 0 ? this.random.nextInt(this.eVR) : 0;
            }
            int i3 = this.eVU + i2;
            int i4 = this.eVR;
            if (this.eVS[i] == null) {
                this.eVS[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.eVS[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.eVU = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(at.getColor(i));
        }
        this.eVV = i;
    }

    public void start() {
        this.dWi = true;
        this.eVP = false;
        aLb();
    }

    public void setCertainColumnCount(int i) {
        this.eVN = i;
    }

    public void baS() {
        this.dWi = true;
        this.eVP = true;
        aLb();
    }
}
