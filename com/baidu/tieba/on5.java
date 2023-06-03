package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes7.dex */
public interface on5 {
    BroadcastReceiver a(@NonNull Context context, @NonNull qn5 qn5Var);

    void b(@NonNull Context context, long j, long j2, int i, long j3, pn5 pn5Var);

    void c(@NonNull Context context, @NonNull BroadcastReceiver broadcastReceiver);

    void d(@NonNull Context context, @NonNull ChatMsg chatMsg, long j, @NonNull rn5 rn5Var);
}
