package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes6.dex */
public interface lo5 {
    BroadcastReceiver a(@NonNull Context context, @NonNull no5 no5Var);

    void b(@NonNull Context context, long j, long j2, int i, long j3, mo5 mo5Var);

    void c(@NonNull Context context, @NonNull BroadcastReceiver broadcastReceiver);

    void d(@NonNull Context context, @NonNull ChatMsg chatMsg, long j, @NonNull oo5 oo5Var);
}
