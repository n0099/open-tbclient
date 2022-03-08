package com.baidubce.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class JoinerUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public JoinerUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String cut(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? str2.replace(str, "") : (String) invokeLL.objValue;
    }

    public static String on(String str, List<String> list) {
        InterceptResult invokeLL;
        Iterator<String> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, list)) == null) {
            String str2 = "";
            while (list.iterator().hasNext()) {
                str2 = str2 + it.next() + str;
            }
            return str2.substring(0, str2.length() - 1);
        }
        return (String) invokeLL.objValue;
    }

    public static String on(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, objArr)) == null) {
            String str2 = "";
            for (Object obj : objArr) {
                str2 = str2 + obj + str;
            }
            return str2.substring(0, str2.length() - 1);
        }
        return (String) invokeLL.objValue;
    }
}
