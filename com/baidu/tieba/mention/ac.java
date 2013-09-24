package com.baidu.tieba.mention;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ac implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReplyMeFragment f1359a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ReplyMeFragment replyMeFragment) {
        this.f1359a = replyMeFragment;
    }

    @Override // com.baidu.tieba.mention.o
    public void a(String str) {
        DatabaseService.j(str);
    }

    @Override // com.baidu.tieba.mention.o
    public String a() {
        return DatabaseService.h();
    }

    @Override // com.baidu.tieba.mention.o
    public void b() {
        DatabaseService.g();
    }
}
