package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class lv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static hv3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            hv3 hv3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                hv3Var = new hv3();
                wrap.get();
                wrap.get();
                hv3Var.r(wrap.get());
                hv3Var.p(wrap.get());
                int i = wrap.getShort();
                hv3Var.q(i);
                int i2 = wrap.getInt();
                hv3Var.k(i2);
                hv3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                hv3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    hv3Var.j(bArr3);
                }
            }
            return hv3Var;
        }
        return (hv3) invokeL.objValue;
    }

    public static byte[] b(hv3 hv3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hv3Var)) == null) {
            if (hv3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(hv3Var.h() + 20 + hv3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (hv3Var.e() != null && hv3Var.e().length == 2) {
                allocate.put(hv3Var.e()[0]);
                allocate.put(hv3Var.e()[1]);
                allocate.put(hv3Var.i());
                allocate.put(hv3Var.g());
                if (hv3Var.f() != null && hv3Var.f().length != 0) {
                    int length = hv3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (hv3Var.a() != null && hv3Var.a().length != 0) {
                        allocate.putInt(hv3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(hv3Var.c());
                    if (hv3Var.f() != null) {
                        allocate.put(hv3Var.f());
                    }
                    if (hv3Var.a() != null) {
                        allocate.put(hv3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
