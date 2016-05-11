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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable bXQ;
    private int dsX;
    private int dsY;
    private int dsZ;
    private int dta;
    private int dtb;
    private int dtc;
    private String[] dtd;
    private int dte;
    private int dtf;
    private ArrayList<Rect> dtg;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.dtg = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.dtg = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.dtg = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.bXQ = at.getDrawable(t.f.btn_recommend_size_handle);
        this.dta = this.bXQ.getIntrinsicWidth();
        this.dtb = this.bXQ.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.m11getInst().getContext().getResources().getDimensionPixelSize(t.e.ds24);
        this.dtd = new String[]{context.getString(t.j.text_size_small), context.getString(t.j.text_size_middle), context.getString(t.j.text_size_big), context.getString(t.j.text_size_very_big)};
        this.dte = at.getColor(t.d.cp_link_tip_a);
        this.dtf = at.getColor(t.d.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.m11getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.bXQ = at.getDrawable(t.f.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.m11getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.dsX == 0 || this.dsY == 0) {
            this.dsX = View.MeasureSpec.getSize(i);
            this.dsY = TbadkCoreApplication.m11getInst().getContext().getResources().getDimensionPixelSize(t.e.ds184);
            this.dsZ = (this.dsX - this.dta) / 3;
            this.dtc = this.dsY / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.dtg.add(new Rect(this.dsZ * i3, this.dtc - (this.dtb / 2), (this.dsZ * i3) + this.dta, this.dtc + (this.dtb / 2)));
            }
        }
        setMeasuredDimension(this.dsX, this.dsY);
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
                        if (!this.dtg.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.c.lD(Math.abs(this.index - 3));
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
        m(canvas);
        n(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.m11getInst().getContext().getResources().getDimensionPixelSize(t.e.ds42);
        for (int i = 0; i < this.dtd.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.dte);
            } else {
                this.paint.setColor(this.dtf);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.dtd[i], (this.dsZ * i) + (this.dta / 2), this.dtc - dimensionPixelSize, this.paint);
        }
    }

    private void m(Canvas canvas) {
        this.paint.setColor(this.dte);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine(this.dta / 2, this.dtc, (this.index * this.dsZ) + (this.dta / 2), this.dtc, this.paint);
        this.paint.setColor(this.dtf);
        canvas.drawLine((this.index * this.dsZ) + (this.dta / 2), this.dtc, this.dsX - (this.dta / 2), this.dtc, this.paint);
    }

    private void n(Canvas canvas) {
        Rect rect = (Rect) y.c(this.dtg, this.index);
        if (rect != null) {
            this.bXQ.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.bXQ.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bXQ != null) {
            this.bXQ.setCallback(null);
            this.bXQ = null;
        }
    }
}
