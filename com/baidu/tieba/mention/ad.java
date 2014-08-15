package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ce;
import com.baidu.tbadk.core.data.AntiData;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<Object, Integer, String> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ v b;
    private com.baidu.tbadk.core.util.ae c;
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
            this.c = new com.baidu.tbadk.core.util.ae(this.d);
            this.c.a(this.a);
            return this.c.h();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
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
                    com.baidu.tieba.data.aj ajVar = new com.baidu.tieba.data.aj();
                    ajVar.b(str);
                    com.baidu.tieba.data.an anVar = ajVar.e().get(0);
                    if (anVar != null) {
                        int i = 0;
                        if (ajVar.h() != null) {
                            i = ajVar.h().getIsMem();
                        }
                        if (anVar.d() != null) {
                            if (ajVar.g() == null || ajVar.g().getIfpost() != 0) {
                                activity9 = this.b.c;
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ce(activity9, 2, ajVar.c().getId(), ajVar.c().getName(), ajVar.d().h(), anVar.d(), anVar.e(), ajVar.g(), 13001, false, ajVar.k(), this.e, false, false, null, null, null, i)));
                            } else {
                                activity10 = this.b.c;
                                com.baidu.adp.lib.util.j.a((Context) activity10, ajVar.g().getForbid_info());
                                return;
                            }
                        } else if (ajVar.g() == null || ajVar.g().getIfpost() != 0) {
                            activity7 = this.b.c;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ce(activity7, 1, ajVar.c().getId(), ajVar.c().getName(), ajVar.d().h(), null, anVar.e(), ajVar.g(), 13002, false, ajVar.k(), this.e, false, false, null, null, null, i)));
                        } else {
                            activity8 = this.b.c;
                            com.baidu.adp.lib.util.j.a((Context) activity8, ajVar.g().getForbid_info());
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (this.f == 2) {
                    activity2 = this.b.c;
                    com.baidu.tieba.data.au a = new com.baidu.tieba.model.an(activity2, str).a();
                    String id = a.i().getId();
                    String name = a.i().getName();
                    String h = a.n().h();
                    AntiData j = a.j();
                    String d = a.b().d();
                    int e = a.b().e();
                    if (d != null) {
                        if (j == null || j.getIfpost() != 0) {
                            activity5 = this.b.c;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ce(activity5, 2, id, name, h, d, e, j, 13001, false, true, this.e, false, false, null, null, null, 0)));
                        } else {
                            activity6 = this.b.c;
                            com.baidu.adp.lib.util.j.a((Context) activity6, j.getForbid_info());
                            return;
                        }
                    } else if (j == null || j.getIfpost() != 0) {
                        activity3 = this.b.c;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ce(activity3, 1, id, name, h, null, e, j, 13002, false, true, this.e, false, false, null, null, null, 0)));
                    } else {
                        activity4 = this.b.c;
                        com.baidu.adp.lib.util.j.a((Context) activity4, j.getForbid_info());
                        return;
                    }
                }
            } else if (this.c != null) {
                activity = this.b.c;
                com.baidu.adp.lib.util.j.a((Context) activity, this.c.e());
            }
        } catch (Exception e2) {
        }
        this.b.k = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.c != null) {
            this.c.f();
        }
        super.cancel(true);
    }
}
