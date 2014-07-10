package com.baidu.tieba.im.stranger;

import java.util.List;
/* loaded from: classes.dex */
class t extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ o b;
    private final /* synthetic */ List c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, List list) {
        this.b = oVar;
        this.c = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.h.a().a(this.c, true);
        return null;
    }
}
