package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class uu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static qu3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            qu3 qu3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                qu3Var = new qu3();
                wrap.get();
                wrap.get();
                qu3Var.r(wrap.get());
                qu3Var.p(wrap.get());
                int i = wrap.getShort();
                qu3Var.q(i);
                int i2 = wrap.getInt();
                qu3Var.k(i2);
                qu3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                qu3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    qu3Var.j(bArr3);
                }
            }
            return qu3Var;
        }
        return (qu3) invokeL.objValue;
    }

    public static byte[] b(qu3 qu3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qu3Var)) == null) {
            if (qu3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(qu3Var.h() + 20 + qu3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (qu3Var.e() != null && qu3Var.e().length == 2) {
                allocate.put(qu3Var.e()[0]);
                allocate.put(qu3Var.e()[1]);
                allocate.put(qu3Var.i());
                allocate.put(qu3Var.g());
                if (qu3Var.f() != null && qu3Var.f().length != 0) {
                    int length = qu3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (qu3Var.a() != null && qu3Var.a().length != 0) {
                        allocate.putInt(qu3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(qu3Var.c());
                    if (qu3Var.f() != null) {
                        allocate.put(qu3Var.f());
                    }
                    if (qu3Var.a() != null) {
                        allocate.put(qu3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
