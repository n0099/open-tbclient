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
import com.baidu.tieba.ri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class VideoLoadingProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public int b;
    public float c;
    public int d;
    public float e;
    public int f;
    public RectF g;
    public Paint h;
    public int i;
    public int j;
    public float k;
    public float l;
    public float m;
    public int n;
    public c o;
    public ValueAnimator p;
    public ValueAnimator q;
    public ValueAnimator r;
    public ValueAnimator.AnimatorUpdateListener s;
    public AnimatorListenerAdapter t;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoLoadingProgressView a;

        public a(VideoLoadingProgressView videoLoadingProgressView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLoadingProgressView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoLoadingProgressView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (this.a.n != 1 && this.a.n != 2) {
                    if (this.a.n == 3) {
                        this.a.m = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 60.0f;
                    }
                } else {
                    VideoLoadingProgressView videoLoadingProgressView = this.a;
                    videoLoadingProgressView.l = videoLoadingProgressView.k + ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.a.m = 60.0f;
                }
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoLoadingProgressView a;

        public b(VideoLoadingProgressView videoLoadingProgressView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLoadingProgressView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoLoadingProgressView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.a.n == 2) {
                    this.a.k();
                } else if (this.a.n != 3 || this.a.o == null) {
                } else {
                    this.a.o.onAnimationEnd();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 7200.0f;
        this.b = 10000;
        this.c = 30.0f;
        this.d = 50;
        this.e = 300.0f;
        this.f = 400;
        this.k = -90.0f;
        this.l = -90.0f;
        this.m = 60.0f;
        this.s = new a(this);
        this.t = new b(this);
        i();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator2 = this.q;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            ValueAnimator valueAnimator3 = this.r;
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
            this.g = new RectF();
            this.h = new Paint(1);
            this.i = getContext().getResources().getColor(R.color.CAM_X0101);
            this.j = ri.f(getContext(), R.dimen.obfuscated_res_0x7f0701d4);
            this.h.setColor(this.i);
            this.h.setStrokeWidth(this.j);
            this.h.setStyle(Paint.Style.STROKE);
            this.h.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g();
            this.n = 2;
            this.k = this.l;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(-this.c);
            this.q = ofFloat;
            ofFloat.setDuration(this.d);
            this.q.addListener(this.t);
            this.q.addUpdateListener(this.s);
            this.q.start();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            g();
            this.n = 3;
            this.k = this.l;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.e);
            this.r = ofFloat;
            ofFloat.setDuration(this.f);
            this.r.addListener(this.t);
            this.r.addUpdateListener(this.s);
            this.r.start();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g();
            this.n = 1;
            this.l = -90.0f;
            this.k = -90.0f;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.a);
            this.p = ofFloat;
            ofFloat.setDuration(this.b);
            this.p.addListener(this.t);
            this.p.addUpdateListener(this.s);
            this.p.start();
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
            RectF rectF = this.g;
            float f = 1;
            rectF.left = f;
            rectF.top = f;
            rectF.right = getWidth() - 1;
            this.g.bottom = getHeight() - 1;
            canvas.drawArc(this.g, this.l, this.m, false, this.h);
        }
    }

    public void setLoadingAnimationListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.o = cVar;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 7200.0f;
        this.b = 10000;
        this.c = 30.0f;
        this.d = 50;
        this.e = 300.0f;
        this.f = 400;
        this.k = -90.0f;
        this.l = -90.0f;
        this.m = 60.0f;
        this.s = new a(this);
        this.t = new b(this);
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoLoadingProgressView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 7200.0f;
        this.b = 10000;
        this.c = 30.0f;
        this.d = 50;
        this.e = 300.0f;
        this.f = 400;
        this.k = -90.0f;
        this.l = -90.0f;
        this.m = 60.0f;
        this.s = new a(this);
        this.t = new b(this);
        i();
    }
}
