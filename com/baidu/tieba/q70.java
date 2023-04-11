package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class q70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void a(Context context, String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65536, null, context, str, str2, i) == null) {
            s70.g().d(context, str, str2, i, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE);
        }
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return s70.g().h();
        }
        return invokeV.intValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            s70.g().k();
        }
    }

    public static void c(@NonNull BLCPRequest bLCPRequest, @Nullable w70 w70Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bLCPRequest, w70Var) == null) {
            s70.g().i(bLCPRequest, w70Var);
        }
    }
}
