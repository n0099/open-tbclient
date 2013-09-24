package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Object, ac, JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<BasicNameValuePair> f1394a;
    af b;
    final /* synthetic */ ac c;
    private com.baidu.tieba.util.z d = null;
    private String e;
    private String f;
    private int g;

    public ag(ac acVar, String str, ArrayList<BasicNameValuePair> arrayList, int i, String str2) {
        this.c = acVar;
        this.e = null;
        this.f = null;
        this.g = 3;
        this.f1394a = null;
        this.b = new af(acVar);
        this.e = str;
        this.f = str2;
        this.f1394a = arrayList;
        this.g = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.frs.ad adVar;
        com.baidu.tieba.frs.ad adVar2;
        adVar = this.c.g;
        if (adVar != null) {
            adVar2 = this.c.g;
            adVar2.a(this.g);
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
        String j;
        boolean z2;
        com.baidu.tieba.data.v vVar;
        com.baidu.tieba.data.v vVar2;
        try {
            z = this.c.l;
            if (z && r.a().a(this.f)) {
                c((Object[]) new ac[]{r.a().b()});
            }
            this.d = new com.baidu.tieba.util.z(this.e);
            this.d.a(this.f1394a);
            j = this.d.j();
            jSONObject = new JSONObject(j);
        } catch (Exception e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            if (this.d.c()) {
                this.c.a(j);
                z2 = this.c.l;
                if (z2) {
                    vVar = this.c.f1390a;
                    if (vVar != null) {
                        r a2 = r.a();
                        vVar2 = this.c.f1390a;
                        a2.a(vVar2.b(), j);
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            com.baidu.tieba.util.av.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
            return jSONObject;
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(ac... acVarArr) {
        com.baidu.tieba.frs.ad adVar;
        com.baidu.tieba.frs.ad adVar2;
        adVar = this.c.g;
        if (adVar != null) {
            adVar2 = this.c.g;
            adVar2.a(acVarArr.length > 0 ? acVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.ad adVar;
        com.baidu.tieba.frs.ad adVar2;
        if (this.d != null) {
            this.b.f1393a = true;
            this.b.b = this.d.d();
            this.b.c = this.d.e();
            this.b.d = this.d.g();
            this.b.e = this.d.b();
        }
        adVar = this.c.g;
        if (adVar != null) {
            adVar2 = this.c.g;
            adVar2.a(this.g, jSONObject, this.b);
        }
        this.c.j = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.tieba.frs.ad adVar;
        com.baidu.tieba.frs.ad adVar2;
        super.cancel(true);
        if (this.d != null) {
            this.d.h();
        }
        adVar = this.c.g;
        if (adVar != null) {
            adVar2 = this.c.g;
            adVar2.a(this.g, null, null);
        }
    }
}
