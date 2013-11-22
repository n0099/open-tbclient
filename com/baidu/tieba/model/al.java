package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends BdAsyncTask<String, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1874a;
    private com.baidu.tieba.util.ap b = null;
    private String c;
    private String d;
    private String e;
    private am f;

    public al(ak akVar, String str, String str2, String str3) {
        this.f1874a = akVar;
        this.f = new am(this.f1874a);
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        try {
            this.b = new com.baidu.tieba.util.ap(strArr[0]);
            this.b.a("fid", this.c);
            this.b.a("kw", this.d);
            this.b.a("is_like", this.e);
            this.b.e(true);
            String l = this.b.l();
            if (this.b.d()) {
                if (this.e.equals(SocialConstants.FALSE)) {
                    try {
                        JSONObject jSONObject = new JSONObject(l);
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
                        this.f1874a.a(this.f);
                    } catch (Exception e) {
                        com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
                    }
                }
                if (this.b.c()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(l);
                        this.f.c = jSONObject2.optInt("num");
                        this.f.f1875a = true;
                    } catch (Exception e2) {
                        com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e2.getMessage());
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e3.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
        }
        this.f1874a.m = null;
        this.f1874a.a(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.tieba.frs.af afVar;
        com.baidu.tieba.frs.af afVar2;
        this.f1874a.m = null;
        this.f1874a.a(false);
        if (this.b != null) {
            an anVar = new an(this.f1874a);
            anVar.d = this.b.i();
            anVar.c = this.b.e();
            afVar = this.f1874a.j;
            if (afVar != null) {
                afVar2 = this.f1874a.j;
                afVar2.a(this.f, anVar);
            }
        }
    }
}
