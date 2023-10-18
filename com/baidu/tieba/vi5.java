package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes8.dex */
public interface vi5 {
    BroadcastReceiver a(@NonNull Context context, @NonNull xi5 xi5Var);

    void b(@NonNull Context context, long j, long j2, int i, long j3, wi5 wi5Var);

    void c(@NonNull Context context, @NonNull BroadcastReceiver broadcastReceiver);

    void d(@NonNull Context context, @NonNull ChatMsg chatMsg, long j, @NonNull yi5 yi5Var);
}
