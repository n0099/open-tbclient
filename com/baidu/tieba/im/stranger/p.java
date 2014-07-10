package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class p extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ o b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, String str) {
        this.b = oVar;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.h.a().a(com.baidu.tieba.im.db.h.c(this.c), true);
        return null;
    }
}
