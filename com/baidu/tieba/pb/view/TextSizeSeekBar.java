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
    private int amH;
    private Drawable dAe;
    private int ds12;
    private int ds3;
    private int ds48;
    private int fmA;
    private ArrayList<Rect> fmB;
    private int fms;
    private int fmt;
    private int fmu;
    private int fmv;
    private int fmw;
    private int fmx;
    private String[] fmy;
    private int fmz;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fmB = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fmB = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fmB = new ArrayList<>(4);
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
        this.dAe = aj.getDrawable(d.f.wordsize);
        this.fmv = dimensionPixelSize;
        this.fmw = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.fmy = new String[]{context.getString(d.j.font_size_small), context.getString(d.j.font_size_mid), context.getString(d.j.font_size_big), context.getString(d.j.font_size_xlarge)};
        this.fmz = aj.getColor(d.C0095d.cp_cont_f);
        this.fmA = aj.getColor(d.C0095d.cp_cont_d);
        this.amH = aj.getColor(d.C0095d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.dAe = aj.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fms == 0 || this.fmt == 0) {
            this.fms = View.MeasureSpec.getSize(i);
            this.fmt = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.fmu = (this.fms - this.fmv) / 3;
            this.fmx = this.fmt / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fmB.add(new Rect(this.fmu * i3, this.fmx - (this.fmw / 2), (this.fmu * i3) + this.fmv, this.fmx + (this.fmw / 2)));
            }
        }
        setMeasuredDimension(this.fms, this.fmt);
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
                        if (!this.fmB.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
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
        for (int i = 0; i < this.fmy.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.fmz);
            } else {
                this.paint.setColor(this.fmA);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fmy[i], (this.fmu * i) + (this.fmv / 2), this.fmx - this.ds48, this.paint);
        }
    }

    private void w(Canvas canvas) {
        this.paint.setColor(this.amH);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.fmv / 2.0d), this.fmx, (float) (this.fms - (this.fmv / 2.0d)), this.fmx, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.fmu * i) + (this.fmv / 2), this.fmx, this.paint);
        }
    }

    private void x(Canvas canvas) {
        Rect rect = (Rect) v.c(this.fmB, this.index);
        if (rect != null && this.dAe != null) {
            this.dAe.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.dAe.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dAe != null) {
            this.dAe.setCallback(null);
            this.dAe = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.dAe != null) {
                this.dAe = aj.getDrawable(d.f.wordsize);
            }
            this.fmz = aj.getColor(d.C0095d.cp_cont_f);
            this.fmA = aj.getColor(d.C0095d.cp_cont_d);
            this.amH = aj.getColor(d.C0095d.cp_cont_e);
            invalidate();
        }
    }
}
