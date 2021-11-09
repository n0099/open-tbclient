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
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class RangeSlider extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ValueAnimator A;
    public int B;
    public b.a.r0.c4.l.c.b C;
    public Paint D;
    public int E;
    public boolean F;
    public float G;

    /* renamed from: e  reason: collision with root package name */
    public int f55619e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f55620f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f55621g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f55622h;

    /* renamed from: i  reason: collision with root package name */
    public final ThumbView f55623i;
    public final ThumbView j;
    public float k;
    public float l;
    public int m;
    public float n;
    public int o;
    public int p;
    public int q;
    public float r;
    public float s;
    public int t;
    public int u;
    public float v;
    public float w;
    public boolean x;
    public a y;
    public b z;

    /* loaded from: classes9.dex */
    public interface a {
        void a(RangeSlider rangeSlider, int i2, float f2, float f3);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(float f2);

        void onDragCancel(float f2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            if (this.E == 1) {
                b.a.r0.c4.l.c.b bVar = this.C;
                if (bVar != null) {
                    bVar.setX(f2);
                    return;
                }
                return;
            }
            b.a.r0.c4.l.c.b bVar2 = this.C;
            if (bVar2 == null || (thumbView = this.j) == null) {
                return;
            }
            float f3 = this.k;
            if (f2 <= f3) {
                bVar2.setX(f3);
            } else if (f2 >= thumbView.getX()) {
                this.C.setX(this.j.getX() - UtilHelper.getDimenPixelSize(R.dimen.tbds4));
            } else {
                this.C.setX(f2);
            }
        }
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int i2 = this.u + (this.f55619e * 2);
            float x = this.f55623i.getX();
            float x2 = this.j.getX();
            float f2 = this.w;
            int i3 = this.f55619e;
            canvas.drawRect(this.t + x, i3, x2, i3 + f2, this.f55620f);
            canvas.drawRect(this.t + x, (i2 - i3) - f2, x2, i2 - this.f55619e, this.f55620f);
            float f3 = this.t + x;
            int i4 = this.f55619e;
            canvas.drawRect(f3, i4 + f2, x2, (i2 - i4) - f2, this.D);
            float f4 = this.k;
            int i5 = this.f55619e;
            canvas.drawRect(f4, i5, x + this.t, i2 - i5, this.f55621g);
            int i6 = this.f55619e;
            canvas.drawRect(x2, i6, this.m, i2 - i6, this.f55621g);
        }
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            float x = this.f55623i.getX() + i2;
            if (x < this.k - this.t || x >= this.j.getX() - this.t || this.j.getX() - (this.t + x) < this.B || x >= getMeasuredWidth() - this.l) {
                return;
            }
            this.f55623i.setX(x);
            e(1);
        }
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            float x = this.j.getX() + i2;
            if (x <= this.k || x <= this.f55623i.getX() + this.t || x - (this.f55623i.getX() + this.t) < this.B || x > getMeasuredWidth() - this.l) {
                return;
            }
            this.j.setX(x);
            e(2);
        }
    }

    public void cancelAnimator() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (valueAnimator = this.A) == null) {
            return;
        }
        valueAnimator.cancel();
        this.n = this.k;
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (this.E == 1) {
                float x = this.C.getX() + i2;
                float f2 = this.k;
                if (x < f2) {
                    x = f2;
                } else if (UtilHelper.getDimenPixelSize(R.dimen.tbds4) + x >= getMeasuredWidth() - this.l) {
                    x = (getMeasuredWidth() - this.l) - UtilHelper.getDimenPixelSize(R.dimen.tbds4);
                }
                this.G = x;
                setVideoPointerViewPosition(x);
                b bVar = this.z;
                if (bVar != null) {
                    bVar.a(this.G);
                    return;
                }
                return;
            }
            float f3 = i2;
            float x2 = this.C.getX() + f3;
            if (x2 <= this.f55623i.getX() + this.t || x2 >= this.j.getX()) {
                return;
            }
            if (UtilHelper.getDimenPixelSize(R.dimen.tbds4) + x2 >= this.j.getX() && this.G <= this.j.getX()) {
                this.G += f3;
            } else {
                this.G = x2;
                setVideoPointerViewPosition(x2);
            }
            b bVar2 = this.z;
            if (bVar2 != null) {
                bVar2.a(this.G);
            }
        }
    }

    public final void e(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (aVar = this.y) == null) {
            return;
        }
        aVar.a(this, i2, this.f55623i.getX() + this.t, this.j.getX());
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            e(3);
            this.f55623i.setPressed(false);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            e(4);
            this.j.setPressed(false);
        }
    }

    public float getLeftThumbX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f55623i.getX() + this.t : invokeV.floatValue;
    }

    public float getRightThumbX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j.getX() : invokeV.floatValue;
    }

    public int getThumbWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.t : invokeV.intValue;
    }

    public float getVerticalLineSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.v : invokeV.floatValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.C.setPressed(false);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, canvas) == null) {
            if (this.E == 1 && this.F) {
                this.f55623i.setVisibility(8);
                this.j.setVisibility(8);
                return;
            }
            if (this.f55623i.getVisibility() == 8 || this.j.getVisibility() == 8) {
                this.f55623i.setVisibility(0);
                this.j.setVisibility(0);
            }
            a(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int measuredWidth = getMeasuredWidth();
            ThumbView thumbView = this.f55623i;
            float f2 = this.k;
            int i6 = this.f55619e;
            thumbView.layout((int) (f2 - this.t), i6, (int) f2, this.u + i6);
            ThumbView thumbView2 = this.j;
            float f3 = measuredWidth;
            float f4 = this.l;
            int i7 = this.f55619e;
            thumbView2.layout((int) (f3 - f4), i7, (int) ((f3 - f4) + this.t), this.u + i7);
            this.C.layout((int) (this.f55623i.getX() + this.t), 0, (int) (this.f55623i.getX() + this.t + this.v), this.u + (this.f55619e * 2));
            this.C.invalidate();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
            super.onMeasure(makeMeasureSpec, i3);
            this.f55623i.measure(makeMeasureSpec, i3);
            this.j.measure(makeMeasureSpec, i3);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            boolean z = false;
            if (isEnabled()) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            int x = (int) motionEvent.getX();
                            if (!this.x && Math.abs(x - this.p) > this.o) {
                                this.x = true;
                            }
                            if (this.x) {
                                int i2 = x - this.q;
                                if (this.f55623i.isPressed()) {
                                    getParent().requestDisallowInterceptTouchEvent(true);
                                    b(i2);
                                    resetAnimator();
                                    invalidate();
                                } else if (this.j.isPressed()) {
                                    getParent().requestDisallowInterceptTouchEvent(true);
                                    c(i2);
                                    resetAnimator();
                                    invalidate();
                                } else if (this.C.isPressed()) {
                                    getParent().requestDisallowInterceptTouchEvent(true);
                                    d(i2);
                                    resetAnimator();
                                    invalidate();
                                }
                                z = true;
                            }
                            this.q = x;
                            return z;
                        } else if (action != 3) {
                            return false;
                        }
                    }
                    this.x = false;
                    this.q = 0;
                    this.p = 0;
                    getParent().requestDisallowInterceptTouchEvent(false);
                    if (this.f55623i.isPressed()) {
                        f();
                        invalidate();
                    } else if (this.j.isPressed()) {
                        g();
                        invalidate();
                    } else if (!this.C.isPressed()) {
                        return false;
                    } else {
                        b bVar = this.z;
                        if (bVar != null) {
                            bVar.onDragCancel(this.C.getX());
                        }
                        h();
                        invalidate();
                    }
                } else {
                    int x2 = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.p = x2;
                    this.q = x2;
                    this.x = false;
                    if (!this.f55623i.isPressed() && this.f55623i.inInTarget(x2, y) && !this.j.isPressed() && !this.f55623i.isPressed() && this.C.a(x2, y)) {
                        if (x2 >= this.C.getX()) {
                            this.C.setPressed(true);
                        } else {
                            this.f55623i.setPressed(true);
                        }
                    } else if (!this.j.isPressed() && this.j.inInTarget(x2, y) && !this.j.isPressed() && !this.f55623i.isPressed() && this.C.a(x2, y)) {
                        if (x2 >= this.j.getX()) {
                            this.j.setPressed(true);
                        } else {
                            this.C.setPressed(true);
                        }
                    } else if (!this.f55623i.isPressed() && this.f55623i.inInTarget(x2, y)) {
                        this.f55623i.setPressed(true);
                    } else if (!this.j.isPressed() && this.j.inInTarget(x2, y)) {
                        this.j.setPressed(true);
                    } else if (this.j.isPressed() || this.f55623i.isPressed() || !this.C.a(x2, y)) {
                        return false;
                    } else {
                        this.C.setPressed(true);
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void playValueAnimator(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.r = this.f55623i.getX() + this.t;
            this.s = this.j.getX() - this.v;
            ValueAnimator valueAnimator = this.A;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.n = (int) (this.f55623i.getX() + this.t);
            }
        }
    }

    public void resetAnimator() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (valueAnimator = this.A) == null) {
            return;
        }
        valueAnimator.cancel();
        this.n = (int) (this.f55623i.getX() + this.t);
    }

    public void setCurrentAbsolutePosition(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
            this.n = f2;
            invalidate();
            setVideoPointerViewPosition(this.n);
        }
    }

    public void setCurrentRelativelyPosition(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f2) == null) {
            float f3 = this.r;
            this.n = (int) (f3 + (f2 * (this.s - f3)));
            invalidate();
            b.a.r0.c4.l.c.b bVar = this.C;
            if (bVar == null || bVar.isPressed()) {
                return;
            }
            setVideoPointerViewPosition(this.n);
        }
    }

    public void setLeftThumbDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, drawable) == null) {
            this.f55623i.setThumbDrawable(drawable);
        }
    }

    public void setLineColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f55620f.setColor(i2);
        }
    }

    public void setMinRangeWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.B = i2;
        }
    }

    public void setOnlyVisibleViewPointer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.F = z;
            invalidate();
        }
    }

    public void setRangeChangeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, aVar) == null) {
            this.y = aVar;
        }
    }

    public void setRightThumbDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, drawable) == null) {
            this.j.setThumbDrawable(drawable);
        }
    }

    public void setThumbHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.u = i2;
            this.f55623i.setThumbHeight(i2);
            this.j.setThumbHeight(i2);
        }
    }

    public void setThumbWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.t = i2;
            this.f55623i.setThumbWidth(i2);
            this.j.setThumbWidth(i2);
        }
    }

    public void setVideoPointerViewDragListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bVar) == null) {
            this.z = bVar;
        }
    }

    public void updateAbsoluteLeftCoverOffset(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f2) == null) {
            resetAnimator();
            invalidate();
        }
    }

    public void updateAbsoluteRightOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.m = i2;
            invalidate();
        }
    }

    public void updateLeftCoverOffset(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048608, this, f2) == null) {
            resetAnimator();
            invalidate();
        }
    }

    public void updateSelectedRange(float f2, float f3) {
        b.a.r0.c4.l.c.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            ThumbView thumbView = this.f55623i;
            if (thumbView != null) {
                thumbView.setX(f2);
            }
            ThumbView thumbView2 = this.j;
            if (thumbView2 != null) {
                thumbView2.setX(f3);
            }
            if (this.E == 1 && (bVar = this.C) != null) {
                bVar.setX(f2 + this.t);
            }
            invalidate();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RangeSlider(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RangeSlider, 0, 0);
        this.t = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RangeSlider_thumbWidth, 7);
        this.u = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RangeSlider_thumbHeight, 70);
        this.f55619e = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RangeSlider_verticalLineBeyond, 2);
        this.v = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RangeSlider_verticalLineWidth, 1);
        this.w = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RangeSlider_lineHeight, 1);
        this.k = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RangeSlider_leftThumbPadding, 0);
        this.l = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RangeSlider_rightThumbPadding, 0);
        Paint paint = new Paint();
        this.f55622h = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.f55622h.setColor(-1);
        Paint paint2 = new Paint();
        this.f55621g = paint2;
        paint2.setColor(obtainStyledAttributes.getColor(R$styleable.RangeSlider_maskColor, -1610612736));
        Paint paint3 = new Paint();
        this.D = paint3;
        paint3.setColor(obtainStyledAttributes.getColor(R$styleable.RangeSlider_maskCoverColor, 0));
        this.E = obtainStyledAttributes.getInt(R$styleable.RangeSlider_sliderType, 0);
        Paint paint4 = new Paint();
        this.f55620f = paint4;
        paint4.setColor(obtainStyledAttributes.getColor(R$styleable.RangeSlider_lineColor, -65456));
        this.o = ViewConfiguration.get(context).getScaledTouchSlop();
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.RangeSlider_leftThumbDrawable);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.RangeSlider_rightThumbDrawable);
        this.f55623i = new ThumbView(context, this.t, this.u, drawable == null ? new ColorDrawable(-65456) : drawable);
        this.j = new ThumbView(context, this.t, this.u, drawable2 == null ? new ColorDrawable(-65456) : drawable2);
        this.C = new b.a.r0.c4.l.c.b(context);
        this.C.setLayoutParams(new FrameLayout.LayoutParams(200, 200));
        obtainStyledAttributes.recycle();
        this.n = this.k;
        addView(this.f55623i);
        addView(this.j);
        addView(this.C);
        setWillNotDraw(false);
    }
}
