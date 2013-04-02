package com.baidu.tieba.service;

import android.os.AsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.ag;
import com.baidu.tieba.c.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends AsyncTask {
    t a = null;
    final /* synthetic */ TiebaMessageService b;

    public k(TiebaMessageService tiebaMessageService) {
        this.b = tiebaMessageService;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public ag doInBackground(String... strArr) {
        ag agVar;
        Exception e;
        try {
        } catch (Exception e2) {
            agVar = null;
            e = e2;
        }
        if (TiebaApplication.b().V()) {
            this.a = new t("http://c.tieba.baidu.com/c/s/msg");
            String i = this.a.i();
            if (this.a.b()) {
                agVar = new ag();
                try {
                    agVar.a(i);
                } catch (Exception e3) {
                    e = e3;
                    com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
                    return agVar;
                }
            } else {
                agVar = null;
            }
            return agVar;
        }
        return null;
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
    public void onPostExecute(ag agVar) {
        try {
            super.onPostExecute(agVar);
            this.b.a = null;
            if (agVar != null) {
                this.b.b = agVar;
                this.b.b();
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }
}
