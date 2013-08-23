package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1365a;
    private int b;
    private com.baidu.tieba.util.v c = null;

    public an(ak akVar, int i) {
        this.f1365a = akVar;
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
            this.c = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/f/frs/photo");
            StringBuilder sb = new StringBuilder();
            int size = this.f1365a.c().size();
            for (int i = this.b; i < size && i < this.b + 30; i++) {
                sb.append((String) this.f1365a.c().get(i));
                sb.append(",");
            }
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == ',') {
                sb.deleteCharAt(length - 1);
            }
            this.c.a("alb_ids", sb.toString());
            com.baidu.tieba.util.v vVar = this.c;
            str = this.f1365a.j;
            vVar.a("kw", str);
            return new JSONObject(this.c.j());
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.ay ayVar;
        com.baidu.tieba.frs.ay ayVar2;
        super.a((Object) jSONObject);
        this.f1365a.l = null;
        ayVar = this.f1365a.n;
        if (ayVar != null) {
            am amVar = new am(this.f1365a);
            if (this.c != null) {
                amVar.f1364a = true;
                amVar.b = this.c.d();
                amVar.c = this.c.e();
                amVar.d = this.c.g();
                amVar.e = this.c.b();
            }
            ayVar2 = this.f1365a.n;
            ayVar2.a(this.b, jSONObject, amVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.ay ayVar;
        com.baidu.tieba.frs.ay ayVar2;
        super.b();
        ayVar = this.f1365a.n;
        if (ayVar != null) {
            ayVar2 = this.f1365a.n;
            ayVar2.a(0);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.h();
            this.c = null;
        }
        this.f1365a.l = null;
    }
}
