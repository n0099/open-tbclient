package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes9.dex */
public interface zo5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "GroupChatService");

    void a(@NonNull Context context, long j, int i, String str);

    void b(@NonNull Context context, String str, long j, int i, String str2, @Nullable Bundle bundle, boolean z);

    void c(@NonNull Context context, long j, String str, int i, String str2);

    void d(@NonNull Context context, long j, String str, int i);

    void e(@NonNull Context context, int i, long j, boolean z);
}
