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
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable dyV;
    private int flp;
    private int flq;
    private int flr;
    private int fls;
    private int flt;
    private int flu;
    private String[] flv;
    private int flw;
    private int flx;
    private ArrayList<Rect> fly;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fly = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fly = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fly = new ArrayList<>(4);
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
        this.dyV = aj.getDrawable(d.f.wordsize);
        this.fls = dimensionPixelSize;
        this.flt = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.flv = new String[]{context.getString(d.j.font_size_small), context.getString(d.j.font_size_mid), context.getString(d.j.font_size_big), context.getString(d.j.font_size_xlarge)};
        this.flw = aj.getColor(d.C0082d.cp_cont_f);
        this.flx = aj.getColor(d.C0082d.cp_cont_d);
        this.amH = aj.getColor(d.C0082d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.dyV = aj.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.flp == 0 || this.flq == 0) {
            this.flp = View.MeasureSpec.getSize(i);
            this.flq = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.flr = (this.flp - this.fls) / 3;
            this.flu = this.flq / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fly.add(new Rect(this.flr * i3, this.flu - (this.flt / 2), (this.flr * i3) + this.fls, this.flu + (this.flt / 2)));
            }
        }
        setMeasuredDimension(this.flp, this.flq);
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
                        if (!this.fly.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.pG(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.flv.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.flw);
            } else {
                this.paint.setColor(this.flx);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.flv[i], (this.flr * i) + (this.fls / 2), this.flu - this.ds48, this.paint);
        }
    }

    private void w(Canvas canvas) {
        this.paint.setColor(this.amH);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.fls / 2.0d), this.flu, (float) (this.flp - (this.fls / 2.0d)), this.flu, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.flr * i) + (this.fls / 2), this.flu, this.paint);
        }
    }

    private void x(Canvas canvas) {
        Rect rect = (Rect) v.c(this.fly, this.index);
        if (rect != null && this.dyV != null) {
            this.dyV.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.dyV.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dyV != null) {
            this.dyV.setCallback(null);
            this.dyV = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.dyV != null) {
                this.dyV = aj.getDrawable(d.f.wordsize);
            }
            this.flw = aj.getColor(d.C0082d.cp_cont_f);
            this.flx = aj.getColor(d.C0082d.cp_cont_d);
            this.amH = aj.getColor(d.C0082d.cp_cont_e);
            invalidate();
        }
    }
}
