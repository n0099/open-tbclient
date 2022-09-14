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
/* loaded from: classes5.dex */
public class pv3 extends ev3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948075452, "Lcom/baidu/tieba/pv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948075452, "Lcom/baidu/tieba/pv3;");
                return;
            }
        }
        c = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pv3() {
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

    @Override // com.baidu.tieba.ev3
    public yu1 a(@NonNull JSONObject jSONObject, @NonNull cg2 cg2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, cg2Var)) == null) {
            y23 b0 = y23.b0();
            if (b0 != null && b0.w() != null) {
                try {
                    b0.w().startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
                } catch (Exception e) {
                    if (c) {
                        e.printStackTrace();
                    }
                    cg3.f(b0.w());
                }
                cg2Var.a(null);
            } else {
                cg2Var.onFail(100, "swan or activity is null");
                if (c) {
                    Log.d("StartAppUsagePage", "swan or activity is null");
                }
            }
            return null;
        }
        return (yu1) invokeLL.objValue;
    }
}
