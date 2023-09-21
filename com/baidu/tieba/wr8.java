package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
/* loaded from: classes8.dex */
public interface wr8 {
    void a(@NonNull ur8 ur8Var);

    void d();

    void e(@NonNull BaseItem<? extends TbBaseMsg> baseItem, @NonNull ChatRoomDetail chatRoomDetail);

    void f(@NonNull tf8 tf8Var);

    void onDestroy();
}
