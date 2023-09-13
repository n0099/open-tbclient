package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.poly.statistics.exception.ServerDataException;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wg1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "payChannel";
    public static String c = "installmentPeriod";
    public static String d = "payType";
    public static volatile wg1 e;
    public transient /* synthetic */ FieldHolder $fh;
    public tg1 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948269512, "Lcom/baidu/tieba/wg1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948269512, "Lcom/baidu/tieba/wg1;");
        }
    }

    /* loaded from: classes8.dex */
    public class a extends og1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og1 a;
        public final /* synthetic */ wg1 b;

        public a(wg1 wg1Var, og1 og1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg1Var, og1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wg1Var;
            this.a = og1Var;
        }

        @Override // com.baidu.tieba.og1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("7", 119501, "cashier/channelAllInfo", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(StatConstants.KEY_EXT_ERR_CODE, -1);
                    int optInt2 = jSONObject.optInt("errno", -1);
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null || optInt != 0 || optInt2 != 0) {
                        this.b.w("7", 119503, "cashier/channelAllInfo", optInt2);
                        String optString = jSONObject.optString("errmsg");
                        og1 og1Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("errmsg = " + optString);
                        og1Var.b(serverDataException, "errno is " + optInt2);
                        return;
                    }
                    this.a.c(optJSONObject);
                } catch (JSONException unused) {
                    this.b.w("7", 119502, "cashier/channelAllInfo", -1);
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends og1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ og1 b;
        public final /* synthetic */ wg1 c;

        public b(wg1 wg1Var, String str, og1 og1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg1Var, str, og1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wg1Var;
            this.a = str;
            this.b = og1Var;
        }

        @Override // com.baidu.tieba.og1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, th, i, str) != null) {
                return;
            }
            this.c.x("8", 119501, "cashier/launchpayment", i, this.a);
            this.b.b(th, ki1.a().getResources().getString(R.string.obfuscated_res_0x7f0f049c));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.c.x("8", 119503, "cashier/launchpayment", optInt, this.a);
                        String optString = jSONObject.optString("msg");
                        og1 og1Var = this.b;
                        og1Var.b(new ServerDataException("msg = " + optString), optString);
                        return;
                    }
                    this.b.c(this.c.y(jSONObject.optJSONObject("data")));
                } catch (JSONException unused) {
                    this.c.x("8", 119502, "cashier/launchpayment", -1, this.a);
                    this.b.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends og1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og1 a;
        public final /* synthetic */ wg1 b;

        public c(wg1 wg1Var, og1 og1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg1Var, og1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wg1Var;
            this.a = og1Var;
        }

        @Override // com.baidu.tieba.og1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("8", 119501, "cashier/pay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.b.w("8", 119503, "cashier/pay", optInt);
                        String optString = jSONObject.optString("msg");
                        og1 og1Var = this.a;
                        og1Var.b(new ServerDataException("msg = " + optString), optString);
                        return;
                    }
                    this.a.c(this.b.y(jSONObject.optJSONObject("data")));
                } catch (Throwable unused) {
                    this.b.w("8", 119502, "cashier/pay", -1);
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends og1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og1 a;
        public final /* synthetic */ wg1 b;

        public d(wg1 wg1Var, og1 og1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg1Var, og1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wg1Var;
            this.a = og1Var;
        }

        @Override // com.baidu.tieba.og1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("105", 119501, "cashier/sdkAdaptH5QueryPay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.b.w("105", 119503, "cashier/sdkAdaptH5QueryPay", optInt);
                        String optString = jSONObject.optString("msg");
                        og1 og1Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("msg = " + optString);
                        og1Var.b(serverDataException, "errno is " + optInt);
                        return;
                    }
                    this.a.c(jSONObject.optJSONObject("data"));
                } catch (Throwable unused) {
                    this.b.w("105", 119502, "cashier/sdkAdaptH5QueryPay", -1);
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends og1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og1 a;

        public e(wg1 wg1Var, og1 og1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg1Var, og1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og1Var;
        }

        @Override // com.baidu.tieba.og1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    og1 og1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    og1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    gi1.d(th.getMessage());
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends og1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og1 a;

        public f(wg1 wg1Var, og1 og1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg1Var, og1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og1Var;
        }

        @Override // com.baidu.tieba.og1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    og1 og1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    og1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    gi1.d(th.getMessage());
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends og1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og1 a;

        public g(wg1 wg1Var, og1 og1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg1Var, og1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og1Var;
        }

        @Override // com.baidu.tieba.og1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    og1 og1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    og1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    gi1.d(th.getMessage());
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    public wg1(tg1 tg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tg1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tg1Var;
    }

    public final qg1 i(qg1 qg1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qg1Var)) == null) {
            if (qg1Var == null) {
                qg1Var = new qg1();
            }
            xg1.d(qg1Var);
            return qg1Var;
        }
        return (qg1) invokeL.objValue;
    }

    public pg1 d(Bundle bundle, qg1 qg1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, qg1Var)) == null) {
            pg1 pg1Var = new pg1();
            t(pg1Var, bundle);
            pg1Var.d(d, "android");
            n(bundle, pg1Var, qg1Var);
            return pg1Var;
        }
        return (pg1) invokeLL.objValue;
    }

    public void e(Bundle bundle, og1<JSONObject> og1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, og1Var) == null) {
            f(bundle, false, og1Var);
        }
    }

    public void u(Bundle bundle, og1<Map<String, String>> og1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bundle, og1Var) == null) {
            qg1 h = h();
            pg1 d2 = d(bundle, h);
            this.a.a(yg1.l(), h, d2, new c(this, og1Var));
        }
    }

    public static wg1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (e == null) {
                synchronized (wg1.class) {
                    if (e == null) {
                        e = new wg1(new ug1());
                    }
                }
            }
            return e;
        }
        return (wg1) invokeV.objValue;
    }

    public void f(Bundle bundle, boolean z, og1<JSONObject> og1Var) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bundle, Boolean.valueOf(z), og1Var}) == null) {
            qg1 h = h();
            Set<String> keySet = bundle.keySet();
            pg1 pg1Var = new pg1();
            for (String str : keySet) {
                if ((bundle.get(str) instanceof String) && (!z || !"bduss".equals(str))) {
                    pg1Var.d(str, bundle.get(str).toString());
                }
            }
            n(bundle, pg1Var, h);
            r(bundle, pg1Var, h);
            p(bundle, pg1Var, h);
            if (z) {
                c2 = yg1.d();
            } else {
                c2 = yg1.c();
            }
            th1.a("1.02", System.currentTimeMillis());
            this.a.a(c2, h, pg1Var, new a(this, og1Var));
        }
    }

    public void g(String str, pg1 pg1Var, og1<JSONObject> og1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, pg1Var, og1Var) == null) {
            this.a.a(str, h(), pg1Var, new g(this, og1Var));
        }
    }

    public final void n(Bundle bundle, pg1 pg1Var, qg1 qg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, bundle, pg1Var, qg1Var) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            o(string, qg1Var);
        }
    }

    public final void p(Bundle bundle, pg1 pg1Var, qg1 qg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, bundle, pg1Var, qg1Var) == null) {
            String string = bundle.getString("clientId");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            q(string, qg1Var);
        }
    }

    public final void r(Bundle bundle, pg1 pg1Var, qg1 qg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, bundle, pg1Var, qg1Var) == null) {
            String string = bundle.getString("openBduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            s(string, qg1Var);
        }
    }

    public final qg1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            qg1 qg1Var = new qg1();
            xg1.d(qg1Var);
            return qg1Var;
        }
        return (qg1) invokeV.objValue;
    }

    public void k(String str, String str2, String str3, og1<JSONObject> og1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, og1Var) == null) {
            qg1 h = h();
            o(str, h);
            pg1 pg1Var = new pg1();
            pg1Var.d("bduss", str);
            pg1Var.d("payChannel", str2);
            pg1Var.d("appKey", str3);
            this.a.a(yg1.i(), h, pg1Var, new e(this, og1Var));
        }
    }

    public void l(String str, String str2, String str3, og1<JSONObject> og1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, og1Var) == null) {
            qg1 h = h();
            o(str, h);
            pg1 pg1Var = new pg1();
            pg1Var.d("appKey", str3);
            pg1Var.d("bduss", str);
            pg1Var.d("payChannel", str2);
            pg1Var.d("sign", nh1.c("appKey=" + str3 + "&bduss=" + str + "&payChannel=" + str2 + "&lLoIsWxrSeJmHQD2TVQQ"));
            this.a.a(yg1.k(), h, pg1Var, new f(this, og1Var));
        }
    }

    public void m(Bundle bundle, og1<JSONObject> og1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, og1Var) == null) {
            qg1 h = h();
            Set<String> keySet = bundle.keySet();
            pg1 pg1Var = new pg1();
            for (String str : keySet) {
                if (bundle.get(str) instanceof String) {
                    pg1Var.d(str, bundle.get(str).toString());
                }
            }
            this.a.a(yg1.m(), h, pg1Var, new d(this, og1Var));
        }
    }

    public final void t(pg1 pg1Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, pg1Var, bundle) == null) && bundle != null && pg1Var != null) {
            for (String str : bundle.keySet()) {
                pg1Var.d(str, bundle.getString(str));
            }
            Iterator<Map.Entry<String, String>> it = pg1Var.b().entrySet().iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty(it.next().getValue())) {
                    it.remove();
                }
            }
        }
    }

    public final void o(String str, qg1 qg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, qg1Var) == null) {
            String a2 = qg1Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                qg1Var.d("Cookie", str2);
                return;
            }
            qg1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void q(String str, qg1 qg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, qg1Var) == null) {
            String a2 = qg1Var.a("Cookie");
            String str2 = "CLIENTID=" + str;
            if (a2 == null) {
                qg1Var.d("Cookie", str2);
                return;
            }
            qg1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void s(String str, qg1 qg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, qg1Var) == null) {
            String a2 = qg1Var.a("Cookie");
            String str2 = "OPENBDUSS=" + str;
            if (a2 == null) {
                qg1Var.d("Cookie", str2);
                return;
            }
            qg1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public void v(qg1 qg1Var, Bundle bundle, og1<Map<String, String>> og1Var, PayChannelEntity payChannelEntity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048593, this, qg1Var, bundle, og1Var, payChannelEntity, str) == null) {
            qg1 i = i(qg1Var);
            Set<String> keySet = bundle.keySet();
            pg1 pg1Var = new pg1();
            for (String str2 : keySet) {
                if (bundle.get(str2) instanceof String) {
                    pg1Var.d(str2, bundle.get(str2).toString());
                }
            }
            if (payChannelEntity == null) {
                return;
            }
            String payChannel = payChannelEntity.getPayChannel();
            if (!TextUtils.isEmpty(payChannel)) {
                pg1Var.d(b, payChannel);
            }
            String installmentPeriod = payChannelEntity.getInstallmentPeriod();
            if (!TextUtils.isEmpty(installmentPeriod)) {
                pg1Var.d(c, installmentPeriod);
            }
            n(bundle, pg1Var, i);
            this.a.a(yg1.j(), i, pg1Var, new b(this, str, og1Var));
        }
    }

    public final void x(String str, int i, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("exceptionType", "" + i);
            hashMap.put("path", str2);
            hashMap.put(StatConstants.KEY_EXT_ERR_CODE, "" + i2);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("isFoldChannel", str3);
            }
            th1.c(str, hashMap);
        }
    }

    public final void w(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("exceptionType", "" + i);
            hashMap.put("path", str2);
            hashMap.put(StatConstants.KEY_EXT_ERR_CODE, "" + i2);
            th1.c(str, hashMap);
        }
    }

    public final Map<String, String> y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jSONObject)) == null) {
            Map<String, String> c2 = hi1.c();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        c2.put(next, jSONObject.optString(next));
                    }
                }
            }
            return c2;
        }
        return (Map) invokeL.objValue;
    }
}
