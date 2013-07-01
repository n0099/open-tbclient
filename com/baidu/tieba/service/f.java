package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.af;
import com.baidu.tieba.data.ap;
import com.baidu.tieba.util.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.r f1409a;
    final /* synthetic */ MessagePullService b;

    private f(MessagePullService messagePullService) {
        this.b = messagePullService;
        this.f1409a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(MessagePullService messagePullService, f fVar) {
        this(messagePullService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        z.a(getClass().getName(), "doBackGround", "pull message...");
        try {
            this.f1409a = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/m/getmsg");
            this.f1409a.a("message_id", String.valueOf(TiebaApplication.f().aR()));
            return this.f1409a.j();
        } catch (Exception e) {
            z.b(getClass().getName(), "doBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.f1397a = null;
        if (this.f1409a != null) {
            this.f1409a.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ap apVar;
        ap apVar2;
        ap apVar3;
        ap apVar4;
        super.a((Object) str);
        if (this.f1409a.d()) {
            z.a(getClass().getName(), "onPostExecute", "result=" + str);
            if (this.f1409a.c()) {
                af afVar = new af();
                afVar.a(str);
                if (!this.b.a(this.b, afVar)) {
                    apVar = this.b.b;
                    apVar.a(str);
                    apVar2 = this.b.b;
                    if (apVar2.a() > TiebaApplication.f().aR()) {
                        TiebaApplication f = TiebaApplication.f();
                        apVar3 = this.b.b;
                        f.g(apVar3.a());
                        MessagePullService messagePullService = this.b;
                        apVar4 = this.b.b;
                        MessagePullService.a(messagePullService, apVar4);
                    }
                }
            }
        }
        this.b.f1397a = null;
    }
}
