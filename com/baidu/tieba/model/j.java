package com.baidu.tieba.model;

import com.baidu.tieba.data.chat.RecentChatFriendData;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.im.a<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.im.a f2036a;
    final /* synthetic */ f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar, com.baidu.tieba.im.a aVar) {
        this.b = fVar;
        this.f2036a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        List list;
        List list2;
        LinkedList<RecentChatFriendData> k = com.baidu.tieba.im.pushNotify.a.h().k();
        if (k != null) {
            list = this.b.b;
            list.clear();
            list2 = this.b.b;
            list2.addAll(k);
            this.b.f();
            if (this.f2036a != null) {
                this.f2036a.a(null);
            }
        }
    }
}
