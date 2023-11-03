package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
/* loaded from: classes8.dex */
public interface v95 {
    public static final ServiceReference a = new ServiceReference("IM", "IMessageCenterService");

    NewsRemindMessage a();

    void b(boolean z);

    ijc<Boolean> c();

    boolean d();

    void e();

    boolean f();

    ijc<NewsRemindMessage> g();
}
