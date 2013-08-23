package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1354a;
    private com.baidu.tieba.util.v b = null;
    private String c;
    private String d;
    private String e;
    private ac f;

    public ab(aa aaVar, String str, String str2, String str3) {
        this.f1354a = aaVar;
        this.f = new ac(aaVar);
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        try {
            this.b = new com.baidu.tieba.util.v(strArr[0]);
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
                        this.f1354a.a(this.f);
                    } catch (Exception e) {
                        com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.getMessage());
                    }
                }
                if (this.b.c()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(j);
                        this.f.c = jSONObject2.optInt("num");
                        this.f.f1355a = true;
                    } catch (Exception e2) {
                        com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e2.getMessage());
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e3.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
        }
        this.f1354a.j = null;
        this.f1354a.a(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.tieba.frs.ad adVar;
        com.baidu.tieba.frs.ad adVar2;
        this.f1354a.j = null;
        this.f1354a.a(false);
        if (this.b != null) {
            ad adVar3 = new ad(this.f1354a);
            adVar3.d = this.b.g();
            adVar3.c = this.b.e();
            adVar = this.f1354a.g;
            if (adVar != null) {
                adVar2 = this.f1354a.g;
                adVar2.a(this.f, adVar3);
            }
        }
    }
}
