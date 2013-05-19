package com.baidu.tieba.service;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.as;
import com.baidu.tieba.d.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.a.a {
    com.baidu.tieba.d.t a;
    final /* synthetic */ MessagePullService b;

    private f(MessagePullService messagePullService) {
        this.b = messagePullService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(MessagePullService messagePullService, f fVar) {
        this(messagePullService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(String... strArr) {
        ae.a(getClass().getName(), "doBackGround", "pull message...");
        try {
            this.a = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/m/getmsg");
            this.a.a("message_id", String.valueOf(TiebaApplication.d().aE()));
            return this.a.i();
        } catch (Exception e) {
            ae.b(getClass().getName(), "doBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        this.b.a = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        as asVar;
        as asVar2;
        as asVar3;
        as asVar4;
        super.a((Object) str);
        if (this.a.c()) {
            ae.a(getClass().getName(), "onPostExecute", "result=" + str);
            if (this.a.b()) {
                asVar = this.b.b;
                asVar.a(str);
                asVar2 = this.b.b;
                if (asVar2.a() > TiebaApplication.d().aE()) {
                    TiebaApplication d = TiebaApplication.d();
                    asVar3 = this.b.b;
                    d.g(asVar3.a());
                    MessagePullService messagePullService = this.b;
                    asVar4 = this.b.b;
                    MessagePullService.a(messagePullService, asVar4);
                }
            }
        }
        this.b.a = null;
    }
}
