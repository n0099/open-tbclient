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
    private int Da;
    private int Db;
    private boolean Dc;
    private boolean Dd;
    private int De;
    private int Df;
    private RectF[] Dg;
    private int[] Dh;
    private int Di;
    private int Dj;
    private final Runnable Dk;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Da = 0;
        this.Db = 8;
        this.Dc = false;
        this.Dd = true;
        this.Dh = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Di = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.Dj = R.color.cp_cont_a;
        this.Dk = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.li();
            }
        };
        lj();
        li();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Da = 0;
        this.Db = 8;
        this.Dc = false;
        this.Dd = true;
        this.Dh = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Di = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.Dj = R.color.cp_cont_a;
        this.Dk = new Runnable() { // from class: com.baidu.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.li();
            }
        };
        lj();
        li();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        if (this.Dc) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.Dk);
        if (!this.Dd) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.Dk, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Da > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.De = this.Di * ((this.Da * 2) - 1);
            this.Db = this.Da;
            i = View.MeasureSpec.makeMeasureSpec(this.De, mode);
        }
        super.onMeasure(i, i2);
        this.Df = getMeasuredHeight();
        this.De = getMeasuredWidth();
        if (this.Da <= 0) {
            this.Db = (this.De / this.Di) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Dc) {
            for (int i = 0; i < this.Db; i++) {
                lk();
                if (i < this.Dg.length) {
                    canvas.save();
                    canvas.translate(0.0f, -(this.Dg[i].top / 2.0f));
                    canvas.drawRoundRect(this.Dg[i], 10.0f, 10.0f, this.mPaint);
                    canvas.restore();
                }
            }
        }
    }

    private void lj() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(am.getColor(this.Dj));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.mPaint.setColor(am.getColor(this.Dj));
            invalidate();
            this.mSkinType = i;
        }
    }

    private void lk() {
        int nextInt;
        if (this.Dg == null || this.Dg.length != this.Db) {
            this.Dg = new RectF[this.Db];
        }
        for (int i = 0; i < this.Db; i++) {
            int i2 = this.Di * i * 2;
            if (this.Dd) {
                nextInt = (int) ((1.0d - (this.Dh[i % 22] / 10.0d)) * this.Df);
            } else {
                nextInt = this.Df > 0 ? this.random.nextInt(this.Df) : 0;
            }
            int i3 = this.Di + i2;
            int i4 = this.Df;
            if (this.Dg[i] == null) {
                this.Dg[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.Dg[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Di = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(am.getColor(i));
        }
        this.Dj = i;
    }

    public void start() {
        this.Dc = true;
        this.Dd = false;
        li();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Da = i;
        }
    }

    public void ll() {
        this.Dc = true;
        this.Dd = true;
        li();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.Dk);
    }
}
