package com.baidu.tieba;

import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
/* loaded from: classes9.dex */
public interface zi5 {
    @WorkerThread
    void a(long j, int i, String str, IChatRoomEnterListener.ChatRoomInfo chatRoomInfo);
}
