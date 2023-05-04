package com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.s58;
/* loaded from: classes4.dex */
public interface ResponsesPanelController extends LifecycleObserver {
    void a();

    void d(@NonNull s58 s58Var);

    void f(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail);

    void j();

    void k();
}
