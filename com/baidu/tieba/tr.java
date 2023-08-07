package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class tr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static or a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            or orVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                orVar = new or();
                wrap.get();
                wrap.get();
                orVar.a(wrap.get());
                orVar.f(wrap.get());
                int i = wrap.getShort();
                orVar.c(i);
                int i2 = wrap.getInt();
                orVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                orVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    orVar.l(bArr3);
                }
            }
            return orVar;
        }
        return (or) invokeL.objValue;
    }

    public static byte[] b(or orVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, orVar)) == null) {
            if (orVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(orVar.m() + 12 + orVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (orVar.e() != null && orVar.e().length == 2) {
                allocate.put(orVar.e()[0]);
                allocate.put(orVar.e()[1]);
                allocate.put(orVar.i());
                allocate.put(orVar.k());
                if (orVar.o() != null && orVar.o().length != 0) {
                    int length = orVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (orVar.p() != null && orVar.p().length != 0) {
                        allocate.putInt(orVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (orVar.o() != null) {
                        allocate.put(orVar.o());
                    }
                    if (orVar.p() != null) {
                        allocate.put(orVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
