package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class tm {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static om a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            om omVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                omVar = new om();
                wrap.get();
                wrap.get();
                omVar.a(wrap.get());
                omVar.f(wrap.get());
                int i = wrap.getShort();
                omVar.c(i);
                int i2 = wrap.getInt();
                omVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                omVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    omVar.l(bArr3);
                }
            }
            return omVar;
        }
        return (om) invokeL.objValue;
    }

    public static byte[] b(om omVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, omVar)) == null) {
            if (omVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(omVar.m() + 12 + omVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (omVar.e() != null && omVar.e().length == 2) {
                allocate.put(omVar.e()[0]);
                allocate.put(omVar.e()[1]);
                allocate.put(omVar.i());
                allocate.put(omVar.k());
                if (omVar.o() != null && omVar.o().length != 0) {
                    int length = omVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (omVar.p() != null && omVar.p().length != 0) {
                        allocate.putInt(omVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (omVar.o() != null) {
                        allocate.put(omVar.o());
                    }
                    if (omVar.p() != null) {
                        allocate.put(omVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
