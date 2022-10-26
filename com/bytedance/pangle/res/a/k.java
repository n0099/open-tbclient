package com.bytedance.pangle.res.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayInputStream;
/* loaded from: classes7.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? new byte[]{(byte) (i >> 0), (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)} : (byte[]) invokeI.objValue;
    }

    public static int a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gVar)) == null) {
            return (int) gVar.a.a().b();
        }
        return invokeL.intValue;
    }

    public static void a(byte[] bArr, int i, int i2, h hVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), hVar}) == null) && i >= 2130706432) {
            byte[] a = a(hVar.a(i));
            bArr[i2] = a[0];
            bArr[i2 + 1] = a[1];
            bArr[i2 + 2] = a[2];
            bArr[i2 + 3] = a[3];
        }
    }

    public static void a(byte[] bArr, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bArr, hVar) == null) {
            b bVar = new b(bArr, hVar);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            bVar.a();
            bVar.a = new g(new i(new e(byteArrayInputStream)));
            do {
            } while (bVar.b() != 1);
        }
    }
}
