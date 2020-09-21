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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int abh;
    private int abi;
    private boolean abj;
    private boolean abk;
    private RectF[] abl;
    private int[] abm;
    private int abn;
    private int abo;
    private final Runnable abp;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.abh = 0;
        this.abi = 8;
        this.abj = false;
        this.abk = true;
        this.abm = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.abo = R.color.cp_cont_a;
        this.abp = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.sv();
            }
        };
        sw();
        sv();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.abh = 0;
        this.abi = 8;
        this.abj = false;
        this.abk = true;
        this.abm = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.abo = R.color.cp_cont_a;
        this.abp = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.sv();
            }
        };
        sw();
        sv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sv() {
        if (this.abj) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.abp);
        if (!this.abk) {
            com.baidu.adp.lib.f.e.mX().postDelayed(this.abp, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.abh > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.abn * ((this.abh * 2) - 1);
            this.abi = this.abh;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.abh <= 0) {
            this.abi = (this.mCanvasWidth / this.abn) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.abj) {
            for (int i = 0; i < this.abi; i++) {
                sx();
                if (i < this.abl.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.abl[i].top / 2.0f));
                    canvas.drawRoundRect(this.abl[i], 10.0f, 10.0f, this.mPaint);
                    canvas.restore();
                }
            }
        }
    }

    private void sw() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ap.getColor(this.abo));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(ap.getColor(this.abo));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void sx() {
        int nextInt;
        if (this.abl == null || this.abl.length != this.abi) {
            this.abl = new RectF[this.abi];
        }
        for (int i = 0; i < this.abi; i++) {
            int i2 = this.abn * i * 2;
            if (this.abk) {
                nextInt = (int) ((1.0d - (this.abm[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.abn + i2;
            int i4 = this.mCanvasHeight;
            if (this.abl[i] == null) {
                this.abl[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.abl[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.abn = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ap.getColor(i));
        }
        this.abo = i;
    }

    public void start() {
        this.abj = true;
        this.abk = false;
        sv();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.abh = i;
        }
    }

    public void sy() {
        this.abj = true;
        this.abk = true;
        sv();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.abp);
    }
}
