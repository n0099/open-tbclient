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
    final /* synthetic */ bx f1908a;
    private com.baidu.tieba.util.ap b;
    private volatile boolean c;
    private boolean d;

    private ca(bx bxVar) {
        this.f1908a = bxVar;
        this.b = null;
        this.c = false;
        this.d = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bx a(Boolean... boolArr) {
        Exception e;
        bx bxVar;
        bx bxVar2;
        Context context;
        String e2;
        Context context2;
        boolean booleanValue = boolArr[0].booleanValue();
        this.d = boolArr[1].booleanValue();
        try {
            if (this.f1908a.c() && booleanValue && (e2 = DatabaseService.e()) != null) {
                context2 = this.f1908a.p;
                bxVar2 = new bx(context2);
                try {
                    bxVar2.b(e2);
                    c((Object[]) new bx[]{bxVar2});
                    this.d = false;
                } catch (Exception e3) {
                    bxVar = bxVar2;
                    e = e3;
                    com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
                    return bxVar;
                }
            } else {
                bxVar2 = null;
            }
            if (!this.c && this.f1908a.b() != null) {
                this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/u/user/profile");
                this.b.a("uid", this.f1908a.b());
                this.b.a("need_post_count", SocialConstants.TRUE);
                String j = this.b.j();
                if (this.b.c()) {
                    context = this.f1908a.p;
                    bxVar = new bx(context);
                    try {
                        bxVar.b(j);
                        if (this.f1908a.c()) {
                            DatabaseService.j(j);
                            AccountData E = TiebaApplication.E();
                            if (E == null) {
                                return null;
                            }
                            if (bxVar.d() != null && !TextUtils.isEmpty(bxVar.d().getPortrait())) {
                                DatabaseService.c(E.getAccount(), bxVar.d().getPortrait());
                                E.setPortrait(bxVar.d().getPortrait());
                                return bxVar;
                            }
                            return bxVar;
                        }
                        return bxVar;
                    } catch (Exception e4) {
                        e = e4;
                        com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
                        return bxVar;
                    }
                }
            }
            return bxVar2;
        } catch (Exception e5) {
            e = e5;
            bxVar = null;
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
            this.f1908a.a(bxVar.d());
            this.f1908a.a(bxVar.a());
            z = true;
        }
        this.f1908a.mLoadDataMode = 2;
        this.f1908a.setErrorString(null);
        gVar = this.f1908a.mLoadDataCallBack;
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
        this.f1908a.n = null;
        if (bxVar != null) {
            this.f1908a.a(bxVar.d());
            this.f1908a.a(bxVar.a());
            this.f1908a.f().e(bxVar.d().getPortrait());
            this.f1908a.mLoadDataMode = 1;
            gVar2 = this.f1908a.mLoadDataCallBack;
            gVar2.a(true);
            return;
        }
        if (this.b != null && this.d) {
            this.f1908a.setErrorString(this.b.g());
        } else {
            bx bxVar2 = this.f1908a;
            context = this.f1908a.p;
            bxVar2.setErrorString(context.getString(R.string.neterror));
        }
        this.f1908a.mLoadDataMode = 1;
        gVar = this.f1908a.mLoadDataCallBack;
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
        this.f1908a.n = null;
        gVar = this.f1908a.mLoadDataCallBack;
        gVar.a(false);
    }
}
