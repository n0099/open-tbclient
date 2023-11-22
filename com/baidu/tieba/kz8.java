package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.mz8;
/* loaded from: classes7.dex */
public interface kz8 {
    void a(@NonNull iz8 iz8Var);

    void c(@NonNull BaseItem<? extends TbBaseMsg> baseItem, @NonNull ChatRoomDetail chatRoomDetail);

    void d(@Nullable FastRequest.b<mz8.e> bVar);

    void e();

    void f(@NonNull dn8 dn8Var);

    void onDestroy();
}
