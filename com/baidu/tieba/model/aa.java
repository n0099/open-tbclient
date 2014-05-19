package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask<String, String, Boolean> {
    ArrayList<com.baidu.tbadk.core.data.g> a;
    String b;
    final /* synthetic */ v c;
    private com.baidu.tbadk.core.util.al d = null;
    private String e;
    private String f;
    private String g;
    private int h;

    public aa(v vVar, String str, String str2, String str3, int i, String str4) {
        this.c = vVar;
        this.a = null;
        this.b = null;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = i;
        this.b = str4;
        this.a = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        this.d = new com.baidu.tbadk.core.util.al(strArr[0]);
        this.d.a("word", this.f);
        if (this.h != 6) {
            this.d.a("fid", this.e);
            this.d.a("z", this.g);
            if (this.h == 4) {
                this.d.a("ntn", "set");
            } else if (this.h == 5) {
                this.d.a("ntn", "");
            } else if (this.h == 2) {
                this.d.a("ntn", "set");
                this.d.a("cid", this.b);
            } else {
                this.d.a("ntn", "");
            }
        }
        this.d.a().a().a = true;
        String i = this.d.i();
        if (this.d.a().b().b()) {
            if (this.h == 6) {
                try {
                    JSONArray optJSONArray = new JSONObject(i).optJSONArray("cates");
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        com.baidu.tbadk.core.data.g gVar = new com.baidu.tbadk.core.data.g();
                        gVar.a(optJSONArray.optJSONObject(i2));
                        this.a.add(gVar);
                    }
                } catch (Exception e) {
                    BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        com.baidu.adp.base.g gVar;
        com.baidu.adp.base.g gVar2;
        super.onPostExecute(bool);
        this.c.c = null;
        if (this.d == null) {
            gVar2 = this.c.mLoadDataCallBack;
            gVar2.a(null);
            return;
        }
        ab abVar = new ab(this.c);
        abVar.a = bool.booleanValue();
        if (bool.booleanValue()) {
            if (this.h == 6) {
                abVar.c = this.a;
            }
        } else {
            abVar.b = this.d.f();
        }
        gVar = this.c.mLoadDataCallBack;
        gVar.a(abVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.g gVar;
        if (this.d != null) {
            this.d.g();
        }
        this.c.c = null;
        super.cancel(true);
        gVar = this.c.mLoadDataCallBack;
        gVar.a(null);
    }
}
