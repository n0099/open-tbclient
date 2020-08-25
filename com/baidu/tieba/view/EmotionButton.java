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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class EmotionButton extends View {
    private static final int mGZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds3);
    private static int mHa = 1;
    private RectF aCa;
    private float btB;
    private int endColor;
    private int height;
    private int mHb;
    private int mHc;
    private int mHd;
    private LinearGradient mHe;
    private LinearGradient mHf;
    private Paint mPaint;
    private TextPaint mTextPaint;
    private int shadowColor;
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
        this.text = obtainStyledAttributes.getString(R.styleable.EmotionButton_text);
        this.btB = obtainStyledAttributes.getDimension(R.styleable.EmotionButton_ebTextSize, l.getDimens(context, R.dimen.tbds44));
        obtainStyledAttributes.recycle();
        init(context);
    }

    public EmotionButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EmotionButton);
        this.text = obtainStyledAttributes.getString(R.styleable.EmotionButton_text);
        this.btB = obtainStyledAttributes.getDimension(R.styleable.EmotionButton_ebTextSize, l.getDimens(context, R.dimen.tbds44));
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        this.shadowColor = ap.getColor(R.color.cp_link_tip_a_alpha50);
        this.startColor = ap.getColor(R.color.cp_link_tip_a);
        this.endColor = ap.getColor(R.color.cp_link_tip_b);
        this.mHb = ap.getColor(R.color.cp_link_tip_a_alpha50);
        this.mHc = ap.getColor(R.color.cp_link_tip_a_alpha50);
        this.mHd = ap.getColor(R.color.cp_link_tip_b_alpha50);
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint = new TextPaint(1);
        this.mTextPaint.setTextSize(this.btB);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setColor(ap.getColor(R.color.cp_cont_a));
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.view.EmotionButton.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1) {
                    int unused = EmotionButton.mHa = motionEvent.getAction();
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
        this.mHe = new LinearGradient(5.0f, 10.0f, this.width - 5, this.height - 10, this.endColor, this.startColor, Shader.TileMode.MIRROR);
        this.mHf = new LinearGradient(5.0f, 10.0f, this.width - 5, this.height - 10, this.mHd, this.mHc, Shader.TileMode.MIRROR);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (mHa == 0) {
            an(canvas);
        } else {
            am(canvas);
        }
    }

    private void am(Canvas canvas) {
        this.mPaint.setShader(this.mHe);
        this.mPaint.setShadowLayer(mGZ, 2.0f, 2.0f, this.shadowColor);
        if (this.aCa == null) {
            this.aCa = new RectF();
        }
        this.aCa.left = 5.0f;
        this.aCa.top = 10.0f;
        this.aCa.right = this.width - 5;
        this.aCa.bottom = this.height - 10;
        canvas.drawRoundRect(this.aCa, 15.0f, 15.0f, this.mPaint);
        if (!TextUtils.isEmpty(this.text)) {
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            canvas.drawText(this.text, this.aCa.centerX(), (int) ((this.aCa.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.mTextPaint);
        }
    }

    private void an(Canvas canvas) {
        this.mPaint.setShader(this.mHf);
        this.mPaint.setShadowLayer(mGZ, 2.0f, 2.0f, this.mHb);
        if (this.aCa == null) {
            this.aCa = new RectF();
        }
        this.aCa.left = 5.0f;
        this.aCa.top = 10.0f;
        this.aCa.right = this.width - 5;
        this.aCa.bottom = this.height - 10;
        canvas.drawRoundRect(this.aCa, 15.0f, 15.0f, this.mPaint);
        if (!TextUtils.isEmpty(this.text)) {
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            canvas.drawText(this.text, this.aCa.centerX(), (int) ((this.aCa.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.mTextPaint);
        }
    }

    public void setText(String str) {
        this.text = str;
        invalidate();
    }
}
