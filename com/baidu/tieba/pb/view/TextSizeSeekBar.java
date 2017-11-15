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
    private int aml;
    private Drawable dri;
    private int ds12;
    private int ds3;
    private int ds48;
    private int fep;
    private int feq;
    private int fer;
    private int fes;
    private int fet;
    private int feu;
    private String[] fev;
    private int few;
    private int fex;
    private ArrayList<Rect> fey;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fey = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fey = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fey = new ArrayList<>(4);
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
        this.dri = aj.getDrawable(d.f.wordsize);
        this.fes = dimensionPixelSize;
        this.fet = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.fev = new String[]{context.getString(d.j.font_size_small), context.getString(d.j.font_size_mid), context.getString(d.j.font_size_big), context.getString(d.j.font_size_xlarge)};
        this.few = aj.getColor(d.C0080d.cp_cont_f);
        this.fex = aj.getColor(d.C0080d.cp_cont_d);
        this.aml = aj.getColor(d.C0080d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.dri = aj.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fep == 0 || this.feq == 0) {
            this.fep = View.MeasureSpec.getSize(i);
            this.feq = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.fer = (this.fep - this.fes) / 3;
            this.feu = this.feq / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fey.add(new Rect(this.fer * i3, this.feu - (this.fet / 2), (this.fer * i3) + this.fes, this.feu + (this.fet / 2)));
            }
        }
        setMeasuredDimension(this.fep, this.feq);
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
                        if (!this.fey.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.pt(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.fev.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.few);
            } else {
                this.paint.setColor(this.fex);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fev[i], (this.fer * i) + (this.fes / 2), this.feu - this.ds48, this.paint);
        }
    }

    private void w(Canvas canvas) {
        this.paint.setColor(this.aml);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.fes / 2.0d), this.feu, (float) (this.fep - (this.fes / 2.0d)), this.feu, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.fer * i) + (this.fes / 2), this.feu, this.paint);
        }
    }

    private void x(Canvas canvas) {
        Rect rect = (Rect) v.c(this.fey, this.index);
        if (rect != null && this.dri != null) {
            this.dri.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.dri.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dri != null) {
            this.dri.setCallback(null);
            this.dri = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.dri != null) {
                this.dri = aj.getDrawable(d.f.wordsize);
            }
            this.few = aj.getColor(d.C0080d.cp_cont_f);
            this.fex = aj.getColor(d.C0080d.cp_cont_d);
            this.aml = aj.getColor(d.C0080d.cp_cont_e);
            invalidate();
        }
    }
}
