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
    private int can;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable gvv;
    private int ieC;
    private int ieD;
    private int ieE;
    private int ieF;
    private int ieG;
    private int ieH;
    private String[] ieI;
    private int ieJ;
    private int ieK;
    private ArrayList<Rect> ieL;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.ieL = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.ieL = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.ieL = new ArrayList<>(4);
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
        this.gvv = am.getDrawable(R.drawable.wordsize);
        this.ieF = dimensionPixelSize;
        this.ieG = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
        this.ieI = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.ieJ = am.getColor(R.color.cp_cont_f);
        this.ieK = am.getColor(R.color.cp_cont_d);
        this.can = am.getColor(R.color.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.gvv = am.getDrawable(R.drawable.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ieC == 0 || this.ieD == 0) {
            this.ieC = View.MeasureSpec.getSize(i);
            this.ieD = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.ieE = (this.ieC - this.ieF) / 3;
            this.ieH = this.ieD / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.ieL.add(new Rect(this.ieE * i3, this.ieH - (this.ieG / 2), (this.ieE * i3) + this.ieF, this.ieH + (this.ieG / 2)));
            }
        }
        setMeasuredDimension(this.ieC, this.ieD);
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
                        if (!this.ieL.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.xE(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.ieI.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.ieJ);
            } else {
                this.paint.setColor(this.ieK);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.ieI[i], (this.ieE * i) + (this.ieF / 2), this.ieH - this.ds48, this.paint);
        }
    }

    private void S(Canvas canvas) {
        this.paint.setColor(this.can);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.ieF / 2.0d), this.ieH, (float) (this.ieC - (this.ieF / 2.0d)), this.ieH, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.ieE * i) + (this.ieF / 2), this.ieH, this.paint);
        }
    }

    private void T(Canvas canvas) {
        Rect rect = (Rect) v.c(this.ieL, this.index);
        if (rect != null && this.gvv != null) {
            this.gvv.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.gvv.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gvv != null) {
            this.gvv.setCallback(null);
            this.gvv = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.gvv != null) {
                this.gvv = am.getDrawable(R.drawable.wordsize);
            }
            this.ieJ = am.getColor(R.color.cp_cont_f);
            this.ieK = am.getColor(R.color.cp_cont_d);
            this.can = am.getColor(R.color.cp_cont_e);
            invalidate();
        }
    }
}
