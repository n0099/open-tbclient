package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class js3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static fs3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            fs3 fs3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                fs3Var = new fs3();
                wrap.get();
                wrap.get();
                fs3Var.r(wrap.get());
                fs3Var.p(wrap.get());
                int i = wrap.getShort();
                fs3Var.q(i);
                int i2 = wrap.getInt();
                fs3Var.k(i2);
                fs3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                fs3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    fs3Var.j(bArr3);
                }
            }
            return fs3Var;
        }
        return (fs3) invokeL.objValue;
    }

    public static byte[] b(fs3 fs3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fs3Var)) == null) {
            if (fs3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(fs3Var.h() + 20 + fs3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (fs3Var.e() != null && fs3Var.e().length == 2) {
                allocate.put(fs3Var.e()[0]);
                allocate.put(fs3Var.e()[1]);
                allocate.put(fs3Var.i());
                allocate.put(fs3Var.g());
                if (fs3Var.f() != null && fs3Var.f().length != 0) {
                    int length = fs3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (fs3Var.a() != null && fs3Var.a().length != 0) {
                        allocate.putInt(fs3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(fs3Var.c());
                    if (fs3Var.f() != null) {
                        allocate.put(fs3Var.f());
                    }
                    if (fs3Var.a() != null) {
                        allocate.put(fs3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
