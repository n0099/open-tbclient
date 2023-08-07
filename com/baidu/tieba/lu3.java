package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class lu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static hu3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            hu3 hu3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                hu3Var = new hu3();
                wrap.get();
                wrap.get();
                hu3Var.r(wrap.get());
                hu3Var.p(wrap.get());
                int i = wrap.getShort();
                hu3Var.q(i);
                int i2 = wrap.getInt();
                hu3Var.k(i2);
                hu3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                hu3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    hu3Var.j(bArr3);
                }
            }
            return hu3Var;
        }
        return (hu3) invokeL.objValue;
    }

    public static byte[] b(hu3 hu3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hu3Var)) == null) {
            if (hu3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(hu3Var.h() + 20 + hu3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (hu3Var.e() != null && hu3Var.e().length == 2) {
                allocate.put(hu3Var.e()[0]);
                allocate.put(hu3Var.e()[1]);
                allocate.put(hu3Var.i());
                allocate.put(hu3Var.g());
                if (hu3Var.f() != null && hu3Var.f().length != 0) {
                    int length = hu3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (hu3Var.a() != null && hu3Var.a().length != 0) {
                        allocate.putInt(hu3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(hu3Var.c());
                    if (hu3Var.f() != null) {
                        allocate.put(hu3Var.f());
                    }
                    if (hu3Var.a() != null) {
                        allocate.put(hu3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
