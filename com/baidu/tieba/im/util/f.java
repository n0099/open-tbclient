package com.baidu.tieba.im.util;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
final class f implements com.baidu.tieba.im.a<Void> {
    private final /* synthetic */ ImMessageCenterPojo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ImMessageCenterPojo imMessageCenterPojo) {
        this.a = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r3) {
        com.baidu.tieba.im.db.l.a().b(this.a);
    }
}
