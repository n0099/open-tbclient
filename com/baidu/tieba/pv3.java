package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class pv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static lv3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            lv3 lv3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                lv3Var = new lv3();
                wrap.get();
                wrap.get();
                lv3Var.r(wrap.get());
                lv3Var.p(wrap.get());
                int i = wrap.getShort();
                lv3Var.q(i);
                int i2 = wrap.getInt();
                lv3Var.k(i2);
                lv3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                lv3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    lv3Var.j(bArr3);
                }
            }
            return lv3Var;
        }
        return (lv3) invokeL.objValue;
    }

    public static byte[] b(lv3 lv3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, lv3Var)) == null) {
            if (lv3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(lv3Var.h() + 20 + lv3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (lv3Var.e() != null && lv3Var.e().length == 2) {
                allocate.put(lv3Var.e()[0]);
                allocate.put(lv3Var.e()[1]);
                allocate.put(lv3Var.i());
                allocate.put(lv3Var.g());
                if (lv3Var.f() != null && lv3Var.f().length != 0) {
                    int length = lv3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (lv3Var.a() != null && lv3Var.a().length != 0) {
                        allocate.putInt(lv3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(lv3Var.c());
                    if (lv3Var.f() != null) {
                        allocate.put(lv3Var.f());
                    }
                    if (lv3Var.a() != null) {
                        allocate.put(lv3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
