package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes8.dex */
public interface ui0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    void a(@NonNull Object obj);

    <T extends ti0> void b(@Nullable T t);

    <T extends ti0> void c(@NonNull Object obj, @NonNull wi0<T> wi0Var);

    <T extends ti0> void d(@NonNull Object obj, int i, @NonNull wi0<T> wi0Var);
}
