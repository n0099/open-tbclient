package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa extends BdAsyncTask<String, String, Boolean> {
    ArrayList<com.baidu.tbadk.core.data.g> a;
    String b;
    final /* synthetic */ v c;
    private com.baidu.tbadk.core.util.ak d = null;
    private String e;
    private String f;
    private String g;
    private int h;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        com.baidu.adp.a.h hVar;
        com.baidu.adp.a.h hVar2;
        Boolean bool2 = bool;
        super.a((aa) bool2);
        this.c.c = null;
        if (this.d == null) {
            hVar2 = this.c.mLoadDataCallBack;
            hVar2.a(null);
            return;
        }
        ab abVar = new ab(this.c);
        abVar.a = bool2.booleanValue();
        if (!bool2.booleanValue()) {
            abVar.b = this.d.f();
        } else if (this.h == 6) {
            abVar.c = this.a;
        }
        hVar = this.c.mLoadDataCallBack;
        hVar.a(abVar);
    }

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
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        this.d = new com.baidu.tbadk.core.util.ak(strArr[0]);
        this.d.a("word", this.f);
        if (this.h != 6) {
            this.d.a("fid", this.e);
            this.d.a("z", this.g);
            if (this.h == 4) {
                this.d.a("ntn", "set");
            } else if (this.h != 5 && this.h == 2) {
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
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.h hVar;
        if (this.d != null) {
            this.d.g();
        }
        this.c.c = null;
        super.cancel(true);
        hVar = this.c.mLoadDataCallBack;
        hVar.a(null);
    }
}
