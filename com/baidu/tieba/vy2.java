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
import com.baidu.tieba.dr2;
import com.baidu.tieba.lb3;
import com.baidu.tieba.sy2;
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
/* loaded from: classes8.dex */
public class vy2 implements cz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public static String[] k;
    public transient /* synthetic */ FieldHolder $fh;
    public g63 a;
    public UnitedSchemeEntity b;
    public CallbackHandler c;
    public String d;
    public String e;
    public int f;
    public String g;
    public PaymentManager h;
    public String i;

    /* loaded from: classes8.dex */
    public interface k {
        void onFail(String str);

        void onSuccess();
    }

    public static String I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 != 0 ? i2 != 2 ? EventAlias.PayEventAlias.PAY_FAIL : "支付取消" : EventAlias.PayEventAlias.PAY_SUCCESS : (String) invokeI.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements zk3<jb3<lb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ vy2 d;

        public a(vy2 vy2Var, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy2Var, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vy2Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L37;
         */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(jb3<lb3.e> jb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jb3Var) == null) {
                char c = 0;
                if (!eb3.h(jb3Var)) {
                    String str = null;
                    if (TextUtils.equals(this.d.d, "2.0")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("payId", "");
                        } catch (JSONException e) {
                            if (vy2.j) {
                                e.printStackTrace();
                            }
                        }
                        str = String.valueOf(jSONObject);
                    }
                    if (TextUtils.equals(this.a, "mapp_request_duxiaoman")) {
                        zc3.H(false, "baiduqianbao", zc3.m("", "authorize fail"));
                    } else if (TextUtils.equals(this.a, "mapp_request_alipayment")) {
                        zc3.H(false, "alipay", zc3.m("", "authorize fail"));
                    } else if (TextUtils.equals(this.a, "mapp_request_wechatpayment")) {
                        zc3.H(false, "wechatH5Action", zc3.m("", "authorize fail"));
                    }
                    g32.k("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.a);
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

    /* loaded from: classes8.dex */
    public class b implements tm1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ vy2 d;

        public b(vy2 vy2Var, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy2Var, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vy2Var;
            this.a = z;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.tieba.tm1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    if (!this.a) {
                        zc3.S("success", 9, this.b);
                    }
                    this.d.C(this.c);
                    return;
                }
                if (!this.a) {
                    zc3.S("fail", 9, this.b);
                }
                this.d.f = 5;
                this.d.g = null;
                this.d.L(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements cb1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy2 a;

        public c(vy2 vy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vy2Var;
        }

        @Override // com.baidu.tieba.cb1
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, str) != null) {
                return;
            }
            this.a.f = i;
            this.a.g = str;
            if (vy2.j) {
                Log.d("SwanAppPaymentManager", "statusCode: " + i + " ,result:" + str);
            }
            this.a.N(i, "baiduqianbao", str);
            zc3.K("baiduqianbao", "result", i);
            if (i == 0 && TextUtils.equals(this.a.d, "2.0")) {
                np2.W().e(this.a.e, this.a);
            } else {
                this.a.L(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements cb1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy2 a;

        public d(vy2 vy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vy2Var;
        }

        @Override // com.baidu.tieba.cb1
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, str) != null) {
                return;
            }
            this.a.f = i;
            this.a.g = str;
            g32.k("SwanAppPaymentManager", "statusCode: " + this.a.f + " ,result:" + this.a.g);
            this.a.N(i, "alipay", str);
            if (i != 1) {
                zc3.K("alipay", "result", i);
            }
            if (i == 0 && TextUtils.equals(this.a.d, "2.0")) {
                np2.W().e(this.a.e, this.a);
            } else {
                this.a.L(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements tm1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String[] c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ vy2 f;

        public e(vy2 vy2Var, String str, String str2, String[] strArr, JSONObject jSONObject, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy2Var, str, str2, strArr, jSONObject, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = vy2Var;
            this.a = str;
            this.b = str2;
            this.c = strArr;
            this.d = jSONObject;
            this.e = z;
        }

        @Override // com.baidu.tieba.tm1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    zc3.S("success", 8, this.a);
                    if (this.f.a.x0()) {
                        this.f.G(this.b, this.c, this.d, true, false);
                        return;
                    } else {
                        this.f.D(this.b, this.c, this.d, true, false);
                        return;
                    }
                }
                if (!this.e) {
                    zc3.S("fail", 8, this.a);
                    g32.k("SwanAppPaymentManager", "login error");
                    zc3.H(false, "nuomi", zc3.m("", "login error"));
                }
                this.f.f = 5;
                this.f.g = null;
                this.f.L(null);
                zc3.J("nuomi", false, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ vy2 f;

        public f(vy2 vy2Var, String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy2Var, str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = vy2Var;
            this.a = str;
            this.b = strArr;
            this.c = jSONObject;
            this.d = z;
            this.e = z2;
        }

        @Override // com.baidu.tieba.vy2.k
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(this.f.i)) {
                return;
            }
            CallbackHandler callbackHandler = this.f.c;
            String str2 = this.f.i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f.a.w().getString(R.string.obfuscated_res_0x7f0f1524) + str).toString());
        }

        @Override // com.baidu.tieba.vy2.k
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.f.D(this.a, this.b, this.c, this.d, this.e);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Function1<Boolean, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ vy2 d;

        public g(vy2 vy2Var, String str, String[] strArr, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy2Var, str, strArr, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vy2Var;
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
                    g32.k("SwanAppPaymentManager", "paykey invalid order info " + this.a);
                    zc3.H(false, "nuomi", zc3.m("", "paykey invalid"));
                    this.d.M();
                    return null;
                }
                this.d.E(this.a, this.b, this.c);
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class h implements xy2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ String b;
        public final /* synthetic */ vy2 c;

        public h(vy2 vy2Var, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy2Var, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vy2Var;
            this.a = jSONObject;
            this.b = str;
        }

        @Override // com.baidu.tieba.xy2
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, str) != null) {
                return;
            }
            this.c.K(i, str, this.a, this.b);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements cb1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ String b;
        public final /* synthetic */ vy2 c;

        public i(vy2 vy2Var, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy2Var, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vy2Var;
            this.a = jSONObject;
            this.b = str;
        }

        @Override // com.baidu.tieba.cb1
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, str) != null) {
                return;
            }
            this.c.K(i, str, this.a, this.b);
        }
    }

    /* loaded from: classes8.dex */
    public class j implements sy2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        public j(vy2 vy2Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vy2Var, jSONObject};
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

        @Override // com.baidu.tieba.sy2.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                g32.i("SwanAppPaymentManager", "pay_check request fail: " + str);
            }
        }

        @Override // com.baidu.tieba.sy2.b
        public void onSuccess(JSONObject jSONObject) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                if (jSONObject == null) {
                    g32.i("SwanAppPaymentManager", "pay_check request success, but result is null.");
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
                    zc3.I("nuomi", str, optString, str2);
                } catch (JSONException e) {
                    g32.i("SwanAppPaymentManager", "pay_check request success, but result error: " + jSONObject + "\n" + Log.getStackTraceString(e));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948257050, "Lcom/baidu/tieba/vy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948257050, "Lcom/baidu/tieba/vy2;");
                return;
            }
        }
        j = rm1.a;
        k = new String[]{"duershow"};
    }

    public vy2(g63 g63Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g63Var, unitedSchemeEntity, callbackHandler, str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = g63Var;
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
            zc3.K("baiduqianbao", "intoPayment", 0);
            this.h.e(this.a.O(), str, new c(this));
        }
    }

    @Override // com.baidu.tieba.k43
    public void onFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            g32.c("SwanAppPaymentManager", "Fail: request payId failed");
            g32.c("SwanAppPaymentManager", str);
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
            zc3.H(z, str, str2);
        }
    }

    public static JSONObject v(g63 g63Var, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, g63Var, jSONObject)) == null) {
            if (g63Var.x0() && jSONObject != null) {
                dr2.a X = g63Var.X();
                if (X.N() == null) {
                    return jSONObject;
                }
                JSONObject N = X.N();
                String optString = N.optString("log_id");
                String optString2 = N.optString("module_id");
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
            if (this.a.N().e(this.a.O())) {
                C(str);
                return true;
            }
            g63 g63Var = this.a;
            if (g63Var == null) {
                return false;
            }
            boolean e2 = g63Var.N().e(this.a.w());
            if (!e2) {
                zc3.S("show", 9, str2);
            }
            this.a.N().f(this.a.O(), null, new b(this, e2, str2, str));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void x(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, jSONObject, str) == null) {
            PMSAppInfo u = de4.i().u(str);
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

    public static void y(@NonNull g63 g63Var, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, g63Var, jSONObject) == null) {
            if (SwanAppAllianceLoginHelper.d.f()) {
                jSONObject.put("openBduss", np2.h0().d(np2.c()));
                jSONObject.put("clientId", np2.n().b());
            } else {
                jSONObject.put("bduss", np2.h0().d(np2.c()));
            }
            jSONObject.put("cuid", np2.h0().i(np2.c()));
            String a2 = np2.y().a();
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("tpUid", a2);
            }
            String optString = jSONObject.optString("bizInfo");
            if (TextUtils.isEmpty(optString)) {
                jSONObject2 = new JSONObject();
            } else {
                jSONObject2 = new JSONObject(optString);
            }
            jSONObject2.put("swanFrom", g63Var.X().U());
            jSONObject2.put("cuid", np2.h0().i(np2.c()));
            jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f63.K().getAppId());
            v(g63Var, jSONObject2);
            jSONObject.put("bizInfo", jSONObject2.toString());
            jSONObject.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "100003");
            jSONObject.put("nativeAppId", np2.n().a());
            jSONObject.put("sceneSource", "swan");
            jSONObject.put("swanNativeVersion", sm1.a());
            x(jSONObject, g63Var.P());
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

    @Override // com.baidu.tieba.k43
    public void onSuccess(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            g32.c("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
            if (jSONObject.optInt("errno") == 0) {
                str = jSONObject.optJSONObject("data").optString("payid");
                g32.c("SwanAppPaymentManager", "Info: payId =  " + str);
            } else {
                str = null;
            }
            L(str);
            if (!m43.c.c()) {
                if (np2.h0().e(this.a)) {
                    m43.c.e();
                } else {
                    m43.c.f();
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
                g32.k("SwanAppPaymentManager", "Error: order info is null.");
                return false;
            }
            this.a.f0().g(this.a.w(), str, new a(this, str, str2, str3));
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
                if (!this.a.x0()) {
                    E(str, strArr, jSONObject);
                } else {
                    hy2.b(optString, new g(this, str, strArr, jSONObject));
                }
            } catch (JSONException e2) {
                M();
                g32.k("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
                if (rm1.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void D(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            F(str, strArr, jSONObject);
            zc3.J("nuomi", z, z2);
        }
    }

    public final void G(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            op2.e().a(str, new f(this, str, strArr, jSONObject, z, z2));
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
                    if (rm1.a) {
                        e2.printStackTrace();
                    }
                    tr2.V().q();
                    String[] strArr2 = k;
                    length = strArr2.length;
                    i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                        }
                        i2++;
                    }
                    zc3.K("nuomi", "intoPayment", 0);
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
            tr2.V().q();
            String[] strArr22 = k;
            length = strArr22.length;
            i2 = 0;
            while (true) {
                if (i2 >= length) {
                    if (strArr22[i2].equals(np2.n().a())) {
                        z = true;
                        break;
                    }
                    i2++;
                } else {
                    z = false;
                    break;
                }
            }
            zc3.K("nuomi", "intoPayment", 0);
            if (!z) {
                String a2 = om4.a(om4.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject2.toString())), "deviceType", "ANDROID");
                u52.k3("qrCodePay", gw2.d(a2, a2));
                yy2.b(new h(this, jSONObject, str));
                g32.k("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject2.toString());
            } else {
                this.h.j(this.a.w(), jSONObject2, strArr, new i(this, jSONObject, str));
                g32.k("SwanAppPaymentManager", "doPolymerPay: " + jSONObject2.toString());
            }
            UnitedSchemeUtility.callCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(0));
            if (this.a.y() == null) {
                String valueOf = String.valueOf(this.a.X().H());
                String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.a.X().X()).get("_baiduboxapp"));
                Bundle bundle = new Bundle();
                bundle.putString("frameType", valueOf);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.a.X().I());
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
                zc3.S("show", 8, str2);
            }
            if (TextUtils.isEmpty(str)) {
                this.b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = jSONObject.optString("__plugin__");
            y13.b("start payment");
            if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
                String optString3 = jSONObject.optString("slaveId");
                r13 r13Var = new r13(jSONObject.optString("componentId"));
                r13Var.a = optString3;
                r13Var.c = opt;
                r13Var.d = false;
                r13Var.e = null;
                r13Var.b();
                g32.k("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
                zc3.H(false, "nuomi", zc3.m("", "param check error - plugin pay contains custom error"));
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
            zc3.K("nuomi", "login", 0);
            if (this.a.w() == null) {
                this.f = 5;
                this.g = null;
                L(null);
                if (j) {
                    throw new RuntimeException("swanApp getActivity returns null");
                }
                return true;
            } else if (this.a.N().e(this.a.O())) {
                if (this.a.x0()) {
                    G(str, strArr, jSONObject, true, true);
                    return true;
                }
                D(str, strArr, jSONObject, true, true);
                return true;
            } else {
                this.a.N().f(this.a.O(), null, new e(this, str2, str, strArr, jSONObject, e2));
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
            tr2.V().c();
            g32.i("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f + " params: " + this.g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
            N(i2, "nuomi", H(str, jSONObject2));
            this.f = i2;
            this.g = str;
            boolean z = true;
            if (i2 != 1) {
                zc3.K("nuomi", "result", i2);
            }
            L(null);
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
                String optString = jSONObject.optString("slaveId");
                String optString2 = jSONObject.optString("componentId");
                Object opt = jSONObject.opt("error");
                r13 r13Var = new r13(optString2);
                r13Var.a = optString;
                r13Var.c = opt;
                if (i2 != 0) {
                    z = false;
                }
                r13Var.d = z;
                r13Var.e = str;
                r13Var.b();
                e23.j();
            }
            if (this.f == 0 && !m43.c.c()) {
                m43.c.e();
            }
            if (i2 == 0) {
                sy2 sy2Var = new sy2();
                sy2Var.h(jSONObject2);
                sy2Var.d(new j(this, jSONObject2));
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
                    g32.i("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f);
                    this.c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f, I(this.f)).toString());
                    return;
                }
                g32.i("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.g + " status code = " + this.f);
                this.c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.g, this.f, I(this.f)).toString());
            } catch (UnsupportedEncodingException | JSONException e2) {
                g32.i("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
                CallbackHandler callbackHandler = this.c;
                String str2 = this.i;
                int i2 = this.f;
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, I(i2)).toString());
            }
        }
    }

    public final void M() {
        g63 g63Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (g63Var = this.a) != null) {
            y53.f(g63Var.w(), R.string.obfuscated_res_0x7f0f1591).G();
            if (!TextUtils.isEmpty(this.i)) {
                this.c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.a.w().getString(R.string.obfuscated_res_0x7f0f1591)).toString());
            }
        }
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            g32.i("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
            if (bz2.a(this.a, this.c, this.b)) {
                this.f = 0;
                this.g = null;
                if (TextUtils.equals(this.d, "2.0")) {
                    np2.W().e(this.e, this);
                } else {
                    L(null);
                }
                zc3.G("wechatH5Action", null, null);
                return true;
            }
            g32.k("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.b.toString());
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
            zc3.K("alipay", "intoPayment", 0);
            this.h.d(this.a.O(), str, new d(this));
            return true;
        }
        return invokeL.booleanValue;
    }
}
