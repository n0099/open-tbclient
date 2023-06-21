package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class mv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static iv3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            iv3 iv3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                iv3Var = new iv3();
                wrap.get();
                wrap.get();
                iv3Var.r(wrap.get());
                iv3Var.p(wrap.get());
                int i = wrap.getShort();
                iv3Var.q(i);
                int i2 = wrap.getInt();
                iv3Var.k(i2);
                iv3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                iv3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    iv3Var.j(bArr3);
                }
            }
            return iv3Var;
        }
        return (iv3) invokeL.objValue;
    }

    public static byte[] b(iv3 iv3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iv3Var)) == null) {
            if (iv3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(iv3Var.h() + 20 + iv3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (iv3Var.e() != null && iv3Var.e().length == 2) {
                allocate.put(iv3Var.e()[0]);
                allocate.put(iv3Var.e()[1]);
                allocate.put(iv3Var.i());
                allocate.put(iv3Var.g());
                if (iv3Var.f() != null && iv3Var.f().length != 0) {
                    int length = iv3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (iv3Var.a() != null && iv3Var.a().length != 0) {
                        allocate.putInt(iv3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(iv3Var.c());
                    if (iv3Var.f() != null) {
                        allocate.put(iv3Var.f());
                    }
                    if (iv3Var.a() != null) {
                        allocate.put(iv3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
