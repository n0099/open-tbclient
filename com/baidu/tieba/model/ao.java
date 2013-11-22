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
    ArrayList<BasicNameValuePair> f1877a;
    an b;
    final /* synthetic */ ak c;
    private com.baidu.tieba.util.ap d = null;
    private String e;
    private String f;
    private int g;

    public ao(ak akVar, String str, ArrayList<BasicNameValuePair> arrayList, int i, String str2) {
        this.c = akVar;
        this.e = null;
        this.f = null;
        this.g = 3;
        this.f1877a = null;
        this.b = new an(this.c);
        this.e = str;
        this.f = str2;
        this.f1877a = arrayList;
        this.g = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.ag agVar;
        com.baidu.tieba.frs.ag agVar2;
        agVar = this.c.i;
        if (agVar != null) {
            agVar2 = this.c.i;
            agVar2.a(this.g);
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
            z = this.c.n;
            if (z && z.a().a(this.f)) {
                c((Object[]) new ak[]{z.a().b()});
            }
            this.d = new com.baidu.tieba.util.ap(this.e);
            this.d.a(this.f1877a);
            String l = this.d.l();
            jSONObject = new JSONObject(l);
            try {
                if (this.d.c()) {
                    this.c.a(l);
                    z2 = this.c.n;
                    if (z2) {
                        forumData = this.c.f1873a;
                        if (forumData != null) {
                            z a2 = z.a();
                            forumData2 = this.c.f1873a;
                            a2.a(forumData2.getName(), l);
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bg.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
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
        com.baidu.tieba.frs.ag agVar;
        com.baidu.tieba.frs.ag agVar2;
        agVar = this.c.i;
        if (agVar != null) {
            agVar2 = this.c.i;
            agVar2.a(akVarArr.length > 0 ? akVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.ag agVar;
        com.baidu.tieba.frs.ag agVar2;
        if (this.d != null) {
            this.b.f1876a = true;
            this.b.b = this.d.d();
            this.b.c = this.d.e();
            this.b.d = this.d.i();
            this.b.e = this.d.b();
        }
        agVar = this.c.i;
        if (agVar != null) {
            agVar2 = this.c.i;
            agVar2.a(this.g, jSONObject, this.b);
        }
        this.c.l = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.tieba.frs.ag agVar;
        com.baidu.tieba.frs.ag agVar2;
        super.cancel(true);
        if (this.d != null) {
            this.d.j();
        }
        agVar = this.c.i;
        if (agVar != null) {
            agVar2 = this.c.i;
            agVar2.a(this.g, null, null);
        }
    }
}
