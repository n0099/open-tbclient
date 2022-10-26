package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface z95 {
    public static final ServiceReference a;
    public static final z95 b;

    boolean a(String str);

    String b(String str);

    String c();

    String d(String str, boolean z);

    String e(String str, String str2);

    static {
        ServiceReference serviceReference = new ServiceReference("tbBaseEmotion", "EmotionService");
        a = serviceReference;
        b = (z95) ServiceManager.getService(serviceReference);
    }
}
