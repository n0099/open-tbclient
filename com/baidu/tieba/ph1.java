package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ph1 {
    public static /* synthetic */ Interceptable $ic;
    public static long c;
    public static ph1 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948061936, "Lcom/baidu/tieba/ph1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948061936, "Lcom/baidu/tieba/ph1;");
        }
    }

    /* loaded from: classes7.dex */
    public class a extends og1<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ si1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ph1 c;

        public a(ph1 ph1Var, si1 si1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph1Var, si1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ph1Var;
            this.a = si1Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.og1
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, th, str) != null) || this.c.b) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (sg1.b(ki1.a()) && currentTimeMillis - ph1.c <= 3000) {
                if (this.c.a) {
                    this.a.onResult(1, "");
                }
                this.c.i(this.b, this.a);
            } else {
                this.a.onResult(3, "支付失败，请重试");
            }
            this.c.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og1
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) != null) || this.c.b) {
                return;
            }
            int optInt = jSONObject.optInt("status", -1);
            int optInt2 = jSONObject.optInt("payStatus", -1);
            if (optInt == 1 && optInt2 == 0) {
                this.a.onResult(3, "支付失败，请重试");
                return;
            }
            if (optInt != 2 && (optInt != 1 || optInt2 != 2)) {
                if (optInt == 1 && optInt2 == 3) {
                    this.a.onResult(3, "支付失败，请重试");
                } else if (System.currentTimeMillis() - ph1.c <= 3000) {
                    if (this.c.a) {
                        this.a.onResult(1, "");
                    }
                    this.c.i(this.b, this.a);
                } else {
                    this.a.onResult(6, "支付结果查询失败，请重试");
                }
            } else {
                this.a.onResult(0, "小额免密支付成功");
            }
            this.c.a = false;
        }
    }

    public ph1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = true;
        this.b = false;
    }

    public static ph1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (d == null) {
                synchronized (ph1.class) {
                    if (d == null) {
                        d = new ph1();
                    }
                }
            }
            return d;
        }
        return (ph1) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = true;
        }
    }

    public void g(String str, si1 si1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, si1Var) == null) {
            this.b = false;
            this.a = true;
            c = System.currentTimeMillis();
            i(str, si1Var);
        }
    }

    public final void i(String str, si1 si1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, si1Var) == null) {
            String[] split = str.split("&");
            pg1 pg1Var = new pg1();
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2.length == 2) {
                    if (TextUtils.equals(split2[0], "timestamp")) {
                        pg1Var.d(split2[0], URLDecoder.decode(split2[1]));
                    } else {
                        pg1Var.d(split2[0], split2[1]);
                    }
                }
            }
            pg1Var.d("terminalData", "{\"queryOrderType\":\"AGREEMENT\",\"payChannel\":\"BAIDU-ALIPAY-WISE\"}");
            wg1.j().g(yg1.e(), pg1Var, new a(this, si1Var, str));
        }
    }
}
