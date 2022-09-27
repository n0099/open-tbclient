package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.n19;
import com.baidu.tieba.v19;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q19 extends v19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ValueAnimator h;
    public ValueAnimator i;
    public float j;
    public float k;
    public ValueAnimator l;
    public ValueAnimator m;
    public AnimatorSet n;
    public ValueAnimator o;
    public ValueAnimator p;
    public float q;
    public float r;
    public float s;
    public int t;
    public n19.c u;
    public f06 v;
    public f06 w;

    /* loaded from: classes5.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q19 a;

        public a(q19 q19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q19Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                g06 g06Var = new g06(this.a.s);
                g06Var.d(0.5f);
                g06Var.f(800.0f);
                q19 q19Var = this.a;
                f06 f06Var = new f06(this.a.u.H, d06.m);
                f06Var.m(g06Var);
                q19Var.v = f06Var;
                this.a.v.h();
                q19 q19Var2 = this.a;
                f06 f06Var2 = new f06(this.a.u.s, d06.m);
                f06Var2.m(g06Var);
                q19Var2.w = f06Var2;
                this.a.w.h();
                this.a.u.H.setTranslationY(0.0f);
                this.a.u.s.setTranslationY(0.0f);
                q19 q19Var3 = this.a;
                q19Var3.e = 2;
                v19.a aVar = q19Var3.d;
                if (aVar != null) {
                    aVar.a(2);
                }
                this.a.u.q.setClickable(true);
                this.a.u.n.setClickable(true);
                this.a.u.k.setClickable(true);
                this.a.u.h.setClickable(true);
                this.a.u.x.setClickable(true);
                this.a.u.A.setClickable(true);
                this.a.u.D.setClickable(true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.a.u.q.setClickable(false);
                this.a.u.n.setClickable(false);
                this.a.u.k.setClickable(false);
                this.a.u.h.setClickable(false);
                this.a.u.x.setClickable(false);
                this.a.u.A.setClickable(false);
                this.a.u.D.setClickable(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q19 a;

        public b(q19 q19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q19Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.a.u.H.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.u.H.setTranslationY(this.a.r * valueAnimator.getAnimatedFraction());
                this.a.u.s.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.u.s.setTranslationY(this.a.r * valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q19 a;

        public c(q19 q19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q19Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.u.H.setAlpha(0.0f);
                this.a.u.H.setTranslationY(this.a.r);
                this.a.u.s.setAlpha(0);
                this.a.u.s.setTranslationY(this.a.r);
                this.a.A();
                this.a.u.q.setClickable(true);
                this.a.u.n.setClickable(true);
                this.a.u.k.setClickable(true);
                this.a.u.h.setClickable(true);
                this.a.u.x.setClickable(true);
                this.a.u.A.setClickable(true);
                this.a.u.D.setClickable(true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.a.u.q.setClickable(false);
                this.a.u.n.setClickable(false);
                this.a.u.k.setClickable(false);
                this.a.u.h.setClickable(false);
                this.a.u.x.setClickable(false);
                this.a.u.A.setClickable(false);
                this.a.u.D.setClickable(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q19 a;

        public d(q19 q19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q19Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q19 q19Var = this.a;
                if (q19Var.f != null && q19Var.j == 0.0f && this.a.k == 0.0f) {
                    this.a.u.G.getGlobalVisibleRect(this.a.g);
                    q19 q19Var2 = this.a;
                    q19Var2.j = q19Var2.f.centerX() - this.a.g.centerX();
                    q19 q19Var3 = this.a;
                    q19Var3.k = q19Var3.f.centerY() - this.a.g.centerY();
                }
                this.a.u.G.setVisibility(0);
                this.a.u.G.setTranslationX(this.a.j);
                this.a.u.G.setTranslationY(this.a.k);
                q19 q19Var4 = this.a;
                View view2 = q19Var4.c;
                if (view2 instanceof OvalActionButton) {
                    ((OvalActionButton) view2).b(q19Var4.u.G);
                }
                this.a.h.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q19 a;

        public e(q19 q19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q19Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (!(this.a.j == 0.0f && this.a.k == 0.0f) && valueAnimator.isRunning()) {
                    this.a.u.G.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    this.a.u.G.setTranslationX(this.a.j - (this.a.j * valueAnimator.getAnimatedFraction()));
                    this.a.u.G.setTranslationY(this.a.k - (this.a.k * valueAnimator.getAnimatedFraction()));
                    this.a.u.G.setRotation(valueAnimator.getAnimatedFraction() * (-90.0f));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q19 a;

        public f(q19 q19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q19Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.u.G.setTranslationX(0.0f);
                this.a.u.G.setTranslationY(0.0f);
                this.a.u.G.setRotation(-90.0f);
                this.a.u.G.setEndIcon(R.drawable.obfuscated_res_0x7f080955, this.a.t, "webp");
                this.a.u.G.setCrossFade(1.0f, false);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                View view2 = this.a.c;
                if (view2 != null) {
                    view2.setVisibility(4);
                    this.a.c.setAlpha(0.0f);
                }
                this.a.u.G.setEndIcon(R.drawable.obfuscated_res_0x7f080955, this.a.t, "webp");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q19 a;

        public g(q19 q19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q19Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (!(this.a.j == 0.0f && this.a.k == 0.0f) && valueAnimator.isRunning()) {
                    this.a.u.G.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    this.a.u.G.setTranslationX(this.a.j * valueAnimator.getAnimatedFraction());
                    this.a.u.G.setTranslationY(this.a.k * valueAnimator.getAnimatedFraction());
                    this.a.u.G.setRotation((valueAnimator.getAnimatedFraction() * 90.0f) - 90.0f);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q19 a;

        public h(q19 q19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q19Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.u.G.setTranslationX(this.a.j);
                this.a.u.G.setTranslationY(this.a.k);
                this.a.u.G.setRotation(0.0f);
                this.a.u.G.setEndIcon(0, 0, "");
                this.a.u.G.setCrossFade(1.0f, true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.a.u.G.setEndIcon(R.drawable.obfuscated_res_0x7f080955, this.a.t, "webp");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q19 a;

        public i(q19 q19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q19Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.a.u.H.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.u.s.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.u.e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.u.f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q19 a;

        public j(q19 q19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q19Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.u.H.setAlpha(1.0f);
                this.a.u.s.setAlpha(1);
                this.a.u.e.setAlpha(1.0f);
                this.a.u.f.setAlpha(1.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q19 a;

        public k(q19 q19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q19Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.a.u.e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.u.f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q19 a;

        public l(q19 q19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q19Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.u.e.setAlpha(0.0f);
                this.a.u.f.setAlpha(0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q19 a;

        public m(q19 q19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q19Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.a.u.H.setTranslationY(this.a.q - (this.a.q * valueAnimator.getAnimatedFraction()));
                this.a.u.s.setTranslationY(this.a.q - (this.a.q * valueAnimator.getAnimatedFraction()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q19(Context context, n19.c cVar) {
        super(context, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (n19) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ej.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.u = cVar;
        this.t = ej.f(this.a, R.dimen.tbds0);
        z();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View view2 = this.c;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            this.e = 4;
            x();
            B(8);
            this.u.G.setVisibility(4);
            View view3 = this.c;
            if (view3 != null) {
                view3.setVisibility(0);
                this.c.setAlpha(1.0f);
            }
            v19.a aVar = this.d;
            if (aVar != null) {
                aVar.a(this.e);
            }
        }
    }

    public final void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.u.f.setVisibility(i2);
            this.u.e.setVisibility(i2);
            this.u.H.setVisibility(i2);
            this.u.s.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.v19
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            A();
        }
    }

    @Override // com.baidu.tieba.v19
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            x();
        }
    }

    @Override // com.baidu.tieba.v19
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.e == 4) {
            this.e = 1;
            v19.a aVar = this.d;
            if (aVar != null) {
                aVar.a(1);
            }
            x();
            B(0);
            this.l.start();
            this.n.start();
            y();
        }
    }

    @Override // com.baidu.tieba.v19
    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.e == 2) {
            this.e = 3;
            v19.a aVar = this.d;
            if (aVar != null) {
                aVar.a(3);
            }
            x();
            this.m.start();
            this.i.start();
            this.p.start();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h.cancel();
            this.i.cancel();
            this.m.cancel();
            this.l.cancel();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.u.G.post(new d(this));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.n = new AnimatorSet();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.h = ofFloat;
            ofFloat.setDuration(450L);
            this.h.setInterpolator(new OvershootInterpolator());
            this.h.addUpdateListener(new e(this));
            this.h.addListener(new f(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.i = ofFloat2;
            ofFloat2.setDuration(450L);
            this.i.setInterpolator(new AccelerateInterpolator());
            this.i.addUpdateListener(new g(this));
            this.i.addListener(new h(this));
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.l = ofFloat3;
            ofFloat3.setDuration(416L);
            this.l.addUpdateListener(new i(this));
            this.l.addListener(new j(this));
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.m = ofFloat4;
            ofFloat4.setDuration(200L);
            this.m.addUpdateListener(new k(this));
            this.m.addListener(new l(this));
            ValueAnimator ofFloat5 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.o = ofFloat5;
            ofFloat5.setDuration(240L);
            this.o.addUpdateListener(new m(this));
            this.n.addListener(new a(this));
            ValueAnimator ofFloat6 = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.p = ofFloat6;
            ofFloat6.setDuration(200L);
            this.p.addUpdateListener(new b(this));
            this.p.addListener(new c(this));
            this.u.j.setVisibility(0);
            this.u.g.setVisibility(0);
            this.u.m.setVisibility(0);
            this.u.p.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.u.x.setVisibility(0);
            if (this.u.A.getVisibility() != 8) {
                this.u.A.setVisibility(0);
            }
            this.q = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds360);
            this.s = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds25);
            this.r = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds177);
            this.n.play(this.o);
        }
    }
}
