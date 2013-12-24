package com.baidu.tieba.model;

import com.baidu.tieba.data.chat.RecentChatFriendData;
import java.util.Comparator;
/* loaded from: classes.dex */
class n implements Comparator<RecentChatFriendData> {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.a = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(RecentChatFriendData recentChatFriendData, RecentChatFriendData recentChatFriendData2) {
        if (recentChatFriendData == null || recentChatFriendData2 == null) {
            return 0;
        }
        if (recentChatFriendData.getServerTime() < recentChatFriendData2.getServerTime()) {
            return 1;
        }
        return recentChatFriendData.getServerTime() > recentChatFriendData2.getServerTime() ? -1 : 0;
    }
}
