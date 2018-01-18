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
    private int baF;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable enD;
    private int gaN;
    private int gaO;
    private int gaP;
    private int gaQ;
    private int gaR;
    private int gaS;
    private String[] gaT;
    private int gaU;
    private int gaV;
    private ArrayList<Rect> gaW;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.gaW = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.gaW = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.gaW = new ArrayList<>(4);
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
        this.enD = aj.getDrawable(d.f.wordsize);
        this.gaQ = dimensionPixelSize;
        this.gaR = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.gaT = new String[]{context.getString(d.j.font_size_small), context.getString(d.j.font_size_mid), context.getString(d.j.font_size_big), context.getString(d.j.font_size_xlarge)};
        this.gaU = aj.getColor(d.C0107d.cp_cont_f);
        this.gaV = aj.getColor(d.C0107d.cp_cont_d);
        this.baF = aj.getColor(d.C0107d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.enD = aj.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.gaN == 0 || this.gaO == 0) {
            this.gaN = View.MeasureSpec.getSize(i);
            this.gaO = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.gaP = (this.gaN - this.gaQ) / 3;
            this.gaS = this.gaO / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.gaW.add(new Rect(this.gaP * i3, this.gaS - (this.gaR / 2), (this.gaP * i3) + this.gaQ, this.gaS + (this.gaR / 2)));
            }
        }
        setMeasuredDimension(this.gaN, this.gaO);
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
                        if (!this.gaW.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.sA(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.gaT.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.gaU);
            } else {
                this.paint.setColor(this.gaV);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.gaT[i], (this.gaP * i) + (this.gaQ / 2), this.gaS - this.ds48, this.paint);
        }
    }

    private void A(Canvas canvas) {
        this.paint.setColor(this.baF);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.gaQ / 2.0d), this.gaS, (float) (this.gaN - (this.gaQ / 2.0d)), this.gaS, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.gaP * i) + (this.gaQ / 2), this.gaS, this.paint);
        }
    }

    private void B(Canvas canvas) {
        Rect rect = (Rect) v.f(this.gaW, this.index);
        if (rect != null && this.enD != null) {
            this.enD.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.enD.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.enD != null) {
            this.enD.setCallback(null);
            this.enD = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.enD != null) {
                this.enD = aj.getDrawable(d.f.wordsize);
            }
            this.gaU = aj.getColor(d.C0107d.cp_cont_f);
            this.gaV = aj.getColor(d.C0107d.cp_cont_d);
            this.baF = aj.getColor(d.C0107d.cp_cont_e);
            invalidate();
        }
    }
}
