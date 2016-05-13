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
    private int eVM;
    private int eVN;
    private boolean eVO;
    private int eVP;
    private int eVQ;
    private Rect[] eVR;
    private int[] eVS;
    private int eVT;
    private int eVU;
    private final Runnable eVV;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.eVM = 0;
        this.eVN = 8;
        this.dWi = false;
        this.eVO = true;
        this.eVS = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.eVT = k.c(TbadkCoreApplication.m11getInst(), t.e.ds4);
        this.eVU = t.d.cp_link_tip_a;
        this.eVV = new a(this);
        initPaint();
        aLe();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.eVM = 0;
        this.eVN = 8;
        this.dWi = false;
        this.eVO = true;
        this.eVS = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.eVT = k.c(TbadkCoreApplication.m11getInst(), t.e.ds4);
        this.eVU = t.d.cp_link_tip_a;
        this.eVV = new a(this);
        initPaint();
        aLe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLe() {
        if (this.dWi) {
            invalidate();
        }
        h.dL().removeCallbacks(this.eVV);
        if (!this.eVO) {
            h.dL().postDelayed(this.eVV, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.eVM > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.eVP = this.eVT * ((this.eVM * 2) - 1);
            this.eVN = this.eVM;
            i = View.MeasureSpec.makeMeasureSpec(this.eVP, mode);
        }
        super.onMeasure(i, i2);
        this.eVQ = getMeasuredHeight();
        this.eVP = getMeasuredWidth();
        if (this.eVM <= 0) {
            this.eVN = (this.eVP / this.eVT) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.dWi) {
            for (int i = 0; i < this.eVN; i++) {
                baY();
                if (i < this.eVR.length) {
                    canvas.drawRect(this.eVR[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(at.getColor(this.eVU));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(at.getColor(this.eVU));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void baY() {
        int nextInt;
        if (this.eVR == null || this.eVR.length != this.eVN) {
            this.eVR = new Rect[this.eVN];
        }
        for (int i = 0; i < this.eVN; i++) {
            int i2 = this.eVT * i * 2;
            if (this.eVO) {
                nextInt = (int) ((1.0d - (this.eVS[i % 22] / 10.0d)) * this.eVQ);
            } else {
                nextInt = this.eVQ > 0 ? this.random.nextInt(this.eVQ) : 0;
            }
            int i3 = this.eVT + i2;
            int i4 = this.eVQ;
            if (this.eVR[i] == null) {
                this.eVR[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.eVR[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.eVT = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(at.getColor(i));
        }
        this.eVU = i;
    }

    public void start() {
        this.dWi = true;
        this.eVO = false;
        aLe();
    }

    public void setCertainColumnCount(int i) {
        this.eVM = i;
    }

    public void baZ() {
        this.dWi = true;
        this.eVO = true;
        aLe();
    }
}
