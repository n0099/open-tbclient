package com.baidu.tieba.im.util;
/* loaded from: classes.dex */
final class j extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ String a;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str, String str2) {
        this.a = str;
        this.c = str2;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Void a() {
        com.baidu.tieba.im.db.k.a();
        com.baidu.tieba.im.db.k.b(this.a, this.c);
        return null;
    }
}
