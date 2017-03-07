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
    private Drawable cLj;
    private int exZ;
    private int eya;
    private int eyb;
    private int eyc;
    private int eyd;
    private int eye;
    private String[] eyf;
    private int eyg;
    private int eyh;
    private ArrayList<Rect> eyi;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.eyi = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.eyi = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.eyi = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.cLj = aq.getDrawable(w.g.btn_recommend_size_handle);
        this.eyc = this.cLj.getIntrinsicWidth();
        this.eyd = this.cLj.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds24);
        this.eyf = new String[]{context.getString(w.l.font_size_small), context.getString(w.l.font_size_mid), context.getString(w.l.font_size_big), context.getString(w.l.font_size_xlarge)};
        this.eyg = aq.getColor(w.e.cp_link_tip_a);
        this.eyh = aq.getColor(w.e.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.cLj = aq.getDrawable(w.g.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.exZ == 0 || this.eya == 0) {
            this.exZ = View.MeasureSpec.getSize(i);
            this.eya = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds184);
            this.eyb = (this.exZ - this.eyc) / 3;
            this.eye = this.eya / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.eyi.add(new Rect(this.eyb * i3, this.eye - (this.eyd / 2), (this.eyb * i3) + this.eyc, this.eye + (this.eyd / 2)));
            }
        }
        setMeasuredDimension(this.exZ, this.eya);
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
                        if (!this.eyi.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.c.ob(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.eyf.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.eyg);
            } else {
                this.paint.setColor(this.eyh);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.eyf[i], (this.eyb * i) + (this.eyc / 2), this.eye - dimensionPixelSize, this.paint);
        }
    }

    private void j(Canvas canvas) {
        this.paint.setColor(this.eyg);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.eyc / 2.0d), this.eye, (float) ((this.index * this.eyb) + (this.eyc / 2.0d)), this.eye, this.paint);
        this.paint.setColor(this.eyh);
        canvas.drawLine((float) ((this.index * this.eyb) + (this.eyc / 2.0d)), this.eye, (float) (this.exZ - (this.eyc / 2.0d)), this.eye, this.paint);
    }

    private void k(Canvas canvas) {
        Rect rect = (Rect) x.c(this.eyi, this.index);
        if (rect != null && this.cLj != null) {
            this.cLj.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.cLj.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cLj != null) {
            this.cLj.setCallback(null);
            this.cLj = null;
        }
    }
}
