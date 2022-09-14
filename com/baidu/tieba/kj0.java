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
/* loaded from: classes4.dex */
public class kj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final kj0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-659568070, "Lcom/baidu/tieba/kj0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-659568070, "Lcom/baidu/tieba/kj0$b;");
                    return;
                }
            }
            a = new kj0(null);
        }
    }

    public /* synthetic */ kj0(a aVar) {
        this();
    }

    public static kj0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (kj0) invokeV.objValue;
    }

    public void b(yj0 yj0Var) {
        ck0 ck0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, yj0Var) == null) || yj0Var == null || (ck0Var = yj0Var.p) == null || yj0Var.q == null || TextUtils.isEmpty(ck0Var.a)) {
            return;
        }
        zj0 zj0Var = yj0Var.q;
        long j = zj0Var.q;
        if (j < 0) {
            return;
        }
        String str = yj0Var.d;
        zj0Var.p = f21.c(j, System.currentTimeMillis());
        ClogBuilder n = new ClogBuilder().y(ClogBuilder.LogType.DOWNLOAD_KEEP).p(yj0Var.p.a).k(str).n(String.valueOf(yj0Var.q.p));
        JSONObject jSONObject = new JSONObject();
        try {
            PackageInfo packageInfo = mi0.b().getPackageManager().getPackageInfo(str, 0);
            n.l(packageInfo.versionName).m(String.valueOf(packageInfo.versionCode));
            kz0.d(jSONObject, "installed", 1);
        } catch (PackageManager.NameNotFoundException unused) {
            kz0.d(jSONObject, "installed", 0);
            yj0Var.q.q = -2L;
        } catch (Throwable unused2) {
            return;
        }
        n.o(jSONObject.toString());
        uz0.b(n);
        pj0.b().e(yj0Var);
    }

    public kj0() {
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
}
