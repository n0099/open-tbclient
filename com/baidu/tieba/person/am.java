package com.baidu.tieba.person;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends BdAsyncTask<Boolean, al, al> {
    final /* synthetic */ al a;
    private com.baidu.tieba.util.ba b;
    private al c;
    private volatile boolean d;
    private boolean e;

    private am(al alVar) {
        this.a = alVar;
        this.c = null;
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ am(al alVar, am amVar) {
        this(alVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public al a(Boolean... boolArr) {
        Context context;
        Context context2;
        boolean booleanValue = boolArr[0].booleanValue();
        this.e = boolArr[1].booleanValue();
        if (booleanValue) {
            try {
                String c = DatabaseService.c();
                if (c != null) {
                    context = this.a.e;
                    this.c = new al(context);
                    this.c.c(c);
                    c((Object[]) new al[]{this.c});
                    this.e = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            }
        }
        if (!this.d && this.a.b() != null) {
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/u/user/profile");
            this.b.a(SapiAccountManager.SESSION_UID, this.a.b());
            String m = this.b.m();
            if (this.b.d()) {
                context2 = this.a.e;
                this.c = new al(context2);
                this.c.c(m);
                if (this.c.a() != null) {
                    DatabaseService.e(m);
                    AccountData E = TiebaApplication.E();
                    if (E == null) {
                        return null;
                    }
                    if (!TextUtils.isEmpty(this.c.a().getPortrait())) {
                        DatabaseService.a(E.getAccount(), this.c.a().getPortrait());
                        E.setPortrait(this.c.a().getPortrait());
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
    public void b(al... alVarArr) {
        com.baidu.adp.a.g gVar;
        boolean z = false;
        super.b((Object[]) alVarArr);
        al alVar = alVarArr[0];
        if (alVar != null) {
            this.a.a(alVar.a());
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
            this.b.k();
            this.b = null;
        }
        this.a.b = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(al alVar) {
        Context context;
        com.baidu.adp.a.g gVar;
        com.baidu.tieba.util.i iVar;
        com.baidu.adp.a.g gVar2;
        super.a((am) alVar);
        this.a.b = null;
        this.a.mLoadDataMode = 1;
        if (alVar != null) {
            this.a.k = true;
            this.a.a(alVar.a());
            iVar = this.a.f;
            iVar.e(alVar.a().getPortrait());
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(true);
            return;
        }
        this.a.k = false;
        if (this.b != null && this.e) {
            this.a.setErrorString(this.b.j());
        } else {
            al alVar2 = this.a;
            context = this.a.e;
            alVar2.setErrorString(context.getString(R.string.neterror));
        }
        gVar = this.a.mLoadDataCallBack;
        gVar.a(false);
    }
}
