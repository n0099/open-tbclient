package com.baidu.tieba;

import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes7.dex */
public interface nbb {
    public static final ServiceReference a = new ServiceReference("voyager", HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM);

    void a();

    void b();
}
