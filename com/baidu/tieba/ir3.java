package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class ir3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static er3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            er3 er3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                er3Var = new er3();
                wrap.get();
                wrap.get();
                er3Var.r(wrap.get());
                er3Var.p(wrap.get());
                int i = wrap.getShort();
                er3Var.q(i);
                int i2 = wrap.getInt();
                er3Var.k(i2);
                er3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                er3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    er3Var.j(bArr3);
                }
            }
            return er3Var;
        }
        return (er3) invokeL.objValue;
    }

    public static byte[] b(er3 er3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, er3Var)) == null) {
            if (er3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(er3Var.h() + 20 + er3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (er3Var.e() != null && er3Var.e().length == 2) {
                allocate.put(er3Var.e()[0]);
                allocate.put(er3Var.e()[1]);
                allocate.put(er3Var.i());
                allocate.put(er3Var.g());
                if (er3Var.f() != null && er3Var.f().length != 0) {
                    int length = er3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (er3Var.a() != null && er3Var.a().length != 0) {
                        allocate.putInt(er3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(er3Var.c());
                    if (er3Var.f() != null) {
                        allocate.put(er3Var.f());
                    }
                    if (er3Var.a() != null) {
                        allocate.put(er3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
