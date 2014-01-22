package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.gson.JsonParseException;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.util.ax;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Void, Void, PersonPostReplyModel> {
    private WeakReference<e> a;
    private boolean b;
    private ax c;

    public f(e eVar, boolean z) {
        this.a = new WeakReference<>(eVar);
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public PersonPostReplyModel a(Void... voidArr) {
        PersonPostReplyModel personPostReplyModel;
        this.c = new ax(com.baidu.tieba.data.h.a + "c/u/feed/userpost");
        this.c.a(SapiAccountManager.SESSION_UID, String.valueOf(PersonPostReplyModel.mLastReplyUid));
        this.c.a("pn", String.valueOf(PersonPostReplyModel.mReplyPn));
        this.c.a("rn", String.valueOf(20));
        this.c.a("is_thread", String.valueOf(0));
        this.c.a("need_content", String.valueOf(1));
        String m = this.c.m();
        com.baidu.adp.lib.g.e.e("PersonPostReplyModel", "doInBackground", m);
        try {
            personPostReplyModel = (PersonPostReplyModel) new GsonBuilder().create().fromJson(m, (Class<Object>) PersonPostReplyModel.class);
        } catch (JsonParseException e) {
            com.baidu.adp.lib.g.e.e("PersonPostReplyModel", "doInBackground", e.getMessage());
            personPostReplyModel = null;
        }
        if (personPostReplyModel == null) {
            personPostReplyModel = new PersonPostReplyModel();
        }
        personPostReplyModel.setErrorCode(this.c.f());
        personPostReplyModel.setErrorString(this.c.j());
        return personPostReplyModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(PersonPostReplyModel personPostReplyModel) {
        e eVar = this.a.get();
        if (eVar != null) {
            eVar.a(personPostReplyModel, this.b);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.c != null) {
            this.c.k();
        }
        PersonPostReplyModel.sFetchReplyAsyncTask = null;
    }
}
