package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
/* loaded from: classes8.dex */
public interface ul8 {
    void b(@NonNull sl8 sl8Var);

    void e(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail);

    void f(@NonNull fn8 fn8Var);

    void g();

    void onDestroy();
}
