package com.baidu.tieba.mention;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class a implements p {
    final /* synthetic */ AtMeFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtMeFragment atMeFragment) {
        this.a = atMeFragment;
    }

    @Override // com.baidu.tieba.mention.p
    public void a(String str) {
        DatabaseService.j(str);
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
