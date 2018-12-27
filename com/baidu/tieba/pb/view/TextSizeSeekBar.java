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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class TextSizeSeekBar extends View {
    private int aIs;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable eHr;
    private int gpf;
    private int gpg;
    private int gph;
    private int gpi;
    private int gpj;
    private int gpk;
    private String[] gpl;
    private int gpm;
    private int gpn;
    private ArrayList<Rect> gpo;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.gpo = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.gpo = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.gpo = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds48);
        init(context);
    }

    private void init(Context context) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds54);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.eHr = al.getDrawable(e.f.wordsize);
        this.gpi = dimensionPixelSize;
        this.gpj = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds28);
        this.gpl = new String[]{context.getString(e.j.font_size_small), context.getString(e.j.font_size_mid), context.getString(e.j.font_size_big), context.getString(e.j.font_size_xlarge)};
        this.gpm = al.getColor(e.d.cp_cont_f);
        this.gpn = al.getColor(e.d.cp_cont_d);
        this.aIs = al.getColor(e.d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.eHr = al.getDrawable(e.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.gpf == 0 || this.gpg == 0) {
            this.gpf = View.MeasureSpec.getSize(i);
            this.gpg = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds176);
            this.gph = (this.gpf - this.gpi) / 3;
            this.gpk = this.gpg / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.gpo.add(new Rect(this.gph * i3, this.gpk - (this.gpj / 2), (this.gph * i3) + this.gpi, this.gpk + (this.gpj / 2)));
            }
        }
        setMeasuredDimension(this.gpf, this.gpg);
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
                        if (!this.gpo.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.sm(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.gpl.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.gpm);
            } else {
                this.paint.setColor(this.gpn);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.gpl[i], (this.gph * i) + (this.gpi / 2), this.gpk - this.ds48, this.paint);
        }
    }

    private void z(Canvas canvas) {
        this.paint.setColor(this.aIs);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.gpi / 2.0d), this.gpk, (float) (this.gpf - (this.gpi / 2.0d)), this.gpk, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.gph * i) + (this.gpi / 2), this.gpk, this.paint);
        }
    }

    private void A(Canvas canvas) {
        Rect rect = (Rect) v.d(this.gpo, this.index);
        if (rect != null && this.eHr != null) {
            this.eHr.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.eHr.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eHr != null) {
            this.eHr.setCallback(null);
            this.eHr = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.eHr != null) {
                this.eHr = al.getDrawable(e.f.wordsize);
            }
            this.gpm = al.getColor(e.d.cp_cont_f);
            this.gpn = al.getColor(e.d.cp_cont_d);
            this.aIs = al.getColor(e.d.cp_cont_e);
            invalidate();
        }
    }
}
