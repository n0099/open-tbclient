package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import javax.annotation.Nullable;
import org.webrtc.EglBase;
import org.webrtc.EglBase10;
import org.webrtc.EglBase14;
/* compiled from: EglBase.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class jz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static EglBase a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return c(null, EglBase.CONFIG_PLAIN);
        }
        return (EglBase) invokeV.objValue;
    }

    public static EglBase b(EglBase.Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return c(context, EglBase.CONFIG_PLAIN);
        }
        return (EglBase) invokeL.objValue;
    }

    public static EglBase d(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iArr)) == null) {
            return new EglBase10(null, iArr);
        }
        return (EglBase) invokeL.objValue;
    }

    public static EglBase c(@Nullable EglBase.Context context, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, iArr)) == null) {
            if (EglBase14.isEGL14Supported() && (context == null || (context instanceof EglBase14.Context))) {
                return new EglBase14((EglBase14.Context) context, iArr);
            }
            return new EglBase10((EglBase10.Context) context, iArr);
        }
        return (EglBase) invokeLL.objValue;
    }
}
