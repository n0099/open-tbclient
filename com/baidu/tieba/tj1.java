package com.baidu.tieba;

import android.content.Context;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class tj1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tj1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public lk1 a(Context context, uj1 uj1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, uj1Var)) == null) {
            if (uj1Var != null && context != null) {
                try {
                    JSONObject a = uj1Var.a();
                    if (a != null) {
                        String optString = a.optString("material_type");
                        if ("image".equals(optString)) {
                            return new ck1(context, a);
                        }
                        if (NativeConstants.TYPE_GIF.equals(optString)) {
                            return new bk1(context, a);
                        }
                        if ("video".equals(optString)) {
                            return new dk1(context, a);
                        }
                        return null;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (lk1) invokeLL.objValue;
    }
}
