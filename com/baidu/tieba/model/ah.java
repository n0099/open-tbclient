package com.baidu.tieba.model;
/* loaded from: classes.dex */
final class ah extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ ag a;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, boolean z, String str) {
        this.a = agVar;
        this.c = z;
        this.d = str;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Void a() {
        String b = this.c ? com.baidu.tieba.im.db.k.b(this.d) : this.d;
        com.baidu.tieba.im.db.k.a();
        com.baidu.tieba.im.db.k.a(b, true);
        return null;
    }
}
