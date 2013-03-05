package com.baidu.tieba.service;

import android.os.AsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.ae;
import com.baidu.tieba.c.ag;
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
    public ae doInBackground(String... strArr) {
        ae aeVar;
        Exception e;
        try {
        } catch (Exception e2) {
            aeVar = null;
            e = e2;
        }
        if (TiebaApplication.b().U()) {
            this.a = new t("http://c.tieba.baidu.com/c/s/msg");
            String i = this.a.i();
            if (this.a.b()) {
                aeVar = new ae();
                try {
                    aeVar.a(i);
                } catch (Exception e3) {
                    e = e3;
                    ag.b(getClass().getName(), "doInBackground", e.getMessage());
                    return aeVar;
                }
            } else {
                aeVar = null;
            }
            return aeVar;
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
    public void onPostExecute(ae aeVar) {
        try {
            super.onPostExecute(aeVar);
            this.b.a = null;
            if (aeVar != null) {
                this.b.b = aeVar;
                this.b.b();
            }
        } catch (Exception e) {
            ag.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }
}
