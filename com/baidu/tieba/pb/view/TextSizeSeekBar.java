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
    private Drawable jMq;
    private int lKY;
    private int lKZ;
    private int lLa;
    private int lLb;
    private int lLc;
    private int lLd;
    private String[] lLe;
    private int lLf;
    private int lLg;
    private ArrayList<Rect> lLh;
    private int lineColor;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.lLh = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.lLh = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.lLh = new ArrayList<>(4);
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
        this.jMq = ap.getDrawable(R.drawable.pic_wordsize_n);
        this.lLb = dimensionPixelSize;
        this.lLc = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
        this.lLe = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.lLf = ap.getColor(R.color.cp_cont_f);
        this.lLg = ap.getColor(R.color.cp_cont_d);
        this.lineColor = ap.getColor(R.color.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.jMq = ap.getDrawable(R.drawable.pic_wordsize_n);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.lKY == 0 || this.lKZ == 0) {
            this.lKY = View.MeasureSpec.getSize(i);
            this.lKZ = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.lLa = (this.lKY - this.lLb) / 3;
            this.lLd = this.lKZ / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.lLh.add(new Rect(this.lLa * i3, this.lLd - (this.lLc / 2), (this.lLa * i3) + this.lLb, this.lLd + (this.lLc / 2)));
            }
        }
        setMeasuredDimension(this.lKY, this.lKZ);
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
                        if (!this.lLh.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.Fs(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.lLe.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.lLf);
            } else {
                this.paint.setColor(this.lLg);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.lLe[i], (this.lLa * i) + (this.lLb / 2), this.lLd - this.ds48, this.paint);
        }
    }

    private void o(Canvas canvas) {
        this.paint.setColor(this.lineColor);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.lLb / 2.0d), this.lLd, (float) (this.lKY - (this.lLb / 2.0d)), this.lLd, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.lLa * i) + (this.lLb / 2), this.lLd, this.paint);
        }
    }

    private void ae(Canvas canvas) {
        Rect rect = (Rect) y.getItem(this.lLh, this.index);
        if (rect != null && this.jMq != null) {
            this.jMq.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.jMq.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.jMq != null) {
            this.jMq.setCallback(null);
            this.jMq = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.jMq != null) {
                this.jMq = ap.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.lLf = ap.getColor(R.color.cp_cont_f);
            this.lLg = ap.getColor(R.color.cp_cont_d);
            this.lineColor = ap.getColor(R.color.cp_cont_e);
            invalidate();
        }
    }
}
