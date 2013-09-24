package com.baidu.tieba.mention;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class a implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtMeFragment f1356a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtMeFragment atMeFragment) {
        this.f1356a = atMeFragment;
    }

    @Override // com.baidu.tieba.mention.o
    public void a(String str) {
        DatabaseService.k(str);
    }

    @Override // com.baidu.tieba.mention.o
    public String a() {
        return DatabaseService.j();
    }

    @Override // com.baidu.tieba.mention.o
    public void b() {
        DatabaseService.i();
    }
}
