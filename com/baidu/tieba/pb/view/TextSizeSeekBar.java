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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class TextSizeSeekBar extends View {
    private int awi;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable ehb;
    private int fPj;
    private int fPk;
    private int fPl;
    private int fPm;
    private int fPn;
    private int fPo;
    private String[] fPp;
    private int fPq;
    private int fPr;
    private ArrayList<Rect> fPs;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fPs = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fPs = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fPs = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds48);
        init(context);
    }

    private void init(Context context) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds54);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ehb = am.getDrawable(f.C0146f.wordsize);
        this.fPm = dimensionPixelSize;
        this.fPn = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds28);
        this.fPp = new String[]{context.getString(f.j.font_size_small), context.getString(f.j.font_size_mid), context.getString(f.j.font_size_big), context.getString(f.j.font_size_xlarge)};
        this.fPq = am.getColor(f.d.cp_cont_f);
        this.fPr = am.getColor(f.d.cp_cont_d);
        this.awi = am.getColor(f.d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.ehb = am.getDrawable(f.C0146f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fPj == 0 || this.fPk == 0) {
            this.fPj = View.MeasureSpec.getSize(i);
            this.fPk = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.ds176);
            this.fPl = (this.fPj - this.fPm) / 3;
            this.fPo = this.fPk / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fPs.add(new Rect(this.fPl * i3, this.fPo - (this.fPn / 2), (this.fPl * i3) + this.fPm, this.fPo + (this.fPn / 2)));
            }
        }
        setMeasuredDimension(this.fPj, this.fPk);
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
                        if (!this.fPs.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.qn(Math.abs(this.index - 3));
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
        x(canvas);
        z(canvas);
        A(canvas);
    }

    private void x(Canvas canvas) {
        for (int i = 0; i < this.fPp.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.fPq);
            } else {
                this.paint.setColor(this.fPr);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fPp[i], (this.fPl * i) + (this.fPm / 2), this.fPo - this.ds48, this.paint);
        }
    }

    private void z(Canvas canvas) {
        this.paint.setColor(this.awi);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.fPm / 2.0d), this.fPo, (float) (this.fPj - (this.fPm / 2.0d)), this.fPo, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.fPl * i) + (this.fPm / 2), this.fPo, this.paint);
        }
    }

    private void A(Canvas canvas) {
        Rect rect = (Rect) w.d(this.fPs, this.index);
        if (rect != null && this.ehb != null) {
            this.ehb.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.ehb.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ehb != null) {
            this.ehb.setCallback(null);
            this.ehb = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.ehb != null) {
                this.ehb = am.getDrawable(f.C0146f.wordsize);
            }
            this.fPq = am.getColor(f.d.cp_cont_f);
            this.fPr = am.getColor(f.d.cp_cont_d);
            this.awi = am.getColor(f.d.cp_cont_e);
            invalidate();
        }
    }
}
