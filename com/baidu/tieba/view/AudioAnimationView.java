package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int aZP;
    private boolean eZA;
    private final Runnable fVA;
    private int fVs;
    private int fVt;
    private boolean fVu;
    private int fVv;
    private int fVw;
    private Rect[] fVx;
    private int[] fVy;
    private int fVz;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.fVs = 0;
        this.fVt = 8;
        this.eZA = false;
        this.fVu = true;
        this.fVy = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fVz = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds4);
        this.aZP = t.d.cp_link_tip_a;
        this.fVA = new a(this);
        initPaint();
        baP();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.fVs = 0;
        this.fVt = 8;
        this.eZA = false;
        this.fVu = true;
        this.fVy = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fVz = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds4);
        this.aZP = t.d.cp_link_tip_a;
        this.fVA = new a(this);
        initPaint();
        baP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baP() {
        if (this.eZA) {
            invalidate();
        }
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.fVA);
        if (!this.fVu) {
            com.baidu.adp.lib.h.h.eG().postDelayed(this.fVA, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.fVs > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.fVv = this.fVz * ((this.fVs * 2) - 1);
            this.fVt = this.fVs;
            i = View.MeasureSpec.makeMeasureSpec(this.fVv, mode);
        }
        super.onMeasure(i, i2);
        this.fVw = getMeasuredHeight();
        this.fVv = getMeasuredWidth();
        if (this.fVs <= 0) {
            this.fVt = (this.fVv / this.fVz) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eZA) {
            for (int i = 0; i < this.fVt; i++) {
                bqh();
                if (i < this.fVx.length) {
                    canvas.drawRect(this.fVx[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(av.getColor(this.aZP));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(av.getColor(this.aZP));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bqh() {
        int nextInt;
        if (this.fVx == null || this.fVx.length != this.fVt) {
            this.fVx = new Rect[this.fVt];
        }
        for (int i = 0; i < this.fVt; i++) {
            int i2 = this.fVz * i * 2;
            if (this.fVu) {
                nextInt = (int) ((1.0d - (this.fVy[i % 22] / 10.0d)) * this.fVw);
            } else {
                nextInt = this.fVw > 0 ? this.random.nextInt(this.fVw) : 0;
            }
            int i3 = this.fVz + i2;
            int i4 = this.fVw;
            if (this.fVx[i] == null) {
                this.fVx[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.fVx[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.fVz = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(av.getColor(i));
        }
        this.aZP = i;
    }

    public void start() {
        this.eZA = true;
        this.fVu = false;
        baP();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.fVs = i;
        }
    }

    public void bqi() {
        this.eZA = true;
        this.fVu = true;
        baP();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.fVA);
    }
}
