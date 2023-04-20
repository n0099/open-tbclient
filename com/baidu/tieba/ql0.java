package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface ql0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends pl0> void a(@Nullable T t);

    <T extends pl0> void b(@NonNull Object obj, @NonNull sl0<T> sl0Var);

    <T extends pl0> void c(@NonNull Object obj, int i, @NonNull sl0<T> sl0Var);

    void unregister(@NonNull Object obj);
}
