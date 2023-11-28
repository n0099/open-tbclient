package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes8.dex */
public interface vi0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    void a(@NonNull Object obj);

    <T extends ui0> void b(@Nullable T t);

    <T extends ui0> void c(@NonNull Object obj, @NonNull xi0<T> xi0Var);

    <T extends ui0> void d(@NonNull Object obj, int i, @NonNull xi0<T> xi0Var);
}
