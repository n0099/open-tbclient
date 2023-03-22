package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.ad.FrsAdVideoView;
import com.baidu.tieba.frs.ad.ScanningView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigDecimal;
/* loaded from: classes6.dex */
public class ry6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    public final ScanningView b;
    public final Activity c;
    public final b9<?> d;
    public final ViewGroup e;
    public final FrsAdVideoView f;
    public final TbImageView g;
    public final AnimatorSet h;
    public final AnimatorSet i;
    public long j;
    public ForumData k;
    public la9 l;
    public Dialog m;
    public int n;
    public int o;
    public final n p;

    /* loaded from: classes6.dex */
    public interface n {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    /* loaded from: classes6.dex */
    public interface o extends View.OnClickListener {
        void K(int i);
    }

    /* loaded from: classes6.dex */
    public class a implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry6 a;

        /* renamed from: com.baidu.tieba.ry6$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0416a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0416a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.p();
                }
            }
        }

        public a(ry6 ry6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry6Var;
        }

        @Override // com.baidu.tieba.ry6.o
        public void K(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 3) {
                this.a.a.post(new RunnableC0416a(this));
                this.a.p.f();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && !lt5.a(this.a.c, this.a.l.i())) {
                k87.b((TbPageContext) g9.a(this.a.c), this.a.l.k(), this.a.l.p(), this.a.l.j());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ViewGroup.LayoutParams e;
        public final /* synthetic */ ry6 f;

        public b(ry6 ry6Var, int i, int i2, int i3, int i4, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ry6Var;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = this.a;
                int i2 = i - ((int) ((i - this.b) * floatValue));
                int i3 = this.c;
                int i4 = i3 - ((int) ((i3 - this.d) * floatValue));
                ViewGroup.LayoutParams layoutParams = this.e;
                if (i2 != layoutParams.width || i4 != layoutParams.height) {
                    ViewGroup.LayoutParams layoutParams2 = this.e;
                    layoutParams2.width = i2;
                    layoutParams2.height = i4;
                    ry6 ry6Var = this.f;
                    FrsAdVideoView frsAdVideoView = ry6Var.f;
                    int i5 = this.f.n;
                    int i6 = this.f.o;
                    ViewGroup.LayoutParams layoutParams3 = this.e;
                    ry6Var.v(frsAdVideoView, i5, i6, layoutParams3.width, layoutParams3.height, this.f.e.getHeight());
                    this.f.f.setLayoutParams(this.e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry6 a;

        public c(ry6 ry6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry6Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 2));
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.b.e();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry6 a;

        public d(ry6 ry6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry6Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.f.setVisibility(8);
                lg.a(this.a.m, this.a.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry6 a;

        public e(ry6 ry6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry6Var;
        }

        @Override // com.baidu.tieba.ry6.n
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i87.a("common_click", this.a.l, this.a.k, 2, "video");
            }
        }

        @Override // com.baidu.tieba.ry6.n
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                i87.k("common_exp", this.a.l, this.a.k, 2, "video");
            }
        }

        @Override // com.baidu.tieba.ry6.n
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                i87.a("common_click", this.a.l, this.a.k, 2, "frontpage");
            }
        }

        @Override // com.baidu.tieba.ry6.n
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                i87.g("c14592", this.a.l, this.a.k);
            }
        }

        @Override // com.baidu.tieba.ry6.n
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                i87.k("common_exp", this.a.l, this.a.k, 2, "frontpage");
            }
        }

        @Override // com.baidu.tieba.ry6.n
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                i87.g("c14593", this.a.l, this.a.k);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry6 a;

        public f(ry6 ry6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry6Var;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                if (i == 4) {
                    this.a.p.f();
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(ry6 ry6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                w05.r("frsAd");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ViewGroup.LayoutParams e;
        public final /* synthetic */ ry6 f;

        public h(ry6 ry6Var, int i, int i2, int i3, int i4, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ry6Var;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = this.a;
                int i2 = i + ((int) ((this.b - i) * floatValue));
                int i3 = this.c;
                int i4 = i3 + ((int) ((this.d - i3) * floatValue));
                ViewGroup.LayoutParams layoutParams = this.e;
                if (i2 != layoutParams.width || i4 != layoutParams.height) {
                    ViewGroup.LayoutParams layoutParams2 = this.e;
                    layoutParams2.width = i2;
                    layoutParams2.height = i4;
                    ry6 ry6Var = this.f;
                    FrsAdVideoView frsAdVideoView = ry6Var.f;
                    int i5 = this.f.n;
                    int i6 = this.f.o;
                    ViewGroup.LayoutParams layoutParams3 = this.e;
                    ry6Var.v(frsAdVideoView, i5, i6, layoutParams3.width, layoutParams3.height, this.f.e.getHeight());
                    this.f.f.setLayoutParams(this.e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ry6 d;

        public i(ry6 ry6Var, ViewGroup.LayoutParams layoutParams, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var, layoutParams, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ry6Var;
            this.a = layoutParams;
            this.b = i;
            this.c = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                int[] iArr = new int[2];
                this.d.b.getLocationInWindow(iArr);
                ry6 ry6Var = this.d;
                ry6Var.n = iArr[0] + (ry6Var.b.getWidth() / 2);
                ry6 ry6Var2 = this.d;
                ry6Var2.o = iArr[1] + (ry6Var2.b.getHeight() / 2);
                ViewGroup.LayoutParams layoutParams = this.a;
                layoutParams.width = this.b;
                layoutParams.height = this.c;
                ry6 ry6Var3 = this.d;
                FrsAdVideoView frsAdVideoView = ry6Var3.f;
                int i = this.d.n;
                int i2 = this.d.o;
                ViewGroup.LayoutParams layoutParams2 = this.a;
                ry6Var3.v(frsAdVideoView, i, i2, layoutParams2.width, layoutParams2.height, this.d.e.getHeight());
                this.d.f.setLayoutParams(this.a);
                this.d.f.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ViewGroup.LayoutParams c;
        public final /* synthetic */ ry6 d;

        public j(ry6 ry6Var, int i, int i2, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var, Integer.valueOf(i), Integer.valueOf(i2), layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ry6Var;
            this.a = i;
            this.b = i2;
            this.c = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int l = this.a + ((int) ((hi.l(this.d.c) - this.a) * floatValue));
                int height = this.b + ((int) ((this.d.e.getHeight() - this.b) * floatValue));
                ViewGroup.LayoutParams layoutParams = this.c;
                if (l != layoutParams.width || height != layoutParams.height) {
                    ViewGroup.LayoutParams layoutParams2 = this.c;
                    layoutParams2.width = l;
                    layoutParams2.height = height;
                    ry6 ry6Var = this.d;
                    FrsAdVideoView frsAdVideoView = ry6Var.f;
                    int i = this.d.n;
                    int i2 = this.d.o;
                    ViewGroup.LayoutParams layoutParams3 = this.c;
                    ry6Var.v(frsAdVideoView, i, i2, layoutParams3.width, layoutParams3.height, this.d.e.getHeight());
                    this.d.f.setLayoutParams(this.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry6 a;

        public k(ry6 ry6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry6Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.f.y(1000L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry6 a;

        public l(ry6 ry6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry6Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (new BigDecimal(floatValue).compareTo(new BigDecimal(this.a.g.getAlpha())) != 0) {
                    this.a.g.setAlpha(floatValue);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ ry6 b;

        public m(ry6 ry6Var, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ry6Var;
            this.a = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = this.a;
                if (intValue != layoutParams.height) {
                    layoutParams.height = intValue;
                    ry6 ry6Var = this.b;
                    FrsAdVideoView frsAdVideoView = ry6Var.f;
                    int i = this.b.n;
                    int i2 = this.b.o;
                    ViewGroup.LayoutParams layoutParams2 = this.a;
                    ry6Var.v(frsAdVideoView, i, i2, layoutParams2.width, layoutParams2.height, this.b.e.getHeight());
                    this.b.f.setLayoutParams(this.a);
                }
            }
        }
    }

    public ry6(Context context, View view2, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, tbImageView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new AnimatorSet();
        this.i = new AnimatorSet();
        this.p = new e(this);
        this.a = view2;
        this.g = tbImageView;
        this.b = (ScanningView) view2.findViewById(R.id.obfuscated_res_0x7f090d1f);
        if (!(context instanceof b9)) {
            this.c = null;
            this.e = null;
            this.f = null;
            this.d = null;
            return;
        }
        b9<?> b9Var = (b9) context;
        this.d = b9Var;
        Activity pageActivity = b9Var.getPageContext().getPageActivity();
        this.c = pageActivity;
        this.e = (ViewGroup) pageActivity.findViewById(16908290);
        FrsAdVideoView frsAdVideoView = new FrsAdVideoView(this.c);
        this.f = frsAdVideoView;
        frsAdVideoView.setVisibility(8);
        this.f.setStateListener(new a(this));
        this.f.setFrsAdVideoStatisticListener(this.p);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c != null && this.e != null && this.f != null) {
            int[] iArr = new int[2];
            this.b.getLocationInWindow(iArr);
            this.n = iArr[0] + (this.b.getWidth() / 2);
            this.o = iArr[1] + (this.b.getHeight() / 2);
            ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(this.e.getHeight(), this.e.getWidth());
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new m(this, layoutParams));
            int width = this.e.getWidth();
            int width2 = (this.e.getWidth() * 3) / 4;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(200L);
            ofFloat.addUpdateListener(new b(this, width, width2, this.e.getWidth(), width2 / 5, layoutParams));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat2.setDuration(320L);
            ofFloat2.addListener(new c(this));
            ofFloat2.setStartDelay(640L);
            ofFloat2.start();
            this.i.addListener(new d(this));
            this.i.play(ofInt).before(ofFloat);
            this.i.start();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Dialog dialog = new Dialog(this.c, R.style.obfuscated_res_0x7f1001b6);
            this.m = dialog;
            dialog.requestWindowFeature(1);
            this.m.setContentView(this.f);
            this.m.setCancelable(true);
            this.m.setCanceledOnTouchOutside(true);
            if (this.m.getWindow() != null) {
                this.m.getWindow().getDecorView().setSystemUiVisibility(1280);
                this.m.getWindow().addFlags(Integer.MIN_VALUE);
                this.m.getWindow().setStatusBarColor(0);
                this.m.getWindow().setNavigationBarColor(0);
                WindowManager.LayoutParams attributes = this.m.getWindow().getAttributes();
                if (attributes != null) {
                    attributes.width = -1;
                    attributes.height = -1;
                    if (Build.VERSION.SDK_INT >= 28) {
                        attributes.layoutInDisplayCutoutMode = 1;
                    }
                    this.m.getWindow().setAttributes(attributes);
                }
            }
            this.m.setOnKeyListener(new f(this));
            this.m.setOnDismissListener(new g(this));
            this.m.show();
            m35 m2 = m35.m();
            m2.A("key_frs_video_ad_last_show_time" + this.j, System.currentTimeMillis());
            this.p.e();
            w05.l("frsAd");
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.c != null && this.e != null && this.f != null) {
            t();
            ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
            int width = this.b.getWidth() / 3;
            int height = this.b.getHeight() / 9;
            int l2 = (hi.l(this.c) * 2) / 3;
            int l3 = (hi.l(this.c) * 2) / 3;
            int[] iArr = new int[2];
            this.b.getLocationInWindow(iArr);
            this.n = iArr[0] + (this.b.getWidth() / 2);
            this.o = iArr[1] + (this.b.getHeight() / 2);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(180L);
            ofFloat.addUpdateListener(new h(this, width, l2, height, l3, layoutParams));
            ofFloat.addListener(new i(this, layoutParams, width, height));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat2.setDuration(520L);
            ofFloat2.addUpdateListener(new j(this, l2, l3, layoutParams));
            this.h.addListener(new k(this));
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat3.setDuration(360L);
            ofFloat3.setStartDelay(240L);
            ofFloat3.addUpdateListener(new l(this));
            ofFloat3.start();
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat4.setDuration(1000L);
            this.h.setStartDelay(300L);
            this.h.play(ofFloat).before(ofFloat2).before(ofFloat4);
            this.h.start();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f.r();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f.isPlayStarted()) {
            this.f.stopPlay();
        }
    }

    public void s(la9 la9Var, ForumData forumData, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{la9Var, forumData, Long.valueOf(j2)}) == null) && this.c != null && this.e != null && this.f != null && la9Var != null && !StringUtils.isNull(la9Var.q())) {
            this.j = j2;
            this.k = forumData;
            this.l = la9Var;
            this.f.setVideoData(la9Var.q(), this.l.b());
            this.b.d();
        }
    }

    public final void v(View view2, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            int i7 = i2 - (i4 / 2);
            int max = Math.max(i3 - (i5 / 2), 0);
            if (max + i5 > i6) {
                max = i6 - i5;
            }
            float f2 = i7;
            if (view2.getX() != f2 || view2.getY() != max) {
                view2.setX(f2);
                view2.setY(max);
            }
        }
    }
}
