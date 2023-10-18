package com.baidu.tieba;

import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class mw0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -2;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947986947, "Lcom/baidu/tieba/mw0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947986947, "Lcom/baidu/tieba/mw0;");
        }
    }

    public static void a(ClarityUrlList clarityUrlList) {
        ClarityUrlList.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, clarityUrlList) == null) {
            Iterator it = clarityUrlList.iterator();
            while (true) {
                if (it.hasNext()) {
                    cVar = (ClarityUrlList.c) it.next();
                    if ("auto".equals(cVar.c())) {
                        break;
                    }
                } else {
                    cVar = null;
                    break;
                }
            }
            if (cVar != null) {
                clarityUrlList.remove(cVar);
            }
        }
    }

    public static dv0 b(ClarityUrlList clarityUrlList, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{clarityUrlList, Double.valueOf(d)})) == null) {
            a(clarityUrlList);
            int f = xw0.f(a);
            a = f;
            return xw0.g(clarityUrlList, f, d, false);
        }
        return (dv0) invokeCommon.objValue;
    }
}
