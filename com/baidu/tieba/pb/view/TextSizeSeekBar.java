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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class TextSizeSeekBar extends View {
    private int anO;
    private Drawable dOi;
    private int ds12;
    private int ds3;
    private int ds48;
    private int fzK;
    private int fzL;
    private int fzM;
    private int fzN;
    private int fzO;
    private int fzP;
    private String[] fzQ;
    private int fzR;
    private int fzS;
    private ArrayList<Rect> fzT;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fzT = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fzT = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fzT = new ArrayList<>(4);
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
        this.dOi = ak.getDrawable(d.f.wordsize);
        this.fzN = dimensionPixelSize;
        this.fzO = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.fzQ = new String[]{context.getString(d.k.font_size_small), context.getString(d.k.font_size_mid), context.getString(d.k.font_size_big), context.getString(d.k.font_size_xlarge)};
        this.fzR = ak.getColor(d.C0126d.cp_cont_f);
        this.fzS = ak.getColor(d.C0126d.cp_cont_d);
        this.anO = ak.getColor(d.C0126d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.dOi = ak.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fzK == 0 || this.fzL == 0) {
            this.fzK = View.MeasureSpec.getSize(i);
            this.fzL = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.fzM = (this.fzK - this.fzN) / 3;
            this.fzP = this.fzL / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fzT.add(new Rect(this.fzM * i3, this.fzP - (this.fzO / 2), (this.fzM * i3) + this.fzN, this.fzP + (this.fzO / 2)));
            }
        }
        setMeasuredDimension(this.fzK, this.fzL);
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
                        if (!this.fzT.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.pX(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.fzQ.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.fzR);
            } else {
                this.paint.setColor(this.fzS);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fzQ[i], (this.fzM * i) + (this.fzN / 2), this.fzP - this.ds48, this.paint);
        }
    }

    private void x(Canvas canvas) {
        this.paint.setColor(this.anO);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.fzN / 2.0d), this.fzP, (float) (this.fzK - (this.fzN / 2.0d)), this.fzP, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.fzM * i) + (this.fzN / 2), this.fzP, this.paint);
        }
    }

    private void y(Canvas canvas) {
        Rect rect = (Rect) v.c(this.fzT, this.index);
        if (rect != null && this.dOi != null) {
            this.dOi.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.dOi.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dOi != null) {
            this.dOi.setCallback(null);
            this.dOi = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.dOi != null) {
                this.dOi = ak.getDrawable(d.f.wordsize);
            }
            this.fzR = ak.getColor(d.C0126d.cp_cont_f);
            this.fzS = ak.getColor(d.C0126d.cp_cont_d);
            this.anO = ak.getColor(d.C0126d.cp_cont_e);
            invalidate();
        }
    }
}
