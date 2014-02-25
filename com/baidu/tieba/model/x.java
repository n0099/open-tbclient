package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<String, String, Boolean> {
    ArrayList<com.baidu.tieba.data.z> a;
    String b;
    final /* synthetic */ s c;
    private com.baidu.tieba.util.ba d = null;
    private String e;
    private String f;
    private String g;
    private int h;

    public x(s sVar, String str, String str2, String str3, int i, String str4) {
        this.c = sVar;
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
    public Boolean a(String... strArr) {
        this.d = new com.baidu.tieba.util.ba(strArr[0]);
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
        this.d.e(true);
        String m = this.d.m();
        if (this.d.d()) {
            if (this.h == 6) {
                try {
                    JSONArray optJSONArray = new JSONObject(m).optJSONArray("cates");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        com.baidu.tieba.data.z zVar = new com.baidu.tieba.data.z();
                        zVar.a(optJSONArray.optJSONObject(i));
                        this.a.add(zVar);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((x) bool);
        this.c.c = null;
        if (this.d == null) {
            gVar2 = this.c.mLoadDataCallBack;
            gVar2.a(null);
            return;
        }
        y yVar = new y(this.c);
        yVar.a = bool.booleanValue();
        if (bool.booleanValue()) {
            if (this.h == 6) {
                yVar.c = this.a;
            }
        } else {
            yVar.b = this.d.j();
        }
        gVar = this.c.mLoadDataCallBack;
        gVar.a(yVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.d != null) {
            this.d.k();
        }
        this.c.c = null;
        super.cancel(true);
        gVar = this.c.mLoadDataCallBack;
        gVar.a(null);
    }
}
