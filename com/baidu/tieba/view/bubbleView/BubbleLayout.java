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
    public ArrowDirection f22219e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.t3.j.a f22220f;

    /* renamed from: g  reason: collision with root package name */
    public float f22221g;

    /* renamed from: h  reason: collision with root package name */
    public float f22222h;
    public float i;
    public float j;
    public int k;
    public float l;
    public int m;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22223a;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            f22223a = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22223a[ArrowDirection.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22223a[ArrowDirection.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22223a[ArrowDirection.BOTTOM.ordinal()] = 4;
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

    public final void b(int i, int i2, int i3, int i4) {
        if (i2 < i || i4 < i3) {
            return;
        }
        this.f22220f = new d.b.i0.t3.j.a(new RectF(i, i3, i2, i4), this.f22221g, this.f22222h, this.i, this.j, this.l, this.m, this.k, this.f22219e);
    }

    public final void c() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i = a.f22223a[this.f22219e.ordinal()];
        if (i == 1) {
            paddingLeft = (int) (paddingLeft + this.f22221g);
        } else if (i == 2) {
            paddingRight = (int) (paddingRight + this.f22221g);
        } else if (i == 3) {
            paddingTop = (int) (paddingTop + this.i);
        } else if (i == 4) {
            paddingBottom = (int) (paddingBottom + this.i);
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
        int i = a.f22223a[this.f22219e.ordinal()];
        if (i == 1) {
            paddingLeft = (int) (paddingLeft - this.f22221g);
        } else if (i == 2) {
            paddingRight = (int) (paddingRight - this.f22221g);
        } else if (i == 3) {
            paddingTop = (int) (paddingTop - this.i);
        } else if (i == 4) {
            paddingBottom = (int) (paddingBottom - this.i);
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
        d.b.i0.t3.j.a aVar = this.f22220f;
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

    public BubbleLayout f(int i) {
        this.k = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.f22219e;
    }

    public float getArrowHeight() {
        return this.i;
    }

    public float getArrowPosition() {
        return this.j;
    }

    public float getArrowWidth() {
        return this.f22221g;
    }

    public int getBubbleColor() {
        return this.k;
    }

    public float getCornersRadius() {
        return this.f22222h;
    }

    public int getStrokeColor() {
        return this.m;
    }

    public float getStrokeWidth() {
        return this.l;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        b(0, getWidth(), 0, getHeight());
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleLayout);
        this.f22221g = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_arrowWidth, a(8.0f, context));
        this.i = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_arrowHeight, a(8.0f, context));
        this.f22222h = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_cornersRadius, 0.0f);
        this.j = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_arrowPosition, a(12.0f, context));
        this.k = obtainStyledAttributes.getColor(R$styleable.BubbleLayout_bl_bubbleColor, -1);
        this.l = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_strokeWidth, n);
        this.m = obtainStyledAttributes.getColor(R$styleable.BubbleLayout_bl_strokeColor, -7829368);
        this.f22219e = ArrowDirection.fromInt(obtainStyledAttributes.getInt(R$styleable.BubbleLayout_tb_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
        obtainStyledAttributes.recycle();
        c();
    }
}
