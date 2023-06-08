package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes7.dex */
public interface qn5 {
    BroadcastReceiver a(@NonNull Context context, @NonNull sn5 sn5Var);

    void b(@NonNull Context context, long j, long j2, int i, long j3, rn5 rn5Var);

    void c(@NonNull Context context, @NonNull BroadcastReceiver broadcastReceiver);

    void d(@NonNull Context context, @NonNull ChatMsg chatMsg, long j, @NonNull tn5 tn5Var);
}
