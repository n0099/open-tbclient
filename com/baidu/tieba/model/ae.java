package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1322a;
    ad b;
    final /* synthetic */ aa c;
    private com.baidu.tieba.util.u d = null;
    private String e;
    private int f;

    public ae(aa aaVar, String str, ArrayList arrayList, int i) {
        this.c = aaVar;
        this.e = null;
        this.f = 3;
        this.f1322a = null;
        this.b = new ad(aaVar);
        this.e = str;
        this.f1322a = arrayList;
        this.f = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.ac acVar;
        com.baidu.tieba.frs.ac acVar2;
        acVar = this.c.f;
        if (acVar != null) {
            acVar2 = this.c.f;
            acVar2.a(this.f);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public JSONObject a(Object... objArr) {
        JSONObject jSONObject;
        Exception e;
        try {
            this.d = new com.baidu.tieba.util.u(this.e);
            this.d.a(this.f1322a);
            String k = this.d.k();
            jSONObject = new JSONObject(k);
            try {
                if (this.d.d()) {
                    this.c.a(k);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.aj.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
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
        com.baidu.tieba.frs.ac acVar;
        com.baidu.tieba.frs.ac acVar2;
        if (this.d != null) {
            this.b.f1321a = true;
            this.b.b = this.d.e();
            this.b.c = this.d.f();
            this.b.d = this.d.h();
            this.b.e = this.d.c();
        }
        acVar = this.c.f;
        if (acVar != null) {
            acVar2 = this.c.f;
            acVar2.a(this.f, jSONObject, this.b);
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
        com.baidu.tieba.frs.ac acVar;
        com.baidu.tieba.frs.ac acVar2;
        super.cancel(true);
        if (this.d != null) {
            this.d.i();
        }
        acVar = this.c.f;
        if (acVar != null) {
            acVar2 = this.c.f;
            acVar2.a(this.f, null, null);
        }
    }
}
