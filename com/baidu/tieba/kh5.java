package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes5.dex */
public interface kh5 {
    BroadcastReceiver a(@NonNull Context context, @NonNull mh5 mh5Var);

    void b(@NonNull Context context, long j, long j2, int i, long j3, lh5 lh5Var);

    void c(@NonNull Context context, @NonNull BroadcastReceiver broadcastReceiver);

    void d(@NonNull Context context, @NonNull ChatMsg chatMsg, long j, @NonNull nh5 nh5Var);
}
