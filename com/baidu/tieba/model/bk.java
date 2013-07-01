package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bi f1040a;
    private com.baidu.tieba.util.r b;
    private volatile boolean c;
    private boolean d;

    private bk(bi biVar) {
        this.f1040a = biVar;
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
            if (this.f1040a.b() && booleanValue && (g = DatabaseService.g()) != null) {
                UserData userData2 = new UserData();
                userData2.parserJson(g);
                c(userData2);
                this.d = false;
            }
            if (!this.c && this.f1040a.a() != null) {
                this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/u/user/profile");
                this.b.a("uid", this.f1040a.a());
                String j = this.b.j();
                if (this.b.c()) {
                    userData = new UserData();
                    try {
                        JSONObject optJSONObject = new JSONObject(j).optJSONObject("user");
                        userData.parserJson(optJSONObject);
                        if (this.f1040a.b()) {
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
            this.f1040a.a(userData);
            z = true;
        }
        this.f1040a.mLoadDataMode = 2;
        this.f1040a.setErrorString(null);
        eVar = this.f1040a.mLoadDataCallBack;
        eVar.a(Boolean.valueOf(z));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(UserData userData) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) userData);
        this.f1040a.l = null;
        if (userData != null) {
            this.f1040a.a(userData);
            this.f1040a.e().d(userData.getPortrait());
            this.f1040a.mLoadDataMode = 1;
            eVar2 = this.f1040a.mLoadDataCallBack;
            eVar2.a(true);
            return;
        }
        if (this.b != null && this.d) {
            this.f1040a.setErrorString(this.b.g());
        } else {
            this.f1040a.setErrorString(null);
        }
        this.f1040a.mLoadDataMode = 1;
        eVar = this.f1040a.mLoadDataCallBack;
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
        this.f1040a.l = null;
        super.cancel(true);
        eVar = this.f1040a.mLoadDataCallBack;
        eVar.a(false);
    }
}
