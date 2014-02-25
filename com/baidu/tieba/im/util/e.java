package com.baidu.tieba.im.util;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.c<Void> {
    private final /* synthetic */ ImMessageCenterPojo a;
    private final /* synthetic */ LinkedHashMap c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ImMessageCenterPojo imMessageCenterPojo, LinkedHashMap linkedHashMap) {
        this.a = imMessageCenterPojo;
        this.c = linkedHashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Void b() {
        com.baidu.tieba.im.db.k.a().a(this.a);
        return com.baidu.tieba.im.db.b.a().a(this.c);
    }
}
