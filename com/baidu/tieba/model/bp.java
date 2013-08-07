package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1355a;
    private com.baidu.tieba.util.u b;
    private volatile boolean c;
    private boolean d;

    private bp(bn bnVar) {
        this.f1355a = bnVar;
        this.b = null;
        this.c = false;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bp(bn bnVar, bp bpVar) {
        this(bnVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public UserData a(Boolean... boolArr) {
        UserData userData;
        Exception e;
        String g;
        boolean booleanValue = boolArr[0].booleanValue();
        this.d = boolArr[1].booleanValue();
        try {
            if (this.f1355a.b() && booleanValue && (g = DatabaseService.g()) != null) {
                UserData userData2 = new UserData();
                userData2.parserJson(g);
                c(userData2);
                this.d = false;
            }
            if (!this.c && this.f1355a.a() != null) {
                this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/u/user/profile");
                this.b.a("uid", this.f1355a.a());
                String k = this.b.k();
                if (this.b.d()) {
                    userData = new UserData();
                    try {
                        JSONObject optJSONObject = new JSONObject(k).optJSONObject("user");
                        userData.parserJson(optJSONObject);
                        if (this.f1355a.b()) {
                            DatabaseService.j(optJSONObject.toString());
                            return userData;
                        }
                        return userData;
                    } catch (Exception e2) {
                        e = e2;
                        com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
                        return userData;
                    }
                }
            }
            return null;
        } catch (Exception e3) {
            userData = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(UserData... userDataArr) {
        com.baidu.adp.a.e eVar;
        boolean z = false;
        super.b((Object[]) userDataArr);
        UserData userData = userDataArr[0];
        if (userData != null) {
            this.f1355a.a(userData);
            z = true;
        }
        this.f1355a.mLoadDataMode = 2;
        this.f1355a.setErrorString(null);
        eVar = this.f1355a.mLoadDataCallBack;
        eVar.a(Boolean.valueOf(z));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(UserData userData) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) userData);
        this.f1355a.l = null;
        if (userData != null) {
            this.f1355a.a(userData);
            this.f1355a.e().e(userData.getPortrait());
            this.f1355a.mLoadDataMode = 1;
            eVar2 = this.f1355a.mLoadDataCallBack;
            eVar2.a(true);
            return;
        }
        if (this.b != null && this.d) {
            this.f1355a.setErrorString(this.b.h());
        } else {
            this.f1355a.setErrorString(null);
        }
        this.f1355a.mLoadDataMode = 1;
        eVar = this.f1355a.mLoadDataCallBack;
        eVar.a(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.i();
            this.b = null;
        }
        this.f1355a.l = null;
        eVar = this.f1355a.mLoadDataCallBack;
        eVar.a(false);
    }
}
