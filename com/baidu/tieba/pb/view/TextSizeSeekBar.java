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
    private Drawable cMb;
    private int eyA;
    private int eyB;
    private String[] eyC;
    private int eyD;
    private int eyE;
    private ArrayList<Rect> eyF;
    private int eyw;
    private int eyx;
    private int eyy;
    private int eyz;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.eyF = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.eyF = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.eyF = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.cMb = aq.getDrawable(w.g.btn_recommend_size_handle);
        this.eyz = this.cMb.getIntrinsicWidth();
        this.eyA = this.cMb.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds24);
        this.eyC = new String[]{context.getString(w.l.font_size_small), context.getString(w.l.font_size_mid), context.getString(w.l.font_size_big), context.getString(w.l.font_size_xlarge)};
        this.eyD = aq.getColor(w.e.cp_link_tip_a);
        this.eyE = aq.getColor(w.e.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.cMb = aq.getDrawable(w.g.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.m9getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.eyw == 0 || this.eyx == 0) {
            this.eyw = View.MeasureSpec.getSize(i);
            this.eyx = TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds184);
            this.eyy = (this.eyw - this.eyz) / 3;
            this.eyB = this.eyx / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.eyF.add(new Rect(this.eyy * i3, this.eyB - (this.eyA / 2), (this.eyy * i3) + this.eyz, this.eyB + (this.eyA / 2)));
            }
        }
        setMeasuredDimension(this.eyw, this.eyx);
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
                        if (!this.eyF.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.c.of(Math.abs(this.index - 3));
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
        for (int i = 0; i < this.eyC.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.eyD);
            } else {
                this.paint.setColor(this.eyE);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.eyC[i], (this.eyy * i) + (this.eyz / 2), this.eyB - dimensionPixelSize, this.paint);
        }
    }

    private void j(Canvas canvas) {
        this.paint.setColor(this.eyD);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.eyz / 2.0d), this.eyB, (float) ((this.index * this.eyy) + (this.eyz / 2.0d)), this.eyB, this.paint);
        this.paint.setColor(this.eyE);
        canvas.drawLine((float) ((this.index * this.eyy) + (this.eyz / 2.0d)), this.eyB, (float) (this.eyw - (this.eyz / 2.0d)), this.eyB, this.paint);
    }

    private void k(Canvas canvas) {
        Rect rect = (Rect) x.c(this.eyF, this.index);
        if (rect != null && this.cMb != null) {
            this.cMb.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.cMb.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cMb != null) {
            this.cMb.setCallback(null);
            this.cMb = null;
        }
    }
}
