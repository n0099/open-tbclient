package com.baidu.tieba.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.gson.GsonBuilder;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.person.PersonPostListData;
import com.baidu.tieba.person.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask<Boolean, av, av> {
    final /* synthetic */ av a;
    private com.baidu.tbadk.core.util.al b = null;
    private volatile boolean c = false;
    private boolean d = false;
    private av e;

    public ax(av avVar) {
        Context context;
        this.a = avVar;
        context = avVar.s;
        this.e = new av(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public av doInBackground(Boolean... boolArr) {
        int i;
        String b;
        boolean booleanValue = boolArr[0].booleanValue();
        this.d = boolArr[1].booleanValue();
        try {
            if (this.a.f() && booleanValue && (b = com.baidu.tieba.util.k.b()) != null) {
                this.e.b(b);
                a(b);
                publishProgress(this.e);
                this.d = false;
            }
            if (!this.c && this.a.e() != null) {
                this.b = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/user/profile");
                this.b.a(SapiAccountManager.SESSION_UID, this.a.e());
                this.b.a("need_post_count", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                com.baidu.tbadk.core.util.al alVar = this.b;
                StringBuilder sb = new StringBuilder();
                i = this.a.m;
                alVar.a("pn", sb.append(i).toString());
                this.b.a("rn", "20");
                this.b.a("has_plist", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                if (this.a.f()) {
                    this.b.a("is_owner", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
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
                    AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                    if (currentAccountObj == null) {
                        return null;
                    }
                    if (this.e.g() != null && !TextUtils.isEmpty(this.e.g().getPortrait())) {
                        com.baidu.tbadk.core.account.a.a(currentAccountObj.getAccount(), this.e.g().getPortrait());
                        currentAccountObj.setPortrait(this.e.g().getPortrait());
                    }
                }
            }
            return this.e;
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
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
    public void onProgressUpdate(av... avVarArr) {
        com.baidu.adp.base.g gVar;
        boolean z = false;
        super.onProgressUpdate(avVarArr);
        av avVar = avVarArr[0];
        if (avVar != null) {
            this.a.a(avVar.g());
            this.a.a(avVar.d());
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
    /* renamed from: a */
    public void onPostExecute(av avVar) {
        com.baidu.adp.base.g gVar;
        Context context;
        com.baidu.adp.base.g gVar2;
        by byVar;
        by byVar2;
        com.baidu.adp.base.g gVar3;
        super.onPostExecute(avVar);
        this.a.q = null;
        av avVar2 = this.a;
        gVar = this.a.mLoadDataCallBack;
        avVar2.r = new com.baidu.tbadk.coreExtra.b.a(gVar);
        if (avVar != null) {
            UserData g = avVar.g();
            if (g != null) {
                this.a.a(g);
            }
            AntiData d = avVar.d();
            if (d != null) {
                this.a.a(d);
            }
            this.a.mLoadDataMode = 1;
            gVar3 = this.a.mLoadDataCallBack;
            gVar3.a(true);
        } else {
            if (this.b != null && this.d) {
                this.a.setErrorString(this.b.f());
            } else {
                av avVar3 = this.a;
                context = this.a.s;
                avVar3.setErrorString(context.getString(com.baidu.tieba.u.neterror));
            }
            this.a.mLoadDataMode = 1;
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(false);
        }
        byVar = this.a.t;
        if (byVar != null) {
            byVar2 = this.a.t;
            byVar2.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.g gVar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.q = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(false);
    }
}
