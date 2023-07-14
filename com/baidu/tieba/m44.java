package com.baidu.tieba;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m44 extends b44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947922684, "Lcom/baidu/tieba/m44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947922684, "Lcom/baidu/tieba/m44;");
                return;
            }
        }
        c = fs1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m44() {
        super("StartAppUsagePage");
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

    @Override // com.baidu.tieba.b44
    public v32 a(@NonNull JSONObject jSONObject, @NonNull zo2 zo2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, zo2Var)) == null) {
            vb3 b0 = vb3.b0();
            if (b0 != null && b0.w() != null) {
                try {
                    b0.w().startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
                } catch (Exception e) {
                    if (c) {
                        e.printStackTrace();
                    }
                    zo3.f(b0.w());
                }
                zo2Var.onSuccess(null);
            } else {
                zo2Var.onFail(100, "swan or activity is null");
                if (c) {
                    Log.d("StartAppUsagePage", "swan or activity is null");
                }
            }
            return null;
        }
        return (v32) invokeLL.objValue;
    }
}
