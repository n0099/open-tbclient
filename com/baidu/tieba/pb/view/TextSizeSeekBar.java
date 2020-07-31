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
    private Drawable iNh;
    private int index;
    private String[] kKA;
    private int kKB;
    private int kKC;
    private ArrayList<Rect> kKD;
    private int kKu;
    private int kKv;
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
        this.kKD = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.kKD = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.kKD = new ArrayList<>(4);
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
        this.iNh = ao.getDrawable(R.drawable.pic_wordsize_n);
        this.kKx = dimensionPixelSize;
        this.kKy = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
        this.kKA = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.kKB = ao.getColor(R.color.cp_cont_f);
        this.kKC = ao.getColor(R.color.cp_cont_d);
        this.lineColor = ao.getColor(R.color.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.iNh = ao.getDrawable(R.drawable.pic_wordsize_n);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.kKu == 0 || this.kKv == 0) {
            this.kKu = View.MeasureSpec.getSize(i);
            this.kKv = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.kKw = (this.kKu - this.kKx) / 3;
            this.kKz = this.kKv / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.kKD.add(new Rect(this.kKw * i3, this.kKz - (this.kKy / 2), (this.kKw * i3) + this.kKx, this.kKz + (this.kKy / 2)));
            }
        }
        setMeasuredDimension(this.kKu, this.kKv);
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
                        if (!this.kKD.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
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
        for (int i = 0; i < this.kKA.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.kKB);
            } else {
                this.paint.setColor(this.kKC);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.kKA[i], (this.kKw * i) + (this.kKx / 2), this.kKz - this.ds48, this.paint);
        }
    }

    private void W(Canvas canvas) {
        this.paint.setColor(this.lineColor);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.kKx / 2.0d), this.kKz, (float) (this.kKu - (this.kKx / 2.0d)), this.kKz, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.kKw * i) + (this.kKx / 2), this.kKz, this.paint);
        }
    }

    private void X(Canvas canvas) {
        Rect rect = (Rect) x.getItem(this.kKD, this.index);
        if (rect != null && this.iNh != null) {
            this.iNh.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.iNh.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.iNh != null) {
            this.iNh.setCallback(null);
            this.iNh = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.iNh != null) {
                this.iNh = ao.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.kKB = ao.getColor(R.color.cp_cont_f);
            this.kKC = ao.getColor(R.color.cp_cont_d);
            this.lineColor = ao.getColor(R.color.cp_cont_e);
            invalidate();
        }
    }
}
