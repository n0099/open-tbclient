package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface im0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends hm0> void a(@Nullable T t);

    <T extends hm0> void b(@NonNull Object obj, @NonNull km0<T> km0Var);

    <T extends hm0> void c(@NonNull Object obj, int i, @NonNull km0<T> km0Var);

    void unregister(@NonNull Object obj);
}
