package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class or {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static jr a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            jr jrVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                jrVar = new jr();
                wrap.get();
                wrap.get();
                jrVar.a(wrap.get());
                jrVar.f(wrap.get());
                int i = wrap.getShort();
                jrVar.c(i);
                int i2 = wrap.getInt();
                jrVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                jrVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    jrVar.l(bArr3);
                }
            }
            return jrVar;
        }
        return (jr) invokeL.objValue;
    }

    public static byte[] b(jr jrVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jrVar)) == null) {
            if (jrVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(jrVar.m() + 12 + jrVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (jrVar.e() != null && jrVar.e().length == 2) {
                allocate.put(jrVar.e()[0]);
                allocate.put(jrVar.e()[1]);
                allocate.put(jrVar.i());
                allocate.put(jrVar.k());
                if (jrVar.o() != null && jrVar.o().length != 0) {
                    int length = jrVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (jrVar.p() != null && jrVar.p().length != 0) {
                        allocate.putInt(jrVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (jrVar.o() != null) {
                        allocate.put(jrVar.o());
                    }
                    if (jrVar.p() != null) {
                        allocate.put(jrVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
