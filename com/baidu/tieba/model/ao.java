package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ao extends BdAsyncTask<Object, Integer, JSONObject> {
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
        super.a((ao) jSONObject2);
        this.a.l = null;
        boVar = this.a.n;
        if (boVar != null) {
            an anVar = new an(this.a);
            if (this.c != null) {
                anVar.a = true;
                anVar.b = this.c.d();
                anVar.c = this.c.e();
                anVar.d = this.c.i();
                anVar.e = this.c.b();
            }
            boVar2 = this.a.n;
            boVar2.a(this.b, jSONObject2, anVar);
        }
    }

    public ao(al alVar, int i) {
        this.a = alVar;
        this.b = 0;
        this.b = i;
        if (this.b < 0) {
            this.b = 0;
        }
    }

    private JSONObject d() {
        String str;
        try {
            this.c = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/frs/photo");
            StringBuilder sb = new StringBuilder();
            int size = this.a.d().size();
            for (int i = this.b; i < size && i < this.b + 30; i++) {
                sb.append(this.a.d().get(i));
                sb.append(",");
            }
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == ',') {
                sb.deleteCharAt(length - 1);
            }
            this.c.a("alb_ids", sb.toString());
            com.baidu.tieba.util.ba baVar = this.c;
            str = this.a.j;
            baVar.a("kw", str);
            return new JSONObject(this.c.l());
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        com.baidu.tieba.frs.bo boVar;
        com.baidu.tieba.frs.bo boVar2;
        super.b();
        boVar = this.a.n;
        if (boVar != null) {
            boVar2 = this.a.n;
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
        this.a.l = null;
    }
}
