package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes7.dex */
public interface s9 {
    @NonNull
    public static final ServiceReference a;
    @Nullable
    public static final s9 b;

    void a(int i, @NonNull String str, @Nullable Object obj);

    static {
        ServiceReference serviceReference = new ServiceReference("DebugProcessor", "DebugService4Adp");
        a = serviceReference;
        b = (s9) ServiceManager.getService(serviceReference);
    }
}
