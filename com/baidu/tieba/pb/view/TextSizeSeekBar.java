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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class TextSizeSeekBar extends View {
    private int aIU;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable eId;
    private int gqj;
    private int gqk;
    private int gql;
    private int gqm;
    private int gqn;
    private int gqo;
    private String[] gqp;
    private int gqq;
    private int gqr;
    private ArrayList<Rect> gqs;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.gqs = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.gqs = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.gqs = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds48);
        init(context);
    }

    private void init(Context context) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds54);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.eId = al.getDrawable(e.f.wordsize);
        this.gqm = dimensionPixelSize;
        this.gqn = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds28);
        this.gqp = new String[]{context.getString(e.j.font_size_small), context.getString(e.j.font_size_mid), context.getString(e.j.font_size_big), context.getString(e.j.font_size_xlarge)};
        this.gqq = al.getColor(e.d.cp_cont_f);
        this.gqr = al.getColor(e.d.cp_cont_d);
        this.aIU = al.getColor(e.d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.eId = al.getDrawable(e.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.gqj == 0 || this.gqk == 0) {
            this.gqj = View.MeasureSpec.getSize(i);
            this.gqk = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds176);
            this.gql = (this.gqj - this.gqm) / 3;
            this.gqo = this.gqk / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.gqs.add(new Rect(this.gql * i3, this.gqo - (this.gqn / 2), (this.gql * i3) + this.gqm, this.gqo + (this.gqn / 2)));
            }
        }
        setMeasuredDimension(this.gqj, this.gqk);
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
                        if (!this.gqs.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.sq(Math.abs(this.index - 3));
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
        x(canvas);
        z(canvas);
        A(canvas);
    }

    private void x(Canvas canvas) {
        for (int i = 0; i < this.gqp.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.gqq);
            } else {
                this.paint.setColor(this.gqr);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.gqp[i], (this.gql * i) + (this.gqm / 2), this.gqo - this.ds48, this.paint);
        }
    }

    private void z(Canvas canvas) {
        this.paint.setColor(this.aIU);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.gqm / 2.0d), this.gqo, (float) (this.gqj - (this.gqm / 2.0d)), this.gqo, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.gql * i) + (this.gqm / 2), this.gqo, this.paint);
        }
    }

    private void A(Canvas canvas) {
        Rect rect = (Rect) v.d(this.gqs, this.index);
        if (rect != null && this.eId != null) {
            this.eId.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.eId.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eId != null) {
            this.eId.setCallback(null);
            this.eId = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.eId != null) {
                this.eId = al.getDrawable(e.f.wordsize);
            }
            this.gqq = al.getColor(e.d.cp_cont_f);
            this.gqr = al.getColor(e.d.cp_cont_d);
            this.aIU = al.getColor(e.d.cp_cont_e);
            invalidate();
        }
    }
}
