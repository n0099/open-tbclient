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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class RangeSlider extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public float C;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f37142b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f37143c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f37144d;

    /* renamed from: e  reason: collision with root package name */
    public final ThumbView f37145e;

    /* renamed from: f  reason: collision with root package name */
    public final ThumbView f37146f;

    /* renamed from: g  reason: collision with root package name */
    public float f37147g;

    /* renamed from: h  reason: collision with root package name */
    public float f37148h;
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
    public c.a.p0.q4.n.c.b y;
    public Paint z;

    /* loaded from: classes6.dex */
    public interface a {
        void a(RangeSlider rangeSlider, int i, float f2, float f3);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(float f2);

        void b(float f2);
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

    private void setVideoPointerViewPosition(float f2) {
        ThumbView thumbView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65539, this, f2) == null) {
            if (this.A == 1) {
                c.a.p0.q4.n.c.b bVar = this.y;
                if (bVar != null) {
                    bVar.setX(f2);
                    return;
                }
                return;
            }
            c.a.p0.q4.n.c.b bVar2 = this.y;
            if (bVar2 == null || (thumbView = this.f37146f) == null) {
                return;
            }
            float f3 = this.f37147g;
            if (f2 <= f3) {
                bVar2.setX(f3);
            } else if (f2 >= thumbView.getX()) {
                this.y.setX(this.f37146f.getX() - UtilHelper.getDimenPixelSize(R.dimen.tbds4));
            } else {
                this.y.setX(f2);
            }
        }
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int i = this.q + (this.a * 2);
            float x = this.f37145e.getX();
            float x2 = this.f37146f.getX();
            float f2 = this.s;
            int i2 = this.a;
            canvas.drawRect(this.p + x, i2, x2, i2 + f2, this.f37142b);
            canvas.drawRect(this.p + x, (i - i2) - f2, x2, i - this.a, this.f37142b);
            float f3 = this.p + x;
            int i3 = this.a;
            canvas.drawRect(f3, i3 + f2, x2, (i - i3) - f2, this.z);
            float f4 = this.f37147g;
            int i4 = this.a;
            canvas.drawRect(f4, i4, x + this.p, i - i4, this.f37143c);
            int i5 = this.a;
            canvas.drawRect(x2, i5, this.i, i - i5, this.f37143c);
        }
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            float x = this.f37145e.getX() + i;
            if (x < this.f37147g - this.p || x >= this.f37146f.getX() - this.p || this.f37146f.getX() - (this.p + x) < this.x || x >= getMeasuredWidth() - this.f37148h) {
                return;
            }
            this.f37145e.setX(x);
            e(1);
        }
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            float x = this.f37146f.getX() + i;
            if (x <= this.f37147g || x <= this.f37145e.getX() + this.p || x - (this.f37145e.getX() + this.p) < this.x || x > getMeasuredWidth() - this.f37148h) {
                return;
            }
            this.f37146f.setX(x);
            e(2);
        }
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.A == 1) {
                float x = this.y.getX() + i;
                float f2 = this.f37147g;
                if (x < f2) {
                    x = f2;
                } else if (UtilHelper.getDimenPixelSize(R.dimen.tbds4) + x >= getMeasuredWidth() - this.f37148h) {
                    x = (getMeasuredWidth() - this.f37148h) - UtilHelper.getDimenPixelSize(R.dimen.tbds4);
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
            float f3 = i;
            float x2 = this.y.getX() + f3;
            if (x2 <= this.f37145e.getX() + this.p || x2 >= this.f37146f.getX()) {
                return;
            }
            if (UtilHelper.getDimenPixelSize(R.dimen.tbds4) + x2 >= this.f37146f.getX() && this.C <= this.f37146f.getX()) {
                this.C += f3;
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

    public final void e(int i) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (aVar = this.u) == null) {
            return;
        }
        aVar.a(this, i, this.f37145e.getX() + this.p, this.f37146f.getX());
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.n = this.f37145e.getX() + this.p;
            this.o = this.f37146f.getX() - this.r;
            ValueAnimator valueAnimator = this.w;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.j = (int) (this.f37145e.getX() + this.p);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            e(3);
            this.f37145e.setPressed(false);
        }
    }

    public float getLeftThumbX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37145e.getX() + this.p : invokeV.floatValue;
    }

    public float getRightThumbX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f37146f.getX() : invokeV.floatValue;
    }

    public int getThumbWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.p : invokeV.intValue;
    }

    public float getVerticalLineSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.r : invokeV.floatValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            e(4);
            this.f37146f.setPressed(false);
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
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (valueAnimator = this.w) == null) {
            return;
        }
        valueAnimator.cancel();
        this.j = (int) (this.f37145e.getX() + this.p);
    }

    public void k(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
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

    public void m(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            j();
            invalidate();
        }
    }

    public void n(float f2, float f3) {
        c.a.p0.q4.n.c.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            ThumbView thumbView = this.f37145e;
            if (thumbView != null) {
                thumbView.setX(f2);
            }
            ThumbView thumbView2 = this.f37146f;
            if (thumbView2 != null) {
                thumbView2.setX(f3);
            }
            if (this.A == 1 && (bVar = this.y) != null) {
                bVar.setX(f2 + this.p);
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, canvas) == null) {
            if (this.A == 1 && this.B) {
                this.f37145e.setVisibility(8);
                this.f37146f.setVisibility(8);
                return;
            }
            if (this.f37145e.getVisibility() == 8 || this.f37146f.getVisibility() == 8) {
                this.f37145e.setVisibility(0);
                this.f37146f.setVisibility(0);
            }
            a(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int measuredWidth = getMeasuredWidth();
            ThumbView thumbView = this.f37145e;
            float f2 = this.f37147g;
            int i5 = this.a;
            thumbView.layout((int) (f2 - this.p), i5, (int) f2, this.q + i5);
            ThumbView thumbView2 = this.f37146f;
            float f3 = measuredWidth;
            float f4 = this.f37148h;
            int i6 = this.a;
            thumbView2.layout((int) (f3 - f4), i6, (int) ((f3 - f4) + this.p), this.q + i6);
            this.y.layout((int) (this.f37145e.getX() + this.p), 0, (int) (this.f37145e.getX() + this.p + this.r), this.q + (this.a * 2));
            this.y.invalidate();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824);
            super.onMeasure(makeMeasureSpec, i2);
            this.f37145e.measure(makeMeasureSpec, i2);
            this.f37146f.measure(makeMeasureSpec, i2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
            boolean z = false;
            if (isEnabled()) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            int x = (int) motionEvent.getX();
                            if (!this.t && Math.abs(x - this.l) > this.k) {
                                this.t = true;
                            }
                            if (this.t) {
                                int i = x - this.m;
                                if (this.f37145e.isPressed()) {
                                    getParent().requestDisallowInterceptTouchEvent(true);
                                    b(i);
                                    j();
                                    invalidate();
                                } else if (this.f37146f.isPressed()) {
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
                        } else if (action != 3) {
                            return false;
                        }
                    }
                    this.t = false;
                    this.m = 0;
                    this.l = 0;
                    getParent().requestDisallowInterceptTouchEvent(false);
                    if (this.f37145e.isPressed()) {
                        g();
                        invalidate();
                    } else if (this.f37146f.isPressed()) {
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
                    if (!this.f37145e.isPressed() && this.f37145e.a(x2, y) && !this.f37146f.isPressed() && !this.f37145e.isPressed() && this.y.a(x2, y)) {
                        if (x2 >= this.y.getX()) {
                            this.y.setPressed(true);
                        } else {
                            this.f37145e.setPressed(true);
                        }
                    } else if (!this.f37146f.isPressed() && this.f37146f.a(x2, y) && !this.f37146f.isPressed() && !this.f37145e.isPressed() && this.y.a(x2, y)) {
                        if (x2 >= this.f37146f.getX()) {
                            this.f37146f.setPressed(true);
                        } else {
                            this.y.setPressed(true);
                        }
                    } else if (!this.f37145e.isPressed() && this.f37145e.a(x2, y)) {
                        this.f37145e.setPressed(true);
                    } else if (!this.f37146f.isPressed() && this.f37146f.a(x2, y)) {
                        this.f37146f.setPressed(true);
                    } else if (this.f37146f.isPressed() || this.f37145e.isPressed() || !this.y.a(x2, y)) {
                        return false;
                    } else {
                        this.y.setPressed(true);
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setCurrentAbsolutePosition(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f2) == null) {
            this.j = f2;
            invalidate();
            setVideoPointerViewPosition(this.j);
        }
    }

    public void setCurrentRelativelyPosition(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f2) == null) {
            float f3 = this.n;
            this.j = (int) (f3 + (f2 * (this.o - f3)));
            invalidate();
            c.a.p0.q4.n.c.b bVar = this.y;
            if (bVar == null || bVar.isPressed()) {
                return;
            }
            setVideoPointerViewPosition(this.j);
        }
    }

    public void setLeftThumbDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, drawable) == null) {
            this.f37145e.setThumbDrawable(drawable);
        }
    }

    public void setLineColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.f37142b.setColor(i);
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
            this.f37146f.setThumbDrawable(drawable);
        }
    }

    public void setThumbHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.q = i;
            this.f37145e.setThumbHeight(i);
            this.f37146f.setThumbHeight(i);
        }
    }

    public void setThumbWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.p = i;
            this.f37145e.setThumbWidth(i);
            this.f37146f.setThumbWidth(i);
        }
    }

    public void setVideoPointerViewDragListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bVar) == null) {
            this.v = bVar;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04039c, R.attr.obfuscated_res_0x7f04039d, R.attr.obfuscated_res_0x7f0403a3, R.attr.obfuscated_res_0x7f0403a4, R.attr.obfuscated_res_0x7f0403ff, R.attr.obfuscated_res_0x7f040400, R.attr.obfuscated_res_0x7f0404ff, R.attr.obfuscated_res_0x7f040500, R.attr.obfuscated_res_0x7f040568, R.attr.obfuscated_res_0x7f040630, R.attr.obfuscated_res_0x7f040635, R.attr.obfuscated_res_0x7f040675, R.attr.obfuscated_res_0x7f04067e, R.attr.obfuscated_res_0x7f04067f}, 0, 0);
        this.p = obtainStyledAttributes.getDimensionPixelOffset(10, 7);
        this.q = obtainStyledAttributes.getDimensionPixelOffset(9, 70);
        this.a = obtainStyledAttributes.getDimensionPixelOffset(12, 2);
        this.r = obtainStyledAttributes.getDimensionPixelOffset(13, 1);
        this.s = obtainStyledAttributes.getDimensionPixelOffset(3, 1);
        this.f37147g = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f37148h = obtainStyledAttributes.getDimensionPixelOffset(7, 0);
        Paint paint = new Paint();
        this.f37144d = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.f37144d.setColor(-1);
        Paint paint2 = new Paint();
        this.f37143c = paint2;
        paint2.setColor(obtainStyledAttributes.getColor(4, -1610612736));
        Paint paint3 = new Paint();
        this.z = paint3;
        paint3.setColor(obtainStyledAttributes.getColor(5, 0));
        this.A = obtainStyledAttributes.getInt(8, 0);
        Paint paint4 = new Paint();
        this.f37142b = paint4;
        paint4.setColor(obtainStyledAttributes.getColor(2, -65456));
        this.k = ViewConfiguration.get(context).getScaledTouchSlop();
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(6);
        this.f37145e = new ThumbView(context, this.p, this.q, drawable == null ? new ColorDrawable(-65456) : drawable);
        this.f37146f = new ThumbView(context, this.p, this.q, drawable2 == null ? new ColorDrawable(-65456) : drawable2);
        this.y = new c.a.p0.q4.n.c.b(context);
        this.y.setLayoutParams(new FrameLayout.LayoutParams(200, 200));
        obtainStyledAttributes.recycle();
        this.j = this.f37147g;
        addView(this.f37145e);
        addView(this.f37146f);
        addView(this.y);
        setWillNotDraw(false);
    }
}
