package com.baidu.tieba.person;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class am extends BdAsyncTask<Boolean, al, al> {
    final /* synthetic */ al a;
    private com.baidu.tieba.util.ba b;
    private al c;
    private volatile boolean d;
    private boolean e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(al alVar) {
        Context context;
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        com.baidu.tieba.util.i unused;
        al alVar2 = alVar;
        super.a((am) alVar2);
        this.a.b = null;
        this.a.mLoadDataMode = 1;
        if (alVar2 != null) {
            this.a.k = true;
            this.a.a(alVar2.a());
            unused = this.a.f;
            com.baidu.tbadk.imageManager.e.a().a(alVar2.a().getPortrait());
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(true);
            return;
        }
        this.a.k = false;
        if (this.b == null || !this.e) {
            al alVar3 = this.a;
            context = this.a.e;
            alVar3.setErrorString(context.getString(R.string.neterror));
        } else {
            this.a.setErrorString(this.b.i());
        }
        gVar = this.a.mLoadDataCallBack;
        gVar.a(false);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(al... alVarArr) {
        com.baidu.adp.a.g gVar;
        boolean z = false;
        al[] alVarArr2 = alVarArr;
        super.b((Object[]) alVarArr2);
        al alVar = alVarArr2[0];
        if (alVar != null) {
            this.a.a(alVar.a());
            z = true;
        }
        this.a.mLoadDataMode = 2;
        this.a.setErrorString(null);
        gVar = this.a.mLoadDataCallBack;
        gVar.a(Boolean.valueOf(z));
    }

    private am(al alVar) {
        this.a = alVar;
        this.c = null;
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ am(al alVar, byte b) {
        this(alVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
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
                com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
            }
        }
        if (!this.d && this.a.b() != null) {
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/u/user/profile");
            this.b.a(SapiAccountManager.SESSION_UID, this.a.b());
            this.b.a("has_plist", SocialConstants.FALSE);
            String l = this.b.l();
            if (this.b.c()) {
                context2 = this.a.e;
                this.c = new al(context2);
                this.c.c(l);
                if (this.c.a() != null) {
                    DatabaseService.d(l);
                    AccountData y = TiebaApplication.y();
                    if (y == null) {
                        return null;
                    }
                    if (!TextUtils.isEmpty(this.c.a().getPortrait())) {
                        DatabaseService.a(y.getAccount(), this.c.a().getPortrait());
                        y.setPortrait(this.c.a().getPortrait());
                    }
                }
            }
        }
        return this.c;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
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
}
