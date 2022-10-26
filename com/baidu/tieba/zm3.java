package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class zm3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static vm3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            vm3 vm3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                vm3Var = new vm3();
                wrap.get();
                wrap.get();
                vm3Var.r(wrap.get());
                vm3Var.p(wrap.get());
                int i = wrap.getShort();
                vm3Var.q(i);
                int i2 = wrap.getInt();
                vm3Var.k(i2);
                vm3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                vm3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    vm3Var.j(bArr3);
                }
            }
            return vm3Var;
        }
        return (vm3) invokeL.objValue;
    }

    public static byte[] b(vm3 vm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vm3Var)) == null) {
            if (vm3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(vm3Var.h() + 20 + vm3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (vm3Var.e() != null && vm3Var.e().length == 2) {
                allocate.put(vm3Var.e()[0]);
                allocate.put(vm3Var.e()[1]);
                allocate.put(vm3Var.i());
                allocate.put(vm3Var.g());
                if (vm3Var.f() != null && vm3Var.f().length != 0) {
                    int length = vm3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (vm3Var.a() != null && vm3Var.a().length != 0) {
                        allocate.putInt(vm3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(vm3Var.c());
                    if (vm3Var.f() != null) {
                        allocate.put(vm3Var.f());
                    }
                    if (vm3Var.a() != null) {
                        allocate.put(vm3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
