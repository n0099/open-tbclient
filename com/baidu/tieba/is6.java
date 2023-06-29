package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface is6 {
    public static final ServiceReference a = new ServiceReference("tieba.core", "eventbus");

    /* loaded from: classes6.dex */
    public interface a {
        public static final ServiceReference a = new ServiceReference("tieba.core", "eventbus.autorelease");

        void a(@NonNull BdUniqueId bdUniqueId);
    }

    <T extends hs6> void a(@NonNull Object obj, @NonNull js6<T> js6Var);

    <T extends hs6> void b(@Nullable T t);

    void unregister(@NonNull Object obj);
}
