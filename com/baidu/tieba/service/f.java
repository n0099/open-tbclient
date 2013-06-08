package com.baidu.tieba.service;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.ah;
import com.baidu.tieba.a.at;
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
            this.a.a("message_id", String.valueOf(TiebaApplication.d().aN()));
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
        at atVar;
        at atVar2;
        at atVar3;
        at atVar4;
        super.a((Object) str);
        if (this.a.c()) {
            ae.a(getClass().getName(), "onPostExecute", "result=" + str);
            if (this.a.b()) {
                ah ahVar = new ah();
                ahVar.a(str);
                if (!this.b.a(this.b, ahVar)) {
                    atVar = this.b.b;
                    atVar.a(str);
                    atVar2 = this.b.b;
                    if (atVar2.a() > TiebaApplication.d().aN()) {
                        TiebaApplication d = TiebaApplication.d();
                        atVar3 = this.b.b;
                        d.g(atVar3.a());
                        MessagePullService messagePullService = this.b;
                        atVar4 = this.b.b;
                        MessagePullService.a(messagePullService, atVar4);
                    }
                }
            }
        }
        this.b.a = null;
    }
}
