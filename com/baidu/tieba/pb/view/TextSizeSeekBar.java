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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class TextSizeSeekBar extends View {
    private int awF;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable edo;
    private int fPh;
    private int fPi;
    private int fPj;
    private int fPk;
    private int fPl;
    private int fPm;
    private String[] fPn;
    private int fPo;
    private int fPp;
    private ArrayList<Rect> fPq;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fPq = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fPq = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fPq = new ArrayList<>(4);
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
        this.edo = am.getDrawable(d.f.wordsize);
        this.fPk = dimensionPixelSize;
        this.fPl = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.fPn = new String[]{context.getString(d.k.font_size_small), context.getString(d.k.font_size_mid), context.getString(d.k.font_size_big), context.getString(d.k.font_size_xlarge)};
        this.fPo = am.getColor(d.C0142d.cp_cont_f);
        this.fPp = am.getColor(d.C0142d.cp_cont_d);
        this.awF = am.getColor(d.C0142d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.edo = am.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fPh == 0 || this.fPi == 0) {
            this.fPh = View.MeasureSpec.getSize(i);
            this.fPi = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.fPj = (this.fPh - this.fPk) / 3;
            this.fPm = this.fPi / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fPq.add(new Rect(this.fPj * i3, this.fPm - (this.fPl / 2), (this.fPj * i3) + this.fPk, this.fPm + (this.fPl / 2)));
            }
        }
        setMeasuredDimension(this.fPh, this.fPi);
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
                        if (!this.fPq.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.qq(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.fPn.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.fPo);
            } else {
                this.paint.setColor(this.fPp);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fPn[i], (this.fPj * i) + (this.fPk / 2), this.fPm - this.ds48, this.paint);
        }
    }

    private void A(Canvas canvas) {
        this.paint.setColor(this.awF);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.fPk / 2.0d), this.fPm, (float) (this.fPh - (this.fPk / 2.0d)), this.fPm, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.fPj * i) + (this.fPk / 2), this.fPm, this.paint);
        }
    }

    private void B(Canvas canvas) {
        Rect rect = (Rect) w.d(this.fPq, this.index);
        if (rect != null && this.edo != null) {
            this.edo.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.edo.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.edo != null) {
            this.edo.setCallback(null);
            this.edo = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.edo != null) {
                this.edo = am.getDrawable(d.f.wordsize);
            }
            this.fPo = am.getColor(d.C0142d.cp_cont_f);
            this.fPp = am.getColor(d.C0142d.cp_cont_d);
            this.awF = am.getColor(d.C0142d.cp_cont_e);
            invalidate();
        }
    }
}
