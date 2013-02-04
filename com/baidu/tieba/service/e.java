package com.baidu.tieba.service;

import android.os.AsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.an;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends AsyncTask {
    t a;
    final /* synthetic */ MessagePullService b;

    private e(MessagePullService messagePullService) {
        this.b = messagePullService;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(MessagePullService messagePullService, e eVar) {
        this(messagePullService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        ae.a(getClass().getName(), "doBackGround", "pull message...");
        try {
            this.a = new t("http://c.tieba.baidu.com/c/m/getmsg");
            this.a.a("message_id", String.valueOf(TiebaApplication.a().av()));
            return this.a.i();
        } catch (Exception e) {
            ae.b(getClass().getName(), "doBackground", e.toString());
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
        an anVar;
        an anVar2;
        an anVar3;
        an anVar4;
        super.onPostExecute(str);
        if (this.a.c()) {
            ae.a(getClass().getName(), "onPostExecute", "result=" + str);
            if (this.a.b()) {
                anVar = this.b.b;
                anVar.a(str);
                anVar2 = this.b.b;
                if (anVar2.a() > TiebaApplication.a().av()) {
                    TiebaApplication a = TiebaApplication.a();
                    anVar3 = this.b.b;
                    a.g(anVar3.a());
                    MessagePullService messagePullService = this.b;
                    anVar4 = this.b.b;
                    MessagePullService.a(messagePullService, anVar4);
                }
            }
        }
        this.b.a = null;
    }
}
