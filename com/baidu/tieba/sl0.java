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
/* loaded from: classes7.dex */
public class sl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final sl0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-428687820, "Lcom/baidu/tieba/sl0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-428687820, "Lcom/baidu/tieba/sl0$b;");
                    return;
                }
            }
            a = new sl0(null);
        }
    }

    public sl0() {
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

    public static sl0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (sl0) invokeV.objValue;
    }

    public /* synthetic */ sl0(a aVar) {
        this();
    }

    public void b(gm0 gm0Var) {
        km0 km0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, gm0Var) == null) && gm0Var != null && (km0Var = gm0Var.p) != null && gm0Var.q != null && !TextUtils.isEmpty(km0Var.a)) {
            hm0 hm0Var = gm0Var.q;
            long j = hm0Var.q;
            if (j < 0) {
                return;
            }
            String str = gm0Var.d;
            hm0Var.p = d71.c(j, System.currentTimeMillis());
            ClogBuilder n = new ClogBuilder().y(ClogBuilder.LogType.DOWNLOAD_KEEP).p(gm0Var.p.a).k(str).n(String.valueOf(gm0Var.q.p));
            JSONObject jSONObject = new JSONObject();
            try {
                PackageInfo packageInfo = rk0.b().getPackageManager().getPackageInfo(str, 0);
                n.l(packageInfo.versionName).m(String.valueOf(packageInfo.versionCode));
                y31.d(jSONObject, "installed", 1);
            } catch (PackageManager.NameNotFoundException unused) {
                y31.d(jSONObject, "installed", 0);
                gm0Var.q.q = -2L;
            } catch (Throwable unused2) {
                return;
            }
            n.o(jSONObject.toString());
            n41.e(n);
            xl0.b().e(gm0Var);
        }
    }
}
