package com.baidu.tieba.mention;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class b implements s {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.mention.s
    public void a(String str) {
        DatabaseService.g(str);
    }

    @Override // com.baidu.tieba.mention.s
    public String a() {
        return DatabaseService.h();
    }

    @Override // com.baidu.tieba.mention.s
    public void b() {
        DatabaseService.g();
    }
}
