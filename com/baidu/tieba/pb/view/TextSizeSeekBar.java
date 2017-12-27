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
/* loaded from: classes2.dex */
public class TextSizeSeekBar extends View {
    private int baG;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable emf;
    private int fZm;
    private int fZn;
    private int fZo;
    private int fZp;
    private int fZq;
    private int fZr;
    private String[] fZs;
    private int fZt;
    private int fZu;
    private ArrayList<Rect> fZv;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fZv = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fZv = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fZv = new ArrayList<>(4);
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
        this.emf = aj.getDrawable(d.f.wordsize);
        this.fZp = dimensionPixelSize;
        this.fZq = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.fZs = new String[]{context.getString(d.j.font_size_small), context.getString(d.j.font_size_mid), context.getString(d.j.font_size_big), context.getString(d.j.font_size_xlarge)};
        this.fZt = aj.getColor(d.C0108d.cp_cont_f);
        this.fZu = aj.getColor(d.C0108d.cp_cont_d);
        this.baG = aj.getColor(d.C0108d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.emf = aj.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fZm == 0 || this.fZn == 0) {
            this.fZm = View.MeasureSpec.getSize(i);
            this.fZn = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.fZo = (this.fZm - this.fZp) / 3;
            this.fZr = this.fZn / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fZv.add(new Rect(this.fZo * i3, this.fZr - (this.fZq / 2), (this.fZo * i3) + this.fZp, this.fZr + (this.fZq / 2)));
            }
        }
        setMeasuredDimension(this.fZm, this.fZn);
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
                        if (!this.fZv.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.sH(Math.abs(this.index - 3));
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
        A(canvas);
        B(canvas);
    }

    private void drawText(Canvas canvas) {
        for (int i = 0; i < this.fZs.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.fZt);
            } else {
                this.paint.setColor(this.fZu);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fZs[i], (this.fZo * i) + (this.fZp / 2), this.fZr - this.ds48, this.paint);
        }
    }

    private void A(Canvas canvas) {
        this.paint.setColor(this.baG);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.fZp / 2.0d), this.fZr, (float) (this.fZm - (this.fZp / 2.0d)), this.fZr, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.fZo * i) + (this.fZp / 2), this.fZr, this.paint);
        }
    }

    private void B(Canvas canvas) {
        Rect rect = (Rect) v.f(this.fZv, this.index);
        if (rect != null && this.emf != null) {
            this.emf.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.emf.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.emf != null) {
            this.emf.setCallback(null);
            this.emf = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.emf != null) {
                this.emf = aj.getDrawable(d.f.wordsize);
            }
            this.fZt = aj.getColor(d.C0108d.cp_cont_f);
            this.fZu = aj.getColor(d.C0108d.cp_cont_d);
            this.baG = aj.getColor(d.C0108d.cp_cont_e);
            invalidate();
        }
    }
}
