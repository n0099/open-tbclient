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
public class p extends BdAsyncTask<Boolean, o, o> {
    final /* synthetic */ o a;
    private com.baidu.tbadk.core.util.aq b;
    private o c;
    private volatile boolean d;
    private boolean e;

    private p(o oVar) {
        this.a = oVar;
        this.c = null;
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(o oVar, p pVar) {
        this(oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public o doInBackground(Boolean... boolArr) {
        Context context;
        Context context2;
        boolean booleanValue = boolArr[0].booleanValue();
        this.e = boolArr[1].booleanValue();
        if (booleanValue) {
            try {
                String b = com.baidu.tieba.util.k.b();
                if (b != null) {
                    context = this.a.e;
                    this.c = new o(context);
                    this.c.c(b);
                    publishProgress(this.c);
                    this.e = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                BdLog.e(e.getMessage());
            }
        }
        if (!this.d && this.a.b() != null) {
            this.b = new com.baidu.tbadk.core.util.aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/user/profile");
            this.b.a(SapiAccountManager.SESSION_UID, this.a.b());
            this.b.a("has_plist", "0");
            String i = this.b.i();
            if (this.b.a().b().b()) {
                context2 = this.a.e;
                this.c = new o(context2);
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
    public void onProgressUpdate(o... oVarArr) {
        com.baidu.adp.base.h hVar;
        boolean z = false;
        super.onProgressUpdate(oVarArr);
        o oVar = oVarArr[0];
        if (oVar != null) {
            this.a.a(oVar.a());
            z = true;
        }
        this.a.mLoadDataMode = 2;
        this.a.setErrorString(null);
        hVar = this.a.mLoadDataCallBack;
        hVar.a(Boolean.valueOf(z));
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        super.cancel();
        this.d = true;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.b = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(o oVar) {
        Context context;
        com.baidu.adp.base.h hVar;
        com.baidu.tbadk.editortool.aa aaVar;
        com.baidu.adp.base.h hVar2;
        super.onPostExecute(oVar);
        this.a.b = null;
        this.a.mLoadDataMode = 1;
        if (oVar != null) {
            this.a.j = true;
            this.a.a(oVar.a());
            aaVar = this.a.f;
            aaVar.e(oVar.a().getPortrait());
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(true);
            return;
        }
        this.a.j = false;
        if (this.b != null && this.e) {
            this.a.setErrorString(this.b.f());
        } else {
            o oVar2 = this.a;
            context = this.a.e;
            oVar2.setErrorString(context.getString(com.baidu.tieba.y.neterror));
        }
        hVar = this.a.mLoadDataCallBack;
        hVar.a(false);
    }
}
