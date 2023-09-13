package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class xr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static sr a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            sr srVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                srVar = new sr();
                wrap.get();
                wrap.get();
                srVar.a(wrap.get());
                srVar.f(wrap.get());
                int i = wrap.getShort();
                srVar.c(i);
                int i2 = wrap.getInt();
                srVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                srVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    srVar.l(bArr3);
                }
            }
            return srVar;
        }
        return (sr) invokeL.objValue;
    }

    public static byte[] b(sr srVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, srVar)) == null) {
            if (srVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(srVar.m() + 12 + srVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (srVar.e() != null && srVar.e().length == 2) {
                allocate.put(srVar.e()[0]);
                allocate.put(srVar.e()[1]);
                allocate.put(srVar.i());
                allocate.put(srVar.k());
                if (srVar.o() != null && srVar.o().length != 0) {
                    int length = srVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (srVar.p() != null && srVar.p().length != 0) {
                        allocate.putInt(srVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (srVar.o() != null) {
                        allocate.put(srVar.o());
                    }
                    if (srVar.p() != null) {
                        allocate.put(srVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
