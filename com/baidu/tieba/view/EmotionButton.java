package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes.dex */
public class EmotionButton extends View {
    private int endColor;
    private int height;
    private int jAB;
    private int jAC;
    private int jAD;
    private LinearGradient jAE;
    private LinearGradient jAF;
    private Paint mPaint;
    private RectF mRect;
    private TextPaint mTextPaint;
    private int shadowColor;
    private int startColor;
    private String text;
    private float textSize;
    private int width;
    private static final int jAz = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds3);
    private static int jAA = 1;

    public EmotionButton(Context context) {
        super(context);
        init(context);
    }

    public EmotionButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.EmotionButton);
        this.text = obtainStyledAttributes.getString(1);
        this.textSize = obtainStyledAttributes.getDimension(0, l.g(context, R.dimen.tbds44));
        obtainStyledAttributes.recycle();
        init(context);
    }

    public EmotionButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.EmotionButton);
        this.text = obtainStyledAttributes.getString(1);
        this.textSize = obtainStyledAttributes.getDimension(0, l.g(context, R.dimen.tbds44));
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        this.shadowColor = al.getColor(R.color.cp_link_tip_a_alpha50);
        this.startColor = al.getColor(R.color.cp_link_tip_a);
        this.endColor = al.getColor(R.color.cp_link_tip_b);
        this.jAB = al.getColor(R.color.cp_link_tip_a_alpha50);
        this.jAC = al.getColor(R.color.cp_link_tip_a_alpha50);
        this.jAD = al.getColor(R.color.cp_link_tip_b_alpha50);
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint = new TextPaint(1);
        this.mTextPaint.setTextSize(this.textSize);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setColor(al.getColor(R.color.cp_btn_a));
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.view.EmotionButton.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1) {
                    int unused = EmotionButton.jAA = motionEvent.getAction();
                    EmotionButton.this.invalidate();
                    return false;
                }
                return false;
            }
        });
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(200, 200);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(200, size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(size, 200);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        this.jAE = new LinearGradient(5.0f, 10.0f, this.width - 5, this.height - 10, this.endColor, this.startColor, Shader.TileMode.MIRROR);
        this.jAF = new LinearGradient(5.0f, 10.0f, this.width - 5, this.height - 10, this.jAD, this.jAC, Shader.TileMode.MIRROR);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (jAA == 0) {
            ae(canvas);
        } else {
            ad(canvas);
        }
    }

    private void ad(Canvas canvas) {
        this.mPaint.setShader(this.jAE);
        this.mPaint.setShadowLayer(jAz, 2.0f, 2.0f, this.shadowColor);
        if (this.mRect == null) {
            this.mRect = new RectF();
        }
        this.mRect.left = 5.0f;
        this.mRect.top = 10.0f;
        this.mRect.right = this.width - 5;
        this.mRect.bottom = this.height - 10;
        canvas.drawRoundRect(this.mRect, 15.0f, 15.0f, this.mPaint);
        if (!TextUtils.isEmpty(this.text)) {
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            canvas.drawText(this.text, this.mRect.centerX(), (int) ((this.mRect.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.mTextPaint);
        }
    }

    private void ae(Canvas canvas) {
        this.mPaint.setShader(this.jAF);
        this.mPaint.setShadowLayer(jAz, 2.0f, 2.0f, this.jAB);
        if (this.mRect == null) {
            this.mRect = new RectF();
        }
        this.mRect.left = 5.0f;
        this.mRect.top = 10.0f;
        this.mRect.right = this.width - 5;
        this.mRect.bottom = this.height - 10;
        canvas.drawRoundRect(this.mRect, 15.0f, 15.0f, this.mPaint);
        if (!TextUtils.isEmpty(this.text)) {
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            canvas.drawText(this.text, this.mRect.centerX(), (int) ((this.mRect.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.mTextPaint);
        }
    }

    public void setText(String str) {
        this.text = str;
        invalidate();
    }
}
