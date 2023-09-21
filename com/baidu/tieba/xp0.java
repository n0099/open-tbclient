package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.j91;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class xp0 {
    public static /* synthetic */ Interceptable $ic;
    public static Handler a;
    public static boolean b;
    public static Runnable c;
    public static WeakReference<c91> d;
    public static final b e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes8.dex */
        public static final class a implements j91 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k91 a;
            public final /* synthetic */ long b;

            public a(k91 k91Var, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k91Var, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = k91Var;
                this.b = j;
            }

            @Override // com.baidu.tieba.j91
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    wp0.j(this.a.f());
                }
            }

            @Override // com.baidu.tieba.j91
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    j91.a.a(this);
                }
            }

            @Override // com.baidu.tieba.j91
            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    wp0.t(this.a.f());
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
            @Override // com.baidu.tieba.j91
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void b() {
                String str;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.a.d() == -1) {
                    return;
                }
                String valueOf = String.valueOf((System.currentTimeMillis() - this.b) / 1000);
                String l = this.a.l();
                if (l != null) {
                    int hashCode = l.hashCode();
                    if (hashCode != 48) {
                        if (hashCode == 49 && l.equals("1")) {
                            str = ClogBuilder.Area.REWARD_FORM.type;
                        }
                    } else if (l.equals("0")) {
                        str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                    }
                    String daPage = str;
                    if (!xp0.b) {
                        Intrinsics.checkNotNullExpressionValue(daPage, "daPage");
                        ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
                        String e = this.a.e();
                        String f = this.a.f();
                        Intrinsics.checkNotNullExpressionValue(f, "model.ext");
                        wp0.u(daPage, logType, e, f, valueOf, "1");
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(daPage, "daPage");
                    ClogBuilder.LogType logType2 = ClogBuilder.LogType.FREE_CLICK;
                    String e2 = this.a.e();
                    String f2 = this.a.f();
                    Intrinsics.checkNotNullExpressionValue(f2, "model.ext");
                    wp0.u(daPage, logType2, e2, f2, valueOf, "1");
                    return;
                }
                str = ClogBuilder.Area.REWARD_LANDING_PAGE.type;
                String daPage2 = str;
                if (!xp0.b) {
                }
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @JvmStatic
        public final void a() {
            c91 c91Var;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            WeakReference weakReference = xp0.d;
            if (weakReference != null && (c91Var = (c91) weakReference.get()) != null) {
                c91Var.f();
            }
            c();
        }

        @JvmStatic
        public final boolean b() {
            InterceptResult invokeV;
            c91 c91Var;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return invokeV.booleanValue;
            }
            WeakReference weakReference = xp0.d;
            if (weakReference != null && (c91Var = (c91) weakReference.get()) != null && c91Var.isShowing()) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                xp0.a.removeCallbacks(xp0.c);
                xp0.b = false;
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void d(Context context, k91 model) {
            c91 c91Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, context, model) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(model, "model");
                if (!q91.a()) {
                    WeakReference weakReference = xp0.d;
                    if (weakReference != null && (c91Var = (c91) weakReference.get()) != null && c91Var.isShowing()) {
                        return;
                    }
                    if (model.d() != -1) {
                        xp0.a.postDelayed(xp0.c, model.d());
                    }
                    if (!(context instanceof Activity)) {
                        ib1.d(new IllegalArgumentException("Error, WebPanel need context is Activity."));
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    ip0 a2 = mp0.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "NadRewardVideoLpRuntime.getUIProvider()");
                    c91 c91Var2 = new c91(context, a2.x());
                    c91Var2.j(new a(model, currentTimeMillis));
                    model.O(true);
                    model.R(true);
                    model.Q(!model.c());
                    model.F(model.c());
                    model.G(model.c());
                    model.H(true);
                    model.N(false);
                    Unit unit = Unit.INSTANCE;
                    c91Var2.i(model);
                    c91Var2.k();
                    xp0.d = new WeakReference(c91Var2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-281848012, "Lcom/baidu/tieba/xp0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-281848012, "Lcom/baidu/tieba/xp0$a;");
                    return;
                }
            }
            a = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            xp0.b = true;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948307921, "Lcom/baidu/tieba/xp0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948307921, "Lcom/baidu/tieba/xp0;");
                return;
            }
        }
        e = new b(null);
        a = new Handler(Looper.getMainLooper());
        c = a.a;
    }
}
