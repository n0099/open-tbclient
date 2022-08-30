package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class mk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static ik3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            ik3 ik3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                ik3Var = new ik3();
                wrap.get();
                wrap.get();
                ik3Var.r(wrap.get());
                ik3Var.p(wrap.get());
                int i = wrap.getShort();
                ik3Var.q(i);
                int i2 = wrap.getInt();
                ik3Var.k(i2);
                ik3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                ik3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    ik3Var.j(bArr3);
                }
            }
            return ik3Var;
        }
        return (ik3) invokeL.objValue;
    }

    public static byte[] b(ik3 ik3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ik3Var)) == null) {
            if (ik3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(ik3Var.h() + 20 + ik3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (ik3Var.e() != null && ik3Var.e().length == 2) {
                allocate.put(ik3Var.e()[0]);
                allocate.put(ik3Var.e()[1]);
                allocate.put(ik3Var.i());
                allocate.put(ik3Var.g());
                if (ik3Var.f() != null && ik3Var.f().length != 0) {
                    int length = ik3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (ik3Var.a() != null && ik3Var.a().length != 0) {
                        allocate.putInt(ik3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(ik3Var.c());
                    if (ik3Var.f() != null) {
                        allocate.put(ik3Var.f());
                    }
                    if (ik3Var.a() != null) {
                        allocate.put(ik3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
