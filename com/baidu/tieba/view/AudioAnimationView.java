package com.baidu.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int TR;
    private int TS;
    private boolean TT;
    private boolean TU;
    private int TV;
    private int TW;
    private RectF[] TX;
    private int[] TY;
    private int TZ;
    private int Ua;
    private final Runnable Ub;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.TR = 0;
        this.TS = 8;
        this.TT = false;
        this.TU = true;
        this.TY = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.TZ = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.Ua = R.color.cp_btn_a;
        this.Ub = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.pS();
            }
        };
        pT();
        pS();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.TR = 0;
        this.TS = 8;
        this.TT = false;
        this.TU = true;
        this.TY = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.TZ = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.Ua = R.color.cp_btn_a;
        this.Ub = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.pS();
            }
        };
        pT();
        pS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS() {
        if (this.TT) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.Ub);
        if (!this.TU) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.Ub, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.TR > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.TV = this.TZ * ((this.TR * 2) - 1);
            this.TS = this.TR;
            i = View.MeasureSpec.makeMeasureSpec(this.TV, mode);
        }
        super.onMeasure(i, i2);
        this.TW = getMeasuredHeight();
        this.TV = getMeasuredWidth();
        if (this.TR <= 0) {
            this.TS = (this.TV / this.TZ) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.TT) {
            for (int i = 0; i < this.TS; i++) {
                pU();
                if (i < this.TX.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.TX[i].top / 2.0f));
                    canvas.drawRoundRect(this.TX[i], 10.0f, 10.0f, this.mPaint);
                    canvas.restore();
                }
            }
        }
    }

    private void pT() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(al.getColor(this.Ua));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(al.getColor(this.Ua));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void pU() {
        int nextInt;
        if (this.TX == null || this.TX.length != this.TS) {
            this.TX = new RectF[this.TS];
        }
        for (int i = 0; i < this.TS; i++) {
            int i2 = this.TZ * i * 2;
            if (this.TU) {
                nextInt = (int) ((1.0d - (this.TY[i % 22] / 10.0d)) * this.TW);
            } else {
                nextInt = this.TW > 0 ? this.random.nextInt(this.TW) : 0;
            }
            int i3 = this.TZ + i2;
            int i4 = this.TW;
            if (this.TX[i] == null) {
                this.TX[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.TX[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.TZ = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(al.getColor(i));
        }
        this.Ua = i;
    }

    public void start() {
        this.TT = true;
        this.TU = false;
        pS();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.TR = i;
        }
    }

    public void pV() {
        this.TT = true;
        this.TU = true;
        pS();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.Ub);
    }
}
