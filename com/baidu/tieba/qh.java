package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes7.dex */
public interface qh {
    @NonNull
    public static final ServiceReference a = new ServiceReference("tbadkcore", "IThreadExperiment");

    boolean threadABTest();
}
