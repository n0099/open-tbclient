package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1332a;
    private int b;
    private com.baidu.tieba.util.u c = null;

    public an(ak akVar, int i) {
        this.f1332a = akVar;
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
            this.c = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/f/frs/photo");
            StringBuilder sb = new StringBuilder();
            int size = this.f1332a.c().size();
            for (int i = this.b; i < size && i < this.b + 30; i++) {
                sb.append((String) this.f1332a.c().get(i));
                sb.append(",");
            }
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == ',') {
                sb.deleteCharAt(length - 1);
            }
            this.c.a("alb_ids", sb.toString());
            com.baidu.tieba.util.u uVar = this.c;
            str = this.f1332a.j;
            uVar.a("kw", str);
            return new JSONObject(this.c.k());
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.aw awVar;
        com.baidu.tieba.frs.aw awVar2;
        super.a((Object) jSONObject);
        this.f1332a.l = null;
        awVar = this.f1332a.n;
        if (awVar != null) {
            am amVar = new am(this.f1332a);
            if (this.c != null) {
                amVar.f1331a = true;
                amVar.b = this.c.e();
                amVar.c = this.c.f();
                amVar.d = this.c.h();
                amVar.e = this.c.c();
            }
            awVar2 = this.f1332a.n;
            awVar2.a(this.b, jSONObject, amVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.aw awVar;
        com.baidu.tieba.frs.aw awVar2;
        super.b();
        awVar = this.f1332a.n;
        if (awVar != null) {
            awVar2 = this.f1332a.n;
            awVar2.a(0);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.i();
            this.c = null;
        }
        this.f1332a.l = null;
    }
}
