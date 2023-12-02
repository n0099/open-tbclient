package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.y29;
/* loaded from: classes8.dex */
public interface w29 {
    void a(@NonNull u29 u29Var);

    void c(@NonNull BaseItem<? extends TbBaseMsg> baseItem, @NonNull ChatRoomDetail chatRoomDetail);

    void d(@Nullable FastRequest.b<y29.e> bVar);

    void e();

    void g(@NonNull kq8 kq8Var);

    void onDestroy();
}
