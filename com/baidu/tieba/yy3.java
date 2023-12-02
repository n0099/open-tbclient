package com.baidu.tieba;

import android.util.Log;
import com.baidu.appsearchlib.Info;
import com.baidu.tieba.xb3;
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
/* loaded from: classes9.dex */
public class yy3 extends qy3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements xb3.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj2 a;

        public a(yy3 yy3Var, oj2 oj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy3Var, oj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oj2Var;
        }

        @Override // com.baidu.tieba.xb3.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == -1) {
                    yy3.c(this.a, "202");
                } else if (i == 1) {
                    yy3.c(this.a, BasicPushStatus.SUCCESS_CODE);
                } else {
                    this.a.onFail(101, "noPermission");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948346454, "Lcom/baidu/tieba/yy3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948346454, "Lcom/baidu/tieba/yy3;");
                return;
            }
        }
        c = vm1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yy3() {
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

    public static void c(oj2 oj2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, oj2Var, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", str);
            } catch (JSONException e) {
                if (c) {
                    e.printStackTrace();
                }
            }
            oj2Var.onSuccess(jSONObject);
        }
    }

    @Override // com.baidu.tieba.qy3
    public ly1 a(JSONObject jSONObject, oj2 oj2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, oj2Var)) == null) {
            k63 c0 = k63.c0();
            if (c0 != null && c0.w() != null && c0.X() != null) {
                if (xb3.s(c0.w(), c0.X().L(), c0.X().I()) == 1) {
                    c(oj2Var, Info.kBaiduPIDValue);
                    return null;
                }
                xb3.j(c0.w(), c0.X(), 1, new a(this, oj2Var));
                return null;
            }
            oj2Var.onFail(100, "swan or activity is null");
            if (c) {
                Log.d("AddShortcutToDesktop", "swan or activity is null");
                return null;
            }
            return null;
        }
        return (ly1) invokeLL.objValue;
    }
}
