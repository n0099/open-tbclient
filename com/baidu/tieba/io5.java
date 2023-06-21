package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface io5 {
    @NonNull
    public static final ServiceReference a;
    @NonNull
    public static final io5 b;

    boolean a(@NonNull String str);

    @NonNull
    String b(@NonNull String str);

    @NonNull
    String c();

    @NonNull
    String d(@NonNull String str, boolean z);

    @NonNull
    String e(@NonNull String str, @NonNull String str2);

    static {
        ServiceReference serviceReference = new ServiceReference("tbBaseEmotion", "EmotionService");
        a = serviceReference;
        b = (io5) ServiceManager.getService(serviceReference);
    }
}
