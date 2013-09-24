package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends BdAsyncTask<Object, Integer, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ am f1400a;
    private int b;
    private com.baidu.tieba.util.z c = null;

    public an(am amVar, int i) {
        this.f1400a = amVar;
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
            this.c = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/f/frs/photolist");
            str = this.f1400a.i;
            if (str != null) {
                com.baidu.tieba.util.z zVar = this.c;
                str3 = this.f1400a.i;
                zVar.a("st_type", str3);
            }
            com.baidu.tieba.util.z zVar2 = this.c;
            str2 = this.f1400a.j;
            zVar2.a("kw", str2);
            this.c.a("bs", String.valueOf(this.b));
            this.c.a("be", String.valueOf((this.b + 240) - 1));
            this.c.a("an", String.valueOf(30));
            String j = this.c.j();
            jSONObject = new JSONObject(j);
            try {
                if (this.c.c()) {
                    this.f1400a.a(j);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
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
        com.baidu.tieba.frs.ax axVar;
        com.baidu.tieba.frs.ax axVar2;
        super.a((an) jSONObject);
        this.f1400a.k = null;
        axVar = this.f1400a.m;
        if (axVar != null) {
            ao aoVar = new ao(this.f1400a);
            if (this.c != null) {
                aoVar.f1401a = true;
                aoVar.b = this.c.d();
                aoVar.c = this.c.e();
                aoVar.d = this.c.g();
                aoVar.e = this.c.b();
            }
            axVar2 = this.f1400a.m;
            axVar2.a(this.b, jSONObject, aoVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.ax axVar;
        com.baidu.tieba.frs.ax axVar2;
        super.b();
        axVar = this.f1400a.m;
        if (axVar != null) {
            axVar2 = this.f1400a.m;
            axVar2.a(0);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.h();
            this.c = null;
        }
        this.f1400a.k = null;
    }
}
