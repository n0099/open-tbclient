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
    private int btq;
    private boolean eZR;
    private int fHi;
    private int fHj;
    private boolean fHk;
    private int fHl;
    private int fHm;
    private Rect[] fHn;
    private int[] fHo;
    private int fHp;
    private final Runnable fHq;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.fHi = 0;
        this.fHj = 8;
        this.eZR = false;
        this.fHk = true;
        this.fHo = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fHp = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds4);
        this.btq = w.e.cp_link_tip_a;
        this.fHq = new a(this);
        initPaint();
        aYT();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.fHi = 0;
        this.fHj = 8;
        this.eZR = false;
        this.fHk = true;
        this.fHo = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fHp = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds4);
        this.btq = w.e.cp_link_tip_a;
        this.fHq = new a(this);
        initPaint();
        aYT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYT() {
        if (this.eZR) {
            invalidate();
        }
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.fHq);
        if (!this.fHk) {
            com.baidu.adp.lib.g.h.fM().postDelayed(this.fHq, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.fHi > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.fHl = this.fHp * ((this.fHi * 2) - 1);
            this.fHj = this.fHi;
            i = View.MeasureSpec.makeMeasureSpec(this.fHl, mode);
        }
        super.onMeasure(i, i2);
        this.fHm = getMeasuredHeight();
        this.fHl = getMeasuredWidth();
        if (this.fHi <= 0) {
            this.fHj = (this.fHl / this.fHp) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eZR) {
            for (int i = 0; i < this.fHj; i++) {
                blz();
                if (i < this.fHn.length) {
                    canvas.drawRect(this.fHn[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aq.getColor(this.btq));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aq.getColor(this.btq));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void blz() {
        int nextInt;
        if (this.fHn == null || this.fHn.length != this.fHj) {
            this.fHn = new Rect[this.fHj];
        }
        for (int i = 0; i < this.fHj; i++) {
            int i2 = this.fHp * i * 2;
            if (this.fHk) {
                nextInt = (int) ((1.0d - (this.fHo[i % 22] / 10.0d)) * this.fHm);
            } else {
                nextInt = this.fHm > 0 ? this.random.nextInt(this.fHm) : 0;
            }
            int i3 = this.fHp + i2;
            int i4 = this.fHm;
            if (this.fHn[i] == null) {
                this.fHn[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.fHn[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.fHp = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aq.getColor(i));
        }
        this.btq = i;
    }

    public void start() {
        this.eZR = true;
        this.fHk = false;
        aYT();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.fHi = i;
        }
    }

    public void blA() {
        this.eZR = true;
        this.fHk = true;
        aYT();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.fHq);
    }
}
