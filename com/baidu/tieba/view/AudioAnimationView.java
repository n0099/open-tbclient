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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int aUE;
    private boolean eSF;
    private boolean fNA;
    private int fNB;
    private int fNC;
    private Rect[] fND;
    private int[] fNE;
    private int fNF;
    private final Runnable fNG;
    private int fNy;
    private int fNz;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.fNy = 0;
        this.fNz = 8;
        this.eSF = false;
        this.fNA = true;
        this.fNE = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fNF = k.c(TbadkCoreApplication.m10getInst(), u.e.ds4);
        this.aUE = u.d.cp_link_tip_a;
        this.fNG = new a(this);
        initPaint();
        aXx();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.fNy = 0;
        this.fNz = 8;
        this.eSF = false;
        this.fNA = true;
        this.fNE = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fNF = k.c(TbadkCoreApplication.m10getInst(), u.e.ds4);
        this.aUE = u.d.cp_link_tip_a;
        this.fNG = new a(this);
        initPaint();
        aXx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXx() {
        if (this.eSF) {
            invalidate();
        }
        h.dL().removeCallbacks(this.fNG);
        if (!this.fNA) {
            h.dL().postDelayed(this.fNG, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.fNy > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.fNB = this.fNF * ((this.fNy * 2) - 1);
            this.fNz = this.fNy;
            i = View.MeasureSpec.makeMeasureSpec(this.fNB, mode);
        }
        super.onMeasure(i, i2);
        this.fNC = getMeasuredHeight();
        this.fNB = getMeasuredWidth();
        if (this.fNy <= 0) {
            this.fNz = (this.fNB / this.fNF) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eSF) {
            for (int i = 0; i < this.fNz; i++) {
                bmy();
                if (i < this.fND.length) {
                    canvas.drawRect(this.fND[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(av.getColor(this.aUE));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(av.getColor(this.aUE));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bmy() {
        int nextInt;
        if (this.fND == null || this.fND.length != this.fNz) {
            this.fND = new Rect[this.fNz];
        }
        for (int i = 0; i < this.fNz; i++) {
            int i2 = this.fNF * i * 2;
            if (this.fNA) {
                nextInt = (int) ((1.0d - (this.fNE[i % 22] / 10.0d)) * this.fNC);
            } else {
                nextInt = this.fNC > 0 ? this.random.nextInt(this.fNC) : 0;
            }
            int i3 = this.fNF + i2;
            int i4 = this.fNC;
            if (this.fND[i] == null) {
                this.fND[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.fND[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.fNF = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(av.getColor(i));
        }
        this.aUE = i;
    }

    public void start() {
        this.eSF = true;
        this.fNA = false;
        aXx();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.fNy = i;
        }
    }

    public void bmz() {
        this.eSF = true;
        this.fNA = true;
        aXx();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.dL().removeCallbacks(this.fNG);
    }
}
