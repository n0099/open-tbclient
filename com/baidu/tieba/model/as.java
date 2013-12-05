package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends BdAsyncTask<Object, Integer, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ar f1993a;
    private int b;
    private com.baidu.tieba.util.am c = null;

    public as(ar arVar, int i) {
        this.f1993a = arVar;
        this.b = 0;
        this.b = i;
        if (this.b < 1) {
            this.b = 1;
        }
        setSelfExecute(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public JSONObject a(Object... objArr) {
        JSONObject jSONObject;
        Exception e;
        String str;
        String str2;
        String str3;
        try {
            this.c = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/f/frs/photolist");
            str = this.f1993a.i;
            if (str != null) {
                com.baidu.tieba.util.am amVar = this.c;
                str3 = this.f1993a.i;
                amVar.a("st_type", str3);
            }
            com.baidu.tieba.util.am amVar2 = this.c;
            str2 = this.f1993a.j;
            amVar2.a("kw", str2);
            this.c.a("bs", String.valueOf(this.b));
            this.c.a("be", String.valueOf((this.b + 240) - 1));
            this.c.a("an", String.valueOf(30));
            String l = this.c.l();
            jSONObject = new JSONObject(l);
            try {
                if (this.c.c()) {
                    this.f1993a.a(l);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
                return jSONObject;
            }
        } catch (Exception e3) {
            jSONObject = null;
            e = e3;
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.bk bkVar;
        com.baidu.tieba.frs.bk bkVar2;
        super.a((as) jSONObject);
        this.f1993a.k = null;
        bkVar = this.f1993a.m;
        if (bkVar != null) {
            at atVar = new at(this.f1993a);
            if (this.c != null) {
                atVar.f1994a = true;
                atVar.b = this.c.d();
                atVar.c = this.c.e();
                atVar.d = this.c.i();
                atVar.e = this.c.b();
            }
            bkVar2 = this.f1993a.m;
            bkVar2.a(this.b, jSONObject, atVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.bk bkVar;
        com.baidu.tieba.frs.bk bkVar2;
        super.b();
        bkVar = this.f1993a.m;
        if (bkVar != null) {
            bkVar2 = this.f1993a.m;
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
        this.f1993a.k = null;
    }
}
