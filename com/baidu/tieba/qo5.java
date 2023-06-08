package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes7.dex */
public interface qo5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "GroupChatService");

    void a(@NonNull Context context, long j, int i, String str);

    void b(@NonNull Context context, long j);

    void c(@NonNull Context context, long j, String str);

    void d(@NonNull Context context, String str, long j, int i, String str2, @Nullable Bundle bundle, boolean z);
}
