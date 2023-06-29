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
public class pl0 {
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
        public static final pl0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-514575273, "Lcom/baidu/tieba/pl0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-514575273, "Lcom/baidu/tieba/pl0$b;");
                    return;
                }
            }
            a = new pl0(null);
        }
    }

    public pl0() {
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

    public static pl0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (pl0) invokeV.objValue;
    }

    public /* synthetic */ pl0(a aVar) {
        this();
    }

    public void b(dm0 dm0Var) {
        hm0 hm0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, dm0Var) == null) && dm0Var != null && (hm0Var = dm0Var.p) != null && dm0Var.q != null && !TextUtils.isEmpty(hm0Var.a)) {
            em0 em0Var = dm0Var.q;
            long j = em0Var.q;
            if (j < 0) {
                return;
            }
            String str = dm0Var.d;
            em0Var.p = f61.c(j, System.currentTimeMillis());
            ClogBuilder n = new ClogBuilder().y(ClogBuilder.LogType.DOWNLOAD_KEEP).p(dm0Var.p.a).k(str).n(String.valueOf(dm0Var.q.p));
            JSONObject jSONObject = new JSONObject();
            try {
                PackageInfo packageInfo = ok0.b().getPackageManager().getPackageInfo(str, 0);
                n.l(packageInfo.versionName).m(String.valueOf(packageInfo.versionCode));
                c31.d(jSONObject, "installed", 1);
            } catch (PackageManager.NameNotFoundException unused) {
                c31.d(jSONObject, "installed", 0);
                dm0Var.q.q = -2L;
            } catch (Throwable unused2) {
                return;
            }
            n.o(jSONObject.toString());
            r31.b(n);
            ul0.b().e(dm0Var);
        }
    }
}
