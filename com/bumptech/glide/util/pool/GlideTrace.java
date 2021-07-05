package com.bumptech.glide.util.pool;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class GlideTrace {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_LENGTH = 127;
    public static final boolean TRACING_ENABLED = false;
    public transient /* synthetic */ FieldHolder $fh;

    public GlideTrace() {
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

    public static void beginSection(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
        }
    }

    public static void beginSectionFormat(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, obj) == null) {
        }
    }

    public static void beginSectionFormat(String str, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, obj, obj2) == null) {
        }
    }

    public static void beginSectionFormat(String str, Object obj, Object obj2, Object obj3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65540, null, str, obj, obj2, obj3) == null) {
        }
    }

    public static void endSection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
        }
    }

    public static String truncateTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? str.length() > 127 ? str.substring(0, 126) : str : (String) invokeL.objValue;
    }
}
