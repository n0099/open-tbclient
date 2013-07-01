package com.baidu.tieba.mention;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class aa implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReplyMeActivity f979a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ReplyMeActivity replyMeActivity) {
        this.f979a = replyMeActivity;
    }

    @Override // com.baidu.tieba.mention.n
    public void a(String str) {
        DatabaseService.l(str);
    }

    @Override // com.baidu.tieba.mention.n
    public String a() {
        return DatabaseService.j();
    }

    @Override // com.baidu.tieba.mention.n
    public void b() {
        DatabaseService.i();
    }
}
