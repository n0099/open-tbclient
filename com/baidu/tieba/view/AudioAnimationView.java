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
    private int bGn;
    private boolean fBS;
    private int gtU;
    private int gtV;
    private boolean gtW;
    private int gtX;
    private int gtY;
    private Rect[] gtZ;
    private int[] gua;
    private int gub;
    private final Runnable guc;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.gtU = 0;
        this.gtV = 8;
        this.fBS = false;
        this.gtW = true;
        this.gua = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gub = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bGn = d.e.cp_link_tip_a;
        this.guc = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bgH();
            }
        };
        initPaint();
        bgH();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.gtU = 0;
        this.gtV = 8;
        this.fBS = false;
        this.gtW = true;
        this.gua = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gub = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bGn = d.e.cp_link_tip_a;
        this.guc = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bgH();
            }
        };
        initPaint();
        bgH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgH() {
        if (this.fBS) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.guc);
        if (!this.gtW) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.guc, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.gtU > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.gtX = this.gub * ((this.gtU * 2) - 1);
            this.gtV = this.gtU;
            i = View.MeasureSpec.makeMeasureSpec(this.gtX, mode);
        }
        super.onMeasure(i, i2);
        this.gtY = getMeasuredHeight();
        this.gtX = getMeasuredWidth();
        if (this.gtU <= 0) {
            this.gtV = (this.gtX / this.gub) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fBS) {
            for (int i = 0; i < this.gtV; i++) {
                bwu();
                if (i < this.gtZ.length) {
                    canvas.drawRect(this.gtZ[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ai.getColor(this.bGn));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(ai.getColor(this.bGn));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bwu() {
        int nextInt;
        if (this.gtZ == null || this.gtZ.length != this.gtV) {
            this.gtZ = new Rect[this.gtV];
        }
        for (int i = 0; i < this.gtV; i++) {
            int i2 = this.gub * i * 2;
            if (this.gtW) {
                nextInt = (int) ((1.0d - (this.gua[i % 22] / 10.0d)) * this.gtY);
            } else {
                nextInt = this.gtY > 0 ? this.random.nextInt(this.gtY) : 0;
            }
            int i3 = this.gub + i2;
            int i4 = this.gtY;
            if (this.gtZ[i] == null) {
                this.gtZ[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.gtZ[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.gub = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ai.getColor(i));
        }
        this.bGn = i;
    }

    public void start() {
        this.fBS = true;
        this.gtW = false;
        bgH();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.gtU = i;
        }
    }

    public void bwv() {
        this.fBS = true;
        this.gtW = true;
        bgH();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.guc);
    }
}
