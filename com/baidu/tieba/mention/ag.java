package com.baidu.tieba.mention;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ag implements s {
    final /* synthetic */ af a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.a = afVar;
    }

    @Override // com.baidu.tieba.mention.s
    public void a(String str) {
        DatabaseService.f(str);
    }

    @Override // com.baidu.tieba.mention.s
    public String a() {
        return DatabaseService.f();
    }

    @Override // com.baidu.tieba.mention.s
    public void b() {
        DatabaseService.e();
    }
}
