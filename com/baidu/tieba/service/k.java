package com.baidu.tieba.service;

import android.os.AsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.ah;
import com.baidu.tieba.c.af;
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
    public ah doInBackground(String... strArr) {
        ah ahVar;
        Exception e;
        try {
        } catch (Exception e2) {
            ahVar = null;
            e = e2;
        }
        if (TiebaApplication.b().T()) {
            this.a = new t("http://c.tieba.baidu.com/c/s/msg");
            String i = this.a.i();
            if (this.a.b()) {
                ahVar = new ah();
                try {
                    ahVar.a(i);
                } catch (Exception e3) {
                    e = e3;
                    af.b(getClass().getName(), "doInBackground", e.getMessage());
                    return ahVar;
                }
            } else {
                ahVar = null;
            }
            return ahVar;
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
    public void onPostExecute(ah ahVar) {
        try {
            super.onPostExecute(ahVar);
            this.b.a = null;
            if (ahVar != null) {
                this.b.b = ahVar;
                this.b.b();
            }
        } catch (Exception e) {
            af.b(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }
}
