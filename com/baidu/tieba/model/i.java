package com.baidu.tieba.model;

import com.baidu.tieba.data.chat.RecentChatFriendData;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.a<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f2035a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f2035a = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r6) {
        List list;
        RecentChatFriendData recentChatFriendData;
        List list2;
        list = this.f2035a.c.b;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                recentChatFriendData = null;
                break;
            }
            recentChatFriendData = (RecentChatFriendData) it.next();
            if (this.f2035a.f2033a.equals(recentChatFriendData.getFriendId())) {
                break;
            }
        }
        if (recentChatFriendData != null) {
            list2 = this.f2035a.c.b;
            list2.remove(recentChatFriendData);
        }
        com.baidu.tieba.im.pushNotify.a.h().b(this.f2035a.f2033a);
        com.baidu.tieba.im.pushNotify.a.h().b(false, this.f2035a.b);
    }
}
