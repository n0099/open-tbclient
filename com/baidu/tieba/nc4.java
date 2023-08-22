package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* loaded from: classes7.dex */
public class nc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final Object b;

    public static String f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            switch (i) {
                case 1:
                    return "boolean";
                case 2:
                case 3:
                case 5:
                    return "number";
                case 4:
                default:
                    return "unknown";
                case 6:
                    return "array";
                case 7:
                    return EMABTest.TYPE_STRING;
                case 8:
                    return "function";
                case 9:
                    return "object";
                case 10:
                    return "arraybuffer";
                case 11:
                    return StringUtil.NULL_STRING;
                case 12:
                    return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
            }
        }
        return (String) invokeI.objValue;
    }

    public nc4(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = obj;
    }

    public static Object a(ni2 ni2Var, String str, String str2, nc4 nc4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, ni2Var, str, str2, nc4Var)) == null) {
            if (nc4Var.g()) {
                return nc4Var.d();
            }
            String a = kc4.a(str, str2, nc4Var.e());
            ni2Var.throwJSException(JSExceptionType.Error, a);
            return a;
        }
        return invokeLLLL.objValue;
    }

    public static nc4 b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return new nc4(str, null);
        }
        return (nc4) invokeL.objValue;
    }

    public static nc4 i(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) {
            return new nc4(null, obj);
        }
        return (nc4) invokeL.objValue;
    }

    public static Object h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new JsObject();
        }
        return invokeV.objValue;
    }

    public Object d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (g()) {
                return kc4.b(str);
            }
            return kc4.a(str, str2, e());
        }
        return (String) invokeLL.objValue;
    }
}
