package com.baidu.tieba.model;

import com.baidu.tieba.data.chat.RecentChatFriendData;
import java.util.Comparator;
/* loaded from: classes.dex */
class k implements Comparator<RecentChatFriendData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f2037a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.f2037a = fVar;
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
