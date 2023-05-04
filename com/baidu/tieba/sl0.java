package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface sl0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends rl0> void a(@Nullable T t);

    <T extends rl0> void b(@NonNull Object obj, @NonNull ul0<T> ul0Var);

    <T extends rl0> void c(@NonNull Object obj, int i, @NonNull ul0<T> ul0Var);

    void unregister(@NonNull Object obj);
}
