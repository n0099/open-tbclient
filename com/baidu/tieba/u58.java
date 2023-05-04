package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
/* loaded from: classes6.dex */
public interface u58 {
    void d(@NonNull s58 s58Var);

    void f(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail);

    void j();

    void onDestroy();
}
