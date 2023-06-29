package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
/* loaded from: classes7.dex */
public interface oe5 {
    public static final ServiceReference a = new ServiceReference("IM", "IMessageCenterService");

    void a(boolean z);

    xsb<Boolean> b();

    boolean c();

    void d();

    boolean e();

    xsb<NewsRemindMessage> f();
}
