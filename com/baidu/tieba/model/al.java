package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1363a;
    private int b;
    private com.baidu.tieba.util.v c = null;

    public al(ak akVar, int i) {
        this.f1363a = akVar;
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
            this.c = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/f/frs/photolist");
            str = this.f1363a.i;
            if (str != null) {
                com.baidu.tieba.util.v vVar = this.c;
                str3 = this.f1363a.i;
                vVar.a("st_type", str3);
            }
            com.baidu.tieba.util.v vVar2 = this.c;
            str2 = this.f1363a.j;
            vVar2.a("kw", str2);
            this.c.a("bs", String.valueOf(this.b));
            this.c.a("be", String.valueOf((this.b + 240) - 1));
            this.c.a("an", String.valueOf(30));
            String j = this.c.j();
            jSONObject = new JSONObject(j);
            try {
                if (this.c.c()) {
                    this.f1363a.a(j);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.getMessage());
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
        com.baidu.tieba.frs.ay ayVar;
        com.baidu.tieba.frs.ay ayVar2;
        super.a((Object) jSONObject);
        this.f1363a.k = null;
        ayVar = this.f1363a.m;
        if (ayVar != null) {
            am amVar = new am(this.f1363a);
            if (this.c != null) {
                amVar.f1364a = true;
                amVar.b = this.c.d();
                amVar.c = this.c.e();
                amVar.d = this.c.g();
                amVar.e = this.c.b();
            }
            ayVar2 = this.f1363a.m;
            ayVar2.a(this.b, jSONObject, amVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.ay ayVar;
        com.baidu.tieba.frs.ay ayVar2;
        super.b();
        ayVar = this.f1363a.m;
        if (ayVar != null) {
            ayVar2 = this.f1363a.m;
            ayVar2.a(0);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.h();
            this.c = null;
        }
        this.f1363a.k = null;
    }
}
