package com.baidu.tieba.model;
/* loaded from: classes.dex */
class ah extends com.baidu.tieba.im.c<Void> {
    final /* synthetic */ ag a;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, boolean z, String str) {
        this.a = agVar;
        this.c = z;
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Void b() {
        String str;
        if (this.c) {
            str = com.baidu.tieba.im.db.k.b(this.d);
        } else {
            str = this.d;
        }
        com.baidu.tieba.im.db.k.a().a(str, true);
        return null;
    }
}
