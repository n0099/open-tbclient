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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable cFu;
    private int elV;
    private int elW;
    private int elX;
    private int elY;
    private int elZ;
    private int ema;
    private String[] emb;
    private int emc;
    private int emd;
    private ArrayList<Rect> eme;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.eme = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.eme = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.eme = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.cFu = av.getDrawable(u.f.btn_recommend_size_handle);
        this.elY = this.cFu.getIntrinsicWidth();
        this.elZ = this.cFu.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.m10getInst().getContext().getResources().getDimensionPixelSize(u.e.ds24);
        this.emb = new String[]{context.getString(u.j.text_size_small), context.getString(u.j.text_size_middle), context.getString(u.j.text_size_big), context.getString(u.j.text_size_very_big)};
        this.emc = av.getColor(u.d.cp_link_tip_a);
        this.emd = av.getColor(u.d.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.m10getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.cFu = av.getDrawable(u.f.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.m10getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.elV == 0 || this.elW == 0) {
            this.elV = View.MeasureSpec.getSize(i);
            this.elW = TbadkCoreApplication.m10getInst().getContext().getResources().getDimensionPixelSize(u.e.ds184);
            this.elX = (this.elV - this.elY) / 3;
            this.ema = this.elW / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.eme.add(new Rect(this.elX * i3, this.ema - (this.elZ / 2), (this.elX * i3) + this.elY, this.ema + (this.elZ / 2)));
            }
        }
        setMeasuredDimension(this.elV, this.elW);
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
                        if (!this.eme.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.c.nw(Math.abs(this.index - 3));
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
        q(canvas);
        r(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.m10getInst().getContext().getResources().getDimensionPixelSize(u.e.ds42);
        for (int i = 0; i < this.emb.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.emc);
            } else {
                this.paint.setColor(this.emd);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.emb[i], (this.elX * i) + (this.elY / 2), this.ema - dimensionPixelSize, this.paint);
        }
    }

    private void q(Canvas canvas) {
        this.paint.setColor(this.emc);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine(this.elY / 2, this.ema, (this.index * this.elX) + (this.elY / 2), this.ema, this.paint);
        this.paint.setColor(this.emd);
        canvas.drawLine((this.index * this.elX) + (this.elY / 2), this.ema, this.elV - (this.elY / 2), this.ema, this.paint);
    }

    private void r(Canvas canvas) {
        Rect rect = (Rect) y.c(this.eme, this.index);
        if (rect != null && this.cFu != null) {
            this.cFu.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.cFu.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cFu != null) {
            this.cFu.setCallback(null);
            this.cFu = null;
        }
    }
}
