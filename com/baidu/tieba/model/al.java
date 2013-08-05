package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1330a;
    private int b;
    private com.baidu.tieba.util.u c = null;

    public al(ak akVar, int i) {
        this.f1330a = akVar;
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
            this.c = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/f/frs/photolist");
            str = this.f1330a.i;
            if (str != null) {
                com.baidu.tieba.util.u uVar = this.c;
                str3 = this.f1330a.i;
                uVar.a("st_type", str3);
            }
            com.baidu.tieba.util.u uVar2 = this.c;
            str2 = this.f1330a.j;
            uVar2.a("kw", str2);
            this.c.a("bs", String.valueOf(this.b));
            this.c.a("be", String.valueOf((this.b + 240) - 1));
            this.c.a("an", String.valueOf(30));
            String k = this.c.k();
            jSONObject = new JSONObject(k);
            try {
                if (this.c.d()) {
                    this.f1330a.a(k);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.f1330a.k = null;
        awVar = this.f1330a.m;
        if (awVar != null) {
            am amVar = new am(this.f1330a);
            if (this.c != null) {
                amVar.f1331a = true;
                amVar.b = this.c.e();
                amVar.c = this.c.f();
                amVar.d = this.c.h();
                amVar.e = this.c.c();
            }
            awVar2 = this.f1330a.m;
            awVar2.a(this.b, jSONObject, amVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.aw awVar;
        com.baidu.tieba.frs.aw awVar2;
        super.b();
        awVar = this.f1330a.m;
        if (awVar != null) {
            awVar2 = this.f1330a.m;
            awVar2.a(0);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.i();
            this.c = null;
        }
        this.f1330a.k = null;
    }
}
