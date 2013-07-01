package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1070a;
    y b;
    final /* synthetic */ v c;
    private com.baidu.tieba.util.r d = null;
    private String e;
    private int f;

    public z(v vVar, String str, ArrayList arrayList, int i) {
        this.c = vVar;
        this.e = null;
        this.f = 3;
        this.f1070a = null;
        this.b = new y(vVar);
        this.e = str;
        this.f1070a = arrayList;
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
            this.d = new com.baidu.tieba.util.r(this.e);
            this.d.a(this.f1070a);
            String j = this.d.j();
            jSONObject = new JSONObject(j);
            try {
                if (this.d.c()) {
                    this.c.a(j);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.z.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
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
            this.b.f1069a = true;
            this.b.b = this.d.d();
            this.b.c = this.d.e();
            this.b.d = this.d.g();
            this.b.e = this.d.b();
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
            this.d.h();
        }
        acVar = this.c.f;
        if (acVar != null) {
            acVar2 = this.c.f;
            acVar2.a(this.f, null, null);
        }
    }
}
