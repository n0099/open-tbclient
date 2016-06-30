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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable cCF;
    private int dZA;
    private int dZB;
    private ArrayList<Rect> dZC;
    private int dZt;
    private int dZu;
    private int dZv;
    private int dZw;
    private int dZx;
    private int dZy;
    private String[] dZz;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.dZC = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.dZC = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.dZC = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.cCF = av.getDrawable(u.f.btn_recommend_size_handle);
        this.dZw = this.cCF.getIntrinsicWidth();
        this.dZx = this.cCF.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(u.e.ds24);
        this.dZz = new String[]{context.getString(u.j.text_size_small), context.getString(u.j.text_size_middle), context.getString(u.j.text_size_big), context.getString(u.j.text_size_very_big)};
        this.dZA = av.getColor(u.d.cp_link_tip_a);
        this.dZB = av.getColor(u.d.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.cCF = av.getDrawable(u.f.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.dZt == 0 || this.dZu == 0) {
            this.dZt = View.MeasureSpec.getSize(i);
            this.dZu = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(u.e.ds184);
            this.dZv = (this.dZt - this.dZw) / 3;
            this.dZy = this.dZu / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.dZC.add(new Rect(this.dZv * i3, this.dZy - (this.dZx / 2), (this.dZv * i3) + this.dZw, this.dZy + (this.dZx / 2)));
            }
        }
        setMeasuredDimension(this.dZt, this.dZu);
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
                        if (!this.dZC.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.c.ne(Math.abs(this.index - 3));
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
        q(canvas);
        r(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(u.e.ds42);
        for (int i = 0; i < this.dZz.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.dZA);
            } else {
                this.paint.setColor(this.dZB);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.dZz[i], (this.dZv * i) + (this.dZw / 2), this.dZy - dimensionPixelSize, this.paint);
        }
    }

    private void q(Canvas canvas) {
        this.paint.setColor(this.dZA);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine(this.dZw / 2, this.dZy, (this.index * this.dZv) + (this.dZw / 2), this.dZy, this.paint);
        this.paint.setColor(this.dZB);
        canvas.drawLine((this.index * this.dZv) + (this.dZw / 2), this.dZy, this.dZt - (this.dZw / 2), this.dZy, this.paint);
    }

    private void r(Canvas canvas) {
        Rect rect = (Rect) y.c(this.dZC, this.index);
        if (rect != null && this.cCF != null) {
            this.cCF.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.cCF.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cCF != null) {
            this.cCF.setCallback(null);
            this.cCF = null;
        }
    }
}
