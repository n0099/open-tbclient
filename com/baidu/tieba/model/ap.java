package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends BdAsyncTask<Object, Integer, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ am f1402a;
    private int b;
    private com.baidu.tieba.util.z c = null;

    public ap(am amVar, int i) {
        this.f1402a = amVar;
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
            this.c = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/f/frs/photo");
            StringBuilder sb = new StringBuilder();
            int size = this.f1402a.c().size();
            for (int i = this.b; i < size && i < this.b + 30; i++) {
                sb.append(this.f1402a.c().get(i));
                sb.append(",");
            }
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == ',') {
                sb.deleteCharAt(length - 1);
            }
            this.c.a("alb_ids", sb.toString());
            com.baidu.tieba.util.z zVar = this.c;
            str = this.f1402a.j;
            zVar.a("kw", str);
            return new JSONObject(this.c.j());
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.ax axVar;
        com.baidu.tieba.frs.ax axVar2;
        super.a((ap) jSONObject);
        this.f1402a.l = null;
        axVar = this.f1402a.n;
        if (axVar != null) {
            ao aoVar = new ao(this.f1402a);
            if (this.c != null) {
                aoVar.f1401a = true;
                aoVar.b = this.c.d();
                aoVar.c = this.c.e();
                aoVar.d = this.c.g();
                aoVar.e = this.c.b();
            }
            axVar2 = this.f1402a.n;
            axVar2.a(this.b, jSONObject, aoVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.ax axVar;
        com.baidu.tieba.frs.ax axVar2;
        super.b();
        axVar = this.f1402a.n;
        if (axVar != null) {
            axVar2 = this.f1402a.n;
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
        this.f1402a.l = null;
    }
}
