package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface vf {
    @NonNull
    public static final ServiceReference a = new ServiceReference("tbadkcore", "IHttpsExperiment");

    boolean isIpv6();

    boolean isSwitchOn();
}
