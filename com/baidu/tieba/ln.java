package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class ln {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static gn a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            gn gnVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                gnVar = new gn();
                wrap.get();
                wrap.get();
                gnVar.a(wrap.get());
                gnVar.f(wrap.get());
                int i = wrap.getShort();
                gnVar.c(i);
                int i2 = wrap.getInt();
                gnVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                gnVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    gnVar.l(bArr3);
                }
            }
            return gnVar;
        }
        return (gn) invokeL.objValue;
    }

    public static byte[] b(gn gnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gnVar)) == null) {
            if (gnVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(gnVar.m() + 12 + gnVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (gnVar.e() != null && gnVar.e().length == 2) {
                allocate.put(gnVar.e()[0]);
                allocate.put(gnVar.e()[1]);
                allocate.put(gnVar.i());
                allocate.put(gnVar.k());
                if (gnVar.o() != null && gnVar.o().length != 0) {
                    int length = gnVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (gnVar.p() != null && gnVar.p().length != 0) {
                        allocate.putInt(gnVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (gnVar.o() != null) {
                        allocate.put(gnVar.o());
                    }
                    if (gnVar.p() != null) {
                        allocate.put(gnVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
