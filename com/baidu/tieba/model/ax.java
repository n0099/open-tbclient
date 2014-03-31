package com.baidu.tieba.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.Gson;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.person.PersonPostListData;
import com.baidu.tieba.person.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ax extends BdAsyncTask<Boolean, av, av> {
    final /* synthetic */ av a;
    private com.baidu.tbadk.core.util.ak b = null;
    private volatile boolean c = false;
    private boolean d = false;
    private av e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(av avVar) {
        com.baidu.adp.a.h hVar;
        Context context;
        com.baidu.adp.a.h hVar2;
        bx bxVar;
        com.baidu.adp.a.h hVar3;
        av avVar2 = avVar;
        super.a((ax) avVar2);
        this.a.q = null;
        av avVar3 = this.a;
        hVar = this.a.mLoadDataCallBack;
        avVar3.r = new com.baidu.tbadk.coreExtra.b.a(hVar);
        if (avVar2 != null) {
            this.a.a(avVar2.g());
            this.a.a(avVar2.d());
            this.a.i();
            com.baidu.tbadk.imageManager.e.a().a(avVar2.g().getPortrait());
            this.a.mLoadDataMode = 1;
            hVar3 = this.a.mLoadDataCallBack;
            hVar3.a(true);
        } else {
            if (this.b == null || !this.d) {
                av avVar4 = this.a;
                context = this.a.s;
                avVar4.setErrorString(context.getString(com.baidu.tieba.a.k.neterror));
            } else {
                this.a.setErrorString(this.b.f());
            }
            this.a.mLoadDataMode = 1;
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(false);
        }
        bxVar = this.a.t;
        bxVar.a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(av... avVarArr) {
        com.baidu.adp.a.h hVar;
        boolean z = false;
        av[] avVarArr2 = avVarArr;
        super.b((Object[]) avVarArr2);
        av avVar = avVarArr2[0];
        if (avVar != null) {
            this.a.a(avVar.g());
            this.a.a(avVar.d());
            z = true;
        }
        this.a.mLoadDataMode = 2;
        this.a.setErrorString(null);
        hVar = this.a.mLoadDataCallBack;
        hVar.a(Boolean.valueOf(z));
    }

    public ax(av avVar) {
        Context context;
        this.a = avVar;
        context = avVar.s;
        this.e = new av(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public av a(Boolean... boolArr) {
        int i;
        String b;
        boolean booleanValue = boolArr[0].booleanValue();
        this.d = boolArr[1].booleanValue();
        try {
            if (this.a.f() && booleanValue && (b = com.baidu.tieba.util.k.b()) != null) {
                this.e.b(b);
                a(b);
                c((Object[]) new av[]{this.e});
                this.d = false;
            }
            if (!this.c && this.a.e() != null) {
                this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/u/user/profile");
                this.b.a("uid", this.a.e());
                this.b.a("need_post_count", "1");
                com.baidu.tbadk.core.util.ak akVar = this.b;
                StringBuilder sb = new StringBuilder();
                i = this.a.m;
                akVar.a("pn", sb.append(i).toString());
                this.b.a("rn", "20");
                this.b.a("has_plist", "1");
                if (this.a.f()) {
                    this.b.a("is_owner", "1");
                } else {
                    this.b.a("is_owner", "0");
                }
                String i2 = this.b.i();
                if (!this.b.a().b().b()) {
                    return null;
                }
                this.e.b(i2);
                a(i2);
                if (this.a.f() && booleanValue) {
                    com.baidu.tieba.util.k.c(i2);
                    AccountData N = TbadkApplication.N();
                    if (N == null) {
                        return null;
                    }
                    if (this.e.g() != null && !TextUtils.isEmpty(this.e.g().getPortrait())) {
                        com.baidu.tbadk.core.a.o.a(N.getAccount(), this.e.g().getPortrait());
                        N.setPortrait(this.e.g().getPortrait());
                    }
                }
            }
            return this.e;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    private void a(String str) {
        PersonPostListData personPostListData;
        PersonPostListData personPostListData2;
        int i;
        PersonPostListData personPostListData3;
        PersonPostListData personPostListData4;
        PersonPostListData personPostListData5;
        Gson create = new GsonBuilder().create();
        new PersonPostListData();
        PersonPostListData personPostListData6 = (PersonPostListData) create.fromJson(str, (Class<Object>) PersonPostListData.class);
        if (personPostListData6 == null || personPostListData6.post_list.size() <= 0) {
            personPostListData = this.a.l;
            if (personPostListData != null) {
                personPostListData2 = this.a.l;
                if (personPostListData2.post_list.size() > 0) {
                    this.a.a(true);
                    return;
                }
            }
            this.a.a(false);
            return;
        }
        i = this.a.m;
        if (i == 1) {
            personPostListData5 = this.a.l;
            if (personPostListData5 == null) {
                this.a.l = new PersonPostListData();
            }
            this.a.l = personPostListData6;
            return;
        }
        personPostListData3 = this.a.l;
        if (personPostListData3 != null) {
            personPostListData4 = this.a.l;
            personPostListData4.post_list.addAll(personPostListData6.post_list);
            return;
        }
        this.a.l = new PersonPostListData();
        this.a.l = personPostListData6;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.h hVar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.q = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(false);
    }
}
