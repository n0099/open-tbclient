package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class wr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static rr a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            rr rrVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                rrVar = new rr();
                wrap.get();
                wrap.get();
                rrVar.a(wrap.get());
                rrVar.f(wrap.get());
                int i = wrap.getShort();
                rrVar.c(i);
                int i2 = wrap.getInt();
                rrVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                rrVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    rrVar.l(bArr3);
                }
            }
            return rrVar;
        }
        return (rr) invokeL.objValue;
    }

    public static byte[] b(rr rrVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rrVar)) == null) {
            if (rrVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(rrVar.m() + 12 + rrVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (rrVar.e() != null && rrVar.e().length == 2) {
                allocate.put(rrVar.e()[0]);
                allocate.put(rrVar.e()[1]);
                allocate.put(rrVar.i());
                allocate.put(rrVar.k());
                if (rrVar.o() != null && rrVar.o().length != 0) {
                    int length = rrVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (rrVar.p() != null && rrVar.p().length != 0) {
                        allocate.putInt(rrVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (rrVar.o() != null) {
                        allocate.put(rrVar.o());
                    }
                    if (rrVar.p() != null) {
                        allocate.put(rrVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
