package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bm f1389a;
    private com.baidu.tieba.util.v b;
    private volatile boolean c;
    private boolean d;

    private bo(bm bmVar) {
        this.f1389a = bmVar;
        this.b = null;
        this.c = false;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bo(bm bmVar, bo boVar) {
        this(bmVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public UserData a(Boolean... boolArr) {
        UserData userData;
        Exception e;
        String e2;
        boolean booleanValue = boolArr[0].booleanValue();
        this.d = boolArr[1].booleanValue();
        try {
            if (this.f1389a.b() && booleanValue && (e2 = DatabaseService.e()) != null) {
                UserData userData2 = new UserData();
                userData2.parserJson(e2);
                c(userData2);
                this.d = false;
            }
            if (!this.c && this.f1389a.a() != null) {
                this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/u/user/profile");
                this.b.a("uid", this.f1389a.a());
                this.b.a("need_post_count", "1");
                String j = this.b.j();
                if (this.b.c()) {
                    userData = new UserData();
                    try {
                        JSONObject optJSONObject = new JSONObject(j).optJSONObject("user");
                        userData.parserJson(optJSONObject);
                        if (this.f1389a.b()) {
                            DatabaseService.i(optJSONObject.toString());
                            return userData;
                        }
                        return userData;
                    } catch (Exception e3) {
                        e = e3;
                        com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.getMessage());
                        return userData;
                    }
                }
            }
            return null;
        } catch (Exception e4) {
            userData = null;
            e = e4;
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
            this.f1389a.a(userData);
            z = true;
        }
        this.f1389a.mLoadDataMode = 2;
        this.f1389a.setErrorString(null);
        eVar = this.f1389a.mLoadDataCallBack;
        eVar.a(Boolean.valueOf(z));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(UserData userData) {
        Context context;
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) userData);
        this.f1389a.n = null;
        if (userData != null) {
            this.f1389a.a(userData);
            this.f1389a.f().e(userData.getPortrait());
            this.f1389a.mLoadDataMode = 1;
            eVar2 = this.f1389a.mLoadDataCallBack;
            eVar2.a(true);
            return;
        }
        if (this.b != null && this.d) {
            this.f1389a.setErrorString(this.b.g());
        } else {
            bm bmVar = this.f1389a;
            context = this.f1389a.p;
            bmVar.setErrorString(context.getString(R.string.neterror));
        }
        this.f1389a.mLoadDataMode = 1;
        eVar = this.f1389a.mLoadDataCallBack;
        eVar.a(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1389a.n = null;
        eVar = this.f1389a.mLoadDataCallBack;
        eVar.a(false);
    }
}
