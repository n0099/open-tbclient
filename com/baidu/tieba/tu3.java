package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class tu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static pu3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            pu3 pu3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                pu3Var = new pu3();
                wrap.get();
                wrap.get();
                pu3Var.r(wrap.get());
                pu3Var.p(wrap.get());
                int i = wrap.getShort();
                pu3Var.q(i);
                int i2 = wrap.getInt();
                pu3Var.k(i2);
                pu3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                pu3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    pu3Var.j(bArr3);
                }
            }
            return pu3Var;
        }
        return (pu3) invokeL.objValue;
    }

    public static byte[] b(pu3 pu3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pu3Var)) == null) {
            if (pu3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(pu3Var.h() + 20 + pu3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (pu3Var.e() != null && pu3Var.e().length == 2) {
                allocate.put(pu3Var.e()[0]);
                allocate.put(pu3Var.e()[1]);
                allocate.put(pu3Var.i());
                allocate.put(pu3Var.g());
                if (pu3Var.f() != null && pu3Var.f().length != 0) {
                    int length = pu3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (pu3Var.a() != null && pu3Var.a().length != 0) {
                        allocate.putInt(pu3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(pu3Var.c());
                    if (pu3Var.f() != null) {
                        allocate.put(pu3Var.f());
                    }
                    if (pu3Var.a() != null) {
                        allocate.put(pu3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
