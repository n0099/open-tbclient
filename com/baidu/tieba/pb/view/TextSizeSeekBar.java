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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class TextSizeSeekBar extends View {
    private int bRq;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable fYe;
    private int hGA;
    private String[] hGB;
    private int hGC;
    private int hGD;
    private ArrayList<Rect> hGE;
    private int hGv;
    private int hGw;
    private int hGx;
    private int hGy;
    private int hGz;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.hGE = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.hGE = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.hGE = new ArrayList<>(4);
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
        this.fYe = al.getDrawable(d.f.wordsize);
        this.hGy = dimensionPixelSize;
        this.hGz = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.hGB = new String[]{context.getString(d.j.font_size_small), context.getString(d.j.font_size_mid), context.getString(d.j.font_size_big), context.getString(d.j.font_size_xlarge)};
        this.hGC = al.getColor(d.C0277d.cp_cont_f);
        this.hGD = al.getColor(d.C0277d.cp_cont_d);
        this.bRq = al.getColor(d.C0277d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.fYe = al.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.hGv == 0 || this.hGw == 0) {
            this.hGv = View.MeasureSpec.getSize(i);
            this.hGw = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.hGx = (this.hGv - this.hGy) / 3;
            this.hGA = this.hGw / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.hGE.add(new Rect(this.hGx * i3, this.hGA - (this.hGz / 2), (this.hGx * i3) + this.hGy, this.hGA + (this.hGz / 2)));
            }
        }
        setMeasuredDimension(this.hGv, this.hGw);
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
                        if (!this.hGE.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.vY(Math.abs(this.index - 3));
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
        P(canvas);
        R(canvas);
        S(canvas);
    }

    private void P(Canvas canvas) {
        for (int i = 0; i < this.hGB.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.hGC);
            } else {
                this.paint.setColor(this.hGD);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.hGB[i], (this.hGx * i) + (this.hGy / 2), this.hGA - this.ds48, this.paint);
        }
    }

    private void R(Canvas canvas) {
        this.paint.setColor(this.bRq);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.hGy / 2.0d), this.hGA, (float) (this.hGv - (this.hGy / 2.0d)), this.hGA, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.hGx * i) + (this.hGy / 2), this.hGA, this.paint);
        }
    }

    private void S(Canvas canvas) {
        Rect rect = (Rect) v.c(this.hGE, this.index);
        if (rect != null && this.fYe != null) {
            this.fYe.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.fYe.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fYe != null) {
            this.fYe.setCallback(null);
            this.fYe = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.fYe != null) {
                this.fYe = al.getDrawable(d.f.wordsize);
            }
            this.hGC = al.getColor(d.C0277d.cp_cont_f);
            this.hGD = al.getColor(d.C0277d.cp_cont_d);
            this.bRq = al.getColor(d.C0277d.cp_cont_e);
            invalidate();
        }
    }
}
