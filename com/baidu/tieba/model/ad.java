package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ad extends BdAsyncTask<Object, z, JSONObject> {
    ArrayList<BasicNameValuePair> a;
    ac b;
    final /* synthetic */ z c;
    private com.baidu.tieba.util.ba d = null;
    private String e;
    private String f;
    private int g;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ JSONObject a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.bz bzVar;
        com.baidu.tieba.frs.bz bzVar2;
        JSONObject jSONObject2 = jSONObject;
        if (this.d != null) {
            this.b.a = true;
            this.b.b = this.d.d();
            this.b.c = this.d.e();
            this.b.d = this.d.i();
            this.b.e = this.d.b();
        }
        bzVar = this.c.j;
        if (bzVar != null) {
            bzVar2 = this.c.j;
            bzVar2.a(this.g, jSONObject2, this.b);
        }
        this.c.m = null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(z... zVarArr) {
        com.baidu.tieba.frs.bz bzVar;
        com.baidu.tieba.frs.bz bzVar2;
        z[] zVarArr2 = zVarArr;
        bzVar = this.c.j;
        if (bzVar != null) {
            bzVar2 = this.c.j;
            bzVar2.a(zVarArr2.length > 0 ? zVarArr2[0] : null);
        }
    }

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
    public final void b() {
        com.baidu.tieba.frs.bz bzVar;
        com.baidu.tieba.frs.bz bzVar2;
        bzVar = this.c.j;
        if (bzVar != null) {
            bzVar2 = this.c.j;
            bzVar2.a(this.g);
        }
    }

    private JSONObject d() {
        JSONObject jSONObject;
        Exception e;
        boolean z;
        String l;
        boolean z2;
        ForumData forumData;
        ForumData forumData2;
        try {
            z = this.c.o;
            if (z && o.a().a(this.f)) {
                if (!o.a().c(String.valueOf(TiebaApplication.v()) + this.f)) {
                    o.a().b().f().getSignData().setIsSigned(0);
                }
                c((Object[]) new z[]{o.a().b()});
            }
            this.c.p = System.currentTimeMillis();
            this.d = new com.baidu.tieba.util.ba(this.e);
            this.d.a(this.a);
            l = this.d.l();
            jSONObject = new JSONObject(l);
        } catch (Exception e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            this.c.q = this.d.p();
            this.c.r = this.d.q();
            this.c.s = System.currentTimeMillis();
            if (this.d.c()) {
                this.c.a(l);
                z2 = this.c.o;
                if (z2) {
                    forumData = this.c.a;
                    if (forumData != null) {
                        o a = o.a();
                        forumData2 = this.c.a;
                        a.a(forumData2.getName(), l);
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            com.baidu.adp.lib.util.e.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
            return jSONObject;
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.tieba.frs.bz bzVar;
        com.baidu.tieba.frs.bz bzVar2;
        super.cancel(true);
        if (this.d != null) {
            this.d.j();
        }
        bzVar = this.c.j;
        if (bzVar != null) {
            bzVar2 = this.c.j;
            bzVar2.a(this.g, null, null);
        }
    }
}
