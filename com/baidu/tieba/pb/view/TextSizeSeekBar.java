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
/* loaded from: classes2.dex */
public class TextSizeSeekBar extends View {
    private int ds12;
    private int ds3;
    private int ds58;
    private int index;
    private Drawable ktP;
    private int lineColor;
    private int mSkinType;
    private int mkE;
    private int mkF;
    private int mkG;
    private int mkH;
    private int mkI;
    private int mkJ;
    private String[] mkK;
    private int mkL;
    private int mkM;
    private ArrayList<Rect> mkN;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.mkN = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds58 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.mkN = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds58 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.mkN = new ArrayList<>(4);
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
        this.ktP = ao.getDrawable(R.drawable.pic_wordsize_n);
        this.mkH = dimensionPixelSize;
        this.mkI = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.T_X09);
        this.mkK = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.mkL = ao.getColor(R.color.CAM_X0105);
        this.mkM = ao.getColor(R.color.CAM_X0109);
        this.lineColor = ao.getColor(R.color.CAM_X0111);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.ktP = ao.getDrawable(R.drawable.pic_wordsize_n);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mkE == 0 || this.mkF == 0) {
            this.mkE = View.MeasureSpec.getSize(i);
            this.mkF = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.mkG = (this.mkE - this.mkH) / 3;
            this.mkJ = this.mkF / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.mkN.add(new Rect(this.mkG * i3, this.mkJ - (this.mkI / 2), (this.mkG * i3) + this.mkH, this.mkJ + (this.mkI / 2)));
            }
        }
        setMeasuredDimension(this.mkE, this.mkF);
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
                        if (!this.mkN.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.GK(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.mkK.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.mkL);
            } else {
                this.paint.setColor(this.mkM);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.mkK[i], (this.mkG * i) + (this.mkH / 2), this.mkJ - this.ds58, this.paint);
        }
    }

    private void v(Canvas canvas) {
        this.paint.setColor(this.lineColor);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.mkH / 2.0d), this.mkJ, (float) (this.mkE - (this.mkH / 2.0d)), this.mkJ, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.mkG * i) + (this.mkH / 2), this.mkJ, this.paint);
        }
    }

    private void an(Canvas canvas) {
        Rect rect = (Rect) x.getItem(this.mkN, this.index);
        if (rect != null && this.ktP != null) {
            this.ktP.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.ktP.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ktP != null) {
            this.ktP.setCallback(null);
            this.ktP = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.ktP != null) {
                this.ktP = ao.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.mkL = ao.getColor(R.color.CAM_X0105);
            this.mkM = ao.getColor(R.color.CAM_X0109);
            this.lineColor = ao.getColor(R.color.CAM_X0111);
            invalidate();
        }
    }
}
