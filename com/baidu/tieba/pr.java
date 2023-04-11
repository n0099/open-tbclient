package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class pr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static kr a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            kr krVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                krVar = new kr();
                wrap.get();
                wrap.get();
                krVar.a(wrap.get());
                krVar.f(wrap.get());
                int i = wrap.getShort();
                krVar.c(i);
                int i2 = wrap.getInt();
                krVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                krVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    krVar.l(bArr3);
                }
            }
            return krVar;
        }
        return (kr) invokeL.objValue;
    }

    public static byte[] b(kr krVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, krVar)) == null) {
            if (krVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(krVar.m() + 12 + krVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (krVar.e() != null && krVar.e().length == 2) {
                allocate.put(krVar.e()[0]);
                allocate.put(krVar.e()[1]);
                allocate.put(krVar.i());
                allocate.put(krVar.k());
                if (krVar.o() != null && krVar.o().length != 0) {
                    int length = krVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (krVar.p() != null && krVar.p().length != 0) {
                        allocate.putInt(krVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (krVar.o() != null) {
                        allocate.put(krVar.o());
                    }
                    if (krVar.p() != null) {
                        allocate.put(krVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
