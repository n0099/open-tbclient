package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes7.dex */
public interface ym0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends xm0> void a(@Nullable T t);

    <T extends xm0> void b(@NonNull Object obj, @NonNull an0<T> an0Var);

    <T extends xm0> void c(@NonNull Object obj, int i, @NonNull an0<T> an0Var);

    void unregister(@NonNull Object obj);
}
