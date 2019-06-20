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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class TextSizeSeekBar extends View {
    private int bZl;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable gpj;
    private int hYm;
    private int hYn;
    private int hYo;
    private int hYp;
    private int hYq;
    private int hYr;
    private String[] hYs;
    private int hYt;
    private int hYu;
    private ArrayList<Rect> hYv;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.hYv = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.hYv = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.hYv = new ArrayList<>(4);
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
        this.gpj = al.getDrawable(R.drawable.wordsize);
        this.hYp = dimensionPixelSize;
        this.hYq = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
        this.hYs = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.hYt = al.getColor(R.color.cp_cont_f);
        this.hYu = al.getColor(R.color.cp_cont_d);
        this.bZl = al.getColor(R.color.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.gpj = al.getDrawable(R.drawable.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.hYm == 0 || this.hYn == 0) {
            this.hYm = View.MeasureSpec.getSize(i);
            this.hYn = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.hYo = (this.hYm - this.hYp) / 3;
            this.hYr = this.hYn / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.hYv.add(new Rect(this.hYo * i3, this.hYr - (this.hYq / 2), (this.hYo * i3) + this.hYp, this.hYr + (this.hYq / 2)));
            }
        }
        setMeasuredDimension(this.hYm, this.hYn);
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
                        if (!this.hYv.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.xa(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.hYs.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.hYt);
            } else {
                this.paint.setColor(this.hYu);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.hYs[i], (this.hYo * i) + (this.hYp / 2), this.hYr - this.ds48, this.paint);
        }
    }

    private void S(Canvas canvas) {
        this.paint.setColor(this.bZl);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.hYp / 2.0d), this.hYr, (float) (this.hYm - (this.hYp / 2.0d)), this.hYr, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.hYo * i) + (this.hYp / 2), this.hYr, this.paint);
        }
    }

    private void T(Canvas canvas) {
        Rect rect = (Rect) v.c(this.hYv, this.index);
        if (rect != null && this.gpj != null) {
            this.gpj.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.gpj.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gpj != null) {
            this.gpj.setCallback(null);
            this.gpj = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.gpj != null) {
                this.gpj = al.getDrawable(R.drawable.wordsize);
            }
            this.hYt = al.getColor(R.color.cp_cont_f);
            this.hYu = al.getColor(R.color.cp_cont_d);
            this.bZl = al.getColor(R.color.cp_cont_e);
            invalidate();
        }
    }
}
