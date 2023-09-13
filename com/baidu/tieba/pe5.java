package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
/* loaded from: classes7.dex */
public interface pe5 {
    public static final ServiceReference a = new ServiceReference("IM", "IMessageCenterService");

    NewsRemindMessage a();

    void b(boolean z);

    sac<Boolean> c();

    boolean d();

    void e();

    boolean f();

    sac<NewsRemindMessage> g();
}
