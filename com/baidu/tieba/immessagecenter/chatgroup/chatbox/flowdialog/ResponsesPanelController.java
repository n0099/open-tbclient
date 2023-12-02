package com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.kq8;
import com.baidu.tieba.u29;
/* loaded from: classes6.dex */
public interface ResponsesPanelController extends LifecycleObserver {
    void a(@NonNull u29 u29Var);

    void c(@NonNull BaseItem<? extends TbBaseMsg> baseItem, @NonNull ChatRoomDetail chatRoomDetail);

    void e();

    void g(@NonNull kq8 kq8Var);

    void h();

    void onChangeSkinType();
}
