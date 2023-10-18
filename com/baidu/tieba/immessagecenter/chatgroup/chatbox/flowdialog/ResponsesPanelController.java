package com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import com.baidu.tieba.ea8;
import com.baidu.tieba.em8;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
/* loaded from: classes6.dex */
public interface ResponsesPanelController extends LifecycleObserver {
    void a(@NonNull em8 em8Var);

    void d();

    void e(@NonNull BaseItem<? extends TbBaseMsg> baseItem, @NonNull ChatRoomDetail chatRoomDetail);

    void f(@NonNull ea8 ea8Var);

    void h();

    void onChangeSkinType();
}
