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
/* loaded from: classes5.dex */
public class lf1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "payChannel";
    public static String c = "installmentPeriod";
    public static String d = "payType";
    public static volatile lf1 e;
    public transient /* synthetic */ FieldHolder $fh;
    public if1 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947940850, "Lcom/baidu/tieba/lf1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947940850, "Lcom/baidu/tieba/lf1;");
        }
    }

    /* loaded from: classes5.dex */
    public class a extends df1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ df1 a;
        public final /* synthetic */ lf1 b;

        public a(lf1 lf1Var, df1 df1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var, df1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lf1Var;
            this.a = df1Var;
        }

        @Override // com.baidu.tieba.df1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("7", 119501, "cashier/channelAllInfo", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.df1
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
                        df1 df1Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("errmsg = " + optString);
                        df1Var.b(serverDataException, "errno is " + optInt2);
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

    /* loaded from: classes5.dex */
    public class b extends df1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ df1 b;
        public final /* synthetic */ lf1 c;

        public b(lf1 lf1Var, String str, df1 df1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var, str, df1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lf1Var;
            this.a = str;
            this.b = df1Var;
        }

        @Override // com.baidu.tieba.df1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, th, i, str) != null) {
                return;
            }
            this.c.x("8", 119501, "cashier/launchpayment", i, this.a);
            this.b.b(th, zg1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0442));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.df1
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
                        df1 df1Var = this.b;
                        df1Var.b(new ServerDataException("msg = " + optString), optString);
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

    /* loaded from: classes5.dex */
    public class c extends df1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ df1 a;
        public final /* synthetic */ lf1 b;

        public c(lf1 lf1Var, df1 df1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var, df1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lf1Var;
            this.a = df1Var;
        }

        @Override // com.baidu.tieba.df1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("8", 119501, "cashier/pay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.df1
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
                        df1 df1Var = this.a;
                        df1Var.b(new ServerDataException("msg = " + optString), optString);
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

    /* loaded from: classes5.dex */
    public class d extends df1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ df1 a;
        public final /* synthetic */ lf1 b;

        public d(lf1 lf1Var, df1 df1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var, df1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lf1Var;
            this.a = df1Var;
        }

        @Override // com.baidu.tieba.df1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("105", 119501, "cashier/sdkAdaptH5QueryPay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.df1
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
                        df1 df1Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("msg = " + optString);
                        df1Var.b(serverDataException, "errno is " + optInt);
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

    /* loaded from: classes5.dex */
    public class e extends df1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ df1 a;

        public e(lf1 lf1Var, df1 df1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var, df1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = df1Var;
        }

        @Override // com.baidu.tieba.df1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.df1
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
                    df1 df1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    df1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    vg1.d(th.getMessage());
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends df1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ df1 a;

        public f(lf1 lf1Var, df1 df1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var, df1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = df1Var;
        }

        @Override // com.baidu.tieba.df1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.df1
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
                    df1 df1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    df1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    vg1.d(th.getMessage());
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends df1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ df1 a;

        public g(lf1 lf1Var, df1 df1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var, df1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = df1Var;
        }

        @Override // com.baidu.tieba.df1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.df1
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
                    df1 df1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    df1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    vg1.d(th.getMessage());
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    public lf1(if1 if1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {if1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = if1Var;
    }

    public final ff1 i(ff1 ff1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ff1Var)) == null) {
            if (ff1Var == null) {
                ff1Var = new ff1();
            }
            mf1.d(ff1Var);
            return ff1Var;
        }
        return (ff1) invokeL.objValue;
    }

    public ef1 d(Bundle bundle, ff1 ff1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, ff1Var)) == null) {
            ef1 ef1Var = new ef1();
            t(ef1Var, bundle);
            ef1Var.d(d, "android");
            n(bundle, ef1Var, ff1Var);
            return ef1Var;
        }
        return (ef1) invokeLL.objValue;
    }

    public void e(Bundle bundle, df1<JSONObject> df1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, df1Var) == null) {
            f(bundle, false, df1Var);
        }
    }

    public void u(Bundle bundle, df1<Map<String, String>> df1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bundle, df1Var) == null) {
            ff1 h = h();
            ef1 d2 = d(bundle, h);
            this.a.a(nf1.l(), h, d2, new c(this, df1Var));
        }
    }

    public static lf1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (e == null) {
                synchronized (lf1.class) {
                    if (e == null) {
                        e = new lf1(new jf1());
                    }
                }
            }
            return e;
        }
        return (lf1) invokeV.objValue;
    }

    public void f(Bundle bundle, boolean z, df1<JSONObject> df1Var) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bundle, Boolean.valueOf(z), df1Var}) == null) {
            ff1 h = h();
            Set<String> keySet = bundle.keySet();
            ef1 ef1Var = new ef1();
            for (String str : keySet) {
                if ((bundle.get(str) instanceof String) && (!z || !"bduss".equals(str))) {
                    ef1Var.d(str, bundle.get(str).toString());
                }
            }
            n(bundle, ef1Var, h);
            r(bundle, ef1Var, h);
            p(bundle, ef1Var, h);
            if (z) {
                c2 = nf1.d();
            } else {
                c2 = nf1.c();
            }
            ig1.a("1.02", System.currentTimeMillis());
            this.a.a(c2, h, ef1Var, new a(this, df1Var));
        }
    }

    public void g(String str, ef1 ef1Var, df1<JSONObject> df1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, ef1Var, df1Var) == null) {
            this.a.a(str, h(), ef1Var, new g(this, df1Var));
        }
    }

    public final void n(Bundle bundle, ef1 ef1Var, ff1 ff1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, bundle, ef1Var, ff1Var) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            o(string, ff1Var);
        }
    }

    public final void p(Bundle bundle, ef1 ef1Var, ff1 ff1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, bundle, ef1Var, ff1Var) == null) {
            String string = bundle.getString("clientId");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            q(string, ff1Var);
        }
    }

    public final void r(Bundle bundle, ef1 ef1Var, ff1 ff1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, bundle, ef1Var, ff1Var) == null) {
            String string = bundle.getString("openBduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            s(string, ff1Var);
        }
    }

    public final ff1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ff1 ff1Var = new ff1();
            mf1.d(ff1Var);
            return ff1Var;
        }
        return (ff1) invokeV.objValue;
    }

    public void k(String str, String str2, String str3, df1<JSONObject> df1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, df1Var) == null) {
            ff1 h = h();
            o(str, h);
            ef1 ef1Var = new ef1();
            ef1Var.d("bduss", str);
            ef1Var.d("payChannel", str2);
            ef1Var.d("appKey", str3);
            this.a.a(nf1.i(), h, ef1Var, new e(this, df1Var));
        }
    }

    public void l(String str, String str2, String str3, df1<JSONObject> df1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, df1Var) == null) {
            ff1 h = h();
            o(str, h);
            ef1 ef1Var = new ef1();
            ef1Var.d("appKey", str3);
            ef1Var.d("bduss", str);
            ef1Var.d("payChannel", str2);
            ef1Var.d("sign", cg1.c("appKey=" + str3 + "&bduss=" + str + "&payChannel=" + str2 + "&lLoIsWxrSeJmHQD2TVQQ"));
            this.a.a(nf1.k(), h, ef1Var, new f(this, df1Var));
        }
    }

    public void m(Bundle bundle, df1<JSONObject> df1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, df1Var) == null) {
            ff1 h = h();
            Set<String> keySet = bundle.keySet();
            ef1 ef1Var = new ef1();
            for (String str : keySet) {
                if (bundle.get(str) instanceof String) {
                    ef1Var.d(str, bundle.get(str).toString());
                }
            }
            this.a.a(nf1.m(), h, ef1Var, new d(this, df1Var));
        }
    }

    public final void t(ef1 ef1Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, ef1Var, bundle) == null) && bundle != null && ef1Var != null) {
            for (String str : bundle.keySet()) {
                ef1Var.d(str, bundle.getString(str));
            }
            Iterator<Map.Entry<String, String>> it = ef1Var.b().entrySet().iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty(it.next().getValue())) {
                    it.remove();
                }
            }
        }
    }

    public final void o(String str, ff1 ff1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, ff1Var) == null) {
            String a2 = ff1Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                ff1Var.d("Cookie", str2);
                return;
            }
            ff1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void q(String str, ff1 ff1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, ff1Var) == null) {
            String a2 = ff1Var.a("Cookie");
            String str2 = "CLIENTID=" + str;
            if (a2 == null) {
                ff1Var.d("Cookie", str2);
                return;
            }
            ff1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void s(String str, ff1 ff1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, ff1Var) == null) {
            String a2 = ff1Var.a("Cookie");
            String str2 = "OPENBDUSS=" + str;
            if (a2 == null) {
                ff1Var.d("Cookie", str2);
                return;
            }
            ff1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public void v(ff1 ff1Var, Bundle bundle, df1<Map<String, String>> df1Var, PayChannelEntity payChannelEntity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048593, this, ff1Var, bundle, df1Var, payChannelEntity, str) == null) {
            ff1 i = i(ff1Var);
            Set<String> keySet = bundle.keySet();
            ef1 ef1Var = new ef1();
            for (String str2 : keySet) {
                if (bundle.get(str2) instanceof String) {
                    ef1Var.d(str2, bundle.get(str2).toString());
                }
            }
            if (payChannelEntity == null) {
                return;
            }
            String payChannel = payChannelEntity.getPayChannel();
            if (!TextUtils.isEmpty(payChannel)) {
                ef1Var.d(b, payChannel);
            }
            String installmentPeriod = payChannelEntity.getInstallmentPeriod();
            if (!TextUtils.isEmpty(installmentPeriod)) {
                ef1Var.d(c, installmentPeriod);
            }
            n(bundle, ef1Var, i);
            this.a.a(nf1.j(), i, ef1Var, new b(this, str, df1Var));
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
            ig1.c(str, hashMap);
        }
    }

    public final void w(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("exceptionType", "" + i);
            hashMap.put("path", str2);
            hashMap.put(StatConstants.KEY_EXT_ERR_CODE, "" + i2);
            ig1.c(str, hashMap);
        }
    }

    public final Map<String, String> y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jSONObject)) == null) {
            Map<String, String> c2 = wg1.c();
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
