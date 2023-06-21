package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes7.dex */
public interface sn0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends rn0> void a(@Nullable T t);

    <T extends rn0> void b(@NonNull Object obj, @NonNull un0<T> un0Var);

    <T extends rn0> void c(@NonNull Object obj, int i, @NonNull un0<T> un0Var);

    void unregister(@NonNull Object obj);
}
