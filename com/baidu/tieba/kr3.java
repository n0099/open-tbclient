package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class kr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static gr3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            gr3 gr3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                gr3Var = new gr3();
                wrap.get();
                wrap.get();
                gr3Var.r(wrap.get());
                gr3Var.p(wrap.get());
                int i = wrap.getShort();
                gr3Var.q(i);
                int i2 = wrap.getInt();
                gr3Var.k(i2);
                gr3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                gr3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    gr3Var.j(bArr3);
                }
            }
            return gr3Var;
        }
        return (gr3) invokeL.objValue;
    }

    public static byte[] b(gr3 gr3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gr3Var)) == null) {
            if (gr3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(gr3Var.h() + 20 + gr3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (gr3Var.e() != null && gr3Var.e().length == 2) {
                allocate.put(gr3Var.e()[0]);
                allocate.put(gr3Var.e()[1]);
                allocate.put(gr3Var.i());
                allocate.put(gr3Var.g());
                if (gr3Var.f() != null && gr3Var.f().length != 0) {
                    int length = gr3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (gr3Var.a() != null && gr3Var.a().length != 0) {
                        allocate.putInt(gr3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(gr3Var.c());
                    if (gr3Var.f() != null) {
                        allocate.put(gr3Var.f());
                    }
                    if (gr3Var.a() != null) {
                        allocate.put(gr3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
