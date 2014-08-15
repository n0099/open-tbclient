package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<String, String, Boolean> {
    ArrayList<com.baidu.tbadk.core.data.h> a;
    String b;
    final /* synthetic */ u c;
    private com.baidu.tbadk.core.util.ae d = null;
    private String e;
    private String f;
    private String g;
    private int h;

    public z(u uVar, String str, String str2, String str3, int i, String str4) {
        this.c = uVar;
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
        this.d = new com.baidu.tbadk.core.util.ae(strArr[0]);
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
        String h = this.d.h();
        if (this.d.a().b().b()) {
            if (this.h == 6) {
                try {
                    JSONArray optJSONArray = new JSONObject(h).optJSONArray("cates");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
                        hVar.a(optJSONArray.optJSONObject(i));
                        this.a.add(hVar);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
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
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        super.onPostExecute(bool);
        this.c.c = null;
        if (this.d == null) {
            hVar2 = this.c.mLoadDataCallBack;
            hVar2.a(null);
            return;
        }
        aa aaVar = new aa(this.c);
        aaVar.a = bool.booleanValue();
        if (bool.booleanValue()) {
            if (this.h == 6) {
                aaVar.c = this.a;
            }
        } else {
            aaVar.b = this.d.e();
        }
        hVar = this.c.mLoadDataCallBack;
        hVar.a(aaVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        if (this.d != null) {
            this.d.f();
        }
        this.c.c = null;
        super.cancel(true);
        hVar = this.c.mLoadDataCallBack;
        hVar.a(null);
    }
}
