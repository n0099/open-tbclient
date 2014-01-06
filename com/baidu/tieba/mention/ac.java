package com.baidu.tieba.mention;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ac implements p {
    final /* synthetic */ ReplyMeFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ReplyMeFragment replyMeFragment) {
        this.a = replyMeFragment;
    }

    @Override // com.baidu.tieba.mention.p
    public void a(String str) {
        DatabaseService.i(str);
    }

    @Override // com.baidu.tieba.mention.p
    public String a() {
        return DatabaseService.h();
    }

    @Override // com.baidu.tieba.mention.p
    public void b() {
        DatabaseService.g();
    }
}
