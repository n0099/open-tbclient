package com.baidu.tieba.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends BdAsyncTask<Boolean, bx, bx> {
    final /* synthetic */ bx a;
    private com.baidu.tieba.util.an b;
    private volatile boolean c;
    private boolean d;

    private bz(bx bxVar) {
        this.a = bxVar;
        this.b = null;
        this.c = false;
        this.d = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bx a(Boolean... boolArr) {
        bx bxVar;
        Context context;
        String e;
        Context context2;
        boolean booleanValue = boolArr[0].booleanValue();
        this.d = boolArr[1].booleanValue();
        try {
            if (this.a.c() && booleanValue && (e = DatabaseService.e()) != null) {
                context2 = this.a.p;
                bxVar = new bx(context2);
                bxVar.b(e);
                c((Object[]) new bx[]{bxVar});
                this.d = false;
            } else {
                bxVar = null;
            }
            if (!this.c && this.a.b() != null) {
                this.b = new com.baidu.tieba.util.an(com.baidu.tieba.data.h.a + "c/u/user/profile");
                this.b.a("uid", this.a.b());
                this.b.a("need_post_count", SocialConstants.TRUE);
                String l = this.b.l();
                if (this.b.c()) {
                    context = this.a.p;
                    bx bxVar2 = new bx(context);
                    bxVar2.b(l);
                    if (this.a.c()) {
                        DatabaseService.h(l);
                        AccountData F = TiebaApplication.F();
                        if (F == null) {
                            return null;
                        }
                        if (bxVar2.d() != null && !TextUtils.isEmpty(bxVar2.d().getPortrait())) {
                            DatabaseService.c(F.getAccount(), bxVar2.d().getPortrait());
                            F.setPortrait(bxVar2.d().getPortrait());
                            return bxVar2;
                        }
                        return bxVar2;
                    }
                    return bxVar2;
                }
                return null;
            }
            return bxVar;
        } catch (Exception e2) {
            com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e2.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(bx... bxVarArr) {
        com.baidu.adp.a.g gVar;
        boolean z = false;
        super.b((Object[]) bxVarArr);
        bx bxVar = bxVarArr[0];
        if (bxVar != null) {
            this.a.a(bxVar.d());
            this.a.a(bxVar.a());
            z = true;
        }
        this.a.mLoadDataMode = 2;
        this.a.setErrorString(null);
        gVar = this.a.mLoadDataCallBack;
        gVar.a(Boolean.valueOf(z));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bx bxVar) {
        com.baidu.adp.a.g gVar;
        Context context;
        com.baidu.adp.a.g gVar2;
        com.baidu.adp.a.g gVar3;
        super.a((bz) bxVar);
        this.a.n = null;
        bx bxVar2 = this.a;
        gVar = this.a.mLoadDataCallBack;
        bxVar2.o = new e(gVar);
        if (bxVar != null) {
            this.a.a(bxVar.d());
            this.a.a(bxVar.a());
            this.a.f().e(bxVar.d().getPortrait());
            this.a.mLoadDataMode = 1;
            gVar3 = this.a.mLoadDataCallBack;
            gVar3.a(true);
            return;
        }
        if (this.b != null && this.d) {
            this.a.setErrorString(this.b.i());
        } else {
            bx bxVar3 = this.a;
            context = this.a.p;
            bxVar3.setErrorString(context.getString(R.string.neterror));
        }
        this.a.mLoadDataMode = 1;
        gVar2 = this.a.mLoadDataCallBack;
        gVar2.a(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        this.a.n = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(false);
    }
}
