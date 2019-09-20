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
    private int cbm;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable gye;
    private int ihD;
    private int ihE;
    private int ihF;
    private int ihG;
    private int ihH;
    private int ihI;
    private String[] ihJ;
    private int ihK;
    private int ihL;
    private ArrayList<Rect> ihM;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.ihM = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.ihM = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.ihM = new ArrayList<>(4);
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
        this.gye = am.getDrawable(R.drawable.pic_wordsize_n);
        this.ihG = dimensionPixelSize;
        this.ihH = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
        this.ihJ = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.ihK = am.getColor(R.color.cp_cont_f);
        this.ihL = am.getColor(R.color.cp_cont_d);
        this.cbm = am.getColor(R.color.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.gye = am.getDrawable(R.drawable.pic_wordsize_n);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ihD == 0 || this.ihE == 0) {
            this.ihD = View.MeasureSpec.getSize(i);
            this.ihE = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.ihF = (this.ihD - this.ihG) / 3;
            this.ihI = this.ihE / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.ihM.add(new Rect(this.ihF * i3, this.ihI - (this.ihH / 2), (this.ihF * i3) + this.ihG, this.ihI + (this.ihH / 2)));
            }
        }
        setMeasuredDimension(this.ihD, this.ihE);
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
                        if (!this.ihM.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.xJ(Math.abs(this.index - 3));
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
        T(canvas);
        U(canvas);
    }

    private void C(Canvas canvas) {
        for (int i = 0; i < this.ihJ.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.ihK);
            } else {
                this.paint.setColor(this.ihL);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.ihJ[i], (this.ihF * i) + (this.ihG / 2), this.ihI - this.ds48, this.paint);
        }
    }

    private void T(Canvas canvas) {
        this.paint.setColor(this.cbm);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.ihG / 2.0d), this.ihI, (float) (this.ihD - (this.ihG / 2.0d)), this.ihI, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.ihF * i) + (this.ihG / 2), this.ihI, this.paint);
        }
    }

    private void U(Canvas canvas) {
        Rect rect = (Rect) v.c(this.ihM, this.index);
        if (rect != null && this.gye != null) {
            this.gye.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.gye.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gye != null) {
            this.gye.setCallback(null);
            this.gye = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.gye != null) {
                this.gye = am.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.ihK = am.getColor(R.color.cp_cont_f);
            this.ihL = am.getColor(R.color.cp_cont_d);
            this.cbm = am.getColor(R.color.cp_cont_e);
            invalidate();
        }
    }
}
