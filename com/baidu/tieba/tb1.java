package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.poly.statistics.exception.ServerDataException;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.util.TbEnum;
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
/* loaded from: classes6.dex */
public class tb1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "payChannel";
    public static String c = "installmentPeriod";
    public static String d = "payType";
    public static volatile tb1 e;
    public transient /* synthetic */ FieldHolder $fh;
    public qb1 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948175334, "Lcom/baidu/tieba/tb1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948175334, "Lcom/baidu/tieba/tb1;");
        }
    }

    /* loaded from: classes6.dex */
    public class a extends lb1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lb1 a;
        public final /* synthetic */ tb1 b;

        public a(tb1 tb1Var, lb1 lb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb1Var, lb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tb1Var;
            this.a = lb1Var;
        }

        @Override // com.baidu.tieba.lb1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("7", 119501, "cashier/channelAllInfo", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lb1
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
                        lb1 lb1Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("errmsg = " + optString);
                        lb1Var.b(serverDataException, "errno is " + optInt2);
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

    /* loaded from: classes6.dex */
    public class b extends lb1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lb1 b;
        public final /* synthetic */ tb1 c;

        public b(tb1 tb1Var, String str, lb1 lb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb1Var, str, lb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tb1Var;
            this.a = str;
            this.b = lb1Var;
        }

        @Override // com.baidu.tieba.lb1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, th, i, str) != null) {
                return;
            }
            this.c.x("8", 119501, "cashier/launchpayment", i, this.a);
            this.b.b(th, hd1.a().getResources().getString(R.string.obfuscated_res_0x7f0f042a));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lb1
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
                        lb1 lb1Var = this.b;
                        lb1Var.b(new ServerDataException("msg = " + optString), optString);
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

    /* loaded from: classes6.dex */
    public class c extends lb1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lb1 a;
        public final /* synthetic */ tb1 b;

        public c(tb1 tb1Var, lb1 lb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb1Var, lb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tb1Var;
            this.a = lb1Var;
        }

        @Override // com.baidu.tieba.lb1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("8", 119501, "cashier/pay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lb1
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
                        lb1 lb1Var = this.a;
                        lb1Var.b(new ServerDataException("msg = " + optString), optString);
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

    /* loaded from: classes6.dex */
    public class d extends lb1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lb1 a;
        public final /* synthetic */ tb1 b;

        public d(tb1 tb1Var, lb1 lb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb1Var, lb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tb1Var;
            this.a = lb1Var;
        }

        @Override // com.baidu.tieba.lb1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119501, "cashier/sdkAdaptH5QueryPay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lb1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119503, "cashier/sdkAdaptH5QueryPay", optInt);
                        String optString = jSONObject.optString("msg");
                        lb1 lb1Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("msg = " + optString);
                        lb1Var.b(serverDataException, "errno is " + optInt);
                        return;
                    }
                    this.a.c(jSONObject.optJSONObject("data"));
                } catch (Throwable unused) {
                    this.b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119502, "cashier/sdkAdaptH5QueryPay", -1);
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends lb1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lb1 a;

        public e(tb1 tb1Var, lb1 lb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb1Var, lb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lb1Var;
        }

        @Override // com.baidu.tieba.lb1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lb1
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
                    lb1 lb1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    lb1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    dd1.d(th.getMessage());
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends lb1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lb1 a;

        public f(tb1 tb1Var, lb1 lb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb1Var, lb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lb1Var;
        }

        @Override // com.baidu.tieba.lb1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lb1
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
                    lb1 lb1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    lb1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    dd1.d(th.getMessage());
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends lb1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lb1 a;

        public g(tb1 tb1Var, lb1 lb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb1Var, lb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lb1Var;
        }

        @Override // com.baidu.tieba.lb1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lb1
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
                    lb1 lb1Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    lb1Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    dd1.d(th.getMessage());
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    public tb1(qb1 qb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qb1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = qb1Var;
    }

    public final nb1 i(nb1 nb1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, nb1Var)) == null) {
            if (nb1Var == null) {
                nb1Var = new nb1();
            }
            ub1.d(nb1Var);
            return nb1Var;
        }
        return (nb1) invokeL.objValue;
    }

    public mb1 d(Bundle bundle, nb1 nb1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, nb1Var)) == null) {
            mb1 mb1Var = new mb1();
            t(mb1Var, bundle);
            mb1Var.d(d, "android");
            n(bundle, mb1Var, nb1Var);
            return mb1Var;
        }
        return (mb1) invokeLL.objValue;
    }

    public void e(Bundle bundle, lb1<JSONObject> lb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, lb1Var) == null) {
            f(bundle, false, lb1Var);
        }
    }

    public void u(Bundle bundle, lb1<Map<String, String>> lb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bundle, lb1Var) == null) {
            nb1 h = h();
            mb1 d2 = d(bundle, h);
            this.a.a(vb1.l(), h, d2, new c(this, lb1Var));
        }
    }

    public static tb1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (e == null) {
                synchronized (tb1.class) {
                    if (e == null) {
                        e = new tb1(new rb1());
                    }
                }
            }
            return e;
        }
        return (tb1) invokeV.objValue;
    }

    public void f(Bundle bundle, boolean z, lb1<JSONObject> lb1Var) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bundle, Boolean.valueOf(z), lb1Var}) == null) {
            nb1 h = h();
            Set<String> keySet = bundle.keySet();
            mb1 mb1Var = new mb1();
            for (String str : keySet) {
                if ((bundle.get(str) instanceof String) && (!z || !"bduss".equals(str))) {
                    mb1Var.d(str, bundle.get(str).toString());
                }
            }
            n(bundle, mb1Var, h);
            r(bundle, mb1Var, h);
            p(bundle, mb1Var, h);
            if (z) {
                c2 = vb1.d();
            } else {
                c2 = vb1.c();
            }
            qc1.a("1.02", System.currentTimeMillis());
            this.a.a(c2, h, mb1Var, new a(this, lb1Var));
        }
    }

    public void g(String str, mb1 mb1Var, lb1<JSONObject> lb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, mb1Var, lb1Var) == null) {
            this.a.a(str, h(), mb1Var, new g(this, lb1Var));
        }
    }

    public final void n(Bundle bundle, mb1 mb1Var, nb1 nb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, bundle, mb1Var, nb1Var) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            o(string, nb1Var);
        }
    }

    public final void p(Bundle bundle, mb1 mb1Var, nb1 nb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, bundle, mb1Var, nb1Var) == null) {
            String string = bundle.getString("clientId");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            q(string, nb1Var);
        }
    }

    public final void r(Bundle bundle, mb1 mb1Var, nb1 nb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, bundle, mb1Var, nb1Var) == null) {
            String string = bundle.getString("openBduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            s(string, nb1Var);
        }
    }

    public final nb1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            nb1 nb1Var = new nb1();
            ub1.d(nb1Var);
            return nb1Var;
        }
        return (nb1) invokeV.objValue;
    }

    public void k(String str, String str2, String str3, lb1<JSONObject> lb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, lb1Var) == null) {
            nb1 h = h();
            o(str, h);
            mb1 mb1Var = new mb1();
            mb1Var.d("bduss", str);
            mb1Var.d("payChannel", str2);
            mb1Var.d("appKey", str3);
            this.a.a(vb1.i(), h, mb1Var, new e(this, lb1Var));
        }
    }

    public void l(String str, String str2, String str3, lb1<JSONObject> lb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, lb1Var) == null) {
            nb1 h = h();
            o(str, h);
            mb1 mb1Var = new mb1();
            mb1Var.d("appKey", str3);
            mb1Var.d("bduss", str);
            mb1Var.d("payChannel", str2);
            mb1Var.d("sign", kc1.c("appKey=" + str3 + "&bduss=" + str + "&payChannel=" + str2 + "&lLoIsWxrSeJmHQD2TVQQ"));
            this.a.a(vb1.k(), h, mb1Var, new f(this, lb1Var));
        }
    }

    public void m(Bundle bundle, lb1<JSONObject> lb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, lb1Var) == null) {
            nb1 h = h();
            Set<String> keySet = bundle.keySet();
            mb1 mb1Var = new mb1();
            for (String str : keySet) {
                if (bundle.get(str) instanceof String) {
                    mb1Var.d(str, bundle.get(str).toString());
                }
            }
            this.a.a(vb1.m(), h, mb1Var, new d(this, lb1Var));
        }
    }

    public final void t(mb1 mb1Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, mb1Var, bundle) == null) && bundle != null && mb1Var != null) {
            for (String str : bundle.keySet()) {
                mb1Var.d(str, bundle.getString(str));
            }
            Iterator<Map.Entry<String, String>> it = mb1Var.b().entrySet().iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty(it.next().getValue())) {
                    it.remove();
                }
            }
        }
    }

    public final void o(String str, nb1 nb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, nb1Var) == null) {
            String a2 = nb1Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                nb1Var.d("Cookie", str2);
                return;
            }
            nb1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void q(String str, nb1 nb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, nb1Var) == null) {
            String a2 = nb1Var.a("Cookie");
            String str2 = "CLIENTID=" + str;
            if (a2 == null) {
                nb1Var.d("Cookie", str2);
                return;
            }
            nb1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void s(String str, nb1 nb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, nb1Var) == null) {
            String a2 = nb1Var.a("Cookie");
            String str2 = "OPENBDUSS=" + str;
            if (a2 == null) {
                nb1Var.d("Cookie", str2);
                return;
            }
            nb1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public void v(nb1 nb1Var, Bundle bundle, lb1<Map<String, String>> lb1Var, PayChannelEntity payChannelEntity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048593, this, nb1Var, bundle, lb1Var, payChannelEntity, str) == null) {
            nb1 i = i(nb1Var);
            Set<String> keySet = bundle.keySet();
            mb1 mb1Var = new mb1();
            for (String str2 : keySet) {
                if (bundle.get(str2) instanceof String) {
                    mb1Var.d(str2, bundle.get(str2).toString());
                }
            }
            if (payChannelEntity == null) {
                return;
            }
            String payChannel = payChannelEntity.getPayChannel();
            if (!TextUtils.isEmpty(payChannel)) {
                mb1Var.d(b, payChannel);
            }
            String installmentPeriod = payChannelEntity.getInstallmentPeriod();
            if (!TextUtils.isEmpty(installmentPeriod)) {
                mb1Var.d(c, installmentPeriod);
            }
            n(bundle, mb1Var, i);
            this.a.a(vb1.j(), i, mb1Var, new b(this, str, lb1Var));
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
            qc1.c(str, hashMap);
        }
    }

    public final void w(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("exceptionType", "" + i);
            hashMap.put("path", str2);
            hashMap.put(StatConstants.KEY_EXT_ERR_CODE, "" + i2);
            qc1.c(str, hashMap);
        }
    }

    public final Map<String, String> y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jSONObject)) == null) {
            Map<String, String> c2 = ed1.c();
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
