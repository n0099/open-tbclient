package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import java.util.TreeSet;
/* loaded from: classes8.dex */
public interface zn5 {
    @WorkerThread
    void a(int i, @NonNull String str, @NonNull TreeSet<ChatMsg> treeSet);
}
