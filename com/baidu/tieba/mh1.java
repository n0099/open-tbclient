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
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.net.URLDecoder;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class mh1 {
    public static /* synthetic */ Interceptable $ic;
    public static mh1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public b b;

    /* loaded from: classes7.dex */
    public interface b {
        void onResult(int i, String str);
    }

    /* loaded from: classes7.dex */
    public class a extends kg1<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi1 a;

        public a(mh1 mh1Var, oi1 oi1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh1Var, oi1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi1Var;
        }

        @Override // com.baidu.tieba.kg1
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                this.a.onResult(119501, "");
                th.printStackTrace();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg1
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                int optInt = jSONObject.optInt("status", -1);
                int optInt2 = jSONObject.optInt("signStatus", -1);
                int optInt3 = jSONObject.optInt("payStatus", -1);
                if (2 != optInt && 2 != optInt3) {
                    this.a.onResult(optInt2, "");
                } else {
                    this.a.onResult(0, EventAlias.PayEventAlias.PAY_SUCCESS);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947972563, "Lcom/baidu/tieba/mh1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947972563, "Lcom/baidu/tieba/mh1;");
                return;
            }
        }
        c = new mh1();
    }

    public mh1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static mh1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c;
        }
        return (mh1) invokeV.objValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (b) invokeV.objValue;
    }

    public void a(oi1 oi1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oi1Var) == null) {
            String[] split = this.a.split("&");
            lg1 lg1Var = new lg1();
            for (String str : split) {
                String[] split2 = str.split("=");
                if (split2 != null && split2.length == 2) {
                    if (TextUtils.equals(split2[0], "timestamp")) {
                        lg1Var.d(split2[0], URLDecoder.decode(split2[1]));
                    } else {
                        lg1Var.d(split2[0], split2[1]);
                    }
                }
            }
            sg1.j().g(ug1.e(), lg1Var, new a(this, oi1Var));
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a = str;
        }
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.b = bVar;
        }
    }
}
