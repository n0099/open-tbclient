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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class TextSizeSeekBar extends View {
    private int avW;
    private Drawable dZu;
    private int ds12;
    private int ds3;
    private int ds48;
    private int fLf;
    private int fLg;
    private int fLh;
    private int fLi;
    private int fLj;
    private int fLk;
    private String[] fLl;
    private int fLm;
    private int fLn;
    private ArrayList<Rect> fLo;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fLo = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fLo = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fLo = new ArrayList<>(4);
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
        this.dZu = al.getDrawable(d.f.wordsize);
        this.fLi = dimensionPixelSize;
        this.fLj = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.fLl = new String[]{context.getString(d.k.font_size_small), context.getString(d.k.font_size_mid), context.getString(d.k.font_size_big), context.getString(d.k.font_size_xlarge)};
        this.fLm = al.getColor(d.C0141d.cp_cont_f);
        this.fLn = al.getColor(d.C0141d.cp_cont_d);
        this.avW = al.getColor(d.C0141d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.dZu = al.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fLf == 0 || this.fLg == 0) {
            this.fLf = View.MeasureSpec.getSize(i);
            this.fLg = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.fLh = (this.fLf - this.fLi) / 3;
            this.fLk = this.fLg / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fLo.add(new Rect(this.fLh * i3, this.fLk - (this.fLj / 2), (this.fLh * i3) + this.fLi, this.fLk + (this.fLj / 2)));
            }
        }
        setMeasuredDimension(this.fLf, this.fLg);
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
                        if (!this.fLo.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.qj(Math.abs(this.index - 3));
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
        y(canvas);
        z(canvas);
    }

    private void drawText(Canvas canvas) {
        for (int i = 0; i < this.fLl.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.fLm);
            } else {
                this.paint.setColor(this.fLn);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fLl[i], (this.fLh * i) + (this.fLi / 2), this.fLk - this.ds48, this.paint);
        }
    }

    private void y(Canvas canvas) {
        this.paint.setColor(this.avW);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.fLi / 2.0d), this.fLk, (float) (this.fLf - (this.fLi / 2.0d)), this.fLk, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.fLh * i) + (this.fLi / 2), this.fLk, this.paint);
        }
    }

    private void z(Canvas canvas) {
        Rect rect = (Rect) w.c(this.fLo, this.index);
        if (rect != null && this.dZu != null) {
            this.dZu.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.dZu.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dZu != null) {
            this.dZu.setCallback(null);
            this.dZu = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.dZu != null) {
                this.dZu = al.getDrawable(d.f.wordsize);
            }
            this.fLm = al.getColor(d.C0141d.cp_cont_f);
            this.fLn = al.getColor(d.C0141d.cp_cont_d);
            this.avW = al.getColor(d.C0141d.cp_cont_e);
            invalidate();
        }
    }
}
