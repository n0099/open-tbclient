package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class lm3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static hm3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            hm3 hm3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                hm3Var = new hm3();
                wrap.get();
                wrap.get();
                hm3Var.r(wrap.get());
                hm3Var.p(wrap.get());
                int i = wrap.getShort();
                hm3Var.q(i);
                int i2 = wrap.getInt();
                hm3Var.k(i2);
                hm3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                hm3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    hm3Var.j(bArr3);
                }
            }
            return hm3Var;
        }
        return (hm3) invokeL.objValue;
    }

    public static byte[] b(hm3 hm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hm3Var)) == null) {
            if (hm3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(hm3Var.h() + 20 + hm3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (hm3Var.e() != null && hm3Var.e().length == 2) {
                allocate.put(hm3Var.e()[0]);
                allocate.put(hm3Var.e()[1]);
                allocate.put(hm3Var.i());
                allocate.put(hm3Var.g());
                if (hm3Var.f() != null && hm3Var.f().length != 0) {
                    int length = hm3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (hm3Var.a() != null && hm3Var.a().length != 0) {
                        allocate.putInt(hm3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(hm3Var.c());
                    if (hm3Var.f() != null) {
                        allocate.put(hm3Var.f());
                    }
                    if (hm3Var.a() != null) {
                        allocate.put(hm3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
