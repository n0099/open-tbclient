package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo;
import java.util.TreeSet;
/* loaded from: classes8.dex */
public interface tm8 {
    void a(BdTypeRecyclerView bdTypeRecyclerView);

    void b(BdTypeRecyclerView bdTypeRecyclerView, GroupChatRepo groupChatRepo, GroupChatRepo.v<TreeSet<ChatMsg>> vVar);
}
