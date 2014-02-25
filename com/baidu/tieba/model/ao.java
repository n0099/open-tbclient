package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends BdAsyncTask<Object, Integer, JSONObject> {
    final /* synthetic */ al a;
    private int b;
    private com.baidu.tieba.util.ba c = null;

    public ao(al alVar, int i) {
        this.a = alVar;
        this.b = 0;
        this.b = i;
        if (this.b < 0) {
            this.b = 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public JSONObject a(Object... objArr) {
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
            return new JSONObject(this.c.m());
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.bn bnVar;
        com.baidu.tieba.frs.bn bnVar2;
        super.a((ao) jSONObject);
        this.a.l = null;
        bnVar = this.a.n;
        if (bnVar != null) {
            an anVar = new an(this.a);
            if (this.c != null) {
                anVar.a = true;
                anVar.b = this.c.e();
                anVar.c = this.c.f();
                anVar.d = this.c.j();
                anVar.e = this.c.c();
            }
            bnVar2 = this.a.n;
            bnVar2.a(this.b, jSONObject, anVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.bn bnVar;
        com.baidu.tieba.frs.bn bnVar2;
        super.b();
        bnVar = this.a.n;
        if (bnVar != null) {
            bnVar2 = this.a.n;
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
        this.a.l = null;
    }
}
