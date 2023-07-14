package com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import com.baidu.tieba.ak8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.ml8;
/* loaded from: classes6.dex */
public interface ResponsesPanelController extends LifecycleObserver {
    void a();

    void c(@NonNull ak8 ak8Var);

    void e(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail);

    void f(@NonNull ml8 ml8Var);

    void h();

    void k();
}
