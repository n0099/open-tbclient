package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes7.dex */
public interface pl5 {
    @NonNull
    public static final ServiceReference a;
    @NonNull
    public static final pl5 b;

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
        b = (pl5) ServiceManager.getService(serviceReference);
    }
}
