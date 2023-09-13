package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static x40 a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bArr, bArr2)) == null) ? new r40(bArr, bArr2) : (x40) invokeLL.objValue;
    }
}
