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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class TextSizeSeekBar extends View {
    private int aEb;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable ewo;
    private int gdZ;
    private int gea;
    private int geb;
    private int gec;
    private int ged;
    private int gee;
    private String[] gef;
    private int geg;
    private int geh;
    private ArrayList<Rect> gei;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.gei = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.gei = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.gei = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds48);
        init(context);
    }

    private void init(Context context) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds54);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ewo = al.getDrawable(e.f.wordsize);
        this.gec = dimensionPixelSize;
        this.ged = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds28);
        this.gef = new String[]{context.getString(e.j.font_size_small), context.getString(e.j.font_size_mid), context.getString(e.j.font_size_big), context.getString(e.j.font_size_xlarge)};
        this.geg = al.getColor(e.d.cp_cont_f);
        this.geh = al.getColor(e.d.cp_cont_d);
        this.aEb = al.getColor(e.d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.ewo = al.getDrawable(e.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.gdZ == 0 || this.gea == 0) {
            this.gdZ = View.MeasureSpec.getSize(i);
            this.gea = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0175e.ds176);
            this.geb = (this.gdZ - this.gec) / 3;
            this.gee = this.gea / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.gei.add(new Rect(this.geb * i3, this.gee - (this.ged / 2), (this.geb * i3) + this.gec, this.gee + (this.ged / 2)));
            }
        }
        setMeasuredDimension(this.gdZ, this.gea);
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
                        if (!this.gei.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.rm(Math.abs(this.index - 3));
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
        x(canvas);
        z(canvas);
        A(canvas);
    }

    private void x(Canvas canvas) {
        for (int i = 0; i < this.gef.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.geg);
            } else {
                this.paint.setColor(this.geh);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.gef[i], (this.geb * i) + (this.gec / 2), this.gee - this.ds48, this.paint);
        }
    }

    private void z(Canvas canvas) {
        this.paint.setColor(this.aEb);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.gec / 2.0d), this.gee, (float) (this.gdZ - (this.gec / 2.0d)), this.gee, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.geb * i) + (this.gec / 2), this.gee, this.paint);
        }
    }

    private void A(Canvas canvas) {
        Rect rect = (Rect) v.d(this.gei, this.index);
        if (rect != null && this.ewo != null) {
            this.ewo.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.ewo.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ewo != null) {
            this.ewo.setCallback(null);
            this.ewo = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.ewo != null) {
                this.ewo = al.getDrawable(e.f.wordsize);
            }
            this.geg = al.getColor(e.d.cp_cont_f);
            this.geh = al.getColor(e.d.cp_cont_d);
            this.aEb = al.getColor(e.d.cp_cont_e);
            invalidate();
        }
    }
}
