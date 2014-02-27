package com.baidu.tieba.im.util;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
final class e extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ ImMessageCenterPojo a;
    private final /* synthetic */ LinkedHashMap c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ImMessageCenterPojo imMessageCenterPojo, LinkedHashMap linkedHashMap) {
        this.a = imMessageCenterPojo;
        this.c = linkedHashMap;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* bridge */ /* synthetic */ Void a() {
        com.baidu.tieba.im.db.k.a().a(this.a);
        return com.baidu.tieba.im.db.b.a().a(this.c);
    }
}
