package com.baidu.tieba.person;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends BdAsyncTask<Boolean, t, t> {
    final /* synthetic */ t a;
    private com.baidu.tbadk.core.util.ak b;
    private t c;
    private volatile boolean d;
    private boolean e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(t tVar) {
        Context context;
        com.baidu.adp.a.h hVar;
        com.baidu.adp.a.h hVar2;
        com.baidu.tbadk.editortool.aa unused;
        t tVar2 = tVar;
        super.a((u) tVar2);
        this.a.b = null;
        this.a.mLoadDataMode = 1;
        if (tVar2 != null) {
            this.a.k = true;
            this.a.a(tVar2.a());
            unused = this.a.f;
            com.baidu.tbadk.imageManager.e.a().a(tVar2.a().getPortrait());
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(true);
            return;
        }
        this.a.k = false;
        if (this.b == null || !this.e) {
            t tVar3 = this.a;
            context = this.a.e;
            tVar3.setErrorString(context.getString(com.baidu.tieba.a.k.neterror));
        } else {
            this.a.setErrorString(this.b.f());
        }
        hVar = this.a.mLoadDataCallBack;
        hVar.a(false);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(t... tVarArr) {
        com.baidu.adp.a.h hVar;
        boolean z = false;
        t[] tVarArr2 = tVarArr;
        super.b((Object[]) tVarArr2);
        t tVar = tVarArr2[0];
        if (tVar != null) {
            this.a.a(tVar.a());
            z = true;
        }
        this.a.mLoadDataMode = 2;
        this.a.setErrorString(null);
        hVar = this.a.mLoadDataCallBack;
        hVar.a(Boolean.valueOf(z));
    }

    private u(t tVar) {
        this.a = tVar;
        this.c = null;
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(t tVar, byte b) {
        this(tVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public t a(Boolean... boolArr) {
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
                    c((Object[]) new t[]{this.c});
                    this.e = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            }
        }
        if (!this.d && this.a.b() != null) {
            this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/u/user/profile");
            this.b.a("uid", this.a.b());
            this.b.a("has_plist", "0");
            String i = this.b.i();
            if (this.b.a().b().b()) {
                context2 = this.a.e;
                this.c = new t(context2);
                this.c.c(i);
                if (this.c.a() != null) {
                    com.baidu.tieba.util.k.c(i);
                    AccountData N = TbadkApplication.N();
                    if (N == null) {
                        return null;
                    }
                    if (!TextUtils.isEmpty(this.c.a().getPortrait())) {
                        com.baidu.tbadk.core.a.o.a(N.getAccount(), this.c.a().getPortrait());
                        N.setPortrait(this.c.a().getPortrait());
                    }
                }
            }
        }
        return this.c;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.h hVar;
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
}
