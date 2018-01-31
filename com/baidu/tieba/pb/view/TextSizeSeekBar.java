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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class TextSizeSeekBar extends View {
    private int baN;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable enY;
    private int gbi;
    private int gbj;
    private int gbk;
    private int gbl;
    private int gbm;
    private int gbn;
    private String[] gbo;
    private int gbp;
    private int gbq;
    private ArrayList<Rect> gbr;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.gbr = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.gbr = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.gbr = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    private void init(Context context) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds54);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.enY = aj.getDrawable(d.f.wordsize);
        this.gbl = dimensionPixelSize;
        this.gbm = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.gbo = new String[]{context.getString(d.j.font_size_small), context.getString(d.j.font_size_mid), context.getString(d.j.font_size_big), context.getString(d.j.font_size_xlarge)};
        this.gbp = aj.getColor(d.C0108d.cp_cont_f);
        this.gbq = aj.getColor(d.C0108d.cp_cont_d);
        this.baN = aj.getColor(d.C0108d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.enY = aj.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.gbi == 0 || this.gbj == 0) {
            this.gbi = View.MeasureSpec.getSize(i);
            this.gbj = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.gbk = (this.gbi - this.gbl) / 3;
            this.gbn = this.gbj / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.gbr.add(new Rect(this.gbk * i3, this.gbn - (this.gbm / 2), (this.gbk * i3) + this.gbl, this.gbn + (this.gbm / 2)));
            }
        }
        setMeasuredDimension(this.gbi, this.gbj);
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
                        if (!this.gbr.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.sA(Math.abs(this.index - 3));
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
        drawText(canvas);
        A(canvas);
        B(canvas);
    }

    private void drawText(Canvas canvas) {
        for (int i = 0; i < this.gbo.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.gbp);
            } else {
                this.paint.setColor(this.gbq);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.gbo[i], (this.gbk * i) + (this.gbl / 2), this.gbn - this.ds48, this.paint);
        }
    }

    private void A(Canvas canvas) {
        this.paint.setColor(this.baN);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.gbl / 2.0d), this.gbn, (float) (this.gbi - (this.gbl / 2.0d)), this.gbn, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.gbk * i) + (this.gbl / 2), this.gbn, this.paint);
        }
    }

    private void B(Canvas canvas) {
        Rect rect = (Rect) v.f(this.gbr, this.index);
        if (rect != null && this.enY != null) {
            this.enY.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.enY.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.enY != null) {
            this.enY.setCallback(null);
            this.enY = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.enY != null) {
                this.enY = aj.getDrawable(d.f.wordsize);
            }
            this.gbp = aj.getColor(d.C0108d.cp_cont_f);
            this.gbq = aj.getColor(d.C0108d.cp_cont_d);
            this.baN = aj.getColor(d.C0108d.cp_cont_e);
            invalidate();
        }
    }
}
