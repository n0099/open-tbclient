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
    private Drawable dce;
    private ArrayList<Rect> eZA;
    private int eZr;
    private int eZs;
    private int eZt;
    private int eZu;
    private int eZv;
    private int eZw;
    private String[] eZx;
    private int eZy;
    private int eZz;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.eZA = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.eZA = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.eZA = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.dce = ai.getDrawable(d.g.btn_recommend_size_handle);
        this.eZu = this.dce.getIntrinsicWidth();
        this.eZv = this.dce.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds24);
        this.eZx = new String[]{context.getString(d.l.font_size_small), context.getString(d.l.font_size_mid), context.getString(d.l.font_size_big), context.getString(d.l.font_size_xlarge)};
        this.eZy = ai.getColor(d.e.cp_link_tip_a);
        this.eZz = ai.getColor(d.e.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.dce = ai.getDrawable(d.g.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.eZr == 0 || this.eZs == 0) {
            this.eZr = View.MeasureSpec.getSize(i);
            this.eZs = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds184);
            this.eZt = (this.eZr - this.eZu) / 3;
            this.eZw = this.eZs / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.eZA.add(new Rect(this.eZt * i3, this.eZw - (this.eZv / 2), (this.eZt * i3) + this.eZu, this.eZw + (this.eZv / 2)));
            }
        }
        setMeasuredDimension(this.eZr, this.eZs);
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
                        if (!this.eZA.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.oO(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.eZx.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.eZy);
            } else {
                this.paint.setColor(this.eZz);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.eZx[i], (this.eZt * i) + (this.eZu / 2), this.eZw - dimensionPixelSize, this.paint);
        }
    }

    private void u(Canvas canvas) {
        this.paint.setColor(this.eZy);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.eZu / 2.0d), this.eZw, (float) ((this.index * this.eZt) + (this.eZu / 2.0d)), this.eZw, this.paint);
        this.paint.setColor(this.eZz);
        canvas.drawLine((float) ((this.index * this.eZt) + (this.eZu / 2.0d)), this.eZw, (float) (this.eZr - (this.eZu / 2.0d)), this.eZw, this.paint);
    }

    private void v(Canvas canvas) {
        Rect rect = (Rect) u.c(this.eZA, this.index);
        if (rect != null && this.dce != null) {
            this.dce.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.dce.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dce != null) {
            this.dce.setCallback(null);
            this.dce = null;
        }
    }
}
