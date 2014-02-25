package com.baidu.tieba.model;

import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ ag a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.tieba.im.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar, String str, com.baidu.tieba.im.a aVar) {
        this.a = agVar;
        this.b = str;
        this.c = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r6) {
        List list;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        List list2;
        list = this.a.b;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                imMessageCenterShowItemData = null;
                break;
            }
            imMessageCenterShowItemData = (ImMessageCenterShowItemData) it.next();
            if (this.b.equals(imMessageCenterShowItemData.getFriendId())) {
                break;
            }
        }
        if (imMessageCenterShowItemData != null) {
            list2 = this.a.b;
            list2.remove(imMessageCenterShowItemData);
        }
        com.baidu.tieba.im.c.a.f().b(this.b);
        com.baidu.tieba.im.c.a.f().b(false, this.c);
    }
}
