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
    private int bBn;
    private int fPJ;
    private int fPK;
    private boolean fPL;
    private int fPM;
    private int fPN;
    private Rect[] fPO;
    private int[] fPP;
    private int fPQ;
    private final Runnable fPR;
    private boolean feO;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.fPJ = 0;
        this.fPK = 8;
        this.feO = false;
        this.fPL = true;
        this.fPP = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fPQ = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds4);
        this.bBn = w.e.cp_link_tip_a;
        this.fPR = new a(this);
        initPaint();
        aYW();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.fPJ = 0;
        this.fPK = 8;
        this.feO = false;
        this.fPL = true;
        this.fPP = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.fPQ = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds4);
        this.bBn = w.e.cp_link_tip_a;
        this.fPR = new a(this);
        initPaint();
        aYW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYW() {
        if (this.feO) {
            invalidate();
        }
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fPR);
        if (!this.fPL) {
            com.baidu.adp.lib.g.h.fS().postDelayed(this.fPR, 250L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.fPJ > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.fPM = this.fPQ * ((this.fPJ * 2) - 1);
            this.fPK = this.fPJ;
            i = View.MeasureSpec.makeMeasureSpec(this.fPM, mode);
        }
        super.onMeasure(i, i2);
        this.fPN = getMeasuredHeight();
        this.fPM = getMeasuredWidth();
        if (this.fPJ <= 0) {
            this.fPK = (this.fPM / this.fPQ) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.feO) {
            for (int i = 0; i < this.fPK; i++) {
                bmo();
                if (i < this.fPO.length) {
                    canvas.drawRect(this.fPO[i], this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aq.getColor(this.bBn));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(aq.getColor(this.bBn));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void bmo() {
        int nextInt;
        if (this.fPO == null || this.fPO.length != this.fPK) {
            this.fPO = new Rect[this.fPK];
        }
        for (int i = 0; i < this.fPK; i++) {
            int i2 = this.fPQ * i * 2;
            if (this.fPL) {
                nextInt = (int) ((1.0d - (this.fPP[i % 22] / 10.0d)) * this.fPN);
            } else {
                nextInt = this.fPN > 0 ? this.random.nextInt(this.fPN) : 0;
            }
            int i3 = this.fPQ + i2;
            int i4 = this.fPN;
            if (this.fPO[i] == null) {
                this.fPO[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.fPO[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.fPQ = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aq.getColor(i));
        }
        this.bBn = i;
    }

    public void start() {
        this.feO = true;
        this.fPL = false;
        aYW();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.fPJ = i;
        }
    }

    public void bmp() {
        this.feO = true;
        this.fPL = true;
        aYW();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fPR);
    }
}
