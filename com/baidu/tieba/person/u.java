package com.baidu.tieba.person;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BdAsyncTask<Boolean, t, t> {
    final /* synthetic */ t a;
    private com.baidu.tbadk.core.util.al b;
    private t c;
    private volatile boolean d;
    private boolean e;

    private u(t tVar) {
        this.a = tVar;
        this.c = null;
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(t tVar, u uVar) {
        this(tVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public t doInBackground(Boolean... boolArr) {
        Context context;
        Context context2;
        boolean booleanValue = boolArr[0].booleanValue();
        this.e = boolArr[1].booleanValue();
        if (booleanValue) {
            try {
                String b = com.baidu.tieba.util.k.b();
                if (b != null) {
                    context = this.a.e;
                    this.c = new t(context);
                    this.c.c(b);
                    publishProgress(this.c);
                    this.e = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
            }
        }
        if (!this.d && this.a.b() != null) {
            this.b = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/user/profile");
            this.b.a(SapiAccountManager.SESSION_UID, this.a.b());
            this.b.a("has_plist", "0");
            String i = this.b.i();
            if (this.b.a().b().b()) {
                context2 = this.a.e;
                this.c = new t(context2);
                this.c.c(i);
                if (this.c.a() != null) {
                    com.baidu.tieba.util.k.c(i);
                    AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                    if (currentAccountObj == null) {
                        return null;
                    }
                    if (!TextUtils.isEmpty(this.c.a().getPortrait())) {
                        com.baidu.tbadk.core.account.a.a(currentAccountObj.getAccount(), this.c.a().getPortrait());
                        currentAccountObj.setPortrait(this.c.a().getPortrait());
                    }
                }
            }
        }
        return this.c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(t... tVarArr) {
        com.baidu.adp.base.e eVar;
        boolean z = false;
        super.onProgressUpdate(tVarArr);
        t tVar = tVarArr[0];
        if (tVar != null) {
            this.a.a(tVar.a());
            z = true;
        }
        this.a.mLoadDataMode = 2;
        this.a.setErrorString(null);
        eVar = this.a.mLoadDataCallBack;
        eVar.a(Boolean.valueOf(z));
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.e eVar;
        super.cancel();
        this.d = true;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.b = null;
        eVar = this.a.mLoadDataCallBack;
        eVar.a(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(t tVar) {
        Context context;
        com.baidu.adp.base.e eVar;
        com.baidu.tbadk.editortool.ab abVar;
        com.baidu.adp.base.e eVar2;
        super.onPostExecute(tVar);
        this.a.b = null;
        this.a.mLoadDataMode = 1;
        if (tVar != null) {
            this.a.k = true;
            this.a.a(tVar.a());
            abVar = this.a.f;
            abVar.e(tVar.a().getPortrait());
            eVar2 = this.a.mLoadDataCallBack;
            eVar2.a(true);
            return;
        }
        this.a.k = false;
        if (this.b != null && this.e) {
            this.a.setErrorString(this.b.f());
        } else {
            t tVar2 = this.a;
            context = this.a.e;
            tVar2.setErrorString(context.getString(com.baidu.tieba.y.neterror));
        }
        eVar = this.a.mLoadDataCallBack;
        eVar.a(false);
    }
}
