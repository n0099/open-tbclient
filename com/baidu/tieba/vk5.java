package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes8.dex */
public interface vk5 {
    BroadcastReceiver a(@NonNull Context context, @NonNull xk5 xk5Var);

    void b(@NonNull Context context, long j, long j2, int i, long j3, wk5 wk5Var);

    void c(@NonNull Context context, @NonNull BroadcastReceiver broadcastReceiver);

    void d(@NonNull Context context, @NonNull ChatMsg chatMsg, long j, @NonNull yk5 yk5Var);
}
