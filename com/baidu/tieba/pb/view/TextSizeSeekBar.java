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
/* loaded from: classes7.dex */
public class TextSizeSeekBar extends View {
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable hmT;
    private int index;
    private int jbf;
    private int jbg;
    private int jbh;
    private int jbi;
    private int jbj;
    private int jbk;
    private String[] jbl;
    private int jbm;
    private int jbn;
    private ArrayList<Rect> jbo;
    private int lineColor;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.jbo = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.jbo = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.jbo = new ArrayList<>(4);
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
        this.hmT = am.getDrawable(R.drawable.pic_wordsize_n);
        this.jbi = dimensionPixelSize;
        this.jbj = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
        this.jbl = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.jbm = am.getColor(R.color.cp_cont_f);
        this.jbn = am.getColor(R.color.cp_cont_d);
        this.lineColor = am.getColor(R.color.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.hmT = am.getDrawable(R.drawable.pic_wordsize_n);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.jbf == 0 || this.jbg == 0) {
            this.jbf = View.MeasureSpec.getSize(i);
            this.jbg = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.jbh = (this.jbf - this.jbi) / 3;
            this.jbk = this.jbg / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.jbo.add(new Rect(this.jbh * i3, this.jbk - (this.jbj / 2), (this.jbh * i3) + this.jbi, this.jbk + (this.jbj / 2)));
            }
        }
        setMeasuredDimension(this.jbf, this.jbg);
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
                        if (!this.jbo.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.yw(Math.abs(this.index - 3));
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
        O(canvas);
        P(canvas);
    }

    private void D(Canvas canvas) {
        for (int i = 0; i < this.jbl.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.jbm);
            } else {
                this.paint.setColor(this.jbn);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.jbl[i], (this.jbh * i) + (this.jbi / 2), this.jbk - this.ds48, this.paint);
        }
    }

    private void O(Canvas canvas) {
        this.paint.setColor(this.lineColor);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.jbi / 2.0d), this.jbk, (float) (this.jbf - (this.jbi / 2.0d)), this.jbk, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.jbh * i) + (this.jbi / 2), this.jbk, this.paint);
        }
    }

    private void P(Canvas canvas) {
        Rect rect = (Rect) v.getItem(this.jbo, this.index);
        if (rect != null && this.hmT != null) {
            this.hmT.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.hmT.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.hmT != null) {
            this.hmT.setCallback(null);
            this.hmT = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.hmT != null) {
                this.hmT = am.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.jbm = am.getColor(R.color.cp_cont_f);
            this.jbn = am.getColor(R.color.cp_cont_d);
            this.lineColor = am.getColor(R.color.cp_cont_e);
            invalidate();
        }
    }
}
