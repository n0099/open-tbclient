package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class sr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static nr a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            nr nrVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                nrVar = new nr();
                wrap.get();
                wrap.get();
                nrVar.a(wrap.get());
                nrVar.f(wrap.get());
                int i = wrap.getShort();
                nrVar.c(i);
                int i2 = wrap.getInt();
                nrVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                nrVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    nrVar.l(bArr3);
                }
            }
            return nrVar;
        }
        return (nr) invokeL.objValue;
    }

    public static byte[] b(nr nrVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, nrVar)) == null) {
            if (nrVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(nrVar.m() + 12 + nrVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (nrVar.e() != null && nrVar.e().length == 2) {
                allocate.put(nrVar.e()[0]);
                allocate.put(nrVar.e()[1]);
                allocate.put(nrVar.i());
                allocate.put(nrVar.k());
                if (nrVar.o() != null && nrVar.o().length != 0) {
                    int length = nrVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (nrVar.p() != null && nrVar.p().length != 0) {
                        allocate.putInt(nrVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (nrVar.o() != null) {
                        allocate.put(nrVar.o());
                    }
                    if (nrVar.p() != null) {
                        allocate.put(nrVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
