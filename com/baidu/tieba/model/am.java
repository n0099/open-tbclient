package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class am extends BdAsyncTask<Object, Integer, JSONObject> {
    final /* synthetic */ al a;
    private int b;
    private com.baidu.tieba.util.ba c = null;

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
        com.baidu.tieba.frs.bo boVar;
        com.baidu.tieba.frs.bo boVar2;
        JSONObject jSONObject2 = jSONObject;
        super.a((am) jSONObject2);
        this.a.k = null;
        boVar = this.a.m;
        if (boVar != null) {
            an anVar = new an(this.a);
            if (this.c != null) {
                anVar.a = true;
                anVar.b = this.c.d();
                anVar.c = this.c.e();
                anVar.d = this.c.i();
                anVar.e = this.c.b();
            }
            boVar2 = this.a.m;
            boVar2.a(this.b, jSONObject2, anVar);
        }
    }

    public am(al alVar, int i) {
        this.a = alVar;
        this.b = 0;
        this.b = i;
        if (this.b <= 0) {
            this.b = 1;
        }
        setSelfExecute(true);
    }

    private JSONObject d() {
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
            String l = this.c.l();
            jSONObject = new JSONObject(l);
            try {
                if (this.c.c()) {
                    try {
                        this.a.a(new JSONObject(l));
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
                return jSONObject;
            }
        } catch (Exception e4) {
            jSONObject = null;
            e = e4;
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        com.baidu.tieba.frs.bo boVar;
        com.baidu.tieba.frs.bo boVar2;
        super.b();
        boVar = this.a.m;
        if (boVar != null) {
            boVar2 = this.a.m;
            boVar2.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.j();
            this.c = null;
        }
        this.a.k = null;
    }
}
