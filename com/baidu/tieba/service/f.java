package com.baidu.tieba.service;

import android.os.AsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.am;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends AsyncTask {
    t a;
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
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        ag.a(getClass().getName(), "doBackGround", "pull message...");
        try {
            this.a = new t("http://c.tieba.baidu.com/c/m/getmsg");
            this.a.a("message_id", String.valueOf(TiebaApplication.b().az()));
            return this.a.i();
        } catch (Exception e) {
            ag.b(getClass().getName(), "doBackground", e.toString());
            return null;
        }
    }

    public void a() {
        this.b.a = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        am amVar;
        am amVar2;
        am amVar3;
        am amVar4;
        super.onPostExecute(str);
        if (this.a.c()) {
            ag.a(getClass().getName(), "onPostExecute", "result=" + str);
            if (this.a.b()) {
                amVar = this.b.b;
                amVar.a(str);
                amVar2 = this.b.b;
                if (amVar2.a() > TiebaApplication.b().az()) {
                    TiebaApplication b = TiebaApplication.b();
                    amVar3 = this.b.b;
                    b.h(amVar3.a());
                    MessagePullService messagePullService = this.b;
                    amVar4 = this.b.b;
                    MessagePullService.a(messagePullService, amVar4);
                }
            }
        }
        this.b.a = null;
    }
}
