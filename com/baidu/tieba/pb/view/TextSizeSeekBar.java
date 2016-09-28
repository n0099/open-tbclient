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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable cRS;
    private int eAi;
    private int eAj;
    private int eAk;
    private int eAl;
    private int eAm;
    private int eAn;
    private String[] eAo;
    private int eAp;
    private int eAq;
    private ArrayList<Rect> eAr;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.eAr = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.eAr = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.eAr = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.cRS = av.getDrawable(r.f.btn_recommend_size_handle);
        this.eAl = this.cRS.getIntrinsicWidth();
        this.eAm = this.cRS.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds24);
        this.eAo = new String[]{context.getString(r.j.text_size_small), context.getString(r.j.text_size_middle), context.getString(r.j.text_size_big), context.getString(r.j.text_size_very_big)};
        this.eAp = av.getColor(r.d.cp_link_tip_a);
        this.eAq = av.getColor(r.d.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.cRS = av.getDrawable(r.f.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.eAi == 0 || this.eAj == 0) {
            this.eAi = View.MeasureSpec.getSize(i);
            this.eAj = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds184);
            this.eAk = (this.eAi - this.eAl) / 3;
            this.eAn = this.eAj / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.eAr.add(new Rect(this.eAk * i3, this.eAn - (this.eAm / 2), (this.eAk * i3) + this.eAl, this.eAn + (this.eAm / 2)));
            }
        }
        setMeasuredDimension(this.eAi, this.eAj);
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
                        if (!this.eAr.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.c.oj(Math.abs(this.index - 3));
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
        x(canvas);
        y(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds42);
        for (int i = 0; i < this.eAo.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.eAp);
            } else {
                this.paint.setColor(this.eAq);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.eAo[i], (this.eAk * i) + (this.eAl / 2), this.eAn - dimensionPixelSize, this.paint);
        }
    }

    private void x(Canvas canvas) {
        this.paint.setColor(this.eAp);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine(this.eAl / 2, this.eAn, (this.index * this.eAk) + (this.eAl / 2), this.eAn, this.paint);
        this.paint.setColor(this.eAq);
        canvas.drawLine((this.index * this.eAk) + (this.eAl / 2), this.eAn, this.eAi - (this.eAl / 2), this.eAn, this.paint);
    }

    private void y(Canvas canvas) {
        Rect rect = (Rect) y.c(this.eAr, this.index);
        if (rect != null && this.cRS != null) {
            this.cRS.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.cRS.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cRS != null) {
            this.cRS.setCallback(null);
            this.cRS = null;
        }
    }
}
