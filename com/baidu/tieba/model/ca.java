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
public class ca extends BdAsyncTask<Boolean, bx, bx> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bx f2021a;
    private com.baidu.tieba.util.am b;
    private volatile boolean c;
    private boolean d;

    private ca(bx bxVar) {
        this.f2021a = bxVar;
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
            if (this.f2021a.c() && booleanValue && (e = DatabaseService.e()) != null) {
                context2 = this.f2021a.p;
                bxVar = new bx(context2);
                bxVar.b(e);
                c((Object[]) new bx[]{bxVar});
                this.d = false;
            } else {
                bxVar = null;
            }
            if (!this.c && this.f2021a.b() != null) {
                this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/u/user/profile");
                this.b.a("uid", this.f2021a.b());
                this.b.a("need_post_count", SocialConstants.TRUE);
                String l = this.b.l();
                if (this.b.c()) {
                    context = this.f2021a.p;
                    bx bxVar2 = new bx(context);
                    bxVar2.b(l);
                    if (this.f2021a.c()) {
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
            com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e2.getMessage());
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
            this.f2021a.a(bxVar.d());
            this.f2021a.a(bxVar.a());
            z = true;
        }
        this.f2021a.mLoadDataMode = 2;
        this.f2021a.setErrorString(null);
        gVar = this.f2021a.mLoadDataCallBack;
        gVar.a(Boolean.valueOf(z));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bx bxVar) {
        Context context;
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((ca) bxVar);
        this.f2021a.n = null;
        if (bxVar != null) {
            this.f2021a.a(bxVar.d());
            this.f2021a.a(bxVar.a());
            this.f2021a.f().e(bxVar.d().getPortrait());
            this.f2021a.mLoadDataMode = 1;
            gVar2 = this.f2021a.mLoadDataCallBack;
            gVar2.a(true);
            return;
        }
        if (this.b != null && this.d) {
            this.f2021a.setErrorString(this.b.i());
        } else {
            bx bxVar2 = this.f2021a;
            context = this.f2021a.p;
            bxVar2.setErrorString(context.getString(R.string.neterror));
        }
        this.f2021a.mLoadDataMode = 1;
        gVar = this.f2021a.mLoadDataCallBack;
        gVar.a(false);
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
        this.f2021a.n = null;
        gVar = this.f2021a.mLoadDataCallBack;
        gVar.a(false);
    }
}
