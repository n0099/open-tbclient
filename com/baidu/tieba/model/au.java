package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends BdAsyncTask<Object, Integer, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ar f1996a;
    private int b;
    private com.baidu.tieba.util.am c = null;

    public au(ar arVar, int i) {
        this.f1996a = arVar;
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
            this.c = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/f/frs/photo");
            StringBuilder sb = new StringBuilder();
            int size = this.f1996a.c().size();
            for (int i = this.b; i < size && i < this.b + 30; i++) {
                sb.append(this.f1996a.c().get(i));
                sb.append(",");
            }
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == ',') {
                sb.deleteCharAt(length - 1);
            }
            this.c.a("alb_ids", sb.toString());
            com.baidu.tieba.util.am amVar = this.c;
            str = this.f1996a.j;
            amVar.a("kw", str);
            return new JSONObject(this.c.l());
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.f1996a.l = null;
        bkVar = this.f1996a.n;
        if (bkVar != null) {
            at atVar = new at(this.f1996a);
            if (this.c != null) {
                atVar.f1995a = true;
                atVar.b = this.c.d();
                atVar.c = this.c.e();
                atVar.d = this.c.i();
                atVar.e = this.c.b();
            }
            bkVar2 = this.f1996a.n;
            bkVar2.a(this.b, jSONObject, atVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.bk bkVar;
        com.baidu.tieba.frs.bk bkVar2;
        super.b();
        bkVar = this.f1996a.n;
        if (bkVar != null) {
            bkVar2 = this.f1996a.n;
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
        this.f1996a.l = null;
    }
}
