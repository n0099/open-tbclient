package com.baidu.tieba.person;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Boolean, ae, ae> {
    final /* synthetic */ ae a;
    private com.baidu.tieba.util.at b;
    private ae c;
    private volatile boolean d;
    private boolean e;

    private ag(ae aeVar) {
        this.a = aeVar;
        this.c = null;
        this.d = false;
        this.e = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ae a(Boolean... boolArr) {
        Context context;
        Context context2;
        boolean booleanValue = boolArr[0].booleanValue();
        this.e = boolArr[1].booleanValue();
        if (booleanValue) {
            try {
                String e = DatabaseService.e();
                if (e != null) {
                    context = this.a.e;
                    this.c = new ae(context);
                    this.c.c(e);
                    c((Object[]) new ae[]{this.c});
                    this.e = false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                com.baidu.tieba.util.bo.b(getClass().getName(), "doInBackground", e2.getMessage());
            }
        }
        if (!this.d && this.a.b() != null) {
            this.b = new com.baidu.tieba.util.at(com.baidu.tieba.data.h.a + "c/u/user/profile");
            this.b.a("uid", this.a.b());
            String l = this.b.l();
            if (this.b.c()) {
                context2 = this.a.e;
                this.c = new ae(context2);
                this.c.c(l);
                if (this.c.a() != null) {
                    DatabaseService.h(l);
                    AccountData F = TiebaApplication.F();
                    if (F == null) {
                        return null;
                    }
                    if (!TextUtils.isEmpty(this.c.a().getPortrait())) {
                        DatabaseService.c(F.getAccount(), this.c.a().getPortrait());
                        F.setPortrait(this.c.a().getPortrait());
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
    public void b(ae... aeVarArr) {
        com.baidu.adp.a.g gVar;
        boolean z = false;
        super.b((Object[]) aeVarArr);
        ae aeVar = aeVarArr[0];
        if (aeVar != null) {
            this.a.a(aeVar.a());
            z = true;
        }
        this.a.mLoadDataMode = 2;
        this.a.setErrorString(null);
        gVar = this.a.mLoadDataCallBack;
        gVar.a(Boolean.valueOf(z));
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        super.cancel();
        this.d = true;
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        this.a.b = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ae aeVar) {
        Context context;
        com.baidu.adp.a.g gVar;
        com.baidu.tieba.util.i iVar;
        com.baidu.adp.a.g gVar2;
        super.a((ag) aeVar);
        this.a.b = null;
        this.a.mLoadDataMode = 1;
        if (aeVar != null) {
            this.a.k = true;
            this.a.a(aeVar.a());
            iVar = this.a.f;
            iVar.e(aeVar.a().getPortrait());
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(true);
            return;
        }
        this.a.k = false;
        if (this.b != null && this.e) {
            this.a.setErrorString(this.b.i());
        } else {
            ae aeVar2 = this.a;
            context = this.a.e;
            aeVar2.setErrorString(context.getString(R.string.neterror));
        }
        gVar = this.a.mLoadDataCallBack;
        gVar.a(false);
    }
}
