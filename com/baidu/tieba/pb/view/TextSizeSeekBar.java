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
    private Drawable dNb;
    private int ds12;
    private int ds3;
    private int ds48;
    private int fyE;
    private int fyF;
    private int fyG;
    private int fyH;
    private int fyI;
    private int fyJ;
    private String[] fyK;
    private int fyL;
    private int fyM;
    private ArrayList<Rect> fyN;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fyN = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fyN = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fyN = new ArrayList<>(4);
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
        this.dNb = ak.getDrawable(d.f.wordsize);
        this.fyH = dimensionPixelSize;
        this.fyI = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.fyK = new String[]{context.getString(d.k.font_size_small), context.getString(d.k.font_size_mid), context.getString(d.k.font_size_big), context.getString(d.k.font_size_xlarge)};
        this.fyL = ak.getColor(d.C0126d.cp_cont_f);
        this.fyM = ak.getColor(d.C0126d.cp_cont_d);
        this.anO = ak.getColor(d.C0126d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.dNb = ak.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fyE == 0 || this.fyF == 0) {
            this.fyE = View.MeasureSpec.getSize(i);
            this.fyF = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.fyG = (this.fyE - this.fyH) / 3;
            this.fyJ = this.fyF / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fyN.add(new Rect(this.fyG * i3, this.fyJ - (this.fyI / 2), (this.fyG * i3) + this.fyH, this.fyJ + (this.fyI / 2)));
            }
        }
        setMeasuredDimension(this.fyE, this.fyF);
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
                        if (!this.fyN.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.pY(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.fyK.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.fyL);
            } else {
                this.paint.setColor(this.fyM);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fyK[i], (this.fyG * i) + (this.fyH / 2), this.fyJ - this.ds48, this.paint);
        }
    }

    private void x(Canvas canvas) {
        this.paint.setColor(this.anO);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.fyH / 2.0d), this.fyJ, (float) (this.fyE - (this.fyH / 2.0d)), this.fyJ, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.fyG * i) + (this.fyH / 2), this.fyJ, this.paint);
        }
    }

    private void y(Canvas canvas) {
        Rect rect = (Rect) v.c(this.fyN, this.index);
        if (rect != null && this.dNb != null) {
            this.dNb.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.dNb.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dNb != null) {
            this.dNb.setCallback(null);
            this.dNb = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.dNb != null) {
                this.dNb = ak.getDrawable(d.f.wordsize);
            }
            this.fyL = ak.getColor(d.C0126d.cp_cont_f);
            this.fyM = ak.getColor(d.C0126d.cp_cont_d);
            this.anO = ak.getColor(d.C0126d.cp_cont_e);
            invalidate();
        }
    }
}
