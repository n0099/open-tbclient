package com.baidubce.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.FormattableUtils;
/* loaded from: classes12.dex */
public class CheckUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CheckUtils() {
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

    public static void checkArgument(boolean z, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65537, null, z, obj) == null) && !z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static String format(String str, Object... objArr) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, objArr)) == null) {
            String valueOf = String.valueOf(str);
            StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
            int i2 = 0;
            int i3 = 0;
            while (i2 < objArr.length && (indexOf = valueOf.indexOf(FormattableUtils.SIMPLEST_FORMAT, i3)) != -1) {
                sb.append(valueOf.substring(i3, indexOf));
                sb.append(objArr[i2]);
                i3 = indexOf + 2;
                i2++;
            }
            sb.append(valueOf.substring(i3));
            if (i2 < objArr.length) {
                sb.append(" [");
                sb.append(objArr[i2]);
                for (int i4 = i2 + 1; i4 < objArr.length; i4++) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(objArr[i4]);
                }
                sb.append(']');
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static <T> void isNotNull(T t, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, t, str) == null) && t == null) {
            throw new NullPointerException(String.valueOf(str));
        }
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), str, objArr}) == null) && !z) {
            throw new IllegalArgumentException(format(str, objArr));
        }
    }

    public static <T> T isNotNull(T t, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, t, str, objArr)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(format(str, objArr));
        }
        return (T) invokeLLL.objValue;
    }
}
