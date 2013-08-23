package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1357a;
    ad b;
    final /* synthetic */ aa c;
    private com.baidu.tieba.util.v d = null;
    private String e;
    private String f;
    private int g;

    public ae(aa aaVar, String str, ArrayList arrayList, int i, String str2) {
        this.c = aaVar;
        this.e = null;
        this.f = null;
        this.g = 3;
        this.f1357a = null;
        this.b = new ad(aaVar);
        this.e = str;
        this.f = str2;
        this.f1357a = arrayList;
        this.g = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.ae aeVar;
        com.baidu.tieba.frs.ae aeVar2;
        aeVar = this.c.f;
        if (aeVar != null) {
            aeVar2 = this.c.f;
            aeVar2.a(this.g);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public JSONObject a(Object... objArr) {
        JSONObject jSONObject;
        Exception e;
        boolean z;
        com.baidu.tieba.data.v vVar;
        com.baidu.tieba.data.v vVar2;
        try {
            if (p.a().a(this.f)) {
                c((Object[]) new aa[]{p.a().b()});
            }
            this.d = new com.baidu.tieba.util.v(this.e);
            this.d.a(this.f1357a);
            String j = this.d.j();
            jSONObject = new JSONObject(j);
            try {
                if (this.d.c()) {
                    this.c.a(j);
                    z = this.c.k;
                    if (z) {
                        vVar = this.c.f1353a;
                        if (vVar != null) {
                            p a2 = p.a();
                            vVar2 = this.c.f1353a;
                            a2.a(vVar2.b(), j);
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.aq.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
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
    /* renamed from: a */
    public void b(aa... aaVarArr) {
        com.baidu.tieba.frs.ae aeVar;
        com.baidu.tieba.frs.ae aeVar2;
        aeVar = this.c.f;
        if (aeVar != null) {
            aeVar2 = this.c.f;
            aeVar2.a(aaVarArr.length > 0 ? aaVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.ae aeVar;
        com.baidu.tieba.frs.ae aeVar2;
        if (this.d != null) {
            this.b.f1356a = true;
            this.b.b = this.d.d();
            this.b.c = this.d.e();
            this.b.d = this.d.g();
            this.b.e = this.d.b();
        }
        aeVar = this.c.f;
        if (aeVar != null) {
            aeVar2 = this.c.f;
            aeVar2.a(this.g, jSONObject, this.b);
        }
        this.c.i = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.tieba.frs.ae aeVar;
        com.baidu.tieba.frs.ae aeVar2;
        super.cancel(true);
        if (this.d != null) {
            this.d.h();
        }
        aeVar = this.c.f;
        if (aeVar != null) {
            aeVar2 = this.c.f;
            aeVar2.a(this.g, null, null);
        }
    }
}
