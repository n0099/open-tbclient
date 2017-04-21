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
    private int bvA;
    private int fLn;
    private int fLo;
    private boolean fLp;
    private int fLq;
    private int fLr;
    private Rect[] fLs;
    private int[] fLt;
    private int fLu;
    private final Runnable fLv;
    private boolean fag;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.fLn = 0;
        this.fLo = 8;
        this.fag = false;
        this.fLp = true;
        this.fLt = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fLu = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds4);
        this.bvA = w.e.cp_link_tip_a;
        this.fLv = new a(this);
        initPaint();
        bad();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.fLn = 0;
        this.fLo = 8;
        this.fag = false;
        this.fLp = true;
        this.fLt = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fLu = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds4);
        this.bvA = w.e.cp_link_tip_a;
        this.fLv = new a(this);
        initPaint();
        bad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bad() {
        if (this.fag) {
            invalidate();
        }
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fLv);
        if (!this.fLp) {
            com.baidu.adp.lib.g.h.fS().postDelayed(this.fLv, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.fLn > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.fLq = this.fLu * ((this.fLn * 2) - 1);
            this.fLo = this.fLn;
            i = View.MeasureSpec.makeMeasureSpec(this.fLq, mode);
        }
        super.onMeasure(i, i2);
        this.fLr = getMeasuredHeight();
        this.fLq = getMeasuredWidth();
        if (this.fLn <= 0) {
            this.fLo = (this.fLq / this.fLu) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fag) {
            for (int i = 0; i < this.fLo; i++) {
                bnk();
                if (i < this.fLs.length) {
                    canvas.drawRect(this.fLs[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aq.getColor(this.bvA));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aq.getColor(this.bvA));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bnk() {
        int nextInt;
        if (this.fLs == null || this.fLs.length != this.fLo) {
            this.fLs = new Rect[this.fLo];
        }
        for (int i = 0; i < this.fLo; i++) {
            int i2 = this.fLu * i * 2;
            if (this.fLp) {
                nextInt = (int) ((1.0d - (this.fLt[i % 22] / 10.0d)) * this.fLr);
            } else {
                nextInt = this.fLr > 0 ? this.random.nextInt(this.fLr) : 0;
            }
            int i3 = this.fLu + i2;
            int i4 = this.fLr;
            if (this.fLs[i] == null) {
                this.fLs[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.fLs[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.fLu = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aq.getColor(i));
        }
        this.bvA = i;
    }

    public void start() {
        this.fag = true;
        this.fLp = false;
        bad();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.fLn = i;
        }
    }

    public void bnl() {
        this.fag = true;
        this.fLp = true;
        bad();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fLv);
    }
}
