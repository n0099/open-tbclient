package com.baidu.tieba.play;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class VideoLoadingProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f20249e;

    /* renamed from: f  reason: collision with root package name */
    public int f20250f;

    /* renamed from: g  reason: collision with root package name */
    public float f20251g;

    /* renamed from: h  reason: collision with root package name */
    public int f20252h;

    /* renamed from: i  reason: collision with root package name */
    public float f20253i;
    public int j;
    public RectF k;
    public Paint l;
    public int m;
    public int n;
    public float o;
    public float p;
    public float q;
    public int r;
    public c s;
    public ValueAnimator t;
    public ValueAnimator u;
    public ValueAnimator v;
    public ValueAnimator.AnimatorUpdateListener w;
    public AnimatorListenerAdapter x;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoLoadingProgressView f20254e;

        public a(VideoLoadingProgressView videoLoadingProgressView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLoadingProgressView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20254e = videoLoadingProgressView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (this.f20254e.r != 1 && this.f20254e.r != 2) {
                    if (this.f20254e.r == 3) {
                        this.f20254e.q = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView videoLoadingProgressView = this.f20254e;
                    videoLoadingProgressView.p = videoLoadingProgressView.o + ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.f20254e.q = 60.0f;
                }
                this.f20254e.invalidate();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoLoadingProgressView f20255e;

        public b(VideoLoadingProgressView videoLoadingProgressView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLoadingProgressView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20255e = videoLoadingProgressView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.f20255e.r == 2) {
                    this.f20255e.k();
                } else if (this.f20255e.r != 3 || this.f20255e.s == null) {
                } else {
                    this.f20255e.s.onAnimationEnd();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onAnimationEnd();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoLoadingProgressView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20249e = 7200.0f;
        this.f20250f = 10000;
        this.f20251g = 30.0f;
        this.f20252h = 50;
        this.f20253i = 300.0f;
        this.j = 400;
        this.o = -90.0f;
        this.p = -90.0f;
        this.q = 60.0f;
        this.w = new a(this);
        this.x = new b(this);
        i();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ValueAnimator valueAnimator = this.t;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator2 = this.u;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            ValueAnimator valueAnimator3 = this.v;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            g();
            setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k = new RectF();
            this.l = new Paint(1);
            this.m = getContext().getResources().getColor(R.color.CAM_X0101);
            this.n = l.g(getContext(), R.dimen.ds2);
            this.l.setColor(this.m);
            this.l.setStrokeWidth(this.n);
            this.l.setStyle(Paint.Style.STROKE);
            this.l.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g();
            this.r = 2;
            this.o = this.p;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(-this.f20251g);
            this.u = ofFloat;
            ofFloat.setDuration(this.f20252h);
            this.u.addListener(this.x);
            this.u.addUpdateListener(this.w);
            this.u.start();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            g();
            this.r = 3;
            this.o = this.p;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f20253i);
            this.v = ofFloat;
            ofFloat.setDuration(this.j);
            this.v.addListener(this.x);
            this.v.addUpdateListener(this.w);
            this.v.start();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g();
            this.r = 1;
            this.p = -90.0f;
            this.o = -90.0f;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f20249e);
            this.t = ofFloat;
            ofFloat.setDuration(this.f20250f);
            this.t.addListener(this.x);
            this.t.addUpdateListener(this.w);
            this.t.start();
            setVisibility(0);
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            g();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            RectF rectF = this.k;
            float f2 = 1;
            rectF.left = f2;
            rectF.top = f2;
            rectF.right = getWidth() - 1;
            this.k.bottom = getHeight() - 1;
            canvas.drawArc(this.k, this.p, this.q, false, this.l);
        }
    }

    public void setLoadingAnimationListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.s = cVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoLoadingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20249e = 7200.0f;
        this.f20250f = 10000;
        this.f20251g = 30.0f;
        this.f20252h = 50;
        this.f20253i = 300.0f;
        this.j = 400;
        this.o = -90.0f;
        this.p = -90.0f;
        this.q = 60.0f;
        this.w = new a(this);
        this.x = new b(this);
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f20249e = 7200.0f;
        this.f20250f = 10000;
        this.f20251g = 30.0f;
        this.f20252h = 50;
        this.f20253i = 300.0f;
        this.j = 400;
        this.o = -90.0f;
        this.p = -90.0f;
        this.q = 60.0f;
        this.w = new a(this);
        this.x = new b(this);
        i();
    }
}
