package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.gson.JsonParseException;
import com.baidu.tbadk.core.util.ak;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class g extends BdAsyncTask<Void, Void, PersonPostReplyModel> {
    private WeakReference<f> a;
    private boolean b;
    private ak c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ PersonPostReplyModel a(Void... voidArr) {
        return a();
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

    private PersonPostReplyModel a() {
        PersonPostReplyModel personPostReplyModel;
        this.c = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/u/feed/userpost");
        this.c.a("uid", String.valueOf(PersonPostReplyModel.mLastReplyUid));
        this.c.a("pn", String.valueOf(PersonPostReplyModel.mReplyPn));
        this.c.a("rn", String.valueOf(20));
        this.c.a("is_thread", String.valueOf(0));
        this.c.a("need_content", String.valueOf(1));
        String i = this.c.i();
        com.baidu.adp.lib.util.f.e("PersonPostReplyModel", "doInBackground", i);
        try {
            personPostReplyModel = (PersonPostReplyModel) new GsonBuilder().create().fromJson(i, (Class<Object>) PersonPostReplyModel.class);
        } catch (JsonParseException e) {
            com.baidu.adp.lib.util.f.e("PersonPostReplyModel", "doInBackground", e.getMessage());
            personPostReplyModel = null;
        }
        if (personPostReplyModel == null) {
            personPostReplyModel = new PersonPostReplyModel();
        }
        personPostReplyModel.setErrorCode(this.c.d());
        personPostReplyModel.setErrorString(this.c.f());
        return personPostReplyModel;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel();
        if (this.c != null) {
            this.c.g();
        }
        PersonPostReplyModel.sFetchReplyAsyncTask = null;
    }
}
