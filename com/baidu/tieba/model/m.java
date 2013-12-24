package com.baidu.tieba.model;

import com.baidu.tieba.data.chat.RecentChatFriendData;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ com.baidu.tieba.im.a a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar, com.baidu.tieba.im.a aVar) {
        this.b = iVar;
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        List list;
        List list2;
        LinkedList<RecentChatFriendData> k = com.baidu.tieba.im.c.a.h().k();
        if (k != null) {
            list = this.b.b;
            list.clear();
            list2 = this.b.b;
            list2.addAll(k);
            this.b.c();
            if (this.a != null) {
                this.a.a(null);
            }
        }
    }
}
