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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class EmotionButton extends View {
    private static final int lNS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds3);
    private static int lNT = 1;
    private RectF atR;
    private float bir;
    private int endColor;
    private int height;
    private int lNU;
    private int lNV;
    private int lNW;
    private int lNX;
    private LinearGradient lNY;
    private LinearGradient lNZ;
    private Paint mPaint;
    private TextPaint mTextPaint;
    private int startColor;
    private String text;
    private int width;

    public EmotionButton(Context context) {
        super(context);
        init(context);
    }

    public EmotionButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EmotionButton);
        this.text = obtainStyledAttributes.getString(1);
        this.bir = obtainStyledAttributes.getDimension(0, l.getDimens(context, R.dimen.tbds44));
        obtainStyledAttributes.recycle();
        init(context);
    }

    public EmotionButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EmotionButton);
        this.text = obtainStyledAttributes.getString(1);
        this.bir = obtainStyledAttributes.getDimension(0, l.getDimens(context, R.dimen.tbds44));
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        this.lNU = am.getColor(R.color.cp_link_tip_a_alpha50);
        this.startColor = am.getColor(R.color.cp_link_tip_a);
        this.endColor = am.getColor(R.color.cp_link_tip_b);
        this.lNV = am.getColor(R.color.cp_link_tip_a_alpha50);
        this.lNW = am.getColor(R.color.cp_link_tip_a_alpha50);
        this.lNX = am.getColor(R.color.cp_link_tip_b_alpha50);
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint = new TextPaint(1);
        this.mTextPaint.setTextSize(this.bir);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.view.EmotionButton.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1) {
                    int unused = EmotionButton.lNT = motionEvent.getAction();
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
        this.lNY = new LinearGradient(5.0f, 10.0f, this.width - 5, this.height - 10, this.endColor, this.startColor, Shader.TileMode.MIRROR);
        this.lNZ = new LinearGradient(5.0f, 10.0f, this.width - 5, this.height - 10, this.lNX, this.lNW, Shader.TileMode.MIRROR);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (lNT == 0) {
            ac(canvas);
        } else {
            ab(canvas);
        }
    }

    private void ab(Canvas canvas) {
        this.mPaint.setShader(this.lNY);
        this.mPaint.setShadowLayer(lNS, 2.0f, 2.0f, this.lNU);
        if (this.atR == null) {
            this.atR = new RectF();
        }
        this.atR.left = 5.0f;
        this.atR.top = 10.0f;
        this.atR.right = this.width - 5;
        this.atR.bottom = this.height - 10;
        canvas.drawRoundRect(this.atR, 15.0f, 15.0f, this.mPaint);
        if (!TextUtils.isEmpty(this.text)) {
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            canvas.drawText(this.text, this.atR.centerX(), (int) ((this.atR.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.mTextPaint);
        }
    }

    private void ac(Canvas canvas) {
        this.mPaint.setShader(this.lNZ);
        this.mPaint.setShadowLayer(lNS, 2.0f, 2.0f, this.lNV);
        if (this.atR == null) {
            this.atR = new RectF();
        }
        this.atR.left = 5.0f;
        this.atR.top = 10.0f;
        this.atR.right = this.width - 5;
        this.atR.bottom = this.height - 10;
        canvas.drawRoundRect(this.atR, 15.0f, 15.0f, this.mPaint);
        if (!TextUtils.isEmpty(this.text)) {
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            canvas.drawText(this.text, this.atR.centerX(), (int) ((this.atR.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.mTextPaint);
        }
    }

    public void setText(String str) {
        this.text = str;
        invalidate();
    }
}
