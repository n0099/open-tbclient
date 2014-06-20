package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.bh;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.data.ap;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Object, Integer, String> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ m b;
    private an c;
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
            this.c = new an(this.d);
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
                    com.baidu.tieba.data.af afVar = new com.baidu.tieba.data.af();
                    afVar.b(str);
                    ai aiVar = afVar.e().get(0);
                    if (aiVar != null) {
                        if (aiVar.l() != null) {
                            if (afVar.g() == null || afVar.g().getIfpost() != 0) {
                                activity9 = this.b.c;
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(activity9, 2, afVar.c().getId(), afVar.c().getName(), afVar.d().p(), aiVar.l(), aiVar.m(), afVar.g(), 13001, false, afVar.k(), this.e, false, false, null, null, null)));
                            } else {
                                activity10 = this.b.c;
                                com.baidu.adp.lib.util.k.a((Context) activity10, afVar.g().getForbid_info());
                                return;
                            }
                        } else if (afVar.g() == null || afVar.g().getIfpost() != 0) {
                            activity7 = this.b.c;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(activity7, 1, afVar.c().getId(), afVar.c().getName(), afVar.d().p(), null, aiVar.m(), afVar.g(), 13002, false, afVar.k(), this.e, false, false, null, null, null)));
                        } else {
                            activity8 = this.b.c;
                            com.baidu.adp.lib.util.k.a((Context) activity8, afVar.g().getForbid_info());
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (this.f == 2) {
                    activity2 = this.b.c;
                    ap a = new com.baidu.tieba.model.an(activity2, str).a();
                    String id = a.h().getId();
                    String name = a.h().getName();
                    String p = a.m().p();
                    AntiData i = a.i();
                    String l = a.a().l();
                    int m = a.a().m();
                    if (l != null) {
                        if (i == null || i.getIfpost() != 0) {
                            activity5 = this.b.c;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(activity5, 2, id, name, p, l, m, i, 13001, false, true, this.e, false, false, null, null, null)));
                        } else {
                            activity6 = this.b.c;
                            com.baidu.adp.lib.util.k.a((Context) activity6, i.getForbid_info());
                            return;
                        }
                    } else if (i == null || i.getIfpost() != 0) {
                        activity3 = this.b.c;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(activity3, 1, id, name, p, null, m, i, 13002, false, true, this.e, false, false, null, null, null)));
                    } else {
                        activity4 = this.b.c;
                        com.baidu.adp.lib.util.k.a((Context) activity4, i.getForbid_info());
                        return;
                    }
                }
            } else if (this.c != null) {
                activity = this.b.c;
                com.baidu.adp.lib.util.k.a((Context) activity, this.c.f());
            }
        } catch (Exception e) {
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
