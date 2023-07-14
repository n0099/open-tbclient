package com.baidu.tieba;

import android.util.Log;
import com.baidu.appsearchlib.Info;
import com.baidu.tieba.ih3;
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
/* loaded from: classes6.dex */
public class j44 extends b44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ih3.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zo2 a;

        public a(j44 j44Var, zo2 zo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j44Var, zo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zo2Var;
        }

        @Override // com.baidu.tieba.ih3.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == -1) {
                    j44.c(this.a, "202");
                } else if (i == 1) {
                    j44.c(this.a, BasicPushStatus.SUCCESS_CODE);
                } else {
                    this.a.onFail(101, "noPermission");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947833311, "Lcom/baidu/tieba/j44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947833311, "Lcom/baidu/tieba/j44;");
                return;
            }
        }
        c = fs1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j44() {
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

    public static void c(zo2 zo2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, zo2Var, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", str);
            } catch (JSONException e) {
                if (c) {
                    e.printStackTrace();
                }
            }
            zo2Var.onSuccess(jSONObject);
        }
    }

    @Override // com.baidu.tieba.b44
    public v32 a(JSONObject jSONObject, zo2 zo2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, zo2Var)) == null) {
            vb3 b0 = vb3.b0();
            if (b0 != null && b0.w() != null && b0.W() != null) {
                if (ih3.s(b0.w(), b0.W().K(), b0.W().H()) == 1) {
                    c(zo2Var, Info.kBaiduPIDValue);
                    return null;
                }
                ih3.j(b0.w(), b0.W(), 1, new a(this, zo2Var));
                return null;
            }
            zo2Var.onFail(100, "swan or activity is null");
            if (c) {
                Log.d("AddShortcutToDesktop", "swan or activity is null");
                return null;
            }
            return null;
        }
        return (v32) invokeLL.objValue;
    }
}
