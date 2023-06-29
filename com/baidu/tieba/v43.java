package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.hh3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class v43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public static final String[] h;
    public static final Map<String, String> i;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;
    public cc3 b;
    public SwanAppActivity c;
    public PaymentManager d;
    public String e;
    public String f;

    /* loaded from: classes8.dex */
    public interface d {
        void a(@NonNull c42 c42Var);
    }

    /* loaded from: classes8.dex */
    public class a implements vq3<fh3<hh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ String b;
        public final /* synthetic */ v43 c;

        public a(v43 v43Var, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v43Var, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v43Var;
            this.a = jSONObject;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(fh3<hh3.e> fh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fh3Var) == null) {
                if (!ah3.h(fh3Var)) {
                    c92.i("SwanAppThirdPayment", "authorize fail");
                    vi3.H(false, this.c.f, vi3.m("", "authorize fail"));
                    this.c.i(new c42(fh3Var.b(), ah3.f(fh3Var.b())));
                    return;
                }
                this.c.p(this.a, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements os1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ v43 c;

        public b(v43 v43Var, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v43Var, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v43Var;
            this.a = str;
            this.b = jSONObject;
        }

        @Override // com.baidu.tieba.os1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    vi3.J(this.c.f, true, false);
                    vi3.S("success", 13, this.a);
                    this.c.l(this.b);
                    return;
                }
                c92.i("SwanAppThirdPayment", "login fail");
                vi3.H(false, this.c.f, vi3.m("", "login error"));
                vi3.S("fail", 13, this.a);
                vi3.J(this.c.f, false, false);
                this.c.i(new c42(5, "login error"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements xg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ v43 b;

        public c(v43 v43Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v43Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v43Var;
            this.a = jSONObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.tieba.xg1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPayResult(int i, String str) {
            JSONObject jSONObject;
            JSONException e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                c92.b("SwanAppThirdPayment", "pay result from nuomi: code:" + i + ", result: " + str);
                JSONObject jSONObject2 = new JSONObject();
                Object obj = null;
                try {
                    jSONObject = new JSONObject(str);
                    try {
                        obj = jSONObject.remove("returnData");
                        jSONObject.remove("msg");
                        jSONObject.remove("statusCode");
                    } catch (JSONException e2) {
                        e = e2;
                        if (v43.g) {
                            Log.e("SwanAppThirdPayment", Log.getStackTraceString(e));
                        }
                        if (obj != null) {
                        }
                        if (i != 0) {
                        }
                        if (i != 1) {
                        }
                        String j = v43.j(i, this.b.c);
                        if (TextUtils.equals("WeChat", this.b.e)) {
                            i = 0;
                        }
                        this.b.i(new c42(i, j, jSONObject));
                    }
                } catch (JSONException e3) {
                    jSONObject = jSONObject2;
                    e = e3;
                }
                if (obj != null) {
                    try {
                        jSONObject.put("returnData", new JSONObject(String.valueOf(obj)));
                    } catch (JSONException e4) {
                        if (v43.g) {
                            Log.e("SwanAppThirdPayment", Log.getStackTraceString(e4));
                        }
                        try {
                            jSONObject.put("returnData", obj);
                        } catch (JSONException e5) {
                            if (v43.g) {
                                Log.e("SwanAppThirdPayment", Log.getStackTraceString(e5));
                            }
                        }
                    }
                }
                if (i != 0) {
                    vi3.H(true, this.b.f, this.b.k(str, this.a));
                } else {
                    c92.i("SwanAppThirdPayment", "pay not success: code:" + i + ", result: " + str);
                    vi3.H(false, this.b.f, this.b.k(str, this.a));
                }
                if (i != 1) {
                    vi3.K(this.b.f, "result", i);
                }
                String j2 = v43.j(i, this.b.c);
                if (TextUtils.equals("WeChat", this.b.e) && i == 1) {
                    i = 0;
                }
                this.b.i(new c42(i, j2, jSONObject));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948190772, "Lcom/baidu/tieba/v43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948190772, "Lcom/baidu/tieba/v43;");
                return;
            }
        }
        g = ms1.a;
        h = new String[]{"dealId", "appKey", "totalAmount", "tpOrderId", "rsaSign", "dealTitle", "chosenChannel", "payInfo", "tradeNo", "mchIdMd5"};
        HashMap hashMap = new HashMap();
        i = hashMap;
        hashMap.put("WeChat", "thirdPayWechatH5");
        i.put("Alipay", "thirdPayAlipay");
    }

    public v43(@NonNull cc3 cc3Var, @NonNull SwanAppActivity swanAppActivity, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cc3Var, swanAppActivity, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = "thirdPayUnknown";
        this.b = cc3Var;
        this.c = swanAppActivity;
        this.a = dVar;
        this.d = new PaymentManager();
    }

    public final void i(@NonNull c42 c42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c42Var) == null) {
            this.a.a(c42Var);
            c92.b("SwanAppThirdPayment", "pay result to js: " + c42Var);
        }
    }

    public final void o(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, jSONObject, str) == null) {
            this.b.e0().g(this.c, "scope_request_thirdpayment", new a(this, jSONObject, str));
        }
    }

    public static String j(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65546, null, i2, context)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return context.getString(R.string.obfuscated_res_0x7f0f149a);
                    }
                    return context.getString(R.string.obfuscated_res_0x7f0f1499);
                }
                return context.getString(R.string.obfuscated_res_0x7f0f149b);
            }
            return context.getString(R.string.obfuscated_res_0x7f0f149c);
        }
        return (String) invokeIL.objValue;
    }

    public final String k(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject(str);
                jSONObject2.put("orderId", jSONObject.opt("tpOrderId"));
                jSONObject2.put("msg", jSONObject3.opt("msg"));
            } catch (JSONException e) {
                c92.b("SwanAppThirdPayment", Log.getStackTraceString(e));
                try {
                    jSONObject2.put("orderId", jSONObject.opt("tpOrderId"));
                    jSONObject2.put("msg", str);
                } catch (JSONException e2) {
                    c92.b("SwanAppThirdPayment", Log.getStackTraceString(e2));
                }
            }
            return jSONObject2.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            vi3.K(this.f, "intoPayment", 0);
            try {
                r43.y(this.b, jSONObject);
                jSONObject.put("tradeType", "DIRECTPAY");
                jSONObject.put("panelType", HlsPlaylistParser.METHOD_NONE);
            } catch (JSONException e) {
                if (g) {
                    Log.e("SwanAppThirdPayment", Log.getStackTraceString(e));
                }
            }
            c92.b("SwanAppThirdPayment", "orderInfo to nuomi: " + jSONObject);
            this.d.j(this.c, jSONObject, null, new c(this, jSONObject));
        }
    }

    public final c42 m(JSONObject jSONObject) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new c42(202, "parse orderInfo fail");
            }
            for (String str : h) {
                Object opt = jSONObject.opt(str);
                if (opt == null) {
                    return new c42(202, str + " is necessary");
                } else if (!(opt instanceof String)) {
                    return new c42(202, str + " must be a string");
                } else if (TextUtils.isEmpty((String) opt)) {
                    return new c42(202, str + " is empty");
                }
            }
            Object opt2 = jSONObject.opt("returnData");
            if (opt2 != null && !(opt2 instanceof JSONObject)) {
                return new c42(202, "returnData must be a object");
            }
            return null;
        }
        return (c42) invokeL.objValue;
    }

    public void n(@Nullable JSONObject jSONObject, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, str) == null) {
            vi3.K(this.f, "create", 0);
            c42 m = m(jSONObject);
            if (m != null) {
                c92.i("SwanAppThirdPayment", "orderInfo param error: " + m);
                vi3.H(false, this.f, vi3.m("", "orderInfo param error"));
                i(m);
                return;
            }
            String optString = jSONObject.optString("chosenChannel");
            this.e = optString;
            String str2 = i.get(optString);
            this.f = str2;
            if (TextUtils.isEmpty(str2)) {
                c92.i("SwanAppThirdPayment", "orderInfo param error: chosen channel error");
                vi3.H(false, "thirdPayUnknown", vi3.m("", "orderInfo param error: chosen channel error"));
                i(new c42(202, "chosenChannel error"));
                return;
            }
            o(jSONObject, str);
        }
    }

    public final void p(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, jSONObject, str) == null) {
            if (!sg1.a().b(this.c)) {
                SwanAppActivity swanAppActivity = this.c;
                ub3.g(swanAppActivity, swanAppActivity.getText(R.string.obfuscated_res_0x7f0f0216)).G();
                vi3.H(false, "wechatH5Action", vi3.m("", "Error: wechat not install. "));
                i(new c42(1002, "had not installed WeChat"));
                return;
            }
            vi3.K(this.f, "login", 0);
            if (this.b.N().e(this.c)) {
                vi3.J(this.f, true, true);
                l(jSONObject);
                return;
            }
            vi3.S("show", 13, str);
            this.b.N().f(this.c, null, new b(this, str, jSONObject));
        }
    }
}
