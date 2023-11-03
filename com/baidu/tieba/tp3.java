package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class tp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static pp3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            pp3 pp3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                pp3Var = new pp3();
                wrap.get();
                wrap.get();
                pp3Var.r(wrap.get());
                pp3Var.p(wrap.get());
                int i = wrap.getShort();
                pp3Var.q(i);
                int i2 = wrap.getInt();
                pp3Var.k(i2);
                pp3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                pp3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    pp3Var.j(bArr3);
                }
            }
            return pp3Var;
        }
        return (pp3) invokeL.objValue;
    }

    public static byte[] b(pp3 pp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pp3Var)) == null) {
            if (pp3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(pp3Var.h() + 20 + pp3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (pp3Var.e() != null && pp3Var.e().length == 2) {
                allocate.put(pp3Var.e()[0]);
                allocate.put(pp3Var.e()[1]);
                allocate.put(pp3Var.i());
                allocate.put(pp3Var.g());
                if (pp3Var.f() != null && pp3Var.f().length != 0) {
                    int length = pp3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (pp3Var.a() != null && pp3Var.a().length != 0) {
                        allocate.putInt(pp3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(pp3Var.c());
                    if (pp3Var.f() != null) {
                        allocate.put(pp3Var.f());
                    }
                    if (pp3Var.a() != null) {
                        allocate.put(pp3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
