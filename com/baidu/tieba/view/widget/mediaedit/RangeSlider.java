package com.baidu.tieba.view.widget.mediaedit;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.g16;
import com.baidu.tieba.l7b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class RangeSlider extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public float C;
    public int a;
    public Paint b;
    public Paint c;
    public Paint d;
    public final ThumbView e;
    public final ThumbView f;
    public float g;
    public float h;
    public int i;
    public float j;
    public int k;
    public int l;
    public int m;
    public float n;
    public float o;
    public int p;
    public int q;
    public float r;
    public float s;
    public boolean t;
    public a u;
    public b v;
    public ValueAnimator w;
    public int x;
    public l7b y;
    public Paint z;

    /* loaded from: classes8.dex */
    public interface a {
        void a(RangeSlider rangeSlider, int i, float f, float f2);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(float f);

        void b(float f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RangeSlider(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.n = this.e.getX() + this.p;
            this.o = this.f.getX() - this.r;
            ValueAnimator valueAnimator = this.w;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.j = (int) (this.e.getX() + this.p);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, canvas) == null) {
            if (this.A == 1 && this.B) {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
                return;
            }
            if (this.e.getVisibility() == 8 || this.f.getVisibility() == 8) {
                this.e.setVisibility(0);
                this.f.setVisibility(0);
            }
            a(canvas);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RangeSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RangeSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g16.RangeSlider, 0, 0);
        this.p = obtainStyledAttributes.getDimensionPixelOffset(10, 7);
        this.q = obtainStyledAttributes.getDimensionPixelOffset(9, 70);
        this.a = obtainStyledAttributes.getDimensionPixelOffset(12, 2);
        this.r = obtainStyledAttributes.getDimensionPixelOffset(13, 1);
        this.s = obtainStyledAttributes.getDimensionPixelOffset(3, 1);
        this.g = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.h = obtainStyledAttributes.getDimensionPixelOffset(7, 0);
        Paint paint = new Paint();
        this.d = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.d.setColor(-1);
        Paint paint2 = new Paint();
        this.c = paint2;
        paint2.setColor(obtainStyledAttributes.getColor(4, -1610612736));
        Paint paint3 = new Paint();
        this.z = paint3;
        paint3.setColor(obtainStyledAttributes.getColor(5, 0));
        this.A = obtainStyledAttributes.getInt(8, 0);
        Paint paint4 = new Paint();
        this.b = paint4;
        paint4.setColor(obtainStyledAttributes.getColor(2, -65456));
        this.k = ViewConfiguration.get(context).getScaledTouchSlop();
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(6);
        this.e = new ThumbView(context, this.p, this.q, drawable == null ? new ColorDrawable(-65456) : drawable);
        this.f = new ThumbView(context, this.p, this.q, drawable2 == null ? new ColorDrawable(-65456) : drawable2);
        this.y = new l7b(context);
        this.y.setLayoutParams(new FrameLayout.LayoutParams(200, 200));
        obtainStyledAttributes.recycle();
        this.j = this.g;
        addView(this.e);
        addView(this.f);
        addView(this.y);
        setWillNotDraw(false);
    }

    private void setVideoPointerViewPosition(float f) {
        ThumbView thumbView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65539, this, f) == null) {
            if (this.A == 1) {
                l7b l7bVar = this.y;
                if (l7bVar != null) {
                    l7bVar.setX(f);
                    return;
                }
                return;
            }
            l7b l7bVar2 = this.y;
            if (l7bVar2 != null && (thumbView = this.f) != null) {
                float f2 = this.g;
                if (f <= f2) {
                    l7bVar2.setX(f2);
                } else if (f >= thumbView.getX()) {
                    this.y.setX(this.f.getX() - UtilHelper.getDimenPixelSize(R.dimen.tbds4));
                } else {
                    this.y.setX(f);
                }
            }
        }
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            float x = this.e.getX() + i;
            if (x >= this.g - this.p && x < this.f.getX() - this.p && this.f.getX() - (this.p + x) >= this.x && x < getMeasuredWidth() - this.h) {
                this.e.setX(x);
                e(1);
            }
        }
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            float x = this.f.getX() + i;
            if (x > this.g && x > this.e.getX() + this.p && x - (this.e.getX() + this.p) >= this.x && x <= getMeasuredWidth() - this.h) {
                this.f.setX(x);
                e(2);
            }
        }
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int i = this.q + (this.a * 2);
            float x = this.e.getX();
            float x2 = this.f.getX();
            float f = this.s;
            int i2 = this.a;
            canvas.drawRect(this.p + x, i2, x2, i2 + f, this.b);
            canvas.drawRect(this.p + x, (i - i2) - f, x2, i - this.a, this.b);
            float f2 = this.p + x;
            int i3 = this.a;
            canvas.drawRect(f2, i3 + f, x2, (i - i3) - f, this.z);
            float f3 = this.g;
            int i4 = this.a;
            canvas.drawRect(f3, i4, x + this.p, i - i4, this.c);
            int i5 = this.a;
            canvas.drawRect(x2, i5, this.i, i - i5, this.c);
        }
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.A == 1) {
                float x = this.y.getX() + i;
                float f = this.g;
                if (x < f) {
                    x = f;
                } else if (UtilHelper.getDimenPixelSize(R.dimen.tbds4) + x >= getMeasuredWidth() - this.h) {
                    x = (getMeasuredWidth() - this.h) - UtilHelper.getDimenPixelSize(R.dimen.tbds4);
                }
                this.C = x;
                setVideoPointerViewPosition(x);
                b bVar = this.v;
                if (bVar != null) {
                    bVar.b(this.C);
                    return;
                }
                return;
            }
            float f2 = i;
            float x2 = this.y.getX() + f2;
            if (x2 > this.e.getX() + this.p && x2 < this.f.getX()) {
                if (UtilHelper.getDimenPixelSize(R.dimen.tbds4) + x2 >= this.f.getX() && this.C <= this.f.getX()) {
                    this.C += f2;
                } else {
                    this.C = x2;
                    setVideoPointerViewPosition(x2);
                }
                b bVar2 = this.v;
                if (bVar2 != null) {
                    bVar2.b(this.C);
                }
            }
        }
    }

    public final void e(int i) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (aVar = this.u) != null) {
            aVar.a(this, i, this.e.getX() + this.p, this.f.getX());
        }
    }

    public void k(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f) == null) {
            j();
            invalidate();
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.i = i;
            invalidate();
        }
    }

    public void m(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            j();
            invalidate();
        }
    }

    public void setCurrentAbsolutePosition(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f) == null) {
            this.j = f;
            invalidate();
            setVideoPointerViewPosition(this.j);
        }
    }

    public void setCurrentRelativelyPosition(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f) == null) {
            float f2 = this.n;
            this.j = (int) (f2 + (f * (this.o - f2)));
            invalidate();
            l7b l7bVar = this.y;
            if (l7bVar != null && !l7bVar.isPressed()) {
                setVideoPointerViewPosition(this.j);
            }
        }
    }

    public void setLeftThumbDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, drawable) == null) {
            this.e.setThumbDrawable(drawable);
        }
    }

    public void setLineColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.b.setColor(i);
        }
    }

    public void setMinRangeWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.x = i;
        }
    }

    public void setOnlyVisibleViewPointer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.B = z;
            invalidate();
        }
    }

    public void setRangeChangeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, aVar) == null) {
            this.u = aVar;
        }
    }

    public void setRightThumbDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, drawable) == null) {
            this.f.setThumbDrawable(drawable);
        }
    }

    public void setThumbHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.q = i;
            this.e.setThumbHeight(i);
            this.f.setThumbHeight(i);
        }
    }

    public void setThumbWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.p = i;
            this.e.setThumbWidth(i);
            this.f.setThumbWidth(i);
        }
    }

    public void setVideoPointerViewDragListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bVar) == null) {
            this.v = bVar;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            e(3);
            this.e.setPressed(false);
        }
    }

    public float getLeftThumbX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e.getX() + this.p;
        }
        return invokeV.floatValue;
    }

    public float getRightThumbX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f.getX();
        }
        return invokeV.floatValue;
    }

    public int getThumbWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public float getVerticalLineSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.r;
        }
        return invokeV.floatValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            e(4);
            this.f.setPressed(false);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.y.setPressed(false);
        }
    }

    public void j() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (valueAnimator = this.w) != null) {
            valueAnimator.cancel();
            this.j = (int) (this.e.getX() + this.p);
        }
    }

    public void n(float f, float f2) {
        l7b l7bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            ThumbView thumbView = this.e;
            if (thumbView != null) {
                thumbView.setX(f);
            }
            ThumbView thumbView2 = this.f;
            if (thumbView2 != null) {
                thumbView2.setX(f2);
            }
            if (this.A == 1 && (l7bVar = this.y) != null) {
                l7bVar.setX(f + this.p);
            }
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int measuredWidth = getMeasuredWidth();
            ThumbView thumbView = this.e;
            float f = this.g;
            int i5 = this.a;
            thumbView.layout((int) (f - this.p), i5, (int) f, this.q + i5);
            ThumbView thumbView2 = this.f;
            float f2 = measuredWidth;
            float f3 = this.h;
            int i6 = this.a;
            thumbView2.layout((int) (f2 - f3), i6, (int) ((f2 - f3) + this.p), this.q + i6);
            this.y.layout((int) (this.e.getX() + this.p), 0, (int) (this.e.getX() + this.p + this.r), this.q + (this.a * 2));
            this.y.invalidate();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824);
            super.onMeasure(makeMeasureSpec, i2);
            this.e.measure(makeMeasureSpec, i2);
            this.f.measure(makeMeasureSpec, i2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
            boolean z = false;
            if (!isEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return false;
                        }
                    } else {
                        int x = (int) motionEvent.getX();
                        if (!this.t && Math.abs(x - this.l) > this.k) {
                            this.t = true;
                        }
                        if (this.t) {
                            int i = x - this.m;
                            if (this.e.isPressed()) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                b(i);
                                j();
                                invalidate();
                            } else if (this.f.isPressed()) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                c(i);
                                j();
                                invalidate();
                            } else if (this.y.isPressed()) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                d(i);
                                j();
                                invalidate();
                            }
                            z = true;
                        }
                        this.m = x;
                        return z;
                    }
                }
                this.t = false;
                this.m = 0;
                this.l = 0;
                getParent().requestDisallowInterceptTouchEvent(false);
                if (this.e.isPressed()) {
                    g();
                    invalidate();
                } else if (this.f.isPressed()) {
                    h();
                    invalidate();
                } else if (!this.y.isPressed()) {
                    return false;
                } else {
                    b bVar = this.v;
                    if (bVar != null) {
                        bVar.a(this.y.getX());
                    }
                    i();
                    invalidate();
                }
            } else {
                int x2 = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                this.l = x2;
                this.m = x2;
                this.t = false;
                if (!this.e.isPressed() && this.e.a(x2, y) && !this.f.isPressed() && !this.e.isPressed() && this.y.a(x2, y)) {
                    if (x2 >= this.y.getX()) {
                        this.y.setPressed(true);
                    } else {
                        this.e.setPressed(true);
                    }
                } else if (!this.f.isPressed() && this.f.a(x2, y) && !this.f.isPressed() && !this.e.isPressed() && this.y.a(x2, y)) {
                    if (x2 >= this.f.getX()) {
                        this.f.setPressed(true);
                    } else {
                        this.y.setPressed(true);
                    }
                } else if (!this.e.isPressed() && this.e.a(x2, y)) {
                    this.e.setPressed(true);
                } else if (!this.f.isPressed() && this.f.a(x2, y)) {
                    this.f.setPressed(true);
                } else if (this.f.isPressed() || this.e.isPressed() || !this.y.a(x2, y)) {
                    return false;
                } else {
                    this.y.setPressed(true);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
