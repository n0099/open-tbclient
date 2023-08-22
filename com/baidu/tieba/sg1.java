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
public class sg1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "payChannel";
    public static String c = "installmentPeriod";
    public static String d = "payType";
    public static volatile sg1 e;
    public transient /* synthetic */ FieldHolder $fh;
    public pg1 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948150348, "Lcom/baidu/tieba/sg1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948150348, "Lcom/baidu/tieba/sg1;");
        }
    }

    /* loaded from: classes8.dex */
    public class a extends kg1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg1 a;
        public final /* synthetic */ sg1 b;

        public a(sg1 sg1Var, kg1 kg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg1Var, kg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sg1Var;
            this.a = kg1Var;
        }

        @Override // com.baidu.tieba.kg1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("7", 119501, "cashier/channelAllInfo", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg1
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
                        kg1 kg1Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("errmsg = " + optString);
                        kg1Var.b(serverDataException, "errno is " + optInt2);
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
    public class b extends kg1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kg1 b;
        public final /* synthetic */ sg1 c;

        public b(sg1 sg1Var, String str, kg1 kg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg1Var, str, kg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sg1Var;
            this.a = str;
            this.b = kg1Var;
        }

        @Override // com.baidu.tieba.kg1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, th, i, str) != null) {
                return;
            }
            this.c.x("8", 119501, "cashier/launchpayment", i, this.a);
            this.b.b(th, gi1.a().getResources().getString(R.string.obfuscated_res_0x7f0f049a));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg1
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
                        kg1 kg1Var = this.b;
                        kg1Var.b(new ServerDataException("msg = " + optString), optString);
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
    public class c extends kg1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg1 a;
        public final /* synthetic */ sg1 b;

        public c(sg1 sg1Var, kg1 kg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg1Var, kg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sg1Var;
            this.a = kg1Var;
        }

        @Override // com.baidu.tieba.kg1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("8", 119501, "cashier/pay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg1
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
                        kg1 kg1Var = this.a;
                        kg1Var.b(new ServerDataException("msg = " + optString), optString);
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
    public class d extends kg1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg1 a;
        public final /* synthetic */ sg1 b;

        public d(sg1 sg1Var, kg1 kg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg1Var, kg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sg1Var;
            this.a = kg1Var;
        }

        @Override // com.baidu.tieba.kg1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("105", 119501, "cashier/sdkAdaptH5QueryPay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg1
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
                        kg1 kg1Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("msg = " + optString);
                        kg1Var.b(serverDataException, "errno is " + optInt);
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
    public class e extends kg1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg1 a;

        public e(sg1 sg1Var, kg1 kg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg1Var, kg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg1Var;
        }

        @Override // com.baidu.tieba.kg1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg1
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
                    kg1 kg1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    kg1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    ci1.d(th.getMessage());
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends kg1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg1 a;

        public f(sg1 sg1Var, kg1 kg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg1Var, kg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg1Var;
        }

        @Override // com.baidu.tieba.kg1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg1
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
                    kg1 kg1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    kg1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    ci1.d(th.getMessage());
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends kg1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg1 a;

        public g(sg1 sg1Var, kg1 kg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg1Var, kg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg1Var;
        }

        @Override // com.baidu.tieba.kg1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg1
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
                    kg1 kg1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    kg1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    ci1.d(th.getMessage());
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    public sg1(pg1 pg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pg1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = pg1Var;
    }

    public final mg1 i(mg1 mg1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mg1Var)) == null) {
            if (mg1Var == null) {
                mg1Var = new mg1();
            }
            tg1.d(mg1Var);
            return mg1Var;
        }
        return (mg1) invokeL.objValue;
    }

    public lg1 d(Bundle bundle, mg1 mg1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, mg1Var)) == null) {
            lg1 lg1Var = new lg1();
            t(lg1Var, bundle);
            lg1Var.d(d, "android");
            n(bundle, lg1Var, mg1Var);
            return lg1Var;
        }
        return (lg1) invokeLL.objValue;
    }

    public void e(Bundle bundle, kg1<JSONObject> kg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, kg1Var) == null) {
            f(bundle, false, kg1Var);
        }
    }

    public void u(Bundle bundle, kg1<Map<String, String>> kg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bundle, kg1Var) == null) {
            mg1 h = h();
            lg1 d2 = d(bundle, h);
            this.a.a(ug1.l(), h, d2, new c(this, kg1Var));
        }
    }

    public static sg1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (e == null) {
                synchronized (sg1.class) {
                    if (e == null) {
                        e = new sg1(new qg1());
                    }
                }
            }
            return e;
        }
        return (sg1) invokeV.objValue;
    }

    public void f(Bundle bundle, boolean z, kg1<JSONObject> kg1Var) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bundle, Boolean.valueOf(z), kg1Var}) == null) {
            mg1 h = h();
            Set<String> keySet = bundle.keySet();
            lg1 lg1Var = new lg1();
            for (String str : keySet) {
                if ((bundle.get(str) instanceof String) && (!z || !"bduss".equals(str))) {
                    lg1Var.d(str, bundle.get(str).toString());
                }
            }
            n(bundle, lg1Var, h);
            r(bundle, lg1Var, h);
            p(bundle, lg1Var, h);
            if (z) {
                c2 = ug1.d();
            } else {
                c2 = ug1.c();
            }
            ph1.a("1.02", System.currentTimeMillis());
            this.a.a(c2, h, lg1Var, new a(this, kg1Var));
        }
    }

    public void g(String str, lg1 lg1Var, kg1<JSONObject> kg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, lg1Var, kg1Var) == null) {
            this.a.a(str, h(), lg1Var, new g(this, kg1Var));
        }
    }

    public final void n(Bundle bundle, lg1 lg1Var, mg1 mg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, bundle, lg1Var, mg1Var) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            o(string, mg1Var);
        }
    }

    public final void p(Bundle bundle, lg1 lg1Var, mg1 mg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, bundle, lg1Var, mg1Var) == null) {
            String string = bundle.getString("clientId");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            q(string, mg1Var);
        }
    }

    public final void r(Bundle bundle, lg1 lg1Var, mg1 mg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, bundle, lg1Var, mg1Var) == null) {
            String string = bundle.getString("openBduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            s(string, mg1Var);
        }
    }

    public final mg1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            mg1 mg1Var = new mg1();
            tg1.d(mg1Var);
            return mg1Var;
        }
        return (mg1) invokeV.objValue;
    }

    public void k(String str, String str2, String str3, kg1<JSONObject> kg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, kg1Var) == null) {
            mg1 h = h();
            o(str, h);
            lg1 lg1Var = new lg1();
            lg1Var.d("bduss", str);
            lg1Var.d("payChannel", str2);
            lg1Var.d("appKey", str3);
            this.a.a(ug1.i(), h, lg1Var, new e(this, kg1Var));
        }
    }

    public void l(String str, String str2, String str3, kg1<JSONObject> kg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, kg1Var) == null) {
            mg1 h = h();
            o(str, h);
            lg1 lg1Var = new lg1();
            lg1Var.d("appKey", str3);
            lg1Var.d("bduss", str);
            lg1Var.d("payChannel", str2);
            lg1Var.d("sign", jh1.c("appKey=" + str3 + "&bduss=" + str + "&payChannel=" + str2 + "&lLoIsWxrSeJmHQD2TVQQ"));
            this.a.a(ug1.k(), h, lg1Var, new f(this, kg1Var));
        }
    }

    public void m(Bundle bundle, kg1<JSONObject> kg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, kg1Var) == null) {
            mg1 h = h();
            Set<String> keySet = bundle.keySet();
            lg1 lg1Var = new lg1();
            for (String str : keySet) {
                if (bundle.get(str) instanceof String) {
                    lg1Var.d(str, bundle.get(str).toString());
                }
            }
            this.a.a(ug1.m(), h, lg1Var, new d(this, kg1Var));
        }
    }

    public final void t(lg1 lg1Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, lg1Var, bundle) == null) && bundle != null && lg1Var != null) {
            for (String str : bundle.keySet()) {
                lg1Var.d(str, bundle.getString(str));
            }
            Iterator<Map.Entry<String, String>> it = lg1Var.b().entrySet().iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty(it.next().getValue())) {
                    it.remove();
                }
            }
        }
    }

    public final void o(String str, mg1 mg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, mg1Var) == null) {
            String a2 = mg1Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                mg1Var.d("Cookie", str2);
                return;
            }
            mg1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void q(String str, mg1 mg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, mg1Var) == null) {
            String a2 = mg1Var.a("Cookie");
            String str2 = "CLIENTID=" + str;
            if (a2 == null) {
                mg1Var.d("Cookie", str2);
                return;
            }
            mg1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void s(String str, mg1 mg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, mg1Var) == null) {
            String a2 = mg1Var.a("Cookie");
            String str2 = "OPENBDUSS=" + str;
            if (a2 == null) {
                mg1Var.d("Cookie", str2);
                return;
            }
            mg1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public void v(mg1 mg1Var, Bundle bundle, kg1<Map<String, String>> kg1Var, PayChannelEntity payChannelEntity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048593, this, mg1Var, bundle, kg1Var, payChannelEntity, str) == null) {
            mg1 i = i(mg1Var);
            Set<String> keySet = bundle.keySet();
            lg1 lg1Var = new lg1();
            for (String str2 : keySet) {
                if (bundle.get(str2) instanceof String) {
                    lg1Var.d(str2, bundle.get(str2).toString());
                }
            }
            if (payChannelEntity == null) {
                return;
            }
            String payChannel = payChannelEntity.getPayChannel();
            if (!TextUtils.isEmpty(payChannel)) {
                lg1Var.d(b, payChannel);
            }
            String installmentPeriod = payChannelEntity.getInstallmentPeriod();
            if (!TextUtils.isEmpty(installmentPeriod)) {
                lg1Var.d(c, installmentPeriod);
            }
            n(bundle, lg1Var, i);
            this.a.a(ug1.j(), i, lg1Var, new b(this, str, kg1Var));
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
            ph1.c(str, hashMap);
        }
    }

    public final void w(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("exceptionType", "" + i);
            hashMap.put("path", str2);
            hashMap.put(StatConstants.KEY_EXT_ERR_CODE, "" + i2);
            ph1.c(str, hashMap);
        }
    }

    public final Map<String, String> y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jSONObject)) == null) {
            Map<String, String> c2 = di1.c();
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
