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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable cGe;
    private int euf;
    private int eug;
    private int euh;
    private int eui;
    private int euj;
    private int euk;
    private String[] eul;
    private int eum;
    private int eun;
    private ArrayList<Rect> euo;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.euo = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.euo = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.euo = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.cGe = aq.getDrawable(w.g.btn_recommend_size_handle);
        this.eui = this.cGe.getIntrinsicWidth();
        this.euj = this.cGe.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds24);
        this.eul = new String[]{context.getString(w.l.font_size_small), context.getString(w.l.font_size_mid), context.getString(w.l.font_size_big), context.getString(w.l.font_size_xlarge)};
        this.eum = aq.getColor(w.e.cp_link_tip_a);
        this.eun = aq.getColor(w.e.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.cGe = aq.getDrawable(w.g.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.euf == 0 || this.eug == 0) {
            this.euf = View.MeasureSpec.getSize(i);
            this.eug = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds184);
            this.euh = (this.euf - this.eui) / 3;
            this.euk = this.eug / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.euo.add(new Rect(this.euh * i3, this.euk - (this.euj / 2), (this.euh * i3) + this.eui, this.euk + (this.euj / 2)));
            }
        }
        setMeasuredDimension(this.euf, this.eug);
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
                        if (!this.euo.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.c.nV(Math.abs(this.index - 3));
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
        j(canvas);
        k(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds42);
        for (int i = 0; i < this.eul.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.eum);
            } else {
                this.paint.setColor(this.eun);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.eul[i], (this.euh * i) + (this.eui / 2), this.euk - dimensionPixelSize, this.paint);
        }
    }

    private void j(Canvas canvas) {
        this.paint.setColor(this.eum);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.eui / 2.0d), this.euk, (float) ((this.index * this.euh) + (this.eui / 2.0d)), this.euk, this.paint);
        this.paint.setColor(this.eun);
        canvas.drawLine((float) ((this.index * this.euh) + (this.eui / 2.0d)), this.euk, (float) (this.euf - (this.eui / 2.0d)), this.euk, this.paint);
    }

    private void k(Canvas canvas) {
        Rect rect = (Rect) x.c(this.euo, this.index);
        if (rect != null && this.cGe != null) {
            this.cGe.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.cGe.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cGe != null) {
            this.cGe.setCallback(null);
            this.cGe = null;
        }
    }
}
