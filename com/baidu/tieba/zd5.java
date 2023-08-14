package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
/* loaded from: classes8.dex */
public interface zd5 {
    public static final ServiceReference a = new ServiceReference("IM", "IMessageCenterService");

    NewsRemindMessage a();

    void b(boolean z);

    y0c<Boolean> c();

    boolean d();

    void e();

    boolean f();

    y0c<NewsRemindMessage> g();
}
