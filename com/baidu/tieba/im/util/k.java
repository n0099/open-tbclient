package com.baidu.tieba.im.util;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
final class k implements com.baidu.tieba.im.a<Void> {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r3) {
        ImMessageCenterPojo a = com.baidu.tieba.im.db.h.a().d().a(this.a);
        if (a != null) {
            a.setGroup_head(this.b);
        }
    }
}
