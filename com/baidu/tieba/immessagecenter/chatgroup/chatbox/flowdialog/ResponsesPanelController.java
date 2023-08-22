package com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import com.baidu.tieba.fn8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.sl8;
/* loaded from: classes6.dex */
public interface ResponsesPanelController extends LifecycleObserver {
    void a();

    void b(@NonNull sl8 sl8Var);

    void e(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail);

    void f(@NonNull fn8 fn8Var);

    void g();

    void l();
}
