package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.adlanding.customer.WebViewContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class su1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebViewContainer a;
    public Context b;
    public boolean c;
    public double d;
    public ValueAnimator e;
    public float f;
    public mw2 g;
    public int h;
    public boolean i;
    public WebViewContainer.b j;
    public WebViewContainer.c k;

    /* loaded from: classes6.dex */
    public class a implements WebViewContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ su1 a;

        public a(su1 su1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = su1Var;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ su1 a;

        public b(su1 su1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = su1Var;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            double d;
            boolean z2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || this.a.a == null) {
                return;
            }
            if (z) {
                d = 1.0d - this.a.d;
            } else {
                d = this.a.d;
            }
            if ((this.a.a.getTopMargin() * 1.0d) / (this.a.h * 1.0d) >= d) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.a.j(z2);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements WebViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ su1 a;

        public c(su1 su1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = su1Var;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (z && this.a.a.getTopMargin() <= this.a.h) {
                    this.a.j(false);
                    return true;
                } else if (!z && this.a.a.getTopMargin() >= this.a.a.getMinTopMargin()) {
                    this.a.j(true);
                    return true;
                } else {
                    return false;
                }
            }
            return invokeZ.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public int b;
        public int c;
        public int d;
        public float e;
        public int f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ su1 h;

        public d(su1 su1Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su1Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = su1Var;
            this.g = z;
            this.a = 0.0f;
            this.b = this.h.h - this.h.a.getTopMargin();
            int topMargin = this.h.a.getTopMargin() - this.h.a.getMinTopMargin();
            this.c = topMargin;
            topMargin = this.g ? this.b : topMargin;
            this.d = topMargin;
            this.e = topMargin * this.h.f;
            this.f = this.h.a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && this.h.a != null && valueAnimator != null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (this.h.c) {
                    f = this.d;
                } else {
                    f = this.e;
                }
                int i = (int) (f * (floatValue - this.a));
                if (this.g) {
                    i = 0 - i;
                }
                this.f -= i;
                this.h.a.scrollBy(0, i);
                this.h.a.setTopMargin(this.f);
                this.a = floatValue;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ su1 b;

        public e(su1 su1Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su1Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = su1Var;
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && this.b.a != null) {
                this.b.i(this.a);
            }
        }
    }

    public su1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = true;
        this.d = 0.25d;
        this.i = true;
        this.j = new a(this);
        this.k = new b(this);
        this.b = context;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.h > 0 && this.a != null && this.g != null) {
            n(z);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.h = i;
        }
    }

    public void p(mw2 mw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mw2Var) == null) {
            this.g = mw2Var;
        }
    }

    public final void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (valueAnimator = this.e) != null) {
            valueAnimator.cancel();
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ValueAnimator valueAnimator = this.e;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (webViewContainer = this.a) != null && this.g != null) {
            if (z) {
                if (this.c) {
                    webViewContainer.scrollBy(0, -(this.h - webViewContainer.getTopMargin()));
                    this.a.setTopMargin(this.h);
                }
                if (!this.g.n() && !this.g.m()) {
                    this.g.s();
                }
                this.i = true;
                return;
            }
            if (this.c) {
                webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.a.getMinTopMargin());
                WebViewContainer webViewContainer2 = this.a;
                webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
            }
            if (this.g.n()) {
                this.g.p();
            }
            this.i = false;
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048582, this, z) != null) || this.a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.e = ofFloat;
        ofFloat.setDuration(100L);
        this.e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.a.getYVelocity() >= 0.0f) {
            this.f = this.a.getYVelocity() / 4000.0f;
        } else {
            this.f = (-this.a.getYVelocity()) / 4000.0f;
        }
        this.f = Math.min(this.f, 1.0f);
        this.e.addUpdateListener(new d(this, z));
        this.e.addListener(new e(this, z));
        this.e.start();
    }

    public WebViewContainer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewContainer webViewContainer = new WebViewContainer(this.b);
            this.a = webViewContainer;
            webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.a.setClipChildren(false);
            this.a.setLayerType(2, null);
            this.a.setTopLimit(this.h);
            this.a.setTopMargin(this.h);
            this.a.setAutoScroll2TopListener(this.j);
            this.a.setOnUpListener(this.k);
            this.a.setMinFlingVelocity(1000);
            this.a.setUpYVelocityRatio(3.5f);
            this.a.setInterceptFlingListener(new c(this));
            return this.a;
        }
        return (WebViewContainer) invokeV.objValue;
    }
}
