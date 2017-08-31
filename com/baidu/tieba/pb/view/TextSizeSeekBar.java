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
    private Drawable dma;
    private int faP;
    private int faQ;
    private int faR;
    private int faS;
    private int faT;
    private int faU;
    private String[] faV;
    private int faW;
    private int faX;
    private ArrayList<Rect> faY;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.faY = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.faY = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.faY = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.dma = aj.getDrawable(d.g.btn_recommend_size_handle);
        this.faS = this.dma.getIntrinsicWidth();
        this.faT = this.dma.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds24);
        this.faV = new String[]{context.getString(d.l.font_size_small), context.getString(d.l.font_size_mid), context.getString(d.l.font_size_big), context.getString(d.l.font_size_xlarge)};
        this.faW = aj.getColor(d.e.cp_link_tip_a);
        this.faX = aj.getColor(d.e.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.dma = aj.getDrawable(d.g.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.faP == 0 || this.faQ == 0) {
            this.faP = View.MeasureSpec.getSize(i);
            this.faQ = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds184);
            this.faR = (this.faP - this.faS) / 3;
            this.faU = this.faQ / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.faY.add(new Rect(this.faR * i3, this.faU - (this.faT / 2), (this.faR * i3) + this.faS, this.faU + (this.faT / 2)));
            }
        }
        setMeasuredDimension(this.faP, this.faQ);
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
                        if (!this.faY.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.pe(Math.abs(this.index - 3));
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
        w(canvas);
        x(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds42);
        for (int i = 0; i < this.faV.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.faW);
            } else {
                this.paint.setColor(this.faX);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.faV[i], (this.faR * i) + (this.faS / 2), this.faU - dimensionPixelSize, this.paint);
        }
    }

    private void w(Canvas canvas) {
        this.paint.setColor(this.faW);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.faS / 2.0d), this.faU, (float) ((this.index * this.faR) + (this.faS / 2.0d)), this.faU, this.paint);
        this.paint.setColor(this.faX);
        canvas.drawLine((float) ((this.index * this.faR) + (this.faS / 2.0d)), this.faU, (float) (this.faP - (this.faS / 2.0d)), this.faU, this.paint);
    }

    private void x(Canvas canvas) {
        Rect rect = (Rect) v.c(this.faY, this.index);
        if (rect != null && this.dma != null) {
            this.dma.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.dma.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dma != null) {
            this.dma.setCallback(null);
            this.dma = null;
        }
    }
}
