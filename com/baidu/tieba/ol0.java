package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface ol0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends nl0> void a(@Nullable T t);

    <T extends nl0> void b(@NonNull Object obj, @NonNull ql0<T> ql0Var);

    <T extends nl0> void c(@NonNull Object obj, int i, @NonNull ql0<T> ql0Var);

    void unregister(@NonNull Object obj);
}
