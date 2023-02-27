package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class zs3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static vs3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            vs3 vs3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                vs3Var = new vs3();
                wrap.get();
                wrap.get();
                vs3Var.r(wrap.get());
                vs3Var.p(wrap.get());
                int i = wrap.getShort();
                vs3Var.q(i);
                int i2 = wrap.getInt();
                vs3Var.k(i2);
                vs3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                vs3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    vs3Var.j(bArr3);
                }
            }
            return vs3Var;
        }
        return (vs3) invokeL.objValue;
    }

    public static byte[] b(vs3 vs3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vs3Var)) == null) {
            if (vs3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(vs3Var.h() + 20 + vs3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (vs3Var.e() != null && vs3Var.e().length == 2) {
                allocate.put(vs3Var.e()[0]);
                allocate.put(vs3Var.e()[1]);
                allocate.put(vs3Var.i());
                allocate.put(vs3Var.g());
                if (vs3Var.f() != null && vs3Var.f().length != 0) {
                    int length = vs3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (vs3Var.a() != null && vs3Var.a().length != 0) {
                        allocate.putInt(vs3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(vs3Var.c());
                    if (vs3Var.f() != null) {
                        allocate.put(vs3Var.f());
                    }
                    if (vs3Var.a() != null) {
                        allocate.put(vs3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
