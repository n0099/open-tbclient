package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class ss {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static ns a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            ns nsVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                nsVar = new ns();
                wrap.get();
                wrap.get();
                nsVar.a(wrap.get());
                nsVar.f(wrap.get());
                int i = wrap.getShort();
                nsVar.c(i);
                int i2 = wrap.getInt();
                nsVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                nsVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    nsVar.l(bArr3);
                }
            }
            return nsVar;
        }
        return (ns) invokeL.objValue;
    }

    public static byte[] b(ns nsVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, nsVar)) == null) {
            if (nsVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(nsVar.m() + 12 + nsVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (nsVar.e() != null && nsVar.e().length == 2) {
                allocate.put(nsVar.e()[0]);
                allocate.put(nsVar.e()[1]);
                allocate.put(nsVar.i());
                allocate.put(nsVar.k());
                if (nsVar.o() != null && nsVar.o().length != 0) {
                    int length = nsVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (nsVar.p() != null && nsVar.p().length != 0) {
                        allocate.putInt(nsVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (nsVar.o() != null) {
                        allocate.put(nsVar.o());
                    }
                    if (nsVar.p() != null) {
                        allocate.put(nsVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
