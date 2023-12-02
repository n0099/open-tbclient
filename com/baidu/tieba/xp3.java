package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class xp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static tp3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            tp3 tp3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                tp3Var = new tp3();
                wrap.get();
                wrap.get();
                tp3Var.r(wrap.get());
                tp3Var.p(wrap.get());
                int i = wrap.getShort();
                tp3Var.q(i);
                int i2 = wrap.getInt();
                tp3Var.k(i2);
                tp3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                tp3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    tp3Var.j(bArr3);
                }
            }
            return tp3Var;
        }
        return (tp3) invokeL.objValue;
    }

    public static byte[] b(tp3 tp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tp3Var)) == null) {
            if (tp3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(tp3Var.h() + 20 + tp3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (tp3Var.e() != null && tp3Var.e().length == 2) {
                allocate.put(tp3Var.e()[0]);
                allocate.put(tp3Var.e()[1]);
                allocate.put(tp3Var.i());
                allocate.put(tp3Var.g());
                if (tp3Var.f() != null && tp3Var.f().length != 0) {
                    int length = tp3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (tp3Var.a() != null && tp3Var.a().length != 0) {
                        allocate.putInt(tp3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(tp3Var.c());
                    if (tp3Var.f() != null) {
                        allocate.put(tp3Var.f());
                    }
                    if (tp3Var.a() != null) {
                        allocate.put(tp3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
