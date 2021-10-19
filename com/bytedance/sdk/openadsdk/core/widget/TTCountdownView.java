package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class TTCountdownView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public AtomicBoolean B;

    /* renamed from: a  reason: collision with root package name */
    public int f67607a;

    /* renamed from: b  reason: collision with root package name */
    public int f67608b;

    /* renamed from: c  reason: collision with root package name */
    public int f67609c;

    /* renamed from: d  reason: collision with root package name */
    public int f67610d;

    /* renamed from: e  reason: collision with root package name */
    public float f67611e;

    /* renamed from: f  reason: collision with root package name */
    public float f67612f;

    /* renamed from: g  reason: collision with root package name */
    public float f67613g;

    /* renamed from: h  reason: collision with root package name */
    public int f67614h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f67615i;

    /* renamed from: j  reason: collision with root package name */
    public float f67616j;
    public float k;
    public float l;
    public String m;
    public boolean n;
    public Paint o;
    public Paint p;
    public Paint q;
    public Paint r;
    public float s;
    public float t;
    public RectF u;
    public a v;
    public AnimatorSet w;
    public ValueAnimator x;
    public ValueAnimator y;
    public ValueAnimator z;

    /* loaded from: classes9.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TTCountdownView(Context context) {
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

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            Paint paint = new Paint(1);
            this.o = paint;
            paint.setColor(this.f67607a);
            this.o.setStrokeWidth(this.f67611e);
            this.o.setAntiAlias(true);
            this.o.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint(1);
            this.p = paint2;
            paint2.setColor(this.f67609c);
            this.p.setAntiAlias(true);
            this.p.setStrokeWidth(this.f67611e);
            this.p.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint(1);
            this.q = paint3;
            paint3.setColor(this.f67608b);
            this.q.setAntiAlias(true);
            this.q.setStrokeWidth(this.f67611e / 2.0f);
            this.q.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint(1);
            this.r = paint4;
            paint4.setColor(this.f67610d);
            this.q.setAntiAlias(true);
            this.r.setTextSize(this.f67612f);
            this.r.setTextAlign(Paint.Align.CENTER);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            float f2 = this.f67613g;
            this.u = new RectF(-f2, -f2, f2, f2);
        }
    }

    private int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? (int) ((((this.f67611e / 2.0f) + this.f67613g) * 2.0f) + a(4.0f)) : invokeV.intValue;
    }

    private ValueAnimator getArcAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            ValueAnimator valueAnimator = this.y;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.y = null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.s, 0.0f);
            this.y = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.y.setDuration(a(this.s, this.f67616j) * 1000.0f);
            this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTCountdownView f67619a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67619a = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                        this.f67619a.s = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                        this.f67619a.postInvalidate();
                    }
                }
            });
            return this.y;
        }
        return (ValueAnimator) invokeV.objValue;
    }

    private ValueAnimator getNumAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            ValueAnimator valueAnimator = this.x;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.x = null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.t, 0.0f);
            this.x = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.x.setDuration(a(this.t, this.k) * 1000.0f);
            this.x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTCountdownView f67618a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67618a = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                        this.f67618a.t = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                        this.f67618a.postInvalidate();
                    }
                }
            });
            return this.x;
        }
        return (ValueAnimator) invokeV.objValue;
    }

    public float a(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? f2 * f3 : invokeCommon.floatValue;
    }

    public float a(float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) ? i2 * f2 : invokeCommon.floatValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                if (this.w == null || Build.VERSION.SDK_INT < 19) {
                    return;
                }
                this.w.pause();
            } catch (Throwable unused) {
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                if (this.w == null || Build.VERSION.SDK_INT < 19) {
                    return;
                }
                this.w.resume();
            } catch (Throwable unused) {
            }
        }
    }

    public a getCountdownListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.v : (a) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b();
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
            b(canvas);
            a(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode != 1073741824) {
                size = g();
            }
            if (mode2 != 1073741824) {
                size2 = g();
            }
            setMeasuredDimension(size, size2);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            super.onWindowFocusChanged(z);
            this.B.set(z);
            if (!this.B.get()) {
                c();
                a aVar = this.v;
                if (aVar != null) {
                    aVar.c();
                    return;
                }
                return;
            }
            d();
            a aVar2 = this.v;
            if (aVar2 != null) {
                aVar2.a();
            }
        }
    }

    public void setCountDownTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            float f2 = i2;
            this.k = f2;
            this.f67616j = f2;
            b();
        }
    }

    public void setCountdownListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.v = aVar;
            if (this.B.get() || aVar == null) {
                return;
            }
            aVar.c();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TTCountdownView(Context context, AttributeSet attributeSet) {
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
    public TTCountdownView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f67607a = Color.parseColor("#fce8b6");
        this.f67608b = Color.parseColor("#f0f0f0");
        this.f67609c = Color.parseColor("#ffffff");
        this.f67610d = Color.parseColor("#7c7c7c");
        this.f67611e = 2.0f;
        this.f67612f = 12.0f;
        this.f67613g = 18.0f;
        this.f67614h = 270;
        this.f67615i = false;
        this.f67616j = 5.0f;
        this.k = 5.0f;
        this.l = 0.8f;
        this.m = "跳过";
        this.n = false;
        this.s = 1.0f;
        this.t = 1.0f;
        this.A = false;
        this.B = new AtomicBoolean(true);
        this.f67611e = a(2.0f);
        this.f67613g = a(18.0f);
        this.f67612f = b(12.0f);
        this.f67614h %= 360;
        e();
        f();
    }

    private void b(Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, canvas) == null) {
            canvas.save();
            float a2 = a(this.s, 360);
            if (this.f67615i) {
                f2 = this.f67614h - a2;
            } else {
                f2 = this.f67614h;
            }
            canvas.drawCircle(0.0f, 0.0f, this.f67613g, this.p);
            canvas.drawCircle(0.0f, 0.0f, this.f67613g, this.q);
            canvas.drawArc(this.u, f2, a2, false, this.o);
            canvas.restore();
        }
    }

    private void a(Canvas canvas) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, canvas) == null) {
            canvas.save();
            Paint.FontMetrics fontMetrics = this.r.getFontMetrics();
            if (this.n) {
                str = "" + ((int) Math.ceil(a(this.t, this.k)));
            } else {
                str = this.m;
            }
            if (TextUtils.isEmpty(str)) {
                str = "跳过";
            }
            canvas.drawText(str, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.r);
            canvas.restore();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AnimatorSet animatorSet = this.w;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.w.cancel();
                this.w = null;
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.w = animatorSet2;
            animatorSet2.playTogether(getNumAnim(), getArcAnim());
            this.w.setInterpolator(new LinearInterpolator());
            this.w.addListener(new AnimatorListenerAdapter(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTCountdownView f67617a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67617a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.f67617a.A = true;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        if (!this.f67617a.A) {
                            if (this.f67617a.v != null) {
                                this.f67617a.v.b();
                                return;
                            }
                            return;
                        }
                        this.f67617a.A = false;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                    }
                }
            });
            this.w.start();
            if (this.B.get()) {
                return;
            }
            c();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.w != null) {
                    this.w.cancel();
                    this.w = null;
                }
                if (this.z != null) {
                    this.z.cancel();
                    this.z = null;
                }
                if (this.x != null) {
                    this.x.cancel();
                    this.x = null;
                }
                if (this.y != null) {
                    this.y.cancel();
                    this.y = null;
                }
                this.s = 1.0f;
                this.t = 1.0f;
                invalidate();
            } catch (Exception unused) {
            }
        }
    }

    private float a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65539, this, f2)) == null) ? TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics()) : invokeF.floatValue;
    }

    private float b(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65544, this, f2)) == null) ? TypedValue.applyDimension(2, f2, getResources().getDisplayMetrics()) : invokeF.floatValue;
    }
}
