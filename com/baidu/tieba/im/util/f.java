package com.baidu.tieba.im.util;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.a<Void> {
    private final /* synthetic */ ImMessageCenterPojo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ImMessageCenterPojo imMessageCenterPojo) {
        this.a = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        com.baidu.tieba.im.db.l.a().b(this.a);
    }
}
