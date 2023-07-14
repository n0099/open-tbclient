package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
/* loaded from: classes6.dex */
public interface lf5 {
    public static final ServiceReference a = new ServiceReference("IM", "IMessageCenterService");

    void a(boolean z);

    u1c<Boolean> b();

    boolean c();

    void d();

    boolean e();

    u1c<NewsRemindMessage> f();
}
