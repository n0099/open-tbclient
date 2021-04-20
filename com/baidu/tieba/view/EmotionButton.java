package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class EmotionButton extends View {
    public static final int t = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds3);
    public static int u = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f21746e;

    /* renamed from: f  reason: collision with root package name */
    public int f21747f;

    /* renamed from: g  reason: collision with root package name */
    public int f21748g;

    /* renamed from: h  reason: collision with root package name */
    public int f21749h;
    public int i;
    public int j;
    public Paint k;
    public TextPaint l;
    public RectF m;
    public int n;
    public int o;
    public LinearGradient p;
    public LinearGradient q;
    public String r;
    public float s;

    /* loaded from: classes5.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1) {
                int unused = EmotionButton.u = motionEvent.getAction();
                EmotionButton.this.invalidate();
                return false;
            }
            return false;
        }
    }

    public EmotionButton(Context context) {
        super(context);
        d(context);
    }

    public final void b(Canvas canvas) {
        this.k.setShader(this.p);
        this.k.setShadowLayer(t, 2.0f, 2.0f, this.f21746e);
        if (this.m == null) {
            this.m = new RectF();
        }
        RectF rectF = this.m;
        rectF.left = 5.0f;
        rectF.top = 10.0f;
        rectF.right = this.n - 5;
        rectF.bottom = this.o - 10;
        canvas.drawRoundRect(rectF, 15.0f, 15.0f, this.k);
        if (TextUtils.isEmpty(this.r)) {
            return;
        }
        Paint.FontMetrics fontMetrics = this.l.getFontMetrics();
        canvas.drawText(this.r, this.m.centerX(), (int) ((this.m.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.l);
    }

    public final void c(Canvas canvas) {
        this.k.setShader(this.q);
        this.k.setShadowLayer(t, 2.0f, 2.0f, this.f21749h);
        if (this.m == null) {
            this.m = new RectF();
        }
        RectF rectF = this.m;
        rectF.left = 5.0f;
        rectF.top = 10.0f;
        rectF.right = this.n - 5;
        rectF.bottom = this.o - 10;
        canvas.drawRoundRect(rectF, 15.0f, 15.0f, this.k);
        if (TextUtils.isEmpty(this.r)) {
            return;
        }
        Paint.FontMetrics fontMetrics = this.l.getFontMetrics();
        canvas.drawText(this.r, this.m.centerX(), (int) ((this.m.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.l);
    }

    public final void d(Context context) {
        this.f21746e = SkinManager.getColor(R.color.cp_link_tip_a_alpha50);
        this.f21747f = SkinManager.getColor(R.color.CAM_X0302);
        this.f21748g = SkinManager.getColor(R.color.CAM_X0303);
        this.f21749h = SkinManager.getColor(R.color.cp_link_tip_a_alpha50);
        this.i = SkinManager.getColor(R.color.cp_link_tip_a_alpha50);
        this.j = SkinManager.getColor(R.color.cp_link_tip_b_alpha50);
        Paint paint = new Paint();
        this.k = paint;
        paint.setStyle(Paint.Style.FILL);
        TextPaint textPaint = new TextPaint(1);
        this.l = textPaint;
        textPaint.setTextSize(this.s);
        this.l.setStyle(Paint.Style.FILL);
        this.l.setTextAlign(Paint.Align.CENTER);
        this.l.setColor(SkinManager.getColor(R.color.CAM_X0101));
        setOnTouchListener(new a());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (u == 0) {
            c(canvas);
        } else {
            b(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
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
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.n = i;
        this.o = i2;
        this.p = new LinearGradient(5.0f, 10.0f, this.n - 5, this.o - 10, this.f21748g, this.f21747f, Shader.TileMode.MIRROR);
        this.q = new LinearGradient(5.0f, 10.0f, this.n - 5, this.o - 10, this.j, this.i, Shader.TileMode.MIRROR);
    }

    public void setText(String str) {
        this.r = str;
        invalidate();
    }

    public EmotionButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EmotionButton);
        this.r = obtainStyledAttributes.getString(R$styleable.EmotionButton_text);
        this.s = obtainStyledAttributes.getDimension(R$styleable.EmotionButton_ebTextSize, l.g(context, R.dimen.tbds44));
        obtainStyledAttributes.recycle();
        d(context);
    }

    public EmotionButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EmotionButton);
        this.r = obtainStyledAttributes.getString(R$styleable.EmotionButton_text);
        this.s = obtainStyledAttributes.getDimension(R$styleable.EmotionButton_ebTextSize, l.g(context, R.dimen.tbds44));
        obtainStyledAttributes.recycle();
        d(context);
    }
}
