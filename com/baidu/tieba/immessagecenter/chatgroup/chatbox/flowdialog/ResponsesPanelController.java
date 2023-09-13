package com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.io8;
import com.baidu.tieba.um8;
/* loaded from: classes6.dex */
public interface ResponsesPanelController extends LifecycleObserver {
    void a(@NonNull um8 um8Var);

    void d(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail);

    void e(@NonNull io8 io8Var);

    void f();

    void i();

    void onChangeSkinType();
}
