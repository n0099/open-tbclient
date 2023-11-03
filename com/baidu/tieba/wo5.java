package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wo5 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948277324, "Lcom/baidu/tieba/wo5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948277324, "Lcom/baidu/tieba/wo5;");
                return;
            }
        }
        qd.getUrlEncode(TbConfig.TIEBA_ADDRESS + "mo/q/tbeanget?_client_return_page=close");
        a = TbConfig.TIEBA_ADDRESS + "mo/q/tbeantshow";
        String str = TbConfig.TIEBA_ADDRESS + "mo/q/tbeanget?difference=%1$s&fr=0&return_type=1&return_url=%2$s";
    }
}
