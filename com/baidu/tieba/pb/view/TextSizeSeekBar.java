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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class TextSizeSeekBar extends View {
    private int ds12;
    private int ds3;
    private int ds48;
    private int index;
    private Drawable jSn;
    private int lQU;
    private int lQV;
    private int lQW;
    private int lQX;
    private int lQY;
    private int lQZ;
    private String[] lRa;
    private int lRb;
    private int lRc;
    private ArrayList<Rect> lRd;
    private int lineColor;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.lRd = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.lRd = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.lRd = new ArrayList<>(4);
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
        this.jSn = ap.getDrawable(R.drawable.pic_wordsize_n);
        this.lQX = dimensionPixelSize;
        this.lQY = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
        this.lRa = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.lRb = ap.getColor(R.color.cp_cont_f);
        this.lRc = ap.getColor(R.color.cp_cont_d);
        this.lineColor = ap.getColor(R.color.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.jSn = ap.getDrawable(R.drawable.pic_wordsize_n);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.lQU == 0 || this.lQV == 0) {
            this.lQU = View.MeasureSpec.getSize(i);
            this.lQV = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.lQW = (this.lQU - this.lQX) / 3;
            this.lQZ = this.lQV / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.lRd.add(new Rect(this.lQW * i3, this.lQZ - (this.lQY / 2), (this.lQW * i3) + this.lQX, this.lQZ + (this.lQY / 2)));
            }
        }
        setMeasuredDimension(this.lQU, this.lQV);
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
                        if (!this.lRd.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.FF(Math.abs(this.index - 3));
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
        C(canvas);
        o(canvas);
        ae(canvas);
    }

    private void C(Canvas canvas) {
        for (int i = 0; i < this.lRa.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.lRb);
            } else {
                this.paint.setColor(this.lRc);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.lRa[i], (this.lQW * i) + (this.lQX / 2), this.lQZ - this.ds48, this.paint);
        }
    }

    private void o(Canvas canvas) {
        this.paint.setColor(this.lineColor);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.lQX / 2.0d), this.lQZ, (float) (this.lQU - (this.lQX / 2.0d)), this.lQZ, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.lQW * i) + (this.lQX / 2), this.lQZ, this.paint);
        }
    }

    private void ae(Canvas canvas) {
        Rect rect = (Rect) y.getItem(this.lRd, this.index);
        if (rect != null && this.jSn != null) {
            this.jSn.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.jSn.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.jSn != null) {
            this.jSn.setCallback(null);
            this.jSn = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.jSn != null) {
                this.jSn = ap.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.lRb = ap.getColor(R.color.cp_cont_f);
            this.lRc = ap.getColor(R.color.cp_cont_d);
            this.lineColor = ap.getColor(R.color.cp_cont_e);
            invalidate();
        }
    }
}
