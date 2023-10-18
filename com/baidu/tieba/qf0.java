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
public class qf0 {
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
        public static final qf0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-491487248, "Lcom/baidu/tieba/qf0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-491487248, "Lcom/baidu/tieba/qf0$b;");
                    return;
                }
            }
            a = new qf0(null);
        }
    }

    public qf0() {
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

    public static qf0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (qf0) invokeV.objValue;
    }

    public /* synthetic */ qf0(a aVar) {
        this();
    }

    public void b(eg0 eg0Var) {
        ig0 ig0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, eg0Var) == null) && eg0Var != null && (ig0Var = eg0Var.p) != null && eg0Var.q != null && !TextUtils.isEmpty(ig0Var.a)) {
            fg0 fg0Var = eg0Var.q;
            long j = fg0Var.q;
            if (j < 0) {
                return;
            }
            String str = eg0Var.d;
            fg0Var.p = b11.c(j, System.currentTimeMillis());
            ClogBuilder n = new ClogBuilder().y(ClogBuilder.LogType.DOWNLOAD_KEEP).p(eg0Var.p.a).k(str).n(String.valueOf(eg0Var.q.p));
            JSONObject jSONObject = new JSONObject();
            try {
                PackageInfo packageInfo = pe0.b().getPackageManager().getPackageInfo(str, 0);
                n.l(packageInfo.versionName).m(String.valueOf(packageInfo.versionCode));
                ux0.d(jSONObject, "installed", 1);
            } catch (PackageManager.NameNotFoundException unused) {
                ux0.d(jSONObject, "installed", 0);
                eg0Var.q.q = -2L;
            } catch (Throwable unused2) {
                return;
            }
            n.o(jSONObject.toString());
            jy0.e(n);
            vf0.b().f(eg0Var);
        }
    }
}
