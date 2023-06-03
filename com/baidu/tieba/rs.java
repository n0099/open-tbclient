package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class rs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static ms a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            ms msVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                msVar = new ms();
                wrap.get();
                wrap.get();
                msVar.a(wrap.get());
                msVar.f(wrap.get());
                int i = wrap.getShort();
                msVar.c(i);
                int i2 = wrap.getInt();
                msVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                msVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    msVar.l(bArr3);
                }
            }
            return msVar;
        }
        return (ms) invokeL.objValue;
    }

    public static byte[] b(ms msVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, msVar)) == null) {
            if (msVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(msVar.m() + 12 + msVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (msVar.e() != null && msVar.e().length == 2) {
                allocate.put(msVar.e()[0]);
                allocate.put(msVar.e()[1]);
                allocate.put(msVar.i());
                allocate.put(msVar.k());
                if (msVar.o() != null && msVar.o().length != 0) {
                    int length = msVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (msVar.p() != null && msVar.p().length != 0) {
                        allocate.putInt(msVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (msVar.o() != null) {
                        allocate.put(msVar.o());
                    }
                    if (msVar.p() != null) {
                        allocate.put(msVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
