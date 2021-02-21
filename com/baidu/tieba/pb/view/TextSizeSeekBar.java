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
/* loaded from: classes2.dex */
public class TextSizeSeekBar extends View {
    private int ds12;
    private int ds3;
    private int ds58;
    private int index;
    private Drawable kxF;
    private int lineColor;
    private int mSkinType;
    private int mpp;
    private int mpq;
    private int mpr;
    private int mps;
    private int mpt;
    private int mpu;
    private String[] mpv;
    private int mpw;
    private int mpx;
    private ArrayList<Rect> mpy;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.mpy = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds58 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.mpy = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds58 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.mpy = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds58 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        init(context);
    }

    private void init(Context context) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds102);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.kxF = ap.getDrawable(R.drawable.pic_wordsize_n);
        this.mps = dimensionPixelSize;
        this.mpt = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.T_X09);
        this.mpv = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.mpw = ap.getColor(R.color.CAM_X0105);
        this.mpx = ap.getColor(R.color.CAM_X0109);
        this.lineColor = ap.getColor(R.color.CAM_X0111);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.kxF = ap.getDrawable(R.drawable.pic_wordsize_n);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mpp == 0 || this.mpq == 0) {
            this.mpp = View.MeasureSpec.getSize(i);
            this.mpq = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.mpr = (this.mpp - this.mps) / 3;
            this.mpu = this.mpq / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.mpy.add(new Rect(this.mpr * i3, this.mpu - (this.mpt / 2), (this.mpr * i3) + this.mps, this.mpu + (this.mpt / 2)));
            }
        }
        setMeasuredDimension(this.mpp, this.mpq);
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
                        if (!this.mpy.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.Fx(Math.abs(this.index - 3));
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
        J(canvas);
        v(canvas);
        an(canvas);
    }

    private void J(Canvas canvas) {
        for (int i = 0; i < this.mpv.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.mpw);
            } else {
                this.paint.setColor(this.mpx);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.mpv[i], (this.mpr * i) + (this.mps / 2), this.mpu - this.ds58, this.paint);
        }
    }

    private void v(Canvas canvas) {
        this.paint.setColor(this.lineColor);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.mps / 2.0d), this.mpu, (float) (this.mpp - (this.mps / 2.0d)), this.mpu, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.mpr * i) + (this.mps / 2), this.mpu, this.paint);
        }
    }

    private void an(Canvas canvas) {
        Rect rect = (Rect) y.getItem(this.mpy, this.index);
        if (rect != null && this.kxF != null) {
            this.kxF.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.kxF.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.kxF != null) {
            this.kxF.setCallback(null);
            this.kxF = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.kxF != null) {
                this.kxF = ap.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.mpw = ap.getColor(R.color.CAM_X0105);
            this.mpx = ap.getColor(R.color.CAM_X0109);
            this.lineColor = ap.getColor(R.color.CAM_X0111);
            invalidate();
        }
    }
}
