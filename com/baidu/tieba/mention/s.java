package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.an;
import com.baidu.tieba.data.ar;
import com.baidu.tieba.data.av;
import com.baidu.tieba.model.cg;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<Object, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<BasicNameValuePair> f1964a;
    final /* synthetic */ j b;
    private am c = null;
    private String d;
    private String e;
    private int f;

    public s(j jVar, String str, ArrayList<BasicNameValuePair> arrayList, int i, String str2) {
        this.b = jVar;
        this.d = null;
        this.e = null;
        this.f1964a = null;
        this.d = str;
        this.f1964a = arrayList;
        this.f = i;
        this.e = str2;
    }

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
            this.c = new am(this.d);
            this.c.a(this.f1964a);
            return this.c.l();
        } catch (Exception e) {
            bd.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
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
            if (this.c != null && this.c.c()) {
                if (this.f == 1) {
                    an anVar = new an();
                    anVar.b(str);
                    ar arVar = anVar.e().get(0);
                    if (arVar != null) {
                        activity4 = this.b.c;
                        WriteActivity.a(activity4, anVar.c().getId(), anVar.c().getName(), anVar.d().a(), arVar.d(), arVar.e(), this.e, anVar.g(), anVar.k());
                    } else {
                        return;
                    }
                }
                if (this.f == 2) {
                    activity2 = this.b.c;
                    av a2 = new cg(activity2, str).a();
                    String id = a2.h().getId();
                    String name = a2.h().getName();
                    String a3 = a2.m().a();
                    AntiData i = a2.i();
                    String d = a2.a().d();
                    int e = a2.a().e();
                    activity3 = this.b.c;
                    WriteActivity.a(activity3, id, name, a3, d, e, this.e, i, true);
                }
            } else if (this.c != null) {
                activity = this.b.c;
                com.baidu.adp.lib.h.g.a((Context) activity, this.c.i());
            }
        } catch (Exception e2) {
        }
        this.b.l = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.c != null) {
            this.c.j();
        }
        super.cancel(true);
    }
}
