package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.aw2;
import com.baidu.tieba.ig3;
import com.baidu.tieba.p33;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s33 implements z33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public static String[] k;
    public transient /* synthetic */ FieldHolder $fh;
    public db3 a;
    public UnitedSchemeEntity b;
    public CallbackHandler c;
    public String d;
    public String e;
    public int f;
    public String g;
    public PaymentManager h;
    public String i;

    /* loaded from: classes7.dex */
    public interface k {
        void onFail(String str);

        void onSuccess();
    }

    public static String I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 != 0 ? i2 != 2 ? EventAlias.PayEventAlias.PAY_FAIL : "支付取消" : EventAlias.PayEventAlias.PAY_SUCCESS : (String) invokeI.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ s33 d;

        public a(s33 s33Var, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s33Var, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = s33Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L37;
         */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                char c = 0;
                if (!bg3.h(gg3Var)) {
                    String str = null;
                    if (TextUtils.equals(this.d.d, "2.0")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("payId", "");
                        } catch (JSONException e) {
                            if (s33.j) {
                                e.printStackTrace();
                            }
                        }
                        str = String.valueOf(jSONObject);
                    }
                    if (TextUtils.equals(this.a, "mapp_request_duxiaoman")) {
                        wh3.H(false, "baiduqianbao", wh3.m("", "authorize fail"));
                    } else if (TextUtils.equals(this.a, "mapp_request_alipayment")) {
                        wh3.H(false, "alipay", wh3.m("", "authorize fail"));
                    } else if (TextUtils.equals(this.a, "mapp_request_wechatpayment")) {
                        wh3.H(false, "wechatH5Action", wh3.m("", "authorize fail"));
                    }
                    d82.k("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.a);
                    this.d.c.handleSchemeDispatchCallback(this.d.i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                    return;
                }
                String str2 = this.a;
                int hashCode = str2.hashCode();
                if (hashCode != -1689456891) {
                    if (hashCode != -1250772529) {
                        if (hashCode == 1111965155 && str2.equals("mapp_request_alipayment")) {
                            c = 1;
                        }
                        c = 65535;
                    }
                } else {
                    if (str2.equals("mapp_request_wechatpayment")) {
                        c = 2;
                    }
                    c = 65535;
                }
                if (c != 0) {
                    if (c == 1) {
                        this.d.w(this.b);
                        return;
                    } else if (c != 2) {
                        return;
                    } else {
                        this.d.O();
                        return;
                    }
                }
                this.d.A(this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements pr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ s33 d;

        public b(s33 s33Var, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s33Var, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = s33Var;
            this.a = z;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.tieba.pr1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    if (!this.a) {
                        wh3.S("success", 9, this.b);
                    }
                    this.d.C(this.c);
                    return;
                }
                if (!this.a) {
                    wh3.S("fail", 9, this.b);
                }
                this.d.f = 5;
                this.d.g = null;
                this.d.L(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements yf1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s33 a;

        public c(s33 s33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s33Var;
        }

        @Override // com.baidu.tieba.yf1
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, str) != null) {
                return;
            }
            this.a.f = i;
            this.a.g = str;
            if (s33.j) {
                Log.d("SwanAppPaymentManager", "statusCode: " + i + " ,result:" + str);
            }
            this.a.N(i, "baiduqianbao", str);
            wh3.K("baiduqianbao", "result", i);
            if (i == 0 && TextUtils.equals(this.a.d, "2.0")) {
                ku2.W().e(this.a.e, this.a);
            } else {
                this.a.L(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements yf1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s33 a;

        public d(s33 s33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s33Var;
        }

        @Override // com.baidu.tieba.yf1
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, str) != null) {
                return;
            }
            this.a.f = i;
            this.a.g = str;
            d82.k("SwanAppPaymentManager", "statusCode: " + this.a.f + " ,result:" + this.a.g);
            this.a.N(i, "alipay", str);
            if (i != 1) {
                wh3.K("alipay", "result", i);
            }
            if (i == 0 && TextUtils.equals(this.a.d, "2.0")) {
                ku2.W().e(this.a.e, this.a);
            } else {
                this.a.L(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements pr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String[] c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ s33 f;

        public e(s33 s33Var, String str, String str2, String[] strArr, JSONObject jSONObject, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s33Var, str, str2, strArr, jSONObject, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = s33Var;
            this.a = str;
            this.b = str2;
            this.c = strArr;
            this.d = jSONObject;
            this.e = z;
        }

        @Override // com.baidu.tieba.pr1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    wh3.S("success", 8, this.a);
                    if (this.f.a.w0()) {
                        this.f.G(this.b, this.c, this.d, true, false);
                        return;
                    } else {
                        this.f.D(this.b, this.c, this.d, true, false);
                        return;
                    }
                }
                if (!this.e) {
                    wh3.S("fail", 8, this.a);
                    d82.k("SwanAppPaymentManager", "login error");
                    wh3.H(false, "nuomi", wh3.m("", "login error"));
                }
                this.f.f = 5;
                this.f.g = null;
                this.f.L(null);
                wh3.J("nuomi", false, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ s33 f;

        public f(s33 s33Var, String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s33Var, str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = s33Var;
            this.a = str;
            this.b = strArr;
            this.c = jSONObject;
            this.d = z;
            this.e = z2;
        }

        @Override // com.baidu.tieba.s33.k
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(this.f.i)) {
                return;
            }
            CallbackHandler callbackHandler = this.f.c;
            String str2 = this.f.i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f.a.w().getString(R.string.obfuscated_res_0x7f0f14e0) + str).toString());
        }

        @Override // com.baidu.tieba.s33.k
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.f.D(this.a, this.b, this.c, this.d, this.e);
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Function1<Boolean, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ s33 d;

        public g(s33 s33Var, String str, String[] strArr, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s33Var, str, strArr, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = s33Var;
            this.a = str;
            this.b = strArr;
            this.c = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (!bool.booleanValue()) {
                    d82.k("SwanAppPaymentManager", "paykey invalid order info " + this.a);
                    wh3.H(false, "nuomi", wh3.m("", "paykey invalid"));
                    this.d.M();
                    return null;
                }
                this.d.E(this.a, this.b, this.c);
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements u33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ String b;
        public final /* synthetic */ s33 c;

        public h(s33 s33Var, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s33Var, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s33Var;
            this.a = jSONObject;
            this.b = str;
        }

        @Override // com.baidu.tieba.u33
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, str) != null) {
                return;
            }
            this.c.K(i, str, this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class i implements yf1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ String b;
        public final /* synthetic */ s33 c;

        public i(s33 s33Var, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s33Var, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s33Var;
            this.a = jSONObject;
            this.b = str;
        }

        @Override // com.baidu.tieba.yf1
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, str) != null) {
                return;
            }
            this.c.K(i, str, this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class j implements p33.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        public j(s33 s33Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s33Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
        }

        @Override // com.baidu.tieba.p33.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d82.i("SwanAppPaymentManager", "pay_check request fail: " + str);
            }
        }

        @Override // com.baidu.tieba.p33.b
        public void onSuccess(JSONObject jSONObject) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                if (jSONObject == null) {
                    d82.i("SwanAppPaymentManager", "pay_check request success, but result is null.");
                    return;
                }
                try {
                    boolean z = jSONObject.getBoolean("channel_check");
                    if (z) {
                        str = "pay check success";
                    } else {
                        str = "pay check fail";
                    }
                    String optString = this.a.optString("appKey");
                    if (z) {
                        str2 = "success";
                    } else {
                        str2 = "fail";
                    }
                    wh3.I("nuomi", str, optString, str2);
                } catch (JSONException e) {
                    d82.i("SwanAppPaymentManager", "pay_check request success, but result error: " + jSONObject + "\n" + Log.getStackTraceString(e));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948100438, "Lcom/baidu/tieba/s33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948100438, "Lcom/baidu/tieba/s33;");
                return;
            }
        }
        j = nr1.a;
        k = new String[]{"duershow"};
    }

    public s33(db3 db3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {db3Var, unitedSchemeEntity, callbackHandler, str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = db3Var;
        this.b = unitedSchemeEntity;
        this.c = callbackHandler;
        this.d = str;
        this.e = str2;
        this.i = str3;
        this.h = new PaymentManager();
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            wh3.K("baiduqianbao", "intoPayment", 0);
            this.h.e(this.a.getActivity(), str, new c(this));
        }
    }

    @Override // com.baidu.tieba.h93
    public void onFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            d82.c("SwanAppPaymentManager", "Fail: request payId failed");
            d82.c("SwanAppPaymentManager", str);
            L(null);
        }
    }

    public final void N(int i2, String str, String str2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048588, this, i2, str, str2) == null) {
            if (i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            wh3.H(z, str, str2);
        }
    }

    public static JSONObject v(db3 db3Var, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, db3Var, jSONObject)) == null) {
            if (db3Var.w0() && jSONObject != null) {
                aw2.a W = db3Var.W();
                if (W.M() == null) {
                    return jSONObject;
                }
                JSONObject M = W.M();
                String optString = M.optString("log_id");
                String optString2 = M.optString("module_id");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    try {
                        jSONObject.put("log_id", optString);
                        jSONObject.put("module_id", optString2);
                    } catch (JSONException e2) {
                        if (j) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final boolean A(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.a.N().e(this.a.getActivity())) {
                C(str);
                return true;
            }
            db3 db3Var = this.a;
            if (db3Var == null) {
                return false;
            }
            boolean e2 = db3Var.N().e(this.a.w());
            if (!e2) {
                wh3.S("show", 9, str2);
            }
            this.a.N().f(this.a.getActivity(), null, new b(this, e2, str2, str));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void x(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, jSONObject, str) == null) {
            PMSAppInfo u = aj4.i().u(str);
            if (u == null) {
                i2 = PMSConstants.PayProtected.NO_PAY_PROTECTED.type;
            } else {
                i2 = u.payProtected;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("baoStatus", i2);
            jSONObject2.put("sappId", 10001);
            jSONObject2.put("objectId", str);
            jSONObject.put("baoInfo", jSONObject2.toString());
        }
    }

    public final String H(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, jSONObject)) == null) {
            String optString = jSONObject.optString("tpOrderId");
            try {
                return new JSONObject(str).put("orderId", optString).toString();
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
                return str + " orderId = " + optString;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void y(@NonNull db3 db3Var, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, db3Var, jSONObject) == null) {
            if (SwanAppAllianceLoginHelper.d.f()) {
                jSONObject.put("openBduss", ku2.h0().d(ku2.c()));
                jSONObject.put("clientId", ku2.n().b());
            } else {
                jSONObject.put("bduss", ku2.h0().d(ku2.c()));
            }
            jSONObject.put("cuid", ku2.h0().i(ku2.c()));
            String a2 = ku2.y().a();
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("tpUid", a2);
            }
            String optString = jSONObject.optString("bizInfo");
            if (TextUtils.isEmpty(optString)) {
                jSONObject2 = new JSONObject();
            } else {
                jSONObject2 = new JSONObject(optString);
            }
            jSONObject2.put("swanFrom", db3Var.W().T());
            jSONObject2.put("cuid", ku2.h0().i(ku2.c()));
            jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, cb3.K().getAppId());
            v(db3Var, jSONObject2);
            jSONObject.put("bizInfo", jSONObject2.toString());
            jSONObject.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "100003");
            jSONObject.put("nativeAppId", ku2.n().a());
            jSONObject.put("sceneSource", "swan");
            jSONObject.put("swanNativeVersion", or1.a());
            x(jSONObject, db3Var.O());
            if (j) {
                Log.i("SwanAppPaymentManager", jSONObject.toString());
            }
        }
    }

    public static boolean z(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, jSONObject)) == null) {
            Object remove = jSONObject.remove("inlinePaySign");
            if (remove == null) {
                return true;
            }
            String str = remove + "";
            String A = PaymentPanelManager.z().A(str);
            String B = PaymentPanelManager.z().B(str);
            if (TextUtils.isEmpty(A)) {
                return false;
            }
            jSONObject.put("channelSource", "INNER_SDK");
            jSONObject.put("panelType", HlsPlaylistParser.METHOD_NONE);
            jSONObject.put("chosenChannel", A);
            if (!TextUtils.isEmpty(B)) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(new JSONObject(B));
                jSONObject.put("hostMarketingDetail", jSONArray.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.h93
    public void onSuccess(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            d82.c("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
            if (jSONObject.optInt("errno") == 0) {
                str = jSONObject.optJSONObject("data").optString("payid");
                d82.c("SwanAppPaymentManager", "Info: payId =  " + str);
            } else {
                str = null;
            }
            L(str);
            if (!j93.c.c()) {
                if (ku2.h0().e(this.a)) {
                    j93.c.e();
                } else {
                    j93.c.f();
                }
            }
        }
    }

    public boolean B(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
                this.b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d82.k("SwanAppPaymentManager", "Error: order info is null.");
                return false;
            }
            this.a.e0().g(this.a.w(), str, new a(this, str, str2, str3));
            UnitedSchemeUtility.callCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void F(String str, String[] strArr, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, strArr, jSONObject) == null) {
            try {
                String optString = new JSONObject(str).optString("appKey");
                if (!this.a.w0()) {
                    E(str, strArr, jSONObject);
                } else {
                    e33.b(optString, new g(this, str, strArr, jSONObject));
                }
            } catch (JSONException e2) {
                M();
                d82.k("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
                if (nr1.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void D(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            F(str, strArr, jSONObject);
            wh3.J("nuomi", z, z2);
        }
    }

    public final void G(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            lu2.e().a(str, new f(this, str, strArr, jSONObject, z, z2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0147 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x005b A[SYNTHETIC] */
    @SuppressLint({"BDThrowableCheck"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E(String str, String[] strArr, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONException e2;
        int length;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, strArr, jSONObject) == null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2 = new JSONObject(str);
                try {
                    y(this.a, jSONObject2);
                    if (!z(jSONObject2)) {
                        this.c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParams(202).toString());
                        return;
                    }
                } catch (JSONException e3) {
                    e2 = e3;
                    if (nr1.a) {
                        e2.printStackTrace();
                    }
                    qw2.T().p();
                    String[] strArr2 = k;
                    length = strArr2.length;
                    i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                        }
                        i2++;
                    }
                    wh3.K("nuomi", "intoPayment", 0);
                    if (!z) {
                    }
                    UnitedSchemeUtility.callCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.a.y() == null) {
                    }
                }
            } catch (JSONException e4) {
                jSONObject2 = jSONObject3;
                e2 = e4;
            }
            qw2.T().p();
            String[] strArr22 = k;
            length = strArr22.length;
            i2 = 0;
            while (true) {
                if (i2 >= length) {
                    if (strArr22[i2].equals(ku2.n().a())) {
                        z = true;
                        break;
                    }
                    i2++;
                } else {
                    z = false;
                    break;
                }
            }
            wh3.K("nuomi", "intoPayment", 0);
            if (!z) {
                String a2 = mr4.a(mr4.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject2.toString())), "deviceType", "ANDROID");
                ra2.f3("qrCodePay", d13.d(a2, a2));
                v33.b(new h(this, jSONObject, str));
                d82.k("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject2.toString());
            } else {
                this.h.j(this.a.w(), jSONObject2, strArr, new i(this, jSONObject, str));
                d82.k("SwanAppPaymentManager", "doPolymerPay: " + jSONObject2.toString());
            }
            UnitedSchemeUtility.callCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(0));
            if (this.a.y() == null) {
                String valueOf = String.valueOf(this.a.W().G());
                String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.a.W().W()).get("_baiduboxapp"));
                Bundle bundle = new Bundle();
                bundle.putString("frameType", valueOf);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.a.W().H());
                try {
                    bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
                } catch (UnsupportedEncodingException e5) {
                    if (j) {
                        throw new RuntimeException("This method requires UTF-8 encoding support", e5);
                    }
                }
                this.a.y().Z(7, bundle);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public boolean J(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        String[] strArr;
        Object opt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, jSONObject)) == null) {
            String optString = jSONObject.optString("invokeFrom");
            if (TextUtils.isEmpty(optString)) {
                optString = "api";
            }
            String str2 = optString;
            boolean e2 = this.a.N().e(this.a.w());
            if (!e2) {
                wh3.S("show", 8, str2);
            }
            if (TextUtils.isEmpty(str)) {
                this.b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = jSONObject.optString("__plugin__");
            v63.b("start payment");
            if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
                String optString3 = jSONObject.optString("slaveId");
                o63 o63Var = new o63(jSONObject.optString("componentId"));
                o63Var.a = optString3;
                o63Var.c = opt;
                o63Var.d = false;
                o63Var.e = null;
                o63Var.b();
                d82.k("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
                wh3.H(false, "nuomi", wh3.m("", "param check error - plugin pay contains custom error"));
                this.b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("bannedChannels");
            if (optJSONArray != null) {
                String[] strArr2 = new String[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    strArr2[i2] = String.valueOf(optJSONArray.opt(i2));
                }
                strArr = strArr2;
            } else {
                strArr = null;
            }
            wh3.K("nuomi", "login", 0);
            if (this.a.w() == null) {
                this.f = 5;
                this.g = null;
                L(null);
                if (j) {
                    throw new RuntimeException("swanApp getActivity returns null");
                }
                return true;
            } else if (this.a.N().e(this.a.getActivity())) {
                if (this.a.w0()) {
                    G(str, strArr, jSONObject, true, true);
                    return true;
                }
                D(str, strArr, jSONObject, true, true);
                return true;
            } else {
                this.a.N().f(this.a.getActivity(), null, new e(this, str2, str, strArr, jSONObject, e2));
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void K(int i2, String str, JSONObject jSONObject, String str2) {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, jSONObject, str2}) == null) {
            try {
                jSONObject2 = new JSONObject(str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONObject2 = new JSONObject();
            }
            qw2.T().c();
            d82.i("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f + " params: " + this.g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
            N(i2, "nuomi", H(str, jSONObject2));
            this.f = i2;
            this.g = str;
            boolean z = true;
            if (i2 != 1) {
                wh3.K("nuomi", "result", i2);
            }
            L(null);
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
                String optString = jSONObject.optString("slaveId");
                String optString2 = jSONObject.optString("componentId");
                Object opt = jSONObject.opt("error");
                o63 o63Var = new o63(optString2);
                o63Var.a = optString;
                o63Var.c = opt;
                if (i2 != 0) {
                    z = false;
                }
                o63Var.d = z;
                o63Var.e = str;
                o63Var.b();
                b73.j();
            }
            if (this.f == 0 && !j93.c.c()) {
                j93.c.e();
            }
            if (i2 == 0) {
                p33 p33Var = new p33();
                p33Var.h(jSONObject2);
                p33Var.d(new j(this, jSONObject2));
            }
        }
    }

    public final void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            try {
                if (TextUtils.equals(this.d, "2.0")) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("payId", str);
                    if (!TextUtils.isEmpty(this.g)) {
                        jSONObject.put("payResult", Base64.encodeToString(this.g.getBytes("UTF-8"), 2));
                    }
                    d82.i("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f);
                    this.c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f, I(this.f)).toString());
                    return;
                }
                d82.i("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.g + " status code = " + this.f);
                this.c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.g, this.f, I(this.f)).toString());
            } catch (UnsupportedEncodingException | JSONException e2) {
                d82.i("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
                CallbackHandler callbackHandler = this.c;
                String str2 = this.i;
                int i2 = this.f;
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, I(i2)).toString());
            }
        }
    }

    public final void M() {
        db3 db3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (db3Var = this.a) != null) {
            va3.f(db3Var.w(), R.string.obfuscated_res_0x7f0f154d).G();
            if (!TextUtils.isEmpty(this.i)) {
                this.c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.a.w().getString(R.string.obfuscated_res_0x7f0f154d)).toString());
            }
        }
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d82.i("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
            if (y33.a(this.a, this.c, this.b)) {
                this.f = 0;
                this.g = null;
                if (TextUtils.equals(this.d, "2.0")) {
                    ku2.W().e(this.e, this);
                } else {
                    L(null);
                }
                wh3.G("wechatH5Action", null, null);
                return true;
            }
            d82.k("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.b.toString());
            this.c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (j) {
                Log.d("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str);
            }
            wh3.K("alipay", "intoPayment", 0);
            this.h.d(this.a.getActivity(), str, new d(this));
            return true;
        }
        return invokeL.booleanValue;
    }
}
