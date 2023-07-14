package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class iv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static ev3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            ev3 ev3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                ev3Var = new ev3();
                wrap.get();
                wrap.get();
                ev3Var.r(wrap.get());
                ev3Var.p(wrap.get());
                int i = wrap.getShort();
                ev3Var.q(i);
                int i2 = wrap.getInt();
                ev3Var.k(i2);
                ev3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                ev3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    ev3Var.j(bArr3);
                }
            }
            return ev3Var;
        }
        return (ev3) invokeL.objValue;
    }

    public static byte[] b(ev3 ev3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ev3Var)) == null) {
            if (ev3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(ev3Var.h() + 20 + ev3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (ev3Var.e() != null && ev3Var.e().length == 2) {
                allocate.put(ev3Var.e()[0]);
                allocate.put(ev3Var.e()[1]);
                allocate.put(ev3Var.i());
                allocate.put(ev3Var.g());
                if (ev3Var.f() != null && ev3Var.f().length != 0) {
                    int length = ev3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (ev3Var.a() != null && ev3Var.a().length != 0) {
                        allocate.putInt(ev3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(ev3Var.c());
                    if (ev3Var.f() != null) {
                        allocate.put(ev3Var.f());
                    }
                    if (ev3Var.a() != null) {
                        allocate.put(ev3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
