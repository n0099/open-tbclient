package com.baidu.tieba.mention;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class a implements p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtMeFragment f1852a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtMeFragment atMeFragment) {
        this.f1852a = atMeFragment;
    }

    @Override // com.baidu.tieba.mention.p
    public void a(String str) {
        DatabaseService.k(str);
    }

    @Override // com.baidu.tieba.mention.p
    public String a() {
        return DatabaseService.j();
    }

    @Override // com.baidu.tieba.mention.p
    public void b() {
        DatabaseService.i();
    }
}
