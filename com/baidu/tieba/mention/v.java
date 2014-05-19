package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.bh;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.model.an;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Object, Integer, String> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ m b;
    private al c;
    private String d;
    private String e;
    private final int f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        try {
            this.c = new al(this.d);
            this.c.a(this.a);
            return this.c.i();
        } catch (Exception e) {
            BdLog.e("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        Activity activity5;
        Activity activity6;
        Activity activity7;
        Activity activity8;
        Activity activity9;
        Activity activity10;
        try {
            if (this.c != null && this.c.a().b().b()) {
                if (this.f == 1) {
                    com.baidu.tieba.data.ae aeVar = new com.baidu.tieba.data.ae();
                    aeVar.b(str);
                    com.baidu.tieba.data.ah ahVar = aeVar.e().get(0);
                    if (ahVar != null) {
                        if (ahVar.d() != null) {
                            if (aeVar.g() == null || aeVar.g().getIfpost() != 0) {
                                activity9 = this.b.c;
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(activity9, 2, aeVar.c().getId(), aeVar.c().getName(), aeVar.d().k(), ahVar.d(), ahVar.e(), aeVar.g(), 13001, false, aeVar.k(), this.e, false, false, null, null, null)));
                            } else {
                                activity10 = this.b.c;
                                com.baidu.adp.lib.util.h.a((Context) activity10, aeVar.g().getForbid_info());
                                return;
                            }
                        } else if (aeVar.g() == null || aeVar.g().getIfpost() != 0) {
                            activity7 = this.b.c;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(activity7, 1, aeVar.c().getId(), aeVar.c().getName(), aeVar.d().k(), null, ahVar.e(), aeVar.g(), 13002, false, aeVar.k(), this.e, false, false, null, null, null)));
                        } else {
                            activity8 = this.b.c;
                            com.baidu.adp.lib.util.h.a((Context) activity8, aeVar.g().getForbid_info());
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (this.f == 2) {
                    activity2 = this.b.c;
                    ao a = new an(activity2, str).a();
                    String id = a.h().getId();
                    String name = a.h().getName();
                    String k = a.m().k();
                    AntiData i = a.i();
                    String d = a.a().d();
                    int e = a.a().e();
                    if (d != null) {
                        if (i == null || i.getIfpost() != 0) {
                            activity5 = this.b.c;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(activity5, 2, id, name, k, d, e, i, 13001, false, true, this.e, false, false, null, null, null)));
                        } else {
                            activity6 = this.b.c;
                            com.baidu.adp.lib.util.h.a((Context) activity6, i.getForbid_info());
                            return;
                        }
                    } else if (i == null || i.getIfpost() != 0) {
                        activity3 = this.b.c;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(activity3, 1, id, name, k, null, e, i, 13002, false, true, this.e, false, false, null, null, null)));
                    } else {
                        activity4 = this.b.c;
                        com.baidu.adp.lib.util.h.a((Context) activity4, i.getForbid_info());
                        return;
                    }
                }
            } else if (this.c != null) {
                activity = this.b.c;
                com.baidu.adp.lib.util.h.a((Context) activity, this.c.f());
            }
        } catch (Exception e2) {
        }
        this.b.l = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }
}
