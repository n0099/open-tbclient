package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask<Object, Integer, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ au f1907a;
    private int b;
    private com.baidu.tieba.util.ag c = null;

    public ax(au auVar, int i) {
        this.f1907a = auVar;
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
            this.c = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/f/frs/photo");
            StringBuilder sb = new StringBuilder();
            int size = this.f1907a.c().size();
            for (int i = this.b; i < size && i < this.b + 30; i++) {
                sb.append(this.f1907a.c().get(i));
                sb.append(",");
            }
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == ',') {
                sb.deleteCharAt(length - 1);
            }
            this.c.a("alb_ids", sb.toString());
            com.baidu.tieba.util.ag agVar = this.c;
            str = this.f1907a.j;
            agVar.a("kw", str);
            return new JSONObject(this.c.j());
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.ax axVar;
        com.baidu.tieba.frs.ax axVar2;
        super.a((ax) jSONObject);
        this.f1907a.l = null;
        axVar = this.f1907a.n;
        if (axVar != null) {
            aw awVar = new aw(this.f1907a);
            if (this.c != null) {
                awVar.f1906a = true;
                awVar.b = this.c.d();
                awVar.c = this.c.e();
                awVar.d = this.c.g();
                awVar.e = this.c.b();
            }
            axVar2 = this.f1907a.n;
            axVar2.a(this.b, jSONObject, awVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.ax axVar;
        com.baidu.tieba.frs.ax axVar2;
        super.b();
        axVar = this.f1907a.n;
        if (axVar != null) {
            axVar2 = this.f1907a.n;
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
        this.f1907a.l = null;
    }
}
