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
import com.baidu.tieba.person.dd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask<Boolean, au, au> {
    final /* synthetic */ au a;
    private com.baidu.tbadk.core.util.aq b = null;
    private volatile boolean c = false;
    private boolean d = false;
    private au e;

    public aw(au auVar) {
        Context context;
        this.a = auVar;
        context = auVar.v;
        this.e = new au(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public au doInBackground(Boolean... boolArr) {
        int i;
        String b;
        boolean booleanValue = boolArr[0].booleanValue();
        this.d = boolArr[1].booleanValue();
        try {
            if (this.a.i() && booleanValue && (b = com.baidu.tieba.util.k.b()) != null) {
                this.e.b(b);
                a(b);
                publishProgress(this.e);
                this.d = false;
            }
            if (!this.c && this.a.h() != null) {
                this.b = new com.baidu.tbadk.core.util.aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/user/profile");
                this.b.a(SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount());
                this.b.a("need_post_count", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                com.baidu.tbadk.core.util.aq aqVar = this.b;
                StringBuilder sb = new StringBuilder();
                i = this.a.p;
                aqVar.a("pn", sb.append(i).toString());
                this.b.a("rn", "20");
                this.b.a("has_plist", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                if (!this.a.i()) {
                    this.b.a("friend_uid", this.a.h());
                    this.b.a("is_guest", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                }
                this.b.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.a.q());
                String i2 = this.b.i();
                if (!this.b.a().b().b()) {
                    return null;
                }
                this.e.b(i2);
                a(i2);
                if (this.a.i() && booleanValue) {
                    com.baidu.tieba.util.k.c(i2);
                    AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                    if (currentAccountObj == null) {
                        return null;
                    }
                    if (this.e.j() != null && !TextUtils.isEmpty(this.e.j().getPortrait())) {
                        com.baidu.tbadk.core.account.a.a(currentAccountObj.getAccount(), this.e.j().getPortrait());
                        currentAccountObj.setPortrait(this.e.j().getPortrait());
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
            i = this.a.p;
            if (i == 1) {
                this.a.n = personPostListData6;
            }
            personPostListData = this.a.n;
            if (personPostListData != null) {
                personPostListData2 = this.a.n;
                if (personPostListData2.post_list.size() > 0) {
                    this.a.a(true);
                    return;
                }
            }
            this.a.a(false);
            return;
        }
        i2 = this.a.p;
        if (i2 == 1) {
            personPostListData5 = this.a.n;
            if (personPostListData5 == null) {
                this.a.n = new PersonPostListData();
            }
            this.a.n = personPostListData6;
            return;
        }
        personPostListData3 = this.a.n;
        if (personPostListData3 != null) {
            personPostListData4 = this.a.n;
            personPostListData4.post_list.addAll(personPostListData6.post_list);
            return;
        }
        this.a.n = new PersonPostListData();
        this.a.n = personPostListData6;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(au... auVarArr) {
        com.baidu.adp.base.h hVar;
        boolean z = false;
        super.onProgressUpdate(auVarArr);
        au auVar = auVarArr[0];
        if (auVar != null) {
            this.a.a(auVar.j());
            this.a.a(auVar.g());
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
    public void onPostExecute(au auVar) {
        com.baidu.adp.base.h hVar;
        Context context;
        com.baidu.adp.base.h hVar2;
        dd ddVar;
        dd ddVar2;
        com.baidu.adp.base.h hVar3;
        super.onPostExecute(auVar);
        this.a.t = null;
        au auVar2 = this.a;
        hVar = this.a.mLoadDataCallBack;
        auVar2.u = new com.baidu.tbadk.coreExtra.b.a(hVar);
        if (auVar != null) {
            UserData j = auVar.j();
            if (j != null) {
                this.a.a(j);
            }
            AntiData g = auVar.g();
            if (g != null) {
                this.a.a(g);
            }
            this.a.a(auVar.a());
            this.a.mLoadDataMode = 1;
            hVar3 = this.a.mLoadDataCallBack;
            hVar3.a(true);
        } else {
            if (this.b != null && this.d) {
                this.a.setErrorString(this.b.f());
            } else {
                au auVar3 = this.a;
                context = this.a.v;
                auVar3.setErrorString(context.getString(com.baidu.tieba.y.neterror));
            }
            this.a.mLoadDataMode = 1;
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(false);
        }
        ddVar = this.a.w;
        if (ddVar != null) {
            ddVar2 = this.a.w;
            ddVar2.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.t = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(false);
    }
}
