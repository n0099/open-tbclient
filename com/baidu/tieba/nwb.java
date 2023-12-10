package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class nwb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static double a(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, byteBuffer, i)) == null) {
            if (byteBuffer == null || i == 0) {
                return 0.0d;
            }
            byteBuffer.position(i);
            byteBuffer.flip();
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            byteBuffer.position(i);
            byteBuffer.flip();
            double d = 0.0d;
            for (int i2 = 0; i2 < i; i2 += 2) {
                int i3 = (bArr[i2] & 255) + ((bArr[i2 + 1] & 255) << 8);
                if (i3 >= 32768) {
                    i3 = 65535 - i3;
                }
                d += i3 * i3;
            }
            double d2 = (d / i) / 2.0d;
            return Math.abs(d2 > 0.0d ? Math.log10(d2) * 10.0d : 0.0d);
        }
        return invokeLI.doubleValue;
    }
}
