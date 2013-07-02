package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends BdAsyncTask {
    final /* synthetic */ bi a;
    private com.baidu.tieba.util.r b;
    private volatile boolean c;
    private boolean d;

    private bk(bi biVar) {
        this.a = biVar;
        this.b = null;
        this.c = false;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bk(bi biVar, bk bkVar) {
        this(biVar);
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
            if (this.a.b() && booleanValue && (g = DatabaseService.g()) != null) {
                UserData userData2 = new UserData();
                userData2.parserJson(g);
                c(userData2);
                this.d = false;
            }
            if (!this.c && this.a.a() != null) {
                this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/u/user/profile");
                this.b.a("uid", this.a.a());
                String j = this.b.j();
                if (this.b.c()) {
                    userData = new UserData();
                    try {
                        JSONObject optJSONObject = new JSONObject(j).optJSONObject("user");
                        userData.parserJson(optJSONObject);
                        if (this.a.b()) {
                            DatabaseService.j(optJSONObject.toString());
                            return userData;
                        }
                        return userData;
                    } catch (Exception e2) {
                        e = e2;
                        com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
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
            this.a.a(userData);
            z = true;
        }
        this.a.mLoadDataMode = 2;
        this.a.setErrorString(null);
        eVar = this.a.mLoadDataCallBack;
        eVar.a(Boolean.valueOf(z));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(UserData userData) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) userData);
        this.a.l = null;
        if (userData != null) {
            this.a.a(userData);
            this.a.e().d(userData.getPortrait());
            this.a.mLoadDataMode = 1;
            eVar2 = this.a.mLoadDataCallBack;
            eVar2.a(true);
            return;
        }
        if (this.b != null && this.d) {
            this.a.setErrorString(this.b.g());
        } else {
            this.a.setErrorString(null);
        }
        this.a.mLoadDataMode = 1;
        eVar = this.a.mLoadDataCallBack;
        eVar.a(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        this.c = true;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.a.l = null;
        super.cancel(true);
        eVar = this.a.mLoadDataCallBack;
        eVar.a(false);
    }
}
