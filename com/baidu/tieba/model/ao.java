package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.ForumData;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends BdAsyncTask<Object, ak, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<BasicNameValuePair> f1899a;
    an b;
    final /* synthetic */ ak c;
    private com.baidu.tieba.util.ag d = null;
    private String e;
    private String f;
    private int g;

    public ao(ak akVar, String str, ArrayList<BasicNameValuePair> arrayList, int i, String str2) {
        this.c = akVar;
        this.e = null;
        this.f = null;
        this.g = 3;
        this.f1899a = null;
        this.b = new an(this.c);
        this.e = str;
        this.f = str2;
        this.f1899a = arrayList;
        this.g = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.ac acVar;
        com.baidu.tieba.frs.ac acVar2;
        acVar = this.c.h;
        if (acVar != null) {
            acVar2 = this.c.h;
            acVar2.a(this.g);
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
            z = this.c.m;
            if (z && z.a().a(this.f)) {
                c((Object[]) new ak[]{z.a().b()});
            }
            this.d = new com.baidu.tieba.util.ag(this.e);
            this.d.a(this.f1899a);
            String j = this.d.j();
            jSONObject = new JSONObject(j);
            try {
                if (this.d.c()) {
                    this.c.a(j);
                    z2 = this.c.m;
                    if (z2) {
                        forumData = this.c.f1895a;
                        if (forumData != null) {
                            z a2 = z.a();
                            forumData2 = this.c.f1895a;
                            a2.a(forumData2.getName(), j);
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.be.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
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
        com.baidu.tieba.frs.ac acVar;
        com.baidu.tieba.frs.ac acVar2;
        acVar = this.c.h;
        if (acVar != null) {
            acVar2 = this.c.h;
            acVar2.a(akVarArr.length > 0 ? akVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.ac acVar;
        com.baidu.tieba.frs.ac acVar2;
        if (this.d != null) {
            this.b.f1898a = true;
            this.b.b = this.d.d();
            this.b.c = this.d.e();
            this.b.d = this.d.g();
            this.b.e = this.d.b();
        }
        acVar = this.c.h;
        if (acVar != null) {
            acVar2 = this.c.h;
            acVar2.a(this.g, jSONObject, this.b);
        }
        this.c.k = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.tieba.frs.ac acVar;
        com.baidu.tieba.frs.ac acVar2;
        super.cancel(true);
        if (this.d != null) {
            this.d.h();
        }
        acVar = this.c.h;
        if (acVar != null) {
            acVar2 = this.c.h;
            acVar2.a(this.g, null, null);
        }
    }
}
