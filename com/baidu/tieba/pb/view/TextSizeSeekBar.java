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
/* loaded from: classes.dex */
public class TextSizeSeekBar extends View {
    private Drawable dmV;
    private int fbJ;
    private int fbK;
    private int fbL;
    private int fbM;
    private int fbN;
    private int fbO;
    private String[] fbP;
    private int fbQ;
    private int fbR;
    private ArrayList<Rect> fbS;
    private int index;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.fbS = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.fbS = new ArrayList<>(4);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.fbS = new ArrayList<>(4);
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.dmV = aj.getDrawable(d.g.btn_recommend_size_handle);
        this.fbM = this.dmV.getIntrinsicWidth();
        this.fbN = this.dmV.getIntrinsicHeight();
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds24);
        this.fbP = new String[]{context.getString(d.l.font_size_small), context.getString(d.l.font_size_mid), context.getString(d.l.font_size_big), context.getString(d.l.font_size_xlarge)};
        this.fbQ = aj.getColor(d.e.cp_link_tip_a);
        this.fbR = aj.getColor(d.e.cp_cont_c);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    public void setCursonIndex(int i) {
        this.index = i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.dmV = aj.getDrawable(d.g.btn_recommend_size_handle);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fbJ == 0 || this.fbK == 0) {
            this.fbJ = View.MeasureSpec.getSize(i);
            this.fbK = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds184);
            this.fbL = (this.fbJ - this.fbM) / 3;
            this.fbO = this.fbK / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.fbS.add(new Rect(this.fbL * i3, this.fbO - (this.fbN / 2), (this.fbL * i3) + this.fbM, this.fbO + (this.fbN / 2)));
            }
        }
        setMeasuredDimension(this.fbJ, this.fbK);
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
                        if (!this.fbS.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.pg(Math.abs(this.index - 3));
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
        w(canvas);
        x(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds42);
        for (int i = 0; i < this.fbP.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.fbQ);
            } else {
                this.paint.setColor(this.fbR);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.fbP[i], (this.fbL * i) + (this.fbM / 2), this.fbO - dimensionPixelSize, this.paint);
        }
    }

    private void w(Canvas canvas) {
        this.paint.setColor(this.fbQ);
        this.paint.setStrokeWidth(4.0f);
        canvas.drawLine((float) (this.fbM / 2.0d), this.fbO, (float) ((this.index * this.fbL) + (this.fbM / 2.0d)), this.fbO, this.paint);
        this.paint.setColor(this.fbR);
        canvas.drawLine((float) ((this.index * this.fbL) + (this.fbM / 2.0d)), this.fbO, (float) (this.fbJ - (this.fbM / 2.0d)), this.fbO, this.paint);
    }

    private void x(Canvas canvas) {
        Rect rect = (Rect) v.c(this.fbS, this.index);
        if (rect != null && this.dmV != null) {
            this.dmV.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.dmV.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dmV != null) {
            this.dmV.setCallback(null);
            this.dmV = null;
        }
    }
}
