package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
/* loaded from: classes6.dex */
public interface jn6 {
    public static final ServiceReference a = new ServiceReference(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior");

    void a(Throwable th);
}
