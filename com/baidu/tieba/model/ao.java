package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends BdAsyncTask<Object, ak, JSONObject> {
    ArrayList<BasicNameValuePair> a;
    an b;
    final /* synthetic */ ak c;
    private com.baidu.tieba.util.ax d = null;
    private String e;
    private String f;
    private int g;

    public ao(ak akVar, String str, ArrayList<BasicNameValuePair> arrayList, int i, String str2) {
        this.c = akVar;
        this.e = null;
        this.f = null;
        this.g = 3;
        this.a = null;
        this.b = new an(this.c);
        this.e = str;
        this.f = str2;
        this.a = arrayList;
        this.g = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.ab abVar;
        com.baidu.tieba.frs.ab abVar2;
        abVar = this.c.j;
        if (abVar != null) {
            abVar2 = this.c.j;
            abVar2.a(this.g);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public JSONObject a(Object... objArr) {
        JSONObject jSONObject;
        Exception e;
        boolean z;
        boolean z2;
        ForumData forumData;
        ForumData forumData2;
        try {
            z = this.c.o;
            if (z && z.a().a(this.f)) {
                if (!z.a().c(TiebaApplication.A() + this.f)) {
                    z.a().b().b().getSignData().setIsSigned(0);
                }
                c((Object[]) new ak[]{z.a().b()});
            }
            this.d = new com.baidu.tieba.util.ax(this.e);
            this.d.a(this.a);
            String m = this.d.m();
            jSONObject = new JSONObject(m);
            try {
                if (this.d.d()) {
                    this.c.a(m);
                    z2 = this.c.o;
                    if (z2) {
                        forumData = this.c.a;
                        if (forumData != null) {
                            z a = z.a();
                            forumData2 = this.c.a;
                            a.a(forumData2.getName(), m);
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.g.e.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
                return jSONObject;
            }
        } catch (Exception e3) {
            jSONObject = null;
            e = e3;
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(ak... akVarArr) {
        com.baidu.tieba.frs.ab abVar;
        com.baidu.tieba.frs.ab abVar2;
        abVar = this.c.j;
        if (abVar != null) {
            abVar2 = this.c.j;
            abVar2.a(akVarArr.length > 0 ? akVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.ab abVar;
        com.baidu.tieba.frs.ab abVar2;
        if (this.d != null) {
            this.b.a = true;
            this.b.b = this.d.e();
            this.b.c = this.d.f();
            this.b.d = this.d.j();
            this.b.e = this.d.c();
        }
        abVar = this.c.j;
        if (abVar != null) {
            abVar2 = this.c.j;
            abVar2.a(this.g, jSONObject, this.b);
        }
        this.c.m = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.tieba.frs.ab abVar;
        com.baidu.tieba.frs.ab abVar2;
        super.cancel(true);
        if (this.d != null) {
            this.d.k();
        }
        abVar = this.c.j;
        if (abVar != null) {
            abVar2 = this.c.j;
            abVar2.a(this.g, null, null);
        }
    }
}
