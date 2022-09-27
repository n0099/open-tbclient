package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class ym3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static um3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            um3 um3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                um3Var = new um3();
                wrap.get();
                wrap.get();
                um3Var.r(wrap.get());
                um3Var.p(wrap.get());
                int i = wrap.getShort();
                um3Var.q(i);
                int i2 = wrap.getInt();
                um3Var.k(i2);
                um3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                um3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    um3Var.j(bArr3);
                }
            }
            return um3Var;
        }
        return (um3) invokeL.objValue;
    }

    public static byte[] b(um3 um3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, um3Var)) == null) {
            if (um3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(um3Var.h() + 20 + um3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (um3Var.e() != null && um3Var.e().length == 2) {
                allocate.put(um3Var.e()[0]);
                allocate.put(um3Var.e()[1]);
                allocate.put(um3Var.i());
                allocate.put(um3Var.g());
                if (um3Var.f() != null && um3Var.f().length != 0) {
                    int length = um3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (um3Var.a() != null && um3Var.a().length != 0) {
                        allocate.putInt(um3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(um3Var.c());
                    if (um3Var.f() != null) {
                        allocate.put(um3Var.f());
                    }
                    if (um3Var.a() != null) {
                        allocate.put(um3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
