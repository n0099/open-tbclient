package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends BdAsyncTask<Object, Integer, JSONObject> {
    final /* synthetic */ ar a;
    private int b;
    private com.baidu.tieba.util.at c = null;

    public au(ar arVar, int i) {
        this.a = arVar;
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
            this.c = new com.baidu.tieba.util.at(com.baidu.tieba.data.h.a + "c/f/frs/photo");
            StringBuilder sb = new StringBuilder();
            int size = this.a.c().size();
            for (int i = this.b; i < size && i < this.b + 30; i++) {
                sb.append(this.a.c().get(i));
                sb.append(",");
            }
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == ',') {
                sb.deleteCharAt(length - 1);
            }
            this.c.a("alb_ids", sb.toString());
            com.baidu.tieba.util.at atVar = this.c;
            str = this.a.j;
            atVar.a("kw", str);
            return new JSONObject(this.c.l());
        } catch (Exception e) {
            com.baidu.tieba.util.bo.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.bk bkVar;
        com.baidu.tieba.frs.bk bkVar2;
        super.a((au) jSONObject);
        this.a.l = null;
        bkVar = this.a.n;
        if (bkVar != null) {
            at atVar = new at(this.a);
            if (this.c != null) {
                atVar.a = true;
                atVar.b = this.c.d();
                atVar.c = this.c.e();
                atVar.d = this.c.i();
                atVar.e = this.c.b();
            }
            bkVar2 = this.a.n;
            bkVar2.a(this.b, jSONObject, atVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.bk bkVar;
        com.baidu.tieba.frs.bk bkVar2;
        super.b();
        bkVar = this.a.n;
        if (bkVar != null) {
            bkVar2 = this.a.n;
            bkVar2.a(0);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.j();
            this.c = null;
        }
        this.a.l = null;
    }
}
