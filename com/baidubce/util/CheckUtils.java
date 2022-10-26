package com.baidubce.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CheckUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CheckUtils() {
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

    public static void checkArgument(boolean z, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(65537, null, z, obj) != null) || z) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void isNotNull(Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, obj, str) != null) || obj != null) {
            return;
        }
        throw new NullPointerException(String.valueOf(str));
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), str, objArr}) != null) || z) {
            return;
        }
        throw new IllegalArgumentException(format(str, objArr));
    }

    public static Object isNotNull(Object obj, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str, objArr)) == null) {
            if (obj != null) {
                return obj;
            }
            throw new NullPointerException(format(str, objArr));
        }
        return invokeLLL.objValue;
    }

    public static String format(String str, Object... objArr) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, objArr)) == null) {
            String valueOf = String.valueOf(str);
            StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
            int i = 0;
            int i2 = 0;
            while (i < objArr.length && (indexOf = valueOf.indexOf("%s", i2)) != -1) {
                sb.append(valueOf.substring(i2, indexOf));
                sb.append(objArr[i]);
                i2 = indexOf + 2;
                i++;
            }
            sb.append(valueOf.substring(i2));
            if (i < objArr.length) {
                sb.append(" [");
                sb.append(objArr[i]);
                for (int i3 = i + 1; i3 < objArr.length; i3++) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(objArr[i3]);
                }
                sb.append(']');
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
