package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
/* loaded from: classes8.dex */
public interface wm8 {
    void a(@NonNull um8 um8Var);

    void d(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail);

    void e(@NonNull io8 io8Var);

    void f();

    void onDestroy();
}
