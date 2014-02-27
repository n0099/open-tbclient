package com.baidu.tieba.mention;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
final class b implements s {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.mention.s
    public final void a(String str) {
        DatabaseService.f(str);
    }

    @Override // com.baidu.tieba.mention.s
    public final String a() {
        return DatabaseService.h();
    }

    @Override // com.baidu.tieba.mention.s
    public final void b() {
        DatabaseService.g();
    }
}
