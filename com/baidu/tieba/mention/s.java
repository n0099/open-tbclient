package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.bv;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.data.am;
import com.baidu.tieba.data.at;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<Object, Integer, String> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ l b;
    private aq c;
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
            this.c = new aq(this.d);
            this.c.a(this.a);
            return this.c.i();
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
                    ai aiVar = new ai();
                    aiVar.b(str);
                    am amVar = aiVar.d().get(0);
                    if (amVar != null) {
                        int i = 0;
                        if (aiVar.g() != null) {
                            i = aiVar.g().getIsMem();
                        }
                        if (amVar.l() != null) {
                            if (aiVar.f() == null || aiVar.f().getIfpost() != 0) {
                                activity9 = this.b.c;
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bv(activity9, 2, aiVar.b().getId(), aiVar.b().getName(), aiVar.c().p(), amVar.l(), amVar.m(), aiVar.f(), 13001, false, aiVar.j(), this.e, false, false, null, null, null, i)));
                            } else {
                                activity10 = this.b.c;
                                com.baidu.adp.lib.util.j.a((Context) activity10, aiVar.f().getForbid_info());
                                return;
                            }
                        } else if (aiVar.f() == null || aiVar.f().getIfpost() != 0) {
                            activity7 = this.b.c;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bv(activity7, 1, aiVar.b().getId(), aiVar.b().getName(), aiVar.c().p(), null, amVar.m(), aiVar.f(), 13002, false, aiVar.j(), this.e, false, false, null, null, null, i)));
                        } else {
                            activity8 = this.b.c;
                            com.baidu.adp.lib.util.j.a((Context) activity8, aiVar.f().getForbid_info());
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (this.f == 2) {
                    activity2 = this.b.c;
                    at a = new com.baidu.tieba.model.am(activity2, str).a();
                    String id = a.h().getId();
                    String name = a.h().getName();
                    String p = a.m().p();
                    AntiData i2 = a.i();
                    String l = a.a().l();
                    int m = a.a().m();
                    if (l != null) {
                        if (i2 == null || i2.getIfpost() != 0) {
                            activity5 = this.b.c;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bv(activity5, 2, id, name, p, l, m, i2, 13001, false, true, this.e, false, false, null, null, null, 0)));
                        } else {
                            activity6 = this.b.c;
                            com.baidu.adp.lib.util.j.a((Context) activity6, i2.getForbid_info());
                            return;
                        }
                    } else if (i2 == null || i2.getIfpost() != 0) {
                        activity3 = this.b.c;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bv(activity3, 1, id, name, p, null, m, i2, 13002, false, true, this.e, false, false, null, null, null, 0)));
                    } else {
                        activity4 = this.b.c;
                        com.baidu.adp.lib.util.j.a((Context) activity4, i2.getForbid_info());
                        return;
                    }
                }
            } else if (this.c != null) {
                activity = this.b.c;
                com.baidu.adp.lib.util.j.a((Context) activity, this.c.f());
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
