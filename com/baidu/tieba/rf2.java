package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.u83;
import com.baidu.tieba.w83;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class rf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static f b;
    public static g c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface d {
        void a(u83 u83Var);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(@NonNull u83 u83Var, @Nullable PMSAppInfo pMSAppInfo);
    }

    /* loaded from: classes7.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ PrefetchEvent b;
        public final /* synthetic */ rf2 c;

        public a(rf2 rf2Var, e eVar, PrefetchEvent prefetchEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rf2Var, eVar, prefetchEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rf2Var;
            this.a = eVar;
            this.b = prefetchEvent;
        }

        @Override // com.baidu.tieba.rf2.d
        public void a(u83 u83Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, u83Var) != null) || u83Var == null) {
                return;
            }
            if (!rf2.d && u83Var.E()) {
                this.a.a(u83Var, null);
            } else {
                this.c.f(u83Var, this.b, this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements u83.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(rf2 rf2Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rf2Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.tieba.u83.b
        public void a(u83 u83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u83Var) == null) {
                this.a.a(u83Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends ka2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u83 b;
        public final /* synthetic */ e c;

        public c(rf2 rf2Var, u83 u83Var, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rf2Var, u83Var, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u83Var;
            this.c = eVar;
        }

        @Override // com.baidu.tieba.ka2, com.baidu.tieba.la2.b
        public void a() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (rf2.d && this.b.E()) {
                    z = true;
                } else {
                    z = false;
                }
                if (this.b.S() || z) {
                    this.c.a(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements w83.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
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

        public /* synthetic */ f(a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w83.c
        /* renamed from: b */
        public boolean a(String str, u83 u83Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, u83Var)) == null) {
                PrefetchEvent prefetchEvent = u83Var.f;
                if (prefetchEvent == null) {
                    return false;
                }
                return TextUtils.equals(str, prefetchEvent.appId);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements w83.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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

        public /* synthetic */ g(a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w83.c
        /* renamed from: b */
        public boolean a(String str, u83 u83Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, u83Var)) == null) {
                if (u83Var.E() && TextUtils.equals(str, u83Var.c)) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948119627, "Lcom/baidu/tieba/rf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948119627, "Lcom/baidu/tieba/rf2;");
                return;
            }
        }
        a = fs1.a;
        b = new f(null);
        c = new g(null);
        d = vf2.p();
    }

    public rf2() {
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

    public static u83 c(@NonNull PrefetchEvent prefetchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, prefetchEvent)) == null) {
            return w83.k().p(prefetchEvent.appId, b);
        }
        return (u83) invokeL.objValue;
    }

    public static u83 d(@NonNull PrefetchEvent prefetchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, prefetchEvent)) == null) {
            return w83.k().p(prefetchEvent.appId, c);
        }
        return (u83) invokeL.objValue;
    }

    public final void e(@NonNull u83 u83Var, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, u83Var, prefetchEvent, eVar) == null) {
            la2.g(prefetchEvent.appId, "swan", prefetchEvent.scene, false, prefetchEvent.schema, new c(this, u83Var, eVar));
        }
    }

    public final void f(@NonNull u83 u83Var, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u83Var, prefetchEvent, eVar) == null) {
            e(u83Var, prefetchEvent, eVar);
        }
    }

    public void g(@NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, prefetchEvent, eVar) == null) {
            h(prefetchEvent, new a(this, eVar, prefetchEvent));
        }
    }

    @Nullable
    public final void h(@NonNull PrefetchEvent prefetchEvent, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, prefetchEvent, dVar) == null) {
            u83 d2 = d(prefetchEvent);
            if (d2 != null) {
                dVar.a(d2);
                return;
            }
            u83 c2 = c(prefetchEvent);
            if (c2 != null && c2.S()) {
                dVar.a(c2);
                return;
            }
            u83 e2 = w83.k().e();
            if (e2.E()) {
                if (a) {
                    Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
                }
                dVar.a(null);
            } else if (e2.S()) {
                if (a) {
                    Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
                }
                dVar.a(e2);
            } else {
                e2.k0(new b(this, dVar));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "8");
                t83.m(cv2.c(), e2, bundle);
            }
        }
    }
}
