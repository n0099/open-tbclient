package com.bytedance.pangle.res.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.EOFException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Object a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj != null) {
                return obj;
            }
            throw null;
        }
        return invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v0 int), (r1v1 int), (r2v1 int)] */
    public static void a(InputStream inputStream, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65537, null, inputStream, bArr, i, i2) == null) {
            a(inputStream);
            a(bArr);
            int i3 = 0;
            if (i2 >= 0) {
                int i4 = i + i2;
                int length = bArr.length;
                if (i >= 0 && i4 >= i && i4 <= length) {
                    while (i3 < i2) {
                        int read = inputStream.read(bArr, i + i3, i2 - i3);
                        if (read == -1) {
                            break;
                        }
                        i3 += read;
                    }
                    if (i3 == i2) {
                        return;
                    }
                    throw new EOFException("reached end of stream after reading " + i3 + " bytes; " + i2 + " bytes expected");
                }
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append(i4);
                sb.append(length);
                throw new IndexOutOfBoundsException(sb.toString());
            }
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i2)));
        }
    }
}
