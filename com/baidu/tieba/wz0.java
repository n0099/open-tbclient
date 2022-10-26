package com.baidu.tieba;

import com.baidu.nadcore.requester.NadRequester;
import com.baidu.nadcore.requester.RequestParameters;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface wz0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "adRequester");

    void a(RequestParameters requestParameters, NadRequester.b bVar);
}
