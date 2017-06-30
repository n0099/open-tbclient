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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable cTz;
    private int eMQ;
    private int eMR;
    private int eMS;
    private int eMT;
    private int eMU;
    private int eMV;
    private String[] eMW;
    private int eMX;
    private int eMY;
    private ArrayList<Rect> eMZ;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.eMZ = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.eMZ = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.eMZ = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.cTz = as.getDrawable(w.g.btn_recommend_size_handle);
        this.eMT = this.cTz.getIntrinsicWidth();
        this.eMU = this.cTz.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds24);
        this.eMW = new String[]{context.getString(w.l.font_size_small), context.getString(w.l.font_size_mid), context.getString(w.l.font_size_big), context.getString(w.l.font_size_xlarge)};
        this.eMX = as.getColor(w.e.cp_link_tip_a);
        this.eMY = as.getColor(w.e.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.cTz = as.getDrawable(w.g.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.eMQ == 0 || this.eMR == 0) {
            this.eMQ = View.MeasureSpec.getSize(i);
            this.eMR = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds184);
            this.eMS = (this.eMQ - this.eMT) / 3;
            this.eMV = this.eMR / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.eMZ.add(new Rect(this.eMS * i3, this.eMV - (this.eMU / 2), (this.eMS * i3) + this.eMT, this.eMV + (this.eMU / 2)));
            }
        }
        setMeasuredDimension(this.eMQ, this.eMR);
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
                        if (!this.eMZ.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.c.oE(Math.abs(this.index - 3));
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
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds42);
        for (int i = 0; i < this.eMW.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.eMX);
            } else {
                this.paint.setColor(this.eMY);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.eMW[i], (this.eMS * i) + (this.eMT / 2), this.eMV - dimensionPixelSize, this.paint);
        }
    }

    private void u(Canvas canvas) {
        this.paint.setColor(this.eMX);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.eMT / 2.0d), this.eMV, (float) ((this.index * this.eMS) + (this.eMT / 2.0d)), this.eMV, this.paint);
        this.paint.setColor(this.eMY);
        canvas.drawLine((float) ((this.index * this.eMS) + (this.eMT / 2.0d)), this.eMV, (float) (this.eMQ - (this.eMT / 2.0d)), this.eMV, this.paint);
    }

    private void v(Canvas canvas) {
        Rect rect = (Rect) com.baidu.tbadk.core.util.z.c(this.eMZ, this.index);
        if (rect != null && this.cTz != null) {
            this.cTz.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.cTz.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cTz != null) {
            this.cTz.setCallback(null);
            this.cTz = null;
        }
    }
}
