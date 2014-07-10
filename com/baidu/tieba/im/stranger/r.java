package com.baidu.tieba.im.stranger;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ o a;
    private final /* synthetic */ com.baidu.tieba.im.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, com.baidu.tieba.im.a aVar) {
        this.a = oVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList<ImMessageCenterShowItemData> q = com.baidu.tieba.im.pushNotify.a.i().q();
        if (q != null) {
            linkedList = this.a.a;
            linkedList.clear();
            linkedList2 = this.a.a;
            linkedList2.addAll(q);
            this.a.c();
            if (this.b != null) {
                this.b.a(null);
            }
        }
    }
}
