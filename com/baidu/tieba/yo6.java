package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes9.dex */
public interface yo6 {
    public static final ServiceReference a = new ServiceReference("tieba.core", "eventbus");

    /* loaded from: classes9.dex */
    public interface a {
        public static final ServiceReference a = new ServiceReference("tieba.core", "eventbus.autorelease");

        void a(@NonNull BdUniqueId bdUniqueId);
    }

    void a(@NonNull Object obj);

    <T extends xo6> void b(@NonNull Object obj, @NonNull zo6<T> zo6Var);

    <T extends xo6> void c(@Nullable T t);
}
