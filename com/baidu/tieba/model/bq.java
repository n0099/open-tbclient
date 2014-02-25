package com.baidu.tieba.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.gson.Gson;
import com.baidu.gson.GsonBuilder;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.person.PersonPostListData;
import com.baidu.tieba.person.cx;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends BdAsyncTask<Boolean, bp, bp> {
    final /* synthetic */ bp a;
    private com.baidu.tieba.util.ba b;
    private volatile boolean c;
    private boolean d;

    private bq(bp bpVar) {
        this.a = bpVar;
        this.b = null;
        this.c = false;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bq(bp bpVar, bq bqVar) {
        this(bpVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bp a(Boolean... boolArr) {
        bp bpVar;
        int i;
        Context context;
        String c;
        Context context2;
        boolean booleanValue = boolArr[0].booleanValue();
        this.d = boolArr[1].booleanValue();
        try {
            if (this.a.e() && booleanValue && (c = DatabaseService.c()) != null) {
                context2 = this.a.s;
                bpVar = new bp(context2);
                bpVar.b(c);
                a(c);
                c((Object[]) new bp[]{bpVar});
                this.d = false;
            } else {
                bpVar = null;
            }
            if (!this.c && this.a.d() != null) {
                this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/u/user/profile");
                this.b.a(SapiAccountManager.SESSION_UID, this.a.d());
                this.b.a("need_post_count", SocialConstants.TRUE);
                com.baidu.tieba.util.ba baVar = this.b;
                StringBuilder sb = new StringBuilder();
                i = this.a.m;
                baVar.a("pn", sb.append(i).toString());
                this.b.a("rn", "20");
                if (this.a.e()) {
                    this.b.a("is_owner", SocialConstants.TRUE);
                } else {
                    this.b.a("is_owner", SocialConstants.FALSE);
                }
                String m = this.b.m();
                if (this.b.d()) {
                    context = this.a.s;
                    bp bpVar2 = new bp(context);
                    bpVar2.b(m);
                    a(m);
                    if (this.a.e() && booleanValue) {
                        DatabaseService.e(m);
                        AccountData E = TiebaApplication.E();
                        if (E == null) {
                            return null;
                        }
                        if (bpVar2.f() != null && !TextUtils.isEmpty(bpVar2.f().getPortrait())) {
                            DatabaseService.a(E.getAccount(), bpVar2.f().getPortrait());
                            E.setPortrait(bpVar2.f().getPortrait());
                            return bpVar2;
                        }
                        return bpVar2;
                    }
                    return bpVar2;
                }
                return null;
            }
            return bpVar;
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(bp... bpVarArr) {
        com.baidu.adp.a.g gVar;
        boolean z = false;
        super.b((Object[]) bpVarArr);
        bp bpVar = bpVarArr[0];
        if (bpVar != null) {
            this.a.a(bpVar.f());
            this.a.a(bpVar.c());
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
    public void a(bp bpVar) {
        com.baidu.adp.a.g gVar;
        Context context;
        com.baidu.adp.a.g gVar2;
        cx cxVar;
        com.baidu.adp.a.g gVar3;
        super.a((bq) bpVar);
        this.a.q = null;
        bp bpVar2 = this.a;
        gVar = this.a.mLoadDataCallBack;
        bpVar2.r = new d(gVar);
        if (bpVar != null) {
            this.a.a(bpVar.f());
            this.a.a(bpVar.c());
            this.a.h().e(bpVar.f().getPortrait());
            this.a.mLoadDataMode = 1;
            gVar3 = this.a.mLoadDataCallBack;
            gVar3.a(true);
        } else {
            if (this.b != null && this.d) {
                this.a.setErrorString(this.b.j());
            } else {
                bp bpVar3 = this.a;
                context = this.a.s;
                bpVar3.setErrorString(context.getString(R.string.neterror));
            }
            this.a.mLoadDataMode = 1;
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(false);
        }
        cxVar = this.a.t;
        cxVar.a();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.k();
            this.b = null;
        }
        this.a.q = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(false);
    }
}
