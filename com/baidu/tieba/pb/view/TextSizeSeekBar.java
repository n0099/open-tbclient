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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable dfw;
    private int fcA;
    private int fcB;
    private String[] fcC;
    private int fcD;
    private int fcE;
    private ArrayList<Rect> fcF;
    private int fcw;
    private int fcx;
    private int fcy;
    private int fcz;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fcF = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fcF = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fcF = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.dfw = ai.getDrawable(d.g.btn_recommend_size_handle);
        this.fcz = this.dfw.getIntrinsicWidth();
        this.fcA = this.dfw.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds24);
        this.fcC = new String[]{context.getString(d.l.font_size_small), context.getString(d.l.font_size_mid), context.getString(d.l.font_size_big), context.getString(d.l.font_size_xlarge)};
        this.fcD = ai.getColor(d.e.cp_link_tip_a);
        this.fcE = ai.getColor(d.e.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.dfw = ai.getDrawable(d.g.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fcw == 0 || this.fcx == 0) {
            this.fcw = View.MeasureSpec.getSize(i);
            this.fcx = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds184);
            this.fcy = (this.fcw - this.fcz) / 3;
            this.fcB = this.fcx / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fcF.add(new Rect(this.fcy * i3, this.fcB - (this.fcA / 2), (this.fcy * i3) + this.fcz, this.fcB + (this.fcA / 2)));
            }
        }
        setMeasuredDimension(this.fcw, this.fcx);
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
                        if (!this.fcF.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.oX(Math.abs(this.index - 3));
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
        u(canvas);
        v(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds42);
        for (int i = 0; i < this.fcC.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.fcD);
            } else {
                this.paint.setColor(this.fcE);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fcC[i], (this.fcy * i) + (this.fcz / 2), this.fcB - dimensionPixelSize, this.paint);
        }
    }

    private void u(Canvas canvas) {
        this.paint.setColor(this.fcD);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.fcz / 2.0d), this.fcB, (float) ((this.index * this.fcy) + (this.fcz / 2.0d)), this.fcB, this.paint);
        this.paint.setColor(this.fcE);
        canvas.drawLine((float) ((this.index * this.fcy) + (this.fcz / 2.0d)), this.fcB, (float) (this.fcw - (this.fcz / 2.0d)), this.fcB, this.paint);
    }

    private void v(Canvas canvas) {
        Rect rect = (Rect) u.c(this.fcF, this.index);
        if (rect != null && this.dfw != null) {
            this.dfw.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.dfw.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dfw != null) {
            this.dfw.setCallback(null);
            this.dfw = null;
        }
    }
}
