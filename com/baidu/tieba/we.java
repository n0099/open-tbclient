package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes8.dex */
public interface we {
    @NonNull
    public static final ServiceReference a = new ServiceReference("UniKVTest", "UniKVTest");

    boolean isTypeDoubleKv();

    boolean isTypeDoubleSp();

    boolean isTypeSp();
}
