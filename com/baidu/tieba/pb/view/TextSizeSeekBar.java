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
    private Drawable dNe;
    private int ds12;
    private int ds3;
    private int ds48;
    private int fyH;
    private int fyI;
    private int fyJ;
    private int fyK;
    private int fyL;
    private int fyM;
    private String[] fyN;
    private int fyO;
    private int fyP;
    private ArrayList<Rect> fyQ;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fyQ = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fyQ = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fyQ = new ArrayList<>(4);
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
        this.dNe = ak.getDrawable(d.f.wordsize);
        this.fyK = dimensionPixelSize;
        this.fyL = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.fyN = new String[]{context.getString(d.k.font_size_small), context.getString(d.k.font_size_mid), context.getString(d.k.font_size_big), context.getString(d.k.font_size_xlarge)};
        this.fyO = ak.getColor(d.C0126d.cp_cont_f);
        this.fyP = ak.getColor(d.C0126d.cp_cont_d);
        this.anO = ak.getColor(d.C0126d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.dNe = ak.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fyH == 0 || this.fyI == 0) {
            this.fyH = View.MeasureSpec.getSize(i);
            this.fyI = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.fyJ = (this.fyH - this.fyK) / 3;
            this.fyM = this.fyI / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fyQ.add(new Rect(this.fyJ * i3, this.fyM - (this.fyL / 2), (this.fyJ * i3) + this.fyK, this.fyM + (this.fyL / 2)));
            }
        }
        setMeasuredDimension(this.fyH, this.fyI);
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
                        if (!this.fyQ.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
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
        for (int i = 0; i < this.fyN.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.fyO);
            } else {
                this.paint.setColor(this.fyP);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fyN[i], (this.fyJ * i) + (this.fyK / 2), this.fyM - this.ds48, this.paint);
        }
    }

    private void x(Canvas canvas) {
        this.paint.setColor(this.anO);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.fyK / 2.0d), this.fyM, (float) (this.fyH - (this.fyK / 2.0d)), this.fyM, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.fyJ * i) + (this.fyK / 2), this.fyM, this.paint);
        }
    }

    private void y(Canvas canvas) {
        Rect rect = (Rect) v.c(this.fyQ, this.index);
        if (rect != null && this.dNe != null) {
            this.dNe.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.dNe.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dNe != null) {
            this.dNe.setCallback(null);
            this.dNe = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.dNe != null) {
                this.dNe = ak.getDrawable(d.f.wordsize);
            }
            this.fyO = ak.getColor(d.C0126d.cp_cont_f);
            this.fyP = ak.getColor(d.C0126d.cp_cont_d);
            this.anO = ak.getColor(d.C0126d.cp_cont_e);
            invalidate();
        }
    }
}
