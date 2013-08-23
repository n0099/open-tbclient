package com.baidu.tieba.mention;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ab implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReplyMeActivity f1324a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(ReplyMeActivity replyMeActivity) {
        this.f1324a = replyMeActivity;
    }

    @Override // com.baidu.tieba.mention.n
    public void a(String str) {
        DatabaseService.j(str);
    }

    @Override // com.baidu.tieba.mention.n
    public String a() {
        return DatabaseService.h();
    }

    @Override // com.baidu.tieba.mention.n
    public void b() {
        DatabaseService.g();
    }
}
