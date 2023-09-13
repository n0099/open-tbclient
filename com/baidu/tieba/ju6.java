package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface ju6 {
    public static final ServiceReference a = new ServiceReference("tieba.core", "eventbus");

    /* loaded from: classes6.dex */
    public interface a {
        public static final ServiceReference a = new ServiceReference("tieba.core", "eventbus.autorelease");

        void a(@NonNull BdUniqueId bdUniqueId);
    }

    <T extends iu6> void a(@NonNull Object obj, @NonNull ku6<T> ku6Var);

    <T extends iu6> void b(@Nullable T t);

    void unregister(@NonNull Object obj);
}
