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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable cRb;
    private int eyb;
    private int eyc;
    private int eyd;
    private int eye;
    private int eyf;
    private int eyg;
    private String[] eyh;
    private int eyi;
    private int eyj;
    private ArrayList<Rect> eyk;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.eyk = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.eyk = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.eyk = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.cRb = av.getDrawable(t.f.btn_recommend_size_handle);
        this.eye = this.cRb.getIntrinsicWidth();
        this.eyf = this.cRb.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(t.e.ds24);
        this.eyh = new String[]{context.getString(t.j.text_size_small), context.getString(t.j.text_size_middle), context.getString(t.j.text_size_big), context.getString(t.j.text_size_very_big)};
        this.eyi = av.getColor(t.d.cp_link_tip_a);
        this.eyj = av.getColor(t.d.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.cRb = av.getDrawable(t.f.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.eyb == 0 || this.eyc == 0) {
            this.eyb = View.MeasureSpec.getSize(i);
            this.eyc = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(t.e.ds184);
            this.eyd = (this.eyb - this.eye) / 3;
            this.eyg = this.eyc / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.eyk.add(new Rect(this.eyd * i3, this.eyg - (this.eyf / 2), (this.eyd * i3) + this.eye, this.eyg + (this.eyf / 2)));
            }
        }
        setMeasuredDimension(this.eyb, this.eyc);
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
                        if (!this.eyk.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.c.nZ(Math.abs(this.index - 3));
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
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(t.e.ds42);
        for (int i = 0; i < this.eyh.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.eyi);
            } else {
                this.paint.setColor(this.eyj);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.eyh[i], (this.eyd * i) + (this.eye / 2), this.eyg - dimensionPixelSize, this.paint);
        }
    }

    private void x(Canvas canvas) {
        this.paint.setColor(this.eyi);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine(this.eye / 2, this.eyg, (this.index * this.eyd) + (this.eye / 2), this.eyg, this.paint);
        this.paint.setColor(this.eyj);
        canvas.drawLine((this.index * this.eyd) + (this.eye / 2), this.eyg, this.eyb - (this.eye / 2), this.eyg, this.paint);
    }

    private void y(Canvas canvas) {
        Rect rect = (Rect) y.c(this.eyk, this.index);
        if (rect != null && this.cRb != null) {
            this.cRb.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.cRb.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cRb != null) {
            this.cRb.setCallback(null);
            this.cRb = null;
        }
    }
}
