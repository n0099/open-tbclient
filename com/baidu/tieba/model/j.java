package com.baidu.tieba.model;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;
    final /* synthetic */ com.baidu.tieba.im.a c;
    final /* synthetic */ i d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str, boolean z, com.baidu.tieba.im.a aVar) {
        this.d = iVar;
        this.a = str;
        this.b = z;
        this.c = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(this.a);
        if (imMessageCenterPojo != null) {
            imMessageCenterPojo.setIs_hidden(1);
        }
        com.baidu.tieba.im.m.a(new k(this), new l(this));
    }
}
