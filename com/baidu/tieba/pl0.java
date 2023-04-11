package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface pl0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends ol0> void a(@Nullable T t);

    <T extends ol0> void b(@NonNull Object obj, @NonNull rl0<T> rl0Var);

    <T extends ol0> void c(@NonNull Object obj, int i, @NonNull rl0<T> rl0Var);

    void unregister(@NonNull Object obj);
}
