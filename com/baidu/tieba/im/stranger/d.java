package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class d extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.h.a().a(this.b, true);
        return null;
    }
}
