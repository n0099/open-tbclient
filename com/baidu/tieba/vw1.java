package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.tieba.yc3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vw1 extends mw1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppWebPopWindow f;
    public i72 g;
    public z62 h;

    @Override // com.baidu.tieba.wv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "WebPopWindowApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ t73 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ vw1 e;

        /* loaded from: classes6.dex */
        public class a extends i72 {
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

            @Override // com.baidu.tieba.i72, com.baidu.tieba.j72
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    super.b();
                    t42.i("WebPopWindowApi", "swanId=" + this.a.b.b + ", nowId=" + t73.g0());
                    if (TextUtils.equals(this.a.b.b, t73.g0())) {
                        return;
                    }
                    this.a.e.H();
                }
            }

            @Override // com.baidu.tieba.i72, com.baidu.tieba.j72
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    t42.i("WebPopWindowApi", "call onFragmentDestroyed");
                    this.a.e.H();
                    if (this.a.e.h != null && this.a.e.g != null) {
                        this.a.e.h.U2(this.a.e.g);
                    }
                }
            }
        }

        public b(vw1 vw1Var, String str, t73 t73Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vw1Var, str, t73Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vw1Var;
            this.a = str;
            this.b = t73Var;
            this.c = str2;
            this.d = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (activity = gt2.U().getActivity()) == null) {
                return;
            }
            if (this.e.f != null && this.e.f.z()) {
                this.e.d(this.a, new tz1(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            c72 V = gt2.U().V();
            if (V == null) {
                return;
            }
            this.e.h = V.m();
            if (this.e.h == null) {
                return;
            }
            if (this.e.g != null) {
                this.e.h.U2(this.e.g);
            }
            this.e.g = new a(this);
            this.e.h.q2(this.e.g);
            vw1 vw1Var = this.e;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.c);
            swanAppWebPopWindow.t0(R.string.obfuscated_res_0x7f0f1327);
            vw1Var.f = swanAppWebPopWindow;
            if (TextUtils.equals(this.d, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = this.e.f;
                swanAppWebPopWindow2.p0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.q0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = this.e.f;
            swanAppWebPopWindow3.o0();
            swanAppWebPopWindow3.v0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e) {
                if (vw1.i) {
                    e.printStackTrace();
                }
            }
            this.e.d(this.a, new tz1(0, "show halfScreenWebview success", jSONObject));
        }
    }

    /* loaded from: classes6.dex */
    public class a implements mm3<wc3<yc3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ t73 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ vw1 d;

        public a(vw1 vw1Var, String str, t73 t73Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vw1Var, str, t73Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vw1Var;
            this.a = str;
            this.b = t73Var;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(wc3<yc3.e> wc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wc3Var) == null) {
                if (!rc3.h(wc3Var)) {
                    this.d.d(this.a, new tz1(10005, "system deny"));
                } else {
                    this.d.I(this.b, this.c, this.a);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948255097, "Lcom/baidu/tieba/vw1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948255097, "Lcom/baidu/tieba/vw1;");
                return;
            }
        }
        i = do1.a;
    }

    public final void H() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.h.a0() && (swanAppWebPopWindow = this.f) != null) {
            swanAppWebPopWindow.r();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vw1(@NonNull uv1 uv1Var) {
        super(uv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uv1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((uv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void G(t73 t73Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, t73Var, str, str2) == null) {
            if (TextUtils.equals(str, "protect")) {
                t73Var.e0().g(getContext(), "scope_web_window_pay_protected", new a(this, str2, t73Var, str));
            } else {
                d(str2, new tz1(202, "type is invalid"));
            }
        }
    }

    public final void I(t73 t73Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, t73Var, str, str2) == null) {
            String J = J(t73Var, str);
            if (J == null) {
                d(str2, new tz1(202, "type is invalid"));
            } else {
                nl3.e0(new b(this, str2, t73Var, J, str));
            }
        }
    }

    public final String J(t73 t73Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, t73Var, str)) == null) {
            if (TextUtils.equals(str, "protect") && t73Var != null) {
                return "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + t73Var.O();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public tz1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#showHalfScreenWebview", false);
            if (i) {
                Log.d("WebPopWindowApi", "#showHalfScreenWebview params=" + str);
            }
            t73 b0 = t73.b0();
            if (b0 == null) {
                return new tz1(202, "swan app is null");
            }
            Pair<tz1, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((tz1) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new tz1(202, "type is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new tz1(202, "cb is invalid");
                }
                G(b0, optString, optString2);
                return tz1.f();
            }
            return new tz1(202);
        }
        return (tz1) invokeL.objValue;
    }
}
