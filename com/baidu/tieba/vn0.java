package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes8.dex */
public interface vn0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends un0> void a(@Nullable T t);

    <T extends un0> void b(@NonNull Object obj, @NonNull xn0<T> xn0Var);

    <T extends un0> void c(@NonNull Object obj, int i, @NonNull xn0<T> xn0Var);

    void unregister(@NonNull Object obj);
}
