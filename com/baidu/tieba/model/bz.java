package com.baidu.tieba.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends BdAsyncTask<Boolean, UserData, UserData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bw f1929a;
    private com.baidu.tieba.util.ag b;
    private volatile boolean c;
    private boolean d;

    private bz(bw bwVar) {
        this.f1929a = bwVar;
        this.b = null;
        this.c = false;
        this.d = false;
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
            if (this.f1929a.b() && booleanValue && (e2 = DatabaseService.e()) != null) {
                UserData userData2 = new UserData();
                userData2.parserJson(e2);
                c((Object[]) new UserData[]{userData2});
                this.d = false;
            }
        } catch (Exception e3) {
            userData = null;
            e = e3;
        }
        if (!this.c && this.f1929a.a() != null) {
            this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/u/user/profile");
            this.b.a("uid", this.f1929a.a());
            this.b.a("need_post_count", SocialConstants.TRUE);
            String j = this.b.j();
            if (this.b.c()) {
                userData = new UserData();
                try {
                    JSONObject optJSONObject = new JSONObject(j).optJSONObject("user");
                    userData.parserJson(optJSONObject);
                    if (this.f1929a.b()) {
                        DatabaseService.i(optJSONObject.toString());
                        AccountData G = TiebaApplication.G();
                        if (G == null) {
                            return null;
                        }
                        if (!TextUtils.isEmpty(userData.getPortrait())) {
                            DatabaseService.c(G.getAccount(), userData.getPortrait());
                            G.setPortrait(userData.getPortrait());
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
                    return userData;
                }
                return userData;
            }
        }
        userData = null;
        return userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(UserData... userDataArr) {
        com.baidu.adp.a.g gVar;
        boolean z = false;
        super.b((Object[]) userDataArr);
        UserData userData = userDataArr[0];
        if (userData != null) {
            this.f1929a.a(userData);
            z = true;
        }
        this.f1929a.mLoadDataMode = 2;
        this.f1929a.setErrorString(null);
        gVar = this.f1929a.mLoadDataCallBack;
        gVar.a(Boolean.valueOf(z));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(UserData userData) {
        Context context;
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((bz) userData);
        this.f1929a.m = null;
        if (userData != null) {
            this.f1929a.a(userData);
            this.f1929a.e().e(userData.getPortrait());
            this.f1929a.mLoadDataMode = 1;
            gVar2 = this.f1929a.mLoadDataCallBack;
            gVar2.a(true);
            return;
        }
        if (this.b != null && this.d) {
            this.f1929a.setErrorString(this.b.g());
        } else {
            bw bwVar = this.f1929a;
            context = this.f1929a.o;
            bwVar.setErrorString(context.getString(R.string.neterror));
        }
        this.f1929a.mLoadDataMode = 1;
        gVar = this.f1929a.mLoadDataCallBack;
        gVar.a(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1929a.m = null;
        gVar = this.f1929a.mLoadDataCallBack;
        gVar.a(false);
    }
}
