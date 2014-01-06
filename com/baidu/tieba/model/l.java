package com.baidu.tieba.model;

import com.baidu.tieba.data.chat.RecentChatFriendData;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.a = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r6) {
        List list;
        RecentChatFriendData recentChatFriendData;
        List list2;
        list = this.a.d.b;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                recentChatFriendData = null;
                break;
            }
            recentChatFriendData = (RecentChatFriendData) it.next();
            if (this.a.a.equals(recentChatFriendData.getFriendId())) {
                break;
            }
        }
        if (recentChatFriendData != null) {
            list2 = this.a.d.b;
            list2.remove(recentChatFriendData);
        }
        com.baidu.tieba.im.c.a.h().b(this.a.a);
        com.baidu.tieba.im.c.a.h().b(false, this.a.c);
    }
}
