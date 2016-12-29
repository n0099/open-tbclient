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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable cCI;
    private int ekH;
    private int ekI;
    private int ekJ;
    private int ekK;
    private int ekL;
    private int ekM;
    private String[] ekN;
    private int ekO;
    private int ekP;
    private ArrayList<Rect> ekQ;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.ekQ = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.ekQ = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.ekQ = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.cCI = ar.getDrawable(r.f.btn_recommend_size_handle);
        this.ekK = this.cCI.getIntrinsicWidth();
        this.ekL = this.cCI.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds24);
        this.ekN = new String[]{context.getString(r.j.font_size_small), context.getString(r.j.font_size_mid), context.getString(r.j.font_size_big), context.getString(r.j.font_size_xlarge)};
        this.ekO = ar.getColor(r.d.cp_link_tip_a);
        this.ekP = ar.getColor(r.d.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.cCI = ar.getDrawable(r.f.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ekH == 0 || this.ekI == 0) {
            this.ekH = View.MeasureSpec.getSize(i);
            this.ekI = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds184);
            this.ekJ = (this.ekH - this.ekK) / 3;
            this.ekM = this.ekI / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.ekQ.add(new Rect(this.ekJ * i3, this.ekM - (this.ekL / 2), (this.ekJ * i3) + this.ekK, this.ekM + (this.ekL / 2)));
            }
        }
        setMeasuredDimension(this.ekH, this.ekI);
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
                        if (!this.ekQ.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.c.nv(Math.abs(this.index - 3));
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
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds42);
        for (int i = 0; i < this.ekN.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.ekO);
            } else {
                this.paint.setColor(this.ekP);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.ekN[i], (this.ekJ * i) + (this.ekK / 2), this.ekM - dimensionPixelSize, this.paint);
        }
    }

    private void u(Canvas canvas) {
        this.paint.setColor(this.ekO);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.ekK / 2.0d), this.ekM, (float) ((this.index * this.ekJ) + (this.ekK / 2.0d)), this.ekM, this.paint);
        this.paint.setColor(this.ekP);
        canvas.drawLine((float) ((this.index * this.ekJ) + (this.ekK / 2.0d)), this.ekM, (float) (this.ekH - (this.ekK / 2.0d)), this.ekM, this.paint);
    }

    private void v(Canvas canvas) {
        Rect rect = (Rect) x.c(this.ekQ, this.index);
        if (rect != null && this.cCI != null) {
            this.cCI.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.cCI.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cCI != null) {
            this.cCI.setCallback(null);
            this.cCI = null;
        }
    }
}
