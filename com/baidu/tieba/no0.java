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
/* loaded from: classes7.dex */
public class no0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;
    public int d;
    public ADConfigError e;
    public uo0 f;

    /* loaded from: classes7.dex */
    public class a extends du0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no0 a;

        public a(no0 no0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no0Var;
        }

        @Override // com.baidu.tieba.bu0
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cu0
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
                        mo0.d().c();
                        mo0.d().e(str);
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
        @Override // com.baidu.tieba.cu0
        /* renamed from: h */
        public String d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, headers, str, i)) == null) {
                if (i != 200) {
                    String str2 = i + "";
                    if (str != null) {
                        str2 = y31.c(str).optString("error_message");
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

    public no0(int i, boolean z, int i2) {
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

    public void m(uo0 uo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uo0Var) == null) {
            this.f = uo0Var;
        }
    }

    @NonNull
    public final JSONObject g() {
        InterceptResult invokeV;
        String p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            zk0 a2 = rk0.a();
            y31.f(jSONObject, "cuid", a2.g());
            y31.f(jSONObject, "baiduid", a2.o());
            y31.f(jSONObject, "product", a2.A());
            y31.f(jSONObject, "bundle_id", a2.packageName());
            y31.f(jSONObject, AdExtParam.KEY_NAD_CORE_VERSION, "5.12.0.75");
            y31.f(jSONObject, "ot", "2");
            String h = jl0.c().h(false);
            if (!TextUtils.isEmpty(h)) {
                y31.f(jSONObject, "ov", h);
            }
            y31.f(jSONObject, "ua", rk0.e());
            if (TextUtils.isEmpty(a2.p())) {
                p = a2.w();
            } else {
                p = a2.p();
            }
            y31.f(jSONObject, "ver", p);
            y31.f(jSONObject, "sid", a2.i());
            y31.f(jSONObject, HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, String.valueOf(System.currentTimeMillis()));
            y31.f(jSONObject, "ext", "");
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Nullable
    public final ku0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ju0 f = ju0.f(d81.a(g().toString().getBytes()));
            ku0 ku0Var = new ku0();
            ku0Var.a("Content-Encoding", "gzip");
            ku0Var.a("Content-Type", "application/json");
            ku0Var.l(i() + "?" + rk0.a().l());
            ku0Var.g(this.b * 1000);
            ku0Var.j(this.b * 1000);
            ku0Var.k(this.b * 1000);
            ku0Var.f(f);
            ku0Var.i(false);
            return ku0Var;
        }
        return (ku0) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ai0.a && !TextUtils.isEmpty(rk0.d().k())) {
                return rk0.d().k();
            }
            return "https://afdconf.baidu.com/afd/platform";
        }
        return (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            po0.c().d();
        }
    }

    public final void l() {
        ADConfigError aDConfigError;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (aDConfigError = this.e) != null && !TextUtils.equals(aDConfigError.reason, ADConfigError.REASON_REQUEST_SUCCESS)) {
            oo0.c(this.e, this.d, this.c);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ku0 h = h();
            if (h == null) {
                this.e = ADConfigError.error("10", ADConfigError.REASON_BUILD_REQUEST_FAILED);
                l();
                k();
                return;
            }
            rt0.b().a().a(h, new a(this));
        }
    }
}
