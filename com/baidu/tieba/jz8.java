package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.lz8;
/* loaded from: classes6.dex */
public interface jz8 {
    void a(@NonNull hz8 hz8Var);

    void c(@NonNull BaseItem<? extends TbBaseMsg> baseItem, @NonNull ChatRoomDetail chatRoomDetail);

    void d(@Nullable FastRequest.b<lz8.e> bVar);

    void e();

    void f(@NonNull cn8 cn8Var);

    void onDestroy();
}
