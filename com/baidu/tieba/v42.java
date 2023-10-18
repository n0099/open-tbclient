package com.baidu.tieba;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.appframework.AppFrameworkConstants;
import com.baidu.searchbox.appframework.fragment.BaseFragment;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tieba.ua3;
import com.baidu.tieba.xi2;
import com.baidu.tieba.y42;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class v42 extends Fragment implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean F0;
    public transient /* synthetic */ FieldHolder $fh;
    public p A0;
    public boolean B0;
    public g52 C0;
    public double D0;
    public boolean E0;
    public final String b0;
    public Activity c0;
    public qv2 d0;
    public View e0;
    public SwanAppActionBar f0;
    public wb4 g0;
    public SwanAppMenuHeaderView h0;
    public View i0;
    public TextView j0;
    public TextView r0;
    public Button s0;
    public AtomicBoolean t0;
    @Nullable
    public qk3 u0;
    public boolean v0;
    public SlideHelper w0;
    public int x0;
    public int y0;
    public o z0;

    /* loaded from: classes8.dex */
    public interface p {
        void a();
    }

    public abstract boolean G();

    public e63 M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (e63) invokeV.objValue;
    }

    public void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    public boolean h2(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048636, this, new Object[]{Double.valueOf(d2)})) == null) ? d2 >= 0.0d && d2 <= 1.0d : invokeCommon.booleanValue;
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public abstract boolean j2();

    public abstract boolean l2();

    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
        }
    }

    public abstract void q2();

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v42 a;

        /* loaded from: classes8.dex */
        public class a implements b72<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.b72
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                    this.a.a.o2();
                }
            }
        }

        public g(v42 v42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v42Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (vi2.b().c()) {
                    vi2.b().f(this.a.c0, new a(this));
                } else {
                    this.a.o2();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v42 a;

        /* loaded from: classes8.dex */
        public class a implements ik3<sa3<ua3.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ik3
            /* renamed from: b */
            public void a(sa3<ua3.e> sa3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                    if (!na3.h(sa3Var)) {
                        this.a.a.t2();
                    } else {
                        this.a.a.x2();
                    }
                }
            }
        }

        public i(v42 v42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v42Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.a.c0) != null && (activity instanceof SwanAppActivity)) {
                p53 c0 = p53.c0();
                if (c0 != null && !TextUtils.isEmpty(c0.getAppId())) {
                    if (ci3.f() && uh4.a().d()) {
                        c0.f0().g(c0.w(), "mapp_emit_app_close", new a(this));
                        return;
                    } else {
                        this.a.t2();
                        return;
                    }
                }
                this.a.F1();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ View c;
        public final /* synthetic */ v42 d;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                    return;
                }
                this.a.d.v2();
            }
        }

        /* loaded from: classes8.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public b(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                    return;
                }
                this.a.d.X2();
            }
        }

        public l(v42 v42Var, boolean z, boolean z2, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var, Boolean.valueOf(z), Boolean.valueOf(z2), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = v42Var;
            this.a = z;
            this.b = z2;
            this.c = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a && !this.b) {
                    return;
                }
                v42 v42Var = this.d;
                if (v42Var.s0 == null) {
                    View view2 = this.c;
                    if (view2 == null) {
                        p22.b("SwanAppBaseFragment", "view为null");
                        return;
                    }
                    v42Var.s0 = (Button) view2.findViewById(R.id.obfuscated_res_0x7f092345);
                }
                this.d.s0.setVisibility(0);
                if (this.a) {
                    this.d.s0.setOnClickListener(new a(this));
                }
                if (!this.b) {
                    return;
                }
                this.d.t0 = new AtomicBoolean(false);
                this.d.s0.setText(R.string.obfuscated_res_0x7f0f159f);
                this.d.s0.setOnClickListener(new b(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v42 a;

        public a(v42 v42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v42Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.H1(o13.E());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ v42 b;

        public b(v42 v42Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v42Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActionBar swanAppActionBar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v42 v42Var = this.b;
                if (v42Var.c0 != null && (swanAppActionBar = v42Var.f0) != null) {
                    if (this.a) {
                        if (v42Var.j0 == null) {
                            v42Var.j0 = new TextView(this.b.c0);
                        }
                        if (!(this.b.j0.getParent() instanceof SwanAppActionBar)) {
                            this.b.j0.setText(R.string.obfuscated_res_0x7f0f0174);
                            v42 v42Var2 = this.b;
                            v42Var2.j0.setTextColor(v42Var2.P1().getColor(17170455));
                            v42 v42Var3 = this.b;
                            v42Var3.f0.addView(v42Var3.j0);
                            return;
                        }
                        return;
                    }
                    TextView textView = v42Var.j0;
                    if (textView != null) {
                        swanAppActionBar.removeView(textView);
                        this.b.j0 = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v42 a;

        public c(v42 v42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v42Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ik3<sa3<ua3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v42 a;

        public d(v42 v42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (na3.h(sa3Var)) {
                    this.a.w0.setRegionFactor(0.1d);
                    v42 v42Var = this.a;
                    v42Var.D0 = 0.1d;
                    v42Var.w0.setCanSlide(v42Var.E1());
                    return;
                }
                v42 v42Var2 = this.a;
                v42Var2.w0.setCanSlide(v42Var2.E1());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v42 a;

        public e(v42 v42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v42Var;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r2();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.K1();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view2, f) == null) {
                View maskView = this.a.w0.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                this.a.s2(f);
                if (this.a.A0 != null) {
                    this.a.A0.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v42 a;

        public f(v42 v42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v42Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dw2.d();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v42 a;

        public h(v42 v42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v42Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.q2();
                sc3 sc3Var = new sc3();
                sc3Var.e = "menu";
                if (p53.c0() != null && p53.c0().V().d("key_unread_counts_message", 0).intValue() > 0) {
                    sc3Var.g = String.valueOf(1);
                }
                this.a.G1(sc3Var);
                if (this.a.z0 != null) {
                    this.a.z0.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements b72<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v42 a;

        public j(v42 v42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b72
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                this.a.F1();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ v42 b;

        public k(v42 v42Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v42Var;
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || nb3.g()) {
                return;
            }
            this.b.I1(this.a, nb3.d(), nb3.f());
        }
    }

    /* loaded from: classes8.dex */
    public class m implements xi2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v42 a;

        public m(v42 v42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v42Var;
        }

        @Override // com.baidu.tieba.xi2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F1();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v42 a;

        public n(v42 v42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v42Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public Runnable c;
        public final /* synthetic */ v42 d;

        public o(v42 v42Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v42Var, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = v42Var;
            this.a = 0;
            this.b = 0L;
            this.c = runnable;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.b > 1333) {
                    this.b = currentTimeMillis;
                    this.a = 1;
                    return;
                }
                int i = this.a + 1;
                this.a = i;
                if (i == 3) {
                    Runnable runnable = this.c;
                    if (runnable != null) {
                        runnable.run();
                    }
                    this.a = 0;
                    this.b = 0L;
                    return;
                }
                this.b = currentTimeMillis;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948190741, "Lcom/baidu/tieba/v42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948190741, "Lcom/baidu/tieba/v42;");
                return;
            }
        }
        F0 = am1.a;
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.u0 == null) {
            return;
        }
        C1(this.y0);
    }

    public final boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (P1().getConfiguration().orientation != 2 && Build.VERSION.SDK_INT != 26) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final xi2.b L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return new m(this);
        }
        return (xi2.b) invokeV.objValue;
    }

    public int N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (TextUtils.isEmpty(p53.h0())) {
                return 0;
            }
            if (nc2.n(p53.h0())) {
                return 2;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Nullable
    public qk3 O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.u0;
        }
        return (qk3) invokeV.objValue;
    }

    public final Resources P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (n0()) {
                return J();
            }
            return AppRuntime.getAppContext().getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public SwanAppActionBar Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.f0;
        }
        return (SwanAppActionBar) invokeV.objValue;
    }

    public View R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.e0;
        }
        return (View) invokeV.objValue;
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.w0.setSlideListener(new e(this));
        }
    }

    public final y42 S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            Activity activity = this.c0;
            if (activity == null) {
                return null;
            }
            return ((SwanAppActivity) activity).Y();
        }
        return (y42) invokeV.objValue;
    }

    public qv2 T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.d0;
        }
        return (qv2) invokeV.objValue;
    }

    public boolean U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.g(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public wb4 V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.g0;
        }
        return (wb4) invokeV.objValue;
    }

    public void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            y83.f("backtohome", "menu", cr2.V().g());
            sc3 sc3Var = new sc3();
            sc3Var.e = "gohome";
            sc3Var.c = "menu";
            G1(sc3Var);
        }
    }

    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.g(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            iz2.e().d(new a(this), "updateCtsView", false);
        }
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.v0;
        }
        return invokeV.booleanValue;
    }

    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            Activity activity = this.c0;
            if (!(activity instanceof SwanAppActivity) || ((SwanAppActivity) activity).R() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            y42 S1 = S1();
            if (S1 == null || S1.k() <= 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            if (this.y0 == -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(p53.h0());
        }
        return invokeV.booleanValue;
    }

    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.f0.setLeftHomeViewVisibility(0);
            this.f0.setLeftHomeViewClickListener(new c(this));
        }
    }

    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            Activity activity = this.c0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).q0(2);
            } else if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            this.C0.c();
            super.onPause();
        }
    }

    public void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            V2(false, 1.0f);
        }
    }

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            Button button = this.s0;
            if (button != null) {
                button.setVisibility(8);
            }
            TextView textView = this.r0;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (nb3.d()) {
                nb3.l(true);
            }
        }
    }

    public void w2() {
        qk3 qk3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048657, this) == null) && !this.E0 && a2() && (qk3Var = this.u0) != null) {
            qk3Var.l();
        }
    }

    public final void x2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            String D = cr2.V().D();
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, D);
            cr2.V().v(new qf2("closeBtn", hashMap));
        }
    }

    public v42() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b0 = UUID.randomUUID().toString();
        this.v0 = qk3.i;
        this.x0 = 1;
        this.y0 = 1;
        this.B0 = false;
        this.D0 = -1.0d;
        this.E0 = false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (F0) {
                Log.d("SwanAppBaseFragment", "onDetach");
            }
            this.c0 = null;
            Y1(false);
            super.F0();
            try {
                Field declaredField = Fragment.class.getDeclaredField("u");
                declaredField.setAccessible(true);
                declaredField.set(this, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.c0 != null) {
            dr2.a().d(false);
            this.c0.moveTaskToBack(true);
            y2();
            ((SwanAppActivity) this.c0).Z(1);
            rj3.b().e(2);
        }
    }

    public final void X2() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048623, this) != null) || this.s0 == null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.t0;
        atomicBoolean.set(!atomicBoolean.get());
        boolean z = this.t0.get();
        Button button = this.s0;
        if (z) {
            i2 = R.string.obfuscated_res_0x7f0f15a0;
        } else {
            i2 = R.string.obfuscated_res_0x7f0f159f;
        }
        button.setText(i2);
        nb3.j(z);
    }

    public final void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onClose");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, p53.h0());
            cr2.V().v(new rf2(hashMap));
            p22.i("SwanAppBaseFragment", "onClose");
            sc3 sc3Var = new sc3();
            sc3Var.e = "close";
            G1(sc3Var);
        }
    }

    public boolean A2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            return B2(i2, false);
        }
        return invokeI.booleanValue;
    }

    public void C1(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i2) != null) || this.u0 == null) {
            return;
        }
        D1(i2, false);
    }

    @Nullable
    public boolean C2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return D2(str, false);
        }
        return invokeL.booleanValue;
    }

    public void E2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f0.setLeftBackViewVisibility(z);
        }
    }

    public final void G1(sc3 sc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, sc3Var) == null) {
            Activity activity = this.c0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).N(sc3Var);
            }
        }
    }

    public void G2(boolean z) {
        SlideHelper slideHelper;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (slideHelper = this.w0) != null) {
            if (E1() && z) {
                z2 = true;
            } else {
                z2 = false;
            }
            slideHelper.setCanSlide(z2);
        }
    }

    public final void H1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            jj3.e0(new b(this, z));
        }
    }

    public void H2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.B0 = z;
        }
    }

    public boolean J2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            return K2(i2, "", false);
        }
        return invokeI.booleanValue;
    }

    public void M2(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, pVar) == null) {
            this.A0 = pVar;
        }
    }

    public void N2(double d2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048604, this, new Object[]{Double.valueOf(d2)}) != null) || !h2(d2)) {
            return;
        }
        if (h2(this.D0)) {
            d2 = this.D0;
        }
        this.w0.setRegionFactor(d2);
    }

    public void O2(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048606, this, i2) == null) && (activity = this.c0) != null) {
            activity.setRequestedOrientation(i2);
        }
    }

    public void P2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.f0.setRightExitViewVisibility(z);
        }
    }

    public void Q2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.f0.setRightZoneVisibility(z);
        }
    }

    public void Y2(e52 e52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, e52Var) == null) {
            this.C0.e(e52Var);
        }
    }

    public void a3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, view2) == null) {
            iz2.e().d(new k(this, view2), "updateStabilityDataView", false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void q1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            super.q1(z);
            if (z) {
                w2();
            }
        }
    }

    public void s2(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048652, this, f2) == null) {
            V2(true, f2);
        }
    }

    public void u2(e52 e52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, e52Var) == null) {
            this.C0.d(e52Var);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void w0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, context) == null) {
            if (F0) {
                Log.d("SwanAppBaseFragment", "onAttach");
            }
            this.C0 = new g52();
            super.w0(context);
            this.c0 = m();
            Y1(true);
        }
    }

    public View J1(View view2, SlideInterceptor slideInterceptor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, view2, slideInterceptor)) == null) {
            SlideHelper slideHelper = new SlideHelper();
            this.w0 = slideHelper;
            View wrapSlideView = slideHelper.wrapSlideView(view2.getContext(), view2, slideInterceptor);
            this.w0.setFadeColor(0);
            F2();
            R2();
            return wrapSlideView;
        }
        return (View) invokeLL.objValue;
    }

    public boolean L2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048600, this, str, z)) == null) {
            return K2(SwanAppConfigData.t(str), str, z);
        }
        return invokeLZ.booleanValue;
    }

    public View e2(FrameLayout frameLayout, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048633, this, frameLayout, view2)) == null) {
            frameLayout.setTag(BaseFragment.IMMERSION_LAYOUT_TAG);
            frameLayout.addView(view2);
            this.u0 = new qk3(this.c0, frameLayout);
            B1();
            return frameLayout;
        }
        return (View) invokeLL.objValue;
    }

    public boolean B2(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar == null || this.i0 == null) {
                return false;
            }
            this.y0 = i2;
            swanAppActionBar.setBackgroundColor(i2);
            e63 M1 = M1();
            if (M1 != null) {
                M1.a = i2;
                M1.g(z);
            }
            if (a2()) {
                B1();
            }
            if (i2()) {
                this.i0.setVisibility(0);
                return true;
            }
            this.i0.setVisibility(8);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void V2(boolean z, float f2) {
        y42 S1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) && (S1 = S1()) != null && S1.k() >= 2) {
            v42 j2 = S1.j(S1.k() - 2);
            n2(f2, j2);
            if (z) {
                if (j2.E0) {
                    W2(S1, f2);
                    return;
                } else {
                    S1.h().o(j2);
                    return;
                }
            }
            S1.h().c(j2);
        }
    }

    public void D1(@ColorInt int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || this.u0 == null) {
            return;
        }
        this.y0 = i2;
        int i3 = this.x0;
        boolean z2 = true;
        if (i3 != 1) {
            if (i3 != -16777216) {
                z2 = false;
            }
        } else {
            z2 = bi3.a(i2);
        }
        this.u0.m(i2, z, z2);
    }

    public boolean D2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.setTitle(str);
            e63 M1 = M1();
            if (M1 != null) {
                M1.b = str;
                M1.g(z);
            }
            p22.i("SwanAppBaseFragment", "page title: " + str);
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public void I2(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar != null) {
                swanAppActionBar.setActionBarCustom(z, z2);
            }
            if (this.i0 != null) {
                int i2 = 8;
                if (!z && i2()) {
                    i2 = 0;
                }
                this.i0.setVisibility(i2);
            }
        }
    }

    public final void W2(y42 y42Var, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(1048621, this, y42Var, f2) == null) && y42Var != null && y42Var.k() >= 3) {
            ArrayList arrayList = new ArrayList();
            int k2 = y42Var.k() - 3;
            while (true) {
                if (k2 < 0) {
                    break;
                }
                v42 j2 = y42Var.j(k2);
                if (j2.E0) {
                    n2(f2, j2);
                    arrayList.add(j2);
                    k2--;
                } else {
                    n2(f2, j2);
                    arrayList.add(j2);
                    break;
                }
            }
            y42Var.h().p(arrayList);
        }
    }

    public final void n2(float f2, Fragment fragment) {
        View i0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{Float.valueOf(f2), fragment}) == null) {
            float o2 = gj3.o(this.c0) >> 2;
            float f3 = (f2 * o2) - o2;
            if (fragment != null && (i0 = fragment.i0()) != null) {
                i0.setX(f3);
            }
        }
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            e63 M1 = M1();
            if (M1 != null && (M1.l || M1.m)) {
                p53 c0 = p53.c0();
                if (c0 != null) {
                    c0.f0().g(c0.w(), "scope_disable_swipe_back", new d(this));
                    return;
                } else {
                    this.w0.setCanSlide(E1());
                    return;
                }
            }
            this.w0.setCanSlide(E1());
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            super.onResume();
            this.C0.b();
            if (F0) {
                Log.d("SwanAppBaseFragment", "onResume");
            }
            if (h0()) {
                w2();
            }
            Z2();
            if (this.g0 != null) {
                boolean d2 = wo2.y0().d();
                wb4 wb4Var = this.g0;
                if (d2 != wb4Var.p) {
                    wb4Var.x();
                    this.g0.p = wo2.y0().d();
                }
            }
        }
    }

    public void I1(View view2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{view2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            jj3.e0(new l(this, z, z2, view2));
        }
    }

    public void K1() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            y42 S1 = S1();
            if (S1 != null && S1.k() != 1) {
                dc3.f(UUID.randomUUID().toString(), 1);
                y42.b i2 = S1.i("navigateBack");
                i2.n(0, 0);
                i2.g();
                i2.a();
                rc3 rc3Var = new rc3();
                rc3Var.e = "back";
                if (g2()) {
                    str = "1";
                } else {
                    str = "0";
                }
                rc3Var.g = str;
                rc3Var.b = AppFrameworkConstants.VALUE_GESTURE_BACK;
                yb3.a(rc3Var, o53.K().q().X());
                yb3.c(rc3Var);
                return;
            }
            Activity activity = this.c0;
            if (activity != null) {
                activity.moveTaskToBack(true);
                rj3.b().e(1);
            }
        }
    }

    public void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            if (vi2.b().c()) {
                vi2.b().f(this.c0, new j(this));
            } else if (xi2.a().b()) {
                F1();
            } else {
                wi2 wi2Var = new wi2();
                wi2Var.h();
                if (wi2Var.j()) {
                    xi2.a().c(this.c0, wi2Var.f(), wi2Var.e(), wi2Var, L1());
                    return;
                }
                F1();
                dw2.e().g();
            }
        }
    }

    public boolean K2(@ColorInt int i2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)})) == null) {
            if (this.f0 == null) {
                return false;
            }
            P2(!this.B0);
            e63 M1 = M1();
            if (M1 != null) {
                if (!TextUtils.isEmpty(str)) {
                    M1.c = str;
                }
                M1.g(z);
            }
            int i3 = -16777216;
            if (i2 != -16777216) {
                i3 = -1;
            }
            if (a2() && i3 != this.x0) {
                this.x0 = i3;
                B1();
            }
            return this.f0.f(i2, this.B0);
        }
        return invokeCommon.booleanValue;
    }

    public boolean S2(FrameLayout frameLayout, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{frameLayout, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (frameLayout == null) {
                return false;
            }
            frameLayout.setBackgroundColor(i2);
            e63 M1 = M1();
            if (M1 != null) {
                M1.e = i2;
                M1.p = z;
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void X1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            FloatButton c2 = f83.d().c();
            if (!z) {
                if (c2 != null && c2.getVisibility() == 0) {
                    c2.setVisibility(8);
                }
            } else if (c2 != null && c2.getVisibility() != 0) {
                c2.setVisibility(0);
            }
        }
    }

    public void Y1(boolean z) {
        y42 W;
        v42 j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (W = cr2.V().W()) != null) {
            if (z) {
                j2 = W.m();
            } else {
                j2 = W.j(W.k() - 1);
            }
            if (j2 == null) {
                return;
            }
            X1(j2.j2());
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (!f2()) {
                gj3.c(this.c0);
            }
            if (a2() && this.u0 != null && configuration.orientation == 1) {
                m().getWindow().clearFlags(1024);
                jj3.f0(new n(this), 200L);
            }
        }
    }

    public void b2(View view2) {
        e63 f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, view2) == null) {
            c2(view2);
            SwanAppConfigData t = cr2.V().t();
            if (t == null) {
                if (F0) {
                    Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            qv2 qv2Var = this.d0;
            if (qv2Var == null) {
                f2 = t.e;
            } else {
                f2 = cr2.V().f(h93.c(qv2Var.i(), t));
            }
            A2(f2.a);
            this.f0.setTitle(f2.b);
            this.z0 = new o(this, new f(this));
            if (!(this instanceof SwanAppAdLandingFragment)) {
                J2(SwanAppConfigData.t(f2.c));
            }
            String str = f2.c;
        }
    }

    public void c2(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048631, this, view2) != null) || view2 == null) {
            return;
        }
        this.f0 = (SwanAppActionBar) view2.findViewById(R.id.obfuscated_res_0x7f09018f);
        this.e0 = view2.findViewById(R.id.obfuscated_res_0x7f090190);
        this.i0 = view2.findViewById(R.id.obfuscated_res_0x7f0925cf);
        this.f0.setLeftBackViewMinWidth(gj3.f(this.c0, 38.0f));
        g gVar = new g(this);
        this.f0.setLeftBackViewClickListener(gVar);
        this.f0.setLeftFloatBackViewClickListener(gVar);
        this.f0.setRightMenuOnClickListener(new h(this));
        this.f0.setRightExitOnClickListener(new i(this));
    }

    public View d2(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            if (BaseFragment.IMMERSION_LAYOUT_TAG.equals(view2.getTag())) {
                return view2;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup != null) {
                if (BaseFragment.IMMERSION_LAYOUT_TAG.equals(viewGroup.getTag())) {
                    return viewGroup;
                }
                viewGroup.removeView(view2);
            }
            FrameLayout frameLayout = new FrameLayout(s());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            e2(frameLayout, view2);
            return frameLayout;
        }
        return (View) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void z2(int i2, String str) {
        char c2;
        TimeInterpolator linearInterpolator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048660, this, i2, str) == null) {
            switch (str.hashCode()) {
                case -1965087616:
                    if (str.equals("easeOut")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1310316109:
                    if (str.equals("easeIn")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1102672091:
                    if (str.equals(Easing.LINEAR_NAME)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1330629787:
                    if (str.equals("easeInOut")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            linearInterpolator = new LinearInterpolator();
                        } else {
                            linearInterpolator = new AccelerateDecelerateInterpolator();
                        }
                    } else {
                        linearInterpolator = new DecelerateInterpolator();
                    }
                } else {
                    linearInterpolator = new AccelerateInterpolator();
                }
            } else {
                linearInterpolator = new LinearInterpolator();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f0, Key.ALPHA, 0.0f, 1.0f);
            long j2 = i2;
            ofFloat.setDuration(j2);
            ofFloat.setInterpolator(linearInterpolator);
            ofFloat.start();
            qk3 qk3Var = this.u0;
            if (qk3Var != null && qk3Var.e() != null) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.u0.e(), Key.ALPHA, 0.0f, 1.0f);
                ofFloat2.setDuration(j2);
                ofFloat2.setInterpolator(linearInterpolator);
                ofFloat2.start();
            }
        }
    }
}
