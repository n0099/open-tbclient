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
    private int bRt;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable fXS;
    private int hGi;
    private int hGj;
    private int hGk;
    private int hGl;
    private int hGm;
    private int hGn;
    private String[] hGo;
    private int hGp;
    private int hGq;
    private ArrayList<Rect> hGr;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.hGr = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.hGr = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.hGr = new ArrayList<>(4);
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
        this.fXS = al.getDrawable(d.f.wordsize);
        this.hGl = dimensionPixelSize;
        this.hGm = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.hGo = new String[]{context.getString(d.j.font_size_small), context.getString(d.j.font_size_mid), context.getString(d.j.font_size_big), context.getString(d.j.font_size_xlarge)};
        this.hGp = al.getColor(d.C0277d.cp_cont_f);
        this.hGq = al.getColor(d.C0277d.cp_cont_d);
        this.bRt = al.getColor(d.C0277d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.fXS = al.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.hGi == 0 || this.hGj == 0) {
            this.hGi = View.MeasureSpec.getSize(i);
            this.hGj = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.hGk = (this.hGi - this.hGl) / 3;
            this.hGn = this.hGj / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.hGr.add(new Rect(this.hGk * i3, this.hGn - (this.hGm / 2), (this.hGk * i3) + this.hGl, this.hGn + (this.hGm / 2)));
            }
        }
        setMeasuredDimension(this.hGi, this.hGj);
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
                        if (!this.hGr.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.vU(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.hGo.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.hGp);
            } else {
                this.paint.setColor(this.hGq);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.hGo[i], (this.hGk * i) + (this.hGl / 2), this.hGn - this.ds48, this.paint);
        }
    }

    private void R(Canvas canvas) {
        this.paint.setColor(this.bRt);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.hGl / 2.0d), this.hGn, (float) (this.hGi - (this.hGl / 2.0d)), this.hGn, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.hGk * i) + (this.hGl / 2), this.hGn, this.paint);
        }
    }

    private void S(Canvas canvas) {
        Rect rect = (Rect) v.c(this.hGr, this.index);
        if (rect != null && this.fXS != null) {
            this.fXS.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.fXS.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fXS != null) {
            this.fXS.setCallback(null);
            this.fXS = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.fXS != null) {
                this.fXS = al.getDrawable(d.f.wordsize);
            }
            this.hGp = al.getColor(d.C0277d.cp_cont_f);
            this.hGq = al.getColor(d.C0277d.cp_cont_d);
            this.bRt = al.getColor(d.C0277d.cp_cont_e);
            invalidate();
        }
    }
}
