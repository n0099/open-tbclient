package com.baidu.tieba.im.util;
/* loaded from: classes.dex */
class j extends com.baidu.tieba.im.c<Void> {
    private final /* synthetic */ String a;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str, String str2) {
        this.a = str;
        this.c = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Void b() {
        com.baidu.tieba.im.db.k.a().b(this.a, this.c);
        return null;
    }
}
