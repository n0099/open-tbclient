package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class v72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static b b;
    public static LinkedHashMap<String, String> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public boolean b;
        public int c;
        public long d;
        public final q82 e;

        /* loaded from: classes6.dex */
        public class a extends qk2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SwanAppActivity a;
            public final /* synthetic */ b b;

            public a(b bVar, SwanAppActivity swanAppActivity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, swanAppActivity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = swanAppActivity;
            }

            @Override // com.baidu.tieba.qk2, com.baidu.tieba.rk2
            public void f() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.j()) {
                    this.a.H0(this);
                }
            }
        }

        /* renamed from: com.baidu.tieba.v72$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0445b implements mm3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ mm3 a;

            public C0445b(b bVar, mm3 mm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, mm3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = mm3Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.mm3
            /* renamed from: b */
            public void a(String str) {
                mm3 mm3Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (mm3Var = this.a) != null) {
                    mm3Var.a(str);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-391687398, "Lcom/baidu/tieba/v72$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-391687398, "Lcom/baidu/tieba/v72$b;");
                    return;
                }
            }
            ar2.g0().n();
        }

        public final long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                t73 b0 = t73.b0();
                if (b0 == null) {
                    return 0L;
                }
                return b0.W().l("launch_time", 0L);
            }
            return invokeV.longValue;
        }

        public void h() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (activity = gt2.U().getActivity()) != null && !activity.isFinishing()) {
                activity.v0(new a(this, activity));
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.e.i();
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.e.h();
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = "";
            this.b = true;
            System.currentTimeMillis();
            this.c = 0;
            this.d = f();
            this.e = new q82();
        }

        public final boolean j() {
            InterceptResult invokeV;
            String f;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (!TextUtils.isEmpty(this.a)) {
                    f = this.a;
                } else {
                    f = this.e.f();
                }
                if (!this.b || TextUtils.isEmpty(f)) {
                    return false;
                }
                q72.h(this.d, f);
                this.b = false;
                return true;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public void e(@NonNull mm3<String> mm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mm3Var) == null) {
                this.e.e(new C0445b(this, mm3Var));
            }
        }

        public void k(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.c = i;
            }
        }

        public void l(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                this.b = z;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c == 1) {
                if (!TextUtils.equals(gt2.U().T(), s72.a())) {
                    if (v72.a) {
                        Log.d("SwanAppLaunchTips", "current page is not skeleton error first page");
                        Log.d("SwanAppLaunchTips", "current page: " + gt2.U().T());
                        String a2 = s72.a();
                        StringBuilder sb = new StringBuilder();
                        sb.append("skeleton error first page: ");
                        if (a2 == null) {
                            a2 = "";
                        }
                        sb.append(a2);
                        Log.d("SwanAppLaunchTips", sb.toString());
                        return;
                    }
                    return;
                }
                String C = gt2.U().C();
                if (TextUtils.isEmpty(C)) {
                    return;
                }
                gt2.U().m(C, new uh2("check-skeleton-status"));
            }
        }

        public String d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                StringBuilder sb = new StringBuilder(ar2.c().getText(R.string.obfuscated_res_0x7f0f1401));
                sb.append(str);
                String e = q72.e();
                if (!TextUtils.isEmpty(e)) {
                    sb.append(e);
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }

        public void g(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
                String str3 = "\n" + str2 + str;
                if (!TextUtils.isEmpty(this.a)) {
                    str3 = this.a + str3;
                }
                this.a = str3;
                t42.k("SwanAppLaunchTips", str2 + str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements mm3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm3 a;

        public a(mm3 mm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mm3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (v72.a) {
                    Log.d("SwanAppLaunchTips", ">> default launchInfo: " + str);
                }
                this.a.a(v72.b.d(str));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193624, "Lcom/baidu/tieba/v72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193624, "Lcom/baidu/tieba/v72;");
                return;
            }
        }
        a = do1.a;
    }

    public static void c() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && (bVar = b) != null) {
            bVar.c();
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            y72.d().g();
            y72.d().i();
        }
    }

    public static void k() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, null) == null) && (bVar = b) != null) {
            bVar.m();
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            k82.d().g();
            k82.d().i();
        }
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (v72.class) {
                if (b != null) {
                    t72.e();
                    b.i();
                }
                b = new b(null);
                if (c != null) {
                    for (Map.Entry<String, String> entry : c.entrySet()) {
                        b.g(entry.getKey(), entry.getValue());
                    }
                    b.l(true);
                    c = null;
                }
                b.h();
            }
        }
    }

    public static void e(mm3<String> mm3Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, mm3Var) == null) && mm3Var != null && (bVar = b) != null) {
            if (!TextUtils.isEmpty(bVar.a)) {
                if (a) {
                    Log.d("SwanAppLaunchTips", ">> exception launchInfo: " + b.a);
                }
                b bVar2 = b;
                mm3Var.a(bVar2.d(bVar2.a));
                return;
            }
            b.e(new a(mm3Var));
        }
    }

    public static void f(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65542, null, z) != null) || s73.K().k() == 1) {
            return;
        }
        d();
        l();
        j();
        k();
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            h(str, hk3.g(System.currentTimeMillis(), "【HH:mm:ss】"));
        }
    }

    public static void i(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65545, null, i) == null) && (bVar = b) != null) {
            bVar.k(i);
        }
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            b bVar = b;
            if (bVar != null) {
                bVar.g(str, str2);
                return;
            }
            if (c == null) {
                c = new LinkedHashMap<>();
            }
            c.put(str, str2);
        }
    }
}
