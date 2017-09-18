package com.baidu.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int bLS;
    private int gwA;
    private final Runnable gwB;
    private int gws;
    private int gwt;
    private boolean gwu;
    private boolean gwv;
    private int gww;
    private int gwx;
    private Rect[] gwy;
    private int[] gwz;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.gws = 0;
        this.gwt = 8;
        this.gwu = false;
        this.gwv = true;
        this.gwz = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gwA = com.baidu.adp.lib.util.k.f(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bLS = d.e.cp_link_tip_a;
        this.gwB = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bwC();
            }
        };
        initPaint();
        bwC();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.gws = 0;
        this.gwt = 8;
        this.gwu = false;
        this.gwv = true;
        this.gwz = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.gwA = com.baidu.adp.lib.util.k.f(TbadkCoreApplication.getInst(), d.f.ds4);
        this.bLS = d.e.cp_link_tip_a;
        this.gwB = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.bwC();
            }
        };
        initPaint();
        bwC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwC() {
        if (this.gwu) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.gwB);
        if (!this.gwv) {
            com.baidu.adp.lib.g.e.fQ().postDelayed(this.gwB, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.gws > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.gww = this.gwA * ((this.gws * 2) - 1);
            this.gwt = this.gws;
            i = View.MeasureSpec.makeMeasureSpec(this.gww, mode);
        }
        super.onMeasure(i, i2);
        this.gwx = getMeasuredHeight();
        this.gww = getMeasuredWidth();
        if (this.gws <= 0) {
            this.gwt = (this.gww / this.gwA) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.gwu) {
            for (int i = 0; i < this.gwt; i++) {
                bwD();
                if (i < this.gwy.length) {
                    canvas.drawRect(this.gwy[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.bLS));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(this.bLS));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bwD() {
        int nextInt;
        if (this.gwy == null || this.gwy.length != this.gwt) {
            this.gwy = new Rect[this.gwt];
        }
        for (int i = 0; i < this.gwt; i++) {
            int i2 = this.gwA * i * 2;
            if (this.gwv) {
                nextInt = (int) ((1.0d - (this.gwz[i % 22] / 10.0d)) * this.gwx);
            } else {
                nextInt = this.gwx > 0 ? this.random.nextInt(this.gwx) : 0;
            }
            int i3 = this.gwA + i2;
            int i4 = this.gwx;
            if (this.gwy[i] == null) {
                this.gwy[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.gwy[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.gwA = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.bLS = i;
    }

    public void start() {
        this.gwu = true;
        this.gwv = false;
        bwC();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.gws = i;
        }
    }

    public void bwE() {
        this.gwu = true;
        this.gwv = true;
        bwC();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.gwB);
    }
}
