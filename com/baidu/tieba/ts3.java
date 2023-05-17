package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class ts3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static ps3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            ps3 ps3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                ps3Var = new ps3();
                wrap.get();
                wrap.get();
                ps3Var.r(wrap.get());
                ps3Var.p(wrap.get());
                int i = wrap.getShort();
                ps3Var.q(i);
                int i2 = wrap.getInt();
                ps3Var.k(i2);
                ps3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                ps3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    ps3Var.j(bArr3);
                }
            }
            return ps3Var;
        }
        return (ps3) invokeL.objValue;
    }

    public static byte[] b(ps3 ps3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ps3Var)) == null) {
            if (ps3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(ps3Var.h() + 20 + ps3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (ps3Var.e() != null && ps3Var.e().length == 2) {
                allocate.put(ps3Var.e()[0]);
                allocate.put(ps3Var.e()[1]);
                allocate.put(ps3Var.i());
                allocate.put(ps3Var.g());
                if (ps3Var.f() != null && ps3Var.f().length != 0) {
                    int length = ps3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (ps3Var.a() != null && ps3Var.a().length != 0) {
                        allocate.putInt(ps3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(ps3Var.c());
                    if (ps3Var.f() != null) {
                        allocate.put(ps3Var.f());
                    }
                    if (ps3Var.a() != null) {
                        allocate.put(ps3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
