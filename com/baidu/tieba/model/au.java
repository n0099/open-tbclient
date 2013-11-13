package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends BdAsyncTask<Object, Integer, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ar f1901a;
    private int b;
    private com.baidu.tieba.util.ap c = null;

    public au(ar arVar, int i) {
        this.f1901a = arVar;
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
            this.c = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/f/frs/photo");
            StringBuilder sb = new StringBuilder();
            int size = this.f1901a.c().size();
            for (int i = this.b; i < size && i < this.b + 30; i++) {
                sb.append(this.f1901a.c().get(i));
                sb.append(",");
            }
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == ',') {
                sb.deleteCharAt(length - 1);
            }
            this.c.a("alb_ids", sb.toString());
            com.baidu.tieba.util.ap apVar = this.c;
            str = this.f1901a.j;
            apVar.a("kw", str);
            return new JSONObject(this.c.j());
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.f1901a.l = null;
        bkVar = this.f1901a.n;
        if (bkVar != null) {
            at atVar = new at(this.f1901a);
            if (this.c != null) {
                atVar.f1900a = true;
                atVar.b = this.c.d();
                atVar.c = this.c.e();
                atVar.d = this.c.g();
                atVar.e = this.c.b();
            }
            bkVar2 = this.f1901a.n;
            bkVar2.a(this.b, jSONObject, atVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.bk bkVar;
        com.baidu.tieba.frs.bk bkVar2;
        super.b();
        bkVar = this.f1901a.n;
        if (bkVar != null) {
            bkVar2 = this.f1901a.n;
            bkVar2.a(0);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.h();
            this.c = null;
        }
        this.f1901a.l = null;
    }
}
