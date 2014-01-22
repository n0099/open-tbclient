package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ ak a;
    private com.baidu.tieba.util.ax b = null;
    private String c;
    private String d;
    private String e;
    private am f;

    public al(ak akVar, String str, String str2, String str3) {
        this.a = akVar;
        this.f = new am(this.a);
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        try {
            this.b = new com.baidu.tieba.util.ax(strArr[0]);
            this.b.a("fid", this.c);
            this.b.a("kw", this.d);
            this.b.a("is_like", this.e);
            this.b.e(true);
            String m = this.b.m();
            if (this.b.e()) {
                if (this.e.equals(SocialConstants.FALSE)) {
                    try {
                        JSONObject jSONObject = new JSONObject(m);
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
                        this.a.a(this.f);
                    } catch (Exception e) {
                        com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.getMessage());
                    }
                }
                if (this.b.d()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(m);
                        this.f.c = jSONObject2.optInt("num");
                        this.f.a = true;
                    } catch (Exception e2) {
                        com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e2.getMessage());
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e3.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.k();
        }
        this.a.n = null;
        this.a.a(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.tieba.frs.aa aaVar;
        com.baidu.tieba.frs.aa aaVar2;
        this.a.n = null;
        this.a.a(false);
        if (this.b != null) {
            an anVar = new an(this.a);
            anVar.d = this.b.j();
            anVar.c = this.b.f();
            aaVar = this.a.k;
            if (aaVar != null) {
                aaVar2 = this.a.k;
                aaVar2.a(this.f, anVar);
            }
        }
    }
}
