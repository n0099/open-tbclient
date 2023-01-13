package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
/* loaded from: classes6.dex */
public interface s76 {
    public static final ServiceReference a = new ServiceReference(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior");

    void a();

    void b(Throwable th);
}
