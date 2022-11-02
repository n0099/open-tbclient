package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class zr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static ur a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            ur urVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                urVar = new ur();
                wrap.get();
                wrap.get();
                urVar.a(wrap.get());
                urVar.f(wrap.get());
                int i = wrap.getShort();
                urVar.c(i);
                int i2 = wrap.getInt();
                urVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                urVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    urVar.l(bArr3);
                }
            }
            return urVar;
        }
        return (ur) invokeL.objValue;
    }

    public static byte[] b(ur urVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, urVar)) == null) {
            if (urVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(urVar.m() + 12 + urVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (urVar.e() != null && urVar.e().length == 2) {
                allocate.put(urVar.e()[0]);
                allocate.put(urVar.e()[1]);
                allocate.put(urVar.i());
                allocate.put(urVar.k());
                if (urVar.o() != null && urVar.o().length != 0) {
                    int length = urVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (urVar.p() != null && urVar.p().length != 0) {
                        allocate.putInt(urVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (urVar.o() != null) {
                        allocate.put(urVar.o());
                    }
                    if (urVar.p() != null) {
                        allocate.put(urVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
