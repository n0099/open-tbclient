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
import com.baidu.tieba.person.di;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask<Boolean, av, av> {
    final /* synthetic */ av a;
    private com.baidu.tbadk.core.util.ae b = null;
    private volatile boolean c = false;
    private boolean d = false;
    private av e;

    public ax(av avVar) {
        Context context;
        this.a = avVar;
        context = avVar.v;
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
            if (this.a.j() && booleanValue && (b = com.baidu.tieba.util.k.b()) != null) {
                this.e.c(b);
                a(b);
                publishProgress(this.e);
                this.d = false;
            }
            if (!this.c && this.a.i() != null) {
                this.b = new com.baidu.tbadk.core.util.ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/user/profile");
                this.b.a(SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount());
                this.b.a("need_post_count", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                com.baidu.tbadk.core.util.ae aeVar = this.b;
                StringBuilder sb = new StringBuilder();
                i = this.a.q;
                aeVar.a("pn", sb.append(i).toString());
                this.b.a("rn", "20");
                this.b.a("has_plist", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                if (!this.a.j()) {
                    this.b.a("friend_uid", this.a.i());
                    this.b.a("is_guest", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                }
                this.b.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.a.r());
                String h = this.b.h();
                if (!this.b.a().b().b()) {
                    return null;
                }
                this.e.c(h);
                a(h);
                if (this.a.j() && booleanValue) {
                    com.baidu.tieba.util.k.c(h);
                    AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                    if (currentAccountObj == null) {
                        return null;
                    }
                    if (this.e.k() != null && !TextUtils.isEmpty(this.e.k().getPortrait())) {
                        com.baidu.tbadk.core.account.a.a(currentAccountObj.getAccount(), this.e.k().getPortrait());
                        currentAccountObj.setPortrait(this.e.k().getPortrait());
                    }
                }
            }
            return this.e;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private void a(String str) {
        int i;
        PersonPostListData personPostListData;
        PersonPostListData personPostListData2;
        int i2;
        PersonPostListData personPostListData3;
        PersonPostListData personPostListData4;
        PersonPostListData personPostListData5;
        Gson create = new GsonBuilder().create();
        new PersonPostListData();
        PersonPostListData personPostListData6 = (PersonPostListData) create.fromJson(str, (Class<Object>) PersonPostListData.class);
        if (personPostListData6 == null || personPostListData6.post_list.size() <= 0) {
            i = this.a.q;
            if (i == 1) {
                this.a.o = personPostListData6;
            }
            personPostListData = this.a.o;
            if (personPostListData != null) {
                personPostListData2 = this.a.o;
                if (personPostListData2.post_list.size() > 0) {
                    this.a.a(true);
                    return;
                }
            }
            this.a.a(false);
            return;
        }
        i2 = this.a.q;
        if (i2 == 1) {
            personPostListData5 = this.a.o;
            if (personPostListData5 == null) {
                this.a.o = new PersonPostListData();
            }
            this.a.o = personPostListData6;
            return;
        }
        personPostListData3 = this.a.o;
        if (personPostListData3 != null) {
            personPostListData4 = this.a.o;
            personPostListData4.post_list.addAll(personPostListData6.post_list);
            return;
        }
        this.a.o = new PersonPostListData();
        this.a.o = personPostListData6;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(av... avVarArr) {
        com.baidu.adp.base.h hVar;
        boolean z = false;
        super.onProgressUpdate(avVarArr);
        av avVar = avVarArr[0];
        if (avVar != null) {
            UserData k = avVar.k();
            if (k != null) {
                this.a.a(k);
            }
            AntiData h = avVar.h();
            if (h != null) {
                this.a.a(h);
            }
            this.a.a(avVar.a());
            z = true;
        }
        this.a.mLoadDataMode = 2;
        this.a.setErrorString(null);
        hVar = this.a.mLoadDataCallBack;
        hVar.a(Boolean.valueOf(z));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(av avVar) {
        com.baidu.adp.base.h hVar;
        Context context;
        com.baidu.adp.base.h hVar2;
        di diVar;
        di diVar2;
        com.baidu.adp.base.h hVar3;
        super.onPostExecute(avVar);
        this.a.t = null;
        av avVar2 = this.a;
        hVar = this.a.mLoadDataCallBack;
        avVar2.u = new com.baidu.tbadk.coreExtra.b.a(hVar);
        if (avVar != null) {
            UserData k = avVar.k();
            if (k != null) {
                this.a.a(k);
            }
            AntiData h = avVar.h();
            if (h != null) {
                this.a.a(h);
            }
            this.a.a(avVar.a());
            this.a.mLoadDataMode = 1;
            hVar3 = this.a.mLoadDataCallBack;
            hVar3.a(true);
        } else {
            if (this.b != null && this.d) {
                this.a.setErrorString(this.b.e());
            } else {
                av avVar3 = this.a;
                context = this.a.v;
                avVar3.setErrorString(context.getString(com.baidu.tieba.x.neterror));
            }
            this.a.mLoadDataMode = 1;
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(false);
        }
        diVar = this.a.w;
        if (diVar != null) {
            diVar2 = this.a.w;
            diVar2.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.f();
            this.b = null;
        }
        this.a.t = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(false);
    }
}
