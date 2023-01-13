package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class wn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static sn3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            sn3 sn3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                sn3Var = new sn3();
                wrap.get();
                wrap.get();
                sn3Var.r(wrap.get());
                sn3Var.p(wrap.get());
                int i = wrap.getShort();
                sn3Var.q(i);
                int i2 = wrap.getInt();
                sn3Var.k(i2);
                sn3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                sn3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    sn3Var.j(bArr3);
                }
            }
            return sn3Var;
        }
        return (sn3) invokeL.objValue;
    }

    public static byte[] b(sn3 sn3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sn3Var)) == null) {
            if (sn3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(sn3Var.h() + 20 + sn3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (sn3Var.e() != null && sn3Var.e().length == 2) {
                allocate.put(sn3Var.e()[0]);
                allocate.put(sn3Var.e()[1]);
                allocate.put(sn3Var.i());
                allocate.put(sn3Var.g());
                if (sn3Var.f() != null && sn3Var.f().length != 0) {
                    int length = sn3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (sn3Var.a() != null && sn3Var.a().length != 0) {
                        allocate.putInt(sn3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(sn3Var.c());
                    if (sn3Var.f() != null) {
                        allocate.put(sn3Var.f());
                    }
                    if (sn3Var.a() != null) {
                        allocate.put(sn3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
