package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<Object, z, JSONObject> {
    ArrayList<BasicNameValuePair> a;
    ac b;
    final /* synthetic */ z c;
    private com.baidu.tieba.util.ba d = null;
    private String e;
    private String f;
    private int g;

    public ad(z zVar, String str, ArrayList<BasicNameValuePair> arrayList, int i, String str2) {
        this.c = zVar;
        this.e = null;
        this.f = null;
        this.g = 3;
        this.a = null;
        this.b = new ac(zVar);
        this.e = str;
        this.f = str2;
        this.a = arrayList;
        this.g = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.by byVar;
        com.baidu.tieba.frs.by byVar2;
        byVar = this.c.j;
        if (byVar != null) {
            byVar2 = this.c.j;
            byVar2.a(this.g);
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
            if (z && o.a().a(this.f)) {
                if (!o.a().c(String.valueOf(TiebaApplication.A()) + this.f)) {
                    o.a().b().b().getSignData().setIsSigned(0);
                }
                c((Object[]) new z[]{o.a().b()});
            }
            this.d = new com.baidu.tieba.util.ba(this.e);
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
                            o a = o.a();
                            forumData2 = this.c.a;
                            a.a(forumData2.getName(), m);
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
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
    public void b(z... zVarArr) {
        com.baidu.tieba.frs.by byVar;
        com.baidu.tieba.frs.by byVar2;
        byVar = this.c.j;
        if (byVar != null) {
            byVar2 = this.c.j;
            byVar2.a(zVarArr.length > 0 ? zVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.by byVar;
        com.baidu.tieba.frs.by byVar2;
        if (this.d != null) {
            this.b.a = true;
            this.b.b = this.d.e();
            this.b.c = this.d.f();
            this.b.d = this.d.j();
            this.b.e = this.d.c();
        }
        byVar = this.c.j;
        if (byVar != null) {
            byVar2 = this.c.j;
            byVar2.a(this.g, jSONObject, this.b);
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
        com.baidu.tieba.frs.by byVar;
        com.baidu.tieba.frs.by byVar2;
        super.cancel(true);
        if (this.d != null) {
            this.d.k();
        }
        byVar = this.c.j;
        if (byVar != null) {
            byVar2 = this.c.j;
            byVar2.a(this.g, null, null);
        }
    }
}
