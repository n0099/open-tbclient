package com.baidu.tieba.mention;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ad implements p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReplyMeFragment f1856a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ReplyMeFragment replyMeFragment) {
        this.f1856a = replyMeFragment;
    }

    @Override // com.baidu.tieba.mention.p
    public void a(String str) {
        DatabaseService.j(str);
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
