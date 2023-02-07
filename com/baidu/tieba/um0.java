package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface um0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends tm0> void a(@Nullable T t);

    <T extends tm0> void b(@NonNull Object obj, @NonNull wm0<T> wm0Var);

    <T extends tm0> void c(@NonNull Object obj, int i, @NonNull wm0<T> wm0Var);

    void unregister(@NonNull Object obj);
}
