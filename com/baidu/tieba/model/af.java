package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ac f1012a;
    private int b;
    private com.baidu.tieba.util.r c = null;

    public af(ac acVar, int i) {
        this.f1012a = acVar;
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
            this.c = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/f/frs/photo");
            StringBuilder sb = new StringBuilder();
            int size = this.f1012a.c().size();
            for (int i = this.b; i < size && i < this.b + 30; i++) {
                sb.append((String) this.f1012a.c().get(i));
                sb.append(",");
            }
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == ',') {
                sb.deleteCharAt(length - 1);
            }
            this.c.a("alb_ids", sb.toString());
            com.baidu.tieba.util.r rVar = this.c;
            str = this.f1012a.j;
            rVar.a("kw", str);
            return new JSONObject(this.c.j());
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.f1012a.l = null;
        awVar = this.f1012a.n;
        if (awVar != null) {
            ae aeVar = new ae(this.f1012a);
            if (this.c != null) {
                aeVar.f1011a = true;
                aeVar.b = this.c.d();
                aeVar.c = this.c.e();
                aeVar.d = this.c.g();
                aeVar.e = this.c.b();
            }
            awVar2 = this.f1012a.n;
            awVar2.a(this.b, jSONObject, aeVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.aw awVar;
        com.baidu.tieba.frs.aw awVar2;
        super.b();
        awVar = this.f1012a.n;
        if (awVar != null) {
            awVar2 = this.f1012a.n;
            awVar2.a(0);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.h();
            this.c = null;
        }
        this.f1012a.l = null;
    }
}
