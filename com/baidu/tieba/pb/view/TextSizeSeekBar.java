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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable cLC;
    private int eDi;
    private int eDj;
    private int eDk;
    private int eDl;
    private int eDm;
    private int eDn;
    private String[] eDo;
    private int eDp;
    private int eDq;
    private ArrayList<Rect> eDr;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.eDr = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.eDr = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.eDr = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.cLC = aq.getDrawable(w.g.btn_recommend_size_handle);
        this.eDl = this.cLC.getIntrinsicWidth();
        this.eDm = this.cLC.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds24);
        this.eDo = new String[]{context.getString(w.l.font_size_small), context.getString(w.l.font_size_mid), context.getString(w.l.font_size_big), context.getString(w.l.font_size_xlarge)};
        this.eDp = aq.getColor(w.e.cp_link_tip_a);
        this.eDq = aq.getColor(w.e.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.cLC = aq.getDrawable(w.g.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.eDi == 0 || this.eDj == 0) {
            this.eDi = View.MeasureSpec.getSize(i);
            this.eDj = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds184);
            this.eDk = (this.eDi - this.eDl) / 3;
            this.eDn = this.eDj / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.eDr.add(new Rect(this.eDk * i3, this.eDn - (this.eDm / 2), (this.eDk * i3) + this.eDl, this.eDn + (this.eDm / 2)));
            }
        }
        setMeasuredDimension(this.eDi, this.eDj);
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
                        if (!this.eDr.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.c.oo(Math.abs(this.index - 3));
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
        n(canvas);
        o(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds42);
        for (int i = 0; i < this.eDo.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.eDp);
            } else {
                this.paint.setColor(this.eDq);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.eDo[i], (this.eDk * i) + (this.eDl / 2), this.eDn - dimensionPixelSize, this.paint);
        }
    }

    private void n(Canvas canvas) {
        this.paint.setColor(this.eDp);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.eDl / 2.0d), this.eDn, (float) ((this.index * this.eDk) + (this.eDl / 2.0d)), this.eDn, this.paint);
        this.paint.setColor(this.eDq);
        canvas.drawLine((float) ((this.index * this.eDk) + (this.eDl / 2.0d)), this.eDn, (float) (this.eDi - (this.eDl / 2.0d)), this.eDn, this.paint);
    }

    private void o(Canvas canvas) {
        Rect rect = (Rect) com.baidu.tbadk.core.util.x.c(this.eDr, this.index);
        if (rect != null && this.cLC != null) {
            this.cLC.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.cLC.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cLC != null) {
            this.cLC.setCallback(null);
            this.cLC = null;
        }
    }
}
