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
    private int aER;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable exJ;
    private int gfA;
    private int gfB;
    private int gfC;
    private String[] gfD;
    private int gfE;
    private int gfF;
    private ArrayList<Rect> gfG;
    private int gfx;
    private int gfy;
    private int gfz;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.gfG = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.gfG = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.gfG = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds48);
        init(context);
    }

    private void init(Context context) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds54);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.exJ = al.getDrawable(e.f.wordsize);
        this.gfA = dimensionPixelSize;
        this.gfB = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds28);
        this.gfD = new String[]{context.getString(e.j.font_size_small), context.getString(e.j.font_size_mid), context.getString(e.j.font_size_big), context.getString(e.j.font_size_xlarge)};
        this.gfE = al.getColor(e.d.cp_cont_f);
        this.gfF = al.getColor(e.d.cp_cont_d);
        this.aER = al.getColor(e.d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.exJ = al.getDrawable(e.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.gfx == 0 || this.gfy == 0) {
            this.gfx = View.MeasureSpec.getSize(i);
            this.gfy = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.ds176);
            this.gfz = (this.gfx - this.gfA) / 3;
            this.gfC = this.gfy / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.gfG.add(new Rect(this.gfz * i3, this.gfC - (this.gfB / 2), (this.gfz * i3) + this.gfA, this.gfC + (this.gfB / 2)));
            }
        }
        setMeasuredDimension(this.gfx, this.gfy);
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
                        if (!this.gfG.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.rF(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.gfD.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.gfE);
            } else {
                this.paint.setColor(this.gfF);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.gfD[i], (this.gfz * i) + (this.gfA / 2), this.gfC - this.ds48, this.paint);
        }
    }

    private void z(Canvas canvas) {
        this.paint.setColor(this.aER);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.gfA / 2.0d), this.gfC, (float) (this.gfx - (this.gfA / 2.0d)), this.gfC, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.gfz * i) + (this.gfA / 2), this.gfC, this.paint);
        }
    }

    private void A(Canvas canvas) {
        Rect rect = (Rect) v.d(this.gfG, this.index);
        if (rect != null && this.exJ != null) {
            this.exJ.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.exJ.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.exJ != null) {
            this.exJ.setCallback(null);
            this.exJ = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.exJ != null) {
                this.exJ = al.getDrawable(e.f.wordsize);
            }
            this.gfE = al.getColor(e.d.cp_cont_f);
            this.gfF = al.getColor(e.d.cp_cont_d);
            this.aER = al.getColor(e.d.cp_cont_e);
            invalidate();
        }
    }
}
