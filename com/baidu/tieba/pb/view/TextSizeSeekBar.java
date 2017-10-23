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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable diY;
    private int eVF;
    private int eVG;
    private int eVH;
    private int eVI;
    private int eVJ;
    private int eVK;
    private String[] eVL;
    private int eVM;
    private int eVN;
    private ArrayList<Rect> eVO;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.eVO = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.eVO = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.eVO = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.diY = aj.getDrawable(d.g.btn_recommend_size_handle);
        this.eVI = this.diY.getIntrinsicWidth();
        this.eVJ = this.diY.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds24);
        this.eVL = new String[]{context.getString(d.l.font_size_small), context.getString(d.l.font_size_mid), context.getString(d.l.font_size_big), context.getString(d.l.font_size_xlarge)};
        this.eVM = aj.getColor(d.e.cp_link_tip_a);
        this.eVN = aj.getColor(d.e.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.diY = aj.getDrawable(d.g.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.eVF == 0 || this.eVG == 0) {
            this.eVF = View.MeasureSpec.getSize(i);
            this.eVG = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds184);
            this.eVH = (this.eVF - this.eVI) / 3;
            this.eVK = this.eVG / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.eVO.add(new Rect(this.eVH * i3, this.eVK - (this.eVJ / 2), (this.eVH * i3) + this.eVI, this.eVK + (this.eVJ / 2)));
            }
        }
        setMeasuredDimension(this.eVF, this.eVG);
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
                        if (!this.eVO.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.oY(Math.abs(this.index - 3));
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
        x(canvas);
        y(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds42);
        for (int i = 0; i < this.eVL.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.eVM);
            } else {
                this.paint.setColor(this.eVN);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.eVL[i], (this.eVH * i) + (this.eVI / 2), this.eVK - dimensionPixelSize, this.paint);
        }
    }

    private void x(Canvas canvas) {
        this.paint.setColor(this.eVM);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.eVI / 2.0d), this.eVK, (float) ((this.index * this.eVH) + (this.eVI / 2.0d)), this.eVK, this.paint);
        this.paint.setColor(this.eVN);
        canvas.drawLine((float) ((this.index * this.eVH) + (this.eVI / 2.0d)), this.eVK, (float) (this.eVF - (this.eVI / 2.0d)), this.eVK, this.paint);
    }

    private void y(Canvas canvas) {
        Rect rect = (Rect) v.c(this.eVO, this.index);
        if (rect != null && this.diY != null) {
            this.diY.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.diY.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.diY != null) {
            this.diY.setCallback(null);
            this.diY = null;
        }
    }
}
