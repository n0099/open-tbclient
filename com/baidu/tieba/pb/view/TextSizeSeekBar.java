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
/* loaded from: classes2.dex */
public class TextSizeSeekBar extends View {
    private int bcv;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable esp;
    private int geA;
    private ArrayList<Rect> geB;
    private int ges;
    private int get;
    private int geu;
    private int gev;
    private int gew;
    private int gex;
    private String[] gey;
    private int gez;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.geB = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.geB = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.geB = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    private void init(Context context) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds54);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.esp = aj.getDrawable(d.f.wordsize);
        this.gev = dimensionPixelSize;
        this.gew = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.gey = new String[]{context.getString(d.j.font_size_small), context.getString(d.j.font_size_mid), context.getString(d.j.font_size_big), context.getString(d.j.font_size_xlarge)};
        this.gez = aj.getColor(d.C0141d.cp_cont_f);
        this.geA = aj.getColor(d.C0141d.cp_cont_d);
        this.bcv = aj.getColor(d.C0141d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.esp = aj.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ges == 0 || this.get == 0) {
            this.ges = View.MeasureSpec.getSize(i);
            this.get = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.geu = (this.ges - this.gev) / 3;
            this.gex = this.get / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.geB.add(new Rect(this.geu * i3, this.gex - (this.gew / 2), (this.geu * i3) + this.gev, this.gex + (this.gew / 2)));
            }
        }
        setMeasuredDimension(this.ges, this.get);
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
                        if (!this.geB.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.sE(Math.abs(this.index - 3));
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
        A(canvas);
        B(canvas);
    }

    private void drawText(Canvas canvas) {
        for (int i = 0; i < this.gey.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.gez);
            } else {
                this.paint.setColor(this.geA);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.gey[i], (this.geu * i) + (this.gev / 2), this.gex - this.ds48, this.paint);
        }
    }

    private void A(Canvas canvas) {
        this.paint.setColor(this.bcv);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.gev / 2.0d), this.gex, (float) (this.ges - (this.gev / 2.0d)), this.gex, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.geu * i) + (this.gev / 2), this.gex, this.paint);
        }
    }

    private void B(Canvas canvas) {
        Rect rect = (Rect) v.f(this.geB, this.index);
        if (rect != null && this.esp != null) {
            this.esp.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.esp.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.esp != null) {
            this.esp.setCallback(null);
            this.esp = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.esp != null) {
                this.esp = aj.getDrawable(d.f.wordsize);
            }
            this.gez = aj.getColor(d.C0141d.cp_cont_f);
            this.geA = aj.getColor(d.C0141d.cp_cont_d);
            this.bcv = aj.getColor(d.C0141d.cp_cont_e);
            invalidate();
        }
    }
}
