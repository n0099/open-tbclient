package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class sn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static on3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            on3 on3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                on3Var = new on3();
                wrap.get();
                wrap.get();
                on3Var.r(wrap.get());
                on3Var.p(wrap.get());
                int i = wrap.getShort();
                on3Var.q(i);
                int i2 = wrap.getInt();
                on3Var.k(i2);
                on3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                on3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    on3Var.j(bArr3);
                }
            }
            return on3Var;
        }
        return (on3) invokeL.objValue;
    }

    public static byte[] b(on3 on3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, on3Var)) == null) {
            if (on3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(on3Var.h() + 20 + on3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (on3Var.e() != null && on3Var.e().length == 2) {
                allocate.put(on3Var.e()[0]);
                allocate.put(on3Var.e()[1]);
                allocate.put(on3Var.i());
                allocate.put(on3Var.g());
                if (on3Var.f() != null && on3Var.f().length != 0) {
                    int length = on3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (on3Var.a() != null && on3Var.a().length != 0) {
                        allocate.putInt(on3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(on3Var.c());
                    if (on3Var.f() != null) {
                        allocate.put(on3Var.f());
                    }
                    if (on3Var.a() != null) {
                        allocate.put(on3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
