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
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable djl;
    private int eVT;
    private int eVU;
    private int eVV;
    private int eVW;
    private int eVX;
    private int eVY;
    private String[] eVZ;
    private int eWa;
    private int eWb;
    private ArrayList<Rect> eWc;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.eWc = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.eWc = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.eWc = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.djl = aj.getDrawable(d.g.btn_recommend_size_handle);
        this.eVW = this.djl.getIntrinsicWidth();
        this.eVX = this.djl.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds24);
        this.eVZ = new String[]{context.getString(d.l.font_size_small), context.getString(d.l.font_size_mid), context.getString(d.l.font_size_big), context.getString(d.l.font_size_xlarge)};
        this.eWa = aj.getColor(d.e.cp_link_tip_a);
        this.eWb = aj.getColor(d.e.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.djl = aj.getDrawable(d.g.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.eVT == 0 || this.eVU == 0) {
            this.eVT = View.MeasureSpec.getSize(i);
            this.eVU = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds184);
            this.eVV = (this.eVT - this.eVW) / 3;
            this.eVY = this.eVU / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.eWc.add(new Rect(this.eVV * i3, this.eVY - (this.eVX / 2), (this.eVV * i3) + this.eVW, this.eVY + (this.eVX / 2)));
            }
        }
        setMeasuredDimension(this.eVT, this.eVU);
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
                        if (!this.eWc.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.oZ(Math.abs(this.index - 3));
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
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds42);
        for (int i = 0; i < this.eVZ.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.eWa);
            } else {
                this.paint.setColor(this.eWb);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.eVZ[i], (this.eVV * i) + (this.eVW / 2), this.eVY - dimensionPixelSize, this.paint);
        }
    }

    private void x(Canvas canvas) {
        this.paint.setColor(this.eWa);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.eVW / 2.0d), this.eVY, (float) ((this.index * this.eVV) + (this.eVW / 2.0d)), this.eVY, this.paint);
        this.paint.setColor(this.eWb);
        canvas.drawLine((float) ((this.index * this.eVV) + (this.eVW / 2.0d)), this.eVY, (float) (this.eVT - (this.eVW / 2.0d)), this.eVY, this.paint);
    }

    private void y(Canvas canvas) {
        Rect rect = (Rect) v.c(this.eWc, this.index);
        if (rect != null && this.djl != null) {
            this.djl.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.djl.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.djl != null) {
            this.djl.setCallback(null);
            this.djl = null;
        }
    }
}
