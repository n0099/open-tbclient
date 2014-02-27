package com.baidu.tieba.im.util;
/* loaded from: classes.dex */
final class h extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ String a;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str, String str2) {
        this.a = str;
        this.c = str2;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* bridge */ /* synthetic */ Void a() {
        com.baidu.tieba.im.db.k.a();
        com.baidu.tieba.im.db.k.a(this.a, this.c);
        return null;
    }
}
