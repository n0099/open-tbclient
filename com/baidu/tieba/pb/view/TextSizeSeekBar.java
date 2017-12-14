package com.baidu.tieba.pb.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private int amE;
    private Drawable dAa;
    private int ds12;
    private int ds3;
    private int ds48;
    private int fmn;
    private int fmo;
    private int fmp;
    private int fmq;
    private int fmr;
    private int fms;
    private String[] fmt;
    private int fmu;
    private int fmv;
    private ArrayList<Rect> fmw;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fmw = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fmw = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fmw = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    private void init(Context context) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds54);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.dAa = aj.getDrawable(d.f.wordsize);
        this.fmq = dimensionPixelSize;
        this.fmr = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.fmt = new String[]{context.getString(d.j.font_size_small), context.getString(d.j.font_size_mid), context.getString(d.j.font_size_big), context.getString(d.j.font_size_xlarge)};
        this.fmu = aj.getColor(d.C0096d.cp_cont_f);
        this.fmv = aj.getColor(d.C0096d.cp_cont_d);
        this.amE = aj.getColor(d.C0096d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.dAa = aj.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fmn == 0 || this.fmo == 0) {
            this.fmn = View.MeasureSpec.getSize(i);
            this.fmo = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.fmp = (this.fmn - this.fmq) / 3;
            this.fms = this.fmo / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fmw.add(new Rect(this.fmp * i3, this.fms - (this.fmr / 2), (this.fmp * i3) + this.fmq, this.fms + (this.fmr / 2)));
            }
        }
        setMeasuredDimension(this.fmn, this.fmo);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            default:
                return true;
            case 1:
            case 2:
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 <= 3) {
                        if (!this.fmw.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.pN(Math.abs(this.index - 3));
                            invalidate();
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawText(canvas);
        w(canvas);
        x(canvas);
    }

    private void drawText(Canvas canvas) {
        for (int i = 0; i < this.fmt.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.fmu);
            } else {
                this.paint.setColor(this.fmv);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fmt[i], (this.fmp * i) + (this.fmq / 2), this.fms - this.ds48, this.paint);
        }
    }

    private void w(Canvas canvas) {
        this.paint.setColor(this.amE);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.fmq / 2.0d), this.fms, (float) (this.fmn - (this.fmq / 2.0d)), this.fms, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.fmp * i) + (this.fmq / 2), this.fms, this.paint);
        }
    }

    private void x(Canvas canvas) {
        Rect rect = (Rect) v.c(this.fmw, this.index);
        if (rect != null && this.dAa != null) {
            this.dAa.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.dAa.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dAa != null) {
            this.dAa.setCallback(null);
            this.dAa = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.dAa != null) {
                this.dAa = aj.getDrawable(d.f.wordsize);
            }
            this.fmu = aj.getColor(d.C0096d.cp_cont_f);
            this.fmv = aj.getColor(d.C0096d.cp_cont_d);
            this.amE = aj.getColor(d.C0096d.cp_cont_e);
            invalidate();
        }
    }
}
