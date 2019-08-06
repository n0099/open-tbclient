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
    private int cat;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable gwn;
    private int ifE;
    private int ifF;
    private int ifG;
    private int ifH;
    private int ifI;
    private int ifJ;
    private String[] ifK;
    private int ifL;
    private int ifM;
    private ArrayList<Rect> ifN;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.ifN = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.ifN = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.ifN = new ArrayList<>(4);
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
        this.gwn = am.getDrawable(R.drawable.wordsize);
        this.ifH = dimensionPixelSize;
        this.ifI = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
        this.ifK = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.ifL = am.getColor(R.color.cp_cont_f);
        this.ifM = am.getColor(R.color.cp_cont_d);
        this.cat = am.getColor(R.color.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.gwn = am.getDrawable(R.drawable.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ifE == 0 || this.ifF == 0) {
            this.ifE = View.MeasureSpec.getSize(i);
            this.ifF = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.ifG = (this.ifE - this.ifH) / 3;
            this.ifJ = this.ifF / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.ifN.add(new Rect(this.ifG * i3, this.ifJ - (this.ifI / 2), (this.ifG * i3) + this.ifH, this.ifJ + (this.ifI / 2)));
            }
        }
        setMeasuredDimension(this.ifE, this.ifF);
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
                        if (!this.ifN.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.xG(Math.abs(this.index - 3));
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
        Q(canvas);
        S(canvas);
        T(canvas);
    }

    private void Q(Canvas canvas) {
        for (int i = 0; i < this.ifK.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.ifL);
            } else {
                this.paint.setColor(this.ifM);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.ifK[i], (this.ifG * i) + (this.ifH / 2), this.ifJ - this.ds48, this.paint);
        }
    }

    private void S(Canvas canvas) {
        this.paint.setColor(this.cat);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.ifH / 2.0d), this.ifJ, (float) (this.ifE - (this.ifH / 2.0d)), this.ifJ, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.ifG * i) + (this.ifH / 2), this.ifJ, this.paint);
        }
    }

    private void T(Canvas canvas) {
        Rect rect = (Rect) v.c(this.ifN, this.index);
        if (rect != null && this.gwn != null) {
            this.gwn.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.gwn.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gwn != null) {
            this.gwn.setCallback(null);
            this.gwn = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.gwn != null) {
                this.gwn = am.getDrawable(R.drawable.wordsize);
            }
            this.ifL = am.getColor(R.color.cp_cont_f);
            this.ifM = am.getColor(R.color.cp_cont_d);
            this.cat = am.getColor(R.color.cp_cont_e);
            invalidate();
        }
    }
}
