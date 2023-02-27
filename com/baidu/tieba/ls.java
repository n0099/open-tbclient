package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class ls {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static gs a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            gs gsVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                gsVar = new gs();
                wrap.get();
                wrap.get();
                gsVar.a(wrap.get());
                gsVar.f(wrap.get());
                int i = wrap.getShort();
                gsVar.c(i);
                int i2 = wrap.getInt();
                gsVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                gsVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    gsVar.l(bArr3);
                }
            }
            return gsVar;
        }
        return (gs) invokeL.objValue;
    }

    public static byte[] b(gs gsVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gsVar)) == null) {
            if (gsVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(gsVar.m() + 12 + gsVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (gsVar.e() != null && gsVar.e().length == 2) {
                allocate.put(gsVar.e()[0]);
                allocate.put(gsVar.e()[1]);
                allocate.put(gsVar.i());
                allocate.put(gsVar.k());
                if (gsVar.o() != null && gsVar.o().length != 0) {
                    int length = gsVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (gsVar.p() != null && gsVar.p().length != 0) {
                        allocate.putInt(gsVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (gsVar.o() != null) {
                        allocate.put(gsVar.o());
                    }
                    if (gsVar.p() != null) {
                        allocate.put(gsVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
