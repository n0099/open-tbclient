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
    private int aIr;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable eEA;
    private int gmo;
    private int gmp;
    private int gmq;
    private int gmr;
    private int gms;
    private int gmt;
    private String[] gmu;
    private int gmv;
    private int gmw;
    private ArrayList<Rect> gmx;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.gmx = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.gmx = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.gmx = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds48);
        init(context);
    }

    private void init(Context context) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds54);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.eEA = al.getDrawable(e.f.wordsize);
        this.gmr = dimensionPixelSize;
        this.gms = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds28);
        this.gmu = new String[]{context.getString(e.j.font_size_small), context.getString(e.j.font_size_mid), context.getString(e.j.font_size_big), context.getString(e.j.font_size_xlarge)};
        this.gmv = al.getColor(e.d.cp_cont_f);
        this.gmw = al.getColor(e.d.cp_cont_d);
        this.aIr = al.getColor(e.d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.eEA = al.getDrawable(e.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.gmo == 0 || this.gmp == 0) {
            this.gmo = View.MeasureSpec.getSize(i);
            this.gmp = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds176);
            this.gmq = (this.gmo - this.gmr) / 3;
            this.gmt = this.gmp / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.gmx.add(new Rect(this.gmq * i3, this.gmt - (this.gms / 2), (this.gmq * i3) + this.gmr, this.gmt + (this.gms / 2)));
            }
        }
        setMeasuredDimension(this.gmo, this.gmp);
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
                        if (!this.gmx.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.rZ(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.gmu.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.gmv);
            } else {
                this.paint.setColor(this.gmw);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.gmu[i], (this.gmq * i) + (this.gmr / 2), this.gmt - this.ds48, this.paint);
        }
    }

    private void z(Canvas canvas) {
        this.paint.setColor(this.aIr);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.gmr / 2.0d), this.gmt, (float) (this.gmo - (this.gmr / 2.0d)), this.gmt, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.gmq * i) + (this.gmr / 2), this.gmt, this.paint);
        }
    }

    private void A(Canvas canvas) {
        Rect rect = (Rect) v.d(this.gmx, this.index);
        if (rect != null && this.eEA != null) {
            this.eEA.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.eEA.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eEA != null) {
            this.eEA.setCallback(null);
            this.eEA = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.eEA != null) {
                this.eEA = al.getDrawable(e.f.wordsize);
            }
            this.gmv = al.getColor(e.d.cp_cont_f);
            this.gmw = al.getColor(e.d.cp_cont_d);
            this.aIr = al.getColor(e.d.cp_cont_e);
            invalidate();
        }
    }
}
