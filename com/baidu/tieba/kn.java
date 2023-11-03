package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class kn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static fn a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            fn fnVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                fnVar = new fn();
                wrap.get();
                wrap.get();
                fnVar.a(wrap.get());
                fnVar.f(wrap.get());
                int i = wrap.getShort();
                fnVar.c(i);
                int i2 = wrap.getInt();
                fnVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                fnVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    fnVar.l(bArr3);
                }
            }
            return fnVar;
        }
        return (fn) invokeL.objValue;
    }

    public static byte[] b(fn fnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fnVar)) == null) {
            if (fnVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(fnVar.m() + 12 + fnVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (fnVar.e() != null && fnVar.e().length == 2) {
                allocate.put(fnVar.e()[0]);
                allocate.put(fnVar.e()[1]);
                allocate.put(fnVar.i());
                allocate.put(fnVar.k());
                if (fnVar.o() != null && fnVar.o().length != 0) {
                    int length = fnVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (fnVar.p() != null && fnVar.p().length != 0) {
                        allocate.putInt(fnVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (fnVar.o() != null) {
                        allocate.put(fnVar.o());
                    }
                    if (fnVar.p() != null) {
                        allocate.put(fnVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
