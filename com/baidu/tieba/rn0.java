package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes7.dex */
public interface rn0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends qn0> void a(@Nullable T t);

    <T extends qn0> void b(@NonNull Object obj, @NonNull tn0<T> tn0Var);

    <T extends qn0> void c(@NonNull Object obj, int i, @NonNull tn0<T> tn0Var);

    void unregister(@NonNull Object obj);
}
