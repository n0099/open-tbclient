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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class TextSizeSeekBar extends View {
    private int awl;
    private int ds12;
    private int ds3;
    private int ds48;
    private Drawable ehe;
    private ArrayList<Rect> fPA;
    private int fPr;
    private int fPs;
    private int fPt;
    private int fPu;
    private int fPv;
    private int fPw;
    private String[] fPx;
    private int fPy;
    private int fPz;
    private int index;
    private int mSkinType;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fPA = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fPA = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds12);
        this.ds48 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds48);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fPA = new ArrayList<>(4);
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
        this.ehe = am.getDrawable(d.f.wordsize);
        this.fPu = dimensionPixelSize;
        this.fPv = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds28);
        this.fPx = new String[]{context.getString(d.j.font_size_small), context.getString(d.j.font_size_mid), context.getString(d.j.font_size_big), context.getString(d.j.font_size_xlarge)};
        this.fPy = am.getColor(d.C0140d.cp_cont_f);
        this.fPz = am.getColor(d.C0140d.cp_cont_d);
        this.awl = am.getColor(d.C0140d.cp_cont_e);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.ehe = am.getDrawable(d.f.wordsize);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fPr == 0 || this.fPs == 0) {
            this.fPr = View.MeasureSpec.getSize(i);
            this.fPs = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds176);
            this.fPt = (this.fPr - this.fPu) / 3;
            this.fPw = this.fPs / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fPA.add(new Rect(this.fPt * i3, this.fPw - (this.fPv / 2), (this.fPt * i3) + this.fPu, this.fPw + (this.fPv / 2)));
            }
        }
        setMeasuredDimension(this.fPr, this.fPs);
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
                        if (!this.fPA.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.qn(Math.abs(this.index - 3));
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
        y(canvas);
        A(canvas);
        B(canvas);
    }

    private void y(Canvas canvas) {
        for (int i = 0; i < this.fPx.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.fPy);
            } else {
                this.paint.setColor(this.fPz);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fPx[i], (this.fPt * i) + (this.fPu / 2), this.fPw - this.ds48, this.paint);
        }
    }

    private void A(Canvas canvas) {
        this.paint.setColor(this.awl);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.fPu / 2.0d), this.fPw, (float) (this.fPr - (this.fPu / 2.0d)), this.fPw, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.fPt * i) + (this.fPu / 2), this.fPw, this.paint);
        }
    }

    private void B(Canvas canvas) {
        Rect rect = (Rect) w.d(this.fPA, this.index);
        if (rect != null && this.ehe != null) {
            this.ehe.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.ehe.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ehe != null) {
            this.ehe.setCallback(null);
            this.ehe = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.ehe != null) {
                this.ehe = am.getDrawable(d.f.wordsize);
            }
            this.fPy = am.getColor(d.C0140d.cp_cont_f);
            this.fPz = am.getColor(d.C0140d.cp_cont_d);
            this.awl = am.getColor(d.C0140d.cp_cont_e);
            invalidate();
        }
    }
}
