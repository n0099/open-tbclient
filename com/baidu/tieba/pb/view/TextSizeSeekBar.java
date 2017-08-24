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
    private int fcC;
    private int fcD;
    private String[] fcE;
    private int fcF;
    private int fcG;
    private ArrayList<Rect> fcH;
    private int fcy;
    private int fcz;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fcH = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fcH = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fcH = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.dfw = ai.getDrawable(d.g.btn_recommend_size_handle);
        this.fcB = this.dfw.getIntrinsicWidth();
        this.fcC = this.dfw.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds24);
        this.fcE = new String[]{context.getString(d.l.font_size_small), context.getString(d.l.font_size_mid), context.getString(d.l.font_size_big), context.getString(d.l.font_size_xlarge)};
        this.fcF = ai.getColor(d.e.cp_link_tip_a);
        this.fcG = ai.getColor(d.e.cp_cont_c);
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
        if (this.fcy == 0 || this.fcz == 0) {
            this.fcy = View.MeasureSpec.getSize(i);
            this.fcz = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds184);
            this.fcA = (this.fcy - this.fcB) / 3;
            this.fcD = this.fcz / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fcH.add(new Rect(this.fcA * i3, this.fcD - (this.fcC / 2), (this.fcA * i3) + this.fcB, this.fcD + (this.fcC / 2)));
            }
        }
        setMeasuredDimension(this.fcy, this.fcz);
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
                        if (!this.fcH.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
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
        w(canvas);
        x(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds42);
        for (int i = 0; i < this.fcE.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.fcF);
            } else {
                this.paint.setColor(this.fcG);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fcE[i], (this.fcA * i) + (this.fcB / 2), this.fcD - dimensionPixelSize, this.paint);
        }
    }

    private void w(Canvas canvas) {
        this.paint.setColor(this.fcF);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.fcB / 2.0d), this.fcD, (float) ((this.index * this.fcA) + (this.fcB / 2.0d)), this.fcD, this.paint);
        this.paint.setColor(this.fcG);
        canvas.drawLine((float) ((this.index * this.fcA) + (this.fcB / 2.0d)), this.fcD, (float) (this.fcy - (this.fcB / 2.0d)), this.fcD, this.paint);
    }

    private void x(Canvas canvas) {
        Rect rect = (Rect) u.c(this.fcH, this.index);
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
