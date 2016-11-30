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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable cXA;
    private int eGR;
    private int eGS;
    private int eGT;
    private int eGU;
    private int eGV;
    private int eGW;
    private String[] eGX;
    private int eGY;
    private int eGZ;
    private ArrayList<Rect> eHa;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.eHa = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.eHa = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.eHa = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.cXA = at.getDrawable(r.f.btn_recommend_size_handle);
        this.eGU = this.cXA.getIntrinsicWidth();
        this.eGV = this.cXA.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds24);
        this.eGX = new String[]{context.getString(r.j.text_size_small), context.getString(r.j.text_size_middle), context.getString(r.j.text_size_big), context.getString(r.j.text_size_very_big)};
        this.eGY = at.getColor(r.d.cp_link_tip_a);
        this.eGZ = at.getColor(r.d.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.cXA = at.getDrawable(r.f.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.eGR == 0 || this.eGS == 0) {
            this.eGR = View.MeasureSpec.getSize(i);
            this.eGS = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds184);
            this.eGT = (this.eGR - this.eGU) / 3;
            this.eGW = this.eGS / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.eHa.add(new Rect(this.eGT * i3, this.eGW - (this.eGV / 2), (this.eGT * i3) + this.eGU, this.eGW + (this.eGV / 2)));
            }
        }
        setMeasuredDimension(this.eGR, this.eGS);
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
                        if (!this.eHa.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.c.ot(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.eGX.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.eGY);
            } else {
                this.paint.setColor(this.eGZ);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.eGX[i], (this.eGT * i) + (this.eGU / 2), this.eGW - dimensionPixelSize, this.paint);
        }
    }

    private void x(Canvas canvas) {
        this.paint.setColor(this.eGY);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine(this.eGU / 2, this.eGW, (this.index * this.eGT) + (this.eGU / 2), this.eGW, this.paint);
        this.paint.setColor(this.eGZ);
        canvas.drawLine((this.index * this.eGT) + (this.eGU / 2), this.eGW, this.eGR - (this.eGU / 2), this.eGW, this.paint);
    }

    private void y(Canvas canvas) {
        Rect rect = (Rect) x.c(this.eHa, this.index);
        if (rect != null && this.cXA != null) {
            this.cXA.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.cXA.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cXA != null) {
            this.cXA.setCallback(null);
            this.cXA = null;
        }
    }
}
