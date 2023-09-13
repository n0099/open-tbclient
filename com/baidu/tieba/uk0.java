package com.baidu.tieba;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class uk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final uk0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-372353039, "Lcom/baidu/tieba/uk0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-372353039, "Lcom/baidu/tieba/uk0$b;");
                    return;
                }
            }
            a = new uk0(null);
        }
    }

    public uk0() {
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

    public static uk0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (uk0) invokeV.objValue;
    }

    public /* synthetic */ uk0(a aVar) {
        this();
    }

    public void b(il0 il0Var) {
        ml0 ml0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, il0Var) == null) && il0Var != null && (ml0Var = il0Var.p) != null && il0Var.q != null && !TextUtils.isEmpty(ml0Var.a)) {
            jl0 jl0Var = il0Var.q;
            long j = jl0Var.q;
            if (j < 0) {
                return;
            }
            String str = il0Var.d;
            jl0Var.p = p61.c(j, System.currentTimeMillis());
            ClogBuilder n = new ClogBuilder().y(ClogBuilder.LogType.DOWNLOAD_KEEP).p(il0Var.p.a).k(str).n(String.valueOf(il0Var.q.p));
            JSONObject jSONObject = new JSONObject();
            try {
                PackageInfo packageInfo = tj0.b().getPackageManager().getPackageInfo(str, 0);
                n.l(packageInfo.versionName).m(String.valueOf(packageInfo.versionCode));
                i31.d(jSONObject, "installed", 1);
            } catch (PackageManager.NameNotFoundException unused) {
                i31.d(jSONObject, "installed", 0);
                il0Var.q.q = -2L;
            } catch (Throwable unused2) {
                return;
            }
            n.o(jSONObject.toString());
            x31.e(n);
            zk0.b().e(il0Var);
        }
    }
}
