package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class ts {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static os a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            os osVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                osVar = new os();
                wrap.get();
                wrap.get();
                osVar.a(wrap.get());
                osVar.f(wrap.get());
                int i = wrap.getShort();
                osVar.c(i);
                int i2 = wrap.getInt();
                osVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                osVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    osVar.l(bArr3);
                }
            }
            return osVar;
        }
        return (os) invokeL.objValue;
    }

    public static byte[] b(os osVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, osVar)) == null) {
            if (osVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(osVar.m() + 12 + osVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (osVar.e() != null && osVar.e().length == 2) {
                allocate.put(osVar.e()[0]);
                allocate.put(osVar.e()[1]);
                allocate.put(osVar.i());
                allocate.put(osVar.k());
                if (osVar.o() != null && osVar.o().length != 0) {
                    int length = osVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (osVar.p() != null && osVar.p().length != 0) {
                        allocate.putInt(osVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (osVar.o() != null) {
                        allocate.put(osVar.o());
                    }
                    if (osVar.p() != null) {
                        allocate.put(osVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
