package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class pz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(byte[] bArr, byte[] bArr2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, bArr, bArr2, i) == null) {
            if (i < 0) {
                throw new IllegalArgumentException("start should be more than zero!");
            }
            if (bArr == null || bArr.length == 0) {
                throw new IllegalArgumentException("dst array should not be null or empty");
            }
            if (bArr2 == null || bArr2.length == 0) {
                throw new IllegalArgumentException("src array should not be null or empty");
            }
            if (bArr.length < bArr2.length) {
                throw new IllegalArgumentException("dst array length should be longer than:" + bArr2.length);
            }
            if (bArr.length >= bArr2.length + i) {
                System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
                return;
            }
            throw new IllegalArgumentException("start should be less than:" + (bArr.length - bArr2.length));
        }
    }

    public static byte[] b(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, bArr, i)) == null) {
            if (bArr == null || bArr.length == 0) {
                throw new IllegalArgumentException("original array should not be null or empty");
            }
            if (i >= 0) {
                return Arrays.copyOf(bArr, i);
            }
            throw new IllegalArgumentException("length should be more than zero!");
        }
        return (byte[]) invokeLI.objValue;
    }
}
