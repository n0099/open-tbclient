package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends BdAsyncTask<Object, Integer, JSONObject> {
    final /* synthetic */ ar a;
    private int b;
    private com.baidu.tieba.util.ax c = null;

    public as(ar arVar, int i) {
        this.a = arVar;
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
            this.c = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/f/frs/photolist");
            str = this.a.i;
            if (str != null) {
                com.baidu.tieba.util.ax axVar = this.c;
                str3 = this.a.i;
                axVar.a("st_type", str3);
            }
            com.baidu.tieba.util.ax axVar2 = this.c;
            str2 = this.a.j;
            axVar2.a("kw", str2);
            this.c.a("bs", String.valueOf(this.b));
            this.c.a("be", String.valueOf((this.b + 240) - 1));
            this.c.a("an", String.valueOf(30));
            String m = this.c.m();
            jSONObject = new JSONObject(m);
            try {
                if (this.c.d()) {
                    this.a.a(m);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.getMessage());
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
        com.baidu.tieba.frs.bg bgVar;
        com.baidu.tieba.frs.bg bgVar2;
        super.a((as) jSONObject);
        this.a.k = null;
        bgVar = this.a.m;
        if (bgVar != null) {
            at atVar = new at(this.a);
            if (this.c != null) {
                atVar.a = true;
                atVar.b = this.c.e();
                atVar.c = this.c.f();
                atVar.d = this.c.j();
                atVar.e = this.c.c();
            }
            bgVar2 = this.a.m;
            bgVar2.a(this.b, jSONObject, atVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.bg bgVar;
        com.baidu.tieba.frs.bg bgVar2;
        super.b();
        bgVar = this.a.m;
        if (bgVar != null) {
            bgVar2 = this.a.m;
            bgVar2.a(0);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.k();
            this.c = null;
        }
        this.a.k = null;
    }
}
