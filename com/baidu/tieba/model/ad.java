package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ac f1010a;
    private int b;
    private com.baidu.tieba.util.r c = null;

    public ad(ac acVar, int i) {
        this.f1010a = acVar;
        this.b = 0;
        this.b = i;
        if (this.b < 1) {
            this.b = 1;
        }
        setSelfExecute(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public JSONObject a(Object... objArr) {
        JSONObject jSONObject;
        Exception e;
        String str;
        String str2;
        String str3;
        try {
            this.c = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/f/frs/photolist");
            str = this.f1010a.i;
            if (str != null) {
                com.baidu.tieba.util.r rVar = this.c;
                str3 = this.f1010a.i;
                rVar.a("st_type", str3);
            }
            com.baidu.tieba.util.r rVar2 = this.c;
            str2 = this.f1010a.j;
            rVar2.a("kw", str2);
            this.c.a("bs", String.valueOf(this.b));
            this.c.a("be", String.valueOf((this.b + 240) - 1));
            this.c.a("an", String.valueOf(30));
            String j = this.c.j();
            jSONObject = new JSONObject(j);
            try {
                if (this.c.c()) {
                    this.f1010a.a(j);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
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
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.aw awVar;
        com.baidu.tieba.frs.aw awVar2;
        super.a((Object) jSONObject);
        this.f1010a.k = null;
        awVar = this.f1010a.m;
        if (awVar != null) {
            ae aeVar = new ae(this.f1010a);
            if (this.c != null) {
                aeVar.f1011a = true;
                aeVar.b = this.c.d();
                aeVar.c = this.c.e();
                aeVar.d = this.c.g();
                aeVar.e = this.c.b();
            }
            awVar2 = this.f1010a.m;
            awVar2.a(this.b, jSONObject, aeVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.aw awVar;
        com.baidu.tieba.frs.aw awVar2;
        super.b();
        awVar = this.f1010a.m;
        if (awVar != null) {
            awVar2 = this.f1010a.m;
            awVar2.a(0);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.h();
            this.c = null;
        }
        this.f1010a.k = null;
    }
}
