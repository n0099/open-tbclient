package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.z29;
/* loaded from: classes9.dex */
public interface x29 {
    void a(@NonNull v29 v29Var);

    void c(@NonNull BaseItem<? extends TbBaseMsg> baseItem, @NonNull ChatRoomDetail chatRoomDetail);

    void d(@Nullable FastRequest.b<z29.e> bVar);

    void e();

    void g(@NonNull lq8 lq8Var);

    void onDestroy();
}
