package com.baidu.tieba.view.bubbleView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tieba.R$styleable;
/* loaded from: classes5.dex */
public class BubbleLayout extends FrameLayout {
    public static float n = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public ArrowDirection f21753e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.v3.j.a f21754f;

    /* renamed from: g  reason: collision with root package name */
    public float f21755g;

    /* renamed from: h  reason: collision with root package name */
    public float f21756h;

    /* renamed from: i  reason: collision with root package name */
    public float f21757i;
    public float j;
    public int k;
    public float l;
    public int m;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21758a;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            f21758a = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21758a[ArrowDirection.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21758a[ArrowDirection.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21758a[ArrowDirection.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public static float a(float f2, Context context) {
        return f2 * (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public final void b(int i2, int i3, int i4, int i5) {
        if (i3 < i2 || i5 < i4) {
            return;
        }
        this.f21754f = new d.a.n0.v3.j.a(new RectF(i2, i4, i3, i5), this.f21755g, this.f21756h, this.f21757i, this.j, this.l, this.m, this.k, this.f21753e);
    }

    public final void c() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i2 = a.f21758a[this.f21753e.ordinal()];
        if (i2 == 1) {
            paddingLeft = (int) (paddingLeft + this.f21755g);
        } else if (i2 == 2) {
            paddingRight = (int) (paddingRight + this.f21755g);
        } else if (i2 == 3) {
            paddingTop = (int) (paddingTop + this.f21757i);
        } else if (i2 == 4) {
            paddingBottom = (int) (paddingBottom + this.f21757i);
        }
        float f2 = this.l;
        if (f2 > 0.0f) {
            paddingLeft = (int) (paddingLeft + f2);
            paddingRight = (int) (paddingRight + f2);
            paddingTop = (int) (paddingTop + f2);
            paddingBottom = (int) (paddingBottom + f2);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public final void d() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i2 = a.f21758a[this.f21753e.ordinal()];
        if (i2 == 1) {
            paddingLeft = (int) (paddingLeft - this.f21755g);
        } else if (i2 == 2) {
            paddingRight = (int) (paddingRight - this.f21755g);
        } else if (i2 == 3) {
            paddingTop = (int) (paddingTop - this.f21757i);
        } else if (i2 == 4) {
            paddingBottom = (int) (paddingBottom - this.f21757i);
        }
        float f2 = this.l;
        if (f2 > 0.0f) {
            paddingLeft = (int) (paddingLeft - f2);
            paddingRight = (int) (paddingRight - f2);
            paddingTop = (int) (paddingTop - f2);
            paddingBottom = (int) (paddingBottom - f2);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        d.a.n0.v3.j.a aVar = this.f21754f;
        if (aVar != null) {
            aVar.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public BubbleLayout e(float f2) {
        d();
        this.j = f2;
        c();
        return this;
    }

    public BubbleLayout f(int i2) {
        this.k = i2;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.f21753e;
    }

    public float getArrowHeight() {
        return this.f21757i;
    }

    public float getArrowPosition() {
        return this.j;
    }

    public float getArrowWidth() {
        return this.f21755g;
    }

    public int getBubbleColor() {
        return this.k;
    }

    public float getCornersRadius() {
        return this.f21756h;
    }

    public int getStrokeColor() {
        return this.m;
    }

    public float getStrokeWidth() {
        return this.l;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        b(0, getWidth(), 0, getHeight());
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleLayout);
        this.f21755g = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_arrowWidth, a(8.0f, context));
        this.f21757i = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_arrowHeight, a(8.0f, context));
        this.f21756h = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_cornersRadius, 0.0f);
        this.j = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_arrowPosition, a(12.0f, context));
        this.k = obtainStyledAttributes.getColor(R$styleable.BubbleLayout_bl_bubbleColor, -1);
        this.l = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_strokeWidth, n);
        this.m = obtainStyledAttributes.getColor(R$styleable.BubbleLayout_bl_strokeColor, -7829368);
        this.f21753e = ArrowDirection.fromInt(obtainStyledAttributes.getInt(R$styleable.BubbleLayout_tb_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
        obtainStyledAttributes.recycle();
        c();
    }
}
