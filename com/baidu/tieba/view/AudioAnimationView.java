package com.baidu.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int bIg;
    private boolean fEX;
    private int gwX;
    private int gwY;
    private boolean gwZ;
    private int gxa;
    private int gxb;
    private Rect[] gxc;
    private int[] gxd;
    private int gxe;
    private final Runnable gxf;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.gwX = 0;
        this.gwY = 8;
        this.fEX = false;
        this.gwZ = true;
        this.gxd = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gxe = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bIg = d.e.cp_link_tip_a;
        this.gxf = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bhx();
            }
        };
        initPaint();
        bhx();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.gwX = 0;
        this.gwY = 8;
        this.fEX = false;
        this.gwZ = true;
        this.gxd = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gxe = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bIg = d.e.cp_link_tip_a;
        this.gxf = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bhx();
            }
        };
        initPaint();
        bhx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhx() {
        if (this.fEX) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.gxf);
        if (!this.gwZ) {
            com.baidu.adp.lib.g.e.ga().postDelayed(this.gxf, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.gwX > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.gxa = this.gxe * ((this.gwX * 2) - 1);
            this.gwY = this.gwX;
            i = View.MeasureSpec.makeMeasureSpec(this.gxa, mode);
        }
        super.onMeasure(i, i2);
        this.gxb = getMeasuredHeight();
        this.gxa = getMeasuredWidth();
        if (this.gwX <= 0) {
            this.gwY = (this.gxa / this.gxe) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fEX) {
            for (int i = 0; i < this.gwY; i++) {
                bxj();
                if (i < this.gxc.length) {
                    canvas.drawRect(this.gxc[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ai.getColor(this.bIg));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(ai.getColor(this.bIg));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bxj() {
        int nextInt;
        if (this.gxc == null || this.gxc.length != this.gwY) {
            this.gxc = new Rect[this.gwY];
        }
        for (int i = 0; i < this.gwY; i++) {
            int i2 = this.gxe * i * 2;
            if (this.gwZ) {
                nextInt = (int) ((1.0d - (this.gxd[i % 22] / 10.0d)) * this.gxb);
            } else {
                nextInt = this.gxb > 0 ? this.random.nextInt(this.gxb) : 0;
            }
            int i3 = this.gxe + i2;
            int i4 = this.gxb;
            if (this.gxc[i] == null) {
                this.gxc[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.gxc[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.gxe = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ai.getColor(i));
        }
        this.bIg = i;
    }

    public void start() {
        this.fEX = true;
        this.gwZ = false;
        bhx();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.gwX = i;
        }
    }

    public void bxk() {
        this.fEX = true;
        this.gwZ = true;
        bhx();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.gxf);
    }
}
