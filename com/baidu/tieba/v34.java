package com.baidu.tieba;

import android.util.Log;
import com.baidu.appsearchlib.Info;
import com.baidu.tieba.ug3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class v34 extends n34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements ug3.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lo2 a;

        public a(v34 v34Var, lo2 lo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v34Var, lo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lo2Var;
        }

        @Override // com.baidu.tieba.ug3.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == -1) {
                    v34.c(this.a, "202");
                } else if (i == 1) {
                    v34.c(this.a, BasicPushStatus.SUCCESS_CODE);
                } else {
                    this.a.onFail(101, "noPermission");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948189842, "Lcom/baidu/tieba/v34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948189842, "Lcom/baidu/tieba/v34;");
                return;
            }
        }
        c = rr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v34() {
        super("addShortcutToDesktop");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void c(lo2 lo2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, lo2Var, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", str);
            } catch (JSONException e) {
                if (c) {
                    e.printStackTrace();
                }
            }
            lo2Var.onSuccess(jSONObject);
        }
    }

    @Override // com.baidu.tieba.n34
    public h32 a(JSONObject jSONObject, lo2 lo2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, lo2Var)) == null) {
            hb3 b0 = hb3.b0();
            if (b0 != null && b0.w() != null && b0.W() != null) {
                if (ug3.s(b0.w(), b0.W().K(), b0.W().H()) == 1) {
                    c(lo2Var, Info.kBaiduPIDValue);
                    return null;
                }
                ug3.j(b0.w(), b0.W(), 1, new a(this, lo2Var));
                return null;
            }
            lo2Var.onFail(100, "swan or activity is null");
            if (c) {
                Log.d("AddShortcutToDesktop", "swan or activity is null");
                return null;
            }
            return null;
        }
        return (h32) invokeLL.objValue;
    }
}
