package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.gson.JsonParseException;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.util.ba;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class g extends BdAsyncTask<Void, Void, PersonPostReplyModel> {
    private WeakReference<f> a;
    private boolean b;
    private ba c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ PersonPostReplyModel a(Void... voidArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(PersonPostReplyModel personPostReplyModel) {
        PersonPostReplyModel personPostReplyModel2 = personPostReplyModel;
        f fVar = this.a.get();
        if (fVar != null) {
            fVar.a(personPostReplyModel2, this.b);
        }
    }

    public g(f fVar, boolean z) {
        this.a = new WeakReference<>(fVar);
        this.b = z;
    }

    private PersonPostReplyModel d() {
        PersonPostReplyModel personPostReplyModel;
        this.c = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/u/feed/userpost");
        this.c.a(SapiAccountManager.SESSION_UID, String.valueOf(PersonPostReplyModel.mLastReplyUid));
        this.c.a("pn", String.valueOf(PersonPostReplyModel.mReplyPn));
        this.c.a("rn", String.valueOf(20));
        this.c.a("is_thread", String.valueOf(0));
        this.c.a("need_content", String.valueOf(1));
        String l = this.c.l();
        com.baidu.adp.lib.util.e.e("PersonPostReplyModel", "doInBackground", l);
        try {
            personPostReplyModel = (PersonPostReplyModel) new GsonBuilder().create().fromJson(l, (Class<Object>) PersonPostReplyModel.class);
        } catch (JsonParseException e) {
            com.baidu.adp.lib.util.e.e("PersonPostReplyModel", "doInBackground", e.getMessage());
            personPostReplyModel = null;
        }
        if (personPostReplyModel == null) {
            personPostReplyModel = new PersonPostReplyModel();
        }
        personPostReplyModel.setErrorCode(this.c.e());
        personPostReplyModel.setErrorString(this.c.i());
        return personPostReplyModel;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel();
        if (this.c != null) {
            this.c.j();
        }
        PersonPostReplyModel.sFetchReplyAsyncTask = null;
    }
}
