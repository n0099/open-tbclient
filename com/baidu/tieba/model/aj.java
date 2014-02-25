package com.baidu.tieba.model;

import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ ag a;
    private final /* synthetic */ com.baidu.tieba.im.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar, com.baidu.tieba.im.a aVar) {
        this.a = agVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        List list;
        List list2;
        LinkedList<ImMessageCenterShowItemData> i = com.baidu.tieba.im.c.a.f().i();
        if (i != null) {
            list = this.a.b;
            list.clear();
            list2 = this.a.b;
            list2.addAll(i);
            this.a.c();
            if (this.b != null) {
                this.b.a(null);
            }
        }
    }
}
