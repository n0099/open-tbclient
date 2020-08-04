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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class TextSizeSeekBar extends View {
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable iNj;
    private int index;
    private int kKA;
    private int kKB;
    private String[] kKC;
    private int kKD;
    private int kKE;
    private ArrayList<Rect> kKF;
    private int kKw;
    private int kKx;
    private int kKy;
    private int kKz;
    private int lineColor;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.kKF = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.kKF = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.kKF = new ArrayList<>(4);
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
        this.iNj = ao.getDrawable(R.drawable.pic_wordsize_n);
        this.kKz = dimensionPixelSize;
        this.kKA = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
        this.kKC = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.kKD = ao.getColor(R.color.cp_cont_f);
        this.kKE = ao.getColor(R.color.cp_cont_d);
        this.lineColor = ao.getColor(R.color.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.iNj = ao.getDrawable(R.drawable.pic_wordsize_n);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.kKw == 0 || this.kKx == 0) {
            this.kKw = View.MeasureSpec.getSize(i);
            this.kKx = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.kKy = (this.kKw - this.kKz) / 3;
            this.kKB = this.kKx / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.kKF.add(new Rect(this.kKy * i3, this.kKB - (this.kKA / 2), (this.kKy * i3) + this.kKz, this.kKB + (this.kKA / 2)));
            }
        }
        setMeasuredDimension(this.kKw, this.kKx);
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
                        if (!this.kKF.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.Bz(Math.abs(this.index - 3));
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
        W(canvas);
        X(canvas);
    }

    private void G(Canvas canvas) {
        for (int i = 0; i < this.kKC.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.kKD);
            } else {
                this.paint.setColor(this.kKE);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.kKC[i], (this.kKy * i) + (this.kKz / 2), this.kKB - this.ds48, this.paint);
        }
    }

    private void W(Canvas canvas) {
        this.paint.setColor(this.lineColor);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.kKz / 2.0d), this.kKB, (float) (this.kKw - (this.kKz / 2.0d)), this.kKB, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.kKy * i) + (this.kKz / 2), this.kKB, this.paint);
        }
    }

    private void X(Canvas canvas) {
        Rect rect = (Rect) x.getItem(this.kKF, this.index);
        if (rect != null && this.iNj != null) {
            this.iNj.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.iNj.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.iNj != null) {
            this.iNj.setCallback(null);
            this.iNj = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.iNj != null) {
                this.iNj = ao.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.kKD = ao.getColor(R.color.cp_cont_f);
            this.kKE = ao.getColor(R.color.cp_cont_d);
            this.lineColor = ao.getColor(R.color.cp_cont_e);
            invalidate();
        }
    }
}
