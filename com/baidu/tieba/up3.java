package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class up3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static qp3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            qp3 qp3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                qp3Var = new qp3();
                wrap.get();
                wrap.get();
                qp3Var.r(wrap.get());
                qp3Var.p(wrap.get());
                int i = wrap.getShort();
                qp3Var.q(i);
                int i2 = wrap.getInt();
                qp3Var.k(i2);
                qp3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                qp3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    qp3Var.j(bArr3);
                }
            }
            return qp3Var;
        }
        return (qp3) invokeL.objValue;
    }

    public static byte[] b(qp3 qp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qp3Var)) == null) {
            if (qp3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(qp3Var.h() + 20 + qp3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (qp3Var.e() != null && qp3Var.e().length == 2) {
                allocate.put(qp3Var.e()[0]);
                allocate.put(qp3Var.e()[1]);
                allocate.put(qp3Var.i());
                allocate.put(qp3Var.g());
                if (qp3Var.f() != null && qp3Var.f().length != 0) {
                    int length = qp3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (qp3Var.a() != null && qp3Var.a().length != 0) {
                        allocate.putInt(qp3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(qp3Var.c());
                    if (qp3Var.f() != null) {
                        allocate.put(qp3Var.f());
                    }
                    if (qp3Var.a() != null) {
                        allocate.put(qp3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
