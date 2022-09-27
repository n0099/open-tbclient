package com.baidu.tieba;

import android.content.Context;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class rf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rf1() {
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

    public jg1 a(Context context, sf1 sf1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, sf1Var)) == null) {
            if (sf1Var == null || context == null) {
                return null;
            }
            try {
                JSONObject a = sf1Var.a();
                if (a != null) {
                    String optString = a.optString("material_type");
                    if ("image".equals(optString)) {
                        return new ag1(context, a);
                    }
                    if (NativeConstants.TYPE_GIF.equals(optString)) {
                        return new zf1(context, a);
                    }
                    if ("video".equals(optString)) {
                        return new bg1(context, a);
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (jg1) invokeLL.objValue;
    }
}
