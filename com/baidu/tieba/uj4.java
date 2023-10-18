package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes8.dex */
public class uj4<D> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a<D> {
    }

    /* loaded from: classes8.dex */
    public interface b<D> {
    }

    public abstract String a(D d);

    public abstract void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c(int i, b<D> bVar);

    public abstract void d(a<D> aVar);

    public abstract void e();

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            throw null;
        }
    }

    public abstract void g();

    public abstract void h(b<D> bVar);

    public abstract void i(a<D> aVar);
}
