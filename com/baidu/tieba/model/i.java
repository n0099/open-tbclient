package com.baidu.tieba.model;

import com.baidu.tieba.data.chat.RecentChatFriendData;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.a<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f2036a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f2036a = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r6) {
        List list;
        RecentChatFriendData recentChatFriendData;
        List list2;
        list = this.f2036a.c.b;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                recentChatFriendData = null;
                break;
            }
            recentChatFriendData = (RecentChatFriendData) it.next();
            if (this.f2036a.f2034a.equals(recentChatFriendData.getFriendId())) {
                break;
            }
        }
        if (recentChatFriendData != null) {
            list2 = this.f2036a.c.b;
            list2.remove(recentChatFriendData);
        }
        com.baidu.tieba.im.pushNotify.a.h().b(this.f2036a.f2034a);
        com.baidu.tieba.im.pushNotify.a.h().b(false, this.f2036a.b);
    }
}
