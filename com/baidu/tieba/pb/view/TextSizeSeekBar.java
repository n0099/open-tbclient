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
    private Drawable kzH;
    private int lineColor;
    private int mSkinType;
    private ArrayList<Rect> mrA;
    private int mrr;
    private int mrs;
    private int mrt;
    private int mru;
    private int mrv;
    private int mrw;
    private String[] mrx;
    private int mry;
    private int mrz;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.mrA = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds58 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.mrA = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds58 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.mrA = new ArrayList<>(4);
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
        this.kzH = ap.getDrawable(R.drawable.pic_wordsize_n);
        this.mru = dimensionPixelSize;
        this.mrv = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.T_X09);
        this.mrx = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.mry = ap.getColor(R.color.CAM_X0105);
        this.mrz = ap.getColor(R.color.CAM_X0109);
        this.lineColor = ap.getColor(R.color.CAM_X0111);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.kzH = ap.getDrawable(R.drawable.pic_wordsize_n);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mrr == 0 || this.mrs == 0) {
            this.mrr = View.MeasureSpec.getSize(i);
            this.mrs = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.mrt = (this.mrr - this.mru) / 3;
            this.mrw = this.mrs / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.mrA.add(new Rect(this.mrt * i3, this.mrw - (this.mrv / 2), (this.mrt * i3) + this.mru, this.mrw + (this.mrv / 2)));
            }
        }
        setMeasuredDimension(this.mrr, this.mrs);
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
                        if (!this.mrA.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.FA(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.mrx.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.mry);
            } else {
                this.paint.setColor(this.mrz);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.mrx[i], (this.mrt * i) + (this.mru / 2), this.mrw - this.ds58, this.paint);
        }
    }

    private void v(Canvas canvas) {
        this.paint.setColor(this.lineColor);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.mru / 2.0d), this.mrw, (float) (this.mrr - (this.mru / 2.0d)), this.mrw, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.mrt * i) + (this.mru / 2), this.mrw, this.paint);
        }
    }

    private void an(Canvas canvas) {
        Rect rect = (Rect) y.getItem(this.mrA, this.index);
        if (rect != null && this.kzH != null) {
            this.kzH.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.kzH.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.kzH != null) {
            this.kzH.setCallback(null);
            this.kzH = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.kzH != null) {
                this.kzH = ap.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.mry = ap.getColor(R.color.CAM_X0105);
            this.mrz = ap.getColor(R.color.CAM_X0109);
            this.lineColor = ap.getColor(R.color.CAM_X0111);
            invalidate();
        }
    }
}
