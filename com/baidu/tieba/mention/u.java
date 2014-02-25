package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.am;
import com.baidu.tieba.data.aq;
import com.baidu.tieba.data.av;
import com.baidu.tieba.model.bv;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BdAsyncTask<Object, Integer, String> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ l b;
    private ba c;
    private String d;
    private String e;
    private int f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String a(Object... objArr) {
        try {
            this.c = new ba(this.d);
            this.c.a(this.a);
            return this.c.m();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        try {
            if (this.c != null && this.c.d()) {
                if (this.f == 1) {
                    am amVar = new am();
                    amVar.b(str);
                    aq aqVar = amVar.e().get(0);
                    if (aqVar != null) {
                        activity4 = this.b.c;
                        WriteActivity.a(activity4, amVar.c().getId(), amVar.c().getName(), amVar.d().a(), aqVar.d(), aqVar.e(), this.e, amVar.g(), amVar.k());
                    } else {
                        return;
                    }
                }
                if (this.f == 2) {
                    activity2 = this.b.c;
                    av a = new bv(activity2, str).a();
                    String id = a.h().getId();
                    String name = a.h().getName();
                    String a2 = a.m().a();
                    AntiData i = a.i();
                    String d = a.a().d();
                    int e = a.a().e();
                    activity3 = this.b.c;
                    WriteActivity.a(activity3, id, name, a2, d, e, this.e, i, true);
                }
            } else if (this.c != null) {
                activity = this.b.c;
                BdUtilHelper.a((Context) activity, this.c.j());
            }
        } catch (Exception e2) {
        }
        this.b.l = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.c != null) {
            this.c.k();
        }
        super.cancel(true);
    }
}
