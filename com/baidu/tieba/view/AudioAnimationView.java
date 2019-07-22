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
    private int Uj;
    private int Uk;
    private boolean Ul;
    private boolean Um;
    private int Un;
    private int Uo;
    private RectF[] Up;
    private int[] Uq;
    private int Ur;
    private int Us;
    private final Runnable Ut;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Uj = 0;
        this.Uk = 8;
        this.Ul = false;
        this.Um = true;
        this.Uq = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Ur = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.Us = R.color.cp_btn_a;
        this.Ut = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qo();
            }
        };
        qp();
        qo();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Uj = 0;
        this.Uk = 8;
        this.Ul = false;
        this.Um = true;
        this.Uq = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Ur = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.Us = R.color.cp_btn_a;
        this.Ut = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qo();
            }
        };
        qp();
        qo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qo() {
        if (this.Ul) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.Ut);
        if (!this.Um) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.Ut, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Uj > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Un = this.Ur * ((this.Uj * 2) - 1);
            this.Uk = this.Uj;
            i = View.MeasureSpec.makeMeasureSpec(this.Un, mode);
        }
        super.onMeasure(i, i2);
        this.Uo = getMeasuredHeight();
        this.Un = getMeasuredWidth();
        if (this.Uj <= 0) {
            this.Uk = (this.Un / this.Ur) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Ul) {
            for (int i = 0; i < this.Uk; i++) {
                qq();
                if (i < this.Up.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.Up[i].top / 2.0f));
                    canvas.drawRoundRect(this.Up[i], 10.0f, 10.0f, this.mPaint);
                    canvas.restore();
                }
            }
        }
    }

    private void qp() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(am.getColor(this.Us));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(am.getColor(this.Us));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void qq() {
        int nextInt;
        if (this.Up == null || this.Up.length != this.Uk) {
            this.Up = new RectF[this.Uk];
        }
        for (int i = 0; i < this.Uk; i++) {
            int i2 = this.Ur * i * 2;
            if (this.Um) {
                nextInt = (int) ((1.0d - (this.Uq[i % 22] / 10.0d)) * this.Uo);
            } else {
                nextInt = this.Uo > 0 ? this.random.nextInt(this.Uo) : 0;
            }
            int i3 = this.Ur + i2;
            int i4 = this.Uo;
            if (this.Up[i] == null) {
                this.Up[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.Up[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Ur = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(am.getColor(i));
        }
        this.Us = i;
    }

    public void start() {
        this.Ul = true;
        this.Um = false;
        qo();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Uj = i;
        }
    }

    public void qr() {
        this.Ul = true;
        this.Um = true;
        qo();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.Ut);
    }
}
