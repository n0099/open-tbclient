package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class lm0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;
    public int d;
    public ADConfigError e;
    public sm0 f;

    /* loaded from: classes4.dex */
    public class a extends lq0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lm0 a;

        public a(lm0 lm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lm0Var;
        }

        @Override // com.baidu.tieba.jq0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                try {
                    e(exc);
                } finally {
                    this.a.k();
                }
            }
        }

        public final void e(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
                this.a.e = ADConfigError.error("1", exc.toString());
                if (this.a.f != null) {
                    this.a.f.a(this.a.e);
                }
            }
        }

        public final void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        this.a.a = true;
                        km0.d().c();
                        km0.d().e(str);
                        return;
                    } catch (ADConfigError e) {
                        this.a.e = e;
                        this.a.l();
                        return;
                    }
                }
                this.a.e = ADConfigError.error("1", ADConfigError.REASON_NULL_RESPONSE);
                this.a.l();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kq0
        /* renamed from: g */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048581, this, headers, str, i) == null) {
                try {
                    f(str);
                } finally {
                    this.a.k();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kq0
        /* renamed from: h */
        public String d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, headers, str, i)) == null) {
                if (i != 200) {
                    String str2 = i + "";
                    if (str != null) {
                        str2 = xz0.c(str).optString("error_message");
                    }
                    this.a.e = ADConfigError.error("8", str2);
                    this.a.l();
                    this.a.k();
                    return null;
                }
                return str;
            }
            return (String) invokeLLI.objValue;
        }
    }

    public lm0(int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = i;
        this.c = z;
        this.d = i2;
    }

    @NonNull
    public final JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            hj0 a2 = zi0.a();
            xz0.f(jSONObject, "cuid", a2.g());
            xz0.f(jSONObject, "baiduid", a2.m());
            xz0.f(jSONObject, "product", a2.x());
            xz0.f(jSONObject, "bundle_id", a2.packageName());
            xz0.f(jSONObject, AdExtParam.KEY_NAD_CORE_VERSION, "5.8.0.17");
            xz0.f(jSONObject, "ot", "2");
            String h = pj0.c().h(false);
            if (!TextUtils.isEmpty(h)) {
                xz0.f(jSONObject, "ov", h);
            }
            xz0.f(jSONObject, "ua", zi0.e());
            xz0.f(jSONObject, "ver", TextUtils.isEmpty(a2.n()) ? a2.u() : a2.n());
            xz0.f(jSONObject, "sid", a2.h());
            xz0.f(jSONObject, HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, String.valueOf(System.currentTimeMillis()));
            xz0.f(jSONObject, "ext", "");
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Nullable
    public final sq0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            rq0 f = rq0.f(o31.a(g().toString().getBytes()));
            sq0 sq0Var = new sq0();
            sq0Var.a("Content-Encoding", "gzip");
            sq0Var.a("Content-Type", "application/json");
            sq0Var.k(i() + "?" + zi0.a().k());
            sq0Var.g(this.b * 1000);
            sq0Var.i(this.b * 1000);
            sq0Var.j(this.b * 1000);
            sq0Var.f(f);
            return sq0Var;
        }
        return (sq0) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (!ng0.a || TextUtils.isEmpty(zi0.d().j())) ? "https://afdconf.baidu.com/afd/platform" : zi0.d().j() : (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            nm0.c().d();
        }
    }

    public final void l() {
        ADConfigError aDConfigError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aDConfigError = this.e) == null || TextUtils.equals(aDConfigError.reason, ADConfigError.REASON_REQUEST_SUCCESS)) {
            return;
        }
        mm0.c(this.e, this.d, this.c);
    }

    public void m(sm0 sm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sm0Var) == null) {
            this.f = sm0Var;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            sq0 h = h();
            if (h == null) {
                this.e = ADConfigError.error("10", ADConfigError.REASON_BUILD_REQUEST_FAILED);
                l();
                k();
                return;
            }
            zp0.b().a().a(h, new a(this));
        }
    }
}
