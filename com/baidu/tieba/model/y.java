package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1387a;
    String b;
    final /* synthetic */ t c;
    private com.baidu.tieba.util.u d = null;
    private String e;
    private String f;
    private String g;
    private int h;

    public y(t tVar, String str, String str2, String str3, int i, String str4) {
        this.c = tVar;
        this.f1387a = null;
        this.b = null;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = i;
        this.b = str4;
        this.f1387a = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        this.d = new com.baidu.tieba.util.u(strArr[0]);
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
        String k = this.d.k();
        if (this.d.d()) {
            if (this.h == 6) {
                try {
                    JSONArray optJSONArray = new JSONObject(k).optJSONArray("cates");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        com.baidu.tieba.data.y yVar = new com.baidu.tieba.data.y();
                        yVar.a(optJSONArray.optJSONObject(i));
                        this.f1387a.add(yVar);
                    }
                } catch (Exception e) {
                    com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
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
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) bool);
        this.c.c = null;
        if (this.d == null) {
            eVar2 = this.c.mLoadDataCallBack;
            eVar2.a(null);
            return;
        }
        z zVar = new z(this.c);
        zVar.f1388a = bool.booleanValue();
        if (bool.booleanValue()) {
            if (this.h == 6) {
                zVar.c = this.f1387a;
            }
        } else {
            zVar.b = this.d.h();
        }
        eVar = this.c.mLoadDataCallBack;
        eVar.a(zVar);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.d != null) {
            this.d.i();
        }
        this.c.c = null;
        super.cancel(true);
        eVar = this.c.mLoadDataCallBack;
        eVar.a(null);
    }
}
