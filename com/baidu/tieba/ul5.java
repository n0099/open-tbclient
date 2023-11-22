package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes8.dex */
public interface ul5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "GroupChatService");

    void a(@NonNull Context context, long j, int i, String str);

    void b(@NonNull Context context, String str, long j, int i, String str2, @Nullable Bundle bundle, boolean z);

    long c();

    void d(@NonNull Context context, long j, String str, int i, String str2);

    void e(@NonNull Context context, long j, String str, int i);

    void f(@NonNull Context context, int i, long j, boolean z);
}
