package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask {
    final /* synthetic */ v a;
    private com.baidu.tieba.util.r b = null;
    private String c;
    private String d;
    private String e;
    private x f;

    public w(v vVar, String str, String str2, String str3) {
        this.a = vVar;
        this.f = new x(vVar);
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        try {
            this.b = new com.baidu.tieba.util.r(strArr[0]);
            this.b.a("fid", this.c);
            this.b.a("kw", this.d);
            this.b.a("is_like", this.e);
            this.b.d(true);
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
                        this.a.a(this.f);
                    } catch (Exception e) {
                        com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
                    }
                }
                if (this.b.c()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(j);
                        this.f.c = jSONObject2.optInt("num");
                        this.f.a = true;
                    } catch (Exception e2) {
                        com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e2.getMessage());
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            com.baidu.tieba.util.z.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e3.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
        }
        this.a.j = null;
        this.a.a(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.tieba.frs.ab abVar;
        com.baidu.tieba.frs.ab abVar2;
        this.a.j = null;
        this.a.a(false);
        if (this.b != null) {
            y yVar = new y(this.a);
            yVar.d = this.b.g();
            yVar.c = this.b.e();
            abVar = this.a.g;
            if (abVar != null) {
                abVar2 = this.a.g;
                abVar2.a(this.f, yVar);
            }
        }
    }
}
