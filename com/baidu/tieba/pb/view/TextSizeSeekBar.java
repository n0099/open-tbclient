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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable cJP;
    private int euC;
    private int euD;
    private int euE;
    private int euF;
    private int euG;
    private int euH;
    private String[] euI;
    private int euJ;
    private int euK;
    private ArrayList<Rect> euL;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.euL = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.euL = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.euL = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.cJP = ap.getDrawable(r.g.btn_recommend_size_handle);
        this.euF = this.cJP.getIntrinsicWidth();
        this.euG = this.cJP.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.f.ds24);
        this.euI = new String[]{context.getString(r.l.font_size_small), context.getString(r.l.font_size_mid), context.getString(r.l.font_size_big), context.getString(r.l.font_size_xlarge)};
        this.euJ = ap.getColor(r.e.cp_link_tip_a);
        this.euK = ap.getColor(r.e.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.cJP = ap.getDrawable(r.g.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.euC == 0 || this.euD == 0) {
            this.euC = View.MeasureSpec.getSize(i);
            this.euD = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.f.ds184);
            this.euE = (this.euC - this.euF) / 3;
            this.euH = this.euD / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.euL.add(new Rect(this.euE * i3, this.euH - (this.euG / 2), (this.euE * i3) + this.euF, this.euH + (this.euG / 2)));
            }
        }
        setMeasuredDimension(this.euC, this.euD);
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
                        if (!this.euL.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.c.on(Math.abs(this.index - 3));
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
        m(canvas);
        n(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.f.ds42);
        for (int i = 0; i < this.euI.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.euJ);
            } else {
                this.paint.setColor(this.euK);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.euI[i], (this.euE * i) + (this.euF / 2), this.euH - dimensionPixelSize, this.paint);
        }
    }

    private void m(Canvas canvas) {
        this.paint.setColor(this.euJ);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.euF / 2.0d), this.euH, (float) ((this.index * this.euE) + (this.euF / 2.0d)), this.euH, this.paint);
        this.paint.setColor(this.euK);
        canvas.drawLine((float) ((this.index * this.euE) + (this.euF / 2.0d)), this.euH, (float) (this.euC - (this.euF / 2.0d)), this.euH, this.paint);
    }

    private void n(Canvas canvas) {
        Rect rect = (Rect) w.c(this.euL, this.index);
        if (rect != null && this.cJP != null) {
            this.cJP.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.cJP.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cJP != null) {
            this.cJP.setCallback(null);
            this.cJP = null;
        }
    }
}
