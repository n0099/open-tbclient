package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class rn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static nn3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            nn3 nn3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                nn3Var = new nn3();
                wrap.get();
                wrap.get();
                nn3Var.r(wrap.get());
                nn3Var.p(wrap.get());
                int i = wrap.getShort();
                nn3Var.q(i);
                int i2 = wrap.getInt();
                nn3Var.k(i2);
                nn3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                nn3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    nn3Var.j(bArr3);
                }
            }
            return nn3Var;
        }
        return (nn3) invokeL.objValue;
    }

    public static byte[] b(nn3 nn3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, nn3Var)) == null) {
            if (nn3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(nn3Var.h() + 20 + nn3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (nn3Var.e() != null && nn3Var.e().length == 2) {
                allocate.put(nn3Var.e()[0]);
                allocate.put(nn3Var.e()[1]);
                allocate.put(nn3Var.i());
                allocate.put(nn3Var.g());
                if (nn3Var.f() != null && nn3Var.f().length != 0) {
                    int length = nn3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (nn3Var.a() != null && nn3Var.a().length != 0) {
                        allocate.putInt(nn3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(nn3Var.c());
                    if (nn3Var.f() != null) {
                        allocate.put(nn3Var.f());
                    }
                    if (nn3Var.a() != null) {
                        allocate.put(nn3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
