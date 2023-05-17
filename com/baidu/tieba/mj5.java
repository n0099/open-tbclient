package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes6.dex */
public interface mj5 {
    BroadcastReceiver a(@NonNull Context context, @NonNull oj5 oj5Var);

    void b(@NonNull Context context, long j, long j2, int i, long j3, nj5 nj5Var);

    void c(@NonNull Context context, @NonNull BroadcastReceiver broadcastReceiver);

    void d(@NonNull Context context, @NonNull ChatMsg chatMsg, long j, @NonNull pj5 pj5Var);
}
