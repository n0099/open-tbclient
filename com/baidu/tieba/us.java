package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class us {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static ps a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            ps psVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                psVar = new ps();
                wrap.get();
                wrap.get();
                psVar.a(wrap.get());
                psVar.f(wrap.get());
                int i = wrap.getShort();
                psVar.c(i);
                int i2 = wrap.getInt();
                psVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                psVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    psVar.l(bArr3);
                }
            }
            return psVar;
        }
        return (ps) invokeL.objValue;
    }

    public static byte[] b(ps psVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, psVar)) == null) {
            if (psVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(psVar.m() + 12 + psVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (psVar.e() != null && psVar.e().length == 2) {
                allocate.put(psVar.e()[0]);
                allocate.put(psVar.e()[1]);
                allocate.put(psVar.i());
                allocate.put(psVar.k());
                if (psVar.o() != null && psVar.o().length != 0) {
                    int length = psVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (psVar.p() != null && psVar.p().length != 0) {
                        allocate.putInt(psVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (psVar.o() != null) {
                        allocate.put(psVar.o());
                    }
                    if (psVar.p() != null) {
                        allocate.put(psVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
