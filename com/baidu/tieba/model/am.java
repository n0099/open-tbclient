package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends BdAsyncTask<Object, Integer, JSONObject> {
    final /* synthetic */ al a;
    private int b;
    private com.baidu.tieba.util.ba c = null;

    public am(al alVar, int i) {
        this.a = alVar;
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
            this.c = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/frs/photolist");
            str = this.a.i;
            if (str != null) {
                com.baidu.tieba.util.ba baVar = this.c;
                str3 = this.a.i;
                baVar.a("st_type", str3);
            }
            com.baidu.tieba.util.ba baVar2 = this.c;
            str2 = this.a.j;
            baVar2.a("kw", str2);
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
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
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
        com.baidu.tieba.frs.bn bnVar;
        com.baidu.tieba.frs.bn bnVar2;
        super.a((am) jSONObject);
        this.a.k = null;
        bnVar = this.a.m;
        if (bnVar != null) {
            an anVar = new an(this.a);
            if (this.c != null) {
                anVar.a = true;
                anVar.b = this.c.e();
                anVar.c = this.c.f();
                anVar.d = this.c.j();
                anVar.e = this.c.c();
            }
            bnVar2 = this.a.m;
            bnVar2.a(this.b, jSONObject, anVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.bn bnVar;
        com.baidu.tieba.frs.bn bnVar2;
        super.b();
        bnVar = this.a.m;
        if (bnVar != null) {
            bnVar2 = this.a.m;
            bnVar2.a(0);
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
