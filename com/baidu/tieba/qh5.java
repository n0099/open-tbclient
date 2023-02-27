package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
/* loaded from: classes5.dex */
public interface qh5 {
    @WorkerThread
    void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo);
}
