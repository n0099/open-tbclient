package com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import com.baidu.tieba.cd8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
/* loaded from: classes6.dex */
public interface ResponsesPanelController extends LifecycleObserver {
    void a();

    void c(@NonNull cd8 cd8Var);

    void e(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail);

    void i();

    void k();
}
