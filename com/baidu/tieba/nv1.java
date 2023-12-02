package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.tieba.pb3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class nv1 extends ev1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppWebPopWindow f;
    public z52 g;
    public q52 h;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "WebPopWindowApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ k63 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ nv1 e;

        /* loaded from: classes7.dex */
        public class a extends z52 {
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

            @Override // com.baidu.tieba.z52, com.baidu.tieba.a62
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    super.b();
                    k32.i("WebPopWindowApi", "swanId=" + this.a.b.b + ", nowId=" + k63.h0());
                    if (TextUtils.equals(this.a.b.b, k63.h0())) {
                        return;
                    }
                    this.a.e.I();
                }
            }

            @Override // com.baidu.tieba.z52, com.baidu.tieba.a62
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    k32.i("WebPopWindowApi", "call onFragmentDestroyed");
                    this.a.e.I();
                    if (this.a.e.h != null && this.a.e.g != null) {
                        this.a.e.h.Y2(this.a.e.g);
                    }
                }
            }
        }

        public b(nv1 nv1Var, String str, k63 k63Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv1Var, str, k63Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nv1Var;
            this.a = str;
            this.b = k63Var;
            this.c = str2;
            this.d = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (activity = xr2.V().getActivity()) == null) {
                return;
            }
            if (this.e.f != null && this.e.f.z()) {
                this.e.d(this.a, new ly1(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            t52 W = xr2.V().W();
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
            this.e.h.t2(this.e.g);
            nv1 nv1Var = this.e;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.c);
            swanAppWebPopWindow.u0(R.string.obfuscated_res_0x7f0f14f9);
            nv1Var.f = swanAppWebPopWindow;
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
                if (nv1.i) {
                    e.printStackTrace();
                }
            }
            this.e.d(this.a, new ly1(0, "show halfScreenWebview success", jSONObject));
        }
    }

    /* loaded from: classes7.dex */
    public class a implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ k63 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ nv1 d;

        public a(nv1 nv1Var, String str, k63 k63Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv1Var, str, k63Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nv1Var;
            this.a = str;
            this.b = k63Var;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (!ib3.h(nb3Var)) {
                    this.d.d(this.a, new ly1(10005, "system deny"));
                } else {
                    this.d.J(this.b, this.c, this.a);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948015808, "Lcom/baidu/tieba/nv1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948015808, "Lcom/baidu/tieba/nv1;");
                return;
            }
        }
        i = vm1.a;
    }

    public final void I() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.h.h0() && (swanAppWebPopWindow = this.f) != null) {
            swanAppWebPopWindow.r();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nv1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void H(k63 k63Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, k63Var, str, str2) == null) {
            if (TextUtils.equals(str, "protect")) {
                k63Var.f0().g(i(), "scope_web_window_pay_protected", new a(this, str2, k63Var, str));
            } else {
                d(str2, new ly1(202, "type is invalid"));
            }
        }
    }

    public final void J(k63 k63Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, k63Var, str, str2) == null) {
            String K = K(k63Var, str);
            if (K == null) {
                d(str2, new ly1(202, "type is invalid"));
            } else {
                ek3.e0(new b(this, str2, k63Var, K, str));
            }
        }
    }

    public final String K(k63 k63Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, k63Var, str)) == null) {
            if (TextUtils.equals(str, "protect") && k63Var != null) {
                return "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + k63Var.P();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public ly1 L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            r("#showHalfScreenWebview", false);
            if (i) {
                Log.d("WebPopWindowApi", "#showHalfScreenWebview params=" + str);
            }
            k63 c0 = k63.c0();
            if (c0 == null) {
                return new ly1(202, "swan app is null");
            }
            Pair<ly1, JSONObject> t = t(str);
            JSONObject jSONObject = (JSONObject) t.second;
            if (((ly1) t.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new ly1(202, "type is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new ly1(202, "cb is invalid");
                }
                H(c0, optString, optString2);
                return ly1.f();
            }
            return new ly1(202);
        }
        return (ly1) invokeL.objValue;
    }
}
