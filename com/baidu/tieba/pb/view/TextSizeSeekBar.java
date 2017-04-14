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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable cJK;
    private int ewe;
    private int ewf;
    private int ewg;
    private int ewh;
    private int ewi;
    private int ewj;
    private String[] ewk;
    private int ewl;
    private int ewm;
    private ArrayList<Rect> ewn;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.ewn = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.ewn = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.ewn = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.cJK = aq.getDrawable(w.g.btn_recommend_size_handle);
        this.ewh = this.cJK.getIntrinsicWidth();
        this.ewi = this.cJK.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds24);
        this.ewk = new String[]{context.getString(w.l.font_size_small), context.getString(w.l.font_size_mid), context.getString(w.l.font_size_big), context.getString(w.l.font_size_xlarge)};
        this.ewl = aq.getColor(w.e.cp_link_tip_a);
        this.ewm = aq.getColor(w.e.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.cJK = aq.getDrawable(w.g.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ewe == 0 || this.ewf == 0) {
            this.ewe = View.MeasureSpec.getSize(i);
            this.ewf = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds184);
            this.ewg = (this.ewe - this.ewh) / 3;
            this.ewj = this.ewf / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.ewn.add(new Rect(this.ewg * i3, this.ewj - (this.ewi / 2), (this.ewg * i3) + this.ewh, this.ewj + (this.ewi / 2)));
            }
        }
        setMeasuredDimension(this.ewe, this.ewf);
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
                        if (!this.ewn.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.c.nZ(Math.abs(this.index - 3));
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
        j(canvas);
        k(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds42);
        for (int i = 0; i < this.ewk.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.ewl);
            } else {
                this.paint.setColor(this.ewm);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.ewk[i], (this.ewg * i) + (this.ewh / 2), this.ewj - dimensionPixelSize, this.paint);
        }
    }

    private void j(Canvas canvas) {
        this.paint.setColor(this.ewl);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.ewh / 2.0d), this.ewj, (float) ((this.index * this.ewg) + (this.ewh / 2.0d)), this.ewj, this.paint);
        this.paint.setColor(this.ewm);
        canvas.drawLine((float) ((this.index * this.ewg) + (this.ewh / 2.0d)), this.ewj, (float) (this.ewe - (this.ewh / 2.0d)), this.ewj, this.paint);
    }

    private void k(Canvas canvas) {
        Rect rect = (Rect) x.c(this.ewn, this.index);
        if (rect != null && this.cJK != null) {
            this.cJK.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.cJK.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cJK != null) {
            this.cJK.setCallback(null);
            this.cJK = null;
        }
    }
}
