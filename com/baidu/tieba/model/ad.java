package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<String, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ac f1391a;
    private com.baidu.tieba.util.z b = null;
    private String c;
    private String d;
    private String e;
    private ae f;

    public ad(ac acVar, String str, String str2, String str3) {
        this.f1391a = acVar;
        this.f = new ae(acVar);
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        try {
            this.b = new com.baidu.tieba.util.z(strArr[0]);
            this.b.a("fid", this.c);
            this.b.a("kw", this.d);
            this.b.a("is_like", this.e);
            this.b.e(true);
            String j = this.b.j();
            if (this.b.d()) {
                if (this.e.equals("0")) {
                    try {
                        JSONObject jSONObject = new JSONObject(j);
                        JSONObject optJSONObject = jSONObject.optJSONObject("like_data");
                        if (optJSONObject.optInt("is_success", 0) == 1) {
                            this.f.d = optJSONObject.optInt("level_id", 0);
                            this.f.e = optJSONObject.optString("level_name", "");
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_perm");
                            if (optJSONObject2 != null) {
                                this.f.f = optJSONObject2.optInt("cur_score", 0);
                                this.f.g = optJSONObject2.optInt("levelup_score", 0);
                            }
                            this.f.b = true;
                        }
                        this.f1391a.a(this.f);
                    } catch (Exception e) {
                        com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
                    }
                }
                if (this.b.c()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(j);
                        this.f.c = jSONObject2.optInt("num");
                        this.f.f1392a = true;
                    } catch (Exception e2) {
                        com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e2.getMessage());
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            com.baidu.tieba.util.av.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e3.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
        }
        this.f1391a.k = null;
        this.f1391a.a(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.tieba.frs.ac acVar;
        com.baidu.tieba.frs.ac acVar2;
        this.f1391a.k = null;
        this.f1391a.a(false);
        if (this.b != null) {
            af afVar = new af(this.f1391a);
            afVar.d = this.b.g();
            afVar.c = this.b.e();
            acVar = this.f1391a.h;
            if (acVar != null) {
                acVar2 = this.f1391a.h;
                acVar2.a(this.f, afVar);
            }
        }
    }
}
