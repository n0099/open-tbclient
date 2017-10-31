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
    private int amm;
    private Drawable dqO;
    private int ds12;
    private int ds3;
    private int ds48;
    private int fdT;
    private int fdU;
    private int fdV;
    private int fdW;
    private int fdX;
    private int fdY;
    private String[] fdZ;
    private int fea;
    private int feb;
    private ArrayList<Rect> fec;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fec = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fec = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fec = new ArrayList<>(4);
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
        this.dqO = aj.getDrawable(d.f.wordsize);
        this.fdW = dimensionPixelSize;
        this.fdX = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.fdZ = new String[]{context.getString(d.j.font_size_small), context.getString(d.j.font_size_mid), context.getString(d.j.font_size_big), context.getString(d.j.font_size_xlarge)};
        this.fea = aj.getColor(d.C0080d.cp_cont_f);
        this.feb = aj.getColor(d.C0080d.cp_cont_d);
        this.amm = aj.getColor(d.C0080d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.dqO = aj.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fdT == 0 || this.fdU == 0) {
            this.fdT = View.MeasureSpec.getSize(i);
            this.fdU = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.fdV = (this.fdT - this.fdW) / 3;
            this.fdY = this.fdU / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fec.add(new Rect(this.fdV * i3, this.fdY - (this.fdX / 2), (this.fdV * i3) + this.fdW, this.fdY + (this.fdX / 2)));
            }
        }
        setMeasuredDimension(this.fdT, this.fdU);
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
                        if (!this.fec.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.ps(Math.abs(this.index - 3));
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
        w(canvas);
        x(canvas);
    }

    private void drawText(Canvas canvas) {
        for (int i = 0; i < this.fdZ.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.fea);
            } else {
                this.paint.setColor(this.feb);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fdZ[i], (this.fdV * i) + (this.fdW / 2), this.fdY - this.ds48, this.paint);
        }
    }

    private void w(Canvas canvas) {
        this.paint.setColor(this.amm);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.fdW / 2.0d), this.fdY, (float) (this.fdT - (this.fdW / 2.0d)), this.fdY, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.fdV * i) + (this.fdW / 2), this.fdY, this.paint);
        }
    }

    private void x(Canvas canvas) {
        Rect rect = (Rect) v.c(this.fec, this.index);
        if (rect != null && this.dqO != null) {
            this.dqO.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.dqO.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dqO != null) {
            this.dqO.setCallback(null);
            this.dqO = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.dqO != null) {
                this.dqO = aj.getDrawable(d.f.wordsize);
            }
            this.fea = aj.getColor(d.C0080d.cp_cont_f);
            this.feb = aj.getColor(d.C0080d.cp_cont_d);
            this.amm = aj.getColor(d.C0080d.cp_cont_e);
            invalidate();
        }
    }
}
