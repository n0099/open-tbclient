package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.channel.CsjForbidStrategy;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zh0 implements ko0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a extends jt0<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zh0 a;

        @Override // com.baidu.tieba.ht0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        public a(zh0 zh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zh0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zh0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.it0
        /* renamed from: e */
        public void b(Headers headers, JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLI(1048579, this, headers, jSONObject, i) != null) {
                return;
            }
            this.a.i(jSONObject);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.it0
        /* renamed from: f */
        public JSONObject d(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) {
                if (i != 200 || TextUtils.isEmpty(str)) {
                    return null;
                }
                return new JSONObject(str);
            }
            return (JSONObject) invokeLLI.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final zh0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-231977847, "Lcom/baidu/tieba/zh0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-231977847, "Lcom/baidu/tieba/zh0$b;");
                    return;
                }
            }
            a = new zh0(null);
        }
    }

    public zh0() {
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

    public static zh0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (zh0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ko0
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return f();
        }
        return (String) invokeV.objValue;
    }

    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return q31.a().b("nad_app_quick_config").getLong("ip_dx_expire_time", 0L);
        }
        return invokeV.longValue;
    }

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return q31.a().b("nad_app_quick_config").getLong("request_ip_dx_time", 0L);
        }
        return invokeV.longValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return q31.a().b("nad_app_quick_config").getString("ip_dx_data", "");
        }
        return (String) invokeV.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (System.currentTimeMillis() / 1000 <= d()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (System.currentTimeMillis() - e() > CsjForbidStrategy.FORBID_TIME_ANTI_SPAM) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ko0
    public void request() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            m();
        }
    }

    public /* synthetic */ zh0(a aVar) {
        this();
    }

    public final void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        k(jSONObject);
        j(jSONObject.optLong("exptime"));
    }

    public final void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            q31.a().b("nad_app_quick_config").g("ip_dx_expire_time", j);
        }
    }

    public final void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            q31.a().b("nad_app_quick_config").h("ip_dx_data", jSONObject.toString());
        }
    }

    public final void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            q31.a().b("nad_app_quick_config").g("request_ip_dx_time", j);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && sj0.a().n() && h() && !g()) {
            l(System.currentTimeMillis());
            zj0 a2 = sj0.c().a();
            String g = a2.g();
            String packageName = a2.packageName();
            String str = "https://bz-ipdx.baidu.com/miaozhen?" + String.format("uid=%s&appname=%s", g, packageName);
            bt0 a3 = xs0.b().a();
            qt0 qt0Var = new qt0();
            qt0Var.l(str);
            qt0Var.c();
            a3.a(qt0Var, new a(this));
        }
    }
}
