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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.Random;
/* loaded from: classes.dex */
public class AudioAnimationView extends View {
    private int Zo;
    private int Zp;
    private boolean Zq;
    private boolean Zr;
    private RectF[] Zs;
    private int[] Zt;
    private int Zu;
    private int Zv;
    private final Runnable Zw;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Zo = 0;
        this.Zp = 8;
        this.Zq = false;
        this.Zr = true;
        this.Zt = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Zu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.Zv = R.color.cp_cont_a;
        this.Zw = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qr();
            }
        };
        qs();
        qr();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Zo = 0;
        this.Zp = 8;
        this.Zq = false;
        this.Zr = true;
        this.Zt = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Zu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.Zv = R.color.cp_cont_a;
        this.Zw = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qr();
            }
        };
        qs();
        qr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr() {
        if (this.Zq) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.Zw);
        if (!this.Zr) {
            com.baidu.adp.lib.f.e.lb().postDelayed(this.Zw, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Zo > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.Zu * ((this.Zo * 2) - 1);
            this.Zp = this.Zo;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.Zo <= 0) {
            this.Zp = (this.mCanvasWidth / this.Zu) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Zq) {
            for (int i = 0; i < this.Zp; i++) {
                qt();
                if (i < this.Zs.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.Zs[i].top / 2.0f));
                    canvas.drawRoundRect(this.Zs[i], 10.0f, 10.0f, this.mPaint);
                    canvas.restore();
                }
            }
        }
    }

    private void qs() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(am.getColor(this.Zv));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(am.getColor(this.Zv));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void qt() {
        int nextInt;
        if (this.Zs == null || this.Zs.length != this.Zp) {
            this.Zs = new RectF[this.Zp];
        }
        for (int i = 0; i < this.Zp; i++) {
            int i2 = this.Zu * i * 2;
            if (this.Zr) {
                nextInt = (int) ((1.0d - (this.Zt[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.Zu + i2;
            int i4 = this.mCanvasHeight;
            if (this.Zs[i] == null) {
                this.Zs[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.Zs[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Zu = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(am.getColor(i));
        }
        this.Zv = i;
    }

    public void start() {
        this.Zq = true;
        this.Zr = false;
        qr();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Zo = i;
        }
    }

    public void qu() {
        this.Zq = true;
        this.Zr = true;
        qr();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.Zw);
    }
}
