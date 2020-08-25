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
/* loaded from: classes16.dex */
public class TextSizeSeekBar extends View {
    private int ds12;
    private int ds3;
    private int ds48;
    private int index;
    private Drawable jch;
    private int lak;
    private int lal;
    private int lam;
    private int lan;
    private int lao;
    private int lap;
    private String[] laq;
    private int lar;
    private int las;
    private ArrayList<Rect> lau;
    private int lineColor;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.lau = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.lau = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.lau = new ArrayList<>(4);
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
        this.jch = ap.getDrawable(R.drawable.pic_wordsize_n);
        this.lan = dimensionPixelSize;
        this.lao = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
        this.laq = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.lar = ap.getColor(R.color.cp_cont_f);
        this.las = ap.getColor(R.color.cp_cont_d);
        this.lineColor = ap.getColor(R.color.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.jch = ap.getDrawable(R.drawable.pic_wordsize_n);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.lak == 0 || this.lal == 0) {
            this.lak = View.MeasureSpec.getSize(i);
            this.lal = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.lam = (this.lak - this.lan) / 3;
            this.lap = this.lal / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.lau.add(new Rect(this.lam * i3, this.lap - (this.lao / 2), (this.lam * i3) + this.lan, this.lap + (this.lao / 2)));
            }
        }
        setMeasuredDimension(this.lak, this.lal);
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
                        if (!this.lau.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.DS(Math.abs(this.index - 3));
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
        ad(canvas);
    }

    private void C(Canvas canvas) {
        for (int i = 0; i < this.laq.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.lar);
            } else {
                this.paint.setColor(this.las);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.laq[i], (this.lam * i) + (this.lan / 2), this.lap - this.ds48, this.paint);
        }
    }

    private void o(Canvas canvas) {
        this.paint.setColor(this.lineColor);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.lan / 2.0d), this.lap, (float) (this.lak - (this.lan / 2.0d)), this.lap, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.lam * i) + (this.lan / 2), this.lap, this.paint);
        }
    }

    private void ad(Canvas canvas) {
        Rect rect = (Rect) y.getItem(this.lau, this.index);
        if (rect != null && this.jch != null) {
            this.jch.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.jch.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.jch != null) {
            this.jch.setCallback(null);
            this.jch = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.jch != null) {
                this.jch = ap.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.lar = ap.getColor(R.color.cp_cont_f);
            this.las = ap.getColor(R.color.cp_cont_d);
            this.lineColor = ap.getColor(R.color.cp_cont_e);
            invalidate();
        }
    }
}
