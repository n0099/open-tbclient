package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface of {
    @NonNull
    public static final ServiceReference a = new ServiceReference("tbadkcore", "INetExperiment");

    boolean netABTest();

    boolean netBdABTest();

    boolean qaHttpsTest();
}
