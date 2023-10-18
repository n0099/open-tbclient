package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.tieba.ua3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class su1 extends ju1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppWebPopWindow f;
    public e52 g;
    public v42 h;

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "WebPopWindowApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ p53 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ su1 e;

        /* loaded from: classes8.dex */
        public class a extends e52 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.e52, com.baidu.tieba.f52
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    super.b();
                    p22.i("WebPopWindowApi", "swanId=" + this.a.b.b + ", nowId=" + p53.h0());
                    if (TextUtils.equals(this.a.b.b, p53.h0())) {
                        return;
                    }
                    this.a.e.I();
                }
            }

            @Override // com.baidu.tieba.e52, com.baidu.tieba.f52
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    p22.i("WebPopWindowApi", "call onFragmentDestroyed");
                    this.a.e.I();
                    if (this.a.e.h != null && this.a.e.g != null) {
                        this.a.e.h.Y2(this.a.e.g);
                    }
                }
            }
        }

        public b(su1 su1Var, String str, p53 p53Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su1Var, str, p53Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = su1Var;
            this.a = str;
            this.b = p53Var;
            this.c = str2;
            this.d = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (activity = cr2.V().getActivity()) == null) {
                return;
            }
            if (this.e.f != null && this.e.f.y()) {
                this.e.d(this.a, new qx1(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            y42 W = cr2.V().W();
            if (W == null) {
                return;
            }
            this.e.h = W.m();
            if (this.e.h == null) {
                return;
            }
            if (this.e.g != null) {
                this.e.h.Y2(this.e.g);
            }
            this.e.g = new a(this);
            this.e.h.u2(this.e.g);
            su1 su1Var = this.e;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.c);
            swanAppWebPopWindow.u0(R.string.obfuscated_res_0x7f0f14d1);
            su1Var.f = swanAppWebPopWindow;
            if (TextUtils.equals(this.d, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = this.e.f;
                swanAppWebPopWindow2.q0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.r0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = this.e.f;
            swanAppWebPopWindow3.p0();
            swanAppWebPopWindow3.w0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e) {
                if (su1.i) {
                    e.printStackTrace();
                }
            }
            this.e.d(this.a, new qx1(0, "show halfScreenWebview success", jSONObject));
        }
    }

    /* loaded from: classes8.dex */
    public class a implements ik3<sa3<ua3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ p53 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ su1 d;

        public a(su1 su1Var, String str, p53 p53Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su1Var, str, p53Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = su1Var;
            this.a = str;
            this.b = p53Var;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (!na3.h(sa3Var)) {
                    this.d.d(this.a, new qx1(10005, "system deny"));
                } else {
                    this.d.J(this.b, this.c, this.a);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948163802, "Lcom/baidu/tieba/su1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948163802, "Lcom/baidu/tieba/su1;");
                return;
            }
        }
        i = am1.a;
    }

    public final void I() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.h.h0() && (swanAppWebPopWindow = this.f) != null) {
            swanAppWebPopWindow.q();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public su1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void H(p53 p53Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, p53Var, str, str2) == null) {
            if (TextUtils.equals(str, "protect")) {
                p53Var.f0().g(i(), "scope_web_window_pay_protected", new a(this, str2, p53Var, str));
            } else {
                d(str2, new qx1(202, "type is invalid"));
            }
        }
    }

    public final void J(p53 p53Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, p53Var, str, str2) == null) {
            String K = K(p53Var, str);
            if (K == null) {
                d(str2, new qx1(202, "type is invalid"));
            } else {
                jj3.e0(new b(this, str2, p53Var, K, str));
            }
        }
    }

    public final String K(p53 p53Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, p53Var, str)) == null) {
            if (TextUtils.equals(str, "protect") && p53Var != null) {
                return "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + p53Var.P();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public qx1 L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            r("#showHalfScreenWebview", false);
            if (i) {
                Log.d("WebPopWindowApi", "#showHalfScreenWebview params=" + str);
            }
            p53 c0 = p53.c0();
            if (c0 == null) {
                return new qx1(202, "swan app is null");
            }
            Pair<qx1, JSONObject> t = t(str);
            JSONObject jSONObject = (JSONObject) t.second;
            if (((qx1) t.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new qx1(202, "type is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new qx1(202, "cb is invalid");
                }
                H(c0, optString, optString2);
                return qx1.f();
            }
            return new qx1(202);
        }
        return (qx1) invokeL.objValue;
    }
}
