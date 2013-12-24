package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ar;
import com.baidu.tieba.data.av;
import com.baidu.tieba.model.cf;
import com.baidu.tieba.util.an;
import com.baidu.tieba.util.be;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<Object, Integer, String> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ j b;
    private an c = null;
    private String d;
    private String e;
    private int f;

    public s(j jVar, String str, ArrayList<BasicNameValuePair> arrayList, int i, String str2) {
        this.b = jVar;
        this.d = null;
        this.e = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
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
            this.c = new an(this.d);
            this.c.a(this.a);
            return this.c.l();
        } catch (Exception e) {
            be.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
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
                    com.baidu.tieba.data.an anVar = new com.baidu.tieba.data.an();
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
                    av a = new cf(activity2, str).a();
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
