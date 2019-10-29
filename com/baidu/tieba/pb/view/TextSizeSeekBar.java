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
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class TextSizeSeekBar extends View {
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable gwb;
    private int ign;
    private int igo;
    private int igp;
    private int igq;
    private int igr;
    private int igs;
    private String[] igt;
    private int igu;
    private int igv;
    private ArrayList<Rect> igw;
    private int index;
    private int lineColor;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.igw = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.igw = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.igw = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    private void init(Context context) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds54);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.gwb = am.getDrawable(R.drawable.pic_wordsize_n);
        this.igq = dimensionPixelSize;
        this.igr = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
        this.igt = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.igu = am.getColor(R.color.cp_cont_f);
        this.igv = am.getColor(R.color.cp_cont_d);
        this.lineColor = am.getColor(R.color.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.gwb = am.getDrawable(R.drawable.pic_wordsize_n);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ign == 0 || this.igo == 0) {
            this.ign = View.MeasureSpec.getSize(i);
            this.igo = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.igp = (this.ign - this.igq) / 3;
            this.igs = this.igo / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.igw.add(new Rect(this.igp * i3, this.igs - (this.igr / 2), (this.igp * i3) + this.igq, this.igs + (this.igr / 2)));
            }
        }
        setMeasuredDimension(this.ign, this.igo);
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
                        if (!this.igw.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.wp(Math.abs(this.index - 3));
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
        G(canvas);
        R(canvas);
        S(canvas);
    }

    private void G(Canvas canvas) {
        for (int i = 0; i < this.igt.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.igu);
            } else {
                this.paint.setColor(this.igv);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.igt[i], (this.igp * i) + (this.igq / 2), this.igs - this.ds48, this.paint);
        }
    }

    private void R(Canvas canvas) {
        this.paint.setColor(this.lineColor);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.igq / 2.0d), this.igs, (float) (this.ign - (this.igq / 2.0d)), this.igs, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.igp * i) + (this.igq / 2), this.igs, this.paint);
        }
    }

    private void S(Canvas canvas) {
        Rect rect = (Rect) v.getItem(this.igw, this.index);
        if (rect != null && this.gwb != null) {
            this.gwb.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.gwb.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gwb != null) {
            this.gwb.setCallback(null);
            this.gwb = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.gwb != null) {
                this.gwb = am.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.igu = am.getColor(R.color.cp_cont_f);
            this.igv = am.getColor(R.color.cp_cont_d);
            this.lineColor = am.getColor(R.color.cp_cont_e);
            invalidate();
        }
    }
}
