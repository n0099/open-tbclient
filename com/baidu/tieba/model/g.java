package com.baidu.tieba.model;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1938a;
    final /* synthetic */ com.baidu.tieba.im.a b;
    final /* synthetic */ f c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, String str, com.baidu.tieba.im.a aVar) {
        this.c = fVar;
        this.f1938a = str;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(this.f1938a);
        if (imMessageCenterPojo != null) {
            imMessageCenterPojo.setIs_hidden(1);
        }
        com.baidu.tieba.im.m.a(new h(this), new i(this));
    }
}
