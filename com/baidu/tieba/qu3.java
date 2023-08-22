package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class qu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static mu3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            mu3 mu3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                mu3Var = new mu3();
                wrap.get();
                wrap.get();
                mu3Var.r(wrap.get());
                mu3Var.p(wrap.get());
                int i = wrap.getShort();
                mu3Var.q(i);
                int i2 = wrap.getInt();
                mu3Var.k(i2);
                mu3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                mu3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    mu3Var.j(bArr3);
                }
            }
            return mu3Var;
        }
        return (mu3) invokeL.objValue;
    }

    public static byte[] b(mu3 mu3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mu3Var)) == null) {
            if (mu3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(mu3Var.h() + 20 + mu3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (mu3Var.e() != null && mu3Var.e().length == 2) {
                allocate.put(mu3Var.e()[0]);
                allocate.put(mu3Var.e()[1]);
                allocate.put(mu3Var.i());
                allocate.put(mu3Var.g());
                if (mu3Var.f() != null && mu3Var.f().length != 0) {
                    int length = mu3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (mu3Var.a() != null && mu3Var.a().length != 0) {
                        allocate.putInt(mu3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(mu3Var.c());
                    if (mu3Var.f() != null) {
                        allocate.put(mu3Var.f());
                    }
                    if (mu3Var.a() != null) {
                        allocate.put(mu3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
