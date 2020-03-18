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
/* loaded from: classes9.dex */
public class TextSizeSeekBar extends View {
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable hqH;
    private int index;
    private int jeA;
    private int jeB;
    private int jeC;
    private int jeD;
    private String[] jeE;
    private int jeF;
    private int jeG;
    private ArrayList<Rect> jeH;
    private int jey;
    private int jez;
    private int lineColor;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.jeH = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.jeH = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.jeH = new ArrayList<>(4);
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
        this.hqH = am.getDrawable(R.drawable.pic_wordsize_n);
        this.jeB = dimensionPixelSize;
        this.jeC = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
        this.jeE = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.jeF = am.getColor(R.color.cp_cont_f);
        this.jeG = am.getColor(R.color.cp_cont_d);
        this.lineColor = am.getColor(R.color.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.hqH = am.getDrawable(R.drawable.pic_wordsize_n);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.jey == 0 || this.jez == 0) {
            this.jey = View.MeasureSpec.getSize(i);
            this.jez = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.jeA = (this.jey - this.jeB) / 3;
            this.jeD = this.jez / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.jeH.add(new Rect(this.jeA * i3, this.jeD - (this.jeC / 2), (this.jeA * i3) + this.jeB, this.jeD + (this.jeC / 2)));
            }
        }
        setMeasuredDimension(this.jey, this.jez);
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
                        if (!this.jeH.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.yL(Math.abs(this.index - 3));
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
        D(canvas);
        P(canvas);
        Q(canvas);
    }

    private void D(Canvas canvas) {
        for (int i = 0; i < this.jeE.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.jeF);
            } else {
                this.paint.setColor(this.jeG);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.jeE[i], (this.jeA * i) + (this.jeB / 2), this.jeD - this.ds48, this.paint);
        }
    }

    private void P(Canvas canvas) {
        this.paint.setColor(this.lineColor);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.jeB / 2.0d), this.jeD, (float) (this.jey - (this.jeB / 2.0d)), this.jeD, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.jeA * i) + (this.jeB / 2), this.jeD, this.paint);
        }
    }

    private void Q(Canvas canvas) {
        Rect rect = (Rect) v.getItem(this.jeH, this.index);
        if (rect != null && this.hqH != null) {
            this.hqH.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.hqH.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.hqH != null) {
            this.hqH.setCallback(null);
            this.hqH = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.hqH != null) {
                this.hqH = am.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.jeF = am.getColor(R.color.cp_cont_f);
            this.jeG = am.getColor(R.color.cp_cont_d);
            this.lineColor = am.getColor(R.color.cp_cont_e);
            invalidate();
        }
    }
}
